package com.david.bgtfans.bgt.cards;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.david.bgtfans.R;
import com.david.bgtfans.io.network.responses.INetworkResponse;
import com.david.bgtfans.io.network.responses.NetworkResponse;
import com.david.bgtfans.io.toolbox.NetworkServiceTask;
import com.david.bgtfans.io.v2.network.services.ForecastService;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by david.hodge on 2/9/14.
 */
public class TomorrowWeatherCard extends Card {

    TextView currentTemp;
    TextView currentConditions;
    String city = "Williamsburg,VA&units=imperial";

    /**
     * Constructor with a custom inner layout
     *
     * @param context
     */
    public TomorrowWeatherCard(Context context) {
        this(context, R.layout.tomorrow_weather_card);
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

        if (isNetworkAvailable(mContext)) {

            ForecastService.Request request1 = ForecastService.Request.newBuilder("9127a75d40728c2aeab21957e38a5a62")
                    .setLatitude(37.234027)
                    .setLongitude(-76.646109)
                    .build();

            new NetworkServiceTask() {

                @Override
                protected void onPostExecute(INetworkResponse network) {
                    if (network == null || network.getStatus() == NetworkResponse.Status.FAIL) {
                        Toast.makeText(mContext, "FORECAST ERROR", Toast.LENGTH_SHORT).show();

                        return;
                    }

                    ForecastService.Response response = (ForecastService.Response) network;
                    currentConditions.setText(response.getForecast().getDaily().getSummary());

                }
            }.execute(request1);
        }

    }

    public boolean isNetworkAvailable(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting() && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }
}
