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
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class select_student extends AppCompatActivity {
    private List<Torder> orderList = new ArrayList<>();
    private Spinner province,course,gender;
    private Button m_btn_back,btn_con;
    private String uid="",sprovince="",scourse="",sgender="";
    private SQLiteDatabase db;
    @Override
    @SuppressLint("range")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_student);
        Intent intent=getIntent();
        uid=intent.getStringExtra("uid");
        System.out.println("uid"+uid);
        db=openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        init();
        System.out.println("*"+sprovince+"*"+scourse+"*"+sgender);
        province=findViewById(R.id.province);
        course=findViewById(R.id.course);
        gender=findViewById(R.id.gender);
        TorderAdapter adapter = new TorderAdapter(select_student.this,R.layout.torder_list_item,orderList);
        ListView listView = (ListView) findViewById(R.id.order_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Torder torder = orderList.get(position);
                Toast.makeText(select_student.this,torder.getNum(),Toast.LENGTH_SHORT).show();
            }
        });
        btn_con=findViewById(R.id.con);
        btn_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderList.clear();
                sprovince=province.getSelectedItem().toString();
                scourse=course.getSelectedItem().toString();
                sgender=gender.getSelectedItem().toString();
                System.out.println(""+uid+sprovince+sgender+scourse);
                Cursor c=db.rawQuery("SELECT * FROM orderlists WHERE taketeacherid=? and home=? and sex=? and subject=?",new String[]{uid,
                        sprovince,sgender,scourse});
                if(c!=null&&c.moveToFirst())
                {
                    do{
                        Torder t=new Torder("订单编号："+c.getString(c.getColumnIndex("id")),
                                "求教科目："+scourse,
                                "地区："+sprovince,
                                "时间："+c.getString(c.getColumnIndex("time")));
                        orderList.add(t);
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
                select_student.this.finish();
            }
        });
    }
    @SuppressLint("range")
    private void init(){
        orderList.clear();
        Cursor c=db.rawQuery("SELECT * FROM orderlists WHERE taketeacherid=?",new String[]{uid});
        if(c!=null&&c.moveToFirst())
        {
            do{
                Torder t=new Torder("订单编号："+c.getString(c.getColumnIndex("id")),
                        "求教科目："+c.getString(c.getColumnIndex("subject")),
                        "地区："+c.getString(c.getColumnIndex("home")),
                        "时间："+c.getString(c.getColumnIndex("time")));
                orderList.add(t);
            }while(c.moveToNext());
        }
        c.close();
    }
}
