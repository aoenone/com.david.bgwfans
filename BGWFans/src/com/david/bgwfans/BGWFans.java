package com.david.bgwfans;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BGWFans extends WindowSample implements View.OnClickListener{

	private WebView webview;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bgwfans);
		
		ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
		actionbar.setListNavigationCallbacks(null, null);
        actionbar.setDisplayHomeAsUpEnabled(true);
 
		webview = (WebView) findViewById(R.id.webView1);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.loadUrl("http://www.bgwfans.com");
		webview.setWebViewClient(new WebViewClient());
		webview.getSettings().setBuiltInZoomControls(true);
		webview.setBackgroundColor(0x00000000);

	}
	}
