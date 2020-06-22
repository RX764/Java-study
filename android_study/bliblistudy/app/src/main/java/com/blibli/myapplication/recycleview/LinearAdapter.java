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
    private MyonClick myonclick;

    //构造函数
    public LinearAdapter(Context context,List<String> list,MyonClick myonclick){
        this.list = list;
        this.mcontext = context;
        this.myonclick = myonclick;
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
    public void onBindViewHolder(@NonNull LinearAdapter.LinearViewHolder holder, final int position) {
        //通过holder设置内容
//        holder.textView.setText("dream it possible");
        holder.textView.setText(list.get(position));
        //利用回调函数给每一个item设计点击事件
        //也可以不用回调函数。这样的话就不用了myonclik接口。直接把点击事件设置在onBindViewHolder
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myonclick.onclick(position);
            }
        });
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
    public interface MyonClick{
        void onclick(int pos);
    }
}
