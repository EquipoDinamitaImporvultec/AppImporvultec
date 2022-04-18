package com.example.appimporvultec.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Producto {

    public static Retrofit getProducto(String url){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url).addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
