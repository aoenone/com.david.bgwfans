package com.david.bgwfans;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class Coasters extends BaseActivity implements OnClickListener{
	
	private ScrollView scrollview;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.coasters);

		
		ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
		actionbar.setListNavigationCallbacks(null, null);
        actionbar.setDisplayHomeAsUpEnabled(true);
        
        ScrollView scrollview = (ScrollView) findViewById(R.id.scroll);
        
        scrollview.setDrawingCacheEnabled(false);
        
        RelativeLayout b1 = (RelativeLayout) findViewById(R.id.vbolt);
        b1.setOnClickListener(this);
        
        RelativeLayout b2 = (RelativeLayout) findViewById(R.id.griffon);
        b2.setOnClickListener(this);
        
        RelativeLayout b3 = (RelativeLayout) findViewById(R.id.apollo);
        b3.setOnClickListener(this);
        
        RelativeLayout b4 = (RelativeLayout) findViewById(R.id.alpen);
        b4.setOnClickListener(this);
        
        RelativeLayout b5 = (RelativeLayout) findViewById(R.id.lochness);
        b5.setOnClickListener(this);
        
        RelativeLayout b6 = (RelativeLayout) findViewById(R.id.grover);
        b6.setOnClickListener(this);
}
	
    
}
