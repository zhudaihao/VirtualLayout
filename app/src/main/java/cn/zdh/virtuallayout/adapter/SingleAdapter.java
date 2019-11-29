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
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;

import cn.zdh.virtuallayout.R;
import cn.zdh.virtuallayout.bean.StickyBean;

/**
 * 一盒元素
 */
public class SingleAdapter extends DelegateAdapter.Adapter<SingleAdapter.MyViewHolder> {

    private StickyBean stickyBean;

    public SingleAdapter(StickyBean stickyBean) {
        this.stickyBean = stickyBean;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        // 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setPadding(20, 20, 20, 20);
        // 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);
        // 设置背景颜色
        singleLayoutHelper.setBgColor(Color.GRAY);
        // 设置设置布局内每行布局的宽与高的比
        singleLayoutHelper.setAspectRatio(6);


        return singleLayoutHelper;
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
        myViewHolder.imageView.setImageResource(stickyBean.getImage());

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}
