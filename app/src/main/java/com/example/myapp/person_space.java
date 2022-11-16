package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class person_space extends AppCompatActivity {
    //声明控件
    private Button m_btn_space_main;
    private Button m_btn_space_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_space);

        //找到控件
        m_btn_space_main=findViewById(R.id.space_main);
        m_btn_space_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(person_space.this,subject_choose.class);
                startActivity(intent);
            }
        });

        m_btn_space_back=findViewById(R.id.space_back);

        m_btn_space_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person_space.this.finish();
            }
        });
    }
}