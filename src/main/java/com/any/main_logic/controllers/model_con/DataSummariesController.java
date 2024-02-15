package com.any.main_logic.controllers.model_con;

import com.any.main_logic.services.Model_services.DataService;
import com.any.model.JWT_BL.dto.getTopicSummary_dto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Path("/dataSummaries")
public class DataSummariesController {

    private final DataService service = new DataService();

    @Path("/topicClassification")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> topicSummary() {
        System.out.println("Topic Summary");
        try {
            var topicClassification = service.getTopicSummary();
            return ResponseEntity.ok(topicClassification);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @Path("/offensiveChart")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> offensiveDate() {
        try {
            var offensiveDate = service.getDateOffensiveSummary();
            return ResponseEntity.ok(offensiveDate);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @Path("/topOffensiveRegions")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> topOffensiveRegions() {
        try {
            var topOffensiveRegions = service.getTopCountryOffensiveSummary();
            return ResponseEntity.ok(topOffensiveRegions);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @Path("/numOfTweets")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> numOfTweets() {
        try {
            return ResponseEntity.ok(service.getNumberOfTweets());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @Path("/offensiveSummary")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> offensiveSummary() {
        try {
            var offensiveSummary = service.getOffensiveSummary();
            return ResponseEntity.ok(offensiveSummary);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @Path("/regionsOffensive")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> regionsOffensive() {
        try {
            List<getTopicSummary_dto> regionsOffensive = service.getCountryOffensiveSummary();
            return ResponseEntity.ok(regionsOffensive);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}