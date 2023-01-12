package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class video_list extends AppCompatActivity {
    private List<Videoclass> vcList = new ArrayList<>();
    private Button m_btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        init();
        VideoclassAdapter adapter = new VideoclassAdapter(video_list.this,R.layout.videoclass_list_item,vcList);
        ListView listView = (ListView) findViewById(R.id.video_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Videoclass vc = vcList.get(position);
                Toast.makeText(video_list.this,vc.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        m_btn_back = findViewById(R.id.btn_back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                video_list.this.finish();
            }
        });
    }
    private void init(){
        Videoclass a = new Videoclass("语文成语","￥89.9 8.5折|高一语文|10节课","课程介绍：讲解成语",R.drawable.g);
        vcList.add(a);
        Videoclass b = new Videoclass("数学几何", "￥10.00元|初中数学|1节课","课程介绍：对初中数学几何进行归纳总结",R.drawable.c);
        vcList.add(b);
    }
}
