package com.example.appimporvultec.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appimporvultec.R;

public class Producto extends AppCompatActivity implements View.OnClickListener {

    private Button OpAccesorios, OpSistemaElectrico, OpSistemaFrenos, OpLlantas, OpLubricantes, OpFiltros, OpMotor, OpTransmision;
    private DetalleProducto dp;
    public TextView textoAccesorios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        textoAccesorios = findViewById(R.id.textViewTituloPro);

        OpAccesorios = findViewById(R.id.btnAccesorios);
        OpSistemaElectrico = findViewById(R.id.btnSistemaElectrico);
        OpSistemaFrenos = findViewById(R.id.btnSistemaFrenos);
        OpLlantas = findViewById(R.id.btnLlantas);
        OpLubricantes = findViewById(R.id.btnLubricantes);
        OpFiltros = findViewById(R.id.btnFiltros);
        OpMotor = findViewById(R.id.btnMotor);
        OpTransmision = findViewById(R.id.btnTransmision);

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
        Intent intent = new Intent(getApplicationContext(), DetalleProducto.class);
        intent.putExtra("titulo", i);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnAccesorios:
                goToDetalle("Accesorios");
                break;
            case R.id.btnSistemaElectrico:
                goToDetalle("Sistema Eléctrico");
                break;
            case R.id.btnSistemaFrenos:
                goToDetalle("Sistema de Frenos");
                break;
            case R.id.btnLlantas:
                goToDetalle("Llantas");
                break;
            case R.id.btnLubricantes:
                goToDetalle("Lubricantes");
                break;
            case R.id.btnFiltros:
                goToDetalle("Filtros");
                break;
            case R.id.btnMotor:
                goToDetalle("Sistema de Motor");
                break;
            case R.id.btnTransmision:
                goToDetalle("Sistema de Transmisión");
                break;
        }
    }
}