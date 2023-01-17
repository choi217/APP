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

public class eval_list extends AppCompatActivity {
    private List<Evaluate> evalList = new ArrayList<>();
    private Button m_btn_back,btn_all,btn_1,btn_2,btn_3;
    private String uid="";
    private SQLiteDatabase db;
    @Override
    @SuppressLint("range")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eval_list);
        Intent intent=getIntent();
        uid=intent.getStringExtra("uid");
        db=openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        init();
        EvaluateAdapter adapter = new EvaluateAdapter(eval_list.this,R.layout.eval_list_item,evalList);
        ListView listView = (ListView) findViewById(R.id.eval_list);
        listView.setAdapter(adapter);
        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Evaluate eval = evalList.get(position);
                Toast.makeText(eval_list.this,eval.getEvaluate(),Toast.LENGTH_SHORT).show();
            }
        });
        btn_all=findViewById(R.id.btn_all);
        btn_1=findViewById(R.id.btn_1);
        btn_2=findViewById(R.id.btn_2);
        btn_3=findViewById(R.id.btn_3);
        btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evalList.clear();
                Cursor c=db.rawQuery("SELECT * FROM studentteacher WHERE teacherid=?",new String[]{uid});
                if(c!=null&&c.moveToFirst()) {
                    while (c.moveToNext()) {
                        String name = "";
                        Cursor d = db.rawQuery("SELECT name FROM student WHERE id=?", new String[]{c.getString(c.getColumnIndex("student"))});
                        if (d.getCount() > 0) {
                            d.moveToFirst();
                            name = d.getString(d.getColumnIndex("name"));
                        }
                        Evaluate t = new Evaluate(c.getString(c.getColumnIndex("level")), name,
                                c.getString(c.getColumnIndex("evaluate")));
                        d.close();
                        evalList.add(t);
                    }
                }
                c.close();
                adapter.notifyDataSetChanged();
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evalList.clear();
                Cursor c=db.rawQuery("SELECT * FROM studentteacher WHERE teacherid=?",new String[]{uid});
                String l="";
                if(c!=null&&c.moveToFirst()) {
                    while (c.moveToNext()) {
                        String name = "";
                        Cursor d = db.rawQuery("SELECT name FROM student WHERE id=?", new String[]{c.getString(c.getColumnIndex("student"))});
                        if (d.getCount() > 0) {
                            d.moveToFirst();
                            name = d.getString(d.getColumnIndex("name"));
                        }
                        l=c.getString(c.getColumnIndex("level"));
                        Evaluate t = new Evaluate(l, name,c.getString(c.getColumnIndex("evaluate")));
                        d.close();
                        if(l.equals("好评"))evalList.add(t);
                    }
                }
                c.close();
                adapter.notifyDataSetChanged();
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evalList.clear();
                Cursor c=db.rawQuery("SELECT * FROM studentteacher WHERE teacherid=?",new String[]{uid});
                String l="";
                if(c!=null&&c.moveToFirst()) {
                    while (c.moveToNext()) {
                        String name = "";
                        Cursor d = db.rawQuery("SELECT name FROM student WHERE id=?", new String[]{c.getString(c.getColumnIndex("student"))});
                        if (d.getCount() > 0) {
                            d.moveToFirst();
                            name = d.getString(d.getColumnIndex("name"));
                        }
                        l=c.getString(c.getColumnIndex("level"));
                        Evaluate t = new Evaluate(l, name,c.getString(c.getColumnIndex("evaluate")));
                        d.close();
                        if(l.equals("中评"))evalList.add(t);
                    }
                }
                c.close();
                adapter.notifyDataSetChanged();
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evalList.clear();
                Cursor c=db.rawQuery("SELECT * FROM studentteacher WHERE teacherid=?",new String[]{uid});
                String l="";
                if(c!=null&&c.moveToFirst()) {
                    while (c.moveToNext()) {
                        String name = "";
                        Cursor d = db.rawQuery("SELECT name FROM student WHERE id=?", new String[]{c.getString(c.getColumnIndex("student"))});
                        if (d.getCount() > 0) {
                            d.moveToFirst();
                            name = d.getString(d.getColumnIndex("name"));
                        }
                        l=c.getString(c.getColumnIndex("level"));
                        Evaluate t = new Evaluate(l, name,c.getString(c.getColumnIndex("evaluate")));
                        d.close();
                        if(l.equals("差评"))evalList.add(t);
                    }
                }
                c.close();
                adapter.notifyDataSetChanged();
            }
        });
        m_btn_back = findViewById(R.id.btn_back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eval_list.this.finish();
            }
        });
    }
    @SuppressLint("range")
    private void init(){
        evalList.clear();
        Cursor c=db.rawQuery("SELECT * FROM studentteacher WHERE teacherid=?",new String[]{uid});
        if(c!=null&&c.moveToFirst()) {
            while (c.moveToNext()) {
                String name = "";
                Cursor d = db.rawQuery("SELECT name FROM student WHERE id=?", new String[]{c.getString(c.getColumnIndex("student"))});
                if (d.getCount() > 0) {
                    d.moveToFirst();
                    name = d.getString(d.getColumnIndex("name"));
                }
                Evaluate t = new Evaluate(c.getString(c.getColumnIndex("level")), name,
                        c.getString(c.getColumnIndex("evaluate")));
                d.close();
                evalList.add(t);
            }
        }
        c.close();
    }
}
