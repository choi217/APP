package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class student_space extends Fragment {
    public String studentid;
    private SQLiteDatabase sqldb;

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
                intent.putExtra("studentid",studentid);
                startActivity(intent);
            }
        });
        Button m_btn_info_edit;
        m_btn_info_edit = getActivity().findViewById(R.id.info_edit);
        m_btn_info_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), student_info_edit.class);
                intent.putExtra("studentid",studentid);
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
                intent.putExtra("logout","1");
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
        Button m_btn_gzh;
        m_btn_gzh = getActivity().findViewById(R.id.gzh);
        m_btn_gzh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), gzh.class);
                startActivity(intent);
            }
        });
        Button m_btn_myteachers;
        m_btn_myteachers = getActivity().findViewById(R.id.my_teachers);
        m_btn_myteachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), myteacher_list.class);
                startActivity(intent);
            }
        });
        Button m_btn_myclass;
        m_btn_myclass = getActivity().findViewById(R.id.my_class);
        m_btn_myclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), myclass_list.class);
                startActivity(intent);
            }
        });
        Button m_btn_myappointment;
        m_btn_myappointment = getActivity().findViewById(R.id.my_appointment);
        m_btn_myappointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), myappointment_list.class);
                startActivity(intent);
            }
        });
        Button m_btn_myvideo;
        m_btn_myvideo = getActivity().findViewById(R.id.my_video);
        m_btn_myvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), myvideo_list.class);
                startActivity(intent);
            }
        });
        Button m_btn_mycollect;
        m_btn_mycollect = getActivity().findViewById(R.id.my_collect);
        m_btn_mycollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), mycollect_list.class);
                startActivity(intent);
            }
        });
        Button m_btn_myorder;
        m_btn_myorder = getActivity().findViewById(R.id.my_order);
        m_btn_myorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), myorder_list.class);
                startActivity(intent);
            }
        });
        Button m_btn_zhuxiao;
        m_btn_zhuxiao = getActivity().findViewById(R.id.zhuxiao);
        m_btn_zhuxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setIcon(R.drawable.ic_baseline_person_24)
                        .setTitle("注销账号")
                        .setMessage("注销后，信息将被删除，该手机号将会被屏蔽，不能再做学员，是否确定注销？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setNegativeButton("取消",new DialogInterface.OnClickListener(){
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