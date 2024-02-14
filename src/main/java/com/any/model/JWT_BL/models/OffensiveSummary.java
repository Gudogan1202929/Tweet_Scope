package com.any.model.JWT_BL.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OffensiveSummary {
    private int normal;
    private int offensive;
    private int hateSpeech;
}
