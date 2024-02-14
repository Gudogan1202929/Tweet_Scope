package com.any.model.JWT_BL.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TweetTopic {
    private int tweetId;
    private Enums.TopicClass topic;

}
