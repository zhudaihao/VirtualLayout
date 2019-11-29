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
import com.alibaba.android.vlayout.layout.FloatLayoutHelper;

import cn.zdh.virtuallayout.R;
import cn.zdh.virtuallayout.bean.StickyBean;

/**
 * 定格
 */
public class FloatAdapter extends DelegateAdapter.Adapter<FloatAdapter.MyViewHolder> {

    private StickyBean stickyBean;

    public FloatAdapter(StickyBean stickyBean) {
        this.stickyBean = stickyBean;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        FloatLayoutHelper floatLayoutHelper = new FloatLayoutHelper();
        // 公共属性
        // 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        floatLayoutHelper.setPadding(20, 20, 20, 20);
//        // 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
//        floatLayoutHelper.setMargin(20, 20, 20, 20);
        // 设置背景颜色
        floatLayoutHelper.setBgColor(Color.GRAY);
        // 设置设置布局内每行布局的宽与高的比
//        stickyLayoutHelper.setAspectRatio(6);


        return floatLayoutHelper;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_stick, viewGroup, false);
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
