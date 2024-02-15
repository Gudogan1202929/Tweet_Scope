package com.any.model.JWT_BL.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Tweet_Offensive")
public class TweetOffensive {
    @Id
    private int id;
    private int tweetId;
    private Enums.OffensiveClass offensiveClass;
}
