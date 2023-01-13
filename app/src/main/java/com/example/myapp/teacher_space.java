package com.example.myapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;

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
        Button m_btn_gzh;
        m_btn_gzh = getActivity().findViewById(R.id.gzh);
        m_btn_gzh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), gzh.class);
                startActivity(intent);
            }
        });
        Button m_btn_order;
        m_btn_order = getActivity().findViewById(R.id.my_order);
        m_btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), teacher_order.class);
                startActivity(intent);
            }
        });
        Button m_btn_select;
        m_btn_select = getActivity().findViewById(R.id.select);
        m_btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), select_student.class);
                startActivity(intent);
            }
        });
        Button m_btn_card;
        m_btn_card = getActivity().findViewById(R.id.my_card);
        m_btn_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), id_card.class);
                startActivity(intent);
            }
        });
        Button m_btn_class;
        m_btn_class = getActivity().findViewById(R.id.my_class);
        m_btn_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), teacher_class.class);
                startActivity(intent);
            }
        });
        Button m_btn_appoint;
        m_btn_appoint = getActivity().findViewById(R.id.appointment);
        m_btn_appoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), teacher_appointment.class);
                startActivity(intent);
            }
        });
        Button m_btn_gclass;
        m_btn_gclass = getActivity().findViewById(R.id.give_classes);
        m_btn_gclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), give_class.class);
                startActivity(intent);
            }
        });
        Button m_btn_eval;
        m_btn_eval = getActivity().findViewById(R.id.my_eval);
        m_btn_eval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), eval_list.class);
                startActivity(intent);
            }
        });
        Button m_btn_video;
        m_btn_video = getActivity().findViewById(R.id.teacher_video);
        m_btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), teacher_video.class);
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
                        .setMessage("注销后，简历将被删除，该手机号将会被屏蔽，不能再做家教，是否确定注销？")
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
