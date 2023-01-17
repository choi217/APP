package com.example.myapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends ArrayAdapter<Order> {
    private int resourceId;
    private SQLiteDatabase sqldb;
    private static String PACKAGE_NAME = "com.example.myapp"; //包名
    private static String DB_PATH =  "/data" + Environment.getDataDirectory().getAbsolutePath() + "/" + PACKAGE_NAME + "/databases/";
    private static String DB_NAME = "asdb";
    public OrderAdapter(Context context, int textViewResourceId, List<Order> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Order order = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }
        else{
            view = convertView;
        }
        TextView orderinfo =  (TextView) view.findViewById(R.id.order_info);
        orderinfo.setText("订单信息:编号:" + order.getId() + " 年级:"+order.getGrade());
        TextView teacherinfo =  (TextView) view.findViewById(R.id.teacher_info);
        String ts = "已预约";
        if(order.getTaketeacherid().equals("-1")) ts = "未预约";
        teacherinfo.setText("老师信息:" + ts);
        TextView moneyinfo =  (TextView) view.findViewById(R.id.money_info);
        moneyinfo.setText("价格:"+order.getSalary());
        Button button1 = (Button) view.findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myPath = DB_PATH + DB_NAME;
                String args[] = {order.getId()};
                sqldb = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
                Cursor c = sqldb.rawQuery("DELETE FROM message where id=?",args );
                c.close();

            }
        });
        return view;
    }
}
