package com.android.moblieprogramming10_4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        GridView gv = findViewById(R.id.gridView1);
        MyGridAdapter gAdapter=new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }


    public class MyGridAdapter extends BaseAdapter{

        Context context;
        public MyGridAdapter(Context c){
            context=c;
        }

        Integer[] posterID = {R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05,
                R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10,R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05,
                R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10,R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05,
                R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10,R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05,
                R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10};


        String[] posterTitle={"토이스토리4","호빗3","제이슨 본","반지의 제왕3","정직한 후보","나쁜 녀석들",
        "겨울왕국2","알라딘","극한직업","스파이더맨","토이스토리4","호빗3","제이슨 본","반지의 제왕3","정직한 후보","나쁜 녀석들",
                "겨울왕국2","알라딘","극한직업","스파이더맨","토이스토리4","호빗3","제이슨 본","반지의 제왕3","정직한 후보","나쁜 녀석들",
                "겨울왕국2","알라딘","극한직업","스파이더맨","토이스토리4","호빗3","제이슨 본","반지의 제왕3","정직한 후보","나쁜 녀석들",
                "겨울왕국2","알라딘","극한직업","스파이더맨"};
        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView=new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(200,300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);

            imageView.setImageResource(posterID[i]);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View dialogView=View.inflate(MainActivity.this, R.layout.dialog,null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[i]);
                    dlg.setTitle(posterTitle[i]);
                    dlg.setIcon(R.drawable.ic_launcher);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기",null);
                    dlg.show();
                    Toast.makeText(getApplicationContext(), posterTitle[i]+"이 선택되었습니다.",Toast.LENGTH_SHORT).show();
                }
            });
            return imageView;
        }
    }

}