package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        Button m_btn_choose_tutor;
        m_btn_choose_tutor = getActivity().findViewById(R.id.choose_tutor);
        m_btn_choose_tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), teacher_list.class);
                startActivity(intent);
            }
        });
        Button m_btn_ask_tutor;
        m_btn_ask_tutor = getActivity().findViewById(R.id.ask_tutor);
        m_btn_ask_tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ask_tutor.class);
                startActivity(intent);
            }
        });
        Button m_btn_info_show;
        m_btn_info_show = getActivity().findViewById(R.id.info_show);
        m_btn_info_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), student_info_show.class);
                startActivity(intent);
            }
        });
        Button m_btn_info_edit;
        m_btn_info_edit = getActivity().findViewById(R.id.info_edit);
        m_btn_info_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), student_info_edit.class);
                startActivity(intent);
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
        Button m_btn_logout;
        m_btn_logout = getActivity().findViewById(R.id.logout);
        m_btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
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
    }

}