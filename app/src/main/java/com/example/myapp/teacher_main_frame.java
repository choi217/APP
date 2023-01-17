package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class teacher_main_frame extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private String teacherid;
    private String sphone,susername="";
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main_frame);
        Intent intent =getIntent();
        teacherid = intent.getStringExtra("teacherid");
        SQLiteDatabase db=openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        Cursor c=db.rawQuery("SELECT * FROM teacher WHERE id=?",new String[]{teacherid});
        if(c.getCount()>0)
        {
            c.moveToFirst();
            sphone=c.getString(c.getColumnIndex("phone"));
        }
        c.close();
        Cursor d=db.rawQuery("SELECT * FROM user WHERE id=?",new String[]{teacherid});
        d.moveToFirst();
        susername=d.getString(d.getColumnIndex("username"));
        d.close();
        System.out.println("main frame id" + teacherid);
        if (savedInstanceState == null){
            teacher_mainpage teacher_mainpage = new teacher_mainpage();
            teacher_mainpage.teacherid=teacherid;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment,teacher_mainpage).commit();
        }
        initView();
        //replaceFragment(new subject_choose());

    }

    public void initView() {
        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);//设置导航栏监听器
        //bottomNavigationView.setSelectedItemId(R.id.home);//设置默认选择的导航栏子项首页
        bottomNavigationView.setItemIconTintList(null);//取消导航栏子项图片的颜色覆盖
    }

    @Override
    //处理导航栏子项的点击事件
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();//获取点击的位置以及对应的id
        switch (itemId) {
            case R.id.home:
                teacher_mainpage teacher_mainpage=new teacher_mainpage();
                teacher_mainpage.teacherid=teacherid;
                replaceFragment(teacher_mainpage);
                menuItem.setChecked(true);
                break;
            case R.id.message:
                message message=new message();
                message.userid=teacherid;
                replaceFragment(message);
                menuItem.setChecked(true);
                break;
            case R.id.person:
                teacher_space teacher_space=new teacher_space();
                teacher_space.teacherid=teacherid;
                teacher_space.sphone=sphone;
                teacher_space.susername=susername;
                replaceFragment(teacher_space);
                menuItem.setChecked(true);
                break;
        }
        return false;
    }

    //替换Fragment的方法
    public void replaceFragment(Fragment fragment) {
        Bundle bundle = new Bundle();
        bundle.putString("teacherid",teacherid);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment, fragment);
        transaction.commit();
    }
}