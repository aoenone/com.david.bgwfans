package com.david.bgwfans;


import android.content.Intent;
import android.os.Bundle;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;


public class Settings extends SideMenuActivity {

    public static final Intent ACTION_LOCATION_SOURCE_SETTINGS = null;
    private Tracker mGaTracker;
    private GoogleAnalytics mGaInstance;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_screen);

        mGaInstance = GoogleAnalytics.getInstance(this);
        mGaTracker = mGaInstance.getTracker("UA-39204043-1");

    }
}
