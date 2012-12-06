package com.david.bgwfans;

import android.app.ActionBar;
import android.os.Bundle;

public class About extends WindowSample{
		
	
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.about_screen);
	
	ActionBar actionbar = getActionBar();
    actionbar.setDisplayShowTitleEnabled(false);
	actionbar.setListNavigationCallbacks(null, null);
    actionbar.setDisplayHomeAsUpEnabled(true);
    
	}
}
