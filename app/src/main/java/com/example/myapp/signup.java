package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    private Button m_btn_signup;
    String identification = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        m_btn_signup = findViewById(R.id.btn_now_signup);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.edit_identification);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.edit_teacher:
                        identification = "教师";
                        break;
                    case R.id.edit_student:
                        identification = "学生";
                        break;
                }
            }
        });
        m_btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                if (identification.equals("教师")){
                    Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_SHORT).show();
                    intent = new Intent(signup.this,teacher_info_edit.class);
                    startActivity(intent);
                }
                else if (identification.equals("学生")){
                    Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_SHORT).show();
                    intent = new Intent(signup.this,student_info_edit.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"请选择身份",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}