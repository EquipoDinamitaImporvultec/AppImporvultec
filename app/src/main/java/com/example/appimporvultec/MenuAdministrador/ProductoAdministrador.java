package com.example.appimporvultec.MenuAdministrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.appimporvultec.Menu.DetalleProducto;
import com.example.appimporvultec.Models.Categoria;
import com.example.appimporvultec.R;
import com.example.appimporvultec.Utils.Apis;
import com.example.appimporvultec.Utils.CategoriaService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductoAdministrador extends AppCompatActivity implements View.OnClickListener{


    private Button OpAccesorios, OpSistemaElectrico, OpSistemaFrenos, OpLlantas, OpLubricantes, OpFiltros, OpMotor, OpTransmision;
    public TextView textoAccesorios;
    CategoriaService categoriaService= Apis.getCategoriaService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_administrador);

        textoAccesorios = findViewById(R.id.textViewTituloPro);

        OpAccesorios = findViewById(R.id.btnAccesorios_A);
        OpSistemaElectrico = findViewById(R.id.btnSistemaElectrico_A);
        OpSistemaFrenos = findViewById(R.id.btnSistemaFrenos_A);
        OpLlantas = findViewById(R.id.btnLlantas_A);
        OpLubricantes = findViewById(R.id.btnLubricantes_A);
        OpFiltros = findViewById(R.id.btnFiltros_A);
        OpMotor = findViewById(R.id.btnMotor_A);
        OpTransmision = findViewById(R.id.btnTransmision_A);

        OpAccesorios.setOnClickListener(this);
        OpSistemaElectrico.setOnClickListener(this);
        OpSistemaFrenos.setOnClickListener(this);
        OpLlantas.setOnClickListener(this);
        OpLubricantes.setOnClickListener(this);
        OpFiltros.setOnClickListener(this);
        OpMotor.setOnClickListener(this);
        OpTransmision.setOnClickListener(this);


        crearCategorias();

    }
    private void goToDetalle(String i){
        Intent intent = new Intent(getApplicationContext(), DetalleProductorAdministrador.class);
        intent.putExtra("titulo", i);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnAccesorios_A:
                goToDetalle("Accesorios");
                break;
            case R.id.btnSistemaElectrico_A:
                goToDetalle("Sistema Eléctrico");
                break;
            case R.id.btnSistemaFrenos_A:
                goToDetalle("Sistema de Frenos");
                break;
            case R.id.btnLlantas_A:
                goToDetalle("Llantas");
                break;
            case R.id.btnLubricantes_A:
                goToDetalle("Lubricantes");
                break;
            case R.id.btnFiltros_A:
                goToDetalle("Filtros");
                break;
            case R.id.btnMotor_A:
                goToDetalle("Sistema de Motor");
                break;
            case R.id.btnTransmision_A:
                goToDetalle("Sistema de Transmisión");
                break;
        }
    }

    public void crearCategorias(){

        Call<List<Categoria>> call0=categoriaService.getCategorias();
        call0.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {



                if(response.isSuccessful()){

                    if(response.body().size()==0){
                        System.out.println("Esta creando las categorias en la ventana del administrador");
                        Categoria categoria=new Categoria();
                        categoria.setCategoryName("Accesorios");
                        Call<Categoria> call70=categoriaService.createCategoria(categoria);
                        call70.enqueue(new Callback<Categoria>() {
                            @Override
                            public void onResponse(Call<Categoria> call, Response<Categoria> response) {

                                if(response.isSuccessful()){
                                    System.out.println("Creado 1");
                                }

                            }

                            @Override
                            public void onFailure(Call<Categoria> call, Throwable t) {

                            }
                        });

                        Categoria categoria1=new Categoria();
                        categoria1.setCategoryName("Sistema Eléctrico");
                        Call<Categoria> call2=categoriaService.createCategoria(categoria1);
                        call2.enqueue(new Callback<Categoria>() {
                            @Override
                            public void onResponse(Call<Categoria> call, Response<Categoria> response) {

                                if(response.isSuccessful()){
                                    System.out.println("Creado 2");
                                }

                            }

                            @Override
                            public void onFailure(Call<Categoria> call, Throwable t) {

                            }
                        });

                        Categoria categoria3=new Categoria();
                        categoria3.setCategoryName("Sistema de Frenos");
                        Call<Categoria> call3=categoriaService.createCategoria(categoria3);
                        call3.enqueue(new Callback<Categoria>() {
                            @Override
                            public void onResponse(Call<Categoria> call, Response<Categoria> response) {

                                if(response.isSuccessful()){
                                    System.out.println("Creado 3");
                                }

                            }

                            @Override
                            public void onFailure(Call<Categoria> call, Throwable t) {

                            }
                        });Categoria categoria4=new Categoria();
                        categoria4.setCategoryName("Llantas");
                        Call<Categoria> call4=categoriaService.createCategoria(categoria4);
                        call4.enqueue(new Callback<Categoria>() {
                            @Override
                            public void onResponse(Call<Categoria> call, Response<Categoria> response) {

                                if(response.isSuccessful()){}
                                System.out.println("Creado 4");
                            }

                            @Override
                            public void onFailure(Call<Categoria> call, Throwable t) {

                            }
                        });

                        Categoria categoria5=new Categoria();
                        categoria5.setCategoryName("Lubricantes");
                        Call<Categoria> call5=categoriaService.createCategoria(categoria5);
                        call5.enqueue(new Callback<Categoria>() {
                            @Override
                            public void onResponse(Call<Categoria> call, Response<Categoria> response) {

                                if(response.isSuccessful()){
                                    System.out.println("Creado 5");
                                }

                            }

                            @Override
                            public void onFailure(Call<Categoria> call, Throwable t) {

                            }
                        });

                        Categoria categoria6=new Categoria();
                        categoria6.setCategoryName("Filtros");
                        Call<Categoria> call6=categoriaService.createCategoria(categoria6);
                        call6.enqueue(new Callback<Categoria>() {
                            @Override
                            public void onResponse(Call<Categoria> call, Response<Categoria> response) {

                                if(response.isSuccessful()){
                                    System.out.println("Creado 6");
                                }

                            }

                            @Override
                            public void onFailure(Call<Categoria> call, Throwable t) {

                            }
                        });

                        Categoria categoria7=new Categoria();
                        categoria7.setCategoryName("Sistema de Motor");
                        Call<Categoria> call7=categoriaService.createCategoria(categoria7);
                        call7.enqueue(new Callback<Categoria>() {
                            @Override
                            public void onResponse(Call<Categoria> call, Response<Categoria> response) {

                                if(response.isSuccessful()){
                                    System.out.println("Creado 7");
                                }

                            }

                            @Override
                            public void onFailure(Call<Categoria> call, Throwable t) {

                            }
                        });

                        Categoria categoria8=new Categoria();
                        categoria8.setCategoryName("Sistema de Transmisión");
                        Call<Categoria> call8=categoriaService.createCategoria(categoria8);
                        call8.enqueue(new Callback<Categoria>() {
                            @Override
                            public void onResponse(Call<Categoria> call, Response<Categoria> response) {

                                if(response.isSuccessful()){
                                    System.out.println("Creado 8");
                                }

                            }

                            @Override
                            public void onFailure(Call<Categoria> call, Throwable t) {

                            }
                        });


                    }else{

                        System.out.println("Ya estan creados todos los que deben de estar creados");

                    }


                }





            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {

            }
        });













    };

}