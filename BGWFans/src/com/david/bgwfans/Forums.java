package com.david.bgwfans;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Forums extends BaseActivity implements View.OnClickListener{
	
	private WebView webview2;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forums);
		
		ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
		actionbar.setListNavigationCallbacks(null, null);
        actionbar.setDisplayHomeAsUpEnabled(true);
        createNavigation();
 
		webview2 = (WebView) findViewById(R.id.webView2);
		webview2.getSettings().setJavaScriptEnabled(true);
		webview2.loadUrl("http://www.bgwfans.com/forums");
		webview2.setWebViewClient(new WebViewClient());
		webview2.getSettings().setBuiltInZoomControls(true);
		webview2.setBackgroundColor(0x00000000);
		
		

}
	private void createNavigation() {
		// TODO Auto-generated method stub
		
	}
	
}
