package com.any.main_logic.services.Model_services;
import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.JsonObject;
import org.springframework.stereotype.Service;
import com.any.model.JWT_BL.models.*;
import com.any.model.JWT_BL.models.Enums.*;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


@Service
public class HateModelService {

    public OffensiveClass ClassifyText(String text){
        String encodedText = URLEncoder.encode(text, StandardCharsets.UTF_8);
        HttpClient client = HttpClient.newHttpClient();
        String hateEndPoint = "http://localhost:5000/predict/hate/" + encodedText;
        try {
            HttpRequest hateRequest = HttpRequest.newBuilder()
                    .uri(URI.create(hateEndPoint))
                    .build();
            HttpResponse<String> offensiveResponse = client.send(hateRequest, HttpResponse.BodyHandlers.ofString());
            if (offensiveResponse.statusCode() == 200) {
                int offensiveClass = extractClassFromJson(offensiveResponse.body());
                OffensiveClass offensive = Enums.OffensiveClass.fromInt(offensiveClass);
                return offensive;
            } else {
                System.out.println("Failed to classify offensive. Status code: " + offensiveResponse.statusCode());
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
