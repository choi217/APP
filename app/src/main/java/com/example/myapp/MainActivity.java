package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//这是一行测试注释
public class MainActivity extends AppCompatActivity {
    //声明控件
    private Button m_btn_signup;
    private Button m_btn_login;
    private EditText m_edt_name;
    private EditText m_edt_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //找到控件
        m_btn_signup=findViewById(R.id.btn_signup);
        m_btn_login=findViewById(R.id.btn_login);
        m_edt_name = findViewById(R.id.username);
        m_edt_pwd =findViewById(R.id.password);
        //实现注册跳转
        m_btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,signup.class);
                startActivity(intent);
            }
        });
        //登录跳转
        m_btn_login.setOnClickListener(new View.OnClickListener(){
            String name = m_edt_name.getText().toString();
            String pwd =m_edt_pwd.getText().toString();
            @Override
            public  void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,subject_choose.class);
                startActivity(intent);
            }
        });

    }
}