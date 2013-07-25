package com.david.bgwfanspaid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;


public class Wiki extends RoboSherlockFragment{

    private WebView webview3;
    private ProgressBar Pbar;
    private Tracker mGaTracker;
    private GoogleAnalytics maInstance;


    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.wiki, container, false);

        maInstance = GoogleAnalytics.getInstance(getSherlockActivity());
        mGaTracker = maInstance.getTracker("UA-39204043-1");

        //getWindow().setFeatureInt( Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);

        webview3 = (WebView) view.findViewById(R.id.webView3);
        webview3.getSettings().setJavaScriptEnabled(true);
        webview3.loadUrl("http://wiki.parkfans.net/index.php/Busch_Gardens_Williamsburg");
        webview3.setWebViewClient(new WebViewClient());
        webview3.getSettings().setBuiltInZoomControls(true);
        webview3.getSettings().setDisplayZoomControls(false);
        webview3.setBackgroundColor(0x00000000);
        Pbar = (ProgressBar) view.findViewById(R.id.pb1);

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
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.webmenu, menu);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.web_back) {
            webview3.goBack();
        } else if (itemId == R.id.web_forward) {
            webview3.goForward();
        } else if (itemId == R.id.web_refresh) {
            webview3.reload();
        }
        return super.onOptionsItemSelected(item);
    }

}

