package com.example.appimporvultec.Utils;

import com.example.appimporvultec.Models.Productos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProductService {

    @GET("api/products/all")
    Call<List<Productos>> getProductos();

    @POST("api/products")
    Call<Productos> createProductosCall(@Body Productos productos);
}
