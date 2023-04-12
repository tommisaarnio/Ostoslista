package com.tommisaarnio.ostoslista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;

        StuffStorage stuffStorage = StuffStorage.getInstance();

        stuffStorage.loadStuff(context);

        recyclerView = findViewById(R.id.rvList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new StuffListAdapter(getApplicationContext(), stuffStorage.getStuffList()));
    }



    public void switchToAdd(View view) {
        Intent intent = new Intent(this, activity_add.class);
        startActivity(intent);
    }
}