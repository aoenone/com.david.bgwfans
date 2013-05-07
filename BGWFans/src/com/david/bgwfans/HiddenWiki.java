package com.david.bgwfans;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.google.ads.AdRequest;
import com.google.ads.AdView;

public class HiddenWiki extends Activity {

    private AdView adView;
    String adMobId = "a151350c50621fc";
    private WebView webview3;
    private ProgressBar Pbar;
    String value;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wiki);

        AdView adView = (AdView) findViewById(R.id.adMob);
        adView.loadAd(new AdRequest());

        ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setListNavigationCallbacks(null, null);
        actionbar.setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        String value = extras.getString("wikiLink");


        webview3 = (WebView) findViewById(R.id.webView3);
        webview3.getSettings().setJavaScriptEnabled(true);
        webview3.loadUrl(value);
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

    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            finish();
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

