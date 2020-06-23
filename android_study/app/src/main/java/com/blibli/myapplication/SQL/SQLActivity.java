package com.blibli.myapplication.SQL;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.blibli.myapplication.AsyncTask.AsyncTaskActivity;
import com.blibli.myapplication.R;
import com.blibli.myapplication.util.ToastUtil;

import java.io.File;

public class SQLActivity extends AppCompatActivity {
    private  Button insert,selected,delete,update;
    private EditText name,age,id;
    RadioButton man,woman;
    RadioGroup gender_group;
    String gender = "男";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_q_l);
        insert = findViewById(R.id.insert_btn);
        selected = findViewById(R.id.selected_btn);
        delete= findViewById(R.id.delete_btn);
        update = findViewById(R.id.change_btn);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        man = findViewById(R.id.man);
        woman = findViewById(R.id.woman);
        id= findViewById(R.id.id);
        gender_group =  findViewById(R.id.gender_group);
        gender_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.man){
                    gender = "男";
                }
                if (checkedId ==R.id.woman){
                    gender = "女";
                }
            }
        });
        setclick();
    }
    private  void  setclick(){
        Myclick myclick = new Myclick();
        insert.setOnClickListener(myclick);
        selected.setOnClickListener(myclick);
        delete.setOnClickListener(myclick);
        update.setOnClickListener(myclick);
    }

    public class Myclick implements View.OnClickListener{
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.insert_btn:
                    //4个参数：  环境上下文；数据库名称(如果只有名称，则该数据库位置在私有目录中。如果有路径，那么数据库位置在指定路径下)
                    //
                                    String path = getFilesDir()+ File.separator +"test.db";
//                    String path = Environment.getExternalStorageDirectory()+File.separator+"stu.db";
                    SQLiteOpenHelper helper = new SQLiteOpenHelper(SQLActivity.this,path,null,2) {
                        @Override
                        //这里是回调函数，参数db就是这个：SQLiteDatabase db = helper.getReadableDatabase();
                        public void onCreate(SQLiteDatabase db) {
                            //创建数据库方法
                            //可以吧表的创建放到这个方法里面.前提是数据库不存在，如果数据库存在，是不会调用这个方式的
                            ToastUtil.showMsg(getApplicationContext(),"数据库创建");
                            String sql = "create table info(id INTEGER PRIMARY KEY AUTOINCREMENT,"+ "name varchar(20),"+"age int,"+"gender varchar(20))";
                            db.execSQL(sql);
                        }

                        @Override
                        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                            //升级数据库方法
                            ToastUtil.showMsg(getApplicationContext(),"数据库升级");
                        }
                    };
                    //获取数据库对象 ,判断指定的数据库是否存在。存在就打开，不存在就创建
                    //数据库存在，版本号提高就会调用升级方法
//                    helper.getReadableDatabase();
                    SQLiteDatabase db = helper.getReadableDatabase();
//                    db.rawQuery():查询
//                    db.execSQL();添加 删除  创建表 修改
                    String namestr = name.getText().toString();
                    String ageint = age.getText().toString();
//                    String sql = "DROP TABLE IF EXISTS `info`;"+"create table info(id int primary key autoincrement,"+ "name varchar(20),"+"age int)";
                    String sql =  "insert into info(name,age,gender) values('"+namestr+"',"+ageint+",'"+gender+"')";
                    db.execSQL(sql);
                    break;
                case R.id.selected_btn:
                    break;
                case R.id.delete_btn:
                    break;
                case R.id.change_btn:
                    break;
            }
        }
    }




}



