package com.david.bgtfans.hos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.david.bgtfans.viewcomponents.AttractionItem;
import com.david.bgtfans.R;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

/**
 * Created with IntelliJ IDEA.
 * User: david.hodge
 * Date: 8/12/13
 * Time: 9:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class HosShows extends RoboSherlockFragment {

    View view;
    private Tracker mGaTracker;
    private GoogleAnalytics mGaInstance;

    AttractionItem digItUp;
    AttractionItem fiends;
    AttractionItem nightBeats;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.hos_shows_2013, container, false);

        digItUp = (AttractionItem) view.findViewById(R.id.hos_dig_it);
        fiends = (AttractionItem) view.findViewById(R.id.hos_fiends);
        nightBeats = (AttractionItem) view.findViewById(R.id.hos_nightbeats);

        digItUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent digIntent = new Intent(getActivity().getBaseContext(), hosDig.class);
                startActivity(digIntent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        fiends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fiendsIntent = new Intent(getActivity().getBaseContext(), hosFiends.class);
                startActivity(fiendsIntent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        nightBeats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nightIntent = new Intent(getActivity().getBaseContext(), hosNightBeats.class);
                startActivity(nightIntent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        mGaInstance = GoogleAnalytics.getInstance(getActivity());
        mGaTracker = mGaInstance.getTracker("UA-39204043-1");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EasyTracker.getInstance().activityStart(getActivity()); // Add this method.
    }

    @Override
    public void onStop() {
        super.onStop();
        EasyTracker.getInstance().activityStop(getActivity()); // Add this method.
    }
}
