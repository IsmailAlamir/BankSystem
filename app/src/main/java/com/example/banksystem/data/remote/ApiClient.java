package com.example.banksystem.data.remote;

import android.util.Log;

import com.example.banksystem.data.model.AuthTokenResponse;
import com.example.banksystem.data.model.LoginRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
         private AuthService authService;

        public ApiClient() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("base url") //TODO: Replace with your API base URL
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            authService = retrofit.create(AuthService.class);
        }

        public void loginUser(String username, String password) {
            LoginRequest loginRequest = new LoginRequest(username, password);

            Call<AuthTokenResponse> call = authService.login(loginRequest);
            call.enqueue(new Callback<AuthTokenResponse>() {
                @Override
                public void onResponse(Call<AuthTokenResponse> call, Response<AuthTokenResponse> response) {
                    if (response.isSuccessful()) {
                        AuthTokenResponse authTokenResponse = response.body();
                        //TODO: Store the authToken securely

//                        String authToken = authTokenResponse.getToken();
                    } else {
                        Log.e("authTokenResponse", "error in Response") ;
                    }
                }

                @Override
                public void onFailure(Call<AuthTokenResponse> call, Throwable t) {
                    // TODO: Handle network errors here
                }
            });
        }
    }


