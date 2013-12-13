package com.david.bgwfans.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.david.bgwfans.webviews.ChatRoom;
import com.david.bgwfans.R;
import com.david.bgwfans.attractions.coasters.Apollo;
import com.david.bgwfans.attractions.coasters.Alpen;
import com.david.bgwfans.attractions.coasters.Griffon;
import com.david.bgwfans.attractions.coasters.Grover;
import com.david.bgwfans.attractions.coasters.LochNess;
import com.david.bgwfans.attractions.coasters.Verbolten;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;


public class TabOne extends RoboSherlockFragment {
    RelativeLayout b1;
    Context ctx;
//    public AdView adView;
    View view;

    private AssetManager getAssets() {
        // TODO Auto-generated method stub
        return null;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ctx = getApplication();
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.coasters, container, false);

        //Pay no mind, this is for a few easter eggs. Gotta change it up every now and then
        final Button aButton = (Button) view.findViewById(R.id.apolloButton);
        final TextView aText = (TextView) view.findViewById(R.id.apollot);
        final Button gButton = (Button) view.findViewById(R.id.griffonButton);
        final TextView gText = (TextView) view.findViewById(R.id.griffont);
        final Button vButton = (Button) view.findViewById(R.id.vboltButton);
        final TextView vText = (TextView) view.findViewById(R.id.vboltt);
        final Button grovButton = (Button) view.findViewById(R.id.grovButton);
        RelativeLayout alpenBTN = (RelativeLayout) view.findViewById(R.id.alpen_button);
        RelativeLayout lochBTN = (RelativeLayout) view.findViewById(R.id.lochness_button);

        aButton.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                aButton.setBackgroundResource(R.drawable.fabio);
                aText.setText("Apollo's Chariot -> Poor Fabio");
                return true;
            }
        });
        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent apollo = new Intent(getSherlockActivity(), Apollo.class);
                getSherlockActivity().startActivity(apollo);
            }
        });

        gButton.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                gButton.setBackgroundResource(R.drawable.lemans);
                gText.setText("Griffon -> RIP Le Mans Raceway");
                return true;
            }
        });
        gButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent griffon = new Intent(getSherlockActivity(), Griffon.class);
                getSherlockActivity().startActivity(griffon);
            }
        });

        vButton.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                vButton.setBackgroundResource(R.drawable.bbw);
                vText.setText("Verbolten -> RIP Big Bad Wolf");
                return true;
            }
        });
        vButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vbolt = new Intent(getSherlockActivity(), Verbolten.class);
                getSherlockActivity().startActivity(vbolt);
            }
        });

        alpenBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alpen = new Intent(getSherlockActivity(), Alpen.class);
                getSherlockActivity().startActivity(alpen);
            }
        });

        lochBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lochness = new Intent(getSherlockActivity(), LochNess.class);
                getSherlockActivity().startActivity(lochness);
            }
        });

        grovButton.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
            	Intent cr = new Intent(v.getContext(), ChatRoom.class);
                startActivity(cr);
                return true;
            }
        });
        grovButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent grover = new Intent(getSherlockActivity(), Grover.class);
                getSherlockActivity().startActivity(grover);
            }
        });

        return view;
    }


}



