package com.david.bgwfans;

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
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;


public class Forums extends RoboSherlockFragment {

    private WebView webview2;
    private ProgressBar Pbar;
    private Tracker mGaTracker;
    private GoogleAnalytics mGaInstance;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.forums, container, false);

        mGaInstance = GoogleAnalytics.getInstance(getSherlockActivity());
        mGaTracker = mGaInstance.getTracker("UA-39204043-1");


        webview2 = (WebView) view.findViewById(R.id.webView2);
        webview2.getSettings().setJavaScriptEnabled(true);
        webview2.getSettings().setPluginsEnabled(true);
        webview2.loadUrl("http://www.bgwfans.com/forums");
        webview2.setWebViewClient(new WebViewClient());
        webview2.getSettings().setBuiltInZoomControls(true);
        webview2.getSettings().setDisplayZoomControls(false);
        //webview2.setBackgroundColor(0x00000000);
        Pbar = (ProgressBar) view.findViewById(R.id.pb1);
        setHasOptionsMenu(true);

        webview2.setWebChromeClient(new WebChromeClient() {
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
            webview2.goBack();
        } else if (itemId == R.id.web_forward) {
            webview2.goForward();
        } else if (itemId == R.id.web_refresh) {
            webview2.reload();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        EasyTracker.getInstance().activityStart(getActivity()); // Add this method.
    }

    @Override
    public void onStop() {
        super.onStop();
        EasyTracker.getInstance().activityStop(getActivity()); // Add this method.
    }

}
