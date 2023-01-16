package com.example.myapp;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.view.LayoutInflater;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class message extends Fragment {
    private List<Messager> mssList = new ArrayList<>();
    public  String userid;
    private SQLiteDatabase sqldb;
    private Button msssearch;
    private EditText mssid;
    private static String PACKAGE_NAME = "com.example.myapp"; //包名
    private static String DB_PATH =  "/data" + Environment.getDataDirectory().getAbsolutePath() + "/" + PACKAGE_NAME + "/databases/";
    private static String DB_NAME = "asdb";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_message,container,false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        msssearch = getActivity().findViewById(R.id.msssearch);
        mssid = getActivity().findViewById(R.id.mssid);
        MssAdapter adapter = new MssAdapter(getActivity(),R.layout.appointment_list_item,mssList);
        ListView listView = getActivity().findViewById(R.id.message_list);
        listView.setAdapter(adapter);
        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Messager) Messager) = apList.get(position);
                Intent intent = new Intent(getActivity(), talk.class);
                intent.putExtra("userid",userid);
                intent.putExtra("toid",mssList.get(position).getOps());
                startActivity(intent);
            }
        });

        msssearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search_data();
                MssAdapter adapter = new MssAdapter(getActivity(),R.layout.appointment_list_item,mssList);
                listView.setAdapter(adapter);
            }
        });
    }
    @SuppressLint("Range")
    private void init(){
        String args[] = {userid};
        String myPath = DB_PATH + DB_NAME;
        sqldb = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        Cursor c = sqldb.rawQuery("SELECT * FROM message where fid=? or toid=?", args);
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                Messager a = new Messager(userid);
                a.setFid(c.getString(c.getColumnIndex("fid")));
                a.setToid(c.getString(c.getColumnIndex("toid")));
                a.setDate(c.getString(c.getColumnIndex("date")));
                a.setText(c.getString(c.getColumnIndex("text")));
                a.setoo();
                System.out.println(a.getText());
                int flag=0;
                for (int i = 0; i < mssList.size(); i++){
                    if(mssList.get(i).getOps().equals(a.getOps()))
                        flag=1;
                }
                if(flag==0) mssList.add(a);
            }
            c.close();
            for (int i = 0; i < mssList.size(); i++) {
                String arg[] = {mssList.get(i).getOps()};
                Cursor cc = sqldb.rawQuery("SELECT * FROM user where id=?", arg);
                if (cc != null && cc.getCount() > 0) {
                    while (cc.moveToNext()) {
                        mssList.get(i).setOname(cc.getString(cc.getColumnIndex("username")));
                    }
                }
                cc.close();
            }
            sqldb.close();
        }
    }


    @SuppressLint("Range")
    private void search_data() {
        mssList.clear();
        String msid = mssid.getText().toString();
        String where = "where id like ?";
        String args[] = {msid};
        String myPath = DB_PATH + DB_NAME;
        sqldb = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        Cursor c = sqldb.rawQuery("SELECT * FROM user " + where, args);
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                Messager a = new Messager(userid);;
                a.setOps(c.getString(c.getColumnIndex("id")));
                a.setOname(c.getString(c.getColumnIndex("username")));
                mssList.add(a);
            }
            c.close();
        }
        sqldb.close();
    }



}