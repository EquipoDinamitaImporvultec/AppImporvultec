package com.example.appimporvultec.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appimporvultec.Models.Categoria;
import com.example.appimporvultec.R;
import com.example.appimporvultec.Utils.Apis;
import com.example.appimporvultec.Utils.CategoriaService;
import com.google.android.gms.common.api.Api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleProducto extends AppCompatActivity {

    private ListView ListViewProductos;
    private TextView DetalleText;
    private Adaptador adaptador;
    private ArrayList<Pruba> arraypureba;
    private CategoriaService categoriaService = Apis.getCategoriaService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);

        ListViewProductos = (ListView) findViewById(R.id.listViewProductos);
        arraypureba = GetArrayItems();
        adaptador = new Adaptador(this, arraypureba);
        ListViewProductos.setAdapter(adaptador);

        ListViewProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DetalleProducto.this, DetalleItemProducto.class);
                intent.putExtra("objectoData", arraypureba.get(i));
                startActivity(intent);
            }
        });

        DetalleText = findViewById(R.id.textViewTituloPro);
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

        }else if (a.equals("Sistema El??ctrico")){
                DetalleText.setText("Sistema El??ctrico");

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

        }else if (a.equals("Sistema de Transmisi??n")){
            DetalleText.setText("Sistema de Transmisi??n");
        }
    }

}