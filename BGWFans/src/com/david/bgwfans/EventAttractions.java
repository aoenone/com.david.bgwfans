package com.david.bgwfans;

import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class EventAttractions extends SideMenuActivity implements View.OnClickListener {
    private Tracker mGaTracker;
    private GoogleAnalytics mGaInstance;

    public void Austria(View view) {
        Intent austriaActivity = new Intent(this, Austria.class);
        startActivity(austriaActivity);
    }

    public void Canada(View view) {
        Intent canadaActivity = new Intent(this, Canada.class);
        startActivity(canadaActivity);
    }

    public void France(View view) {
        Intent franceActivity = new Intent(this, France.class);
        startActivity(franceActivity);
    }

    public void Germany(View view) {
        Intent germanyActivity = new Intent(this, Germany.class);
        startActivity(germanyActivity);
    }
    
    public void Greece(View view) {
        Intent greeceActivity = new Intent(this, Greece.class);
        startActivity(greeceActivity);
    }
    
    public void Italy(View view) {
        Intent italyActivity = new Intent(this, Italy.class);
        startActivity(italyActivity);
    }
    
    public void Scandinavia(View view){
    	Intent scandinaviaAcitvity = new Intent(this, Scandinavia.class);
    	startActivity(scandinaviaAcitvity);
    }
    
    public void Scotland(View view){
    	Intent scotlandAcitvity = new Intent(this, Scotland.class);
    	startActivity(scotlandAcitvity);
    }
    
    public void Spain(View view){
    	Intent spainActivity = new Intent(this, Spain.class);
    	startActivity(spainActivity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventattractions);

        mGaInstance = GoogleAnalytics.getInstance(this);
        mGaTracker = mGaInstance.getTracker("UA-39204043-1");
    }
}
