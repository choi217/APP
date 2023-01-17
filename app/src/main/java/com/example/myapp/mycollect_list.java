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

public class mycollect_list extends AppCompatActivity {
    private List<Teacher> teaList = new ArrayList<>();
    private Button m_btn_back;
    private SQLiteDatabase sqldb;
    private String studentid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycollect_list);
        Intent intent= getIntent();
        studentid =intent.getStringExtra("studentid");
        init();
        TeaAdapter adapter = new TeaAdapter(mycollect_list.this,R.layout.teacher_list_item,teaList);
        ListView listView = (ListView) findViewById(R.id.collect_list);
        listView.setAdapter(adapter);
        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Teacher tea = teaList.get(position);
                Intent intent = new Intent(mycollect_list.this, teacher_info_show.class);
                intent.putExtra("studentid",studentid);
                intent.putExtra("teacherid",tea.getId());
                startActivity(intent);
            }
        });
        m_btn_back = findViewById(R.id.btn_back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mycollect_list.this.finish();
            }
        });
    }
    @SuppressLint("Range")
    private void init(){
        teaList.clear();
        String args[] = {studentid};
        sqldb = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        Cursor c = sqldb.rawQuery("SELECT * FROM studentfavorite where studentid=?", args);
        ArrayList<String> tes = new ArrayList<>();
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                tes.add(c.getString(c.getColumnIndex("teacherid")));
            }
            c.close();
        }
        for(int i=0;i<tes.size();i++){
            String arg[]={tes.get(i)};
            c = sqldb.rawQuery("SELECT * FROM teacher where id=?", arg);
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
        sqldb.close();
    }

}
