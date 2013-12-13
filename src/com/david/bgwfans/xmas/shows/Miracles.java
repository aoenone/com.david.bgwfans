package com.david.bgwfans.xmas.shows;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.david.bgwfans.R;
import com.david.bgwfans.utils.fadingScroller.FadingHelper;
import com.david.bgwfans.viewcomponents.XmasItem;
import com.david.bgwfans.webviews.HiddenWiki;
import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockFragmentActivity;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by david.hodge on 11/20/13.
 */
public class Miracles extends RoboSherlockFragmentActivity {

    XmasItem forum;
    GoogleMap mMap;
    private static final LatLng LOC_BITTEN = new LatLng(37.233491,-76.644021);
    static final CameraPosition HOME =
            new CameraPosition.Builder().target(LOC_BITTEN)
                    .zoom(17)
                    .bearing(0)
                    .tilt(25)
                    .build();


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setTheme(R.style.HOSTheme);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setIcon(android.R.color.transparent);

        FadingHelper helper = new FadingHelper()
                .actionBarBackground(R.color.black_overlay)
                .headerLayout(R.layout.xmas_header)
                .parallax(true)
                .contentLayout(R.layout.xmas_miracles);

        setContentView(helper.createView(this));
        helper.initActionBar(this);
        setUpMapIfNeeded();

        forum = (XmasItem) findViewById(R.id.forum);
        forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HiddenWiki.class);
                i.putExtra("wikiLink", "http://forum.parkfans.net/thread-1673.html");
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.hos_attr_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.menu_item_share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "I'm at Miracles, via the BGWFans for Android app! " + "https://play.google.com/store/apps/details?id=com.david.bgwfans");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
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
        mMap.addMarker(new MarkerOptions()
                .position(LOC_BITTEN)
                .title("Miracles")
                .snippet("Celebrate the spirit of Christmas through powerful movement and dance."));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.setMyLocationEnabled(false);
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(HOME));
    }

    @Override
    public void onStart() {
        super.onStart();
        EasyTracker.getInstance().activityStart(this); // Add this method.
    }

    @Override
    public void onStop() {
        super.onStop();
        EasyTracker.getInstance().activityStop(this); // Add this method.
    }
}
