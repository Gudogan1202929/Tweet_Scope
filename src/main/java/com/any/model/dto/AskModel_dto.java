package com.any.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AskModel_dto {

    private String egnore;

    private String message;

    public AskModel_dto(String egnore, String message) {
        this.egnore = egnore;
        this.message = message;
    }

    public AskModel_dto() {
    }

    @Override
    public String toString() {
        return "AskModel_dto{" +
                "egnore='" + egnore + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
