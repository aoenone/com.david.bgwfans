package com.david.bgtfans.webviews;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.david.bgtfans.R;
import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockFragmentActivity;

public class HiddenWiki extends RoboSherlockFragmentActivity {

    private WebView webview3;
    private ProgressBar Pbar;
    String value;
    ActionBar actionbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wiki);

//        ActionBar actionbar = getActionBar();
        actionbar = getSupportActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        String value = extras.getString("wikiLink");

        webview3 = (WebView) findViewById(R.id.webView3);
        webview3.getSettings().setJavaScriptEnabled(true);
        webview3.loadUrl(value);
        webview3.setWebViewClient(new WebViewClient());
        webview3.getSettings().setBuiltInZoomControls(true);
        webview3.getSettings().setDisplayZoomControls(false);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        com.actionbarsherlock.view.MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.webmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == android.R.id.home ){
           this.finish();
        } else if (itemId == R.id.web_back) {
            webview3.goBack();
        } else if (itemId == R.id.web_forward) {
            webview3.goForward();
        } else if (itemId == R.id.web_refresh) {
            webview3.reload();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}

