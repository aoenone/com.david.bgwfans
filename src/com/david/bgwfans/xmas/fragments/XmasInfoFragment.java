package com.david.bgwfans.xmas.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
