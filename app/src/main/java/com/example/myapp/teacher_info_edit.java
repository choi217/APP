package com.example.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;


public class teacher_info_edit extends AppCompatActivity {
    private Button m_btn_submit;
    private Button edit_subject;
    private Button m_btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_info_edit);
        m_btn_submit = findViewById(R.id.btn_submit);

        m_btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"编辑成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(teacher_info_edit.this,teacher_info_show.class);
                startActivity(intent);
            }
        });
        edit_subject = findViewById(R.id.edit_subject);
        edit_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(teacher_info_edit.this);
                switch (view.getId()){
                    case R.id.edit_subject:
                        builder.setTitle("请选择科目");
                        builder.setIcon(R.mipmap.ic_launcher);
                        final String[] items = new String[]{"语文", "数学", "英语", "物理" , "化学" , "生物" , "历史" , "地理" , "政治" , "体育" , "计算机"};
                        final boolean[] checkedItem = new boolean[]{false,false,false,false,false,false,false,false,false,false,false};
                        builder.setMultiChoiceItems(items, checkedItem, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                                checkedItem[which] = isChecked;
                            }
                        });
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public  void onClick(DialogInterface dialogInterface, int which) {
                                String text = "";
                                for (int i =0;i<items.length;i++){
                                    if (checkedItem[i]){
                                        text+=" [";
                                        text += items[i];
                                        text+="] ";
                                    }
                                }
                                TextView subject_show = findViewById(R.id.subject_show);
                                subject_show.setText(text);
                                Toast.makeText(teacher_info_edit.this,text, Toast.LENGTH_LONG).show();
                                dialogInterface.dismiss();
                            }
                        });
                        break;
                }
                AlertDialog ad = builder.create();
                ad.show();

            }
        });
        m_btn_back = findViewById(R.id.edit_back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacher_info_edit.this.finish();
            }
        });

    }


}