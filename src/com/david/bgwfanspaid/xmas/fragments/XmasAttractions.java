package com.david.bgwfanspaid.xmas.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.david.bgwfanspaid.R;
import com.david.bgwfanspaid.viewcomponents.XmasItem;
import com.david.bgwfanspaid.xmas.attractions.HighlandStables;
import com.david.bgwfanspaid.xmas.attractions.HolidayHills;
import com.david.bgwfanspaid.xmas.attractions.IcePalace;
import com.david.bgwfanspaid.xmas.attractions.MistletoeMarketplace;
import com.david.bgwfanspaid.xmas.attractions.PolarPathway;
import com.david.bgwfanspaid.xmas.attractions.SantaWorkshop;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.EasyTracker;

/**
 * Created by david.hodge on 11/10/13.
 */
public class XmasAttractions extends RoboSherlockFragment {

    View view;
    XmasItem mistletoeMarketplace;
    XmasItem holidayHills;
    XmasItem polarPathway;
    XmasItem highlandStables;
    XmasItem icePalace;
    XmasItem santaWorkshop;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.xmas_attractions, container, false);

        mistletoeMarketplace = (XmasItem) view.findViewById(R.id.mistletoe_marketplace);
        holidayHills = (XmasItem) view.findViewById(R.id.holiday_hills);
        polarPathway = (XmasItem) view.findViewById(R.id.polar_pathway);
        highlandStables = (XmasItem) view.findViewById(R.id.highland_stables);
        icePalace = (XmasItem) view.findViewById(R.id.ice_palace);
        santaWorkshop = (XmasItem) view.findViewById(R.id.santa_workshop);

        setUpOnClicks();
        return view;
    }

    private void setUpOnClicks(){

        mistletoeMarketplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), MistletoeMarketplace.class));
            }
        });

        holidayHills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), HolidayHills.class));
            }
        });

        polarPathway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), PolarPathway.class));
            }
        });

        highlandStables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), HighlandStables.class));
            }
        });

        icePalace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), IcePalace.class));
            }
        });

        santaWorkshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), SantaWorkshop.class));
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
