package com.example.dmorenoar.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private List<String> listNames;
    private GridView gridView;


    private int counter = 0;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);



        gridView = findViewById(R.id.GridViewCustom);
        listNames = new ArrayList<String>();

        listNames.add("Juan");
        listNames.add("Pepe");
        listNames.add("Tomás");

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridActivity.this, "Has clickado:" + listNames.get(position), Toast.LENGTH_LONG).show();
            }
        });

        /*Enlazamos con el adapter personalizado, usando el mismo utilizado para el ListView
        son independientes de usar un ListView o un GridView, pudiendo asignar al Grid el mismo adapter pero modificando el layout*/
         myAdapter = new MyAdapter(GridActivity.this, R.layout.grid_item, listNames);

         //registramos el contextmenu para que aparezca la ventana de modificar, en nuestro caso para un gridview, pero podria ser una imagen etc
        registerForContextMenu(gridView);
    }


    /*Inflaremos el layout del menu para poder visualizarlo*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    //Manejamos eventos del menu de opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_item:
                this.listNames.add("Added num" + (++counter));
                myAdapter.notifyDataSetChanged(); //Al añadir hemos de refrescar el adaptador para refrescarlo
                return true;

            case R.id.deleteItem:

            default:
                return onOptionsItemSelected(item);
        }

    }

    //Inflamos el layout del context menu para eliminar elementos
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater inflater = getMenuInflater();

        //Poner titulo a la ventana
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle("Eliminar el elemento: " + listNames.get(info.position));

        inflater.inflate(R.menu.context_menu, menu);

    }


    //Manejamos eventos click en el context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        //Creamos un adapter que nso da información de donde hemos hecho el click
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.deleteItem:
                //Borramos el item clickeado utilizando la info de la posicion
                this.listNames.remove(info.position);
                //Notificamos al adaptador el cambio producido
                this.myAdapter.notifyDataSetChanged();
                return true;
                default:
                    return super.onContextItemSelected(item);
        }


    }
}
