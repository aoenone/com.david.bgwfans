package com.david.bgwfanspaid;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

import android.content.Intent;

import android.os.Bundle;


public class Settings extends RoboSherlockFragment{

    public static final Intent ACTION_LOCATION_SOURCE_SETTINGS = null;
    private Tracker mGaTracker;
    private GoogleAnalytics mGaInstance;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.settings_screen, container, false);

        mGaInstance = GoogleAnalytics.getInstance(getSherlockActivity());
        mGaTracker = mGaInstance.getTracker("UA-39204043-1");
        return view;
    }
}