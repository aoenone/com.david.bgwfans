package com.david.bgwfans;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Wiki extends WindowSample implements View.OnClickListener{
	
	private WebView webview3;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wiki);
		
		ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
		actionbar.setListNavigationCallbacks(null, null);
        actionbar.setDisplayHomeAsUpEnabled(true);
        createNavigation();
 
		webview3 = (WebView) findViewById(R.id.webView3);
		webview3.getSettings().setJavaScriptEnabled(true);
		webview3.loadUrl("http://wiki.parkfans.net/index.php/Busch_Gardens_Williamsburg");
		webview3.setWebViewClient(new WebViewClient());
		webview3.getSettings().setBuiltInZoomControls(true);
		webview3.setBackgroundColor(0x00000000);
		
		

}
	private void createNavigation() {
		// TODO Auto-generated method stub
		
	}
	
}

