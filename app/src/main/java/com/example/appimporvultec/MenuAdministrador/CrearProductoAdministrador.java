package com.example.appimporvultec.MenuAdministrador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appimporvultec.IngresoDatos;
import com.example.appimporvultec.Models.Productos;
import com.example.appimporvultec.Models.User;
import com.example.appimporvultec.R;
import com.example.appimporvultec.Utils.Apis;
import com.example.appimporvultec.Utils.ProductService;
import com.example.appimporvultec.Utils.Producto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CrearProductoAdministrador extends AppCompatActivity implements View.OnClickListener {

    private EditText nombre, descripcion, precio;
    private Button crear;

    ProductService productService = Apis.getProductoService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_producto_administrador);

        nombre = (EditText) findViewById(R.id.TituloProducto);
        descripcion = (EditText) findViewById(R.id.DescripcionProducto);
        precio = (EditText) findViewById(R.id.PrecioProducto);

        crear = (Button) findViewById(R.id.GuardarRegistro);

        crear.setOnClickListener(this);

    }

    public void crearProducto(Productos productos){

        Call<Productos> call=productService.createProductosCall(productos);
        call.enqueue(new Callback<Productos>() {
            @Override
            public void onResponse(Call<Productos> call, Response<Productos> response) {
                System.out.println(response.code());

                if(response.isSuccessful()){
                    Toast.makeText(CrearProductoAdministrador.this, "Registro Guardado", Toast.LENGTH_SHORT).show();

                    System.out.println("Guardado Guardado exitoso");
                }else{
                    Toast.makeText(CrearProductoAdministrador.this, "Algo salio mal :(", Toast.LENGTH_SHORT).show();

                    System.out.println("fallo el guardado");
                }
            }
            @Override
            public void onFailure(Call<Productos> call, Throwable t) {
                Log.e("Error: ",t.toString());
            }
        });
    }


    public void Datos(){
        Productos p = new Productos();
        p.setName(nombre.getText().toString());
        p.setDescription(descripcion.getText().toString());
        p.setPrice(Double.parseDouble(precio.getText().toString()));
        crearProducto(p);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.GuardarRegistro:
                Datos();
                break;
        }
    }
}