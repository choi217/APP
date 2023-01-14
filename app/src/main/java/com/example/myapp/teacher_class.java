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

public class teacher_class extends AppCompatActivity {
    private List<Course> courseList = new ArrayList<>();
    private Button m_btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_class);

        init();
        CourseAdapter adapter = new CourseAdapter(teacher_class.this,R.layout.class_list_item,courseList);
        ListView listView = (ListView) findViewById(R.id.class_list);
        listView.setAdapter(adapter);
        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course course = courseList.get(position);
                Toast.makeText(teacher_class.this,course.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        m_btn_back = findViewById(R.id.btn_back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacher_class.this.finish();
            }
        });
    }
    private void init(){
        Course a = new Course("高三语文","基本信息");
        courseList.add(a);
        Course b = new Course("高二地理", "基本信息");
        courseList.add(b);
    }
}
