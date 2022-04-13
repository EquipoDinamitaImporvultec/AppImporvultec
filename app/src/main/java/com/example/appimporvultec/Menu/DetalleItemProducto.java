package com.example.appimporvultec.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appimporvultec.R;

public class DetalleItemProducto extends AppCompatActivity {

    private Pruba Item;
    private ImageView imagenDetalleProducto;
    private TextView TituloDetalleProducto, DescripcionDetalleProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_item_producto);

        Item = (Pruba) getIntent().getSerializableExtra("objectoData");

        imagenDetalleProducto = (ImageView) findViewById(R.id.imgDetalleItemProducto);
        TituloDetalleProducto = (TextView) findViewById(R.id.TituloDetalleProducto);
        DescripcionDetalleProducto = (TextView) findViewById(R.id.DescripcionDetalleProducto);

        TituloDetalleProducto.setText(Item.getTitulo());
        DescripcionDetalleProducto.setText(Item.getContenido());
        imagenDetalleProducto.setImageResource(Item.getImgfoto());
    }
}