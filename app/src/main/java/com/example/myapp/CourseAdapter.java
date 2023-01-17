package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CourseAdapter extends ArrayAdapter<Course> {
    private int resourceId;

    public CourseAdapter(Context context, int textViewResourceId, List<Course> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Course course = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }
        else{
            view = convertView;
        }
        TextView className =  (TextView) view.findViewById(R.id.class_name);
        className.setText(course.getName());
        TextView classState =  (TextView) view.findViewById(R.id.class_state);
        String text = course.getDate();
        if(course.getDate().length()==0) text = course.getOlddate();
        classState.setText(course.getTeachername()+"|"+text);
        return view;
    }
}
