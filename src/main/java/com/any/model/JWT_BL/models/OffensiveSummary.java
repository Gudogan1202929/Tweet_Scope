package com.any.model.JWT_BL.models;

import jakarta.persistence.Column;
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
    private int offensive;
    @Column(name = "Hate_Speech")
    private int hateSpeech;
    private int normal;
}