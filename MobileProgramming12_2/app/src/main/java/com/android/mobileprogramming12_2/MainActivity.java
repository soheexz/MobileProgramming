package com.android.mobileprogramming12_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button btnPrev, btnNext;
    MyPicureView myPictureView;
    int curNum;
    File[] imageFiles;
    String imageFname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("이미지 뷰어어");

        btnPrev=findViewById(R.id.btnPerv);
        btnNext=findViewById(R.id.btnNext);
        myPictureView=findViewById(R.id.myPictureView1);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Pictures").listFiles();
        imageFname = imageFiles[0].toString();
        myPictureView.imagePath = imageFname;

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curNum<=0){
                    Toast.makeText(MainActivity.this, "첫번째 그림입니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    curNum--;
                    imageFname = imageFiles[curNum].toString();
                    myPictureView.imagePath = imageFname;
                    myPictureView.invalidate();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curNum>=imageFiles.length-2){
                    Toast.makeText(MainActivity.this, "마지막 그림입니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    curNum++;
                    imageFname = imageFiles[curNum].toString();
                    myPictureView.imagePath = imageFname;
                    myPictureView.invalidate();
                }
            }
        });
    }
}