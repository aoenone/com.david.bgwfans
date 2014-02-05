package com.david.bgtfans.eateries;


import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.webkit.WebView;

import com.david.bgtfans.webviews.HiddenWiki;
import com.david.bgtfans.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Grill extends FragmentActivity implements View.OnClickListener {
    private GoogleMap mMap;
    public WebView webViewWiki;

    static final CameraPosition HOME =
            new CameraPosition.Builder().target(new LatLng(37.235862, -76.647386))
                    .zoom(17)
                    .bearing(0)
                    .tilt(25)
                    .build();

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

    }
    //public WebView webViewWiki;
    //WebView webViewWiki = (WebView)findViewById(R.id.webViewWiki);
    //webviewWiki.loadUrl("http://wiki.parkfans.net/index.php/Busch_Gardens_Williamsburg");


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grill);
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

    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(37.235862, -76.647386)).title("Grogan's Grill"));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.setMyLocationEnabled(false);
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(HOME));
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


    public void Wiki(View view) {

        Intent i = new Intent(getApplicationContext(), HiddenWiki.class);
        i.putExtra("wikiLink", "http://wiki.parkfans.net/index.php/Grogan%27s_Grill");
        startActivity(i);
    }

}


