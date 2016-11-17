package zhangtao.com.MvvmDemo.fast;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by zhangtao on 16/5/14.
 */
public class NCheckNet {
    public static  boolean CheckNet(){
        ConnectivityManager cm = (ConnectivityManager) NContext.GetAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()){
           // NToast.NToast("您的网络有点问题");
            return true;
        }else {
            NToast.fastToast("您的网络有点问题");
            return false;
        }
    }
}
