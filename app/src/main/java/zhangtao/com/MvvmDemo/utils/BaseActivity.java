package zhangtao.com.MvvmDemo.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import java.util.List;

import zhangtao.com.MvvmDemo.R;
import zhangtao.com.MvvmDemo.fast.NContext;
import zhangtao.com.MvvmDemo.fast.NStatusBarCompat;

/**
 * Created by Lenovo on 2016/9/12.
 */
public class BaseActivity extends Activity {

    protected String TAG;

    protected BaseApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        application = (BaseApplication) NContext.GetAppContext();
    }

    @Override
    protected void onStart() {
        super.onStart();
        NStatusBarCompat.compat(this, R.color.colorPrimary);
    }

    protected void intent2Activity(Class<? extends Activity> tarActivity) {
        Intent intent = new Intent(this, tarActivity);
        startActivity(intent);
    }

//    protected void showToast(String msg) {
//        ToastUtil.show(msg);
//    }
//
//    protected void showLog(String msg) {
//        fastDevLog.Log(TAG, msg);
//    }

//    public void onResume() {
//        super.onResume();
//        JPushInterface.onResume(this);
//        MobclickAgent.onResume(this);
//    }
//
//    public void onPause() {
//        super.onPause();
//        JPushInterface.onPause(this);
//        MobclickAgent.onPause(this);
//    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    public static boolean isAppIsInBackground() {
        boolean isInBackground = true;
        ActivityManager am = (ActivityManager) NContext.GetAppContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningProcesses = am.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo processInfo : runningProcesses) {
            //前台程序
            if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                for (String activeProcess : processInfo.pkgList) {
                    if (activeProcess.equals(NContext.GetAppContext().getPackageName())) {
                        isInBackground = false;
                    }
                }
            }

        }

        return isInBackground;
    }
}
