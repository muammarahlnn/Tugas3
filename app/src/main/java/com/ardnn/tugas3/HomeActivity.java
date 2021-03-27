package com.ardnn.tugas3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
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

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rvDatas;
    private ArrayList<ProgrammingLanguage> list = new ArrayList<>();

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    View btnLogout;
    TextView tvFullname, tvEmail;
    String userId;
//    LinearLayout btnJava;


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

//        btnJava = findViewById(R.id.btn_java);
//        btnJava.setOnClickListener(this);

        DocumentReference documentReference = firebaseFirestore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                tvFullname.setText(value.getString("fullname"));
                tvEmail.setText(value.getString("email"));
            }
        });


        rvDatas = findViewById(R.id.rv_datas);
        rvDatas.setHasFixedSize(true);

        list.addAll(ProgrammingLanguagesData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvDatas.setLayoutManager(new LinearLayoutManager(this));
        ListProgrammingLanguageAdapter listDataAdapter = new ListProgrammingLanguageAdapter(list);
        rvDatas.setAdapter(listDataAdapter);

        listDataAdapter.setOnItemClickCallback(data -> {
            showSelecetedData(data);
        });
    }

    private void showSelecetedData(ProgrammingLanguage data) {
        Intent goToDetail = new Intent(HomeActivity.this, DetailActivity.class);
        goToDetail.putExtra(DetailActivity.EXTRAS[0], data.getName());
        goToDetail.putExtra(DetailActivity.EXTRAS[1], data.getCreator());
        goToDetail.putExtra(DetailActivity.EXTRAS[2], data.getDesc());
        goToDetail.putExtra(DetailActivity.EXTRAS[3], data.getImage());
        startActivity(goToDetail);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_logout:
                Toast.makeText(this, "Sign Out", Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();
                Intent backToLogin = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(backToLogin);
                finish();
                break;
//            case R.id.btn_java:
//                Intent goToJava = new Intent(HomeActivity.this, JavaActivity.class);
//                startActivity(goToJava);
//                break;
        }
    }
}