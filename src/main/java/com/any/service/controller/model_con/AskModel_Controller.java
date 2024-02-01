package com.any.service.controller.model_con;

import com.any.service.repo.model_rep.AskModel_repo;
import com.any.utils.constant.SystemConstants;
import org.springframework.stereotype.Service;

@Service
public class AskModel_Controller {

    private final AskModel_repo askModelRepo = new AskModel_repo();


    public String typeOfAbusive(String message) throws Exception {
        try {
            return askModelRepo.typeOfAbusive(message);
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }

    public String typeOfTopics(String message) throws Exception {
        try {
            return askModelRepo.typeOfTopics(message);
        }catch (Exception e){
            throw new Exception(SystemConstants.BAD_REQUEST);
        }
    }
}
