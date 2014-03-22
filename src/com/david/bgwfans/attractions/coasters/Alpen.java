package com.david.bgwfans.attractions.coasters;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.david.bgwfans.R;
import com.david.bgwfans.webviews.HiddenWiki;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Alpen extends SherlockFragmentActivity {
    private GoogleMap mMap;
    public WebView webViewWiki;

    static final CameraPosition HOME =
            new CameraPosition.Builder().target(new LatLng(37.232808, -76.647436))
                    .zoom(17)
                    .bearing(0)
                    .tilt(25)
                    .build();

    //public WebView webViewWiki;
    //WebView webViewWiki = (WebView)findViewById(R.id.webViewWiki);
    //webviewWiki.loadUrl("http://wiki.parkfans.net/index.php/Busch_Gardens_Williamsburg");


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alpengeist);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(37.232808, -76.647436)).title("Alpengeist").snippet("The slopes are closed"));
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
        i.putExtra("wikiLink", "http://wiki.parkfans.net/index.php/Alpengeist");
        startActivity(i);
    }

}
