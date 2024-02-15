package com.any.model.JWT_BL.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Date_Offensive")
public class DateOffensive {
    @Id
    private int id;
    private LocalDate date;
    private int hateSpeech;
    private int offensive;
    private int normal;


    public static Timestamp getDateAsTimestamp(LocalDate date){
        // Convert LocalDate to LocalDateTime at the start of the day (00:00)
        LocalDateTime startOfDay = date.atStartOfDay();
        // Convert LocalDateTime to Timestamp
        return Timestamp.valueOf(startOfDay);
    }
}
