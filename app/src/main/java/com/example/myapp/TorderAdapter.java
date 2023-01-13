package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class TorderAdapter extends ArrayAdapter<Torder> {
    private int resourceId;

    public TorderAdapter(Context context, int textViewResourceId, List<Torder> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Torder torder = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }
        else{
            view = convertView;
        }
        TextView num =  (TextView) view.findViewById(R.id.order_num);
        num.setText(torder.getNum());
        TextView course =  (TextView) view.findViewById(R.id.order_course);
        course.setText(torder.getCourse());
        TextView place =  (TextView) view.findViewById(R.id.order_place);
        place.setText(torder.getPlace());
        TextView people =  (TextView) view.findViewById(R.id.order_people);
        people.setText(torder.getPeople());
        return view;
    }
}
