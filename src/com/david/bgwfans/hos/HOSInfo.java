package com.david.bgwfans.hos;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.david.bgwfans.HOSInfoCard;
import com.david.bgwfans.R;
import com.fima.cardsui.views.CardUI;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

/**
 * Created with IntelliJ IDEA.
 * User: david.hodge
 * Date: 8/10/13
 * Time: 11:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class HOSInfo extends RoboSherlockFragment {

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

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Light.ttf");

        mCardView = (CardUI) view.findViewById(R.id.cardsview);
        mCardView.setSwipeable(false);

        mCardView.addCard(new HOSInfoCard("Howl-O-Scream 2013"));

        mCardView.addCard(new HOSInfoCard2("Howl-O-Scream"));

        mCardView.addCard(new HosCardAge("Event Warning"));
//
//        mCardView.addCard(new HOSInfoCard("Testing 2"));
//
//        mCardView.addCard(new HOSInfoCard("Testing 3"));
//
//        mCardView.addCard(new HOSInfoCard("Testing 4"));

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
