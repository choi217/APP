package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class teacher_space extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_teacher_space,container,false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button m_btn_points;
        m_btn_points = getActivity().findViewById(R.id.points_state);
        m_btn_points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), points_state.class);
                startActivity(intent);
            }
        });
        Button m_btn_charge;
        m_btn_charge = getActivity().findViewById(R.id.charge_standard);
        m_btn_charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), charge_standard.class);
                startActivity(intent);
            }
        });
        Button m_btn_help;
        m_btn_help = getActivity().findViewById(R.id.tutor_help);
        m_btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), tutor_help.class);
                startActivity(intent);
            }
        });
    }
}
