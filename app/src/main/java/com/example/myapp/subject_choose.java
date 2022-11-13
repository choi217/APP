package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class subject_choose extends AppCompatActivity {
    private Button m_btn_teacher;
    private Button m_btn_student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_choose);

        m_btn_teacher = findViewById(R.id.btn_teacher);
        m_btn_student = findViewById(R.id.btn_student);

        //请家教按键：跳转到申请家教的表单页面，填写表单，提交申请
        m_btn_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(subject_choose.this,ask_tutor.class);
                startActivity(intent);
            }
        });

        //做教员按键：跳转到注册页面，选择注册成为教师
        m_btn_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(subject_choose.this,signup.class);
                startActivity(intent);
            }
        });
    }



}