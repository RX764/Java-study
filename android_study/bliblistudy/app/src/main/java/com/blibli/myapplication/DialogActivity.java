package com.blibli.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blibli.myapplication.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {
    private Button mbtnDialog1,mbtnDialog2,mbtnDialog3,mbtnDialog4,mbtnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mbtnDialog1=findViewById(R.id.btn_dialog1);
        mbtnDialog2=findViewById(R.id.btn_dialog2);
        mbtnDialog3=findViewById(R.id.btn_dialog3);
        mbtnDialog4=findViewById(R.id.btn_dialog4);
        mbtnDialog5=findViewById(R.id.btn_dialog5);
        myOnclick onclick = new myOnclick();
        mbtnDialog1.setOnClickListener(onclick);
        mbtnDialog2.setOnClickListener(onclick);
        mbtnDialog3.setOnClickListener(onclick);
        mbtnDialog4.setOnClickListener(onclick);
        mbtnDialog5.setOnClickListener(onclick);
    }

    class myOnclick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_dialog1:
//                    AlertDialog在app和V7包都有，使用V7的
//                    Builder构造者模式
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("请回答").setMessage("当程序员掉头发吗")
                            .setIcon(R.mipmap.ic_launcher_round)
                            .setPositiveButton("是的", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this,"你很诚实");
                                }
                            })
                            .setNeutralButton("你猜", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"默认了吗");
                        }
                    })
                    .setNegativeButton("假的", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"我信你个鬼哦");
                        }
                    }).show();
//                    builder.setMessage("当程序员掉头发吗？");

                    break;
                case R.id.btn_dialog2:
//                    实现单选功能
                    final String array[] = new String[]{"man","woman"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("选择性别").setItems(array, new DialogInterface.OnClickListener() {
                        @Override
//                        which就是数组的索引
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,array[which]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog3:
//                    单选功能，和上一个类似，只是视觉不一样
                    final String array3[] = new String[]{"男","女"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
//                    checkeditem是指默认的选中哪一个
                    builder3.setTitle("请选择性别").setSingleChoiceItems(array3, 1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,array3[which]);
                            dialog.dismiss();
                        }
//                        setCancelable()设置点击时弹窗不会消失。由于不会消失，所以添加dialog.dismiss();
//                        使其在点击弹窗位置时消失
                    }).setCancelable(false)
                            .show();
                    break;
                case R.id.btn_dialog4:
//                    多选功能
                    final String array4[] = new String[]{"香蕉 ","苹果","西瓜","葡萄"};
                    boolean isselected[] = new boolean[]{false,false,false,true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("选择您所喜欢的").setMultiChoiceItems(array4, isselected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(DialogActivity.this,array4[which]+":"+isChecked);
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).setNeutralButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).show();
                    break;
                case  R.id.btn_dialog5:
                    //自定义弹窗
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                    View view = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog_mydiv,null);
                    final EditText username = view.findViewById(R.id.et_username);
                    final EditText pwd = view.findViewById(R.id.et_pwd);
                    Button btnlogin = view.findViewById(R.id.btn_login);
                    //接下来可以设置一些点击事件。根据需要
                    btnlogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ToastUtil.showMsg(DialogActivity.this,"用户名："+username.getText()+" 密码："+pwd.getText());
                        }
                    });
                    builder5.setTitle("请先登录").setView(view)
                            .show();
                    break;
            }
        }
    }
}
