package cn.zdh.virtuallayout.taobao;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * banner 图片加载器
 */
public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //使用Glide加载图片

        Glide.with(context).load(path).into(imageView);
    }
}
