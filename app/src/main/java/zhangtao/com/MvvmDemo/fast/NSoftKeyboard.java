package zhangtao.com.MvvmDemo.fast;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class NSoftKeyboard {
    // 点击parentView时，隐藏软键盘
    public static void ClickHideKeyBoard(final Activity activity, View parentView) {
        if (!(parentView instanceof EditText)) {
            parentView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
                    return false;
                }
            });
        }
        if (parentView instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) parentView).getChildCount(); i++) {
                View innerView = ((ViewGroup) parentView).getChildAt(i);
                ClickHideKeyBoard(activity, innerView);
            }
        }
    }

    static public void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
