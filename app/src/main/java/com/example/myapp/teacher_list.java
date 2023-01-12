package com.example.myapp;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class teacher_list extends AppCompatActivity {
    private List<Teacher> teaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_list);

        init();
        TeaAdapter adapter = new TeaAdapter(teacher_list.this,R.layout.teacher_list_item,teaList);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Teacher tea = teaList.get(position);
                Toast.makeText(teacher_list.this,tea.getName(),Toast.LENGTH_SHORT).show();
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