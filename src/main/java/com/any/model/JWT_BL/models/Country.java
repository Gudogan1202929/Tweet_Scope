package com.any.model.JWT_BL.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    private int id;
    private String name;
    private String language;
    private String currency;
    private String TimeZone;
}
