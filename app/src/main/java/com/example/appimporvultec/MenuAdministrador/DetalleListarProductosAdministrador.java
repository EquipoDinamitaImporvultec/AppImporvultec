package com.example.appimporvultec.MenuAdministrador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appimporvultec.Models.Productos;
import com.example.appimporvultec.R;
import com.example.appimporvultec.Utils.Apis;
import com.example.appimporvultec.Utils.ProductService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleListarProductosAdministrador extends AppCompatActivity implements View.OnClickListener {

    private EditText nombre, desc, price;
    private ProductService productService = Apis.getProductoService();
    private Button editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_listar_productos_administrador);

        nombre = findViewById(R.id.TituloProducto);
        desc = findViewById(R.id.DescripcionProducto);
        price = findViewById(R.id.PrecioProducto);

        editar = findViewById(R.id.EditarRegistro);

        nombre.setText(getIntent().getStringExtra("Nombre"));
        desc.setText(getIntent().getStringExtra("Descripcion"));
        price.setText(getIntent().getStringExtra("Precio"));

        editar.setOnClickListener(this);


    }

    public void updateProducto(Productos productos, int id){

        Call<Productos> call=productService.update(productos, id);
        call.enqueue(new Callback<Productos>() {
            @Override
            public void onResponse(Call<Productos> call, Response<Productos> response) {
                if(response.isSuccessful()){
                    System.out.println("Logro editar el usuario: "+"\n"+response.body().getName()+" "+response.body().getName());

                }else{
                    System.out.println(response.code());
                    System.out.println("no bro lo siento, no lograste editar");

                }
            }

            @Override
            public void onFailure(Call<Productos> call, Throwable t) {
                Log.e("Error: ",t.toString());
            }
        });

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.EditarRegistro:
                Productos productos = new Productos();
                productos.setName(nombre.getText().toString());
                productos.setDescription(desc.getText().toString());
                productos.setPrice(Double.parseDouble(price.getText().toString()));
                productos.setId_categoria(null);
                productos.setUrlFoto(getIntent().getStringExtra("URLFOTO"));
                updateProducto(productos, Integer.parseInt(getIntent().getStringExtra("ID")));
                break;
        }
    }
}