package com.any.main_logic.controllers.model_con;

import com.any.main_logic.services.Model_services.HateModelService;
import com.any.main_logic.services.Model_services.TopicModelService;
import jakarta.ws.rs.Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextClassificationController {
    private final HateModelService _hateModel = new HateModelService();
    private final TopicModelService _topicModel = new TopicModelService();

    @Path("/classifyHate")
    public ResponseEntity<?> classifyHate(@RequestParam String text) {
        try {
            var hateClass = _hateModel.ClassifyText(text);
            return ResponseEntity.ok(hateClass);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @Path("/classifyTopic")
    public ResponseEntity<?> classifyTopic(@RequestParam String text) {
        try {
            var topicClass = _topicModel.ClassifyText(text);
            return ResponseEntity.ok(topicClass);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
