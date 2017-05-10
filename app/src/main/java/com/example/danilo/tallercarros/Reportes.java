package com.example.danilo.tallercarros;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Reportes extends AppCompatActivity {

    private ListView lv;
    private Resources res;
    private String[] opc;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);

        lv = (ListView) findViewById(R.id.lvinfo);
        res = this.getResources();
        opc = res.getStringArray(R.array.Informes_array);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, opc);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        i = new Intent(Reportes.this, Info1.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(Reportes.this, Info2.class);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(Reportes.this, Info3.class);
                        startActivity(i);
                        break;

                }
            }
        });
    }
}