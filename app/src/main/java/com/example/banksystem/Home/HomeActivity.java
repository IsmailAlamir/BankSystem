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
import android.widget.TextView;
import android.widget.Toast;

import com.example.banksystem.R;

public class HomeActivity extends AppCompatActivity {
    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        signup= findViewById(R.id.tv_signup);
        String signupText = getString(R.string.login_view_sign_up);
        SpannableString spannableString = new SpannableString(signupText);
        ClickableSpan signUpSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Log.i("testing sign up","done");
            }
        };

        int signUpStart = signupText.indexOf("Sign up");
        int signUpEnd = signUpStart + "Sign up".length();
        spannableString.setSpan(signUpSpan, signUpStart, signUpEnd, 0);

        signup.setText(spannableString);
        signup.setMovementMethod(LinkMovementMethod.getInstance());

    }

}

