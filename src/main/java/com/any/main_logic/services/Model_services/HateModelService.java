package com.any.main_logic.services.Model_services;
import org.springframework.stereotype.Service;
import com.any.model.JWT_BL.models.*;


@Service
public class HateModelService {

    public Enums.OffensiveClass ClassifyText(String text){
        return Enums.OffensiveClass.Offensive;
    }
}
