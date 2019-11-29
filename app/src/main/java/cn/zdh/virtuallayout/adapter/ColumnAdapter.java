package cn.zdh.virtuallayout.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;

import java.util.List;

import cn.zdh.virtuallayout.R;
import cn.zdh.virtuallayout.bean.GridBean;

/**
 * 栅格栏
 */
public class ColumnAdapter extends DelegateAdapter.Adapter<ColumnAdapter.MyViewHolder> {

    private List<GridBean> list;

    public ColumnAdapter(List<GridBean> list) {
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        //公共属性
        columnLayoutHelper.setItemCount(1);
        columnLayoutHelper.setPadding(20, 20, 20, 20);
        columnLayoutHelper.setMargin(10, 10, 10, 10);
//        columnLayoutHelper.setAspectRatio(1);
        columnLayoutHelper.setBgColor(Color.BLUE);

        //特有属性
        //设置权重 设置每个itemView占该行总宽度比例 (横向)
        // 注意 1:总数和为100 ;注意2数组的长度需要和集合一致
        columnLayoutHelper.setWeights(new float[]{60, 20, 10,10});


        return columnLayoutHelper;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_column, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.imageView.setImageResource(list.get(i).getImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}
