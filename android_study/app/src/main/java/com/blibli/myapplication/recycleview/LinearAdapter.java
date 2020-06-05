package com.blibli.myapplication.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blibli.myapplication.R;

import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {
    private Context mcontext;
    private List<String> list;

    //构造函数
    public LinearAdapter(Context context,List<String> list){
        this.list = list;
        this.mcontext = context;
    }
//    public LinearAdapter(Context context){
////
////        this.mcontext = mcontext;
////    }
    @NonNull
    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new LinearViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.layout_linear_item,parent,false));//参数是每一个Item的样子的布局
        return new LinearViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.layout_linear_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.LinearViewHolder holder, int position) {
        //通过holder设置内容
//        holder.textView.setText("dream it possible");
        holder.textView.setText(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
//        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }
}
