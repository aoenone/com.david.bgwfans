package com.david.bgwfans;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.MenuItem;
import com.cyrilmottier.polaris.PolarisMapView;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;

import android.support.v4.app.ListFragment;

import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;
import com.slidingmenu.lib.app.SlidingMapActivity;

import net.simonvt.widget.MenuDrawer;
import net.simonvt.widget.MenuDrawerManager;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

public class WindowSample extends SlidingMapActivity implements View.OnClickListener {

    private static final String STATE_MENUDRAWER = "net.simonvt.menudrawer.samples.WindowSample.menuDrawer";
    private static final String STATE_ACTIVE_VIEW_ID = "net.simonvt.menudrawer.samples.WindowSample.activeViewId";

    private MenuDrawerManager mMenuDrawer;
    private TextView mContentTextView;
    private PolarisMapView mMapView;

    private int mActiveViewId;
    protected SherlockListFragment mFrag;

    @TargetApi(11)
	@Override
	
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.info);

    	//public void onCreate(Bundle inState) {
        //super.onCreate(inState);
       // setContentView(R.layout.info);
        //if (inState != null) {
        //    mActiveViewId = inState.getInt(STATE_ACTIVE_VIEW_ID);
        //}
			// set the Behind View
			setBehindContentView(R.layout.menu_frame);
			android.app.FragmentTransaction t = this.getFragmentManager().beginTransaction();
			mFrag = new SherlockListFragment();
			//t.replace(R.id.menu_frame, mFrag);
			t.commit();

        mMenuDrawer = new MenuDrawerManager(this, MenuDrawer.MENU_DRAG_WINDOW);
        //mMenuDrawer.setContentView(R.layout.activity_windowsample);
        mMenuDrawer.setMenuView(R.layout.menu_scrollview);

        MenuScrollView msv = (MenuScrollView) mMenuDrawer.getMenuView();
        msv.setOnScrollChangedListener(new MenuScrollView.OnScrollChangedListener() {
            public void onScrollChanged() {
                mMenuDrawer.getMenuDrawer().invalidate();
            }
        });

        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
       //     getActionBar().setDisplayHomeAsUpEnabled(true);
        //    getActionBar().setDisplayShowTitleEnabled(false);
        //}
        
        SlidingMenu sm = getSlidingMenu();
        sm.setMenu(R.layout.hos_map);
		//sm.setShadowWidthRes(R.dimen.shadow_width);
		//sm.setShadowDrawable(R.drawable.shadow);
		//sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		sm.setMode(SlidingMenu.RIGHT);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setFadeEnabled(true);
		sm.setFadeDegree(0.99f);
		
		mMapView = (PolarisMapView) findViewById(R.id.mapview);
        mMapView.setUserTrackingButtonEnabled(true);
        mMapView.setSatellite(true);
        MapController mapController = mMapView.getController();
		mapController.animateTo(new GeoPoint(37235407, -76646019));
		mMapView.invalidate();
		mapController.setZoom(19);

        mContentTextView = (TextView) findViewById(R.id.contentText);

        findViewById(R.id.item1).setOnClickListener(this);
        findViewById(R.id.item2).setOnClickListener(this);
        findViewById(R.id.item3).setOnClickListener(this);
        findViewById(R.id.item4).setOnClickListener(this);
        findViewById(R.id.item5).setOnClickListener(this);
        findViewById(R.id.item6).setOnClickListener(this);
        findViewById(R.id.item7).setOnClickListener(this);
        findViewById(R.id.item8).setOnClickListener(this);
        findViewById(R.id.item9).setOnClickListener(this);
        findViewById(R.id.item10).setOnClickListener(this);
        findViewById(R.id.item11).setOnClickListener(this);
        findViewById(R.id.item12).setOnClickListener(this);
        findViewById(R.id.item13).setOnClickListener(this);
        findViewById(R.id.item14).setOnClickListener(this);

        TextView activeView = (TextView) findViewById(mActiveViewId);
        if (activeView != null) {
            mMenuDrawer.setActiveView(activeView);
            mContentTextView.setText("Active item: " + activeView.getText());
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        mMenuDrawer.onRestoreDrawerState(inState.getParcelable(STATE_MENUDRAWER));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(STATE_MENUDRAWER, mMenuDrawer.onSaveDrawerState());
        outState.putInt(STATE_ACTIVE_VIEW_ID, mActiveViewId);
    }

    
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mMenuDrawer.toggleMenu();
                return true;
        }
        	//return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mMenuDrawer.isMenuVisible()) {
            mMenuDrawer.closeMenu();
            return;
        }

        super.onBackPressed();
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
		case R.id.item5: Intent mapActivity = new Intent(this, MapScreen.class);
			startActivity(mapActivity);
			break;
		case R.id.item6: Intent hhActivity = new Intent(this, HOS_Houses.class);
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
			break;
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
        mMenuDrawer.setActiveView(v);
        //mContentTextView.setText("Active item: " + ((TextView) v).getText());
        mMenuDrawer.closeMenu();
        //mActiveViewId = v.getId();
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
