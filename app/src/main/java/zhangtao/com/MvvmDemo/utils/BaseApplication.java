package zhangtao.com.MvvmDemo.utils;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.lzy.ninegrid.NineGridView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import zhangtao.com.MvvmDemo.R;

/**
 * Created by zhangtao on 16/11/2.
 */

public class BaseApplication extends Application {
    UniversalImageLoader universalImageLoader;
    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader();

    }
//*******************************ImageLoader初始化*********************************
    private void initImageLoader() {
        if (universalImageLoader==null) {
            universalImageLoader=new UniversalImageLoader();
        }
        NineGridView.setImageLoader(new UniversalImageLoader());
        ImageLoaderConfiguration config = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(config);     //UniversalImageLoader初始化
    }

    /** UniversalImageLoader加载 */
    private class UniversalImageLoader implements NineGridView.ImageLoader {
        @Override
        public void onDisplayImage(Context context, ImageView imageView, String url) {
            ImageLoader.getInstance().displayImage(url, imageView, imageLoaderOptions);
        }

        @Override
        public Bitmap getCacheImage(String url) {
            return null;
        }
    }
    //ImageLoader参数配置
    public static DisplayImageOptions imageLoaderOptions = new DisplayImageOptions.Builder()//
            .showImageOnLoading(R.drawable.ic_default_image)    //设置图片在下载期间显示的图片
            .showImageForEmptyUri(R.drawable.ic_default_image)  //设置图片Uri为空或是错误的时候显示的图片
            .showImageOnFail(R.drawable.ic_default_image)       //设置图片加载/解码过程中错误时候显示的图片
            .cacheInMemory(true)                                //设置下载的图片是否缓存在内存中
            .cacheOnDisk(true)                                  //设置下载的图片是否缓存在SD卡中
            .build();
    //*******************************ImageLoader初始化*********************************

}
