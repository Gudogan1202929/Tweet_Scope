package com.any.model.JWT_BL.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Country")
public class Country {
    @Id
    private int id;
    private String name;
    private String language;
    private String currency;
    private String TimeZone;
}
