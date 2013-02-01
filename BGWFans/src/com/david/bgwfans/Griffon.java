package com.david.bgwfans;

import android.app.ActionBar;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Griffon extends SideMenuActivity implements View.OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.verbolten);
	
	ActionBar actionbar = getActionBar();
    actionbar.setDisplayShowTitleEnabled(false);
	actionbar.setListNavigationCallbacks(null, null);
    actionbar.setDisplayHomeAsUpEnabled(true);
    createNavigation();
    
    Typeface rt = Typeface.createFromAsset(getAssets(),
            "fonts/Roboto-Thin.ttf");
    TextView attr = (TextView) findViewById(R.id.attr);
    //TextView wiki = (TextView) findViewById(R.id.wiki);
    attr.setTypeface(rt);
    //wiki.setTypeface(rt);
    
}

	private void createNavigation() {
		// TODO Auto-generated method stub
		
	}
}