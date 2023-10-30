package com.example.banksystem.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.banksystem.R;
import com.example.banksystem.Registration.RegistrationActivity;
import com.example.banksystem.data.model.RegisterRequest;
import com.example.banksystem.data.remote.ApiClient;

public class HomeActivity extends AppCompatActivity {
    TextView signup;
    EditText username, password;
//    ApiClient apiClient = new ApiClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        signupHandling();

        username=findViewById(R.id.et_username_login);
        password=findViewById(R.id.et_password_login);
//        apiClient.loginUser(username.toString(), password.toString());


    }


    public void signupHandling(){
        signup= findViewById(R.id.tv_signup);
        String signupText = getString(R.string.login_view_sign_up);
        SpannableString spannableString = new SpannableString(signupText);
        ClickableSpan signUpSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(getBaseContext(), RegistrationActivity.class);
                startActivity(intent);

            }
        };

        int signUpStart = signupText.indexOf("Sign up");
        int signUpEnd = signUpStart + "Sign up".length();
        spannableString.setSpan(signUpSpan, signUpStart, signUpEnd, 0);

        signup.setText(spannableString);
        signup.setMovementMethod(LinkMovementMethod.getInstance());
    }


}



