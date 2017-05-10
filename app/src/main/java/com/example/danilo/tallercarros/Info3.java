package com.example.danilo.tallercarros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Info3 extends AppCompatActivity {

    private ArrayList<Carros> carrosArrayList;
    private TextView carroRojo, carroDorado, carroRojo2;
    int rojo = 0, dorado = 0, rojo2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info3);

        ListView listaCarros = (ListView)findViewById(R.id.lstModeloCarros);
        ArrayList<Carros> carroArrayList = Datos.getCarros();
        ArrayList<Carros> resultadosArrayList = new ArrayList<>();

        for (int i = 0; i < carroArrayList.size(); i++) {
            int modelo = Integer.parseInt(carroArrayList.get(i).getModelo());
            if (modelo >= 2010 && modelo <= 2015){
                resultadosArrayList.add(carroArrayList.get(i));
            }
        }

        AdaptadorCarros AdaptadorCarro = new AdaptadorCarros(this, resultadosArrayList);
        listaCarros.setAdapter(AdaptadorCarro);
    }

}
