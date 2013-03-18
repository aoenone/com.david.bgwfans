package com.david.bgwfans;


import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.SlidingMenu.OnCloseListener;
import com.slidingmenu.lib.SlidingMenu.OnOpenedListener;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

public class SideMenuActivity extends SlidingFragmentActivity implements View.OnClickListener {


    //geo points for all bathrooms in the park
    private Marker b1;
    private static final LatLng B1 = new LatLng(37.235452, -76.645974);
    private Marker b2;
    private static final LatLng B2 = new LatLng(37.236357, -76.645663);
    private Marker b3;
    private static final LatLng B3 = new LatLng(37.234975, -76.649074);
    private Marker b4;
    private static final LatLng B4 = new LatLng(37.235768, -76.647556);
    private Marker b5;
    private static final LatLng B5 = new LatLng(37.236265, -76.647742);
    private Marker b6;
    private static final LatLng B6 = new LatLng(37.234072, -76.648717);
    private Marker b7;
    private static final LatLng B7 = new LatLng(37.233079, -76.646847);
    private Marker b8;
    private static final LatLng B8 = new LatLng(37.231436, -76.646203);
    private Marker b9;
    private static final LatLng B9 = new LatLng(37.233756, -76.643855);
    private Marker b10;
    private static final LatLng B10 = new LatLng(37.234635, -76.641682);
    private Marker b11;
    private static final LatLng B11 = new LatLng(37.237228, -76.645271);

    //geo points for ATM's in the park
    private Marker a1;
    private static final LatLng A1 = new LatLng(37.236391, -76.646529);
    private Marker a2;
    private static final LatLng A2 = new LatLng(37.234191, -76.648491);
    private Marker a3;
    private static final LatLng A3 = new LatLng(37.231714, -76.646054);

    //geo points for the main eating areas in the park
    private static final LatLng BEER = new LatLng(37.232464, -76.64566);
    private Marker beer;
    private static final LatLng FESTHAUS = new LatLng(37.2314, -76.646201);
    private Marker festhaus;
    private static final LatLng SMOKEHOUSE = new LatLng(37.23381, -76.648819);
    private Marker smokehouse;
    private static final LatLng PIAZZA = new LatLng(37.233835, -76.643954);
    private Marker piazza;
    private static final LatLng GRILLE = new LatLng(37.236133, -76.645618);
    private Marker grille;
    private static final LatLng CUCINA = new LatLng(37.234501, -76.641524);
    private Marker cucina;
    private static final LatLng PUB = new LatLng(37.236011, -76.647567);
    private Marker pub;
    private static final LatLng GRILL = new LatLng(37.235862, -76.647386);
    private Marker grill;


    public GoogleMap mMap;
    //private SlidingActivityHelper mHelper;
    //private Fragment mFrag;
    public SlidingMenu sm;
    private Tracker mGaTracker;
    private GoogleAnalytics mGaInstance;

    static final CameraPosition HOME =
            new CameraPosition.Builder().target(new LatLng(37.235466, -76.646328))
                    .zoom(17)
                    .bearing(0)
                    .tilt(25)
                    .build();

    public void addATMToMap() {
        a1 = mMap.addMarker(new MarkerOptions()
                .position(A1)
                .title("ATM"));

        a2 = mMap.addMarker(new MarkerOptions()
                .position(A2)
                .title("ATM"));

        a3 = mMap.addMarker(new MarkerOptions()
                .position(A3)
                .title("ATM"));
    }

    /**
     * case R.id.item6: Intent hhActivity = new Intent(this, HOS_Houses.class);
     * startActivity(hhActivity);
     * break;
     * case R.id.item7: Intent hshowActivity = new Intent(this, HOS_Shows.class);
     * startActivity(hshowActivity);
     * break;
     * case R.id.item8: Intent featuresActivity = new Intent(this, HOS_Features.class);
     * startActivity(featuresActivity);
     * break;
     * case R.id.item14: Intent hosMapActivity = new Intent(this, HOS_Map.class);
     * startActivity(hosMapActivity);
     * break; *
     */

