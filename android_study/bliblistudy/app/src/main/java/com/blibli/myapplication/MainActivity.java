package com.blibli.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ViewUtils;

import android.app.Dialog;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.blibli.myapplication.AsyncTask.AsyncTaskActivity;
import com.blibli.myapplication.ExpandableListView.ExpandableListViewActivity;
import com.blibli.myapplication.SQL.SQLActivity;
import com.blibli.myapplication.WebView.WebViewActivity;
import com.blibli.myapplication.girdview.GirdViewActivity;
import com.blibli.myapplication.handle.HandlerActivity;
import com.blibli.myapplication.listView.ListViewActivity;
import com.blibli.myapplication.recycleview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {
        private Button mBtnGridView;
        private Button mBtnListView;
        private Button mBtnRV;
        private Button mBtnwebview;
        private Button mBtnToast;
        private Button mBtnDialog;
        private Button mBtnProgress;
        private Button mBtnHandle;
        private Button mBtnasyncTask;
        private  Button mBtnSQL;
        private Button mbtnExpandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnGridView = findViewById(R.id.btn_gridview);
        mBtnListView = findViewById(R.id.btn_listview);
        mBtnRV = findViewById(R.id.btn_recyclerView);
        mBtnwebview = findViewById(R.id.btn_webView);
        mBtnToast = findViewById(R.id.btn_toast);
        mBtnDialog = findViewById(R.id.btn_dialog);
        mBtnProgress = findViewById(R.id.btn_progress);
        mBtnHandle = findViewById(R.id.btn_handle);
        mBtnasyncTask = findViewById(R.id.btn_async);
        mBtnSQL = findViewById(R.id.btn_mysql);
        mbtnExpandableListView = findViewById(R.id.btn_ExpandableListView);
        setListeners();
    }

    private void setListeners(){
        OnClick onclick = new OnClick();
        mBtnGridView.setOnClickListener(onclick);
        mBtnListView.setOnClickListener(onclick);
        mBtnRV.setOnClickListener(onclick);
        mBtnwebview.setOnClickListener(onclick);
        mBtnToast.setOnClickListener(onclick);
        mBtnDialog.setOnClickListener(onclick);
        mBtnProgress.setOnClickListener(onclick);
        mBtnHandle.setOnClickListener(onclick);
        mBtnasyncTask.setOnClickListener(onclick);
        mBtnSQL.setOnClickListener(onclick);
        mbtnExpandableListView.setOnClickListener(onclick);
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
                    break;
                case  R.id.btn_recyclerView:
                    intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.btn_webView:
                    intent = new Intent(MainActivity.this, WebViewActivity.class);
                    break;
                case  R.id.btn_toast:
                    intent = new Intent(MainActivity.this,ToastActivity.class);
                    break;
                case  R.id.btn_dialog:
                    intent = new Intent(getApplicationContext(), DialogActivity.class);
                    break;
                case  R.id.btn_progress:
                    intent = new Intent(MainActivity.this,progressActivity.class);
                    break;
                case R.id.btn_handle:
                    intent = new Intent(getApplicationContext(), HandlerActivity.class);
                    break;
                case R.id.btn_async:
                    intent = new Intent(MainActivity.this, AsyncTaskActivity.class);
                    break;
                case R.id.btn_mysql:
                    intent = new Intent(MainActivity.this, SQLActivity.class);
                    break;
                case R.id.btn_ExpandableListView:
                    intent = new Intent(MainActivity.this, ExpandableListViewActivity.class);
                    break;
            }
//            getApplicationContext() 返回应用的上下文，生命周期是整个应用，应用摧毁它才摧毁
//            Activity.this的context 返回当前activity的上下文，属于activity ，activity 摧毁他就摧毁
            startActivity(intent);
        }
    }
}
