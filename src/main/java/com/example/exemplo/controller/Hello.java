package com.example.exemplo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.join;
import static java.util.Collections.nCopies;

@RestController
@RequestMapping
public class Hello {

    private static final int[] DECIMAIS =
            {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMANOS =
            {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    @GetMapping
    public String digaOla(){
        return "Olá!";
    }

    @GetMapping ("/{decimal}")
    public String converteRomanos(@PathVariable Integer decimal) {
            StringBuilder resultado = new StringBuilder();
            for (int i = 0; i < DECIMAIS.length; i++) {
                int parteInteira = decimal / DECIMAIS[i];
                decimal -= DECIMAIS[i] * parteInteira;
                resultado.append(join("", nCopies(parteInteira, ROMANOS[i])));
            }
            return resultado.toString();
        }
}
