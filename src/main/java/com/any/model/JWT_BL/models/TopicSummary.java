package com.any.model.JWT_BL.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Topic_Summary")
public class TopicSummary {
    @Id
    private int id;
    private int health;
    private int politics;
    private int sport;
    private int technology;
    private int religion;
}
