package com.david.bgwfans.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdLayout;
import com.amazon.device.ads.AdListener;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.AdTargetingOptions;
import com.crittercism.app.Crittercism;
import com.david.bgwfans.R;
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
    AdLayout adLayout;
    AdTargetingOptions adTargetingOptions;
    LinearLayout adFail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.forums, container, false);

        mGaInstance = GoogleAnalytics.getInstance(getSherlockActivity());
        mGaTracker = mGaInstance.getTracker("UA-39204043-1");


        webview2 = (WebView) view.findViewById(R.id.webView2);
        webview2.getSettings().setJavaScriptEnabled(true);
        webview2.loadUrl("http://www.bgwfans.com/forums");
        webview2.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                adLayout.loadAd(adTargetingOptions);
            }
        });
        webview2.getSettings().setBuiltInZoomControls(true);
        webview2.getSettings().setDisplayZoomControls(false);
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

        final Runnable mRunnable;
        final Handler mHandler=new Handler();

        mRunnable=new Runnable() {

            @Override
            public void run() {
                adLayout.loadAd(adTargetingOptions);
            }
        };

        adFail = (LinearLayout) view.findViewById(R.id.ad_fail_view);
        adFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goProIntent();
            }
        });

        try {
//            AdRegistration.enableTesting(true);
            AdRegistration.setAppKey("9dc03c16047340d88ed5e306f717b2ac");
        } catch (Exception e) {
            Crittercism.logHandledException(e);
        }

        adLayout = (AdLayout) view.findViewById(R.id.ad_view);
        adTargetingOptions = new AdTargetingOptions();
        adLayout.loadAd(adTargetingOptions);
        adLayout.setListener(new AdListener() {
            @Override
            public void onAdLoaded(AdLayout adLayout, AdProperties adProperties) {
                adFail.setVisibility(View.GONE);
            }

            @Override
            public void onAdExpanded(AdLayout adLayout) {
                //
            }

            @Override
            public void onAdCollapsed(AdLayout adLayout) {
                //
            }

            @Override
            public void onAdFailedToLoad(AdLayout adLayout, AdError adError) {
                adFail.setVisibility(View.VISIBLE);
                mHandler.postDelayed(mRunnable,10*1000);
                Log.d("aderror", adError.getMessage());
            }
        });
        return view;
    }

    private void goProIntent(){
        Tracker tracker = EasyTracker.getTracker();
        tracker.sendEvent("go_pro", "go_pro_clicked", "user_go_pro", null);
        String url = "https://play.google.com/store/apps/details?id=com.david.bgwfanspro";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
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
