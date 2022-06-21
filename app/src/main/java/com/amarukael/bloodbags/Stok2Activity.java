package com.amarukael.bloodbags;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Stok2Activity extends AppCompatActivity {

    Button pesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stok2);

        pesan = findViewById(R.id.pesan_stok2);

        pesan.setOnClickListener(view -> {
            Intent intent = new Intent(Stok2Activity.this, Stok3Activity.class);
            startActivity(intent);
        });

    }
}