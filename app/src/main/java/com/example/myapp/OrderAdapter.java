package com.example.myapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends ArrayAdapter<Order> {
    private int resourceId;

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
        orderinfo.setText(order.getOrder());
        TextView teacherinfo =  (TextView) view.findViewById(R.id.teacher_info);
        teacherinfo.setText(order.getTeacher());
        TextView moneyinfo =  (TextView) view.findViewById(R.id.money_info);
        moneyinfo.setText(order.getMoney());
        Button button1 = (Button) view.findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        return view;
    }
}
