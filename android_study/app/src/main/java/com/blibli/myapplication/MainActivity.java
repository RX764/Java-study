package com.blibli.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blibli.myapplication.girdview.GirdViewActivity;
import com.blibli.myapplication.listView.ListViewActivity;
import com.blibli.myapplication.recycleview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {
    private Button mBtnGridView;
    private Button mBtnListView;
    private Button mBtnRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnGridView = findViewById(R.id.btn_gridview);
        mBtnListView = findViewById(R.id.btn_listview);
        mBtnRV = findViewById(R.id.btn_recyclerView);
        setListeners();
    }

    private void setListeners(){
        OnClick onclick = new OnClick();
        mBtnGridView.setOnClickListener(onclick);
        mBtnListView.setOnClickListener(onclick);
        mBtnRV.setOnClickListener(onclick);
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_gridview:
                    intent = new Intent(MainActivity.this, GirdViewActivity.class);
                    break;
                case R.id.btn_listview:
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                case  R.id.btn_recyclerView:
                    intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
            }
            startActivity(intent);
        }
    }
}
