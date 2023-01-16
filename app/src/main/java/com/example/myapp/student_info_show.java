package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class student_info_show extends AppCompatActivity {
    private Button m_btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info_show);
        Intent intent = getIntent();
        String studentid= intent.getStringExtra("studentid");
        m_btn_back = findViewById(R.id.btn_back);
        SQLiteDatabase db1;
        db1 = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);

        TextView username=findViewById(R.id.show_username);
        TextView name=findViewById(R.id.show_name);
        TextView gender=findViewById(R.id.show_gender);
        TextView province=findViewById(R.id.show_province);
        TextView phone=findViewById(R.id.show_phone);
        TextView email=findViewById(R.id.show_email);
        TextView need=findViewById(R.id.show_need);

        String a[]={studentid};//更改id处
        Cursor c = db1.rawQuery("SELECT * FROM student where id=?",a);
        if(c.getCount()>0)
        {
            c.moveToFirst();
            @SuppressLint("range")String sname=c.getString(c.getColumnIndex("name"));
            @SuppressLint("range")String sprovince=c.getString(c.getColumnIndex("province"));
            @SuppressLint("range")String sneed=c.getString(c.getColumnIndex("need"));
            @SuppressLint("range")String sgender=c.getString(c.getColumnIndex("sex"));
            @SuppressLint("range")String sphone=c.getString(c.getColumnIndex("phone"));
            name.setText(sname);
            gender.setText(sgender);
            province.setText(sprovince);
            need.setText(sneed);
            phone.setText(sphone);
        }
        Cursor d = db1.rawQuery("SELECT * FROM user where id=?",a);
        if(d.getCount()>0)
        {
            d.moveToFirst();
            @SuppressLint("range")String susername=d.getString(d.getColumnIndex("username"));
            @SuppressLint("range")String semail=d.getString(d.getColumnIndex("email"));
            username.setText(susername);
            email.setText((semail));
        }


        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                student_info_show.this.finish();
            }
        });
    }
}