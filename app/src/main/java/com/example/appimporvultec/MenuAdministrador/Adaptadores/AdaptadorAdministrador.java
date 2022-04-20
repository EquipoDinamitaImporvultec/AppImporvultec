package com.example.appimporvultec.MenuAdministrador.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appimporvultec.Models.Productos;
import com.example.appimporvultec.R;

import java.util.List;

public class AdaptadorAdministrador extends ArrayAdapter<Productos> {

    private Context context;
    private List<Productos> productos;

    public AdaptadorAdministrador(@NonNull Context context, int resource, @NonNull List<Productos>productos) {
        super(context, resource, productos);

        this.context = context;
        this.productos = productos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.elemento_lista_productos, parent, false);
        TextView txtNom = (TextView) row.findViewById(R.id.tvTitulo);
        TextView txtDesc = (TextView) row.findViewById(R.id.tvContenido);
        TextView txtPre = (TextView) row.findViewById(R.id.tvPrecio);

        txtNom.setText(productos.get(position).getName());
        txtDesc.setText(productos.get(position).getDescription());
        txtPre.setText(productos.get(position).getPrice()+"");

        return row;
    }
}
