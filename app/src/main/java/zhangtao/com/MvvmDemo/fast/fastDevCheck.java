package zhangtao.com.MvvmDemo.fast;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by zhangtao on 16/5/14.
 */
public class fastDevCheck {
    public static  boolean CheckNet(){
        ConnectivityManager cm = (ConnectivityManager) fastDevContext.GetAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

    public static boolean ExistSDCard() {
        if (android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED)) {
            return true;
        } else
            return false;
    }
}
