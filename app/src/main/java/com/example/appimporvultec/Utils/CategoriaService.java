package com.example.appimporvultec.Utils;

import com.example.appimporvultec.Models.Categoria;
import com.example.appimporvultec.Models.Productos;
import com.example.appimporvultec.Models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CategoriaService {

    @GET("api/category/all")
    Call<List<Categoria>> getCategorias();

    @POST("api/category")
    Call<Categoria> createCategoria(@Body Categoria categoria);

    @GET("api/category/{id}")
    Call<Categoria> findById(@Path("id") int id);

}
