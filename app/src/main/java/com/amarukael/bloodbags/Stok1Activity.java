package com.amarukael.bloodbags;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.amarukael.bloodbags.Adapter.StokAdapter;
import com.amarukael.bloodbags.Model.StokModel;

import java.util.ArrayList;

public class Stok1Activity extends AppCompatActivity {

    int[] gambarrs = new int[]{R.drawable.rs1, R.drawable.rs2,R.drawable.rs1,R.drawable.rs2,R.drawable.rs1};
    int[] jarakrs = new int[]{1, 2,3,4,5};
    int[] stok = new int[]{123, 234,345,456,567};
    String[] namars = new String[]{"PMI Yogyakarta","JIH Hospital","PMI Yogyakarta","JIH Hospital","PMI Yogyakarta"};
    String[] jalanrs = new String[]{"JL. Ring Road Utara...","JL. Ring Road Utara...","JL. Ring Road Utara...",
            "JL. Ring Road Utara...","JL. Ring Road Utara..."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stok1);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        RecyclerView recyclerView = findViewById(R.id.stokrecycler);

        ArrayList<StokModel> imageModelStok = stok();
        StokAdapter adapter = new StokAdapter(this, imageModelStok);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }

    private ArrayList<StokModel> stok() {
        ArrayList<StokModel> list = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            StokModel stokModel = new StokModel();
            stokModel.setNamars(namars[i]);
            stokModel.setStok(stok[i]);
            stokModel.setJalanrs(jalanrs[i]);
            stokModel.setJarakrs(jarakrs[i]);
            stokModel.setGambarrs(gambarrs[i]);
            list.add(stokModel);
        }

        return list;
    }
}