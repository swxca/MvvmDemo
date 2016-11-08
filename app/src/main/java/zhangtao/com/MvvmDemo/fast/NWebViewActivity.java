package zhangtao.com.MvvmDemo.fast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import zhangtao.com.MvvmDemo.R;


/**
 * Created by zhangtao on 16/4/27.
 */
public class NWebViewActivity extends Activity {
    static NWebView NWebView;
    static String str;
    TextView appBar;
    static int appBarColor;
    RelativeLayout barLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        appBar = new TextView(this);
        appBar.setTextColor(Color.WHITE);
        appBar.setText("详情");
        NWebView = new NWebView(this);
        barLayout=new RelativeLayout(this);
        RelativeLayout.LayoutParams barLayoutParams=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, NScreen.dpChangepx(this, 48));
        ImageView backBtn=new ImageView(this);
        backBtn.setBackground(getResources().getDrawable(R.mipmap.ic_arrow_w_back));
        RelativeLayout.LayoutParams backBtnLayoutParams= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        backBtnLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        backBtnLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        backBtnLayoutParams.leftMargin=18;
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setActionBarColor();
        //appBar.setLayoutParams(new LinearLayout.LayoutParams((int) NScreen.getScreenWidthPixels(this), NScreen.dpChangepx(this, 55)));
        //Toast.makeText(this,title,Toast.LENGTH_SHORT).show();
        appBar.setGravity(Gravity.CENTER);
        appBar.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        RelativeLayout.LayoutParams appBarLayoutParams=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        appBarLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);


        NWebView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        if (str.startsWith("http")) {
            NWebView.loadCacheUrl(str,this);
        } else {
            NWebView.loadHtmlFile(str);
        }

        barLayout.addView(backBtn,backBtnLayoutParams);
        barLayout.addView(appBar,appBarLayoutParams);

        linearLayout.addView(barLayout,barLayoutParams);
        linearLayout.addView(NWebView);
        setContentView(linearLayout);
    }
    //跳转一个webview,actionbar的默认颜色是蓝色.
    public static void startWebviewActivity(Activity activity, String url, int color) {
        appBarColor = color;
        str = url;
        Intent intent = new Intent(activity, NWebViewActivity.class);
        activity.startActivity(intent);
    }
    //跳转一个webview,actionbar的颜色自己指定
    public static void startWebviewActivity(Context activity, String url) {
        appBarColor = -1;
        str = url;
        Intent intent = new Intent(activity, NWebViewActivity.class);
        activity.startActivity(intent);
    }
    //设置Actionbar的颜色
    public void setActionBarColor() {
        if (appBarColor == -1) {
            Log.e("kjdjfd","dslad");
            barLayout.setBackgroundColor(Color.parseColor("#3eb576"));
        } else {
            barLayout.setBackgroundColor(getResources().getColor(appBarColor));
        }
    }

}
