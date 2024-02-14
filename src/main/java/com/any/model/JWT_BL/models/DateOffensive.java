package com.any.model.JWT_BL.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateOffensive {
    private LocalDate date;
    private int hateSpeech;
    private int offensive;
    private int normal;
}
