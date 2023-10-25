package com.any.model.dto;

public class RecentOffensiveDTO {

    private String OffensiveType;

    private String OffensiveText;

    public RecentOffensiveDTO(String offensiveType, String offensiveText) {
        OffensiveType = offensiveType;
        OffensiveText = offensiveText;
    }

    public String getOffensiveType() {
        return OffensiveType;
    }

    public void setOffensiveType(String offensiveType) {
        OffensiveType = offensiveType;
    }

    public String getOffensiveText() {
        return OffensiveText;
    }

    public void setOffensiveText(String offensiveText) {
        OffensiveText = offensiveText;
    }

    @Override
    public String toString() {
        return "RecentOffensiveDTO{" +
                "OffensiveType='" + OffensiveType + '\'' +
                ", OffensiveText='" + OffensiveText + '\'' +
                '}';
    }
}
