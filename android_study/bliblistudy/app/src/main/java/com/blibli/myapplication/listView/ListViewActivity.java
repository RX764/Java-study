package com.blibli.myapplication.listView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.blibli.myapplication.R;

public class ListViewActivity extends AppCompatActivity {
    private ListView mlv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        mlv1 = findViewById(R.id.lv_1);
        mlv1.setAdapter(new MyListViewAdapter(ListViewActivity.this));
    }

}
