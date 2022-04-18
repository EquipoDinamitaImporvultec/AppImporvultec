package com.example.appimporvultec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appimporvultec.MenuAdministrador.PrincipalMenuAdministrador;
import com.example.appimporvultec.Models.User;
import com.example.appimporvultec.Utils.Apis;
import com.example.appimporvultec.Utils.UserService;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IngresoDatos extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {

    private TextView nameTextView;
    private TextView emailTextView;
    private EditText cedula, telefono;
    private Button btnConfirmar;

    private GoogleApiClient googleApiClient;

    private String email, idgoogle, foto, nombre;

    private String Administrador = "Administrador";
    private String Cliente = "Cliente";

    UserService userService = Apis.getPersonaService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_datos);

        nameTextView = (TextView) findViewById(R.id.txtNombres);
        emailTextView = (TextView) findViewById(R.id.txtCorreo);
        cedula = (EditText) findViewById(R.id.editTextCedula);
        telefono = (EditText) findViewById(R.id.editTextCelular);

        btnConfirmar = findViewById(R.id.buttonConfirmar);

        btnConfirmar.setOnClickListener(this);

        //GOOGLE

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if (opr.isDone()){
            GoogleSignInResult result = opr.get();
            handleSignInResult(result);
        }else{
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                    handleSignInResult(googleSignInResult);
                }
            });
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();
            nameTextView.setText(account.getDisplayName());
            email = account.getEmail();
            foto = ""; //account.getPhotoUrl().toString();
            nombre = account.getDisplayName();
            idgoogle = account.getId();
            emailTextView.setText(account.getEmail());
            //System.setErr(account);
            System.out.println("//AQUI ESTA//" + account.getAccount());
            System.out.println("//AQUI ESTA//" + account.getId());
        }else{
            goMainScreen();
        }
    }

    public void crearUsuario(User user){

        Call<User> call=userService.createUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                System.out.println(response.code());

                if(response.isSuccessful()){

                    Toast.makeText(IngresoDatos.this, "Registro Guardado", Toast.LENGTH_SHORT).show();

                    System.out.println("Guardado exitoso");

                }else{

                    Toast.makeText(IngresoDatos.this, "Algo salio mal :(", Toast.LENGTH_SHORT).show();

                    System.out.println("fallo el guardado");
                }


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Error: ",t.toString());
            }
        });

    }

    public void Datos(){
        User u = new User();
        u.setCedula(cedula.getText().toString());
        u.setTelefono(telefono.getText().toString());
        u.setEmail(email);
        u.setName(nombre);
        u.setUrlFoto(foto);
        u.setIdgoogle(idgoogle);


        if (idgoogle.equals("102745581342295278748")){
            u.setRol(Administrador);
            goToPrincipalMenuAdmin();
        }else{
            u.setRol(Cliente);
            goToPrincipalMenu();
        }

        crearUsuario(u);

    }

    private void goMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void goToPrincipalMenu(){
        Intent intent = new Intent(IngresoDatos.this, Principal_Menu.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void goToPrincipalMenuAdmin(){
        Intent intent = new Intent(IngresoDatos.this, PrincipalMenuAdministrador.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.buttonConfirmar:
                Datos();
                break;
        }
    }
}