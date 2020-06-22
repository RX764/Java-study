package com.blibli.myapplication.WebView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.blibli.myapplication.R;

/**
 * 加载网页
 * 加载 URL(本地或者网络)
 *      加载网络URL webview.loadURL("http://...")
 *      加载saaets下的html   webview.loadURL("file://android_assets/...")
 *      加载html代码 webview.loadDataWithBaseUrl()
 * Native和JS相互调用
 *
 * 网页的前进后退
 *      webview.canGoBack()  webview.canGoForward()   webview.canGoBackOrForward(int steps)
 *      webview.goBack()     webview.goForward()      webview.goBackOrForward(int steps)
 *
 *      * 按下返回键，默认是退出当前activity，如果希望是Webview内的页面后退
        *public boolean onKeyDown(int keyCode,KeyEvent event){
        *if((keyCode==event.KEYCODE_BACK)&&webView.canGoBack()){
        *webview.goBack();
        *return true;
        *}
        *return super.onKeyDown(keyCode,event)
        *}
 *
 *
 */
public class WebViewActivity extends AppCompatActivity {
    private  WebView mWvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWvMain= findViewById(R.id.wv);
//        加载本地HTML
//        mWvMain.loadUrl("file:///android_asset/test.html");
//        加载网络HTML  默认不支持JS，所以需要设置
        mWvMain.getSettings().setJavaScriptEnabled(true);
        mWvMain.setWebChromeClient(new myWebChormeClient());
        mWvMain.setWebViewClient(new mywebview());
        //如果没有上面这一句搜索东西会提示浏览器打开
        mWvMain.loadUrl("https://m.baidu.com");
    }

    class mywebview extends WebViewClient{
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return super.shouldOverrideUrlLoading(view, request);
        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.e("TAG", "onPageStarted: 加载开始");
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.e("TAG", "onPageFinished: 加载结束");
        }

        //该方法已经被废弃
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            return super.shouldOverrideUrlLoading(view, url);
//        }
    }

    class  myWebChormeClient extends WebChromeClient{
        //该函数实现进度条功能
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }

//    按下返回键，默认是退出当前activity，如果希望是Webview内的页面后退
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK) && mWvMain.canGoBack()){
            mWvMain.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
