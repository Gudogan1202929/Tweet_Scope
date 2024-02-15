package com.any.model.JWT_BL.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Entity(name = "Country_Offensive")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryOffensive extends PanacheEntityBase {
    @Id
    public int id;
    public int countryId;
    public int Normal;
    public int Offensive;
    public int Hate_Speech;
}