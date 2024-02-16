package com.any.model.JWT_BL;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "black_tokens")
public class BlackListModel {

    @Id
    @SequenceGenerator(name = "blackId_sequence",
            sequenceName = "blackId_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "blackId_sequence")
    private long blackId;

    @Column(name = "black_token",
            nullable = false,
            columnDefinition = "TEXT")
    private String token;
    public BlackListModel(String token) {
        this.token = token;
    }
}