    public void addBathroomsToMap() {
        b1 = mMap.addMarker(new MarkerOptions()
                .position(B1)
                .title("Bathroom"));

        b2 = mMap.addMarker(new MarkerOptions()
                .position(B2)
                .title("Bathroom"));

        b3 = mMap.addMarker(new MarkerOptions()
                .position(B3)
                .title("Bathroom"));

        b4 = mMap.addMarker(new MarkerOptions()
                .position(B4)
                .title("Bathroom"));

        b5 = mMap.addMarker(new MarkerOptions()
                .position(B5)
                .title("Bathroom"));

        b6 = mMap.addMarker(new MarkerOptions()
                .position(B6)
                .title("Bathroom"));

        b7 = mMap.addMarker(new MarkerOptions()
                .position(B7)
                .title("Bathroom"));

        b8 = mMap.addMarker(new MarkerOptions()
                .position(B8)
                .title("Bathroom"));

        b9 = mMap.addMarker(new MarkerOptions()
                .position(B9)
                .title("Bathroom"));

        b10 = mMap.addMarker(new MarkerOptions()
                .position(B10)
                .title("Bathroom"));

        b11 = mMap.addMarker(new MarkerOptions()
                .position(B11)
                .title("Bathroom"));
    }

    private void addEatToMap() {
        beer = mMap.addMarker(new MarkerOptions()
                .position(BEER)
                .title("Beste Brezeln und Bier")
                .snippet("speciality beer and pretzels"));

        festhaus = mMap.addMarker(new MarkerOptions()
                .position(FESTHAUS)
                .title("Das Festhaus")
                .snippet("German style eatery with daily shows"));

        smokehouse = mMap.addMarker(new MarkerOptions()
                .position(SMOKEHOUSE)
                .title("Trapper's Smokehouse")
                .snippet("Classic smokehouse style food and scenery"));

        piazza = mMap.addMarker(new MarkerOptions()
                .position(PIAZZA)
                .title("Ristorante Della Piazza")
                .snippet("Italian stlye eatery with daily shows"));

        grille = mMap.addMarker(new MarkerOptions()
                .position(GRILLE)
                .title("Squire's Grille")
                .snippet("serves breakfast, along with a diverse lunch and dinner menu"));

        grill = mMap.addMarker(new MarkerOptions()
                .position(GRILL)
                .title("Grogran's Grill")
                .snippet("Irish style eatery, with nearby street performers"));

        pub = mMap.addMarker(new MarkerOptions()
                .position(PUB)
                .title("Grogan's Pub")
                .snippet("Drinks, snacks and speciality beers"));

        cucina = mMap.addMarker(new MarkerOptions()
                .position(CUCINA)
                .title("La Cucina")
                .snippet("All you can eat pizza and pasta buffet"));

    }

    public void destroyItem(View collection, int position, Object o) {
        // TODO Auto-generated method stub

    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.item1) {
            Intent infoActivity = new Intent(this, InfoScreen.class);
            toggle();
            startActivity(infoActivity);
        } else if (id == R.id.item2) {
            Intent attrActivity = new Intent(this, Attractions.class);
            toggle();
            startActivity(attrActivity);
        } else if (id == R.id.item3) {
            Intent showsActivity = new Intent(this, HOS_Shows.class);
            startActivity(showsActivity);
            toggle();
        } else if (id == R.id.item4) {
            Intent eatActivity = new Intent(this, Eateries.class);
            startActivity(eatActivity);
            toggle();
        } else if (id == R.id.item5) {
            Intent mapActivity = new Intent(this, ParkMap.class);
            startActivity(mapActivity);
            toggle();
        } else if (id == R.id.item9) {
            Intent blogActivity = new Intent(this, BGWFans.class);
            startActivity(blogActivity);
            toggle();
        } else if (id == R.id.item10) {
            Intent forumActivity = new Intent(this, Forums.class);
            startActivity(forumActivity);
            toggle();
        } else if (id == R.id.item11) {
            Intent wikiActivity = new Intent(this, Wiki.class);
            startActivity(wikiActivity);
            toggle();
        } else if (id == R.id.item12) {
            Intent settingsActivity = new Intent(this, Settings.class);
            startActivity(settingsActivity);
            toggle();
        } else if (id == R.id.item13) {
            Intent aboutActivity = new Intent(this, About.class);
            startActivity(aboutActivity);
            toggle();
        } else if (id == R.id.wineinfo){
        	Intent eventInfo = new Intent(this, EventInfo.class);
        	startActivity(eventInfo);
        	toggle();        	
        } else if (id == R.id.wineattractions){
        	Intent eventAttractions = new Intent(this, EventAttractions.class);
        	startActivity(eventAttractions);
        	toggle();
        } else if (id == R.id.winemap){
        	Intent eventMap = new Intent(this, EventMap.class);
        	startActivity(eventMap);
        	toggle();
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.DrawerTheme);
        super.onCreate(savedInstanceState);
        setBehindContentView(R.layout.menu_scrollview);

