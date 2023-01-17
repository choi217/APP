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

public class teacher_order extends AppCompatActivity {
    private List<Torder> orderList = new ArrayList<>();
    private Button m_btn_back,btn_all,btn_in,btn_out;
    private String uid="";
    private SQLiteDatabase db;
    @Override
    @SuppressLint("range")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_order);
        Intent intent=getIntent();
        uid=intent.getStringExtra("uid");
        db=openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        init();
        TorderAdapter adapter = new TorderAdapter(teacher_order.this,R.layout.torder_list_item,orderList);
        ListView listView = (ListView) findViewById(R.id.order_list);
        listView.setAdapter(adapter);
        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Torder torder = orderList.get(position);
                Toast.makeText(teacher_order.this,torder.getNum(),Toast.LENGTH_SHORT).show();
            }
        });
        btn_all=findViewById(R.id.or_all);
        btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderList.clear();
                Cursor c=db.rawQuery("SELECT * FROM orderlists WHERE taketeacherid=?",new String[]{uid});
                if(c!=null&&c.moveToFirst()) {
                    do{
                        Torder t=new Torder("订单编号："+c.getString(c.getColumnIndex("id")),
                                "求教科目："+c.getString(c.getColumnIndex("subject")),
                                "地区："+c.getString(c.getColumnIndex("home")),
                                "时间："+c.getString(c.getColumnIndex("time")));
                        orderList.add(t);
                    }while (c.moveToNext());
                }
                c.close();
                adapter.notifyDataSetChanged();
            }
        });
        btn_in=findViewById(R.id.or_in);
        btn_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderList.clear();
                Cursor d=db.rawQuery("SELECT province FROM teacher WHERE id=?",new String[]{uid});
                String tprovince="";
                if(d.getCount()>0)
                {
                    d.moveToFirst();
                    tprovince=d.getString(d.getColumnIndex("province"));
                }
                d.close();
                Cursor c=db.rawQuery("SELECT * FROM orderlists WHERE taketeacherid=?",new String[]{uid});
                if(c!=null&&c.moveToFirst()) {
                    do{
                        Torder t=new Torder("订单编号："+c.getString(c.getColumnIndex("id")),
                                "求教科目："+c.getString(c.getColumnIndex("subject")),
                                "地区："+c.getString(c.getColumnIndex("home")),
                                "时间："+c.getString(c.getColumnIndex("time")));
                        if(tprovince.equals(c.getString(c.getColumnIndex("home"))))orderList.add(t);
                    }while (c.moveToNext());
                }
                c.close();
                adapter.notifyDataSetChanged();
            }
        });
        btn_out=findViewById(R.id.or_out);
        btn_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderList.clear();
                Cursor d=db.rawQuery("SELECT province FROM teacher WHERE id=?",new String[]{uid});
                String tprovince="";
                if(d.getCount()>0)
                {
                    d.moveToFirst();
                    tprovince=d.getString(d.getColumnIndex("province"));
                }
                d.close();
                Cursor c=db.rawQuery("SELECT * FROM orderlists WHERE taketeacherid=?",new String[]{uid});
                if(c!=null&&c.moveToFirst()) {
                    do{
                        Torder t=new Torder("订单编号："+c.getString(c.getColumnIndex("id")),
                                "求教科目："+c.getString(c.getColumnIndex("subject")),
                                "地区："+c.getString(c.getColumnIndex("home")),
                                "时间："+c.getString(c.getColumnIndex("time")));
                        if(!tprovince.equals(c.getString(c.getColumnIndex("home"))))orderList.add(t);
                    }while (c.moveToNext());
                }
                c.close();
                adapter.notifyDataSetChanged();
            }
        });
        m_btn_back = findViewById(R.id.btn_back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacher_order.this.finish();
            }
        });
    }
    @SuppressLint("range")
    private void init(){
        orderList.clear();
//                Cursor d=db.rawQuery("SELECT province FROM teacher WHERE id=?",new String[]{uid});
//                if(d.getCount()>0)
//                {
//                    d.moveToFirst();
//                    String tprovince=d.getString(d.getColumnIndex("province"));
//                }
//                d.close();
        Cursor c=db.rawQuery("SELECT * FROM orderlists WHERE taketeacherid=?",new String[]{uid});
        if(c!=null&&c.moveToFirst()) {
            do{
                Torder t=new Torder("订单编号："+c.getString(c.getColumnIndex("id")),
                        "求教科目："+c.getString(c.getColumnIndex("subject")),
                        "地区："+c.getString(c.getColumnIndex("home")),
                        "时间："+c.getString(c.getColumnIndex("time")));
                orderList.add(t);
            }while (c.moveToNext());
        }
        c.close();
    }

}
