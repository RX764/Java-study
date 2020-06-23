package com.blibli.myapplication.AsyncTask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.blibli.myapplication.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AsyncTaskActivity extends AppCompatActivity {
    private AlertDialog dialog;

    private Button mbtntask;
    private TextView mtvtask;
    private ProgressBar mpgtask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        //使用方法1：可以直接使用或者创建一个类,本处的DownLoadTask类
//            new DownLoadTask().execute("a","b","c");

        mbtntask = findViewById(R.id.btn_task);
        mtvtask = findViewById(R.id.tv_task);
        mpgtask = findViewById(R.id.progress_task);
        setListeners();
    }

    private void setListeners() {
        MyonClick myonClick = new MyonClick();
        mbtntask.setOnClickListener(myonClick);
        mtvtask.setOnClickListener(myonClick);
        mpgtask.setOnClickListener(myonClick);
    }

    public class  MyonClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_task:
                    DownLoadTask downLoadTask = new DownLoadTask();
                    final String s = "https://down.qq.com/qqweb/QQ_1/android_apk/Android_8.3.9.4635_537064751.apk";
                    downLoadTask.execute(s);//不定参数
                    break;
                case R.id.progress_task:
                    break;
                case  R.id.tv_task:
                    break;
            }



        }
    }


    public class DownLoadTask extends AsyncTask<String,Integer,Boolean>{
        /*
        @string 入参
        @interger 进度
        booolean：结果
         */
        //在另外一个线程中处理事件。
        @Override
        protected Boolean doInBackground(String... strings) {
            if (strings != null &&strings.length>0){
                String apkurl = strings[0];
                try {

                    URL url = new URL(apkurl);
                    URLConnection urlConnection = url.openConnection();//相当于打开链接


                    InputStream inputStream = urlConnection.getInputStream();
                    int contentlength = urlConnection.getContentLength();
                    //下载地址准备
//                    String mFilePath = Environment.getExternalStorageState()+
//                            File.separator + "Imooc.apk";
                    String mFilePath = getFilesDir()+File.separator+"imooc.apk";
                    //对下载地址进行处理
                    File apkFile = new File(mFilePath);
                    if (apkFile.exists()){
                        Boolean result = apkFile.delete();
                        if (!result)
                            return false;
                    }
                    //已经下载的大小
                    float downloadsize = 0;
                    byte bytes[] = new byte[2048];
                    int length;
                    //开始拿数据
                    //创建一个输出管道
                    OutputStream outputStream = new FileOutputStream(mFilePath);

                    //不断地读取文件，写到文件
                    while ((length=inputStream.read(bytes))!=-1){
                        outputStream.write(bytes,0,length);
                        downloadsize += length;
                        //发送进度        抛出进度给onProgressUpdate。
//                        publishProgress(downloadsize*100/contentlength);
                        int complete = (int)(100*(downloadsize/contentlength));
                        publishProgress(complete);
//                        Log.e("TAG", "downloadsize: "+downloadsize +"\t"+complete+"%\t");
//                        mbtntask.setText("下载中");
//                        mtvtask.setText("当前进度："+a+"%");
                }
                    inputStream.close();
                    outputStream.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            else
                return  false;
            return true;
        }

        /**
         * 在异步任务之前，主线程中
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //可操作UI
            mbtntask.setText("下载中");
            mtvtask.setText("下载中");
            mpgtask.setProgress(0);
        }

        /**
         * 也是在主线程中，可以进行结果处理。doInBackground的返回结果
         * @param aBoolean
         */
        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (aBoolean)
                mbtntask.setText("下载成功");
            else
                mbtntask.setText("下载失败");
            mtvtask.setText(aBoolean? "处理完成的下载完成":"处理完成的下载失败");

        }


        /*
         *
         * @param values
         * @Integer就是doInBackground中的intger,进度条
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //收到的进度，然后处理，也是在UI线程
            if (values!=null && values.length >0)
             mpgtask.setProgress(values[0]);
        }
    }
}
