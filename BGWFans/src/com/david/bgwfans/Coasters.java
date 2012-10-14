package com.david.bgwfans;

import com.actionbarsherlock.app.SherlockActivity;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Coasters extends SherlockActivity implements OnClickListener{
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.coasters);

		
		ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
		actionbar.setListNavigationCallbacks(null, null);
        actionbar.setDisplayHomeAsUpEnabled(true);
        
        Button b1 = (Button) findViewById(R.id.vbolt);
        b1.setOnClickListener(this);
        
        Button b2 = (Button) findViewById(R.id.griffon);
        b2.setOnClickListener(this);
        
        Button b3 = (Button) findViewById(R.id.apollo);
        b3.setOnClickListener(this);
        
        Button b4 = (Button) findViewById(R.id.alpen);
        b4.setOnClickListener(this);
        
        Button b5 = (Button) findViewById(R.id.lochness);
        b5.setOnClickListener(this);
        
        Button b6 = (Button) findViewById(R.id.grover);
        b6.setOnClickListener(this);
}
	
	
	public void onClick(View v) {
    	switch(v.getId()){
    	case R.id.vbolt: Intent vboltActivity = new Intent(this, Verbolten.class);
    		startActivity(vboltActivity);
    		break;
    	//case R.id.flats: Intent flatsActivity = new Intent(this, Flats.class);
		//	startActivity(flatsActivity);
		//	break;
    	//case R.id.water: Intent waterActivity = new Intent(this, Water.class);
		//	startActivity(waterActivity);
		//	break;
    	//case R.id.additional: Intent additionalActivity = new Intent(this, Additonal.class);
		//	startActivity(additionalActivity);
		//	break;
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
    }
}
