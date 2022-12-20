package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class student_space extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_student_space,container,false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button m_btn_procedure;
        m_btn_procedure = getActivity().findViewById(R.id.btn_procedure);
        m_btn_procedure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), asktutor_procedure.class);
                startActivity(intent);
            }
        });
        Button m_btn_standard;
        m_btn_standard = getActivity().findViewById(R.id.standard);
        m_btn_standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), charge_standard.class);
                startActivity(intent);
            }
        });
        Button m_btn_benefit;
        m_btn_benefit = getActivity().findViewById(R.id.benefit);
        m_btn_benefit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), member_benefit.class);
                startActivity(intent);
            }
        });
    }

}