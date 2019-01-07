package com.example.dmorenoar.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //ListView corresponde a un TableView


    private ListView listView;
    List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        names = new ArrayList<String>();

        names.add("Juan");
        names.add("Pepe");
        names.add("Tomás");

        //Adaptador, la forma visual de como mostraremos nuestros datos
        //Trabajamos la lista con elementos Simple del tipo String, para más complejos utilizaremos una clase con sus atributos.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        //Enlazamos al listView el adapter
        listView.setAdapter(adapter);


        //Controlamos el click en un elemento de ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Has clickado: " + names.get(position), Toast.LENGTH_LONG).show();
            }
        });

        //Enlazamos con nuestro adaptador personalizado el listView creado en el layout

        MyAdapter myAdapter = new MyAdapter(this, R.layout.detail_user, names);
        listView.setAdapter(myAdapter);

    }
}

