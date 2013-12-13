package com.david.bgwfans.xmas.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.david.bgwfans.R;
import com.david.bgwfans.viewcomponents.XmasItem;
import com.david.bgwfans.xmas.shows.DeckTheHalls;
import com.david.bgwfans.xmas.shows.Gloria;
import com.david.bgwfans.xmas.shows.Miracles;
import com.david.bgwfans.xmas.shows.Otann;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.EasyTracker;

/**
 * Created by david.hodge on 11/10/13.
 */
public class XmasShows extends RoboSherlockFragment {

    View view;
    XmasItem deckTheHalls;
    XmasItem gloria;
    XmasItem miracles;
    XmasItem oTann;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.xmas_shows, container, false);

        deckTheHalls = (XmasItem) view.findViewById(R.id.deck_the_halls_btn);
        gloria = (XmasItem) view.findViewById(R.id.gloria_btn);
        miracles = (XmasItem) view.findViewById(R.id.miracles_btn);
        oTann = (XmasItem) view.findViewById(R.id.o_tann_btn);

        setUpOnClicks();

        return view;
    }

    private void setUpOnClicks(){
        deckTheHalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), DeckTheHalls.class));
            }
        });

        gloria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), Gloria.class));
            }
        });

        miracles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), Miracles.class));
            }
        });

        oTann.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), Otann.class));
            }
        });
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
