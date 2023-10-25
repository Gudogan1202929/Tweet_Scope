package com.any.model.JWT_BL;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table
@Entity(name = "black_tokens")
public class BlackListModel {

    @Id
    @SequenceGenerator(name = "black_tokens_sequence",
            sequenceName = "black_tokens_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "bblack_tokens_sequence")
    private long blackId;

    @Column(name = "black_token",
            nullable = false,
            columnDefinition = "TEXT")
    private String token;

    public BlackListModel(String token) {
        this.token = token;
    }
}
