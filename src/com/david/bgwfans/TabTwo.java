package com.david.bgwfans;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;

public class TabTwo extends RoboSherlockFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.flats, container, false);

        RelativeLayout dkBTN = (RelativeLayout) view.findViewById(R.id.dark_button);
        RelativeLayout mtBTN = (RelativeLayout) view.findViewById(R.id.mach_button);
        RelativeLayout autoBTN = (RelativeLayout) view.findViewById(R.id.autobahn_button);
        RelativeLayout cradleBTN = (RelativeLayout) view.findViewById(R.id.cradle_button);
        RelativeLayout fmBTN = (RelativeLayout) view.findViewById(R.id.flying_machine_button);
        RelativeLayout werbelwindBTN = (RelativeLayout) view.findViewById(R.id.wirbelwind_button);
        RelativeLayout tradewindBTN = (RelativeLayout) view.findViewById(R.id.tradewind_button);
        RelativeLayout catapultBTN = (RelativeLayout) view.findViewById(R.id.catapult_button);
        RelativeLayout delightBTN = (RelativeLayout) view.findViewById(R.id.delight_button);
        RelativeLayout ramBTN = (RelativeLayout) view.findViewById(R.id.ram_button);

        dkBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dk = new Intent(getSherlockActivity(), DarKastle.class);
                getSherlockActivity().startActivity(dk);
            }
        });

        mtBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mt = new Intent(getSherlockActivity(), Mach.class);
                getSherlockActivity().startActivity(mt);
            }
        });

        autoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent auto = new Intent(getSherlockActivity(), AutoBahn.class);
                getSherlockActivity().startActivity(auto);
            }
        });

        cradleBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cradle = new Intent(getSherlockActivity(), Cradle.class);
                getSherlockActivity().startActivity(cradle);
            }
        });

        fmBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fm = new Intent(getSherlockActivity(), FlyingMachine.class);
                getSherlockActivity().startActivity(fm);
            }
        });

        werbelwindBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ww = new Intent(getSherlockActivity(), Wirbelwind.class);
                getSherlockActivity().startActivity(ww);
            }
        });

        tradewindBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tw =  new Intent(getSherlockActivity(), TradeWind.class);
                getSherlockActivity().startActivity(tw);
            }
        });

        catapultBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent catapult = new Intent(getSherlockActivity(), Catapult.class);
                getSherlockActivity().startActivity(catapult);
            }
        });

        delightBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent delight = new Intent(getSherlockActivity(), Delight.class);
                getSherlockActivity().startActivity(delight);
            }
        });

        ramBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ram = new Intent(getSherlockActivity(), Ram.class);
                getSherlockActivity().startActivity(ram);
            }
        });

        return view;
    }

}
