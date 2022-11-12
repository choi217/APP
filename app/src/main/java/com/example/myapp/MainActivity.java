package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //声明控件
    private Button m_btn_signup;
    private Button m_btn_login;
    private TextView m_username;
    private TextView m_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //找到控件
        m_btn_signup=findViewById(R.id.btn_signup);
        m_btn_login=findViewById(R.id.btn_login);
        m_username=findViewById(R.id.username);
        m_password=findViewById(R.id.password);

        //实现注册跳转
        m_btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,signup.class);
                startActivity(intent);
            }
        });

        //实现登录跳转
        m_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = m_username.getText().toString();
                String password = m_password.getText().toString();
                Intent intent = null ;
                if ("app".equals(username)&&"123".equals(password))
                {
                    Toast.makeText(getApplicationContext(),"登陆成功",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this,subject_choose.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"用户名或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}