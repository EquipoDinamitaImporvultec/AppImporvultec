package com.example.appimporvultec.Menu;

import android.content.Context;
import android.content.Entity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appimporvultec.R;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private Context context;
    private ArrayList<Pruba> listItems;

    public Adaptador(Context context, ArrayList<Pruba> listItems) {
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

        Pruba item = (Pruba) getItem(i);

        view = LayoutInflater.from(context).inflate(R.layout.elemento_lista_productos, null);
        //ImageView imgFoto = view.findViewById(R.id.imgFoto);
        TextView lvTitulo = view.findViewById(R.id.tvTitulo);
        TextView lvDescripcion = view.findViewById(R.id.tvContenido);

        //imgFoto.setImageResource(item.getImgfoto());
        lvTitulo.setText(item.getTitulo());
        lvDescripcion.setText(item.getContenido());

        return view;
    }
}
