package com.example.appimporvultec.MenuAdministrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appimporvultec.Menu.Adaptador;
import com.example.appimporvultec.Menu.DetalleItemProducto;
import com.example.appimporvultec.Menu.DetalleProducto;
import com.example.appimporvultec.Menu.Pruba;
import com.example.appimporvultec.R;

import java.util.ArrayList;

public class ListarProductosAdministrador extends AppCompatActivity {


    private ListView ListViewListarProductos;
    private TextView DetalleText;
    private Adaptador adaptador;
    private ArrayList<Pruba> arraypureba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_productos_administrador);


        ListViewListarProductos = (ListView) findViewById(R.id.listViewListar);
        arraypureba = GetArrayItems();
        adaptador = new Adaptador(this, arraypureba);
        ListViewListarProductos.setAdapter(adaptador);


        ListViewListarProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), CrearProductoAdministrador.class);
                intent.putExtra("objectoData", arraypureba.get(i));
                startActivity(intent);
            }
        });

        DetalleText = findViewById(R.id.textViewTituloListar);
        ReutilizarActivity(getIntent().getStringExtra("titulo"));

    }


    private ArrayList<Pruba> GetArrayItems(){
        ArrayList<Pruba> listItems = new ArrayList<>();
        listItems.add(new Pruba(R.drawable.carruselejemplo2, "Titulo", "Descripcion"));
        listItems.add(new Pruba(R.drawable.carruselejemplo3, "Titulo2", "Descripcio2"));

        return listItems;
    }


    public void ReutilizarActivity(String a){
        if (a.equals("Accesorios")){
            DetalleText.setText("Accesorios");

        }else if (a.equals("Sistema Eléctrico")){
            DetalleText.setText("Sistema Eléctrico");

        }else if (a.equals("Sistema de Frenos")){
            DetalleText.setText("Sistema de Frenos");

        }else if (a.equals("Llantas")){
            DetalleText.setText("Llantas");

        }else if (a.equals("Lubricantes")){
            DetalleText.setText("Lubricantes");

        }else if (a.equals("Filtros")){
            DetalleText.setText("Filtros");

        }else if (a.equals("Sistema de Motor")){
            DetalleText.setText("Sistema de Motor");

        }else if (a.equals("Sistema de Transmisión")){
            DetalleText.setText("Sistema de Transmisión");
        }
    }

}