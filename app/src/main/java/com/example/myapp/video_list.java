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
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class video_list extends AppCompatActivity {
    private List<Videoclass> vcList = new ArrayList<>();
    private Button m_btn_back;
    private Button search;
    private Spinner grade,course,tsort;
    private SQLiteDatabase sqldb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        grade = findViewById(R.id.grade);
        course = findViewById(R.id.course);
        tsort = findViewById(R.id.sort);
        init();
        VideoclassAdapter adapter = new VideoclassAdapter(video_list.this,R.layout.videoclass_list_item,vcList);
        ListView listView = (ListView) findViewById(R.id.video_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Videoclass vc = vcList.get(position);
                Toast.makeText(video_list.this,vc.getName(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(video_list.this,video_info.class);
                startActivity(intent);
            }
        });
        m_btn_back = findViewById(R.id.btn_back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                video_list.this.finish();
            }
        });
        search = findViewById(R.id.video_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search_data();
                VideoclassAdapter adapter = new VideoclassAdapter(video_list.this,R.layout.videoclass_list_item,vcList);
                listView.setAdapter(adapter);
            }
        });
    }
    @SuppressLint("Range")
    private void init(){
        String args[] = {};
        sqldb = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        Cursor c = sqldb.rawQuery("SELECT * FROM video", args);
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                String name = c.getString(c.getColumnIndex("name"));
                Videoclass a = new Videoclass(name);
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
                vcList.add(a);
            }
            c.close();
            sqldb.close();
        }
    }
    @SuppressLint("Range")
    private void search_data() {
        vcList.clear();
        String gratext = grade.getSelectedItem().toString();
        String coutext = course.getSelectedItem().toString();
        String sorttext = tsort.getSelectedItem().toString();
        String where = "where grade Like ? AND subject Like ? ";
        SpinnerAdapter gra=grade.getAdapter();
        SpinnerAdapter cou=course.getAdapter();
        SpinnerAdapter sort=tsort.getAdapter();
        String args[] = {"%","%"};
        String order = "";
        if(sorttext.equals(sort.getItem(0).toString())){
            order = "order by score,hot desc";
        }else if(sorttext.equals(sort.getItem(1).toString())){
            order = "order by score desc";
        }else{
            order = "order by hot desc";
        }
        if(!gratext.equals(gra.getItem(0).toString())){
            args[0] = gratext;
        }
        if(!coutext.equals(cou.getItem(0).toString())){
            args[1] = coutext;
        }
        sqldb = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        Cursor c = sqldb.rawQuery("SELECT * FROM video " + where +order, args);
        System.out.println(args[0] + args[1]  );
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                String name = c.getString(c.getColumnIndex("name"));
                Videoclass a = new Videoclass(name);
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
                vcList.add(a);
            }
            c.close();
            sqldb.close();
        }
    }
}
