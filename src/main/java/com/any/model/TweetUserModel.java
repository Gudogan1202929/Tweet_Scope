package com.any.model;

import com.any.model.TweetModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table
@Entity(name = "tweetUser")
public class TweetUserModel {

    @Id
    @SequenceGenerator(name = "tweetUser_sequence",
            sequenceName = "tweetUser_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "tweetUser_sequence")
    private long id;

@OneToMany(cascade = CascadeType.ALL , mappedBy = "userModel")
    private static List<TweetModel> list = new LinkedList();

    @Column(name = "Region",
            nullable = false,
            columnDefinition = "TEXT")
    private String Region;

    @Column(name = "username",
            nullable = false,
            columnDefinition = "TEXT")
    private String username;

    public TweetUserModel(String Region, String username) {
        this.Region = Region;
        this.username = username;
    }
}
