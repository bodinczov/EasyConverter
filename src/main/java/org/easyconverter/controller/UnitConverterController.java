package org.easyconverter.controller;

import org.easyconverter.model.ConversionRequest;
import org.easyconverter.model.ConversionResponse;
import org.easyconverter.service.converter.ConverterFactory;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class UnitConverterController {
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("conversionRequest", new ConversionRequest());
        return "index";
    }

    @PostMapping("/convert")
    public String convert(@ModelAttribute ConversionRequest request,
                          Model model){
        System.out.println(request.getCategory() + " " + request.getFromUnit()
                + " " + request.getToUnit() + " " + request.getValue());
        ConverterFactory factory = new ConverterFactory();
        Optional<Double> convertedValue = factory.convert(request);

        ConversionResponse response = new ConversionResponse();
        if(convertedValue.isPresent()){
            response.setValue(convertedValue.get());
        } else {
            response.setMessage("Что-то пошло не так!");
        }
        model.addAttribute("conversionResponse", response);
        model.addAttribute("conversionRequest", request);

        return "index";
    }
}
