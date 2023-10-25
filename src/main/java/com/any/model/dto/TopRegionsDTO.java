package com.any.model.dto;

public class TopRegionsDTO {

    private String region;

    private int user_count;

    public TopRegionsDTO(String region, int user_count) {
        this.region = region;
        this.user_count = user_count;
    }

    public String getRegion() {
        return region;
    }

    public int getUser_count() {
        return user_count;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setUser_count(int user_count) {
        this.user_count = user_count;
    }

    @Override
    public String toString() {
        return "TopRegions{" +
                "region='" + region + '\'' +
                ", user_count=" + user_count +
                '}';
    }
}
