package com.example.danilo.tallercarros;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Registro extends AppCompatActivity {

    private EditText cjPlaca, cjPrecio;
    private Spinner cbMarca, cbModelo, cbColor;
    private String [] opcionMarca, opcionModelo, opcionColor;
    private ArrayAdapter<String> adapter;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        res = this.getResources();

        cjPlaca = (EditText)findViewById(R.id.txtPlaca);
        cbMarca = (Spinner)findViewById(R.id.cmdMarca);
        cbModelo = (Spinner)findViewById(R.id.cmdModelo);
        cbColor = (Spinner)findViewById(R.id.cmdColor);
        cjPrecio = (EditText)findViewById(R.id.txtPrecio);

        opcionMarca = res.getStringArray(R.array.opcionMarca);
        opcionModelo = res.getStringArray(R.array.opcionModelo);
        opcionColor = res.getStringArray(R.array.opcionColor);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, opcionMarca);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, opcionModelo);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, opcionColor);
    }

    public void guardar (View v){
        String placaCarro, marcaCarro, modeloCarro, colorCarro, precioCarro, foto;
        int precio;

        if (validar()){
            placaCarro = cjPlaca.getText().toString().trim();
            marcaCarro = cbMarca.getSelectedItem().toString();
            modeloCarro = cbModelo.getSelectedItem().toString();
            colorCarro = cbColor.getSelectedItem().toString();
            precioCarro = cjPrecio.getText().toString().trim();
            precio = Integer.parseInt(precioCarro);

            foto = String.valueOf(fotoAleatoria());
            Carros c = new Carros(placaCarro, marcaCarro, modeloCarro, colorCarro, precio, foto);
            c.guardar();

            new AlertDialog.Builder(this).setMessage(res.getString(R.string.mensaje)).show();
            limpiar();
        }
    }

    public boolean validar(){
        if(cjPlaca.getText().toString().isEmpty()){
            cjPlaca.setError(getResources().getString(R.string.error_1));
            return false;
        }
        if(cjPlaca.getText().toString().isEmpty()){
            cjPrecio.setError(getResources().getString(R.string.error_2));
            return false;
        }
        return  true;
    }

    public void borrar(View v){
        limpiar();
    }

    public void limpiar(){
        cjPlaca.setText("");
        cjPlaca.requestFocus();
        cbMarca.setSelection(0);
        cbModelo.setSelection(0);
        cbColor.setSelection(0);
        cjPrecio.setText("");

    }

    public int fotoAleatoria(){
        int fotos[] = {R.drawable.ferrari, R.drawable.nissan, R.drawable.porsche};
        int numero = (int) (Math.random() *3);
        return fotos[numero];
    }
}
