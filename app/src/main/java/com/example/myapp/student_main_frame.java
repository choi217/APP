package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class student_main_frame extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private String studentid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frame);
        Intent intent =getIntent();
        studentid = intent.getStringExtra("studentid");
        System.out.println("main frame id" + studentid);
        if (savedInstanceState == null){
            student_mainpage student_mainpage = new student_mainpage();
            student_mainpage.studentid =studentid;
            replaceFragment(student_mainpage);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment,student_mainpage).commit();
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
                student_mainpage student_mainpage = new student_mainpage();
                student_mainpage.studentid =studentid;
                replaceFragment(student_mainpage);
                menuItem.setChecked(true);
                break;
            case R.id.message:
                message message =new message();
                message.userid =studentid;
                replaceFragment(message);
                menuItem.setChecked(true);
                break;
            case R.id.person:
                student_space student_space =new student_space();
                student_space.studentid = studentid;
                replaceFragment(student_space);
                menuItem.setChecked(true);
                break;
        }
        return false;
    }

    //替换Fragment的方法
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment, fragment);
        transaction.commit();
    }
}