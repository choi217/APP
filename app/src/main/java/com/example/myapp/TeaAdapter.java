package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TeaAdapter extends ArrayAdapter<Teacher> {
    private int resourceId;

    public TeaAdapter(Context context, int textViewResourceId, List<Teacher> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Teacher tea = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }
        else{
            view = convertView;
        }
        ImageView teacherImage = (ImageView) view.findViewById(R.id.teacher_image);
        TextView teacherName =  (TextView) view.findViewById(R.id.teacher_name);
        teacherImage.setImageResource(tea.getImageId());
        teacherName.setText(tea.getName());
        return view;
    }

}
