package zhangtao.com.MvvmDemo.utils;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.lzy.ninegrid.NineGridView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.HttpParams;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import zhangtao.com.MvvmDemo.R;
import zhangtao.com.MvvmDemo.fast.NApp;

/**
 * Created by zhangtao on 16/11/2.
 */

public class BaseApplication extends Application {
    UniversalImageLoader universalImageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化图片加载
        initImageLoader();

        initNetRequest();

    }

    private void initNetRequest() {
        /**
         * 公共参数
         */
//        http://115.29.97.161/api/msg/notify/list?appId=3&bno=104&callId=1478759860602&channel=lenovo&did=a00000552dbe2b&extras=&lat=&lon=&pageNo=1&pageSize=15&t=411%7C4d0d24cb26c0fe4bb12e4ecb47582b1b%7C1478759857903&uid=411&v=1.1&sig=2277dfb55968e62933e3aa5bf2d74307
        HttpParams params=new HttpParams();
        params.put("appId",GeneraPara.appId);
        params.put("callId",GeneraPara.getCallId());
        params.put("lat","123");
        params.put("v",GeneraPara.v);
        params.put("did",GeneraPara.getdid(this));
        params.put("lon","234");
        params.put("bno", String.valueOf(NApp.getPackageInfo().versionCode));
        params.put("channel",NApp.metaData("UMENG_CHANNEL"));
        params.put("uid","335");
        params.put("t","335|f35f5d02dcd785f03276e4c71fdda08e|1478753528982");
        //params.put("sig",getSignature(params,"b41ab2af0fb6368495662dfeda2c68d2"));
        OkGo.init(this);
        OkGo.getInstance()
                .debug("OkGo")
                .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS)
                .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS)
                .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS)
                .setCacheMode(CacheMode.REQUEST_FAILED_READ_CACHE)
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
                .addCommonParams(params);
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
