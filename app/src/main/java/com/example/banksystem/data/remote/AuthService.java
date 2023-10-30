package com.example.banksystem.data.remote;

import com.example.banksystem.data.model.AuthTokenResponse;
import com.example.banksystem.data.model.LoginRequest;
import com.example.banksystem.data.model.RegisterRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {
    @POST("login") //TODO : Replace with the actual endpoint URL
    Call<AuthTokenResponse> login(@Body LoginRequest request);

    @POST("register") //TODO : Replace with the actual endpoint URL
    Call<AuthTokenResponse> register(@Body RegisterRequest request);

}
