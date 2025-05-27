package org.easyconverter.service.converter.weight;

import lombok.NoArgsConstructor;
import org.easyconverter.model.ConversionRequest;
import java.util.Optional;

@NoArgsConstructor
public class WeightConverter {
    private final double toLB = 0.4536;
    private final double toKG = 2.2;

    public Optional<Double> calculate(ConversionRequest request){
        if(request.getFromUnit().equalsIgnoreCase("lb")
                && request.getToUnit().equalsIgnoreCase("kg")){
            double result = request.getValue() * toKG;
            return Optional.of(result);
        }
        if(request.getFromUnit().equalsIgnoreCase("kg")
                && request.getToUnit().equalsIgnoreCase("lb")){
            double result = request.getValue() * toLB;
            return Optional.of(result);
        }
        return Optional.empty();
    }
}
