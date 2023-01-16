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

public class teacher_mainpage extends Fragment {
    public String teacherid;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_teacher_mainpage, container, false);

    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button m_btn_select;
        m_btn_select = getActivity().findViewById(R.id.select_student);
        m_btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), select_student.class);
                startActivity(intent);
            }
        });
        Button m_btn_ap;
        m_btn_ap = getActivity().findViewById(R.id.student_appointment);
        m_btn_ap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), teacher_appointment.class);
                startActivity(intent);
            }
        });
        Button m_btn_gclass;
        m_btn_gclass = getActivity().findViewById(R.id.btn_giveclass);
        m_btn_gclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),give_class.class);
                startActivity(intent);
            }
        });
        Button m_btn_video;
        m_btn_video = getActivity().findViewById(R.id.my_video);
        m_btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),teacher_video.class);
                startActivity(intent);
            }
        });
    }
}