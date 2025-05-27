package org.easyconverter.service.converter.length;

import lombok.NoArgsConstructor;
import org.easyconverter.model.ConversionRequest;
import java.util.Optional;

@NoArgsConstructor
public class LengthConverter {
    private final double toMI = 0.62;
    private final double toKM = 1.6;

    public Optional<Double> calculate(ConversionRequest request){
        if(request.getFromUnit().equalsIgnoreCase("km")
                && request.getToUnit().equalsIgnoreCase("mi")){
            double result = request.getValue() * toMI;
            return Optional.of(result);
        }
        if(request.getFromUnit().equalsIgnoreCase("mi")
                && request.getToUnit().equalsIgnoreCase("km")){
            double result = request.getValue() * toKM;
            return Optional.of(result);
        }
        return Optional.empty();
    }
}
