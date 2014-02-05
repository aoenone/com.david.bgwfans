package com.david.bgtfans.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdLayout;
import com.amazon.device.ads.AdListener;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.AdTargetingOptions;
import com.crittercism.app.Crittercism;
import com.david.bgtfans.R;
import com.david.bgtfans.attractions.flats.Rapids;
import com.david.bgtfans.attractions.water.Flume;
import com.david.bgtfans.attractions.water.Pompeii;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.Tracker;

public class TabThree extends RoboSherlockFragment {

    AdLayout adLayout;
    AdTargetingOptions adTargetingOptions;
    LinearLayout adFail;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.water, container, false);

        RelativeLayout rapidsBTN = (RelativeLayout) view.findViewById(R.id.roman_button);
        RelativeLayout pompeiiBTN = (RelativeLayout) view.findViewById(R.id.pompeii_button);
        RelativeLayout flumeBTN = (RelativeLayout) view.findViewById(R.id.flume_button);

        rapidsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rapids = new Intent(getSherlockActivity(), Rapids.class);
                getSherlockActivity().startActivity(rapids);
            }
        });

        pompeiiBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pompeii = new Intent(getSherlockActivity(), Pompeii.class);
                getSherlockActivity().startActivity(pompeii);
            }
        });

        flumeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent flume = new Intent(getSherlockActivity(), Flume.class);
                getSherlockActivity().startActivity(flume);
            }
        });

        final Runnable mRunnable;
        final Handler mHandler=new Handler();
        mRunnable=new Runnable() {

            @Override
            public void run() {
                adLayout.loadAd(adTargetingOptions);
            }
        };

        adFail = (LinearLayout) view.findViewById(R.id.ad_fail_view);
        adFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goProIntent();
            }
        });

        try {
//            AdRegistration.enableTesting(true);
            AdRegistration.setAppKey("9dc03c16047340d88ed5e306f717b2ac");
        } catch (Exception e) {
            Crittercism.logHandledException(e);
        }

        adLayout = (AdLayout) view.findViewById(R.id.ad_view);
        adTargetingOptions = new AdTargetingOptions();
        adLayout.loadAd(adTargetingOptions);
        adLayout.setListener(new AdListener() {
            @Override
            public void onAdLoaded(AdLayout adLayout, AdProperties adProperties) {
                adFail.setVisibility(View.GONE);
            }

            @Override
            public void onAdExpanded(AdLayout adLayout) {
                //
            }

            @Override
            public void onAdCollapsed(AdLayout adLayout) {
                //
            }

            @Override
            public void onAdFailedToLoad(AdLayout adLayout, AdError adError) {
                adFail.setVisibility(View.VISIBLE);
                mHandler.postDelayed(mRunnable,10*1000);
                Log.d("aderror", adError.getMessage());
            }
        });

        return view;
    }

    private void goProIntent(){
        Tracker tracker = EasyTracker.getTracker();
        tracker.sendEvent("go_pro", "go_pro_clicked", "user_go_pro", null);
        String url = "https://play.google.com/store/apps/details?id=com.david.bgwfanspaid";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

}
