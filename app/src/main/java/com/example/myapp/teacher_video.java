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

public class teacher_video extends AppCompatActivity {
    private List<Video> videoList = new ArrayList<>();
    private SQLiteDatabase db;
    private Button m_btn_back,vil_all,vil_money,vil_nomoney;
    private String uid="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_video);
        Intent intent=getIntent();
        uid=intent.getStringExtra("uid");
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
        vil_all=findViewById(R.id.vil_all);
        vil_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoList.clear();
                init();
                adapter.notifyDataSetChanged();
            }
        });
        vil_money=findViewById(R.id.vil_money);
        vil_money.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                videoList.clear();
                db=openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
                Cursor c=db.rawQuery("SELECT * FROM video WHERE teacherid=?",new String[]{uid});
                if(c!=null&&c.moveToFirst()) {
                    do {
                        String charge = c.getString(c.getColumnIndex("price"));
                        String courseid = c.getString(c.getColumnIndex("courseid"));
                        String name = "";
                        Cursor d = db.rawQuery("SELECT * FROM video WHERE teacherid=?", new String[]{uid});
                        if (d.getCount() > 0) {
                            d.moveToFirst();
                            name = d.getString(d.getColumnIndex("name"));
                        }
                        Video t = new Video(name);
                        t.setPrice(charge);
                        t.setGrade(c.getString(c.getColumnIndex("grade")));
                        if(!charge.equals("0"))videoList.add(t);
                        d.close();
                    } while (c.moveToNext());
                }
                c.close();
                db.close();
                adapter.notifyDataSetChanged();
            }
        });
        vil_nomoney=findViewById(R.id.vil_nomoney);
        vil_nomoney.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                videoList.clear();
                db=openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
                Cursor c=db.rawQuery("SELECT * FROM video WHERE teacherid=?",new String[]{uid});
                if(c!=null&&c.moveToFirst()) {
                    do {
                        String charge = c.getString(c.getColumnIndex("price"));
                        String courseid = c.getString(c.getColumnIndex("courseid"));
                        String name = "";
                        Cursor d = db.rawQuery("SELECT * FROM video WHERE teacherid=?", new String[]{uid});
                        if (d.getCount() > 0) {
                            d.moveToFirst();
                            name = d.getString(d.getColumnIndex("name"));
                        }
                        Video t = new Video(name);
                        t.setPrice(charge);
                        t.setGrade(c.getString(c.getColumnIndex("grade")));
                        if(charge.equals("0"))videoList.add(t);
                        d.close();
                    } while (c.moveToNext());
                }
                c.close();
                db.close();
                adapter.notifyDataSetChanged();
            }
        });
    }
    @SuppressLint("Range")
    private void init(){
        videoList.clear();
        db=openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        Cursor c=db.rawQuery("SELECT * FROM video WHERE teacherid=?",new String[]{uid});
        if(c!=null&&c.moveToFirst()) {
            do {
                String charge = c.getString(c.getColumnIndex("price"));
                String courseid = c.getString(c.getColumnIndex("courseid"));
                String name = "";
                Cursor d = db.rawQuery("SELECT * FROM video WHERE teacherid=?", new String[]{uid});
                if (d.getCount() > 0) {
                    d.moveToFirst();
                    name = d.getString(d.getColumnIndex("name"));
                }
                Video t = new Video(name);
                t.setPrice(charge);
                t.setGrade(c.getString(c.getColumnIndex("grade")));
                videoList.add(t);
                d.close();
            } while (c.moveToNext());
        }
        c.close();
        db.close();
    }
}
