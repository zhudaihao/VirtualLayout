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
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;

import java.util.List;

import cn.zdh.virtuallayout.R;
import cn.zdh.virtuallayout.bean.GridBean;

/**
 * 一拖N
 */
public class OnePlusNAdapter extends DelegateAdapter.Adapter<OnePlusNAdapter.MyViewHolder> {

    private List<GridBean> list;

    public OnePlusNAdapter(List<GridBean> list) {
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        //参数 （固定的位置-->左上右下，固定后的偏移量）
        OnePlusNLayoutHelper onePlusNLayoutHelper = new OnePlusNLayoutHelper();
        //公共属性
        // 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        onePlusNLayoutHelper.setPadding(20, 20, 20, 20);
        // 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        onePlusNLayoutHelper.setMargin(20, 20, 20, 20);
        // 设置背景颜色
        onePlusNLayoutHelper.setBgColor(Color.GRAY);
        // 设置设置布局内每行布局的宽与高的比
        onePlusNLayoutHelper.setAspectRatio(3);
        //背景颜色
        onePlusNLayoutHelper.setBgColor(Color.GRAY);
        //特有属性
        //设置行比重 （整个布局是左边一个布局容器，右边两个（一个上一个下），第一个权重决定了后面所有的权重）
       onePlusNLayoutHelper.setColWeights(new float[]{40,60,20,20});


        return onePlusNLayoutHelper;
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
