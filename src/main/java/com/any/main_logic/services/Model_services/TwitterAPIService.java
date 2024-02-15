package com.any.main_logic.services.Model_services;

import com.any.main_logic.repo.dataseed.DataSeedingInsertion;
import com.any.model.JWT_BL.models.Enums.*;
import com.any.model.JWT_BL.models.Tweet;
import com.any.model.JWT_BL.models.TweetOffensive;
import com.any.model.JWT_BL.models.TweetTopic;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class TwitterAPIService {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final HateModelService hateModelService;
    private final TopicModelService topicModelService;
    private final DataSeedingInsertion dataSeedingInsertion = new DataSeedingInsertion();

    public TwitterAPIService(HateModelService hateModelService,
                             TopicModelService topicModelService) {
        this.topicModelService = topicModelService;
        this.hateModelService = hateModelService;
        scheduler.scheduleAtFixedRate(this::withdrawAndClassifyTweets, 0, 5, TimeUnit.SECONDS);
    }

    private void withdrawAndClassifyTweets(){
        Tweet tweet = withdrawTweets();
        if(tweet == null){
            return;
        }
        TopicClass topicClass = topicModelService.ClassifyText(tweet.getText());
        OffensiveClass offensiveClass = hateModelService.ClassifyText(tweet.getText());
        dataSeedingInsertion.Tweet(tweet);
        dataSeedingInsertion.tweetOffensive(new TweetOffensive(0,tweet.getId(),offensiveClass));
        dataSeedingInsertion.tweetTopicObj(new TweetTopic(0,tweet.getId(),topicClass));
    }
    private Tweet withdrawTweets() {
        HttpClient client = HttpClient.newHttpClient();
        String topicEndpoint = "http://localhost:5000/predict/";
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
