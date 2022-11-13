package com.example.myapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ask_tutor extends AppCompatActivity {
    private Button edit_subject;
    private Button apply_now;
    private Button back_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_tutor);
        edit_subject = findViewById(R.id.edit_subject);
        apply_now = findViewById(R.id.apply_now);
        back_button =findViewById(R.id.tutor_back);
        //设置多选
        edit_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ask_tutor.this);
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
                                Toast.makeText(ask_tutor.this,text, Toast.LENGTH_LONG).show();
                                dialogInterface.dismiss();
                            }
                        });
                        break;
                }
                AlertDialog ad = builder.create();
                ad.show();
            }
        });

        //提交申请，这里设置的回到主页面，等待修改
        apply_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"提交申请成功，请等待教师响应",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ask_tutor.this,subject_choose.class);
                startActivity(intent);
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ask_tutor.this.finish();
            }
        });


    }


}