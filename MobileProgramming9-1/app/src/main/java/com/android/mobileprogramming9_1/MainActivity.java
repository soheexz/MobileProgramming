package com.android.mobileprogramming9_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 투표");
        Log.i("명화고르기 메인 시작","onCreate()");

        //이미지뷰 객체 배열
        ImageView image[]=new ImageView[9];
        //이미지뷰 id 객체 배열
        Integer imageId[]={R.id.iv1, R.id.iv2,R.id.iv3,R.id.iv4,R.id.iv5,R.id.iv6,R.id.iv7,R.id.iv8,R.id.iv9};
        //그림 제목 객체 배열
        String imgName[]={"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
        "이레느깡 단 베르양","장자는 소녀","테라스의 두 자매","피아노 레슨","피아노 앞의 소녀들","해변에서"};

        //그림 투표수 저장 배열
        int voteCount[]=new int[9];
        for(int i=0;i<9;i++){
            voteCount[i]=0;
        }

        //이미지 뷰 클릭 이벤트 리스너 생성, 튜표수 증가
        for(int i=0; i<imageId.length;i++){
            final int index;
            index=i;
            image[index]=findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(MainActivity.this,imgName[index]+": 총"+voteCount[index]+": 표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btnFinish = findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                intent.putExtra("voteCount",voteCount);
                intent.putExtra("imgName",imgName);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("명화고르기 메인 보이기","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("명화고르기 메인 상호작용 ","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("명화고르기 메인 잠시","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("명화고르기 메인 멈추기","onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("명화고르기 메인 다시시작","onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("명화고르기 메인 끝내기","onDestroy()");
    }
}