package com.david.bgtfans.xmas.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.david.bgtfans.R;
import com.david.bgtfans.viewcomponents.XmasItem;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.EasyTracker;

/**
 * Created by david.hodge on 11/10/13.
 */
public class XmasFood extends RoboSherlockFragment {

    View view;
    XmasItem cocoaCafe;
    XmasItem dasherDiner;
    XmasItem trapperSmokehouse;
    XmasItem frostBites;
    XmasItem dellaPiazza;
    XmasItem gingerbreadHaus;
    XmasItem tannTreats;
    XmasItem dasFesthaus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.xmas_food, container, false);

        cocoaCafe = (XmasItem) view.findViewById(R.id.cocoa_cafe_btn);
        dasherDiner = (XmasItem) view.findViewById(R.id.trapper_smokehouse_btn);
        trapperSmokehouse = (XmasItem) view.findViewById(R.id.trapper_smokehouse_btn);
        frostBites = (XmasItem) view.findViewById(R.id.frost_bites_btn);
        gingerbreadHaus = (XmasItem) view.findViewById(R.id.gingerbread_haus_btn);
        tannTreats = (XmasItem) view.findViewById(R.id.tann_treats_btn);
        dasFesthaus = (XmasItem) view.findViewById(R.id.das_feathaus_btn);

        setUpOnClicks();

        return view;
    }

    private void setUpOnClicks(){

        cocoaCafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });

        dasherDiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        trapperSmokehouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });

        frostBites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });

        gingerbreadHaus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });

        tannTreats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });

        dasFesthaus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
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
