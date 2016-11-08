package zhangtao.com.MvvmDemo.fast;

import android.net.Uri;

/**
 * Created by keyson on 16/3/5.
 */
public class NUrl {

    public static String getUrlParameter(String url, String aimParameter){
        Uri uri = Uri.parse(url);
        return uri.getQueryParameter(aimParameter);
    }
}
