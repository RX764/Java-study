package com.blibli.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

public class progressActivity extends AppCompatActivity {
    private ProgressBar mpb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mpb3 = findViewById(R.id.pb3);
        Thread thread = new Thread(new mythread());
        thread.start();
        Log.e("TAG", "onCreate: 主线程结束了");
    }



    class mythread implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i <= mpb3.getMax(); i++){
                try {
                    mpb3.setProgress(i);
                    mpb3.setSecondaryProgress(i + 30);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Log.e("TAG", "onCreate: 新建线程结束了");
        }
    }
}
