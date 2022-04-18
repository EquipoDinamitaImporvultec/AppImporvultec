package com.example.appimporvultec.MenuAdministrador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appimporvultec.Models.Productos;
import com.example.appimporvultec.R;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private Context context;
    private ArrayList<Productos> listItems;

    public Adaptador(Context context, ArrayList<Productos> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Productos item = (Productos) getItem(i);

        view = LayoutInflater.from(context).inflate(R.layout.elemento_lista_productos, null);

        TextView lvTitulo = view.findViewById(R.id.tvTitulo);
        TextView lvDescripcion = view.findViewById(R.id.tvContenido);
        TextView lvPrecio = view.findViewById(R.id.tvPrecio);


        lvTitulo.setText(item.getName());
        lvDescripcion.setText(item.getDescription());
        lvPrecio.setText(item.getPrice()+"");

        return view;
    }
}
