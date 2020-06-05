package com.blibli.myapplication.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
        mRvmain.setAdapter(new LinearAdapter(LinearRecyclerViewActivity.this,list));

        //***********************************************
        // 添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this,R.drawable.recyclerview_line));
        mRvmain.addItemDecoration(divider);
    }
}
