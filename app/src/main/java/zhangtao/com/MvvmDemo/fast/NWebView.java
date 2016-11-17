package zhangtao.com.MvvmDemo.fast;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import zhangtao.com.MvvmDemo.utils.ProgressDialogUtils;

/**
 * Created by zhangtao on 16/4/26.
 */
public class NWebView extends WebView {
    String actionBarTitle;

    //三个构造方法,互相调用.(还可以在第三个里增加XML的属性然后调用)
    public NWebView(Context context) {
        this(context, null);
    }

    public NWebView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //初始化一些webview的设置
    public void initSettings() {
        WebSettings webSettings = this.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
    }

    //载入有进度条的链接
    public void setUrlWithProgress(final Activity activity, String url, final TextView textView) {
        initSettings();
        this.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                activity.setProgress(newProgress * 1000);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                textView.setText(title);
            }
        });
        this.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        this.loadUrl(url);
    }

    //交互的接口
    public interface JStoJavaInterface {
        @JavascriptInterface
        void JStoJava(String str);

    }

    private JStoJavaInterface jStoJavaInterface;

    //JS和java的交互,调用的时候在JS的代码里用interfaceName.JStoJava("")调用,
    //JStoJava里实现android的逻辑代码
    //android的target大于17重写后要在方法上加注解JavascriptInterface
    public void setJStoJava(JStoJavaInterface jStoJavaInterface, String interfaceName) {
        this.jStoJavaInterface = jStoJavaInterface;
        initSettings();
        this.addJavascriptInterface(jStoJavaInterface, interfaceName);
    }

    //java调用JS
    public void javaToJS(String functionName) {
        initSettings();
        this.loadUrl("javascript:" + functionName);
    }

    //载入一个html文件,这个文件放在系统默认的assets文件夹里.
    public void loadHtmlFile(String fileName) {
        initSettings();
        this.loadUrl("file:///android_asset/" + fileName);
    }

    public void initCacheSettings() {
        WebSettings webSettings = this.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //设置缓存模式
        if (NCheckNet.CheckNet() == true) {
            clearCache();
            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        } else {
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }

        // 开启DOM storage API 功能
        webSettings.setDomStorageEnabled(true);
        // 开启database storage API功能
        webSettings.setDatabaseEnabled(true);
    }

    public void clearCache() {
        this.clearCache(true);
    }

    public void refresh() {
        this.reload();
    }

    public void loadCacheUrl(String url, final Context context) {
        initSettings();
        initCacheSettings();
        this.loadUrl(url);
        this.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (!((Activity) context).isFinishing()) {
                    ProgressDialogUtils.create(context);
                    ProgressDialogUtils.customProgressDialog.show();
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                ProgressDialogUtils.dismiss();
            }

        });
    }

    public void loadCacheUrlWithoutCreateBar(String url, final Context context) {
        initSettings();
        initCacheSettings();
        this.loadUrl(url);
        this.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (!((Activity) context).isFinishing()) {
                    ProgressDialogUtils.customProgressDialog.show();
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                ProgressDialogUtils.dismiss();
            }
        });
    }
}



