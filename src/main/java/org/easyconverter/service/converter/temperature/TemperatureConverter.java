package org.easyconverter.service.converter.temperature;

import lombok.NoArgsConstructor;
import org.easyconverter.model.ConversionRequest;
import java.util.Optional;

@NoArgsConstructor
public class TemperatureConverter {
    private final double toF = 1.8;
    private final double toC = 0.5556;

    public Optional<Double> calculate(ConversionRequest request){
        if(request.getFromUnit().equalsIgnoreCase("C")
                && request.getToUnit().equalsIgnoreCase("F")){
            double result = request.getValue() * toF + 32;
            return Optional.of(result);
        }
        if(request.getFromUnit().equalsIgnoreCase("F")
                && request.getToUnit().equalsIgnoreCase("C")){
            double result = (request.getValue() - 32) * toC;
            return Optional.of(result);
        }
        return Optional.empty();
    }
}
