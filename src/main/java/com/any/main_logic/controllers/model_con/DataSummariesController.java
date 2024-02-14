package com.any.main_logic.controllers.model_con;

import com.any.main_logic.services.Model_services.DataService;
import jakarta.ws.rs.Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataSummariesController {

    private final DataService service = new DataService();

    @Path("/topicClassification")
    public ResponseEntity<?> topicSummary() {

        try {
            var topicClassification = service.getTopicSummary();
            return ResponseEntity.ok(topicClassification);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @Path("/offensiveChart")
    public ResponseEntity<?> offensiveDate() {

        try {
            var offensiveDate = service.getDateOffensiveSummary();
            return ResponseEntity.ok(offensiveDate);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @Path("/topOffensiveRegions")
    public ResponseEntity<?> topOffensiveRegions() {

        try {
            var topOffensiveRegions = service.getTopCountryOffensiveSummary();
            return ResponseEntity.ok(topOffensiveRegions);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @Path("/numOfTweets")
    public ResponseEntity<?> numOfTweets() {

        try {
            return ResponseEntity.ok(service.getNumberOfTweets());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @Path("/offensiveSummary")
    public ResponseEntity<?> offensiveSummary() {

        try {
            var offensiveSummary = service.getOffensiveSummary();
            return ResponseEntity.ok(offensiveSummary);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @Path("/regionsOffensive")
    public ResponseEntity<?> regionsOffensive() {

        try {
            var regionsOffensive = service.getCountryOffensiveSummary();
            return ResponseEntity.ok(regionsOffensive);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
