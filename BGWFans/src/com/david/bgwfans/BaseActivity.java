package com.david.bgwfans;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import com.cyrilmottier.polaris.PolarisMapView;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.SlidingMenu.OnCloseListener;
import com.slidingmenu.lib.app.SlidingMapActivity;

public class BaseActivity extends SlidingMapActivity implements View.OnClickListener {

	//private int mTitleRes;
	protected MapActivity mFrag;
	private PolarisMapView mMapView;
	public SlidingMenu sm;
	private SlidingMenu smr;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//setTitle(mTitleRes);

		// set the Behind View
		setBehindContentView(R.layout.menu_scrollview);
		//android.app.FragmentTransaction t = this.getFragmentManager().beginTransaction();
		//mFrag = new HOS_Map();
		//t.replace(R.id.menu_frame, mFrag);
		//t.commit();

		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		//SlidingMenu smr = showSecondaryMenu();
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		sm.setMode(SlidingMenu.LEFT_RIGHT);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setFadeEnabled(true);
		sm.setFadeEnabled(true);
		sm.setFadeDegree(0.95f);
		sm.setSecondaryMenu(R.layout.sidemap);
		sm.setSecondaryShadowDrawable(R.drawable.shadowright);
		//sm.attachToActivity(this,  SlidingMenu.SLIDING_CONTENT);
		//sm.viewBehind();

		getSlidingMenu().setOnCloseListener(new OnCloseListener(){
			public void onClose(){
				mMapView.setUserTrackingButtonEnabled(false);
			}
		});
		
		//getSlidingMenu().setOnOpenListener(new OnOpenListener(){
		//	public void onOpen(){
		//		 mMapView.setUserTrackingButtonEnabled(true);
		//	}
		//});
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		 	mMapView = (PolarisMapView) findViewById(R.id.mapview);
	        //getSlidingMenu().setOnOpenedListener(new OnOpenedListener(){
			
		 	mMapView.setUserTrackingButtonEnabled(true);
	        mMapView.setSatellite(true);
	        MapController mapController = mMapView.getController();
			mapController.animateTo(new GeoPoint(37235407, -76646019));
			mMapView.invalidate();
			mapController.setZoom(19);
			
			
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
	
	//@Override
	//protected void onResume()
	//{
	//	toggle();
	//}
	
	@Override
    protected void onStart() {
        super.onStart();
        mMapView.onStart();
        mMapView.setUserTrackingButtonEnabled(false);
        toggle();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMapView.onStop();
    }
	
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		//super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.sidemapmenu, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(android.view.MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
		case R.id.open_sidemap: getSlidingMenu().showSecondaryMenu(true);
								mMapView.setUserTrackingButtonEnabled(true);
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	 public void onClick(View v) {
	    	//int postion = 0;
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
	        //sm.setActivated(v);
	        //mContentTextView.setText("Active item: " + ((TextView) v).getText());
	        //sm.closeMenu();
	        //mActiveViewId = v.getId();
	    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}



}
