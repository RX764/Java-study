package com.blibli.myapplication.listView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blibli.myapplication.R;
import com.bumptech.glide.Glide;

import java.util.zip.Inflater;

public class MyListViewAdapter extends BaseAdapter {
    private Context mcontext;
    private LayoutInflater mlayoutInflater;

    public MyListViewAdapter(Context context) {
        this.mcontext = context;
        mlayoutInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class ViewHolder {
        public ImageView imageView;
        public TextView tvtitle, tvtime, tvcontent;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mlayoutInflater.inflate(R.layout.layout_list_item,null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.iv);
            holder.tvtitle = convertView.findViewById(R.id.tv_title);
            holder.tvtime = convertView.findViewById(R.id.tv_time);
            holder.tvcontent = convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvtitle.setText("秦时明月");
        holder.tvtime.setText("2020 - 6 - 3");
        holder.tvcontent.setText("少司命图片");
        Glide.with(mcontext).load("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3028442949,152520427&fm=26&gp=0.jpg").into(holder.imageView);

        return convertView;
    }
}
