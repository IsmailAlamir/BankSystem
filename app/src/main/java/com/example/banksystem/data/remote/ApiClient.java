package com.example.banksystem.data.remote;

import static android.widget.Toast.LENGTH_LONG;

import android.util.Log;
import android.widget.Toast;

import com.example.banksystem.data.model.AuthTokenResponse;
import com.example.banksystem.data.model.LoginRequest;
import com.example.banksystem.data.model.RegisterRequest;
import com.example.banksystem.ui.Registration.RegistrationActivity;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
        private AuthService authService;

        public ApiClient() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:8000/")// TODO : change url
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            authService = retrofit.create(AuthService.class);
        }

        public void loginUser(LoginRequest loginRequest) {

            Call<LoginRequest> call = authService.login(loginRequest);

            call.enqueue(new Callback<LoginRequest>() {
                @Override
                public void onResponse(Call<LoginRequest> call, Response<LoginRequest> response) {
                    if (response.isSuccessful()) {
                        LoginRequest loginRequest = response.body();
                        //TODO : Store the authToken securely

                        Log.e("Login", "Successful"+ String.valueOf(response)) ;

//                        String authToken = authTokenResponse.getToken();
                    } else {
                        try {
                            String errorBody = response.errorBody().string();
                            Log.e("login", "Error response: " + errorBody);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<LoginRequest> call, Throwable t) {
                    Log.e("login ", String.valueOf(t)) ;
                }
            });
        }

    public void registerUser(RegisterRequest  registerRequest) {

        Call<RegisterRequest> call = authService.register(registerRequest);

        call.enqueue(new Callback<RegisterRequest>() {
            @Override
            public void onResponse(Call<RegisterRequest> call, Response<RegisterRequest> response) {
                if (response.isSuccessful()) {
                    RegisterRequest registerRequest = response.body();
                    //TODO : Store the authToken securely
                    Log.i("authTokenResponse", "Successful "+registerRequest) ;

                } else {
                    try {
                        // Log or display the error message
                        String errorBody = response.errorBody().string();
                        Log.e("authTokenResponse", "Error response: " + errorBody);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<RegisterRequest> call, Throwable t) {

            }

        });
    }

}


