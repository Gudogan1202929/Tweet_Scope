package com.any.model.dto;

public class TopicsDTO {

    private String topic;

    private int tweets_count;

    public TopicsDTO(String topic, int user_count) {
        this.topic = topic;
        this.tweets_count = user_count;
    }

    public String getTopic() {
        return topic;
    }

    public int getUser_count() {
        return tweets_count;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setUser_count(int user_count) {
        this.tweets_count = user_count;
    }

    @Override
    public String toString() {
        return "Topics{" +
                "topic='" + topic + '\'' +
                ", user_count=" + tweets_count +
                '}';
    }
}
