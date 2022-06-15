package com.amarukael.bloodbags;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.amarukael.bloodbags.Adapter.BlogdashAdapter;
import com.amarukael.bloodbags.Model.BlogdashModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int[] myImageList = new int[]{R.drawable.blog,R.drawable.blog,R.drawable.blog};
    private final String[] myImageNameList = new String[]{"PMI Sleman: Ayo Donor,  kita seha...","" +
            "PMI Sleman: Ayo Donor,  kita seha..." ,"PMI Sleman: Ayo Donor,  kita seha..."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        RecyclerView recyclerView = findViewById(R.id.recycler);

        ArrayList<BlogdashModel> imageModelArrayList = testdash();
        BlogdashAdapter adapter = new BlogdashAdapter(this, imageModelArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

       LinearLayout clickstock = findViewById(R.id.stok);

        clickstock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Stok1Activity.class);
                startActivity(intent);
            }
        });

    }

    private ArrayList<BlogdashModel> testdash(){

        ArrayList<BlogdashModel> list = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            BlogdashModel dahsModel = new BlogdashModel();
            dahsModel.setName(myImageNameList[i]);
            dahsModel.setImage_drawable(myImageList[i]);
            list.add(dahsModel);
        }

        return list;
    }
}