package com.any.service.repo.model_rep;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AskModel_repo {

    //todo
    public String typeOfAbusive(String message) {
        return "Hate Speech";
    }

    //todo
    public String typeOfTopics(String message) {
        return "Tech";
    }
}
