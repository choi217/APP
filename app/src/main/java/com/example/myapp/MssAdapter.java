package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MssAdapter extends ArrayAdapter<Messager> {
    private int resourceId;
    public MssAdapter(Context context, int textViewResourceId, List<Messager> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Messager messager = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }
        else{
            view = convertView;
        }
        TextView apCourse =  (TextView) view.findViewById(R.id.ap_course);
        apCourse.setText(messager.getOps());
        TextView apState =  (TextView) view.findViewById(R.id.ap_state);
        apState.setText(messager.getOname());
        return view;
    }
}
