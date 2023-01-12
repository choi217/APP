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

public class myclass_list extends AppCompatActivity {
    private List<Course> courseList = new ArrayList<>();
    private Button m_btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myclass_list);

        init();
        CourseAdapter adapter = new CourseAdapter(myclass_list.this,R.layout.class_list_item,courseList);
        ListView listView = (ListView) findViewById(R.id.class_list);
        listView.setAdapter(adapter);
        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course course = courseList.get(position);
                Toast.makeText(myclass_list.this,course.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        m_btn_back = findViewById(R.id.btn_back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myclass_list.this.finish();
            }
        });
    }
    private void init(){
        Course a = new Course("语文","王老师");
        courseList.add(a);
        Course b = new Course("数学", "张老师");
        courseList.add(b);
    }
}
