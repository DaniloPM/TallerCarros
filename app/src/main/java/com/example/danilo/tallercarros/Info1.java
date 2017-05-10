package com.example.danilo.tallercarros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Info1 extends AppCompatActivity {


    private ArrayList<Carros> carrosArrayList;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info1);

        carrosArrayList = Datos.getCarros();
        resultado = (TextView)findViewById(R.id.txtCantidadCarros);
        resultado.setText(String.valueOf(carrosArrayList.size()));
    }
}
