package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class myvideo_list extends AppCompatActivity {
    private List<Video> videoList = new ArrayList<>();
    private Button m_btn_back,vil_all,vil_money,vil_nomoney;
    private String studentid;
    private SQLiteDatabase sqldb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myvideo_list);
        Intent intent =getIntent();
        studentid = intent.getStringExtra("studentid");
        init("1");
        VideoAdapter adapter = new VideoAdapter(myvideo_list.this,R.layout.video_list_item,videoList);
        ListView listView = (ListView) findViewById(R.id.video_list);
        listView.setAdapter(adapter);
        m_btn_back = findViewById(R.id.btn_back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myvideo_list.this.finish();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Video video = videoList.get(position);
                Intent intent = new Intent(myvideo_list.this,video_info.class);
                startActivity(intent);
            }
        });
        vil_all=findViewById(R.id.vil_all);
        vil_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init("1");
                VideoAdapter adapter = new VideoAdapter(myvideo_list.this,R.layout.video_list_item,videoList);
                listView.setAdapter(adapter);
            }
        });
        vil_money=findViewById(R.id.vil_money);
        vil_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init("2");
                VideoAdapter adapter = new VideoAdapter(myvideo_list.this,R.layout.video_list_item,videoList);
                listView.setAdapter(adapter);
            }
        });
        vil_nomoney=findViewById(R.id.vil_nomoney);
        vil_nomoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init("0");
                VideoAdapter adapter = new VideoAdapter(myvideo_list.this,R.layout.video_list_item,videoList);
                listView.setAdapter(adapter);
            }
        });

    }
    @SuppressLint("Range")
    private void init(String price){
        videoList.clear();
        String pr ="";
        if(price.equals("0"))pr = "and price=?";
        if(price.equals("2"))pr = "and price>?";
        String args[]= {studentid};
        sqldb = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        Cursor c = sqldb.rawQuery("SELECT * FROM studentcourse where studentid=? ", args);
        ArrayList<String> cids = new ArrayList<>();
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                cids.add(c.getString(c.getColumnIndex("courseid")));
            }
            c.close();
        }
        for(int i=0;i<cids.size();i++) {
            String args1[] = {cids.get(i),price};
            String args2[] ={cids.get(i)};
            String arg[] = args2.clone();
            if(price.equals("0") || price.equals("2")) arg=args1.clone();
            c = sqldb.rawQuery("SELECT * FROM video where courseid=? " +pr, arg);
            if (c != null && c.getCount() > 0) {
                while (c.moveToNext()) {
                    String name = c.getString(c.getColumnIndex("name"));
                    Video a = new Video(name);
                    a.setUrl(c.getString(c.getColumnIndex("url")));
                    a.setTeacherid(c.getString(c.getColumnIndex("teacherid")));
                    a.setPrice(c.getString(c.getColumnIndex("price")));
                    a.setDescribe(c.getString(c.getColumnIndex("describe")));
                    a.setSubject(c.getString(c.getColumnIndex("subject")));
                    a.setGrade(c.getString(c.getColumnIndex("grade")));
                    a.setImageurl(c.getString(c.getColumnIndex("imageurl")));
                    a.setHot(c.getString(c.getColumnIndex("hot")));
                    a.setScore(c.getString(c.getColumnIndex("score")));
                    a.setVideoid(c.getString(c.getColumnIndex("videoid")));
                    a.setCourseid(c.getString(c.getColumnIndex("courseid")));
                    System.out.println(a.getName());
                    videoList.add(a);
                }
                c.close();
            }
        }
        sqldb.close();
    }
}
