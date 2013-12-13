package com.david.bgwfans.hos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.david.bgwfans.R;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;
import com.david.bgwfans.viewcomponents.AttractionItem;

/**
 * Created with IntelliJ IDEA.
 * User: david.hodge
 * Date: 8/11/13
 * Time: 1:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class HOSHouses extends RoboSherlockFragment {

    private Tracker mGaTracker;
    private GoogleAnalytics mGaInstance;
    View view;

    AttractionItem bitten;
    AttractionItem catacombs;
    AttractionItem cove;
    AttractionItem deadline;
    AttractionItem root;
    AttractionItem thirteen;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.hos_houses, container, false);

        mGaInstance = GoogleAnalytics.getInstance(getActivity());
        mGaTracker = mGaInstance.getTracker("UA-39204043-1");

        bitten = (AttractionItem) view.findViewById(R.id.hos_bitten);
        catacombs = (AttractionItem) view.findViewById(R.id.hos_catacombs);
        deadline = (AttractionItem) view.findViewById(R.id.hos_dead_line);
        root = (AttractionItem) view.findViewById(R.id.hos_root);
        thirteen = (AttractionItem) view.findViewById(R.id.hos_thirteen);
        cove = (AttractionItem) view.findViewById(R.id.hos_cove);

        bitten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bittenIntent = new Intent(getActivity().getBaseContext(), hosBitten.class);
                startActivity(bittenIntent);
            }
        });

        catacombs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent catacombsIntent = new Intent(getActivity().getBaseContext(), hosCatacombs.class);
                startActivity(catacombsIntent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        cove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent coveIntent = new Intent(getActivity().getBaseContext(), hosCove.class);
                startActivity(coveIntent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        deadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deadlineIntent = new Intent(getActivity().getBaseContext(), hosDeadLine.class);
                startActivity(deadlineIntent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rootIntent = new Intent(getActivity().getBaseContext(), hosRoot.class);
                startActivity(rootIntent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        thirteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thirteen = new Intent(getActivity().getBaseContext(), hosThirteen.class);
                startActivity(thirteen);
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
