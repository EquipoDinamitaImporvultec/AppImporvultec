package com.example.appimporvultec.MenuAdministrador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import com.example.appimporvultec.MenuAdministrador.Adaptadores.AdaptadorUsuarios;
import com.example.appimporvultec.Models.Productos;
import com.example.appimporvultec.Models.User;
import com.example.appimporvultec.R;
import com.example.appimporvultec.Utils.Apis;
import com.example.appimporvultec.Utils.UserService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListarUsuarios extends AppCompatActivity {

    List<User> users = new ArrayList<User>();
    ListView listViewUser = null;
    AdaptadorUsuarios adapter = null;
    private UserService userService = Apis.getPersonaService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuarios);

        adapter = new AdaptadorUsuarios(this, R.layout.elemento_lista_usuario, users);
        listViewUser = (ListView) findViewById(R.id.listViewListarUser);
        listViewUser.setAdapter(adapter);
        cargarUsuarios();

    }

    public void cargarUsuarios(){
        Call<List<User>> call = userService.getUsuarios();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> data = response.body();
                users.addAll(data);
                System.out.println(response.body().get(1).getEmail());
                adapter.notifyDataSetChanged();
                System.out.println("MUESTRATE");
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }

}