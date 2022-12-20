package com.example.myapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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
        Button m_btn_logout;
        m_btn_logout = getActivity().findViewById(R.id.logout);
        m_btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        Button m_btn_show;
        m_btn_show = getActivity().findViewById(R.id.info_show);
        m_btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), teacher_info_show.class);
                startActivity(intent);
            }
        });
        Button m_btn_edit;
        m_btn_edit = getActivity().findViewById(R.id.info_edit);
        m_btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), teacher_info_edit.class);
                startActivity(intent);
            }
        });
        Button m_btn_kf;
        m_btn_kf = getActivity().findViewById(R.id.kf);
        m_btn_kf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setIcon(R.drawable.ic_baseline_person_24)
                        .setTitle("联系客服")
                        .setMessage("客服电话：18806481743、15573197727、12345678。" +
                                "家教工作时间：9：00-20：00 节假日有人值班！")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .create()
                        .show();
            }
        });
        Button m_btn_pw_edit;
        m_btn_pw_edit = getActivity().findViewById(R.id.pw_edit);
        m_btn_pw_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), password_edit.class);
                startActivity(intent);
            }
        });
    }
}
