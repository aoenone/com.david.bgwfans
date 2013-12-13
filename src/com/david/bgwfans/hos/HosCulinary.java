package com.david.bgwfans.hos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.david.bgwfans.viewcomponents.AttractionItem;
import com.david.bgwfans.R;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

/**
 * Created with IntelliJ IDEA.
 * User: david.hodge
 * Date: 8/15/13
 * Time: 8:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class HosCulinary extends RoboSherlockFragment {

    View view;
    private Tracker mGaTracker;
    private GoogleAnalytics mGaInstance;
    AttractionItem hosBlood;
    AttractionItem hosBucGalley;
    AttractionItem hosFrightFeast;
    AttractionItem hosDemonDrinks;
    AttractionItem hosPirateBar;
    AttractionItem hosInocStation;
    AttractionItem hosOpenCask;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.hos_shows_2013, container, false);

        hosBlood = (AttractionItem) view.findViewById(R.id.hos_blood_banquet);
        hosBucGalley = (AttractionItem) view.findViewById(R.id.hos_buccaneer_gallery);
        hosFrightFeast = (AttractionItem) view.findViewById(R.id.hos_fright_feast);
        hosDemonDrinks = (AttractionItem) view.findViewById(R.id.hos_demon_drinks);
        hosPirateBar = (AttractionItem) view.findViewById(R.id.hos_pirate_bar);
        hosInocStation = (AttractionItem) view.findViewById(R.id.hos_inoc_stat);
        hosOpenCask = (AttractionItem) view.findViewById(R.id.hos_open_cask);

        hosBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        hosBucGalley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        hosFrightFeast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        hosDemonDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        hosPirateBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        hosInocStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        hosOpenCask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To change body of implemented methods use File | Settings | File Templates.
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
