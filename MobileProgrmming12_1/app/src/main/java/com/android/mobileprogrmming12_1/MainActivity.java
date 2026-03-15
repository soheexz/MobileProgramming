package com.android.mobileprogrmming12_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRead = findViewById(R.id.btnRead);
        EditText edtSD =findViewById(R.id.edtSD);
        Button btnMkdir = findViewById(R.id.btnMkdir);
        Button btnRmdir =findViewById(R.id.btnRmdir);

        Button btnFilelist = findViewById(R.id.btnFilelist);
        EditText edtFilelist =findViewById(R.id.edtFilelist);

        btnFilelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sysDir =Environment.getRootDirectory().getAbsolutePath();
                File[] sysFiles =new File(sysDir).listFiles();

                String strFname;

                for(int i=0; i<sysFiles.length; i++){
                    if(sysFiles[i].isDirectory()==true){
                        strFname = "<폴더>" + sysFiles[i].toString();
                    }
                    else{
                        strFname = "<파일>" + sysFiles[i].toString();

                        edtFilelist.setText(edtFilelist.getText()+ "\n" + strFname);
                    }
                }
            }
        });

        String strSDpath = Environment.getExternalStorageDirectory().getAbsolutePath();
        File myDir = new File(strSDpath + "/mydir");

        btnMkdir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.mkdir();
            }
        });

        btnRmdir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.delete();
            }
        });

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                MODE_PRIVATE);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream inFs = new FileInputStream("/storage/emulated/0/SD.txt");
                    byte[] txt =new byte[inFs.available()];
                    inFs.read(txt);
                    edtSD.setText(new String(txt));
                    inFs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}