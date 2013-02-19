package com.david.bgwfans;




import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuInflater;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.SlidingMenu.OnOpenedListener;
import com.slidingmenu.lib.app.SlidingActivity;
import com.slidingmenu.lib.app.SlidingActivityHelper;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

public class SideMenuActivity extends SlidingFragmentActivity implements View.OnClickListener{

	
	//geo points for all bathrooms in the park
		private Marker b1;
		private static final LatLng B1 = new LatLng(37.235452,-76.645974);
		private Marker b2;
		private static final LatLng B2 = new LatLng(37.236357,-76.645663);
		private Marker b3;
		private static final LatLng B3 = new LatLng(37.234975,-76.649074);
		private Marker b4;
		private static final LatLng B4 = new LatLng(37.235768,-76.647556);
		private Marker b5;
		private static final LatLng B5 = new LatLng(37.236265,-76.647742);
		private Marker b6;
		private static final LatLng B6 = new LatLng(37.234072,-76.648717);
		private Marker b7;
		private static final LatLng B7 = new LatLng(37.233079,-76.646847);
		private Marker b8;
		private static final LatLng B8 = new LatLng(37.231436,-76.646203);
		private Marker b9;
		private static final LatLng B9 = new LatLng(37.233756,-76.643855);
		private Marker b10;
		private static final LatLng B10 = new LatLng(37.234635,-76.641682);
		private Marker b11;
		private static final LatLng B11 = new LatLng(37.237228,-76.645271);
		
	
	public GoogleMap mMap;
	private SlidingActivityHelper mHelper;
	private Fragment mFrag;
	public SlidingMenu sm;
	
	static final CameraPosition HOME =
            new CameraPosition.Builder().target(new LatLng(37.235466, -76.646328))
                    .zoom(17)
                    .bearing(0)
                    .tilt(25)
                    .build();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setBehindContentView(R.layout.menu_scrollview);

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
		//sm.setSecondaryMenu(R.layout.menu_scrollview);
		sm.setSecondaryShadowDrawable(R.drawable.shadowright);
		sm.setBackgroundColor(0x000000000);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getSlidingMenu().setOnOpenedListener(new OnOpenedListener() {
			  public void onOpened() {
			    getSlidingMenu().invalidate();
			    //mMap.setMyLocationEnabled(true);
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
	        //findViewById(R.id.item14).setOnClickListener(this);

	}

	
	@Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        //toggle();
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
	
	 private void setUpMap() {
		 
		 	mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			mMap.getUiSettings().setZoomControlsEnabled(false);
			mMap.moveCamera(CameraUpdateFactory.newCameraPosition(HOME));
			addBathroomsToMap();
	    }
	 
	 
	
	/** public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.sidemapmenu, menu);
		return true;
	} **/
	
	public boolean onOptionsItemSelected(android.view.MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	 public void onClick(View v) {
			switch(v.getId())
	    	{ 
			case R.id.item1: Intent infoActivity = new Intent(this, InfoScreen.class);
				toggle();
				startActivity(infoActivity);
				break;
			case R.id.item2: Intent attrActivity = new Intent(this, Attractions.class);
				toggle();
				startActivity(attrActivity);
				break;
			case R.id.item3: Intent showsActivity = new Intent(this, HOS_Shows.class);
				startActivity(showsActivity);
				toggle();
				break;
			case R.id.item4: Intent eatActivity = new Intent(this, Eateries.class);
				startActivity(eatActivity);
				toggle();
				break;
			case R.id.item5: Intent mapActivity = new Intent(this, ParkMap.class);
				startActivity(mapActivity);
				toggle();
				break;
			/**case R.id.item6: Intent hhActivity = new Intent(this, HOS_Houses.class);
				startActivity(hhActivity);
				break;
			case R.id.item7: Intent hshowActivity = new Intent(this, HOS_Shows.class);
				startActivity(hshowActivity);
				break;
			case R.id.item8: Intent featuresActivity = new Intent(this, HOS_Features.class);
				startActivity(featuresActivity);
				break;
			case R.id.item14: Intent hosMapActivity = new Intent(this, HOS_Map.class);
				startActivity(hosMapActivity);
				break; **/
	    	case R.id.item9: Intent blogActivity = new Intent(this, BGWFans.class);
	    		startActivity(blogActivity);
	    		toggle();
	    		break;
	    	case R.id.item10: Intent forumActivity = new Intent(this, Forums.class);
	    		startActivity(forumActivity);
	    		toggle();
	    		break;
	    	case R.id.item11: Intent wikiActivity = new Intent(this, Wiki.class);
	    		startActivity(wikiActivity);
	    		toggle();
	    		break;
	    	case R.id.item12: Intent settingsActivity = new Intent(this, Settings.class);
				startActivity(settingsActivity);
				toggle();
				break;
	    	case R.id.item13: Intent aboutActivity = new Intent(this, About.class);
				startActivity(aboutActivity);
				toggle();
				break;
	    	}
	    }
	 
	 public void addBathroomsToMap()
		{
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
}

