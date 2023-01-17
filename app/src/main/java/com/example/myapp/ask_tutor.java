package com.example.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ask_tutor extends AppCompatActivity {
    private Button edit_subject;
    private Button apply_now;
    private Button back_button;
    private EditText edit_phone,edit_address,tech_address,class_time,describe,teacher_request,salary_request;
    private TextView subject;
    private RadioGroup edit_sex,edit_online;
    private RadioButton edit_male,edit_female;
    private Spinner edit_grade;
    private String phone,address,stech_address,time,sdescribe,steacher_request,ssalary_request,sex,online,grade,ssubject;
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_tutor);
        Intent intent= getIntent();
        String studentid = intent.getStringExtra("userid");
        edit_subject = findViewById(R.id.edit_subject);
        apply_now = findViewById(R.id.apply_now);
        back_button =findViewById(R.id.tutor_back);
        edit_phone = findViewById(R.id.edit_phone);
        edit_address = findViewById(R.id.edit_address);
        tech_address = findViewById(R.id.tech_address);
        class_time = findViewById(R.id.class_time);
        describe= findViewById(R.id.describe);
        teacher_request = findViewById(R.id.teacher_request);
        salary_request = findViewById(R.id.salary_request);
        edit_sex =findViewById(R.id.edit_sex);
        edit_online=findViewById(R.id.edit_online);
        edit_grade = findViewById(R.id.edit_grade);
        subject =findViewById(R.id.subject_show);
        edit_male=findViewById(R.id.edit_male);
        edit_female=findViewById(R.id.edit_female);
        String a[]={studentid};//更改id处
        System.out.println(studentid);
        SQLiteDatabase db1;
        db1 = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        Cursor c = db1.rawQuery("SELECT * FROM student where id=?",a);
        if(c.getCount()>0)
        {
            c.moveToFirst();
            sdescribe=c.getString(c.getColumnIndex("need"));
            sex=c.getString(c.getColumnIndex("sex"));
            phone=c.getString(c.getColumnIndex("phone"));
            describe.setText(sdescribe);
            edit_phone.setText(phone);
            if(sex.equals("男"))edit_male.setChecked(true);
            else edit_female.setChecked(true);
        }
        c.close();
        //设置多选
        edit_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ask_tutor.this);
                switch (view.getId()){
                    case R.id.edit_subject:
                        builder.setTitle("请选择科目");
                        builder.setIcon(R.mipmap.ic_launcher);
                        final String[] items = new String[]{"语文", "数学", "英语", "物理" , "化学" , "生物" , "历史" , "地理" , "政治" , "体育" , "计算机"};
                        final boolean[] checkedItem = new boolean[]{false,false,false,false,false,false,false,false,false,false,false};
                        builder.setMultiChoiceItems(items, checkedItem, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                                checkedItem[which] = isChecked;
                            }
                        });
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public  void onClick(DialogInterface dialogInterface, int which) {
                                String text = "";
                                for (int i =0;i<items.length;i++){
                                    if (checkedItem[i]){
                                        text+=" [";
                                        text += items[i];
                                        text+="] ";
                                    }
                                }
                                TextView subject_show = findViewById(R.id.subject_show);
                                subject_show.setText(text);
                                Toast.makeText(ask_tutor.this,text, Toast.LENGTH_LONG).show();
                                dialogInterface.dismiss();
                            }
                        });
                        break;
                }
                AlertDialog ad = builder.create();
                ad.show();
            }
        });

        //提交申请，这里设置的回到主页面，等待修改
        apply_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //phone,address,stech_address,time,sdescribe,steacher_request,ssalary_request,sex,online,grade,ssubject
                phone = edit_phone.getText().toString();
                address = edit_address.getText().toString();
                stech_address = tech_address.getText().toString();
                time = class_time.getText().toString();
                sdescribe = describe.getText().toString();
                steacher_request =  teacher_request.getText().toString();
                ssalary_request =salary_request.getText().toString();
                for(int i=0;i<edit_sex.getChildCount();i++)
                {
                    RadioButton d=(RadioButton)edit_sex.getChildAt(i);
                    if(d.isChecked())sex=d.getText().toString();
                }
                online ="";
                for(int i=0;i<edit_online.getChildCount();i++)
                {
                    RadioButton d=(RadioButton)edit_online.getChildAt(i);
                    if(d.isChecked())online=d.getText().toString();
                }
                grade = edit_grade.getSelectedItem().toString();
                ssubject = subject.getText().toString();
                if(phone.length() ==0 || address.length() ==0 || subject.length()==0 || online.length()==0){
                    Toast.makeText(getApplicationContext(),"必填项不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                String taket = "-1";
                SQLiteDatabase db1;
                db1 = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
                String args[]={};
                Cursor c= db1.rawQuery("SELECT id FROM orderlists",args);
                int count = c.getCount() +1;
                c.close();
                try {
                    db1.execSQL("INSERT INTO orderlists(phone,home,teachplace,sex,grade,subject,time,describe" +
                            ",request,teachmethod,userid,taketeacherid,salary,id) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",
                            new Object[]{phone,address,stech_address,sex,grade,ssubject,time,sdescribe,steacher_request,
                            online,studentid,taket,ssalary_request,count+""});
                }catch(Exception e){
                    e.printStackTrace();
                    e.toString();
                }
                db1.close();
                Toast.makeText(getApplicationContext(),"提交申请成功，请等待教师响应",Toast.LENGTH_SHORT).show();
                ask_tutor.this.finish();
            }
        });
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ask_tutor.this.finish();
            }
        });
    }


}