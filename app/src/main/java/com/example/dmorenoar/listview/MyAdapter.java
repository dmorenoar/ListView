package com.example.dmorenoar.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        /*ViewHolder Pattern nos permite aumentar el rendimiento de la aplicación para que no se
        dupliquen las llamadas al finViewById en las celdas ya instanciadas*/
        ViewHolder holder;

        /*Comprobamos si la row ya ha sido renderizada y directamente asignamos al holder el convertView sin
        * tener que volver a hacer el findById*/
        if (convertView == null){
            /*Recogemos el view de la vista, lo inflamos y lo personalizamos*/
            //Personalizamos el layout donde vamos a mostrar al clickar la celda
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.detail_user, null);

            holder = new ViewHolder();

            //Recuperamos de la vista que si puede contener el contexto el id del textview donde mostraremos el nombre
            //Añadimos en la propiedad la referencia del textview que vamos a referenciar
            holder.nameTextView = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }


        //Casteamos porque recibimos un object de la posición clicada
        String currentName = (String) listNames.get(position);


        holder.nameTextView.setText(currentName);

        return convertView;
    }

    static class ViewHolder {
        /*Creariamos tantas variables como elementos tengamos en nuestra layout personalizada*/
        private TextView nameTextView;
    }
}
