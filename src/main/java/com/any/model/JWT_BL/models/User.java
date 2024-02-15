package com.any.model.JWT_BL.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "'User'")
public class User {
    @Id
    private int id;
    private String email;
    private String password;
    private Enums.Role role;
}
