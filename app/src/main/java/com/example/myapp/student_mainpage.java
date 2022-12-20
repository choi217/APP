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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_student_mainpage,container,false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button m_btn_student;
        Button m_btn_teacher_list;
        m_btn_student = getActivity().findViewById(R.id.btn_student);
        m_btn_teacher_list = getActivity().findViewById(R.id.btn_teacher_list);
        //请家教按键：跳转到申请家教的表单页面，填写表单，提交申请
        m_btn_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ask_tutor.class);
                startActivity(intent);
            }
        });

        m_btn_teacher_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), teacher_list.class);
                startActivity(intent);
            }
        });
    }



}