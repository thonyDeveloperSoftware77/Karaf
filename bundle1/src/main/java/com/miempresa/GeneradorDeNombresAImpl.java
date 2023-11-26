package com.miempresa;

import com.miempresa.GeneradorDeNombresA;

import java.util.List;
import java.util.Arrays;
public class GeneradorDeNombresAImpl implements GeneradorDeNombresA {
    public List<String> generarNombres() {
        System.out.println("entro al bundle1");
        return Arrays.asList("Ana", "Antonio", "Alberto");
    }
}