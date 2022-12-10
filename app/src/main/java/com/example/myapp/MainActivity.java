package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

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

        DBHelper db;
        db = new DBHelper(this);
        try {
            db.createDB();
        } catch (IOException ioe) {
            throw new Error("Database not created....");
        }

        try {
            db.openDB();
            db.close();
        } catch (SQLException sqle) {
            throw sqle;
        }

        SQLiteDatabase db1;
        db1 = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
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
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                String name = m_edt_name.getText().toString();
                String pwd = m_edt_pwd.getText().toString();
                System.out.println(pwd);

                String args[] = {name};
                Cursor c = db1.rawQuery("SELECT * FROM user where username=?", args);
                String pas = "";
                if (c.getCount() > 0) {
                    c.moveToFirst();
                    pas = c.getString(c.getColumnIndex("password"));
                    boolean aa = (pas.equals(pwd));
                    if (aa&&pas.length()>0) {
                        Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, subject_choose.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "密码错误", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "用户名不存在", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}