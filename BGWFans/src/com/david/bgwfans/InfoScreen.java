package com.david.bgwfans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import com.cyrilmottier.polaris.PolarisMapView;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;

import net.simonvt.widget.MenuDrawerManager;
import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class InfoScreen extends BaseActivity{


	private WebView webview;
	private MenuDrawerManager mMenuDrawer;
		@Override
		public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);
		
		ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
		actionbar.setListNavigationCallbacks(null, null);
        actionbar.setDisplayHomeAsUpEnabled(true);
        createNavigation();
		
		
        //String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        //
       // Calendar c = Calendar.getInstance();
       // SimpleDateFormat df = new SimpleDateFormat("MMM dd yyyy");
       // String curDate = df.format(c.getTime());
       // 
       // Time today = new Time(Time.getCurrentTimezone());
       // today.setToNow();
        
       // TextView textTime = (TextView) findViewById(R.id.curTime);
       // textTime.setText(curDate);
        
        //Typeface rt = Typeface.createFromAsset(getAssets(),
       //         "fonts/Roboto-Thin.ttf");
       // TextView loc = (TextView) findViewById(R.id.location);
       // TextView park = (TextView) findViewById(R.id.parkhours);
       // TextView xmas = (TextView) findViewById(R.id.xmas);
       // loc.setTypeface(rt);
       // park.setTypeface(rt);
       // xmas.setTypeface(rt);

}
		
		public void XmasInfo(View view){
			Intent xmasActivity = new Intent(this, XmasInfo.class);
			startActivity(xmasActivity);
		}
		

		private void createNavigation() {
			// TODO Auto-generated method stub
			
		}
		
}
