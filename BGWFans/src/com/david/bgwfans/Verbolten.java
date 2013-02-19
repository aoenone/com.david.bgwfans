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
		
		Intent i = new Intent(getApplicationContext(), HiddenWiki.class);
		i.putExtra("wikiLink", "http://wiki.parkfans.net/index.php/Verbolten");
		startActivity(i);
	}

}
