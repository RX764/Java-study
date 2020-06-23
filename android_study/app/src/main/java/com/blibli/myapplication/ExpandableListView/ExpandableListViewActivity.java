package com.blibli.myapplication.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;
import com.blibli.myapplication.R;
import android.os.Bundle;
import android.widget.ExpandableListView;

public class ExpandableListViewActivity extends AppCompatActivity {
    private ExpandableListView mExpandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);
        initViews();
    }

    private void initViews() {
        mExpandableListView = findViewById(R.id.Expandable);
    }
}
