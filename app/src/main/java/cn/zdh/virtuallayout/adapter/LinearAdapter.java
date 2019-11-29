package cn.zdh.virtuallayout.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;

import java.util.List;

import cn.zdh.virtuallayout.R;
import cn.zdh.virtuallayout.bean.LinearBean;

/**
 * 线性布局 适配器（这适配器可以复用）
 */
public class LinearAdapter extends DelegateAdapter.Adapter<LinearAdapter.MyViewHolder> {

    private List<LinearBean> list;
    public LinearAdapter(List<LinearBean> list) {
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        //设置线限布局帮助类
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        //设置基本属性

        //设置itemView的数量
        linearLayoutHelper.setItemCount(list.size());
        //设置分割线高度（注意不能设置分割线的颜色）
        linearLayoutHelper.setDividerHeight(8);
        //设置背景颜色
        linearLayoutHelper.setBgColor(Color.DKGRAY);
        /**
         * 分割线颜色实现：
         * 1：直接在itemView添加一个view作为分割线
         * 2：通过设置背景颜色（分割线颜色）+itemView设置背景颜色 实现设置分割线颜色
         */
        //设置itemView权重 -->宽高比例


        return linearLayoutHelper;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_linear, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.textView.setText(list.get(i).getContent()+i);
        myViewHolder.imageView.setImageResource(list.get(i).getImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
