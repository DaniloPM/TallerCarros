package com.example.danilo.tallercarros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Info2 extends AppCompatActivity {

    private ArrayList<Carros> carrosArrayList;
    private TextView carroferrari, carronissan, carroporche;
    int ferrari = 0, nissan = 0, porche = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);

        carrosArrayList = Datos.getCarros();

        for (int i = 0; i < carrosArrayList.size(); i++) {
            if (carrosArrayList.get(i).getMarca().equals("Ferrari")) {
                ferrari++;
            } else if (carrosArrayList.get(i).getMarca().equals("Nissan")) {
                nissan++;
            } else {
                porche++;
            }
        }

        carroferrari = (TextView) findViewById(R.id.txtFerrari);
        carronissan = (TextView) findViewById(R.id.txtNissan);
        carroporche = (TextView) findViewById(R.id.txtProche);

        carroferrari.setText(String.valueOf(ferrari));
        carronissan.setText(String.valueOf(nissan));
        carroporche.setText(String.valueOf(porche));
    }
}