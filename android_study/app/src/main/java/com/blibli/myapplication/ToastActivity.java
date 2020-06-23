package com.blibli.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blibli.myapplication.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {
    static int i=0;
    private Button mBtnToast1,mBtnToast2,mBtnToast3,mBtnToast4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        mBtnToast1 = findViewById(R.id.btn_toast_1);
        mBtnToast2 = findViewById(R.id.btn_toast_2);
        mBtnToast3 = findViewById(R.id.btn_toast_3);
        mBtnToast4 = findViewById(R.id.btn_toast_4);
        Onclick onclick = new Onclick();
        mBtnToast1.setOnClickListener(onclick);
        mBtnToast2.setOnClickListener(onclick);
        mBtnToast3.setOnClickListener(onclick);
        mBtnToast4.setOnClickListener(onclick);
    }
    class Onclick implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.btn_toast_1:
                    //默认的Toast点击事件
                    Toast.makeText(ToastActivity.this,"默认而过",Toast.LENGTH_SHORT).show();
                   break;
                case R.id.btn_toast_2:
                    //改变显示位置的Toast
                    //第一个参数ToastActivity.this和getApplicationContext()都可以
                    Toast toastcenter = Toast.makeText(getApplicationContext(),"居中显示",Toast.LENGTH_SHORT);
                    toastcenter.setGravity(Gravity.CENTER,0,0);
//                    toastcenter.setText("hhhhhhhhhhhhhhhh");
                    toastcenter.show();
                    break;
                case R.id.btn_toast_3:
                    Toast toastcustom = new Toast(getApplicationContext());
                    LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
                    View view=inflater.inflate(R.layout.layout_toast,null);
                    ImageView imageView  = view.findViewById(R.id.iv_toast);
                    TextView textView = view.findViewById(R.id.tv_toast);
                    imageView.setImageResource(R.mipmap.ic_launcher);
                    textView.setText("这是默认的图标");
                    toastcustom.setGravity(Gravity.CENTER,0,0);
                    toastcustom.setView(view);
                    toastcustom.show();
//                    toastcustom.cancel(); 取消掉当前toast
//                    toastcustom.cancel();
                    break;
                case  R.id.btn_toast_4:
//                    解决连续按多下，toast一直显示的问题
                    i++;
                    ToastUtil.showMsg(getApplicationContext(),"点击次数："+i);
                    break;
            }
        }
    }
}
