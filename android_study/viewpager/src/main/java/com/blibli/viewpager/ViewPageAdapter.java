package com.blibli.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ViewPageAdapter extends PagerAdapter {
    private List<View> views= null;

    ViewPageAdapter(List<View> list){
        this.views = list;
    }
    @Override
    public int getCount() {
        return views.size();
    }

    //视图和object  相同就可以复用
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    //两个必须实现的方法，系统不会提醒
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View child = views.get(position);
        container.addView(child);
        return child;
//        return super.instantiateItem(container, position);
    }

    //释放
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(views.get(position));
//        super.destroyItem(container, position, object);
    }
}
