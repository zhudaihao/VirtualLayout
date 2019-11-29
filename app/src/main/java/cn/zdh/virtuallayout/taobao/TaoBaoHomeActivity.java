package cn.zdh.virtuallayout.taobao;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import cn.zdh.virtuallayout.R;

/**
 * VLayout 仿淘宝首页 实战
 */
public class TaoBaoHomeActivity extends AppCompatActivity {

    //不同item必须使用不同的itemType
    private int BANNER_VIEW_TYPE = 1;
    private int MENU_VIEW_TYPE = 2;
    private int NEWS_VIEW_TYPE = 3;
    private int TITLE_VIEW_TYPE = 4;
    private int GRID_VIEW_TYPE = 5;


    private RecyclerView recyclerView;
    private List<String> bannerList = new ArrayList<>();
    private List<String> bannerTitleList = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0, 10);
        recyclerView.setRecycledViewPool(recycledViewPool);

        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(virtualLayoutManager);

        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        recyclerView.setAdapter(delegateAdapter);


        //banner
        setBanner(delegateAdapter);
        //menu
        setMenu(delegateAdapter);
        //news
        setNews(delegateAdapter);

        //title
        setTitle(delegateAdapter);


    }


    private void setBanner(DelegateAdapter delegateAdapter) {
        //数据
        bannerList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574862113663&di=90075f42a06b38800e0c3ca7f3625921&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fdesign%2F00%2F07%2F29%2F69%2F5666757345e09.jpg");
        bannerList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574862113663&di=2c5c317db08296e8c5b3dbae30092614&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F010d4f582ec1bca84a0d304f14e1b9.jpg");
        bannerTitleList.add("标题1");
        bannerTitleList.add("标题2");
        //注意count参数是显示几个itemView
        BaseDelegateAdapter baseDelegateAdapter = new BaseDelegateAdapter(new LinearLayoutHelper(), R.layout.item_banner, 1, BANNER_VIEW_TYPE) {
            @Override
            public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
                super.onBindViewHolder(baseViewHolder, i);
                //绑定数据
                Banner banner = baseViewHolder.getView(R.id.banner);
                //设置banner样式
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                //设置图片加载器
                banner.setImageLoader(new GlideImageLoader());
                //设置图片集合
                banner.setImages(bannerList);
                //设置banner动画效果
                banner.setBannerAnimation(Transformer.DepthPage);
                //设置标题（当需要显示title）
                banner.setBannerTitles(bannerTitleList);
                //设置自动轮播 默认true
                banner.isAutoPlay(true);
                //设置指示器位置
                banner.setIndicatorGravity(BannerConfig.CENTER);
                //banner设置完属性就调用开始
                banner.start();

                //监听
                banner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        Toast.makeText(TaoBaoHomeActivity.this, "banner" + position, Toast.LENGTH_SHORT).show();
                    }
                });


            }
        };

        //添加适配器 到代理适配器
        delegateAdapter.addAdapter(baseDelegateAdapter);
    }

    private void setMenu(DelegateAdapter delegateAdapter) {
        //数据
        final String[] ITEM_NAMES = {"天猫", "聚划算", "天猫国际", "外卖", "天猫超市", "充值中心", "飞猪旅行", "领金币", "拍卖", "分类"};
        final int[] IMG_URLS = {R.mipmap.ic_tian_mao, R.mipmap.ic_ju_hua_suan, R.mipmap.ic_tian_mao_guoji, R.mipmap.ic_waimai,
                R.mipmap.ic_chaoshi, R.mipmap.ic_voucher_center, R.mipmap.ic_travel, R.mipmap.ic_tao_gold, R.mipmap.ic_auction,
                R.mipmap.ic_classify};

        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        //设置水平view间间距-->左右间距离
        gridLayoutHelper.setHGap(20);
        //设置垂直view间间距--》上下间距离
        gridLayoutHelper.setVGap(16);
        BaseDelegateAdapter baseDelegateAdapter = new BaseDelegateAdapter(gridLayoutHelper, R.layout.item_menu, IMG_URLS.length, MENU_VIEW_TYPE) {
            @Override
            public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
                super.onBindViewHolder(baseViewHolder, i);
                //获取view
                ImageView imageView = baseViewHolder.getView(R.id.imageView);
                TextView textView = baseViewHolder.getView(R.id.textView);
                //设置数据
                imageView.setImageResource(IMG_URLS[i]);
                textView.setText(ITEM_NAMES[i]);


            }
        };
        //添加到代理适配器
        delegateAdapter.addAdapter(baseDelegateAdapter);
    }

    private void setNews(DelegateAdapter delegateAdapter) {
        //数据
        final List<String> info1 = new ArrayList<>();
        info1.add("天猫超市最近发大活动啦，快来抢");
        info1.add("没有最便宜，只有更便宜！");

        final List<String> info2 = new ArrayList<>();
        info2.add("这个是用来搞笑的，不要在意这写小细节！");
        info2.add("啦啦啦啦，我就是来搞笑的！");
        BaseDelegateAdapter baseDelegateAdapter = new BaseDelegateAdapter(new LinearLayoutHelper(), R.layout.item_news, 1, NEWS_VIEW_TYPE) {

            @Override
            public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
                super.onBindViewHolder(baseViewHolder, i);
                //获取控件
                MarqueeView marqueeView1 = baseViewHolder.getView(R.id.marqueeView1);
                MarqueeView marqueeView2 = baseViewHolder.getView(R.id.marqueeView2);

                //设置数据
                marqueeView1.startWithList(info1);
                marqueeView2.startWithList(info2);
                //设置动画（也可以在xml设置）
                marqueeView1.startWithList(info1, R.anim.anim_bottom_in, R.anim.anim_top_out);
                marqueeView2.startWithList(info2, R.anim.anim_bottom_in, R.anim.anim_top_out);


                //点击事件
                marqueeView1.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position, TextView textView) {
                        Toast.makeText(TaoBaoHomeActivity.this, "news" + position, Toast.LENGTH_SHORT).show();
                    }
                });
                marqueeView2.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position, TextView textView) {
                        Toast.makeText(TaoBaoHomeActivity.this, "news" + position, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };

        delegateAdapter.addAdapter(baseDelegateAdapter);
    }

    private void setTitle(DelegateAdapter delegateAdapter) {
        //数据
        //广告位
        final int[] ITEM_URL = {R.mipmap.item1, R.mipmap.item2, R.mipmap.item3, R.mipmap.item4, R.mipmap.item5};
        //高颜值商品位
        final int[] GRID_URL = {R.mipmap.flashsale1, R.mipmap.flashsale2, R.mipmap.flashsale3, R.mipmap.flashsale4};

        for (int t = 0; t < ITEM_URL.length; t++) {

            //title
            final int finalT = t;
            BaseDelegateAdapter baseDelegateAdapter = new BaseDelegateAdapter(new SingleLayoutHelper(), R.layout.item_title, 1, TITLE_VIEW_TYPE) {
                @Override
                public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
                    super.onBindViewHolder(baseViewHolder, i);
                    ImageView imageView = baseViewHolder.getView(R.id.imageView);
                    imageView.setImageResource(ITEM_URL[finalT]);

                }
            };
            delegateAdapter.addAdapter(baseDelegateAdapter);
            //grid
            BaseDelegateAdapter baseDelegateAdapter1 = new BaseDelegateAdapter(new GridLayoutHelper(2), R.layout.item_content, GRID_URL.length, GRID_VIEW_TYPE) {
                @Override
                public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
                    super.onBindViewHolder(baseViewHolder, i);
                    ImageView imageView = baseViewHolder.getView(R.id.imageView);
                    imageView.setImageResource(GRID_URL[i]);
                }
            };
            delegateAdapter.addAdapter(baseDelegateAdapter1);


        }
    }
}
