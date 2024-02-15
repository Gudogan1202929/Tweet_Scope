package com.any.model.JWT_BL.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeInstanat_dto {
    private Timestamp time;
    private int numHate;
    private int numOffensive;
    private int numNormal;
}
