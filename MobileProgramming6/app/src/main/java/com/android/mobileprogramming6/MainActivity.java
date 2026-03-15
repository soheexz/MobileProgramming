package com.android.mobileprogramming6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baselayout;
    Button button1,button2,button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기");

        baselayout=findViewById(R.id.baseLayout);
        button1=findViewById(R.id.button1);

        button2=findViewById(R.id.button2);
        registerForContextMenu(button2);
        button3=findViewById(R.id.button3);
        registerForContextMenu(button3);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        /*MenuInflater mInflater2=getMenuInflater();

        if(v==button2){
            menu.setHeaderTitle("배경색 변경");
            mInflater2.inflate(R.menu.menu2,menu);
        }
        if(v==button3){
            mInflater2.inflate(R.menu.menu3, menu);
        }*/

        if(v==button2){
            menu.setHeaderTitle("배경색 변경");

            menu.add(0,1,0,"배경색 (빨강)");
            menu.add(0,2,0,"배경색 (초록)");
            menu.add(0,3,0,"배경색 (파랑)");
        }
        if(v==button3){
            menu.add(0,4,0,"버튼 45도 회전");
            menu.add(0,5,0,"버튼 2배 확대");
        }
    }



    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        /*switch(item.getItemId()) {
            case R.id.itemRed:
                baselayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                baselayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                baselayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.subRotate:
                button1.setRotation(45);
                return true;
            case R.id.subSize:
                button1.setScaleX(2);
                return true;
        }
        return false;*/
        switch(item.getItemId()) {
            case 1:
                baselayout.setBackgroundColor(Color.RED);
                return true;
            case 2:
                baselayout.setBackgroundColor(Color.GREEN);
                return true;
            case 3:
                baselayout.setBackgroundColor(Color.BLUE);
                return true;
            case 4:
                button1.setRotation(45);
                return true;
            case 5:
                button1.setScaleX(2);
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        /*MenuInflater    mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1,menu);
        return true;*/

        menu.add(0,1,0,"배경색 (빨강)");
        menu.add(0,2,0,"배경색 (초록)");
        menu.add(0,3,0,"배경색 (파랑)");

        SubMenu sMenu = menu.addSubMenu("버튼 변경 >>");
        sMenu.add(0,4,0,"버튼 45도 회전");
        sMenu.add(0,5,0,"버튼 2배 확대");

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        /*switch(item.getItemId()){
            case R.id.itemRed:
                baselayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                baselayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                baselayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.subRotate:
                button1.setRotation(45);
                return true;
            case R.id.subSize:
                button1.setScaleX(2);
                return true;*/
        switch(item.getItemId()){
            case 1:
                baselayout.setBackgroundColor(Color.RED);
                return true;
            case 2:
                baselayout.setBackgroundColor(Color.GREEN);
                return true;
            case 3:
                baselayout.setBackgroundColor(Color.BLUE);
                return true;
            case 4:
                button1.setRotation(45);
                return true;
            case 5:
                button1.setScaleX(2);
                return true;

        }
        return false;
    }
}