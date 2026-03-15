package com.android.mobileprogramming11_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, createItemList());
        recyclerView.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//      layoutManager.setOrientation(LinearLayoutManager.VERTICAL)
//    recyclerView.setLayoutManager(layoutManager);
    }

    private List<String> createItemList(){
        List<String> items = new ArrayList<>();
        for(int i=0; i<20; i++){
            items.add("아이템 : " + i);
        }
        return items;
    }
}