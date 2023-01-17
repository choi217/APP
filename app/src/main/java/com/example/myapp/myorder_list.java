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

public class myorder_list extends AppCompatActivity {
    private List<Order> orderList = new ArrayList<>();
    private Button m_btn_back;
    private String studentid;
    private SQLiteDatabase sqldb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder_list);
        Intent intent= getIntent();
        studentid =intent.getStringExtra("studentid");
        init();
        OrderAdapter adapter = new OrderAdapter(myorder_list.this,R.layout.order_list_item,orderList);
        ListView listView = (ListView) findViewById(R.id.order_list);
        listView.setAdapter(adapter);
        m_btn_back = findViewById(R.id.btn_back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myorder_list.this.finish();
            }
        });

    }
    @SuppressLint("Range")
    private void init(){
        orderList.clear();
        String args[] = {studentid};
        sqldb = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        Cursor c = sqldb.rawQuery("SELECT * FROM orderlists where userid=?", args);
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                String id = c.getString(c.getColumnIndex("id"));
                Order a = new Order(id);
                a.setGrade(c.getString(c.getColumnIndex("grade")));
                a.setSubject(c.getString(c.getColumnIndex("subject")));
                a.setSalary(c.getString(c.getColumnIndex("salary")));
                a.setTaketeacherid(c.getString(c.getColumnIndex("taketeacherid")));
                orderList.add(a);
            }
            c.close();
        }
        sqldb.close();
    }
}
