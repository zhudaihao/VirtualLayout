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
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;

import cn.zdh.virtuallayout.R;
import cn.zdh.virtuallayout.bean.StickyBean;

/**
 * 固定
 */
public class FixAdapter extends DelegateAdapter.Adapter<FixAdapter.MyViewHolder> {

    private StickyBean stickyBean;

    public FixAdapter(StickyBean stickyBean) {
        this.stickyBean = stickyBean;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        //参数 （固定的位置-->左上右下，固定后的偏移量）
        FixLayoutHelper fixLayoutHelper = new FixLayoutHelper(ScrollFixLayoutHelper.BOTTOM_RIGHT, 10, 20);
        //公共属性
        fixLayoutHelper.setItemCount(1);
        fixLayoutHelper.setPadding(20, 20, 20, 20);
        fixLayoutHelper.setMargin(10, 10, 10, 10);
//        fixLayoutHelper.setAspectRatio(1);
        fixLayoutHelper.setBgColor(Color.DKGRAY);

        //特有属性
        //设置指定位置
        fixLayoutHelper.setX(300);
        fixLayoutHelper.setY(300);



        return fixLayoutHelper;
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
