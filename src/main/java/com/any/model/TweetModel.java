package com.any.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table
@Entity(name = "Tweet")
public class TweetModel {

    @Id
    @SequenceGenerator(name = "Tweet_sequence",
            sequenceName = "Tweet_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "Tweet_sequence")
    private long Tweet_id;

    @Column(name = "tweet_content",
            nullable = false,
            columnDefinition = "TEXT")
    private String tweet_content;

    @ManyToOne
    private TweetUserModel userModel;

    @Column(name = "topic",
            nullable = false,
            columnDefinition = "TEXT")
    private String topic;

    @Column(name = "offensive_type",
            nullable = false,
            columnDefinition = "TEXT")
    private String offensive_type;

    @CreationTimestamp
    @Column(name = "timestamp", updatable = false)
    private Timestamp timestamp;
}
