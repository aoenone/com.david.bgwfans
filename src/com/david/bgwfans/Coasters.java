package com.david.bgwfans;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;

public class Coasters extends RoboSherlockFragment{

    private ScrollView scrollview;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.coasters, container, false);

        scrollview = (ScrollView) view.findViewById(R.id.scroll);

        scrollview.setDrawingCacheEnabled(true);

       /** RelativeLayout b1 = (RelativeLayout) findViewById(R.id.vbolt);
        b1.setOnClickListener(this);

        RelativeLayout b2 = (RelativeLayout) findViewById(R.id.griffon);
        b2.setOnClickListener(this);

        RelativeLayout b3 = (RelativeLayout) findViewById(R.id.apollo);
        b3.setOnClickListener(this);

        RelativeLayout b4 = (RelativeLayout) findViewById(R.id.alpen);
        b4.setOnClickListener(this);

        RelativeLayout b5 = (RelativeLayout) findViewById(R.id.lochness);
        b5.setOnClickListener(this);

        RelativeLayout b6 = (RelativeLayout) findViewById(R.id.grover);
        b6.setOnClickListener(this);     **/
        return view;
    }


}
