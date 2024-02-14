package com.any.model.JWT_BL;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class IPsModel {

    private long IPsId;

    private String Time;

    private String ip;

    private String URL;

    public IPsModel(String time, String ip, String URL) {
        this.Time = time;
        this.ip = ip;
        this.URL = URL;
    }
}
