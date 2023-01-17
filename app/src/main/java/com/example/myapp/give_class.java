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

public class give_class extends AppCompatActivity {
    private List<Appointment> apList = new ArrayList<>();
    private Button m_btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_class);

        init();
        ApAdapter adapter = new ApAdapter(give_class.this,R.layout.appointment_list_item,apList);
        ListView listView = (ListView) findViewById(R.id.gclass_list);
        listView.setAdapter(adapter);
        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Appointment appointment = apList.get(position);
                Toast.makeText(give_class.this,appointment.getCoursename(),Toast.LENGTH_SHORT).show();
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
    private void init(){
        Appointment a = new Appointment("语文");
        apList.add(a);
        Appointment b = new Appointment("数学");
        apList.add(b);
    }
}
