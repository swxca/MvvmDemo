package zhangtao.com.MvvmDemo.utils;

import android.app.ProgressDialog;
import android.content.Context;

import zhangtao.com.MvvmDemo.R;


/**
 * Created by Lenovo on 2016/9/8.
 */
public class ProgressDialogUtils {
    public static CustomProgressDialog customProgressDialog;
    public static ProgressDialog progressDialog;


    public static void create(Context context){
        customProgressDialog=new CustomProgressDialog(context, R.style.loading_dialog);
        customProgressDialog.setCancelable(true);

    }
    public static void dismiss(){
        customProgressDialog.dismiss();
    }
    public static void createForProgressDialog(Context context,String msg){
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(msg);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }
    public static void dismissForProgressDialog(){
        progressDialog.dismiss();
    }

}
