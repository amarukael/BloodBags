package com.amarukael.bloodbags;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Stok3Activity extends AppCompatActivity {

    Button tiket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stok3);
        tiket = findViewById(R.id.stok3_buton_aktif1);

        tiket.setOnClickListener(view -> {
            Intent intent = new Intent(Stok3Activity.this, TiketActivity.class);
            startActivity(intent);
        });
    }
}