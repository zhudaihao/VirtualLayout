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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;

import java.util.List;

import cn.zdh.virtuallayout.R;
import cn.zdh.virtuallayout.bean.GridBean;

/**
 * 网格
 */
public class GridAdapter extends DelegateAdapter.Adapter<GridAdapter.MyViewHolder> {

    private List<GridBean> list;
    public GridAdapter(List<GridBean> list) {
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        //参数 ：网格中列行数（必须大于0）
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);
        //设置宽高比
//        gridLayoutHelper.setAspectRatio(1);
        //设置垂直 边距 （两个view之间上下距离）
        gridLayoutHelper.setGap(20);
        //设置水平边距（水平两个view之间左右距离）
        gridLayoutHelper.setHGap(10);
        //设置背景颜色
        gridLayoutHelper.setBgColor(Color.DKGRAY);
        //设置是否填充空白区域
        gridLayoutHelper.setAutoExpand(true);


        return gridLayoutHelper;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid, viewGroup, false);
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
