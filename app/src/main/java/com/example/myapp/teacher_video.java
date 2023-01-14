package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class teacher_video extends AppCompatActivity {
    private List<Video> videoList = new ArrayList<>();
    private Button m_btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myvideo_list);

        init();
        VideoAdapter adapter = new VideoAdapter(teacher_video.this,R.layout.video_list_item,videoList);
        ListView listView = (ListView) findViewById(R.id.video_list);
        listView.setAdapter(adapter);
        m_btn_back = findViewById(R.id.btn_back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacher_video.this.finish();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Video video = videoList.get(position);
                Intent intent = new Intent(teacher_video.this,video_info.class);
                startActivity(intent);
            }
        });
    }
    private void init(){
        Video a = new Video("语文成语","价格：0.00元 时长：55秒");
        videoList.add(a);
        Video b = new Video("数学几何", "价格：10.00元 时长：1小时");
        videoList.add(b);
    }
}
