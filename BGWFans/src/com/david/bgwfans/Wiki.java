package com.david.bgwfans;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;


public class Wiki extends SideMenuActivity implements View.OnClickListener {

    private WebView webview3;
    private ProgressBar Pbar;
    private Tracker mGaTracker;
    private GoogleAnalytics maInstance;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.wiki);

        maInstance = GoogleAnalytics.getInstance(this);
        mGaTracker = maInstance.getTracker("UA-39204043-1");

        //getWindow().setFeatureInt( Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);

        ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setListNavigationCallbacks(null, null);
        actionbar.setDisplayHomeAsUpEnabled(true);

        webview3 = (WebView) findViewById(R.id.webView3);
        webview3.getSettings().setJavaScriptEnabled(true);
        webview3.loadUrl("http://wiki.parkfans.net/index.php/Busch_Gardens_Williamsburg");
        webview3.setWebViewClient(new WebViewClient());
        webview3.getSettings().setBuiltInZoomControls(false);
        webview3.setBackgroundColor(0x00000000);
        Pbar = (ProgressBar) findViewById(R.id.pb1);

        webview3.setWebChromeClient(new WebChromeClient() {
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

    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.webmenu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            toggle();
            return true;
        } else if (itemId == R.id.web_back) {
            webview3.goBack();
        } else if (itemId == R.id.web_forward) {
            webview3.goForward();
        } else if (itemId == R.id.web_refresh) {
            webview3.reload();
        }
        return super.onOptionsItemSelected(item);
    }

}

