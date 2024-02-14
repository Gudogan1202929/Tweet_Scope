package com.any.model.JWT_BL;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlackListModel {

    private long blackId;

    private String token;
    public BlackListModel(String token) {
        this.token = token;
    }
}
