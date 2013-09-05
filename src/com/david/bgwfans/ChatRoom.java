package com.david.bgwfans;

import android.os.Bundle;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

public class ChatRoom extends SideMenuActivity {

private WebView webview;
private ProgressBar Pbar;
private Tracker mGaTracker;
private GoogleAnalytics mGaInstance;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.bgwfans);

    mGaInstance = GoogleAnalytics.getInstance(this);
    mGaTracker = mGaInstance.getTracker("UA-39204043-1");

    webview = (WebView) findViewById(R.id.webView1);
    webview.getSettings().setJavaScriptEnabled(true);
    //webview.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
    //webview.getSettings().setLoadWithOverviewMode(true);
    webview.getSettings().setBuiltInZoomControls(true);
    webview.getSettings().setDisplayZoomControls(false);
    //webview.getSettings().setUseWideViewPort(true);
    webview.getSettings().setSupportZoom(true);
    //webview.getSettings().setDefaultZoom(ZoomDensity.FAR);
    webview.loadUrl("http://chat.parkfans.net");
    webview.setWebViewClient(new WebViewClient());
    webview.setBackgroundColor(0x00000000);
    Pbar = (ProgressBar) findViewById(R.id.pb1);

    webview.setWebChromeClient(new WebChromeClient() {
        public void onProgressChanged(WebView view, int progress) {
            if (progress < 100 && Pbar.getVisibility() == ProgressBar.GONE) {
                Pbar.setVisibility(ProgressBar.VISIBLE);
            }
            Pbar.setProgress(progress);
            if (progress == 100) {
                Pbar.setVisibility(ProgressBar.GONE);
            }

        }
    });
}

public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    MenuInflater inflater = getSupportMenuInflater();
    inflater.inflate(R.menu.webmenu, menu);
    return true;
}

@Override
public void onDestroy() {
    super.onDestroy();
}

public boolean onOptionsItemSelected(MenuItem item) {
    int itemId = item.getItemId();
    if (itemId == android.R.id.home) {
        toggle();
        return true;
    } else if (itemId == R.id.web_back) {
        webview.goBack();
    } else if (itemId == R.id.web_forward) {
        webview.goForward();
    } else if (itemId == R.id.web_refresh) {
        webview.reload();
    }
    return super.onOptionsItemSelected(item);
}

}
