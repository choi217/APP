package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class VideoAdapter extends ArrayAdapter<Video> {
    private int resourceId;

    public VideoAdapter(Context context, int textViewResourceId, List<Video> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Video video = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }
        else{
            view = convertView;
        }
        TextView name =  (TextView) view.findViewById(R.id.video_name);
        name.setText(video.getName());
        TextView state =  (TextView) view.findViewById(R.id.video_state);
        state.setText(video.getState());
        Button button1 = (Button) view.findViewById(R.id.btn1);
        Button button2 = (Button) view.findViewById(R.id.btn2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        return view;
    }
}
