package com.any.main_logic.services.Model_services;

import com.any.main_logic.repo.dataseed.DataSeedingInsertion;
import com.any.model.JWT_BL.models.Enums.*;
import com.any.model.JWT_BL.models.Tweet;
import com.any.model.JWT_BL.models.TweetOffensive;
import com.any.model.JWT_BL.models.TweetTopic;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
public class TwitterAPIService {
    private final HateModelService hateModelService = new HateModelService();
    private final TopicModelService topicModelService = new TopicModelService();
    private final DataSeedingInsertion dataSeedingInsertion = new DataSeedingInsertion();


    public void withdrawAndClassifyTweets(){
        Tweet tweet = withdrawTweets();
        if(tweet == null){
            return;
        }
        TopicClass topicClass = topicModelService.ClassifyText(tweet.getText());
        OffensiveClass offensiveClass = hateModelService.ClassifyText(tweet.getText());

        dataSeedingInsertion.Tweet(tweet);
        int tweetId = getNumberTweet();
        dataSeedingInsertion.tweetOffensive(new TweetOffensive(0,tweetId,offensiveClass));
        dataSeedingInsertion.tweetTopicObj(new TweetTopic(0,tweetId,topicClass));
    }

    public int getNumberTweet() {
        String fileName = "/Users/mohammad/IdeaProjects/tweet_scop/src/main/java/com/any/main_logic/services/Model_services/TweetIdSoFar";
        int number = readNumberFromFile(fileName);
        number++;
        updateNumberInFile(fileName, number);
        return (number - 1);
    }

    private int readNumberFromFile(String fileName) {
        int number = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            if (line != null) {
                number = Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
    }

    private void updateNumberInFile(String fileName, int number) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(String.valueOf(number));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Tweet withdrawTweets() {
        HttpClient client = HttpClient.newHttpClient();
        String topicEndpoint = "http://localhost:12321/tweet";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(topicEndpoint))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                Tweet tweet = getTweetFromRequestBody(response.body());
                return tweet;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Tweet getTweetFromRequestBody(String jsonBody) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Parse JSON string to JsonNode
            JsonNode jsonNode = objectMapper.readTree(jsonBody);

            // Extract values from JSON
            String text = jsonNode.get("text").asText();
            int countryId = jsonNode.get("countryId").asInt();
            String publishDate = jsonNode.get("publishDate").asText();

            // Create Tweet object
            Tweet tweet = new Tweet();
            tweet.setText(text);
            tweet.setCountryId(countryId);
            tweet.setPublishDate(LocalDateTime.parse(publishDate));

            return tweet;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
