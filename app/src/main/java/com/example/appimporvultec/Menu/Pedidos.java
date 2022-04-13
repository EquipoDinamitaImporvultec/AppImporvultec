package com.example.appimporvultec.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.appimporvultec.R;

public class Pedidos extends AppCompatActivity {

    private ListView ListViewPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        ListViewPedidos = findViewById(R.id.listViewPedidos);
    }
}