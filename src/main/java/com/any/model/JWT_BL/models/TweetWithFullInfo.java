package com.any.model.JWT_BL.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TweetWithFullInfo {
    private int id;
    private String text;
    private int countryId;
    private LocalDateTime publishDate;
    private Enums.TopicClass topic;
    private Enums.OffensiveClass offensiveClass;
}
