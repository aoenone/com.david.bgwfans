package com.david.bgwfanspaid.xmas.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.david.bgwfanspaid.R;
import com.david.bgwfanspaid.viewcomponents.XmasItem;
import com.david.bgwfanspaid.xmas.HolidayHills;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.EasyTracker;

/**
 * Created by david.hodge on 11/10/13.
 */
public class XmasAttractions extends RoboSherlockFragment {
    View view;
    XmasItem holidayHills;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.xmas_attractions, container, false);

        holidayHills = (XmasItem) view.findViewById(R.id.holiday_hills);
        holidayHills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), HolidayHills.class));
            }
        });

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
