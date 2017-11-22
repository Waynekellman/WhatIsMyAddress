package com.nyc.whatismyaddress;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nyc.whatismyaddress.controller.RecyclerAdapter;
import com.nyc.whatismyaddress.model.RecyclerModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecyclerActivity extends AppCompatActivity {

    private static final String SHARED_PREFS_KEY = "address_shared_preferences";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.email_recyclerview);
        sharedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        Map<String, ?> allEntry = sharedPreferences.getAll();
        List<RecyclerModel> emails = new ArrayList<>();
        for (Map.Entry<String, ?> entry: allEntry.entrySet()) {
            emails.add(new RecyclerModel(entry.getValue().toString()));
        }

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(emails);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

    }
}
