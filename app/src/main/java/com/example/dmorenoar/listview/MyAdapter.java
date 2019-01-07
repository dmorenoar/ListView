package com.example.dmorenoar.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    //Creamos un contexto donde va a ser cargado el adaptador
    private Context context;
    private int layout;
    private List<String> listNames;


    public MyAdapter(Context context, int layout, List<String> listNames){
        this.context = context;
        this.layout = layout;
        this.listNames = listNames;
    }

    //Cuantas veces va a iterar sobre la colección de elementos
    @Override
    public int getCount() {
        return this.listNames.size();
    }

    //Obtener un item de esa colección
    @Override
    public Object getItem(int position) {
        return this.listNames.get(position);
    }

    //Obtener el id del item de la colección
    @Override
    public long getItemId(int position) {
        return 0;
    }

    //Creación de la vista para cada elemento
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        /*Recogemos el view de la vista, lo inflamos y lo personalizamos*/

        //Personalizamos el layout donde vamos a mostrar al clickar la celda
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.detail_user, null);

        //Casteamos porque recibimos un object de la posición clicada
        String currentName = (String) listNames.get(position);

        //Recuperamos de la vista que si puede contener el contexto el id del textview donde mostraremos el nombre
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(currentName);

        return view;
    }
}
