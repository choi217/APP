package com.example.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class teacher_info_edit extends AppCompatActivity {
    private Button m_btn_submit;
    private Button edit_subject;
    private String text,susername,sname,sage,sgender,saddress,sphone,smajor,ssubject,
            sonline,sprovince,seducation,semail,sschool,ssalary,sinfother="";
    private EditText username,name,age,major,address,phone,email,school,salary,infother;
    private RadioGroup sexgroup,onlinegroup;
    private RadioButton male,female,a,b,ab;
    private Spinner province,education;
    private TextView subject;
    private String teacherid;
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_info_edit);
        Intent intent= getIntent();
        teacherid =intent.getStringExtra("teacherid");
        m_btn_submit = findViewById(R.id.btn_submit);
        username=findViewById(R.id.edit_username);
        name=findViewById(R.id.edit_name);
        sexgroup=findViewById(R.id.edit_sex);
        male=findViewById(R.id.edit_male);
        female=findViewById(R.id.edit_female);
        age=findViewById(R.id.edit_age);
        major=findViewById(R.id.edit_major);
        onlinegroup=findViewById(R.id.edit_online);
        a=findViewById(R.id.edit_a);
        b=findViewById(R.id.edit_b);
        ab=findViewById(R.id.edit_both);
        province=findViewById(R.id.edit_province);
        address=findViewById(R.id.edit_address);
        phone=findViewById(R.id.edit_phone);
        email=findViewById(R.id.edit_email);
        school=findViewById(R.id.edit_school);
        education=findViewById(R.id.edit_education);
        salary=findViewById(R.id.edit_salary);
        infother=findViewById(R.id.edit_inf);
        edit_subject = findViewById(R.id.edit_subject);
        subject=findViewById(R.id.subject_show);
        SQLiteDatabase db1;
        db1 = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        String aa[]={teacherid};//更改id处
        Cursor c = db1.rawQuery("SELECT * FROM teacher where id=?",aa);
        if(c.getCount()>0)
        {
            c.moveToFirst();
            sname=c.getString(c.getColumnIndex("name"));
            sgender=c.getString(c.getColumnIndex("sex"));
            sage=c.getString(c.getColumnIndex("age"));
            smajor=c.getString(c.getColumnIndex("major"));
            sonline=c.getString(c.getColumnIndex("teachmethod"));
            sprovince=c.getString(c.getColumnIndex("province"));
            saddress=c.getString(c.getColumnIndex("home"));
            sphone=c.getString(c.getColumnIndex("phone"));
            sschool=c.getString(c.getColumnIndex("school"));
            seducation=c.getString(c.getColumnIndex("degree"));
            ssalary=c.getString(c.getColumnIndex("moneyrequest"));
            ssubject=c.getString(c.getColumnIndex("subject"));
            sinfother=c.getString(c.getColumnIndex("otherinfo"));
            name.setText(sname);
            if(sgender.equals("男"))male.setChecked(true);
            else female.setChecked(true);
            age.setText(sage);
            major.setText(smajor);
            if(sonline.equals("线上"))a.setChecked(true);
            else if(sonline.equals("线下"))b.setChecked(true);
            else ab.setChecked(true);
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
            subject.setText(ssubject);
            address.setText(saddress);
            phone.setText(sphone);
            school.setText(sschool);
            SpinnerAdapter edu=education.getAdapter();
            k=edu.getCount();
            for(int i=0;i<k;i++)
            {
                if(seducation.equals(edu.getItem(i).toString()))
                {
                    education.setSelection(i,true);
                    break;
                }
            }
            salary.setText(ssalary);
            infother.setText(sinfother);
        }
        c.close();
        Cursor d=db1.rawQuery("SELECT * FROM user where id=?",aa);
        if (d.getCount() > 0) {
            d.moveToFirst();
            semail=d.getString(d.getColumnIndex("email"));
            susername=d.getString(d.getColumnIndex("username"));
            username.setText(susername);
            email.setText(semail);
        }
        d.close();


        m_btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                susername=username.getText().toString();
                sname=name.getText().toString();
                for(int i=0;i<sexgroup.getChildCount();i++)
                {
                    RadioButton d=(RadioButton)sexgroup.getChildAt(i);
                    if(d.isChecked())sgender=d.getText().toString();
                }
                sage=age.getText().toString();
                smajor=major.getText().toString();
                sprovince=province.getSelectedItem().toString();
                saddress=address.getText().toString();
                sphone=phone.getText().toString();
                semail=email.getText().toString();
                sschool=school.getText().toString();
                seducation=education.getSelectedItem().toString();
                ssalary=salary.getText().toString();
                sinfother=infother.getText().toString();
                for(int i=0;i<onlinegroup.getChildCount();i++)
                {
                    RadioButton d=(RadioButton)onlinegroup.getChildAt(i);
                    if(d.isChecked())sonline=d.getText().toString();
                }

                SQLiteDatabase db1;
                db1 = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
                db1.execSQL("UPDATE teacher SET sex=?,name=?,age=?,major=?,teachmethod=?,province=?,home=?,phone=?," +
                        "school=?,degree=?,moneyrequest=?,subject=?,otherinfo=? WHERE id=?",new Object[]{sgender,
                        sname,sage,smajor,sonline,sprovince,saddress,sphone,sschool,seducation,ssalary,text,sinfother,aa[0]
                });
                db1.execSQL("UPDATE user SET username=?,email=? WHERE id=?",new Object[]{susername,semail,aa[0]});
                db1.close();
                Toast.makeText(getApplicationContext(),"编辑成功",Toast.LENGTH_SHORT).show();
                teacher_info_edit.this.finish();
            }
        });
        edit_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(teacher_info_edit.this);
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
                                boolean y=false;
                                text="";
                                for (int i =0;i<items.length;i++){
                                    if (checkedItem[i]){
                                        if(y)text+=" ";
                                        text += items[i];
                                        y=true;
                                    }
                                }
                                TextView subject_show = findViewById(R.id.subject_show);
                                subject_show.setText(text);
                                Toast.makeText(teacher_info_edit.this,text, Toast.LENGTH_LONG).show();
                                dialogInterface.dismiss();
                            }
                        });
                        break;
                }
                AlertDialog ad = builder.create();
                ad.show();

            }
        });

    }


}