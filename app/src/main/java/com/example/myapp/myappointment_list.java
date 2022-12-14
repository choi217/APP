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

public class myappointment_list extends AppCompatActivity {
    private List<Appointment> apList = new ArrayList<>();
    private Button m_btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myappointment_list);

        init();
        ApAdapter adapter = new ApAdapter(myappointment_list.this,R.layout.appointment_list_item,apList);
        ListView listView = (ListView) findViewById(R.id.appointment_list);
        listView.setAdapter(adapter);
        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Appointment appointment = apList.get(position);
                Toast.makeText(myappointment_list.this,appointment.getCourse(),Toast.LENGTH_SHORT).show();
            }
        });
        m_btn_back = findViewById(R.id.btn_back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myappointment_list.this.finish();
            }
        });
    }
    private void init(){
        Appointment a = new Appointment("语文","2023.1.30");
        apList.add(a);
        Appointment b = new Appointment("数学", "2023.2.3");
        apList.add(b);
    }
}
