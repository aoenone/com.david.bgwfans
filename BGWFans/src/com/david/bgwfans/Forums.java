package com.david.bgwfans;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Forums extends SideMenuActivity implements View.OnClickListener{
	
	private WebView webview2;
	private ProgressBar Pbar;
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
		Pbar = (ProgressBar) findViewById(R.id.pb1);

		webview2.setWebChromeClient(new WebChromeClient() {
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
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
		case R.id.web_back:
			webview2.goBack();
			break;
		case R.id.web_forward:
			webview2.goForward();
			break;
		case R.id.web_refresh:
			webview2.reload();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
		
	private void createNavigation() {
		// TODO Auto-generated method stub
		
	}
	
}
