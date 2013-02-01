package com.david.bgwfans;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.SlidingMenu.OnOpenedListener;
import com.slidingmenu.lib.app.SlidingActivity;
import com.slidingmenu.lib.app.SlidingActivityHelper;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

public class SideMenuActivity extends SlidingFragmentActivity implements View.OnClickListener{

	//private int mTitleRes;
	//protected MapActivity mFrag;
	private GoogleMap mMap;
	private SlidingActivityHelper mHelper;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setTitle(mTitleRes);
		// set the Behind View
		setBehindContentView(R.layout.menu_scrollview);
		//super.onCreate(savedInstanceState);
		//setTitle(mTitleRes);
		// set the Behind View
		//setBehindContentView(R.layout.mapv2);
		//mHelper = new SlidingActivityHelper(this);
		//mHelper.onCreate(savedInstanceState);

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
    }
	
	private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((MapView) findViewById(R.id.map)).getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }
	
	 private void setUpMap() {
		 
		 	mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			mMap.getUiSettings().setZoomControlsEnabled(false);
	        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
	    }
	 
	 
	
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.sidemapmenu, menu);
		return true;
	}
	
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
				startActivity(infoActivity);
				break;
			case R.id.item2: Intent attrActivity = new Intent(this, Attractions.class);
				startActivity(attrActivity);
				break;
			case R.id.item3: Intent showsActivity = new Intent(this, HOS_Shows.class);
				startActivity(showsActivity);
				break;
			case R.id.item4: Intent eatActivity = new Intent(this, Eateries.class);
				startActivity(eatActivity);
				break;
			case R.id.item5: Intent mapActivity = new Intent(this, ParkMap.class);
				startActivity(mapActivity);
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
	    		break;
	    	case R.id.item10: Intent forumActivity = new Intent(this, Forums.class);
	    		startActivity(forumActivity);
	    		break;
	    	case R.id.item11: Intent wikiActivity = new Intent(this, Wiki.class);
	    		startActivity(wikiActivity);
	    		break;
	    	case R.id.item12: Intent settingsActivity = new Intent(this, Settings.class);
				startActivity(settingsActivity);
				break;
	    	case R.id.item13: Intent aboutActivity = new Intent(this, About.class);
				startActivity(aboutActivity);
				break;
	    	}
	    }
}

