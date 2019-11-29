package cn.zdh.virtuallayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;

import java.util.ArrayList;
import java.util.List;

import cn.zdh.virtuallayout.adapter.ColumnAdapter;
import cn.zdh.virtuallayout.adapter.FixAdapter;
import cn.zdh.virtuallayout.adapter.FloatAdapter;
import cn.zdh.virtuallayout.adapter.GridAdapter;
import cn.zdh.virtuallayout.adapter.LinearAdapter;
import cn.zdh.virtuallayout.adapter.OnePlusNAdapter;
import cn.zdh.virtuallayout.adapter.ScrollFixAdapter;
import cn.zdh.virtuallayout.adapter.SingleAdapter;
import cn.zdh.virtuallayout.adapter.StaggeredAdapter;
import cn.zdh.virtuallayout.adapter.StickyAdapter;
import cn.zdh.virtuallayout.bean.GridBean;
import cn.zdh.virtuallayout.bean.LinearBean;
import cn.zdh.virtuallayout.bean.StickyBean;

/**
 * VLayout基本使用
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<LinearBean> list = new ArrayList<>();
    private List<GridBean> gridBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


    }

    private void initView() {
        /**
         * --------------------初始化recyclerView---------------------
         */
        recyclerView = findViewById(R.id.recyclerView);

        //设置布局管理器
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(virtualLayoutManager);

        //设置recyclerView复用池大小(根据item类型决定)
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0, 10);
        //设置复用池到recyclerView里面
        recyclerView.setRecycledViewPool(recycledViewPool);


        /**
         * ------------------------设置VLayout-----------------
         */

        //设置适配器 hasConsistItemType-->子适配器类型是否一致 默认false
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);

        //把代理适配器 设置到recyclerView
        recyclerView.setAdapter(delegateAdapter);


        /**
         * 1线性布局
         */
        //数据
        initData();
        //创建适配器
        LinearAdapter lAdapter = new LinearAdapter(list);
        //设置配器到代理适配器里面
        delegateAdapter.addAdapter(lAdapter);


        /**
         * 固定--》例如点击按钮自动滑动到顶部--默认固定右下角
         */
        //数据
        StickyBean bean = new StickyBean(R.mipmap.fx);
        FixAdapter fixAdapter = new FixAdapter(bean);
        delegateAdapter.addAdapter(fixAdapter);


        /**
         *2滑动固定布局--》滑动显示固定位置
         */
        //数据
        StickyBean bean2 = new StickyBean(R.mipmap.sf);
        ScrollFixAdapter scrollFixAdapter = new ScrollFixAdapter(bean2);
        delegateAdapter.addAdapter(scrollFixAdapter);

        /**
         * 3浮动布局-->类似苹果虚拟按键
         */
        //数据
        StickyBean bean3 = new StickyBean(R.mipmap.xn);
        FloatAdapter flostAdapter = new FloatAdapter(bean3);
        delegateAdapter.addAdapter(flostAdapter);


        /**
         * 4定格布局---》
         */
        //数据
        StickyBean stickyBean = new StickyBean(R.mipmap.sx);
        StickyAdapter stickyAdapter = new StickyAdapter(stickyBean);
        delegateAdapter.addAdapter(stickyAdapter);

        /**
         * 5网格布局
         */
        //数据
        initGridData();
        GridAdapter gridAdapter = new GridAdapter(gridBeanList);
        delegateAdapter.addAdapter(gridAdapter);

        /**
         * 6栅格栏布局---》例如需要在一行显示几个相同的itemView
         */
        List<GridBean> list1 = new ArrayList<>();
        list1.add(new GridBean(R.mipmap.tp1, "测试"));
        list1.add(new GridBean(R.mipmap.tp2, "测试"));
        list1.add(new GridBean(R.mipmap.tp3, "测试"));
        list1.add(new GridBean(R.mipmap.tp4, "测试"));
        ColumnAdapter columnAdapter = new ColumnAdapter(list1);
        delegateAdapter.addAdapter(columnAdapter);

        /**
         * 7一盒元素布局--》例如 显示一张图片文本或者文本
         */
        //数据
        StickyBean stickyBean1 = new StickyBean(R.mipmap.tp1);
        SingleAdapter singleAdapter = new SingleAdapter(stickyBean1);
        delegateAdapter.addAdapter(singleAdapter);

        /**
         * 8一拖N布局-->总数为4那就是一拖3 固定样
         */

        List<GridBean> list2 = new ArrayList<>();
        list2.add(new GridBean(R.mipmap.tp1, "测试"));
        list2.add(new GridBean(R.mipmap.tp2, "测试"));
        list2.add(new GridBean(R.mipmap.tp3, "测试"));
        list2.add(new GridBean(R.mipmap.tp4, "测试"));
        list2.add(new GridBean(R.mipmap.tp5, "测试"));
        OnePlusNAdapter onePlusNAdapter = new OnePlusNAdapter(list2);
        delegateAdapter.addAdapter(onePlusNAdapter);


        /**
         * 9瀑布流
         */
        //数据
        initGridData();
        StaggeredAdapter staggeredAdapter = new StaggeredAdapter(gridBeanList);
        delegateAdapter.addAdapter(staggeredAdapter);


    }

    private void initGridData() {
        gridBeanList.add(new GridBean(R.mipmap.tp1, "测试"));
        gridBeanList.add(new GridBean(R.mipmap.tp2, "测试"));
        gridBeanList.add(new GridBean(R.mipmap.tp3, "测试"));
        gridBeanList.add(new GridBean(R.mipmap.tp4, "测试"));
        gridBeanList.add(new GridBean(R.mipmap.tp5, "测试"));
        gridBeanList.add(new GridBean(R.mipmap.tp6, "测试"));

        gridBeanList.add(new GridBean(R.mipmap.tp1, "测试"));
        gridBeanList.add(new GridBean(R.mipmap.tp2, "测试"));
        gridBeanList.add(new GridBean(R.mipmap.tp3, "测试"));
        gridBeanList.add(new GridBean(R.mipmap.tp4, "测试"));
        gridBeanList.add(new GridBean(R.mipmap.tp5, "测试"));
        gridBeanList.add(new GridBean(R.mipmap.tp6, "测试"));
    }

    private void initData() {
        list.add(new LinearBean(R.mipmap.tp1, "测试"));
        list.add(new LinearBean(R.mipmap.tp2, "测试"));
        list.add(new LinearBean(R.mipmap.tp3, "测试"));
        list.add(new LinearBean(R.mipmap.tp4, "测试"));
        list.add(new LinearBean(R.mipmap.tp5, "测试"));
        list.add(new LinearBean(R.mipmap.tp6, "测试"));
    }
}
