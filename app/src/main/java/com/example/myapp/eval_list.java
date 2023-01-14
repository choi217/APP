package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class eval_list extends AppCompatActivity {
    private List<Evaluate> evalList = new ArrayList<>();
    private Button m_btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eval_list);

        init();
        EvaluateAdapter adapter = new EvaluateAdapter(eval_list.this,R.layout.eval_list_item,evalList);
        ListView listView = (ListView) findViewById(R.id.eval_list);
        listView.setAdapter(adapter);
        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Evaluate eval = evalList.get(position);
                Toast.makeText(eval_list.this,eval.getEvaluate(),Toast.LENGTH_SHORT).show();
            }
        });
        m_btn_back = findViewById(R.id.btn_back);
        m_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eval_list.this.finish();
            }
        });
    }
    private void init(){
        Evaluate a = new Evaluate("好评","学员：张三","教的很好");
        evalList.add(a);
        Evaluate b = new Evaluate("中评", "学员：李四","教的一般");
        evalList.add(b);
    }
}
