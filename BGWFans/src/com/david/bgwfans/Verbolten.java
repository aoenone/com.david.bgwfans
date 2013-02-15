package com.david.bgwfans;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class Verbolten extends FragmentActivity implements View.OnClickListener {
	private GoogleMap mMap;
	public WebView webViewWiki;
	
	static final CameraPosition HOME =
            new CameraPosition.Builder().target(new LatLng(37.232449, -76.645534))
                    .zoom(17)
                    .bearing(0)
                    .tilt(25)
                    .build();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.vbolt2);
	setUpMapIfNeeded();
	
	ActionBar actionbar = getActionBar();
    actionbar.setDisplayShowTitleEnabled(false);
    actionbar.setDisplayHomeAsUpEnabled(true);

	}


	@Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }
	
	private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }
	
	private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(37.232449, -76.645534)).title("Verbolten").snippet("Brave the Black Forest!"));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.setMyLocationEnabled(false);
		mMap.getUiSettings().setZoomControlsEnabled(false);
		mMap.moveCamera(CameraUpdateFactory.newCameraPosition(HOME));
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	//public WebView webViewWiki;
	//WebView webViewWiki = (WebView)findViewById(R.id.webViewWiki);
	//webviewWiki.loadUrl("http://wiki.parkfans.net/index.php/Busch_Gardens_Williamsburg");
	
		
	
	public void Wiki(View view){
		
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.hidden, null);
        WebView rl = (WebView)findViewById(R.id.hideWiki);
        RelativeLayout.LayoutParams parametri = new  RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        parametri.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        rl.addView(v, parametri);
        
		//WebView webViewWiki = (WebView) findViewById(R.id.webViewWiki);
		LinearLayout hiddenLayout = (LinearLayout) findViewById(R.id.hiddenLayout);
		//WebView hiddenLayout = (WebView) findViewById(R.id.wiki);
		//webViewWiki.loadUrl("http://wiki.parkfans.net/index.php/Verbolten");
		if (hiddenLayout == null)
		{
			LinearLayout myLayout = (LinearLayout)findViewById(R.id.linearLayout2);
			View hiddenInfo = getLayoutInflater().inflate(R.layout.hidden, myLayout, false);
			myLayout.addView(hiddenInfo);
			//WebView myLayout = (WebView)findViewById(R.id.webView3);
			//View hiddenWiki = getLayoutInflater().inflate(R.layout.wiki, myLayout, false);
			//myLayout.addView(webViewWiki);
			//webViewWiki.loadUrl("http://wiki.parkfans.net/index.php/Verbolten");
		}
		//int visibility = webViewWiki.getVisibility();

	    //    if(visibility==View.GONE)
	    //        webViewWiki.setVisibility(View.VISIBLE);
		
		Context context = getApplicationContext();
		CharSequence text = "Coming Soon!";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
		//String wikiLink = new String();
		// Intent s = new Intent(Verbolten.this, Wiki.class);
        // Bundle d = new Bundle();
        // d.putString("http://wiki.parkfans.net/index.php/Verbolten", wikiLink);
		
		//Intent wikiActivity = new Intent(this, Verbolten.class);
		//startActivity(wikiActivity);
	}

}
