package com.android.moblieprogramming9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("액티비티 테스트 예제");
        Log.i("액티비티 테스트","onCreate()");

        Button btnDial=findViewById(R.id.btnDial);
        Button btnFinish=findViewById(R.id.btnFinish);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("액티비티 테스트","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("액티비티 테스트","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("액티비티 테스트","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("액티비티 테스트","onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("액티비티 테스트","onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("액티비티 테스트","onDestroy()");
    }
}