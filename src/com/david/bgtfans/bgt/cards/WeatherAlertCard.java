package com.david.bgtfans.bgt.cards;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.david.bgtfans.R;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by david.hodge on 2/9/14.
 */
public class WeatherAlertCard extends Card {

    TextView hours;
    String alert;

    /**
     * Constructor with a custom inner layout
     *
     * @param context
     */
    public WeatherAlertCard(Context context, String alertText) {
        this(context, R.layout.weather_alert_card);
        this.alert = alertText;
    }

    /**
     * @param context
     * @param innerLayout
     */
    public WeatherAlertCard(Context context, int innerLayout) {
        super(context, innerLayout);
        init();
    }

    /**
     * Init
     */
    private void init() {

        //No Header

        /*
        //Set a OnClickListener listener
        setOnClickListener(new OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(getContext(), "Click Listener card=", Toast.LENGTH_LONG).show();
            }
        });*/
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {

        //Retrieve elements
        hours = (TextView) parent.findViewById(R.id.alert);
        hours.setText(alert);

    }
}
