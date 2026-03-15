package com.android.mobileprogramming9_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표결과");
        Log.i("명화고르기 시작","onCreate()");

        //MainActivity 보낸 투표 결과 값 & 그림 제목
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("voteCount");
        String[] imageName = intent.getStringArrayExtra("imgName");

        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[]=new RatingBar[imageName.length];

        //TextView,RatingBar의 ID 배열
        Integer tvID[]={R.id.tv1, R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9};
        Integer rbarID[]={R.id.rbar1,R.id.rbar2,R.id.rbar3,R.id.rbar4,R.id.rbar5,R.id.rbar6,R.id.rbar7,R.id.rbar8,R.id.rbar9};

        for(int i=0; i<imageName.length;i++){
            tv[i]=findViewById(tvID[i]);
            rbar[i]=findViewById((rbarID[i]));
        }
        for(int i=0;i<imageName.length;i++){
            tv[i].setText(imageName[i]);
            rbar[i].setRating(voteResult[i]);
        }

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //가장 많은 표를 받은 명화 보여주기
        Integer imageField[]={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,R.drawable.pic7,R.drawable.pic8,R.drawable.pic9};

        TextView tvWin = findViewById(R.id.tvWin);
        ImageView tvWinImage = findViewById(R.id.tvWinImage);
        int maxEntry=0;
        for(int i=0; i < voteResult.length; i++){
            if(voteResult[maxEntry] < voteResult[i])
                maxEntry=i;
        }
        tvWin.setText(imageName[maxEntry]);
        tvWinImage.setImageResource(imageField[maxEntry]);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("명화고르기 보이기","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("명화고르기 상호작용 ","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("명화고르기 잠시","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("명화고르기 멈추기","onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("명화고르기 다시시작","onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("명화고르기 끝내기","onDestroy()");
    }

}