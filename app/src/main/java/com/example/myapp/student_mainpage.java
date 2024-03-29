package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;

public class student_mainpage extends Fragment {
    public String studentid;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_student_mainpage,container,false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("mainpage"+studentid);
        Button m_btn_student;
        Button m_btn_teacher_list;
        Button m_btn_video_list;
        m_btn_student = getActivity().findViewById(R.id.btn_student);
        m_btn_teacher_list = getActivity().findViewById(R.id.btn_teacher_list);
        m_btn_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ask_tutor.class);
                intent.putExtra("userid",studentid);
                startActivity(intent);
            }
        });
        m_btn_video_list = getActivity().findViewById(R.id.btn_video);
        m_btn_video_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), video_list.class);
                intent.putExtra("userid",studentid);
                startActivity(intent);
            }
        });

        m_btn_teacher_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), teacher_list.class);
                intent.putExtra("userid",studentid);
                startActivity(intent);
            }
        });
    }



}