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

public class myorder_list extends AppCompatActivity {
    private List<Order> orderList = new ArrayList<>();
    private Button m_btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder_list);

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
    private void init(){
        Order a = new Order("订单信息：订单号：98923 三年级 科目：语文","老师信息：未预约","价格：待定");
        orderList.add(a);
        Order b = new Order("订单信息：订单号：93423 高一 科目：数学", "老师信息：已预约","价格：每小时100元");
        orderList.add(b);
    }
}
