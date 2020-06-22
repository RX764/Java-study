package com.blibli.myapplication.handle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blibli.myapplication.MainActivity;
import com.blibli.myapplication.R;
import com.blibli.myapplication.util.ToastUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HandlerActivity extends AppCompatActivity {
    static boolean flag =false;
    static int iflag=0;
    private Button button,button2;
    private TextView textView;
    Handler handler2;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        /*
        //创建handler
        Handler handler = new Handler();
        //第一个函数使用示例
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);
                ToastUtil.showMsg(getApplicationContext(),"handlerruannable");
            }
        },3000);
       */

//
//        //第二个函数
//        final Handler handler = new Handler(){
//            @Override
//            //处理消息
//            public void handleMessage(@NonNull Message msg) {
//                super.handleMessage(msg);
//                switch (msg.what){
//                    case 1:
//                        ToastUtil.showMsg(getApplicationContext(),"This is: "+msg.what);
//                        break;
//                }
//            }
//        };
//        //创建多线程发送消息
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Message message = new Message();
//                message.what = 1;
//                handler.sendMessage(message);
//            }
//        }).start();
//
//
        //第三个  改变文本值示例
        //UI线程 主线程
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                flag = !flag;
                if (msg.what == 1001 && flag){
                    textView.setText("arg1:"+msg.arg1+"，arg2："+msg.arg2+"，对象："+msg.obj);
                }
                else {
                    textView.setText("默认输入");
                }
//                ToastUtil.showMsg(HandlerActivity.this,"点击按钮，子线程发送的消息："+msg);
            }
        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                此处可以进行大量耗时操作
//                子线程
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //通知更新
                        //方式1
//                        handler.sendEmptyMessage(1001);
                        //方式2
                        Message message = Message.obtain();
                        message.what = 1001;
                        message.arg1 =  001;
                        message.arg2 = 002;
                        message.obj = HandlerActivity.this;
                        handler.sendMessage(message);
                        //设置定时
//                        handler.sendMessageAtTime(message, SystemClock.uptimeMillis()+5000);
//                        handler.sendMessageDelayed(message,5000);//相对时间

//                        post里面运行的是一个可执行对象
//                        原理是一个没有延迟的消息，会在当前立即发送
//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                int a=1+2+3;
//                            }
//                        });
                    }
                }).start();
            }
        });



        //oncreate函数范围
        //点击下载：主线程--按键--下载--子线程下载--通知主线程完成下载--主线程更新进度条
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(HandlerActivity.this,"开始下载");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("TAG", "run: 开始下载" );
                        download("https://down.qq.com/qqweb/QQ_1/android_apk/Android_8.3.9.4635_537064751.apk");
                    }
                }).start();

            }
        });
        handler2 = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 10004:
                        Log.e("TAG", "handleMessage: 正在下载:"+msg.what );
                        progressBar.setProgress((Integer) msg.obj);
                        break;
                    case 10005:
                        Log.e("TAG", "handleMessage: 下载失败");
                        ToastUtil.showMsg(HandlerActivity.this,"下载失败");
                }
            }
        };


    }


    private void download(String durl){
        try {
            URL url =new URL(durl);
            Log.e("TAG", "download: 开始");
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            //获取文件总长度
            int contentlength =  urlConnection.getContentLength();
            Log.e("TAG", "download: 总长度："+contentlength);
            //File.separator其实就是路径的斜线。
            //getExternalStorageDirectory()获取存储设备的地址
            String downloadFileName = Environment.getExternalStorageDirectory()
                    + File.separator+"Imooc"+File.separator;
            Log.e("TAG", "download: 创建本地目录");
            File file = new File("downloadFileName");
            if (!file.exists())
                file.mkdir();
            //上面两步，将文件下载到imooc文件夹，创建文件
            String filename = downloadFileName + "imooc.apk";
            File fileAPK = new File(filename);
            if (fileAPK.exists()){
                fileAPK.delete();
            }
            Log.e("TAG", "download: 创建。apk文件" );
            int downloadsize = 0;
            byte[] bytes = new byte[1024];
            int length = 0;
            Log.e("TAG", "download: 开始打开文件流成功" );

            OutputStream outputStream = new FileOutputStream(filename);

//            if (outputStream ==null)
//                Log.e("TAG", "download: 打开文件流失败" );
//            else
                Log.e("TAG", "download: 打开文件流成功:"+outputStream );
            int i=0;
            while ((length = inputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,length);
                downloadsize += length;
                //更新UI
                Message message2 = Message.obtain();
                message2.obj = downloadsize*100/contentlength;
                message2.what = 10004;
                handler2.sendMessage(message2);
                Log.e("TAG", "download: I = "+(i++) );
            }
            inputStream.close();
            outputStream.close();

        }catch (MalformedURLException e){
            Message message2 = Message.obtain();
            message2.what = 10005;
            handler2.sendMessage(message2);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
