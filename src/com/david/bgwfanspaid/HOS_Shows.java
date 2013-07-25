package com.david.bgwfanspaid;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.hos_shows, container, false);

        fyreBtn = (RelativeLayout) view.findViewById(R.id.fyre_btn);
        mixBTN = (RelativeLayout) view.findViewById(R.id.mix_button);
        petsBTN = (RelativeLayout) view.findViewById(R.id.pets_button);
        entwinedBTN = (RelativeLayout) view.findViewById(R.id.ent_button);

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


        mGaInstance = GoogleAnalytics.getInstance(getActivity());
        mGaTracker = mGaInstance.getTracker("UA-39204043-1");

        return view;
    }
}
