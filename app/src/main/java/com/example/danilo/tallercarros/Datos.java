package com.example.danilo.tallercarros;

import java.util.ArrayList;

/**
 * Created by Danilo on 9/05/2017.
 */

public class Datos {

    private static ArrayList<Carros> carros = new ArrayList<>();

    public static void guardar (Carros c){
        carros.add(c);
    }

    public static ArrayList<Carros> getCarros(){
        return carros;
    }
}

