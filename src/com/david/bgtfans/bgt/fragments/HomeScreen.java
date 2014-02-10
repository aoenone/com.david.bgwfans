package com.david.bgtfans.bgt.fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.david.bgtfans.R;
import com.david.bgtfans.bgt.cards.TodayHoursCard;
import com.david.bgtfans.bgt.cards.TodayWeatherCard;
import com.david.bgtfans.bgt.cards.TomorrowHourCard;
import com.david.bgtfans.bgt.cards.TomorrowWeatherCard;
import com.david.bgtfans.bgt.cards.WeatherAlertCard;
import com.david.bgtfans.io.network.responses.INetworkResponse;
import com.david.bgtfans.io.network.responses.NetworkResponse;
import com.david.bgtfans.io.toolbox.NetworkServiceTask;
import com.david.bgtfans.io.v2.network.services.ForecastService;
import com.david.bgtfans.utils.SmoothProgressBar.SmoothProgressBar;
import com.haarman.listviewanimations.swinginadapters.AnimationAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;

/**
 * Created by david.hodge on 2/4/14.
 */
public class HomeScreen extends SherlockFragment {

    View view;
    SmoothProgressBar empty;
    View footer;
    CardListView cardListView;
    CardArrayAdapter cardGridArrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);
        cardListView = (CardListView) view.findViewById(R.id.card_grid_base);
        empty = (SmoothProgressBar) view.findViewById(R.id.empty_loader);
        footer = inflater.inflate(R.layout.listview_footer, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        useForecastIo();
    }

    private void useForecastIo(){
        cardListView.setEmptyView(empty);
        final ArrayList<Card> cards = new ArrayList<Card>();

        if (isNetworkAvailable(getSherlockActivity())) {

            ForecastService.Request request1 = ForecastService.Request.newBuilder("9127a75d40728c2aeab21957e38a5a62")
                    .setLatitude(37.234027)
                    .setLongitude(-76.646109)
                    .build();

            new NetworkServiceTask() {

                @Override
                protected void onPostExecute(INetworkResponse network) {
                    if (network == null || network.getStatus() == NetworkResponse.Status.FAIL) {
                        Toast.makeText(getSherlockActivity(), "FORECAST ERROR", Toast.LENGTH_SHORT).show();

                        return;
                    }

                    ForecastService.Response response = (ForecastService.Response) network;
                    if (response.getForecast().getAlerts() != null) {
                        String test = response.getForecast().getAlerts().get(0).getDescription();
                        WeatherAlertCard alertCard = new WeatherAlertCard(getSherlockActivity(), response.getForecast().getAlerts().size() + " Weather Alerts");
                        cards.add(alertCard);

                        TodayHoursCard todayHoursCard = new TodayHoursCard(getSherlockActivity());
                        cards.add(todayHoursCard);

                        TodayWeatherCard card = new TodayWeatherCard(getActivity());
                        cards.add(card);

                        TomorrowHourCard tomorrowHourCard = new TomorrowHourCard(getSherlockActivity());
                        cards.add(tomorrowHourCard);

                        TomorrowWeatherCard tomorrowWeatherCard = new TomorrowWeatherCard(getSherlockActivity(), response);
                        cards.add(tomorrowWeatherCard);

                        cardGridArrayAdapter = new CardArrayAdapter(getSherlockActivity(), cards);
                        AnimationAdapter animCardArrayAdapter = new SwingBottomInAnimationAdapter(cardGridArrayAdapter);
                        animCardArrayAdapter.setAbsListView(cardListView);
                        cardListView.setAdapter(animCardArrayAdapter);

                    }else{
                        WeatherAlertCard alertCard = new WeatherAlertCard(getSherlockActivity(), "No Weather Alerts");
                        cards.add(alertCard);

                        TodayHoursCard todayHoursCard = new TodayHoursCard(getSherlockActivity());
                        cards.add(todayHoursCard);

                        TodayWeatherCard card = new TodayWeatherCard(getActivity());
                        cards.add(card);

                        TomorrowHourCard tomorrowHourCard = new TomorrowHourCard(getSherlockActivity());
                        cards.add(tomorrowHourCard);

                        TomorrowWeatherCard tomorrowWeatherCard = new TomorrowWeatherCard(getSherlockActivity(), response);
                        cards.add(tomorrowWeatherCard);

                        cardGridArrayAdapter = new CardArrayAdapter(getSherlockActivity(), cards);
                        AnimationAdapter animCardArrayAdapter = new SwingBottomInAnimationAdapter(cardGridArrayAdapter);
                        animCardArrayAdapter.setAbsListView(cardListView);
                        cardListView.setAdapter(animCardArrayAdapter);
                    }
                }
            }.execute(request1);
        }

        cardListView.addFooterView(footer);
    }

    public void useOpenWeatherMap(){
        cardListView.setEmptyView(empty);
        final ArrayList<Card> cards = new ArrayList<Card>();

        TodayHoursCard todayHoursCard = new TodayHoursCard(getSherlockActivity());
        cards.add(todayHoursCard);

        TodayWeatherCard card = new TodayWeatherCard(getActivity());
        cards.add(card);

        TomorrowHourCard tomorrowHourCard = new TomorrowHourCard(getSherlockActivity());
        cards.add(tomorrowHourCard);

        cardGridArrayAdapter = new CardArrayAdapter(getSherlockActivity(), cards);
        cardListView.setAdapter(cardGridArrayAdapter);
        cardListView.addFooterView(footer);
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
