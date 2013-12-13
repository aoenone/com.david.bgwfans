package com.david.bgwfans.xmas.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdLayout;
import com.amazon.device.ads.AdListener;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.AdTargetingOptions;
import com.crittercism.app.Crittercism;
import com.david.bgwfans.R;
import com.david.bgwfans.cards.XmasCard;
import com.david.bgwfans.xmas.cards.XmasAttrInfo;
import com.david.bgwfans.xmas.cards.XmasHourCard;
import com.fima.cardsui.views.CardUI;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

/**
 * Created by david.hodge on 11/10/13.
 */
public class XmasInfoFragment extends RoboSherlockFragment {

    private CardUI mCardView;
    private Tracker mGaTracker;
    private GoogleAnalytics mGaInstance;
    View view;
    AdLayout adLayout;
    AdTargetingOptions adTargetingOptions;
    LinearLayout adFail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.hos_info, container, false);

        mGaInstance = GoogleAnalytics.getInstance(getActivity());
        mGaTracker = mGaInstance.getTracker("UA-39204043-1");

        mCardView = (CardUI) view.findViewById(R.id.cardsview);
        mCardView.setSwipeable(false);

        mCardView.addCard(new XmasHourCard("ChristmasTown 2013"));
        mCardView.addCard(new XmasCard("ChristmasTown"));
        mCardView.addCard(new XmasAttrInfo("Attraction Info"));
        mCardView.refresh();

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
        String url = "https://play.google.com/store/apps/details?id=com.david.bgwfanspro";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
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
