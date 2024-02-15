package com.any.model.JWT_BL.dto;

public class getTopicSummary_dto {

    private String topic;
    private int totalTweets;

    public getTopicSummary_dto(String topic, int totalTweets) {
        this.topic = topic;
        this.totalTweets = totalTweets;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getTotalTweets() {
        return totalTweets;
    }

    public void setTotalTweets(int totalTweets) {
        this.totalTweets = totalTweets;
    }
}
