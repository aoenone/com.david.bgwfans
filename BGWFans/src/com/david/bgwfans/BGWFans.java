package com.david.bgwfans;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class BGWFans extends SideMenuActivity implements View.OnClickListener{

	private WebView webview;
	private ProgressBar Pbar;
	private AdView adView;
	String adMobId = "a151350c50621fc";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bgwfans);
        
        AdView adView = (AdView)findViewById(R.id.adMob);
		adView.loadAd(new AdRequest());
        
		webview = (WebView) findViewById(R.id.webView1);
		webview.getSettings().setJavaScriptEnabled(true);
		//webview.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN); 
		webview.getSettings().setLoadWithOverviewMode(true);
		webview.getSettings().setBuiltInZoomControls(true);
		webview.getSettings().setUseWideViewPort(true);
		webview.getSettings().setSupportZoom(true);
		webview.getSettings().setDefaultZoom(ZoomDensity.FAR);
		webview.loadUrl("http://www.bgwfans.com");
		webview.setWebViewClient(new WebViewClient());
		webview.setBackgroundColor(0x00000000);
		Pbar = (ProgressBar) findViewById(R.id.pb1);
		
		webview.setWebChromeClient(new WebChromeClient() {
			 public void onProgressChanged(WebView view, int progress)   
			 {
				 if(progress < 100 && Pbar.getVisibility() == ProgressBar.GONE){
		             Pbar.setVisibility(ProgressBar.VISIBLE);
				 }
				 Pbar.setProgress(progress);
		         if(progress == 100) {
		             Pbar.setVisibility(ProgressBar.GONE);
		         }
			 
			   }
			 });}
	
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
			webview.goBack();
		} else if (itemId == R.id.web_forward) {
			webview.goForward();
		} else if (itemId == R.id.web_refresh) {
			webview.reload();
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}
