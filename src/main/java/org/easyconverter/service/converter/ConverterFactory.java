package org.easyconverter.service.converter;

import lombok.NoArgsConstructor;
import org.easyconverter.model.ConversionRequest;
import org.easyconverter.service.converter.length.LengthConverter;
import org.easyconverter.service.converter.temperature.TemperatureConverter;
import org.easyconverter.service.converter.weight.WeightConverter;

import java.util.Optional;

@NoArgsConstructor
public class ConverterFactory {
    public Optional<Double> convert(ConversionRequest request){
        if(request.getCategory().equals("length")){
            LengthConverter converter = new LengthConverter();
            return converter.calculate(request);
        }
        if(request.getCategory().equals("weight")){
            WeightConverter converter = new WeightConverter();
            return converter.calculate(request);
        }
        if(request.getCategory().equals("temperature")){
            TemperatureConverter converter = new TemperatureConverter();
            return converter.calculate(request);
        }
        return Optional.empty();
    }
}
