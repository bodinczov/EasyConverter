package org.easyconverter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConversionRequest {
    private String category;
    private String fromUnit;
    private String toUnit;
    private double value;
}
