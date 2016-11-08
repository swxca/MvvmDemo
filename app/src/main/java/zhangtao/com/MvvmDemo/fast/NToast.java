package zhangtao.com.MvvmDemo.fast;

import android.widget.Toast;

/**
 * Created by zhangtao on 16/5/14.
 */
public class NToast {
    public static void fastToast(String hintString){
        Toast.makeText(NContext.GetAppContext(),hintString,Toast.LENGTH_SHORT).show();
    }
}
