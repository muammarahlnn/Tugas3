package com.ardnn.tugas3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    TextView tvSignUp, tvForgotPassword;
    ImageView btnVisibilityPass;
    EditText etEmail, etPass;
    Button btnSignIn;
    CheckBox cbRememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            finish();
        }

        etEmail = findViewById(R.id.et_email);
        etPass = findViewById(R.id.et_pass);

        tvSignUp = findViewById(R.id.tv_signup);
        tvSignUp.setOnClickListener(this);

        tvForgotPassword = findViewById(R.id.tv_forgot_password);
        tvForgotPassword.setOnClickListener(this);

        btnVisibilityPass = findViewById(R.id.btn_visibility_pass);
        btnVisibilityPass.setOnClickListener(this);

        btnSignIn = findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener(this);

//        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
//        String checkbox = preferences.getString("remember", "");
//        if (checkbox.equals("true")) {
//            Intent goToHome = new Intent(LoginActivity.this, HomeActivity.class);
//            startActivity(goToHome);
//            finish();
//        } else if (checkbox.equals("false")) {
//            Toast.makeText(this, "Please Sign In", Toast.LENGTH_SHORT).show();
//        }
//
//        cbRememberMe = findViewById(R.id.cb_remember_me);
//        cbRememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (buttonView.isChecked()) {
//                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
//                    SharedPreferences.Editor editor = preferences.edit();
//                    editor.putString("remember", "true");
//                    editor.apply();
//                    Toast.makeText(LoginActivity.this, "Checked", Toast.LENGTH_SHORT).show();
//                } else if (!buttonView.isChecked()) {
//                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
//                    SharedPreferences.Editor editor = preferences.edit();
//                    editor.putString("remember", "false");
//                    editor.apply();
//                    Toast.makeText(LoginActivity.this, "Unchecked", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_visibility_pass:
                if (etPass.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                    ((ImageView)(v)).setImageResource(R.drawable.ic_hide_pass);
                    etPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    ((ImageView)(v)).setImageResource(R.drawable.ic_show_pass);
                    etPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            case R.id.tv_forgot_password:
                Intent goToForgotPassword = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(goToForgotPassword);
                break;
            case R.id.btn_sign_in:
                signIn();
                break;
            case R.id.tv_signup:
                Intent goToRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(goToRegister);
                finish();
                break;
        }
    }

    private void signIn() {
        String email = etEmail.getText().toString();
        String password = etPass.getText().toString();
        if (email.isEmpty()) {
            etEmail.setError("Please fill email field");
            etEmail.requestFocus();
        } else if (password.isEmpty()) {
            etPass.setError("Please fill password field");
            etPass.requestFocus();
        } else if (email.isEmpty() && password.isEmpty()) {
            etEmail.setError("Please fill empty field");
            etEmail.requestFocus();
        } else {
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Intent goToHome = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(goToHome);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Sign In failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}