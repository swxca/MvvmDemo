package zhangtao.com.MvvmDemo.fast;

import android.content.SharedPreferences;

public class fastDevKvdb {
    private final static Object locker = new Object();

    public static <T> T Get(String key, Class<T> type) {
        synchronized (locker) {

            SharedPreferences sharedPreferences = fastDevContext.GetAppContext().getSharedPreferences(key, 0);
            String cache_userInfo = sharedPreferences.getString("NKvdb", "");
            return fastDevJson.UnmarshalFromString(cache_userInfo, type);

        }
    }

    public static void Set(String key, Object obj) {
        synchronized (locker) {
            String jsonData = fastDevJson.MarshalToString(obj);
            SharedPreferences cache_userInfo = fastDevContext.GetAppContext().getSharedPreferences(key, 0);
            SharedPreferences.Editor editor = cache_userInfo.edit();
            editor.putString("NKvdb", jsonData);
            editor.commit();
        }
    }
}
