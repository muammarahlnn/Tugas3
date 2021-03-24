package com.ardnn.tugas3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "TAG";

    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    TextView tvSignIn;
    ImageView btnVisibilityPass;
    EditText etFullname, etEmail, etPass;
    Button btnSignUp;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            finish();
        }

        firebaseFirestore = FirebaseFirestore.getInstance();

        etFullname = findViewById(R.id.et_fullname);
        etEmail = findViewById(R.id.et_email);
        etPass = findViewById(R.id.et_pass);

        tvSignIn = findViewById(R.id.tv_signin);
        tvSignIn.setOnClickListener(this);

        btnSignUp = findViewById(R.id.btn_sign_up);
        btnSignUp.setOnClickListener(this);

        btnVisibilityPass = findViewById(R.id.btn_visibility_pass);
        btnVisibilityPass.setOnClickListener(this);
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
            case R.id.tv_signin:
                Intent goToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(goToLogin);
                finish();
                break;
            case R.id.btn_sign_up:
                signUp();
                break;
        }
    }

    private void signUp() {
        String fullname = etFullname.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPass.getText().toString();

        if (fullname.isEmpty()) {
            etFullname.setError("Please fill fullname field");
            etFullname.requestFocus();
        } else if (email.isEmpty()) {
            etEmail.setError("Please fill email field");
            etEmail.requestFocus();
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmail.setError("Please fill a valid email");
            etEmail.requestFocus();
        } else if (password.isEmpty()) {
            etPass.setError("Please fill password field");
            etPass.requestFocus();
        } else if (email.isEmpty() && password.isEmpty() && fullname.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Please fill empty field", Toast.LENGTH_SHORT).show();
            etFullname.requestFocus();
        } else {
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // input user's data to firestore database
                        userId = firebaseAuth.getCurrentUser().getUid();
                        DocumentReference documentReference = firebaseFirestore.collection("users").document(userId);

                        Map<String, Object> userMap = new HashMap<>();
                        userMap.put("fullname", fullname);
                        userMap.put("email", email);
                        documentReference.set(userMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(RegisterActivity.this, "Sign Up successfully", Toast.LENGTH_SHORT).show();
                                Log.d(TAG, "onSuccess: User successfully creater for " + userId);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d(TAG, "onFailuer: " + e.toString());
                            }
                        });

                        Intent goToHome = new Intent(RegisterActivity.this, HomeActivity.class);
                        startActivity(goToHome);
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Sign Up failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
}