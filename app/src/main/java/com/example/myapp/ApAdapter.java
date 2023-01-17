package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ApAdapter extends ArrayAdapter<Appointment> {
    private int resourceId;

    public ApAdapter(Context context, int textViewResourceId, List<Appointment> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Appointment appointment = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }
        else{
            view = convertView;
        }
        TextView apCourse =  (TextView) view.findViewById(R.id.ap_course);
        apCourse.setText(appointment.getCoursename());
        TextView apState =  (TextView) view.findViewById(R.id.ap_state);
        apState.setText(appointment.getTeachername()+"|"+appointment.getDate());
        return view;
    }
}
