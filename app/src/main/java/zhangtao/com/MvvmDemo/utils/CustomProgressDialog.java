package zhangtao.com.MvvmDemo.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import zhangtao.com.MvvmDemo.R;


/**
 * Created by Lenovo on 2016/9/8.
 */
public class CustomProgressDialog extends Dialog {
    private Context context;
    public CustomProgressDialog(Context context) {
        super(context);
        this.context=context;
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.custom_progress_dialog,null);
        setContentView(view);
    }

    public CustomProgressDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context=context;
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.custom_progress_dialog,null);
        setContentView(view);
    }
}
