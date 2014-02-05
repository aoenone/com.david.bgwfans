package com.david.bgtfans.xmas.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.david.bgtfans.R;
import com.david.bgtfans.attractions.additional.Train;
import com.david.bgtfans.attractions.coasters.Verbolten;
import com.david.bgtfans.attractions.flats.AutoBahn;
import com.david.bgtfans.attractions.flats.Catapult;
import com.david.bgtfans.attractions.flats.Cradle;
import com.david.bgtfans.attractions.flats.Delight;
import com.david.bgtfans.attractions.flats.FlyingMachine;
import com.david.bgtfans.attractions.flats.Mach;
import com.david.bgtfans.attractions.flats.Ram;
import com.david.bgtfans.attractions.flats.TradeWind;
import com.david.bgtfans.attractions.flats.Wirbelwind;
import com.david.bgtfans.viewcomponents.XmasItem;
import com.david.bgtfans.xmas.attractions.HighlandStables;
import com.david.bgtfans.xmas.attractions.HolidayHills;
import com.david.bgtfans.xmas.attractions.IcePalace;
import com.david.bgtfans.xmas.attractions.MistletoeMarketplace;
import com.david.bgtfans.xmas.attractions.PolarPathway;
import com.david.bgtfans.xmas.attractions.SantaWorkshop;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.EasyTracker;

/**
 * Created by david.hodge on 11/10/13.
 */
public class XmasAttractions extends RoboSherlockFragment {

    View view;
    XmasItem mistletoeMarketplace;
    XmasItem holidayHills;
    XmasItem polarPathway;
    XmasItem highlandStables;
    XmasItem icePalace;
    XmasItem santaWorkshop;
    XmasItem additonalRides;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.xmas_attractions, container, false);

        mistletoeMarketplace = (XmasItem) view.findViewById(R.id.mistletoe_marketplace);
        holidayHills = (XmasItem) view.findViewById(R.id.holiday_hills);
        polarPathway = (XmasItem) view.findViewById(R.id.polar_pathway);
        highlandStables = (XmasItem) view.findViewById(R.id.highland_stables);
        icePalace = (XmasItem) view.findViewById(R.id.ice_palace);
        santaWorkshop = (XmasItem) view.findViewById(R.id.santa_workshop);
        additonalRides = (XmasItem) view.findViewById(R.id.xmas_add_rides);

        setUpOnClicks();
        return view;
    }

    private void setUpOnClicks(){

        mistletoeMarketplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), MistletoeMarketplace.class));
            }
        });

        holidayHills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), HolidayHills.class));
            }
        });

        polarPathway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), PolarPathway.class));
            }
        });

        highlandStables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), HighlandStables.class));
            }
        });

        icePalace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), IcePalace.class));
            }
        });

        santaWorkshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), SantaWorkshop.class));
            }
        });

        additonalRides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showXmasRidesDialog();
            }
        });

    }


    private void showXmasRidesDialog(){
            // custom dialog
            final Dialog dialog = new Dialog(getSherlockActivity());
            dialog.setContentView(R.layout.xmas_add_attractions_view);
            dialog.setTitle("Additional Attractions");
            // set the custom dialog components - text, image and button
            XmasItem ramButton= (XmasItem) dialog.findViewById(R.id.xmas_bat_ram);
            XmasItem cradleButton = (XmasItem) dialog.findViewById(R.id.xmas_cradle);
            XmasItem autoButton = (XmasItem) dialog.findViewById(R.id.xmas_auto);
            XmasItem windButton = (XmasItem) dialog.findViewById(R.id.xmas_wirbelwind);
            XmasItem machineButton = (XmasItem) dialog.findViewById(R.id.xmas_flying_machine);
            XmasItem karusselButton = (XmasItem) dialog.findViewById(R.id.xmas_karussel);
            XmasItem catapultButton = (XmasItem) dialog.findViewById(R.id.xmas_catapult);
            XmasItem towerButton = (XmasItem) dialog.findViewById(R.id.xmas_tower);
            XmasItem twistButton = (XmasItem) dialog.findViewById(R.id.xmas_twist);
            XmasItem snowmanButton = (XmasItem) dialog.findViewById(R.id.xmas_snowman_summit);
            XmasItem trainButton = (XmasItem) dialog.findViewById(R.id.xmas_train);
            XmasItem vboltButton = (XmasItem) dialog.findViewById(R.id.xmas_vbolt);

            ramButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getSherlockActivity(), Ram.class));
                    dialog.dismiss();
                }
            });

        cradleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), Cradle.class));
                dialog.dismiss();
            }
        });

        autoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), AutoBahn.class));
                dialog.dismiss();
            }
        });

        windButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), Wirbelwind.class));
                dialog.dismiss();
            }
        });

        machineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), FlyingMachine.class));
                dialog.dismiss();
            }
        });

        karusselButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                dialog.dismiss();
            }
        });

        catapultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), Catapult.class));
                dialog.dismiss();
            }
        });

        towerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), Mach.class));
                dialog.dismiss();
            }
        });

        twistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), Delight.class));
                dialog.dismiss();
            }
        });

        snowmanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), TradeWind.class));
                dialog.dismiss();
            }
        });

        trainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), Train.class));
                dialog.dismiss();
            }
        });

        vboltButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getSherlockActivity(), Verbolten.class));
                dialog.dismiss();
            }
        });

            dialog.show();
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
