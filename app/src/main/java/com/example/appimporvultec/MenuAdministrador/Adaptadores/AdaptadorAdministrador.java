package com.example.appimporvultec.MenuAdministrador.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appimporvultec.MenuAdministrador.DetalleListarProductosAdministrador;
import com.example.appimporvultec.Models.Productos;
import com.example.appimporvultec.R;

import java.util.List;

public class AdaptadorAdministrador extends ArrayAdapter<Productos> {

    private Context context;
    private List<Productos> productos;
    private String aux, aux2, aux3;

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
        TextView txtID = (TextView) row.findViewById(R.id.tvID);
        TextView txtNom = (TextView) row.findViewById(R.id.tvTitulo);
        TextView txtDesc = (TextView) row.findViewById(R.id.tvContenido);
        TextView txtPre = (TextView) row.findViewById(R.id.tvPrecio);

        txtID.setText(productos.get(position).getId_producto()+"");
        txtNom.setText(productos.get(position).getName());
        txtDesc.setText(productos.get(position).getDescription());
        txtPre.setText(productos.get(position).getPrice()+"");

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetalleListarProductosAdministrador.class);
                intent.putExtra("ID", String.valueOf(productos.get(position).getId_producto()));
                intent.putExtra("Nombre", String.valueOf(productos.get(position).getName()));
                intent.putExtra("Descripcion", String.valueOf(productos.get(position).getDescription()));
                intent.putExtra("Precio", String.valueOf(productos.get(position).getPrice()));

                intent.putExtra("IDCAT", String.valueOf(productos.get(position).getId_categoria()));
                intent.putExtra("URLFOTO", String.valueOf(productos.get(position).getUrlFoto()));

                context.startActivity(intent);
            }
        });

        return row;
    }
}
