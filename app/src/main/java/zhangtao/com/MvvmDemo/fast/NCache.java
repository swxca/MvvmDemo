package zhangtao.com.MvvmDemo.fast;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zhangtao on 16/5/14.
 */
public class NCache {
    //用sharePreferences实现缓存
    static public void SetLocalCache(Context context, String fileName, String cacheName, Object data) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(cacheName, data.toString());
        editor.commit();
    }

    static public String GetLocalCache(Context context, String fileName, String cacheName) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, 0);
        return sharedPreferences.getString(cacheName, "");
    }

    static public Long GetLocalCacheLong(Context context, String fileName, String cacheName) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, 0);
        return sharedPreferences.getLong(cacheName, Long.valueOf("0"));
    }
}
