package com.any.model.JWT_BL.models;

import lombok.Getter;

public class Enums {


    @Getter
    public enum Role{
        user(0),
        admin(1);

        private final int value;

        Role(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    @Getter
    public enum TopicClass {
        Sport(0),
        Politics(1),
        Technology(2),
        Religion(3),
        Health(4);

        private final int value;

        TopicClass(int value) {
            this.value = value;
        }

        public static TopicClass fromInt(int value) {
            for (TopicClass topic : TopicClass.values()) {
                if (topic.value == value) {
                    return topic;
                }
            }
            throw new IllegalArgumentException("Invalid integer value for TopicClass: " + value);
        }
    }

    @Getter
    public enum OffensiveClass {
        Normal(0),
        Offensive(1),
        HateSpeech(2);

        private final int value;

        OffensiveClass(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static OffensiveClass fromInt(int value) {
            for (OffensiveClass offensiveClass : OffensiveClass.values()) {
                if (offensiveClass.value == value) {
                    return offensiveClass;
                }
            }
            throw new IllegalArgumentException("Invalid integer value for TopicClass: " + value);
        }


    }


}
