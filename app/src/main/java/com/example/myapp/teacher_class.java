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

public class teacher_class extends AppCompatActivity {
    private List<Course> courseList = new ArrayList<>();
    private Button m_btn_back,class_all,class_soon;
    private String teacherid;
    private SQLiteDatabase sqldb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_class);
        Intent intent= getIntent();
        teacherid =intent.getStringExtra("uid");
        init();
        CourseAdapter adapter = new CourseAdapter(teacher_class.this,R.layout.class_list_item,courseList);
        ListView listView = (ListView) findViewById(R.id.class_list);
        listView.setAdapter(adapter);
        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course course = courseList.get(position);
                Toast.makeText(teacher_class.this,course.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        m_btn_back = findViewById(R.id.btn_back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacher_class.this.finish();
            }
        });
        class_all=findViewById(R.id.class_all);
        class_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init();
                CourseAdapter adapter = new CourseAdapter(teacher_class.this,R.layout.class_list_item,courseList);
                listView.setAdapter(adapter);
            }
        });
        class_soon = findViewById(R.id.class_soon);
        class_soon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soon();
                CourseAdapter adapter = new CourseAdapter(teacher_class.this,R.layout.class_list_item,courseList);
                listView.setAdapter(adapter);
            }
        });
    }
    @SuppressLint("Range")
    private void init(){
        courseList.clear();
        String args[] = {teacherid};
        System.out.println("teacherid"+teacherid);
        sqldb = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        Cursor c = sqldb.rawQuery("SELECT * FROM teachercourse where teacherid=?", args);
        ArrayList<String> cids = new ArrayList<>();
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                cids.add(c.getString(c.getColumnIndex("courseid")));
            }
            c.close();
        }
        for(int i=0;i<cids.size();i++){
            String arg[] = {cids.get(i)};
            c = sqldb.rawQuery("SELECT * FROM course where id=?", arg);
            Course a = new Course(arg[0]);
            if (c != null && c.getCount() > 0) {
                while (c.moveToNext()) {
                    a.setTeacherid(c.getString(c.getColumnIndex("teacherid")));
                    a.setName(c.getString(c.getColumnIndex("name")));
                }
                c.close();
            }
            arg[0] = a.getTeacherid();
            System.out.println(arg[0]);
            c = sqldb.rawQuery("SELECT * FROM teacher where id=?", arg);
            if (c != null && c.getCount() > 0) {
                while (c.moveToNext()) {
                    a.setTeachername(c.getString(c.getColumnIndex("name")));
                }
                c.close();
            }
            arg[0] = a.getId();
            System.out.println(arg[0]);
            c = sqldb.rawQuery("SELECT * FROM teachercourse where courseid=? and date>datetime('now','localtime') order by date desc", arg);
            if (c != null && c.getCount() > 0) {
                while (c.moveToNext()) {
                    a.setDate(c.getString(c.getColumnIndex("date")));
                }
                c.close();
            }
            c = sqldb.rawQuery("SELECT * FROM teachercourse where courseid=? order by date", arg);
            if (c != null && c.getCount() > 0) {
                while (c.moveToNext()) {
                    a.setOlddate(c.getString(c.getColumnIndex("date")));
                }
                c.close();
            }
            courseList.add(a);
        }
        sqldb.close();
    }
    @SuppressLint("Range")
    private void soon(){
        courseList.clear();
        String args[] = {teacherid};
        System.out.println("teacherid"+teacherid);
        sqldb = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        Cursor c = sqldb.rawQuery("SELECT * FROM teachercourse where teacherid=?", args);
        ArrayList<String> cids = new ArrayList<>();
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                cids.add(c.getString(c.getColumnIndex("courseid")));
            }
            c.close();
        }
        for(int i=0;i<cids.size();i++){
            String arg[] = {cids.get(i)};
            c = sqldb.rawQuery("SELECT * FROM course where id=?", arg);
            Course a = new Course(arg[0]);
            if (c != null && c.getCount() > 0) {
                while (c.moveToNext()) {
                    a.setTeacherid(c.getString(c.getColumnIndex("teacherid")));
                    a.setName(c.getString(c.getColumnIndex("name")));
                }
                c.close();
            }
            arg[0] = a.getTeacherid();
            System.out.println(arg[0]);
            c = sqldb.rawQuery("SELECT * FROM teacher where id=?", arg);
            if (c != null && c.getCount() > 0) {
                while (c.moveToNext()) {
                    a.setTeachername(c.getString(c.getColumnIndex("name")));
                }
                c.close();
            }
            arg[0] = a.getId();
            System.out.println(arg[0]);
            c = sqldb.rawQuery("SELECT * FROM teachercourse where courseid=? and date>datetime('now','localtime') order by date desc", arg);
            if (c != null && c.getCount() > 0) {
                while (c.moveToNext()) {
                    a.setDate(c.getString(c.getColumnIndex("date")));
                }
                c.close();
            }
            c = sqldb.rawQuery("SELECT * FROM teachercourse where courseid=? order by date", arg);
            if (c != null && c.getCount() > 0) {
                while (c.moveToNext()) {
                    a.setOlddate(c.getString(c.getColumnIndex("date")));
                }
                c.close();
            }
            if(a.getDate()!=null && a.getDate().length()!=0)courseList.add(a);
        }
        sqldb.close();
    }
}
