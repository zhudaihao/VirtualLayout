package cn.zdh.virtuallayout.taobao;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * 封装适配器
 * 使用BaseViewHolder不需要写ViewHolder
 */
public class BaseDelegateAdapter extends DelegateAdapter.Adapter<BaseViewHolder> {
    //helper类
    private LayoutHelper layoutHelper;
    //布局id
    private int itemLayoutId;
    //itemView数据
    private int count;
    //itemView 类型
    private int itemViewType;

    public BaseDelegateAdapter(LayoutHelper layoutHelper, int itemLayoutId, int count, int itemViewType) {
        this.layoutHelper = layoutHelper;
        this.itemLayoutId = itemLayoutId;
        this.count = count;
        this.itemViewType = itemViewType;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }


    /**
     * @param viewGroup
     * @param i  ------》itemView类型
     * @return
     */
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == itemViewType) {
            View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayoutId, viewGroup, false);
            return new BaseViewHolder(itemView);
        }
        return null;
    }

    /**
     *
     * @param baseViewHolder
     * @param i--->数据的position
     */
    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        return itemViewType;
    }
}
