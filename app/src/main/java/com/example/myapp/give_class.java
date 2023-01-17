package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class give_class extends AppCompatActivity {
    private List<GiveClass> apList = new ArrayList<>();
    private Button m_btn_back,btn_all,btn_in,btn_out;
    private String uid="";
    private SQLiteDatabase db;
    @Override
    @SuppressLint("Range")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_class);
        Intent intent=getIntent();
        uid=intent.getStringExtra("uid");
        db=openOrCreateDatabase("asdb",Context.MODE_PRIVATE, null);
        System.out.println(uid);
        init();
        GcAdapter adapter = new GcAdapter(give_class.this,R.layout.appointment_list_item,apList);
        ListView listView = (ListView) findViewById(R.id.gclass_list);
        listView.setAdapter(adapter);
        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GiveClass appointment = apList.get(position);
                Toast.makeText(give_class.this,appointment.getCoursename(),Toast.LENGTH_SHORT).show();
            }
        });
        btn_all=findViewById(R.id.btn_all);
        btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apList.clear();
                init();
                adapter.notifyDataSetChanged();
            }
        });
        btn_in=findViewById(R.id.btn_in);
        btn_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apList.clear();
                Cursor c=db.rawQuery("SELECT * FROM teachercourse WHERE teacherid=?",new String[]{uid});
                String courseid="";
                if(c!=null&&c.moveToFirst()) {
                    do{
                        courseid = c.getString(c.getColumnIndex("courseid"));
                        System.out.println("&" + courseid);
                        Cursor d = db.rawQuery("SELECT * FROM course WHERE id=?", new String[]{courseid});
                        d.moveToFirst();
                        GiveClass t = new GiveClass(uid);
                        t.setCoursename(d.getString(d.getColumnIndex("name")));
                        t.setDate(c.getString(c.getColumnIndex("date")));
                        d = db.rawQuery("SELECT * FROM teacher WHERE id=?", new String[]{uid});
                        d.moveToFirst();
                        t.setTeachername(d.getString(d.getColumnIndex("name")));
                        if(c.getString(c.getColumnIndex("done")).equals("0"))apList.add(t);
                    }while(c.moveToNext());
                }
                c.close();
                adapter.notifyDataSetChanged();
            }
        });
        btn_out=findViewById(R.id.btn_out);
        btn_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apList.clear();
                Cursor c=db.rawQuery("SELECT * FROM teachercourse WHERE teacherid=?",new String[]{uid});
                String courseid="";
                if(c!=null&&c.moveToFirst()) {
                    do{
                        courseid = c.getString(c.getColumnIndex("courseid"));
                        System.out.println("&" + courseid);
                        Cursor d = db.rawQuery("SELECT * FROM course WHERE id=?", new String[]{courseid});
                        d.moveToFirst();
                        GiveClass t = new GiveClass(uid);
                        t.setCoursename(d.getString(d.getColumnIndex("name")));
                        t.setDate(c.getString(c.getColumnIndex("date")));
                        d = db.rawQuery("SELECT * FROM teacher WHERE id=?", new String[]{uid});
                        d.moveToFirst();
                        t.setTeachername(d.getString(d.getColumnIndex("name")));
                        if(c.getString(c.getColumnIndex("done")).equals("1"))apList.add(t);
                    }while(c.moveToNext());
                }
                c.close();
                adapter.notifyDataSetChanged();
            }
        });
        m_btn_back = findViewById(R.id.btn_back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                give_class.this.finish();
            }
        });
    }
    @SuppressLint("Range")
    private void init(){
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            System.out.println(LocalDate.now());
//        }
        Cursor c=db.rawQuery("SELECT * FROM teachercourse WHERE teacherid=?",new String[]{uid});
        String courseid="";
        if(c!=null&&c.moveToFirst()) {
            do{
                courseid = c.getString(c.getColumnIndex("courseid"));
                System.out.println("&" + courseid);
                Cursor d = db.rawQuery("SELECT * FROM course WHERE id=?", new String[]{courseid});
                d.moveToFirst();
                GiveClass t = new GiveClass(uid);
                t.setCoursename(d.getString(d.getColumnIndex("name")));
                t.setDate(c.getString(c.getColumnIndex("date")));
                d = db.rawQuery("SELECT * FROM teacher WHERE id=?", new String[]{uid});
                d.moveToFirst();
                t.setTeachername(d.getString(d.getColumnIndex("name")));
                apList.add(t);
            }while(c.moveToNext());
        }
        c.close();
    }
}
