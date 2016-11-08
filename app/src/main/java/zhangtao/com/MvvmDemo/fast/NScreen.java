package zhangtao.com.MvvmDemo.fast;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by zhangtao on 16/4/28.
 */
public class NScreen {
    public static DisplayMetrics initDisplayMetrics(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }

    public static float getScreenDensity(Activity activity) {
        return initDisplayMetrics(activity).density;
    }

    public static int getScreenHeightPixels(Activity activity) {
        return initDisplayMetrics(activity).heightPixels;
    }

    public static int getScreenWidthPixels(Activity activity) {
        return initDisplayMetrics(activity).widthPixels;
    }

    public static int getScreenDPWidth(Activity activity) {
        return (int) (getScreenWidthPixels(activity) / getScreenDensity(activity));
    }

    public static int getScreenDPHeight(Activity activity) {
        return (int) (getScreenHeightPixels(activity) / getScreenDensity(activity));
    }

    public static int pxChangedp(Activity activity, int px) {
        return (int) (px / getScreenDensity(activity));
    }

    public static int dpChangepx(Activity activity, int dp) {
        return (int) (dp * getScreenDensity(activity));
    }
}
