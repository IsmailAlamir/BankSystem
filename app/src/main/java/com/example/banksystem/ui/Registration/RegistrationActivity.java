package com.example.banksystem.ui.Registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.banksystem.ui.Login.LoginActivity;
import com.example.banksystem.R;

public class RegistrationActivity extends AppCompatActivity {
    TextView signIn;
    Button signup;
    EditText firstname,lastname, idNumber, phone, password, confirm, email, username;
    CheckBox checkBox;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        signIn=findViewById(R.id.tv_sign_in);
        signup=findViewById(R.id.signup_button);
        firstname=findViewById(R.id.et_firstname_register);
        lastname=findViewById(R.id.et_lastname_register);
        idNumber=findViewById(R.id.et_id_number_register);
        phone=findViewById(R.id.et_phone_number_register);
        password=findViewById(R.id.et_password_register);
        confirm=findViewById(R.id.et_confirm_password_register);
        email=findViewById(R.id.et_email_register);
        username=findViewById(R.id.et_username_register);
        checkBox=findViewById(R.id.ch_confirm);

        signInHandling();

    }

    public void signInHandling(){
        signIn= findViewById(R.id.tv_sign_in);
        String signInText = getString(R.string.have_an_account);
        SpannableString spannableString = new SpannableString(signInText);
        ClickableSpan signUpSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intent);

            }
        };

        int signUpStart = signInText.indexOf("Sign In");
        int signUpEnd = signUpStart + "Sign In".length();
        spannableString.setSpan(signUpSpan, signUpStart, signUpEnd, 0);

        signIn.setText(spannableString);
        signIn.setMovementMethod(LinkMovementMethod.getInstance());
    }


}