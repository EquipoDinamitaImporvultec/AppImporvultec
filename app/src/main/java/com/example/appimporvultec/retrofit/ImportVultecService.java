package com.example.appimporvultec.retrofit;

import com.example.appimporvultec.Models.User;
import com.example.appimporvultec.retrofit.response.ResponseAuth;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

public interface ImportVultecService {

Call<List<User>> doLogin();

}
