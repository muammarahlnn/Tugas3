package com.ardnn.tugas3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String[] EXTRAS = {
            "extra_name",
            "extra_creator",
            "extra desc",
            "extra_image"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView[] tvDataDetail = {
                findViewById(R.id.tv_datas_name),
                findViewById(R.id.tv_datas_creator),
                findViewById(R.id.tv_datas_desc),
        };

        for (int i = 0; i < EXTRAS.length - 1; i++) {
            tvDataDetail[i].setText(getIntent().getStringExtra(EXTRAS[i]));
        }

        ImageView datasImage = (ImageView) findViewById(R.id.img_datas_detail);
        datasImage.setImageResource(getIntent().getIntExtra(EXTRAS[EXTRAS.length-1], 0));
    }
}