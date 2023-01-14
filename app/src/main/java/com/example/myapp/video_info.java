package com.example.myapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;

public class video_info extends AppCompatActivity implements View.OnClickListener{
    private VideoView videoView;
    private Button m_btn_back;
    @Override
    //对界面的按钮和显示位置实例化，并检查权限
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_info);

        videoView = (VideoView)findViewById(R.id.video_play);
        Button btnPlay = (Button)findViewById(R.id.btnPlay);
        Button btnPause = (Button)findViewById(R.id.btnPause);
        Button btnReplay = (Button)findViewById(R.id.btnReplay);

        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnReplay.setOnClickListener(this);
        m_btn_back = findViewById(R.id.back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                video_info.this.finish();
            }
        });
    }

    @Override
    //统一处理Play(播放)、Pause(暂停)、Replay(重新播放)的逻辑
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPlay:
                if(!videoView.isPlaying()){
                    videoView.start();//播放
                }
                break;
            case R.id.btnPause:
                if(videoView.isPlaying()){
                    videoView.pause();//暂停
                }
                break;
            case R.id.btnReplay:
                if(videoView.isPlaying()){
                    videoView.resume();//重新播放
                }
                break;
        }
    }

    @Override
    //执行完毕，释放所有资源
    protected void onDestroy() {
        super.onDestroy();
        if(videoView != null){
            videoView.suspend();
        }
    }
}

