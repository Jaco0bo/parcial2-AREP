package org.escuelaing.edu.parcial_2.controllers;

import org.escuelaing.edu.parcial_2.utils.mathLogic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class backendController {
    @GetMapping("/factores")
    public Map<String, Object> factores(@RequestParam String value) {
        Integer n;
        try {
            n = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El valor ingresado no es un numero, intente nuevamente...");
        }

        List<String> factoresList = mathLogic.factores(n);
        Map<String, Object> response = new HashMap<>();
        response.put("Operacion", "Factores de un numero");
        response.put("Input", n);
        response.put("Output", factoresList.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        return response;
    }


    @GetMapping("/primos")
    public Map<String, Object> primos(@RequestParam String value) {
        Integer m;
        try {
            m = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El valor ingresado no es un numéro, intente nuevamente..");
        }

        List<String> primosList =mathLogic.primos(m);
        Map<String, Object> response = new HashMap<>();
        response.put("Operacion", "Primos de un numero");
        response.put("Input", m);
        response.put("Output", primosList.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        return response;
    }
}
