package com.david.bgwfans.hos;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.david.bgwfans.R;
import com.david.bgwfans.shows.Celtic;
import com.david.bgwfans.shows.Entwined;
import com.david.bgwfans.shows.Mix;
import com.david.bgwfans.shows.Pets;
import com.david.bgwfans.shows.TIO;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;


public class HOS_Shows extends RoboSherlockFragment {

    private Tracker mGaTracker;
    private GoogleAnalytics mGaInstance;
    View view;
    RelativeLayout fyreBtn;
    RelativeLayout mixBTN;
    RelativeLayout petsBTN;
    RelativeLayout entwinedBTN;
    RelativeLayout oktBtn;
    RelativeLayout londonbtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.hos_shows, container, false);

        fyreBtn = (RelativeLayout) view.findViewById(R.id.fyre_btn);
        mixBTN = (RelativeLayout) view.findViewById(R.id.mix_button);
        petsBTN = (RelativeLayout) view.findViewById(R.id.pets_button);
        entwinedBTN = (RelativeLayout) view.findViewById(R.id.ent_button);
        oktBtn = (RelativeLayout) view.findViewById(R.id.okt_button);
        londonbtn = (RelativeLayout) view.findViewById(R.id.london_button);

        fyreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent celticActivity = new Intent(getSherlockActivity(), Celtic.class);
                getSherlockActivity().startActivity(celticActivity);
            }
        });

        mixBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mixActivity = new Intent(getSherlockActivity(), Mix.class);
                getSherlockActivity().startActivity(mixActivity);
            }
        });

        petsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent petsActivity = new Intent(getSherlockActivity(), Pets.class);
                getSherlockActivity().startActivity(petsActivity);
            }
        });

        entwinedBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entwinedActivity = new Intent(getSherlockActivity(), Entwined.class);
                getSherlockActivity().startActivity(entwinedActivity);
            }
        });

        oktBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    getSherlockActivity().startActivity(new Intent(getSherlockActivity(), TIO.class));
            }
        });

        londonbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getSherlockActivity(), "Coming Soon!", Toast.LENGTH_LONG).show();
//                getSherlockActivity().startActivity(new Intent(getSherlockActivity(), London.class));
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
