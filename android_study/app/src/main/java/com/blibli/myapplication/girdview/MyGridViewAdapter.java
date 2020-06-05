package com.blibli.myapplication.girdview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blibli.myapplication.MainActivity;
import com.blibli.myapplication.R;
import com.bumptech.glide.Glide;

public class MyGridViewAdapter extends BaseAdapter {
    private  Context mcontext;
    private LayoutInflater mlayoutInflater;
    public MyGridViewAdapter(Context context){
        this.mcontext = context;  //将环境传进来
        mlayoutInflater = LayoutInflater.from(context); //获取布局填充器
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView textView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        随着滑动，屏幕中消失的一行被回收到了缓存, 将其（convertVeiw）取出，
//        在其视图中，更改控件信息（把将要显示的那一行的控件信息填进去），
//        形成了新的即将在ListView中出现的item视图。
//        如果缓存中没有，要新建视图 convertView = myInflater.inflate(R.layout.item, null);//布局实例化

        ViewHolder holder = null;
        if (convertView == null){
            convertView = mlayoutInflater.inflate(R.layout.layout_grid_item,null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.iv_grid);
            holder.textView  = convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText("dream it possible");
        Glide.with(mcontext).load("http://img5.imgtn.bdimg.com/it/u=2946886927,1730899898&fm=26&gp=0.jpg").into(holder.imageView);
        return convertView;
    }
}
