package com.example.myapp;
import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class teacher_list extends AppCompatActivity {
    private List<Teacher> teaList = new ArrayList<>();
    private Button m_btn_back;
    private Button m_btn_search;
    private SQLiteDatabase sqldb;
    private Spinner province,course,education,gender,class_way,tsort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_list);
        sqldb = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        init();
        province=findViewById(R.id.province);
        course=findViewById(R.id.course);
        education=findViewById(R.id.education);
        gender=findViewById(R.id.gender);
        class_way=findViewById(R.id.class_way);
        tsort=findViewById(R.id.sort);
        TeaAdapter adapter = new TeaAdapter(teacher_list.this,R.layout.teacher_list_item,teaList);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Teacher tea = teaList.get(position);
                Intent intent = new Intent(teacher_list.this, teacher_info_show.class);
                intent.putExtra("teacherid",tea.getId());
                startActivity(intent);
            }
        });
        m_btn_back = findViewById(R.id.btn_back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacher_list.this.finish();
            }
        });
        m_btn_search = findViewById(R.id.search);
        m_btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search_data();
                TeaAdapter adapter = new TeaAdapter(teacher_list.this,R.layout.teacher_list_item,teaList);
                listView.setAdapter(adapter);
            }
        });
    }
    @SuppressLint("Range")
    private void init() {
        String args[] = {};
        Cursor c = sqldb.rawQuery("SELECT * FROM teacher", args);
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                String sex = c.getString(c.getColumnIndex("sex"));
                String name = c.getString(c.getColumnIndex("name"));
                int imageId = sex.equals("男")?R.drawable.a:R.drawable.b;
                Teacher a = new Teacher(name, imageId,"123");
                a.setAge(c.getInt(c.getColumnIndex("age")));
                a.setDegree(c.getString(c.getColumnIndex("degree")));
                a.setHome(c.getString(c.getColumnIndex("home")));
                a.setId(c.getString(c.getColumnIndex("id")));
                a.setMajor(c.getString(c.getColumnIndex("major")));
                a.setMoneyrequest(c.getString(c.getColumnIndex("moneyrequest")));
                a.setOtherinfo(c.getString(c.getColumnIndex("otherinfo")));
                a.setPhone(c.getString(c.getColumnIndex("phone")));
                a.setProvince(c.getString(c.getColumnIndex("province")));
                a.setTeachmethod(c.getString(c.getColumnIndex("teachmethod")));
                a.setSchool(c.getString(c.getColumnIndex("school")));
                a.setScore(c.getFloat(c.getColumnIndex("score")));
                a.setSubject(c.getString(c.getColumnIndex("subject")));
                System.out.println(a.getHome());
                teaList.add(a);
            }
            c.close();
        }
    }

    @SuppressLint("Range")
    private void search_data() {
        teaList.clear();
        String protext = province.getSelectedItem().toString();
        String coutext = course.getSelectedItem().toString();
        String edutext = education.getSelectedItem().toString();
        String gentext = gender.getSelectedItem().toString();
        String waytext = class_way.getSelectedItem().toString();
        String sorttext = tsort.getSelectedItem().toString();
        String where = "where province Like ? AND subject Like ? AND degree Like ? AND " +
                "sex Like ? AND teachmethod Like ? ";
        SpinnerAdapter pro=province.getAdapter();
        SpinnerAdapter cou=course.getAdapter();
        SpinnerAdapter edu=education.getAdapter();
        SpinnerAdapter gen=gender.getAdapter();
        SpinnerAdapter way=class_way.getAdapter();
        SpinnerAdapter sort=tsort.getAdapter();
        String args[] = {"%","%","%","%","%"};
        String order = "";
        if(sorttext.equals(sort.getItem(0).toString())){
            order = "order by score,hot desc";
        }else if(sorttext.equals(sort.getItem(1).toString())){
            order = "order by score desc";
        }else{
            order = "order by hot desc";
        }
        if(!protext.equals(pro.getItem(0).toString())){
            args[0] = protext;
        }
        if(!coutext.equals(cou.getItem(0).toString())){
            args[1] = coutext;
        }
        if(!edutext.equals(edu.getItem(0).toString())){
            args[2] = edutext;
        }
        if(!gentext.equals(gen.getItem(0).toString())){
            args[3] = gentext;
        }
        if(!waytext.equals(way.getItem(0).toString())){
            args[4] = waytext;
        }
        Cursor c = sqldb.rawQuery("SELECT * FROM teacher " + where +order, args);
        System.out.println(args[0] + args[1] + args[2] + args[3] +args[4] );
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                String sex = c.getString(c.getColumnIndex("sex"));
                String name = c.getString(c.getColumnIndex("name"));
                int imageId = sex.equals("男")?R.drawable.a:R.drawable.b;
                Teacher a = new Teacher(name, imageId,"123");
                a.setAge(c.getInt(c.getColumnIndex("age")));
                a.setDegree(c.getString(c.getColumnIndex("degree")));
                a.setHome(c.getString(c.getColumnIndex("home")));
                a.setId(c.getString(c.getColumnIndex("id")));
                a.setMajor(c.getString(c.getColumnIndex("major")));
                a.setMoneyrequest(c.getString(c.getColumnIndex("moneyrequest")));
                a.setOtherinfo(c.getString(c.getColumnIndex("otherinfo")));
                a.setPhone(c.getString(c.getColumnIndex("phone")));
                a.setProvince(c.getString(c.getColumnIndex("province")));
                a.setTeachmethod(c.getString(c.getColumnIndex("teachmethod")));
                a.setSchool(c.getString(c.getColumnIndex("school")));
                a.setScore(c.getFloat(c.getColumnIndex("score")));
                a.setSubject(c.getString(c.getColumnIndex("subject")));
                System.out.println(a.getHome());
                teaList.add(a);
            }
            c.close();
        }
    }

}