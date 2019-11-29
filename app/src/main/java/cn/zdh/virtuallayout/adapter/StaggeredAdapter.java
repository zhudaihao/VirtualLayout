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
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;

import java.util.List;

import cn.zdh.virtuallayout.R;
import cn.zdh.virtuallayout.bean.GridBean;

/**
 * 网格
 */
public class StaggeredAdapter extends DelegateAdapter.Adapter<StaggeredAdapter.MyViewHolder> {

    private List<GridBean> list;

    public StaggeredAdapter(List<GridBean> list) {
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper();
        //公共属性

        //这设置item数量如果和getItemCount方法冲突以getItemCount方法为准
        staggeredGridLayoutHelper.setItemCount(list.size());
        staggeredGridLayoutHelper.setPadding(20, 20, 20, 20);
        staggeredGridLayoutHelper.setMargin(10, 10, 10, 10);
        //宽 高比
//        scrollFixLayoutHelper.setAspectRatio(1);
        //背景颜色
        staggeredGridLayoutHelper.setBgColor(Color.DKGRAY);

        //特有属性
        //设置开不了每行的item数量
        staggeredGridLayoutHelper.setLane(3);
        //设置子元素之间的 水平间距
        staggeredGridLayoutHelper.setHGap(20);
        //设置子元素之间的 间垂直间距
        staggeredGridLayoutHelper.setVGap(10);


        return staggeredGridLayoutHelper;
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
