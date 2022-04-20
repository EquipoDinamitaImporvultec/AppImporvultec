package com.example.appimporvultec.MenuAdministrador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.appimporvultec.MainActivity;
import com.example.appimporvultec.Menu.Chat;
import com.example.appimporvultec.Menu.Pedidos;
import com.example.appimporvultec.Menu.Producto;
import com.example.appimporvultec.Menu.Soporte;
import com.example.appimporvultec.Principal_Menu;
import com.example.appimporvultec.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import org.jetbrains.annotations.NotNull;

public class PrincipalMenuAdministrador extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {

    private ImageView photoImageView;
    private TextView nameTextView;
    private TextView emailTextView;
    private Button btnProductos, btnPedidos, btnChats, btnSoporte;

    ViewFlipper v_flipper;

    private GoogleApiClient googleApiClient;
    private Soporte sop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_menu_administrador);


        photoImageView = (ImageView) findViewById(R.id.photoimageView_A);
        nameTextView = (TextView) findViewById(R.id.nametextView_A);
        emailTextView = (TextView) findViewById(R.id.emailtextView_A);

        //CARRUSEL
        int images[] = {R.drawable.carruselejemplo1, R.drawable.carruselejemplo2, R.drawable.carruselejemplo3};
        v_flipper = findViewById(R.id.Carrusel);
        for (int image: images){
            Carrusel(image);
        }

        //BOTONES
        btnProductos = findViewById(R.id.OpcionProductos_A);
        btnPedidos = findViewById(R.id.OpcionPedidos_A);
        btnChats = findViewById(R.id.OpcionChats_A);
        btnSoporte = findViewById(R.id.OpcionUsuarios);

        btnProductos.setOnClickListener(this);
        btnPedidos.setOnClickListener(this);
        btnChats.setOnClickListener(this);
        btnSoporte.setOnClickListener(this);

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
            emailTextView.setText(account.getEmail());
            //System.setErr(account);
            System.out.println("//AQUI ESTA//" + account.getAccount());
            System.out.println("//AQUI ESTA//" + account.getId());
            Glide.with(this).load(account.getPhotoUrl()).into(photoImageView);
        }else{
            goMainScreen();
        }
    }

    private void goMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    //CERRAR SESION
    public void logOut(View view){
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull @NotNull Status status) {
                if (status.isSuccess()){
                    goMainScreen();
                    Toast.makeText(getApplicationContext(), "Cierre de Sesión", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), R.string.no_cierre_sesion, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void goToProductos(){
        Intent intent = new Intent(getApplicationContext(), ProductoAdministrador.class);
        startActivity(intent);
    }

    private void goToPedidos(){
        Intent intent = new Intent(getApplicationContext(), Pedidos.class);
        startActivity(intent);
    }

    private void goToChats(){
        Intent intent = new Intent(getApplicationContext(), Chat.class);
        startActivity(intent);
    }

    private void goToUsuarios(){
        Intent intent = new Intent(getApplicationContext(), ListarUsuarios.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.OpcionProductos_A:
                goToProductos();
                break;
            case R.id.OpcionPedidos:
                goToPedidos();
                break;
            case R.id.OpcionChats:
                goToChats();
                break;
            case R.id.OpcionUsuarios:
                goToUsuarios();
                break;
        }
    }

    public void Carrusel(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000);
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==event.KEYCODE_BACK){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Desea salir de Imporvultec?")
                    .setPositiveButton("SI", new DialogInterface.OnClickListener() {
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


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }

}