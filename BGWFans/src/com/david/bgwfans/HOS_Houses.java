package com.david.bgwfans;


import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import net.simonvt.widget.MenuDrawerManager;

public class HOS_Houses extends BaseActivity implements View.OnClickListener{
	
	private MenuDrawerManager mMenuDrawer;
	private static final String STATE_MENUDRAWER = "net.simonvt.menudrawer.samples.WindowSample.menuDrawer";
	RelativeLayout b1;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hos_houses);

		
		ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
		actionbar.setListNavigationCallbacks(null, null);
        actionbar.setDisplayHomeAsUpEnabled(true);
        createNavigation();
        
        //RelativeLayout b1 = (RelativeLayout) findViewById(R.id.mistletoeMarket);
        //b1.setOnClickListener(this);
}
	
	public void Mistletoe(View view){
		Intent mistletoeActivity = new Intent(this, Mistletoe.class);
		startActivity(mistletoeActivity);
	}
	
	public void Polar(View view){
		Intent polarActivity = new Intent(this, Polar.class);
		startActivity(polarActivity);
	}
	public void Palace(View view){
		Intent palaceActivity = new Intent(this, Palace.class);
		startActivity(palaceActivity);
	}
	
	private void createNavigation() {
		// TODO Auto-generated method stub
		
	}
}

