package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class select_student extends AppCompatActivity {
    private List<Torder> orderList = new ArrayList<>();
    private Button m_btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_student);

        init();
        TorderAdapter adapter = new TorderAdapter(select_student.this,R.layout.torder_list_item,orderList);
        ListView listView = (ListView) findViewById(R.id.order_list);
        listView.setAdapter(adapter);
        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Torder torder = orderList.get(position);
                Toast.makeText(select_student.this,torder.getNum(),Toast.LENGTH_SHORT).show();
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
    private void init(){
        Torder a = new Torder("订单编号：32443", "求教科目：语文数学","地区：长沙岳麓区","申请人数：3");
        orderList.add(a);
        Torder b = new Torder("订单编号：23232","求教科目：英语物理","地区：长沙雨花区","申请人数：6");
        orderList.add(b);
    }
}
