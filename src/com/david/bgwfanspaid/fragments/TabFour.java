package com.david.bgwfanspaid.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.david.bgwfanspaid.R;
import com.david.bgwfanspaid.attractions.additional.Train;
import com.david.bgwfanspaid.attractions.additional.Cruise;
import com.david.bgwfanspaid.attractions.additional.Skyride;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;

public class TabFour extends RoboSherlockFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.additional, container, false);

        RelativeLayout steamBTN = (RelativeLayout) view.findViewById(R.id.steam_button);
        RelativeLayout skyrideBTN = (RelativeLayout) view.findViewById(R.id.skyride_button);
        RelativeLayout cruiseBTN = (RelativeLayout) view.findViewById(R.id.cruise_button);

        steamBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trains = new Intent(getSherlockActivity(), Train.class);
                getSherlockActivity().startActivity(trains);
            }
        });

        skyrideBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skyride = new Intent(getSherlockActivity(), Skyride.class);
                getSherlockActivity().startActivity(skyride);
            }
        });

        cruiseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cruise = new Intent(getSherlockActivity(), Cruise.class);
                getSherlockActivity().startActivity(cruise);
            }
        });


        return view;
    }

}
