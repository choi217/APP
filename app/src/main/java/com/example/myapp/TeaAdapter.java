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
        TextView teacherDegree=(TextView) view.findViewById(R.id.teacher_degree);
        TextView teacherId=(TextView) view.findViewById(R.id.teacher_id);
        TextView teacherMajor=(TextView) view.findViewById(R.id.teacher_major);
        TextView teacherMoneyrequest=(TextView) view.findViewById(R.id.teacher_moneyrequest);
        TextView teacherOtherinfo=(TextView) view.findViewById(R.id.teacher_otherinfo);
        TextView teacherProvince=(TextView) view.findViewById(R.id.teacher_province);
        TextView teacherTeachmethod=(TextView) view.findViewById(R.id.teacher_teachmethod);
        TextView teacherSchool=(TextView) view.findViewById(R.id.teacher_school);
        TextView teacherScore=(TextView) view.findViewById(R.id.teacher_school);
        TextView teacherSubject=(TextView) view.findViewById(R.id.teacher_subject);
        teacherImage.setImageResource(tea.getImageId());
        teacherName.setText(tea.getName());
        teacherDegree.setText(tea.getDegree());
        teacherId.setText(tea.getId());
        teacherMajor.setText(tea.getMajor());
        teacherMoneyrequest.setText(tea.getMoneyrequest());
        teacherOtherinfo.setText(tea.getOtherinfo());
        teacherProvince.setText(tea.getProvince());
        teacherTeachmethod.setText(tea.getTeachmethod());
        teacherSchool.setText(tea.getSchool());
        teacherScore.setText(Float.toString(tea.getScore()));
        teacherSubject.setText(tea.getSubject());
        return view;
    }

}
