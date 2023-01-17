package com.example.myapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class VideoclassAdapter extends ArrayAdapter<Videoclass> {
    private int resourceId;

    public VideoclassAdapter(Context context, int textViewResourceId, List<Videoclass> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Videoclass vc = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }
        else{
            view = convertView;
        }
        ImageView image = (ImageView) view.findViewById(R.id.pic);
        TextView name =  (TextView) view.findViewById(R.id.video_name);
        TextView info = (TextView) view.findViewById(R.id.video_info);
        TextView state = (TextView) view.findViewById(R.id.video_state);
        image.setImageResource(R.drawable.c);
        name.setText(vc.getName());
        info.setText("￥"+vc.getPrice()+"|" + vc.getGrade() + vc.getSubject()+"|1节课" );
        state.setText(vc.getDescribe());
        return view;
    }
}
