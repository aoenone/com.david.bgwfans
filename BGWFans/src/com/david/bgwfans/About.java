package com.david.bgwfans;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class About extends SideMenuActivity implements OnClickListener{
		
	private AdView adView;
    String adMobId = "a151350c50621fc";

	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.about_screen);
	
	LinearLayout layout = (LinearLayout)findViewById(R.id.aboutlayout);
	RelativeLayout.LayoutParams lay = new RelativeLayout.LayoutParams(
    	    RelativeLayout.LayoutParams.MATCH_PARENT, 
    	    RelativeLayout.LayoutParams.MATCH_PARENT);
    lay.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
    adView = new AdView(this, AdSize.SMART_BANNER, adMobId);
    layout.addView(adView, lay);
    adView.setGravity(Gravity.BOTTOM);
    adView.loadAd(new AdRequest());
    
	}
	
	@Override
    public void onDestroy() {
      if (adView != null) {
        adView.destroy();
      }
      super.onDestroy();
    }
}
