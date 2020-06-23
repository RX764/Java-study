package com.blibli.myapplication.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.blibli.myapplication.R;

import java.util.ArrayList;
import java.util.List;

//列表视图实现页面
public class LinearRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvmain;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);
        list = new ArrayList<>();
        for (int i=0;i<30;i++)
            list.add("这是第"+(i+1)+"个item");
        mRvmain = findViewById(R.id.rv_main);
        mRvmain.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
        mRvmain.setAdapter(new LinearAdapter(LinearRecyclerViewActivity.this, list, new LinearAdapter.MyonClick() {
            @Override
            public void onclick(int pos) {
                Toast.makeText(LinearRecyclerViewActivity.this,"点击了第"+(pos+1)+"个item",Toast.LENGTH_SHORT).show();
            }
        }));
        //***********************************************
        // 添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this,R.drawable.recyclerview_line));
        mRvmain.addItemDecoration(divider);
    }
}
