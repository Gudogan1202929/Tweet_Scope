package com.any.model.JWT_BL;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_table")
public class UserModel {
    @Id
    @SequenceGenerator(name = "user_table_sequence",
            sequenceName = "user_table_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_table_sequence")
    private long userid;

    @Column(name = "username",
            nullable = false,
            columnDefinition = "TEXT")
    private String username;

    @Column(name = "password",
            nullable = false,
            columnDefinition = "TEXT")
    private String password;

    @Column(name = "token",
            columnDefinition = "TEXT")
    private String token;

    @Column(name = "role",
            columnDefinition = "TEXT")
    private String role;

    public UserModel(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
