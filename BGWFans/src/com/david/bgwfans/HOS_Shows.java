package com.david.bgwfans;


import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import net.simonvt.widget.MenuDrawerManager;

public class HOS_Shows extends BaseActivity implements View.OnClickListener{
	
	private MenuDrawerManager mMenuDrawer;
	private static final String STATE_MENUDRAWER = "net.simonvt.menudrawer.samples.WindowSample.menuDrawer";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hos_shows);

		
		ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
		actionbar.setListNavigationCallbacks(null, null);
        actionbar.setDisplayHomeAsUpEnabled(true);
        createNavigation();

}
	
	private void createNavigation() {
		// TODO Auto-generated method stub
		
	}
}
