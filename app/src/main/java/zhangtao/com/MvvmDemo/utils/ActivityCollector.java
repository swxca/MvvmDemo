package zhangtao.com.MvvmDemo.utils;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangtao on 16/9/14.
 */
public class ActivityCollector {
    public static List<Activity> activities=new ArrayList<>();
    public static void addActivity(Activity activity)
    {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity)
    {
        activities.remove(activity);
    }

    public static void finishAll()
    {
        Log.e("sadoajsd","finishAll");
        for (Activity activity:activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
