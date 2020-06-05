package com.blibli.myapplication.girdview;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blibli.myapplication.R;

public class GirdViewActivity extends AppCompatActivity {
    private GridView mGv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girdview);
        mGv = findViewById(R.id.gv);
        mGv.setAdapter(new MyGridViewAdapter(GirdViewActivity.this));
    }
}
