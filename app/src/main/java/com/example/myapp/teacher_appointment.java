package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class teacher_appointment extends AppCompatActivity {
    private List<Appointment> apList = new ArrayList<>();
    private Button m_btn_back,ap_done,ap_undone,ap_all;
    private String uid="";
    private SQLiteDatabase sqldb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_appointment);
        Intent intent=getIntent();
        uid=intent.getStringExtra("uid");
        sqldb=openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        init("%");
        ApAdapter adapter = new ApAdapter(teacher_appointment.this,R.layout.appointment_list_item,apList);
        ListView listView = (ListView) findViewById(R.id.appointment_list);
        listView.setAdapter(adapter);
        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Appointment appointment = apList.get(position);
                Toast.makeText(teacher_appointment.this,appointment.getCoursename(),Toast.LENGTH_SHORT).show();
            }
        });
        m_btn_back = findViewById(R.id.btn_back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacher_appointment.this.finish();
            }
        });
        ap_all = findViewById(R.id.btn_all);
        ap_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init("%");
                ApAdapter adapter = new ApAdapter(teacher_appointment.this,R.layout.appointment_list_item,apList);
                listView.setAdapter(adapter);
            }
        });
        ap_done = findViewById(R.id.btn_out);
        ap_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init("1");
                ApAdapter adapter = new ApAdapter(teacher_appointment.this,R.layout.appointment_list_item,apList);
                listView.setAdapter(adapter);
            }
        });
        ap_undone =findViewById(R.id.btn_in);
        ap_undone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init("0");
                ApAdapter adapter = new ApAdapter(teacher_appointment.this,R.layout.appointment_list_item,apList);
                listView.setAdapter(adapter);
            }
        });
    }
    @SuppressLint("Range")
    private void init(String done){
        apList.clear();
        String args[] = {uid,done};
        sqldb = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        Cursor c = sqldb.rawQuery("SELECT * FROM appointment where teacherid=? and done like ?", args);
        ArrayList<String> cids = new ArrayList<>();
        ArrayList<String> tids = new ArrayList<>();
        ArrayList<String> dates = new ArrayList<>();
        ArrayList<String> dones = new ArrayList<>();
        ArrayList<String> sids = new ArrayList<>();
        System.out.println("done"+done);
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                cids.add(c.getString(c.getColumnIndex("courseid")));
                tids.add(c.getString(c.getColumnIndex("teacherid")));
                dates.add(c.getString(c.getColumnIndex("date")));
                dones.add(c.getString(c.getColumnIndex("done")));
                sids.add(c.getString(c.getColumnIndex("studentid")));
            }
            c.close();
        }
        System.out.println(cids.size());
        for(int i=0;i<cids.size();i++){
            Appointment a = new Appointment(uid);
            a.setDate(dates.get(i));
            a.setDone(dones.get(i));
            String arg[] = {tids.get(i)};
            System.out.println(arg[0]);
            c = sqldb.rawQuery("SELECT * FROM teacher where id=?", arg);
            if (c != null && c.getCount() > 0) {
                while (c.moveToNext()) {
                    a.setTeacherid(arg[0]);
                    a.setTeachername(c.getString(c.getColumnIndex("name")));
                }
                c.close();
            }
            arg[0] = cids.get(i);
            c = sqldb.rawQuery("SELECT * FROM course where id=?", arg);
            if (c != null && c.getCount() > 0) {
                while (c.moveToNext()) {
                    a.setCourseid(arg[0]);
                    a.setCoursename(c.getString(c.getColumnIndex("name")));
                }
                c.close();
            }
            arg[0] = sids.get(i);
            c = sqldb.rawQuery("SELECT * FROM student where id=?", arg);
            if (c != null && c.getCount() > 0) {
                while (c.moveToNext()) {
                    a.setStudentname(c.getString(c.getColumnIndex("name")));
                }
                c.close();
            }
            apList.add(a);
        }
    }
}
