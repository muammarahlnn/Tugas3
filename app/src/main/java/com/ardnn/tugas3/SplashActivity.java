package com.ardnn.tugas3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // set timer for 1 second
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // go to LoginActivity
                Intent goToLoginActivity = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(goToLoginActivity);
                finish();
            }
        }, 1200);
    }
}