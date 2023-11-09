package com.example.banksystem.data.remote;

import android.util.Log;

import com.example.banksystem.data.model.AuthTokenResponse;
import com.example.banksystem.data.model.LoginRequest;
import com.example.banksystem.data.model.RegisterRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
        private AuthService authService;

        public ApiClient() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://8000-tareqzoubii-banksystem-dgubkvjxx62.ws-us106.gitpod.io/")// TODO : change url
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
                        Log.e("authTokenResponse", String.valueOf(response)) ;

//                        String authToken = authTokenResponse.getToken();
                    } else {
                        Log.e("authTokenResponse",call+ String.valueOf(response)) ;
                    }
                }

                @Override
                public void onFailure(Call<LoginRequest> call, Throwable t) {
                    // TODO: Handle network errors here
                }
            });
        }



    public void registerUser(RegisterRequest  registerRequest) {

        Call<RegisterRequest> call = authService.register(registerRequest);
        Log.i("authTokenResponsePassed", registerRequest.toString()) ;

        call.enqueue(new Callback<RegisterRequest>() {
            @Override
            public void onResponse(Call<RegisterRequest> call, Response<RegisterRequest> response) {
                if (response.isSuccessful()) {
                    RegisterRequest registerRequest = response.body();
                    //TODO : Store the authToken securely
                    Log.i("authTokenResponse", "Successful"+registerRequest) ;

                } else {
                    Log.e("authTokenResponse", "error in Response"+response) ;
                }
            }

            @Override
            public void onFailure(Call<RegisterRequest> call, Throwable t) {

            }

        });
    }

}


