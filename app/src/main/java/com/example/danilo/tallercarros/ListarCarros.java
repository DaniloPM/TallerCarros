package com.example.danilo.tallercarros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarCarros extends AppCompatActivity {

    private ListView lista;
    private ArrayList<Carros> carros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_carros);

        lista = (ListView)findViewById(R.id.lvListarCarros);
        carros = Datos.getCarros();

        AdaptadorCarros adapter = new AdaptadorCarros(this, carros);
        lista.setAdapter(adapter);
    }
}
