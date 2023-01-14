package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EvaluateAdapter extends ArrayAdapter<Evaluate> {
    private int resourceId;

    public EvaluateAdapter(Context context, int textViewResourceId, List<Evaluate> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Evaluate evaluate = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }
        else{
            view = convertView;
        }
        TextView eval =  (TextView) view.findViewById(R.id.evaluate);
        eval.setText(evaluate.getEvaluate());
        TextView id =  (TextView) view.findViewById(R.id.eval_id);
        id.setText(evaluate.getId());
        TextView content = (TextView) view.findViewById(R.id.eval_content);
        content.setText(evaluate.getContent());
        return view;
    }
}
