package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class talk extends AppCompatActivity {
    List<Msg> list  =new ArrayList<>();
    EditText text ;
    private String userid,toid;
    private SQLiteDatabase sqldb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk);
        Intent intent =getIntent();
        userid =intent.getStringExtra("userid");
        toid = intent.getStringExtra("toid");
        initData();
        final RecyclerView recyclerView  = findViewById(R.id.rlv);
        final MsgAdapter msgAdapter = new MsgAdapter(list);
        text = findViewById(R.id.et_info);
        Button bt = findViewById(R.id.bt_send);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(msgAdapter);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 这里还是利用随机数来生成消息的类型\
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                String da =simpleDateFormat.format(date);
                Msg msg = new Msg(text.getText().toString(),1);
                sqldb = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
                try {;
                    sqldb.execSQL("INSERT INTO message(fid,toid,date,text) values(?,?,?,?)",
                            new Object[]{userid,toid,da,text.getText().toString()});
                }catch(Exception e){
                    e.printStackTrace();
                    e.toString();
                }
                sqldb.close();
                list.add(msg);
                // 表示在消息的末尾插入内容
                msgAdapter.notifyItemInserted(list.size()-1);
                // 让 RecyclerView 自动滚动到最底部
                recyclerView.scrollToPosition(list.size()-1);
                // 清空内容
                text.setText("");
            }});
    }
    @SuppressLint("Range")
    public void initData(){
        String args[] = {userid,toid,toid,userid};
        sqldb = openOrCreateDatabase("asdb", Context.MODE_PRIVATE, null);
        Cursor c = sqldb.rawQuery("SELECT * FROM message where (fid=? and toid=?) or (fid=? and toid=?) order by datetime(date)", args);
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                String ffid = c.getString(c.getColumnIndex("fid"));
                String text = c.getString(c.getColumnIndex("text"));
                int ty = ffid.equals(userid)?1:0;
                Msg msg = new Msg(text,ty);
                list.add(msg);
            }
            c.close();
        }
        sqldb.close();
    }
}
