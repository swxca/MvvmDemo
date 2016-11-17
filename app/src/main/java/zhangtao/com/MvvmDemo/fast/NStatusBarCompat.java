package zhangtao.com.MvvmDemo.fast;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by zhangtao on 16/10/27.
 */
public class NStatusBarCompat {
    private static final int INVALID_VAL = -1;
    private static final int COLOR_DEFAULT = Color.parseColor("#3eb576");

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void compat(Activity activity, int statusColor)
    {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            if (statusColor != INVALID_VAL)
            {
                activity.getWindow().setStatusBarColor(statusColor);
            }
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
        {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            int color = COLOR_DEFAULT;
            ViewGroup contentView = (ViewGroup) activity.findViewById(android.R.id.content);
            if (statusColor != INVALID_VAL)
            {
                color = statusColor;
            }
            View statusBarView = new View(activity);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    getStatusBarHeight(activity));
            Log.e("skdjsagd",color+"===---=="+Color.parseColor("#3eb576"));
            statusBarView.setBackgroundColor(statusColor);
            contentView.addView(statusBarView, lp);
        }

    }

    public static void compat(Activity activity)
    {
        compat(activity, INVALID_VAL);
    }


    public static int getStatusBarHeight(Context context)
    {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
        {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
