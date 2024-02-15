package com.any.model.JWT_BL.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Offensive_Summary")
public class OffensiveSummary {
    @Id
    private int id;
    private int normal;
    private int offensive;
    private int hateSpeech;
}