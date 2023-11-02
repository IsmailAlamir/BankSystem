package com.example.banksystem.ui.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.banksystem.R;
import com.example.banksystem.ui.Home.HomeActivity;
import com.example.banksystem.ui.MainActivity;
import com.example.banksystem.ui.Registration.RegistrationActivity;

public class LoginActivity extends AppCompatActivity {
    TextView signup;
    EditText username, password;
    Button loginBtn;
//    ApiClient apiClient = new ApiClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signupHandling();

        username=findViewById(R.id.et_username_login);
        password=findViewById(R.id.et_password_login);
        loginBtn=findViewById(R.id.login_button);
//        apiClient.loginUser(username.toString(), password.toString());

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                startActivity(intent);

            }
        });



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



