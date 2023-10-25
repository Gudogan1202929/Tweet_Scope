package com.any.model.JWT_BL;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Roles_Allowed {

    private String role;

    private List<String> paths = new ArrayList<>();
    public Roles_Allowed(String role) {
        this.role = role;
    }
}

