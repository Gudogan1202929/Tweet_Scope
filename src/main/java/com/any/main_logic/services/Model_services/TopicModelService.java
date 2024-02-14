package com.any.main_logic.services.Model_services;
import com.any.model.JWT_BL.models.Enums.*;
import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.JsonObject;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
public class TopicModelService {

    public TopicClass ClassifyText(String text){
        String encodedText = URLEncoder.encode(text, StandardCharsets.UTF_8);
        HttpClient client = HttpClient.newHttpClient();
        String topicEndpoint = "http://localhost:5000/predict/topic/" + encodedText;
        try {
            HttpRequest topicRequest = HttpRequest.newBuilder()
                    .uri(URI.create(topicEndpoint))
                    .build();
            HttpResponse<String> topicResponse = client.send(topicRequest, HttpResponse.BodyHandlers.ofString());
            if (topicResponse.statusCode() == 200) {
                int topicClass = extractClassFromJson(topicResponse.body());
                TopicClass topic = TopicClass.fromInt(topicClass);
                return topic;
            } else {
                System.out.println("Failed to classify topic. Status code: " + topicResponse.statusCode());
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int extractClassFromJson(String jsonBody) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonBody, JsonObject.class);
        return jsonObject.get("predicted_class").getAsInt();
    }
}
