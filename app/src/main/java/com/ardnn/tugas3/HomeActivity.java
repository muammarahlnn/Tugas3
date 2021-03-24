package com.ardnn.tugas3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    View btnLogout;
    TextView tvFullname, tvEmail;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        userId = firebaseAuth.getCurrentUser().getUid();

        tvFullname = findViewById(R.id.tv_fullname);
        tvEmail = findViewById(R.id.tv_email);

        btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(this);

        DocumentReference documentReference = firebaseFirestore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                tvFullname.setText(value.getString("fullname"));
                tvEmail.setText(value.getString("email"));
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_logout:
                FirebaseAuth.getInstance().signOut();
                Intent backToLogin = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(backToLogin);
                finish();
                break;
        }
    }
}