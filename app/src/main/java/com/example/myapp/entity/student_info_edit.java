package com.example.myapp.entity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.myapp.R;
import com.mysql.jdbc.util.ErrorMappingsDocGenerator;

import java.io.IOException;
import java.lang.reflect.Array;

public class student_info_edit extends AppCompatActivity {
    private Button m_btn_submit;
    private Button m_btn_back;
    private EditText username,name,phone,email,need;
    private Spinner province;
    private RadioGroup sexgroup;
    private RadioButton male,female;
    private String sname,sprovince,susername,sphone,semail,sneed,sgender="";
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info_edit);
        Intent intent = getIntent();
        String studentid= intent.getStringExtra("studentid");
        m_btn_back = findViewById(R.id.btn_back);
        m_btn_submit =findViewById(R.id.btn_submit);
        username=findViewById(R.id.edit_username);
        name= findViewById(R.id.edit_name);
        province=findViewById(R.id.edit_province);
        sexgroup=findViewById(R.id.edit_sex);
        male=findViewById(R.id.edit_male);
        female=findViewById(R.id.edit_female);
        phone=findViewById(R.id.edit_phone);
        email=findViewById(R.id.edit_email);
        need=findViewById(R.id.edit_need);
        SQLiteDatabase db1;
        db1 = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        String a[]={studentid};//更改id处
        Cursor c = db1.rawQuery("SELECT * FROM student where id=?",a);
        if(c.getCount()>0)
        {
            c.moveToFirst();
            sname=c.getString(c.getColumnIndex("name"));
            sprovince=c.getString(c.getColumnIndex("province"));
            sneed=c.getString(c.getColumnIndex("need"));
            sgender=c.getString(c.getColumnIndex("sex"));
            sphone=c.getString(c.getColumnIndex("phone"));
            name.setText(sname);
            need.setText(sneed);
            phone.setText(sphone);
            if(sgender.equals("男"))male.setChecked(true);
            else female.setChecked(true);
            SpinnerAdapter p=province.getAdapter();
            int k=p.getCount();
            for(int i=0;i<k;i++)
            {
                if(sprovince.equals(p.getItem(i).toString()))
                {
                    province.setSelection(i,true);
                    break;
                }
            }
        }
        c.close();
        Cursor d = db1.rawQuery("SELECT * FROM user where id=?",a);
        if(d.getCount()>0)
        {
            d.moveToFirst();
            susername=d.getString(d.getColumnIndex("username"));
            semail=d.getString(d.getColumnIndex("email"));
            username.setText(susername);
            email.setText((semail));
        }
        d.close();

        db1.close();
        m_btn_submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                sname=name.getText().toString();
                susername=username.getText().toString();
                sphone=phone.getText().toString();
                sprovince=province.getSelectedItem().toString();
                semail=email.getText().toString();
                sneed=need.getText().toString();
                for(int i=0;i<sexgroup.getChildCount();i++)
                {
                    RadioButton d=(RadioButton)sexgroup.getChildAt(i);
                    if(d.isChecked())sgender=d.getText().toString();
                }
                System.out.println("***"+sname+" "+susername+" "+sgender
                        +" "+semail+" "+sphone+" "+sprovince);
                SQLiteDatabase db1;
                db1 = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
                try {
                    db1.execSQL("UPDATE student SET name=?,province=?,sex=?,need=?,phone=? WHERE id=?", new Object[]{sname, sprovince,
                            sgender, sneed, sphone, "1000003"});
                    db1.execSQL("UPDATE user SET username=?,email=? WHERE id=?", new Object[]{susername, semail, "1000003"});
                }catch(Exception e){
                    e.printStackTrace();
                    e.toString();
                }
                db1.close();
                Toast.makeText(getApplicationContext(),"编辑成功",Toast.LENGTH_SHORT).show();
                student_info_edit.this.finish();
            }
        });
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                student_info_edit.this.finish();
            }
        });
    }
}