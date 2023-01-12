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

public class myteacher_list extends AppCompatActivity {
    private List<Teacher> teaList = new ArrayList<>();
    private Button m_btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myteacher_list);

        init();
        TeaAdapter adapter = new TeaAdapter(myteacher_list.this,R.layout.teacher_list_item,teaList);
        ListView listView = (ListView) findViewById(R.id.teacher_list);
        listView.setAdapter(adapter);
        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Teacher tea = teaList.get(position);
                Toast.makeText(myteacher_list.this,tea.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        m_btn_back = findViewById(R.id.btn_back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myteacher_list.this.finish();
            }
        });
    }
    private void init(){
        Teacher a = new Teacher("王狗蛋", R.drawable.a);
        teaList.add(a);
        Teacher b = new Teacher("王铁蛋", R.drawable.b);
        teaList.add(b);
    }

}
