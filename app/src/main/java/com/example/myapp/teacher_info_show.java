package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.annotation.SuppressLint;

import java.io.IOException;

public class teacher_info_show extends AppCompatActivity {
    private Button m_btn_back;
    private String teacherid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_info_show);
        SQLiteDatabase db1;
        db1 = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        Intent intent= getIntent();
        teacherid =intent.getStringExtra("teacherid");
        m_btn_back = findViewById(R.id.show_back);
        TextView id=findViewById(R.id.show_num);
        TextView username=findViewById(R.id.show_username);
        TextView name=findViewById(R.id.show_name);
        TextView gender=findViewById(R.id.show_gender);
        TextView age=findViewById(R.id.show_age);
        TextView major=findViewById(R.id.show_major);
        TextView online=findViewById(R.id.show_online);
        TextView province=findViewById(R.id.show_province);
        TextView address=findViewById(R.id.show_address);
        TextView phone=findViewById(R.id.show_phone);
        TextView email=findViewById(R.id.show_email);
        TextView school=findViewById(R.id.show_school);
        TextView education=findViewById(R.id.show_education);
        TextView salary=findViewById(R.id.show_salary);
        TextView subject=findViewById(R.id.show_subject);
        TextView info=findViewById(R.id.show_info);
        String a[]={teacherid};//更改id处
        Cursor c = db1.rawQuery("SELECT * FROM teacher where id=?",a);
        if (c.getCount() > 0) {
            c.moveToFirst();
            @SuppressLint("Range") String sid=c.getString(c.getColumnIndex("id"));
            @SuppressLint("range")String sname=c.getString(c.getColumnIndex("name"));
            @SuppressLint("range")String sgender=c.getString(c.getColumnIndex("sex"));
            @SuppressLint("range")String sage=c.getString(c.getColumnIndex("age"));
            @SuppressLint("range")String smajor=c.getString(c.getColumnIndex("major"));
            @SuppressLint("range")String sonline=c.getString(c.getColumnIndex("teachmethod"));
            @SuppressLint("range")String sprovince=c.getString(c.getColumnIndex("province"));
            @SuppressLint("range")String saddress=c.getString(c.getColumnIndex("home"));
            @SuppressLint("range")String sphone=c.getString(c.getColumnIndex("phone"));
            @SuppressLint("range")String sschool=c.getString(c.getColumnIndex("school"));
            @SuppressLint("range")String seducation=c.getString(c.getColumnIndex("degree"));
            @SuppressLint("range")String ssalary=c.getString(c.getColumnIndex("moneyrequest"));
            @SuppressLint("range")String ssubject=c.getString(c.getColumnIndex("subject"));
            @SuppressLint("range")String sinfo=c.getString(c.getColumnIndex("otherinfo"));
            id.setText(sid);
            name.setText(sname);
            gender.setText(sgender);
            age.setText(sage);
            major.setText(smajor);
            online.setText(sonline);
            province.setText(sprovince);
            address.setText(saddress);
            phone.setText(sphone);
            school.setText(sschool);
            education.setText(seducation);
            salary.setText(ssalary);
            subject.setText(ssubject);
            info.setText(sinfo);
        }
        Cursor d=db1.rawQuery("SELECT * FROM user where id=?",a);
        if (d.getCount() > 0) {
            d.moveToFirst();
            @SuppressLint("range")String semail=d.getString(d.getColumnIndex("email"));
            @SuppressLint("range")String susername=d.getString(d.getColumnIndex("username"));
            username.setText(susername);
            email.setText(semail);
        }
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacher_info_show.this.finish();
            }
        });
    }
}