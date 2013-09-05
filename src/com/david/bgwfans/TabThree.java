package com.david.bgwfans;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;

public class TabThree extends RoboSherlockFragment {

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

        return view;
    }

}
