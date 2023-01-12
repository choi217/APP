package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class password_edit extends AppCompatActivity {
    private Button back_button;
    private Button m_btn_pw_forget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_edit);
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
    }
}
