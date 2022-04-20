package com.example.appimporvultec.MenuAdministrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appimporvultec.MenuAdministrador.Adaptadores.AdaptadorAdministrador;
import com.example.appimporvultec.Models.Productos;
import com.example.appimporvultec.R;
import com.example.appimporvultec.Utils.Apis;
import com.example.appimporvultec.Utils.ProductService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListarProductosAdministrador extends AppCompatActivity {

    private TextView DetalleText;
    List<Productos> productos = new ArrayList<Productos>();
    ListView listViewAdmin = null;
    AdaptadorAdministrador adapter = null;
    private ProductService productService = Apis.getProductoService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_productos_administrador);

        adapter = new AdaptadorAdministrador(this, R.layout.elemento_lista_productos, productos);
        listViewAdmin = (ListView) findViewById(R.id.listViewListarAdmin);
        listViewAdmin.setAdapter(adapter);
        cargarProductos();

        listViewAdmin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetalleListarProductosAdministrador.class);
                intent.putExtra("objectoData", productos.get(i).getId_producto());
                startActivity(intent);
            }
        });

        DetalleText = findViewById(R.id.textViewTituloListar);
        ReutilizarActivity(getIntent().getStringExtra("titulo"));

    }

    public void cargarProductos(){
        Call<List<Productos>> call = productService.getProductos();
        call.enqueue(new Callback<List<Productos>>() {
            @Override
            public void onResponse(Call<List<Productos>> call, Response<List<Productos>> response) {
                List<Productos> data = response.body();
                productos.addAll(data);
                System.out.println(response.body().get(1).getDescription());
                adapter.notifyDataSetChanged();
                System.out.println("MUESTRATE");
            }

            @Override
            public void onFailure(Call<List<Productos>> call, Throwable t) {

            }
        });
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