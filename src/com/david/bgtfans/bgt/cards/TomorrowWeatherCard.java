package com.david.bgtfans.bgt.cards;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.david.bgtfans.R;
import com.david.bgtfans.io.v2.network.services.ForecastService;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by david.hodge on 2/9/14.
 */
public class TomorrowWeatherCard extends Card {

    TextView currentTemp;
    TextView currentConditions;
    ForecastService.Response response;

    /**
     * Constructor with a custom inner layout
     *
     * @param context
     */
    public TomorrowWeatherCard(Context context, ForecastService.Response response) {
        this(context, R.layout.tomorrow_weather_card);
        this.response = response;
    }

    /**
     * @param context
     * @param innerLayout
     */
    public TomorrowWeatherCard(Context context, int innerLayout) {
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
        currentConditions = (TextView) parent.findViewById(R.id.weather);
        currentConditions.setText(response.getForecast().getDaily().getSummary());
    }
}
