package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class student_info_edit extends AppCompatActivity {
    private Button m_btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info_edit);
        m_btn_submit = findViewById(R.id.btn_submit);
        m_btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"编辑成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(student_info_edit.this,student_info_show.class);
                startActivity(intent);
            }
        });
    }
}