package com.example.appimporvultec.MenuAdministrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.appimporvultec.Menu.DetalleProducto;
import com.example.appimporvultec.R;

public class ProductoAdministrador extends AppCompatActivity implements View.OnClickListener{


    private Button OpAccesorios, OpSistemaElectrico, OpSistemaFrenos, OpLlantas, OpLubricantes, OpFiltros, OpMotor, OpTransmision;
    public TextView textoAccesorios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_administrador);

        textoAccesorios = findViewById(R.id.textViewTituloPro);

        OpAccesorios = findViewById(R.id.btnAccesorios_A);
        OpSistemaElectrico = findViewById(R.id.btnSistemaElectrico_A);
        OpSistemaFrenos = findViewById(R.id.btnSistemaFrenos_A);
        OpLlantas = findViewById(R.id.btnLlantas_A);
        OpLubricantes = findViewById(R.id.btnLubricantes_A);
        OpFiltros = findViewById(R.id.btnFiltros_A);
        OpMotor = findViewById(R.id.btnMotor_A);
        OpTransmision = findViewById(R.id.btnTransmision_A);

        OpAccesorios.setOnClickListener(this);
        OpSistemaElectrico.setOnClickListener(this);
        OpSistemaFrenos.setOnClickListener(this);
        OpLlantas.setOnClickListener(this);
        OpLubricantes.setOnClickListener(this);
        OpFiltros.setOnClickListener(this);
        OpMotor.setOnClickListener(this);
        OpTransmision.setOnClickListener(this);

    }
    private void goToDetalle(String i){
        Intent intent = new Intent(getApplicationContext(), DetalleProductorAdministrador.class);
        intent.putExtra("titulo", i);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnAccesorios_A:
                goToDetalle("Accesorios");
                break;
            case R.id.btnSistemaElectrico_A:
                goToDetalle("Sistema Eléctrico");
                break;
            case R.id.btnSistemaFrenos_A:
                goToDetalle("Sistema de Frenos");
                break;
            case R.id.btnLlantas_A:
                goToDetalle("Llantas");
                break;
            case R.id.btnLubricantes_A:
                goToDetalle("Lubricantes");
                break;
            case R.id.btnFiltros_A:
                goToDetalle("Filtros");
                break;
            case R.id.btnMotor_A:
                goToDetalle("Sistema de Motor");
                break;
            case R.id.btnTransmision_A:
                goToDetalle("Sistema de Transmisión");
                break;
        }
    }
}