package com.david.bgwfans;


import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import net.simonvt.widget.MenuDrawerManager;

public class HOS_Deadline extends BaseActivity implements View.OnClickListener{
	
	private MenuDrawerManager mMenuDrawer;
	private static final String STATE_MENUDRAWER = "net.simonvt.menudrawer.samples.WindowSample.menuDrawer";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hos_deadline);

		
		ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
		actionbar.setListNavigationCallbacks(null, null);
        actionbar.setDisplayHomeAsUpEnabled(true);
        createNavigation();
        
        //Button b1 = (Button) findViewById(R.id.pretzel);
        //b1.setOnClickListener(this);

}
	
	private void createNavigation() {
		// TODO Auto-generated method stub
		
	}
}

