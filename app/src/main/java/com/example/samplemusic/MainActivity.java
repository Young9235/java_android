package com.example.samplemusic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;         // 생명주기를 위해 전역에 선언

    //onCreate main함수 역할
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(MainActivity.this, R.raw.music);        //음악을 재생
        mp.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }

    @Override       //구현한다.
    protected void onResume() {
        super.onResume();
        //mp.start();
        if(!mp.isPlaying()) {       //음악 재생 중이 아니더라도 계속 플레이 시켜라(앱을 꺼도 음악이 계속 재생되고 있음)
            mp.start();
        }
    }
}
