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
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;

import cn.zdh.virtuallayout.R;
import cn.zdh.virtuallayout.bean.StickyBean;

/**
 * 滑动 固定
 */
public class ScrollFixAdapter extends DelegateAdapter.Adapter<ScrollFixAdapter.MyViewHolder> {

    private StickyBean stickyBean;

    public ScrollFixAdapter(StickyBean stickyBean) {
        this.stickyBean = stickyBean;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        //参数 （固定的位置-->左上右下，固定后的偏移量）
        ScrollFixLayoutHelper scrollFixLayoutHelper = new ScrollFixLayoutHelper(ScrollFixLayoutHelper.BOTTOM_RIGHT, 10, 20);
        //公共属性
        scrollFixLayoutHelper.setItemCount(1);
        scrollFixLayoutHelper.setPadding(20, 20, 20, 20);
        scrollFixLayoutHelper.setMargin(10, 10, 10, 10);
//        scrollFixLayoutHelper.setAspectRatio(1);
        scrollFixLayoutHelper.setBgColor(Color.DKGRAY);

        //特有属性 参数显示类型 SHOW_ALWAYS 一直显示；SHOW_ON_ENTER 当页面滑动 就开始显示，滑动到顶部隐藏； SHOW_ON_LEAVE 当整个页面滑动到结束位置显示,向上滑动一段距离就隐藏
        scrollFixLayoutHelper.setShowType(ScrollFixLayoutHelper.SHOW_ON_LEAVE);



        return scrollFixLayoutHelper;
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
