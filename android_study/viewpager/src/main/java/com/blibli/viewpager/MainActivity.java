package com.blibli.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  ViewPager viewPager;
    private int id[] = new int[100];
    private List<View> views = new ArrayList<>();

    private ViewGroup dotgroup;
    private List<ImageView> dot = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        dotgroup = findViewById(R.id.dot);
        for (int i = 0; i < id.length; i++) {
//            getLayoutInflater()获取并解析视图
//            views.add(getLayoutInflater().inflate(id[i],null));
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.mipmap.ic_launcher);
//           Glide.with(this).load("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3028442949,152520427&fm=26&gp=0.jpg").into(imageView);
            views.add(imageView);
            ImageView dots = new ImageView(this);
            dots.setImageResource(R.mipmap.ic_launcher);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(80,80);
            layoutParams.leftMargin = 20;
            layoutParams.rightMargin=20;
            dots.setLayoutParams(layoutParams);
            dots.setEnabled(false);//设置点击事件不可用
            dotgroup.addView(dots);
            dot.add(dots);
        }
        viewPager.setAdapter(new ViewPageAdapter(views));
        viewPager.setOffscreenPageLimit(5);//保留几张不被销毁
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                for (int i = 0; i < dot.size() ; i++) {
                    dot.get(i).setImageResource(position == i ? R.mipmap.list_pwd:R.mipmap.ic_launcher);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
