package zhangtao.com.MvvmDemo.fast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class NActivity extends Activity {

    static public void JumpToByClass(Context fromActivity, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(fromActivity, cls);
        fromActivity.startActivity(intent);
    }

    // 可以在任意线程调用,已解决主线程问题
    static public void JumpToByClassAndFinish(final Activity fromActivity, final Class<?> cls) {
        NThread.RunOnMainThread(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(fromActivity, cls);
                fromActivity.startActivity(intent);
                fromActivity.finish();
            }
        });
    }

    public void JumpToByClassWithoutContext(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), cls);
        startActivity(intent);
    }

    private static boolean hasInitActivityRun = false;
    private static Class<?> InitActivity = null;
    public static void RegisterInitActivity(Class<?> InitActivity){
        NActivity.InitActivity = InitActivity;
    }
    public static void InitActivityRun(){
        hasInitActivityRun = true;
    }

    // 如果跳转了就返回true,没有跳转,返回 false
    // 请在主线程调用
    // 解决android在crash后,进程会随意进入某个非初始界面的问题.(导致初始化代码没有运行)
    // 使用方法: 在 Application.onCreate 上面注册初始界面
    public static boolean JumpToLancherActivityIfNotInit(final Activity fromActivity) {
        if (hasInitActivityRun){
            return false;
        }
        if (NActivity.InitActivity == null){
            //fastDevLog.Log("error","[JumpToLancherActivityIfNotInit] InitActivity == null");
            return false;
        }
        if (fromActivity.isFinishing()){
            return true;
        }
        //fastDevLog.Log("debug","[JumpToLancherActivityIfNotInit] jumpTo",
               // fromActivity.getClass().getName(), NActivity.InitActivity.getName());
        JumpToByClass(fromActivity, NActivity.InitActivity);
        fromActivity.finish();
        return true;
    }
}