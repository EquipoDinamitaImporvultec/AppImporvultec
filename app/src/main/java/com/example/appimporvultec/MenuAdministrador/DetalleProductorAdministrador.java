package com.example.appimporvultec.MenuAdministrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appimporvultec.R;

public class DetalleProductorAdministrador extends AppCompatActivity {


    private TextView DetalleText;
    private Button btnCrearProducto, btnListarProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_productor_administrador);


        btnCrearProducto = findViewById(R.id.OpcionCrear);
        btnListarProducto = findViewById(R.id.OpcionListado);

        //btnCrearProducto.setOnClickListener(this);
        //btnListarProducto.setOnClickListener(this);

        DetalleText = findViewById(R.id.textViewTitulo);
        ReutilizarActivity(getIntent().getStringExtra("titulo"));
    }

    private void gotoCrear(){
        Intent intent = new Intent(getApplicationContext(), CrearProductoAdministrador.class);
        startActivity(intent);
    }
    private void gotoListar(String i){
        Intent intent = new Intent(getApplicationContext(), ListarProductosAdministrador.class);
        intent.putExtra("titulo", i);
        startActivity(intent);
    }


    public void ReutilizarActivity(String a){
        if (a.equals("Accesorios")){
            DetalleText.setText("Accesorios");
            btnCrearProducto.setOnClickListener(view -> {gotoCrear();});
            btnListarProducto.setOnClickListener(view -> {gotoListar("Accesorios");});

        }else if (a.equals("Sistema Eléctrico")){
            DetalleText.setText("Sistema Eléctrico");
            btnCrearProducto.setOnClickListener(view -> {gotoCrear();});
            btnListarProducto.setOnClickListener(view -> {gotoListar("Sistema Eléctrico");});

        }else if (a.equals("Sistema de Frenos")){
            DetalleText.setText("Sistema de Frenos");
            btnCrearProducto.setOnClickListener(view -> {gotoCrear();});
            btnListarProducto.setOnClickListener(view -> {gotoListar("Sistema de Frenos");});

        }else if (a.equals("Llantas")){
            DetalleText.setText("Llantas");
            btnCrearProducto.setOnClickListener(view -> {gotoCrear();});
            btnListarProducto.setOnClickListener(view -> {gotoListar("Llantas");});

        }else if (a.equals("Lubricantes")){
            DetalleText.setText("Lubricantes");
            btnCrearProducto.setOnClickListener(view -> {gotoCrear();});
            btnListarProducto.setOnClickListener(view -> {gotoListar("Lubricantes");});


        }else if (a.equals("Filtros")){
            DetalleText.setText("Filtros");
            btnCrearProducto.setOnClickListener(view -> {gotoCrear();});
            btnListarProducto.setOnClickListener(view -> {gotoListar("Filtros");});

        }else if (a.equals("Sistema de Motor")){
            DetalleText.setText("Sistema de Motor");
            btnCrearProducto.setOnClickListener(view -> {gotoCrear();});
            btnListarProducto.setOnClickListener(view -> {gotoListar("Sistema de Motor");});

        }else if (a.equals("Sistema de Transmisión")){
            DetalleText.setText("Sistema de Transmisión");
            btnCrearProducto.setOnClickListener(view -> {gotoCrear();});
            btnListarProducto.setOnClickListener(view -> {gotoListar("Sistema de Transmisión");});
        }
    }

}