        mGaInstance = GoogleAnalytics.getInstance(this);
        mGaTracker = mGaInstance.getTracker("UA-39204043-1");

        // customize the SlidingMenu
        SlidingMenu sm = getSlidingMenu();
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        sm.setMode(SlidingMenu.LEFT_RIGHT);
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        sm.setShadowDrawable(R.drawable.shadow);
        sm.setShadowWidthRes(R.dimen.shadow_width);
        sm.setShadowWidthRes(R.dimen.shadow_width);
        sm.setFadeEnabled(true);
        sm.setFadeEnabled(true);
        sm.setFadeDegree(0.95f);
        sm.setSecondaryMenu(R.layout.sidemenumap);
        sm.setSelectorEnabled(true);
        //sm.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        sm.setSelectorDrawable(R.drawable.ab_solid_bgwfans);
        //sm.setSecondaryMenu(R.layout.menu_scrollview);
        sm.setSecondaryShadowDrawable(R.drawable.shadowright);
        sm.setBackgroundColor(0x000000000);
        setSlidingActionBarEnabled(false);


        final ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getSlidingMenu().setOnOpenedListener(new OnOpenedListener() {
            public void onOpened() {
                //getSlidingMenu().invalidate();
                actionbar.setDisplayHomeAsUpEnabled(false);
                //mMap.setMyLocationEnabled(true);
                getSlidingMenu().invalidate();
            }
        });
        getSlidingMenu().setOnCloseListener(new OnCloseListener() {
            public void onClose() {
                actionbar.setDisplayHomeAsUpEnabled(true);
                //mMap.setMyLocationEnabled(false);
                getSlidingMenu().invalidate();
            }

        });
        setUpMapIfNeeded();

        findViewById(R.id.item1).setOnClickListener(this);
        findViewById(R.id.item2).setOnClickListener(this);
        findViewById(R.id.item3).setOnClickListener(this);
        findViewById(R.id.item4).setOnClickListener(this);
        findViewById(R.id.item5).setOnClickListener(this);
        //findViewById(R.id.item6).setOnClickListener(this);
        //findViewById(R.id.item7).setOnClickListener(this);
        //findViewById(R.id.item8).setOnClickListener(this);
        findViewById(R.id.item9).setOnClickListener(this);
        findViewById(R.id.item10).setOnClickListener(this);
        findViewById(R.id.item11).setOnClickListener(this);
        findViewById(R.id.item12).setOnClickListener(this);
        findViewById(R.id.item13).setOnClickListener(this);
        findViewById(R.id.wineinfo).setOnClickListener(this);
        findViewById(R.id.wineattractions).setOnClickListener(this);
        findViewById(R.id.winemap).setOnClickListener(this);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            //Put the code for an action menu from the top here
            toggle();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                toggle();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        //toggle();
    }

    @Override
    public void onStart() {
        super.onStart();
        EasyTracker.getInstance().activityStart(this); // Add this method.\
        //mGaTracker.sendView("/SlidingMenu");
    }

    @Override
    public void onStop() {
        super.onStop();
        EasyTracker.getInstance().activityStop(this); // Add this method.
    }

    protected void setUpMap() {

        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(HOME));
        addBathroomsToMap();
        addEatToMap();
        addATMToMap();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            //mMap = ((MapView) findViewById(R.id.map)).getMap();
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.swipemap))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }
}

