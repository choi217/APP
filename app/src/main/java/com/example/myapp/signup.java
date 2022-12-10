package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.EditText;
import com.example.myapp.RandomNumber;
import com.example.myapp.send_email;

public class signup extends AppCompatActivity {
    private Button m_btn_signup;
    private String identification = null; //老师
    //邮件验证码初始化
    private EditText etInputEmail,etInputGetNum,etInputName; //邮箱，验证码，用户名
    private String email="",name; //收件邮箱
    private long getnum=-100; //生成的验证码
    private EditText etInputPasswd1,etInputPasswd2; //两次密码
    private String passwd1,passwd2;
    private long isVerification=0; //标记验证码是否验证成功，验证未成功不能注册
    private long LastTime=0,CurrentTime,WaitTime=30000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        email_init();
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
                //信息不能有空，验证码需要通过，两次密码不能不同，密码位数在8-20位之间
                etInputName= (EditText) findViewById(R.id.ed_username);
                etInputPasswd1= (EditText) findViewById(R.id.ed_password1);
                etInputPasswd2= (EditText) findViewById(R.id.ed_password2);
                name=etInputName.getText().toString();
                passwd1=etInputPasswd1.getText().toString();
                passwd2=etInputPasswd2.getText().toString();
                boolean aa = (passwd1.equals(passwd2));
                if (name.length()==0||passwd1.length()==0||passwd2.length()==0||
                        email.length()==0||getnum==-100||identification==null) {
                    Toast.makeText(getApplicationContext(),"信息不能有空",Toast.LENGTH_LONG).show();
                    return;
                }
                else if (isVerification==0) {
                    Toast.makeText(getApplicationContext(),"邮箱验证未通过",Toast.LENGTH_LONG).show();
                    return;
                }
                else if (!aa){
                    Toast.makeText(getApplicationContext(),"两次密码不一致",Toast.LENGTH_LONG).show();
                    return;
                }
                else if (passwd1.length()<8||passwd1.length()>20){
                    Toast.makeText(getApplicationContext(),"密码位数应在8-20位之间",Toast.LENGTH_LONG).show();
                    return;
                }

                //写入数据库
                SQLiteDatabase db1;
                db1 = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
                RandomNumber rn = new RandomNumber();
                long tmpid = rn.getRandomNumber(7); //随机id
                db1.execSQL("INSERT INTO user(id,username,password,email) values(?,?,?,?)", new Object[]{tmpid,name,passwd1,email});
                Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_LONG).show();

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
            }
        });
    }
    private void email_init() {
        etInputEmail= (EditText) findViewById(R.id.ed_email);
        etInputGetNum= (EditText) findViewById(R.id.ed_pin);
    }
    public void btClick(View view){
        switch (view.getId()){
            case R.id.btGetNum:
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

            case R.id.btSubmit:
                judgeVerificationCode(); //判断输入的验证码是否正确
                break;
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