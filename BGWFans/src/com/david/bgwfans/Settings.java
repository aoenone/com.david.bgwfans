package com.david.bgwfans;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Settings extends SideMenuActivity{

	public static final Intent ACTION_LOCATION_SOURCE_SETTINGS = null;
	private AdView adView;
    String adMobId = "a151350c50621fc";
    
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_screen);
		
		LinearLayout layout = (LinearLayout)findViewById(R.id.settingslayout);
		RelativeLayout.LayoutParams lay = new RelativeLayout.LayoutParams(
        	    RelativeLayout.LayoutParams.MATCH_PARENT, 
        	    RelativeLayout.LayoutParams.MATCH_PARENT);
        lay.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        adView = new AdView(this, AdSize.BANNER, adMobId);
        layout.addView(adView, lay);
        adView.setGravity(Gravity.BOTTOM);
        adView.loadAd(new AdRequest());
        
		ActionBar actionbar = getActionBar();
	    actionbar.setDisplayShowTitleEnabled(false);
		actionbar.setListNavigationCallbacks(null, null);
	    actionbar.setDisplayHomeAsUpEnabled(true);
	    
		}
}
