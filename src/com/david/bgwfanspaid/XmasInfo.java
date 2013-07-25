package com.david.bgwfanspaid;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class XmasInfo extends SideMenuActivity implements View.OnClickListener {

    private WebView webview4;

    private void createNavigation() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmas_info);

        ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setListNavigationCallbacks(null, null);
        actionbar.setDisplayHomeAsUpEnabled(true);
        createNavigation();

        webview4 = (WebView) findViewById(R.id.webView4);
        webview4.getSettings().setJavaScriptEnabled(true);
        webview4.loadUrl("http://thumbnails.visually.netdna-cdn.com/busch-gardens-christmas-town_50b8d3341fb25.jpg");
        webview4.setWebViewClient(new WebViewClient());
        webview4.getSettings().setBuiltInZoomControls(true);
        webview4.setBackgroundColor(0x00000000);


    }

}


