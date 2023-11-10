package com.example.banksystem.ui.Registration;

import static android.widget.Toast.LENGTH_LONG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.banksystem.data.model.AuthTokenResponse;
import com.example.banksystem.data.model.LoginRequest;
import com.example.banksystem.data.model.RegisterRequest;
import com.example.banksystem.data.remote.ApiClient;
import com.example.banksystem.data.remote.AuthService;
import com.example.banksystem.ui.Login.LoginActivity;
import com.example.banksystem.R;

import retrofit2.Call;

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


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiClient apiClient=new ApiClient();
//                RegisterRequest user = new RegisterRequest(
//                        "username",
//                        "email@email.com",
//                        "password",
//                        "first_name",
//                        "last_name",
//                        "1234567890",
//                        "1234567890",
//                        null,
//                        null);


                RegisterRequest user = new RegisterRequest(
                        username.getText().toString(),
                        email.getText().toString(),
                        password.getText().toString(),
                        firstname.getText().toString(),
                        lastname.getText().toString(),
                        idNumber.getText().toString(),
                        phone.getText().toString(),
                        null,
                        null);


                apiClient.registerUser(user);

            }

        });




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