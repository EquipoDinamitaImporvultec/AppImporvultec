package com.example.appimporvultec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.appimporvultec.MenuAdministrador.IngresoDatosAdministrador;
import com.example.appimporvultec.MenuAdministrador.PrincipalMenuAdministrador;
import com.example.appimporvultec.Models.User;
import com.example.appimporvultec.Utils.Apis;
import com.example.appimporvultec.Utils.Cliente;
import com.example.appimporvultec.Utils.UserService;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient googleApiClient;
    private SignInButton signInButton;
    public static final int SIGN_IN_CODE = 777;
    UserService userService = Apis.getPersonaService();
    List<User> listapersona = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        signInButton = (SignInButton) findViewById(R.id.signInButton);

        signInButton.setSize(SignInButton.SIZE_WIDE);
        signInButton.setColorScheme(SignInButton.COLOR_LIGHT);


        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent, SIGN_IN_CODE);
            }
        });
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SIGN_IN_CODE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }


    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            System.out.println("entro aqui");
            GoogleSignInAccount account = result.getSignInAccount();
            validarCorreo(account.getEmail());
            //goToDatos();
        } else {
            Toast.makeText(this, R.string.not_log_in, Toast.LENGTH_SHORT).show();
        }
    }

    public void validarCorreo(String correo){
        Call<List<User>> call=userService.getUsuarios();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                listapersona=response.body();
                System.out.println("Encontrados"+"\n"+response.code());

                for (int i = 0; i <response.body().size(); i++) {
                    System.out.println("entro al for");
                    if(!response.body().get(i).getEmail().equals(correo)){
                       // if(i==response.body().size()){
                            System.out.println("pasando a activity de registro");
                            goToDatos();

                    }else{
                        Call<User> call1=userService.findById(response.body().get(i).getId().intValue());
                        call1.enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {
                                if(response.isSuccessful()){
                                    if(response.body().getRol().equals("Administrador")){
                                        System.out.println("Lo logro amigo lo logro: "+"\n"+response.body().getName()+" "+response.body().getEmail());
                                        Intent intent = new Intent(getApplicationContext(), PrincipalMenuAdministrador.class);
                                        intent.putExtra("Correo", response.body().getEmail());
                                        intent.putExtra("Nombre", response.body().getName());
                                        intent.putExtra("Foto", response.body().getUrlFoto());
                                        startActivity(intent);
                                    }else {
                                        System.out.println("Lo logro amigo lo logro: " + "\n" + response.body().getName() + " " + response.body().getEmail());
                                        Intent intent = new Intent(getApplicationContext(), Principal_Menu.class);
                                        intent.putExtra("Correo", response.body().getEmail());
                                        intent.putExtra("Nombre", response.body().getName());
                                        intent.putExtra("Foto", response.body().getUrlFoto());
                                        startActivity(intent);
                                    }
                                }else{

                                    System.out.println(response.code());
                                    System.out.println("no bro lo siento");

                                }
                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {
                                Log.e("Error: ",t.toString());
                            }
                        });

                    }

                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                System.out.println("Falladooooooooooooo");
                Log.e("error: ",t.toString());

            }
        });

    }

    private void goToDatos() {
        Intent intent = new Intent(this, IngresoDatos.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Desea salir de Imporvultec?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
            builder.show();
        }
        return super.onKeyDown(keyCode, event);
    }
}