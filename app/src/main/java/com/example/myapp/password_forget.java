package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class password_forget extends AppCompatActivity {
    private EditText etInputEmail,etInputGetNum;
    private Button back_button;
    private String email="";
    private long getnum=-100; //生成的验证码
    private SQLiteDatabase sqldb;
    private long isVerification=0; //标记验证码是否验证成功，验证未成功不能注册
    private long LastTime=0,CurrentTime,WaitTime=30000;
    private String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_forget);
        Intent intent = getIntent();
        userid = intent.getStringExtra("userid");
        email_init();
        back_button =findViewById(R.id.pw_back);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password_forget.this.finish();
            }
        });

    }
    private void email_init() {
        etInputEmail= (EditText) findViewById(R.id.my_email);
        etInputGetNum= (EditText) findViewById(R.id.my_pin);
    }
    public void btClick(View view){
        switch (view.getId()){
            case R.id.get_pin:
                //30秒内只能发送一次验证码
                CurrentTime=System.currentTimeMillis(); //获取当前运行时间(毫秒)
                if (CurrentTime-LastTime<WaitTime){
                    //Looper.prepare();
                    Toast.makeText(getApplicationContext(),"30秒内只能发送一次验证码",Toast.LENGTH_LONG).show();
                    //Looper.loop();
                    break;
                }
                email=etInputEmail.getText().toString();
                sendVerificationCode(email); //发送验证码
                break;

            case R.id.pass:
                judgeVerificationCode(); //判断输入的验证码是否正确
                if (email.length()==0||getnum==-100) {
                    Toast.makeText(getApplicationContext(),"信息不能有空",Toast.LENGTH_LONG).show();
                    break;
                }
                else if (isVerification==0) {
                    Toast.makeText(getApplicationContext(),"邮箱验证未通过",Toast.LENGTH_LONG).show();
                    break;
                }
                else
                {
                    sqldb = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
                    sqldb.execSQL("UPDATE user SET password=? WHERE id=?",new Object[]{"12345678",userid});
                    Toast.makeText(getApplicationContext(),"密码已初始化为12345678",Toast.LENGTH_LONG).show();
                    break;
                }
              //  break;
        }
    }

    //发送验证码
    private void sendVerificationCode(final String email) {
        try{
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        RandomNumber rn = new RandomNumber();
                        getnum = rn.getRandomNumber(6);
                        send_email se = new send_email(email);
                        se.sendTextEmail(getnum); //发送文本邮件
                        LastTime=System.currentTimeMillis();
                        //System.out.println("@");
                        //System.out.println(LastTime);
                        Looper.prepare();
                        Toast.makeText(getApplicationContext(),"发送成功",Toast.LENGTH_LONG).show();
                        Looper.loop();
                        //更新上一次发送验证码的时间
                    } catch (Exception e) {
                        Looper.prepare();
                        Toast.makeText(getApplicationContext(),"发送失败，请重试",Toast.LENGTH_LONG).show();
                        Looper.loop();
                        e.printStackTrace();
                    }
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //判断输入的验证码是否正确
    private void judgeVerificationCode() {
        long tmpp=0; //System.out.println(tmpp);
        try{
            tmpp=Integer.parseInt(etInputGetNum.getText().toString());
        } catch(Exception e){
            e.printStackTrace();
        }
        if(tmpp==getnum&&tmpp>0){ //验证码和输入一致
            //System.out.println(getnum);
            //Looper.prepare();
            Toast.makeText(getApplicationContext(),"验证成功",Toast.LENGTH_LONG).show();
            //Looper.loop();
            isVerification=1;
        }
        else{
            //System.out.println("error");
            //Looper.prepare();
            Toast.makeText(getApplicationContext(), "验证失败", Toast.LENGTH_LONG).show();
            //Looper.loop();
        }
    }
}
