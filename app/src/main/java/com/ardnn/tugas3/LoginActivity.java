package com.ardnn.tugas3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView btnVisibilityPass;
    EditText etPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnVisibilityPass = findViewById(R.id.btn_visibility_pass);
        btnVisibilityPass.setOnClickListener(this);

        etPass = findViewById(R.id.et_pass);
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
        }
    }
}