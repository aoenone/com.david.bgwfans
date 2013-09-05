package com.david.bgwfans.hos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.david.bgwfans.AttractionItem;
import com.david.bgwfans.R;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.ads.util.i;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

/**
 * Created with IntelliJ IDEA.
 * User: david.hodge
 * Date: 8/17/13
 * Time: 11:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class HOS_TERROR extends RoboSherlockFragment {

    private Tracker mGaTracker;
    private GoogleAnalytics mGaInstance;
    View view;
    AttractionItem ripperBtn;
    AttractionItem vampireBtn;
    AttractionItem demonBtn;
    AttractionItem portsBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.hos_terrortories, container, false);

        ripperBtn = (AttractionItem) view.findViewById(R.id.hos_ripper_row);
        vampireBtn = (AttractionItem) view.findViewById(R.id.hos_vampire_point);
        demonBtn = (AttractionItem) view.findViewById(R.id.hos_demon_street);
        portsBtn = (AttractionItem) view.findViewById(R.id.hos_ports_of_skull);

        ripperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ripperIntent = new Intent(getActivity().getBaseContext(), hosRipper.class);
                startActivity(ripperIntent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        vampireBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vampireIntent = new Intent(getActivity().getBaseContext(), hosVampire.class);
                startActivity(vampireIntent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        demonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent demonIntent = new Intent(getActivity().getBaseContext(), hosDemon.class);
                startActivity(demonIntent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        portsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent portsIntent = new Intent(getActivity().getBaseContext(), hosPorts.class);
                startActivity(portsIntent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
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
