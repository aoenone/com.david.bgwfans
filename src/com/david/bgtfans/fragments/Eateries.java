package com.david.bgtfans.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.david.bgtfans.eateries.Pub;
import com.david.bgtfans.R;
import com.david.bgtfans.eateries.Smokehouse;
import com.david.bgtfans.eateries.Bier;
import com.david.bgtfans.eateries.Cucina;
import com.david.bgtfans.eateries.Festhaus;
import com.david.bgtfans.eateries.Grill;
import com.david.bgtfans.eateries.Grille;
import com.david.bgtfans.eateries.Piazza;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;


public class Eateries extends RoboSherlockFragment {
    private Tracker mGaTracker;
    private GoogleAnalytics mGaInstance;
    View view;
    RelativeLayout festBTN;
    RelativeLayout smokeBTN;
    RelativeLayout piazzaBTN;
    RelativeLayout grilleBTN;
    RelativeLayout cucinaBTN;
    RelativeLayout pubBTN;
    RelativeLayout grillBTN;
    RelativeLayout bierBTN;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.park_eateries, container, false);

        festBTN = (RelativeLayout) view.findViewById(R.id.festhaus_button);
        smokeBTN = (RelativeLayout) view.findViewById(R.id.smokehouse_button);
        piazzaBTN = (RelativeLayout) view.findViewById(R.id.piazza_button);
        grilleBTN = (RelativeLayout) view.findViewById(R.id.grille_button);
        cucinaBTN = (RelativeLayout) view.findViewById(R.id.cucina_button);
        pubBTN = (RelativeLayout) view.findViewById(R.id.pub_button);
        grillBTN = (RelativeLayout) view.findViewById(R.id.grill_button);
        bierBTN =  (RelativeLayout) view.findViewById(R.id.bier_button);

        festBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fest = new Intent(getSherlockActivity(), Festhaus.class);
                getSherlockActivity().startActivity(fest);
            }
        });

        smokeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smoke  = new Intent(getSherlockActivity(), Smokehouse.class);
                getSherlockActivity().startActivity(smoke);
            }
        });

        piazzaBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent piazza = new Intent(getSherlockActivity(), Piazza.class);
                getSherlockActivity().startActivity(piazza);
            }
        });

        grilleBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent grille = new Intent(getSherlockActivity(), Grille.class);
                getSherlockActivity().startActivity(grille);
            }
        });

        cucinaBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cucina = new Intent(getSherlockActivity(), Cucina.class);
                getSherlockActivity().startActivity(cucina);
            }
        });

        pubBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pub = new Intent(getSherlockActivity(), Pub.class);
                getSherlockActivity().startActivity(pub);
            }
        });

        grillBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent grill = new Intent(getSherlockActivity(), Grill.class);
                getSherlockActivity().startActivity(grill);
            }
        });

        bierBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bier = new Intent(getSherlockActivity(), Bier.class);
                getSherlockActivity().startActivity(bier);
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
