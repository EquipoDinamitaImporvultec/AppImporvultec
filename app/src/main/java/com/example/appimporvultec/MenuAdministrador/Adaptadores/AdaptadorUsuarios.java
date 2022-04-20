package com.example.appimporvultec.MenuAdministrador.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appimporvultec.Models.User;
import com.example.appimporvultec.R;

import java.util.List;

public class AdaptadorUsuarios extends ArrayAdapter<User>{

    private Context context;
    private List<User> users;

    public AdaptadorUsuarios(@NonNull Context context, int resource, @NonNull List<User>users) {
        super(context, resource, users);

        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.elemento_lista_usuario, parent, false);
        TextView txtNombre = (TextView) row.findViewById(R.id.tvNombreUsuario);
        TextView txtCorreo = (TextView) row.findViewById(R.id.tvCorreoUsuario);

        txtNombre.setText(users.get(position).getName());
        txtCorreo.setText(users.get(position).getEmail());

        return row;
    }
}
