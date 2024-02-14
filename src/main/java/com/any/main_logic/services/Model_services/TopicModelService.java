package com.any.main_logic.services.Model_services;
import com.any.model.JWT_BL.models.Enums;
import org.springframework.stereotype.Service;

@Service
public class TopicModelService {

    public Enums.TopicClass ClassifyText(String text){
        return Enums.TopicClass.Politics;
    }
}
