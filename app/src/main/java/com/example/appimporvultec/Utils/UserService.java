package com.example.appimporvultec.Utils;

import com.example.appimporvultec.Models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {

    @GET("api/users/all")
    Call<List<User>> getUsuarios();

    @POST("api/users")
    Call<User> createUser(@Body User User);

    @GET("api/users/{id}")
    Call<User> findById(@Path("id") int id);
}
