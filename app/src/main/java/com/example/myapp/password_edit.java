package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class password_edit extends AppCompatActivity {
    private Button back_button;
    private Button m_btn_pw_forget;
    private Button pass;
    private EditText oldpwd,newpwd,checkpwd;
    private SQLiteDatabase sqldb;
    private String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_edit);
        Intent intent = getIntent();
        userid = intent.getStringExtra("userid");
        oldpwd =findViewById(R.id.oldpwd);
        newpwd = findViewById(R.id.newpwd);
        checkpwd = findViewById(R.id.checkpwd);
        back_button =findViewById(R.id.pw_back);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password_edit.this.finish();
            }
        });
        m_btn_pw_forget = findViewById(R.id.forget_pw);
        m_btn_pw_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(password_edit.this,password_forget.class);
                startActivity(intent);
            }
        });
        pass = findViewById(R.id.pass);
        pass.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                String args[] = {userid};
                System.out.println(userid);
                sqldb = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
                Cursor c = sqldb.rawQuery("SELECT * FROM user where id=?", args);
                String pwd="";
                if (c != null && c.getCount() > 0) {
                    while (c.moveToNext()) {
                        pwd = c.getString(c.getColumnIndex("password"));
                    }
                }
                c.close();
                if(!pwd.equals(oldpwd.getText().toString())){
                    Toast.makeText(getApplicationContext(), "与原来密码不一致", Toast.LENGTH_LONG).show();
                }else if(!newpwd.getText().toString().equals(checkpwd.getText().toString())){
                    Toast.makeText(getApplicationContext(), "两次输入密码不一致", Toast.LENGTH_LONG).show();
                }else{
                    sqldb.execSQL("UPDATE user SET password=? WHERE id=?",new Object[]{newpwd.getText().toString(),userid});
                    Toast.makeText(getApplicationContext(), "修改成功", Toast.LENGTH_LONG).show();
                }
                sqldb.close();
            }
        });
    }
}
