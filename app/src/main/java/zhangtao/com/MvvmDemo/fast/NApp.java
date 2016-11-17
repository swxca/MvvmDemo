package zhangtao.com.MvvmDemo.fast;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by keyson on 16/1/16.
 */

public class NApp {
    /**
     * 判断一个程序是否被安装
     *
     * @param packagename 包名
     * @param context
     * @return true表示已安装 false表示未安装
     */
    public static boolean isPackageInstalled(String packagename, Context context) {
        try {
            getPackageManager().getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static PackageManager getPackageManager() {
        PackageManager manager = NContext.GetAppContext().getPackageManager();
        return manager;
    }

    /**
     * packageInfo
     *
     * @return
     */
    public static PackageInfo getPackageInfo() {
        PackageInfo info = null;
        try {
            info = getPackageManager().getPackageInfo(fastDevContext.GetAppContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return info;
    }

    /**
     * ApplicationInfo
     *
     * @return
     */
    public static ApplicationInfo getApplictaionInfo() {
        ApplicationInfo info = null;
        try {
            info = getPackageManager().getApplicationInfo(getPackageInfo().packageName, PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return info;
    }

    /**
     * 获取Name为args的meta标签的Value
     *
     * @param args
     * @return
     */
    public static String metaData(String args) {
        String msg = getApplictaionInfo().metaData.getString(args);
        ;
        if (msg == null | msg.equals("")) {
            return "";
        }else {
            return msg;
        }
    }

}
