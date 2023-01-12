package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class student_info_show extends AppCompatActivity {
    private Button m_btn_edit;
    private Button m_btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info_show);
        m_btn_edit = findViewById(R.id.btn_edit);
        m_btn_back = findViewById(R.id.show_back);
        m_btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(student_info_show.this,student_info_edit.class);
                startActivity(intent);
            }
        });
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                student_info_show.this.finish();
            }
        });
    }
}