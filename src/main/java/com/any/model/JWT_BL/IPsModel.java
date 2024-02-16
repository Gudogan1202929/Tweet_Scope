package com.any.model.JWT_BL;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = "ip_model")
public class IPsModel {

    @Id
    @SequenceGenerator(name = "ip_model_sequence",
            sequenceName = "ip_model_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ip_model_sequence")
    private long IPsId;

    @Column(name = "time",
            nullable = false,
            columnDefinition = "TEXT")
    private String Time;

    @Column(name = "ip",
            nullable = false,
            columnDefinition = "TEXT")
    private String ip;

    @Column(name = "URL",
            columnDefinition = "TEXT")
    private String URL;

    public IPsModel(String time, String ip, String URL) {
        this.Time = time;
        this.ip = ip;
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "IPsModel{" +
                "IPsId=" + IPsId +
                ", Time='" + Time + '\'' +
                ", ip='" + ip + '\'' +
                ", URL='" + URL + '\'' +
                '}';
    }
}
