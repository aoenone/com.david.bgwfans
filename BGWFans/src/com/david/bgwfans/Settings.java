package com.david.bgwfans;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;

public class Settings extends SideMenuActivity{

	public static final Intent ACTION_LOCATION_SOURCE_SETTINGS = null;

	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_screen);
		
		ActionBar actionbar = getActionBar();
	    actionbar.setDisplayShowTitleEnabled(false);
		actionbar.setListNavigationCallbacks(null, null);
	    actionbar.setDisplayHomeAsUpEnabled(true);
	    
		}
}
