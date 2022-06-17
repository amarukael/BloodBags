package com.amarukael.bloodbags;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amarukael.bloodbags.Adapter.BlogdashAdapter;
import com.amarukael.bloodbags.Model.BlogdashModel;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<BlogdashModel> blogdashModelList;
    private static final String PATTERN_FORMAT = "dd-MM-yyyy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = VolleyClient.getmInstance(MainActivity.this).getRequestQueue();
        blogdashModelList = new ArrayList<>();
        fetchAricle();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
       LinearLayout clickstock = findViewById(R.id.stok);

        clickstock.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Stok1Activity.class);
            startActivity(intent);
        });

    }

    private void fetchAricle() {
        String url = "https://test-1.grisel0.repl.co";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT)
                .withZone(ZoneId.systemDefault());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, response -> {
                    try {
                        JSONArray jsonArray = response.getJSONArray("articles");
                        for (int i = 0; i < 5; i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String title = jsonObject.getString("title");
                            Instant instant = Instant.parse(jsonObject.getString("publishedAt"));
                            String date = formatter.format(instant);
                            String image = jsonObject.getString("urlToImage");

                            BlogdashModel blogdashModel = new BlogdashModel(title, date, image);
                            blogdashModelList.add(blogdashModel);
                        }
                        BlogdashAdapter adapter = new BlogdashAdapter(MainActivity.this,blogdashModelList);
                        recyclerView.setAdapter(adapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
                    // TODO: Handle error
                });

        requestQueue.add(jsonObjectRequest);
    }

}