package com.android.mobileprogramming14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("life-Activity","onCreate");

        Fragment1 fragment1 = new Fragment1();

        getSupportFragmentManager().beginTransaction().replace(R.id.rootlayout,fragment1).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("life-Activity","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("life-Activity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("life-Activity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("life-Activity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("life-Activity","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("life-Activity","onRestart");
    }
}