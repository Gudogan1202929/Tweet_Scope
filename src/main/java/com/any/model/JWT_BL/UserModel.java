package com.any.model.JWT_BL;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserModel {

    private long userid;

    private String username;

    private String password;

    private String token;

    private String role;

    public UserModel(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
