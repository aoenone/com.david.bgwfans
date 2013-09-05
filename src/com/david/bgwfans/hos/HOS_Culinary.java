package com.david.bgwfans.hos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.david.bgwfans.AttractionItem;
import com.david.bgwfans.R;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.EasyTracker;

/**
 * Created with IntelliJ IDEA.
 * User: david.hodge
 * Date: 8/18/13
 * Time: 12:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class HOS_Culinary extends RoboSherlockFragment {

    View view;
    AttractionItem bloodBanq;
    AttractionItem bucGallery;
    AttractionItem frightFeast;
    AttractionItem demonDrinks;
    AttractionItem pirateBar;
    AttractionItem inocStation;
    AttractionItem openCasket;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.hos_culinary, container, false);

        bloodBanq = (AttractionItem) view.findViewById(R.id.hos_blood_banquet);
        bucGallery = (AttractionItem) view.findViewById(R.id.hos_buccaneer_gallery);
        frightFeast = (AttractionItem) view.findViewById(R.id.hos_fright_feast);
        demonDrinks = (AttractionItem) view.findViewById(R.id.hos_demon_drinks);
        pirateBar = (AttractionItem) view.findViewById(R.id.hos_pirate_bar);
        inocStation = (AttractionItem) view.findViewById(R.id.hos_inoc_stat);
        openCasket = (AttractionItem) view.findViewById(R.id.hos_open_cask);

        bloodBanq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bloodIntent = new Intent(getActivity(), hosBlood.class);
                startActivity(bloodIntent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        bucGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bucIntent = new Intent(getActivity(), hosGallery.class);
                startActivity(bucIntent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        frightFeast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent frightIntent = new Intent(getActivity(), hosFright.class);
                startActivity(frightIntent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        demonDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent demonIntent = new Intent(getActivity(), hosDemonDrinks.class);
                startActivity(demonIntent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        pirateBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pBarIntent = new Intent(getActivity(), hosPbar.class);
                startActivity(pBarIntent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        inocStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inocIntent = new Intent(getActivity(), hosInoc.class);
                startActivity(inocIntent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        openCasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent casketIntent = new Intent(getActivity(), hosCasket.class);
                startActivity(casketIntent);
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
