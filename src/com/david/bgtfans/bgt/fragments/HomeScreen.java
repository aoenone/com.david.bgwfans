package com.david.bgtfans.bgt.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.david.bgtfans.R;
import com.david.bgtfans.bgt.cards.TodayHoursCard;
import com.david.bgtfans.bgt.cards.TodayWeatherCard;
import com.david.bgtfans.bgt.cards.TomorrowHourCard;
import com.david.bgtfans.bgt.cards.TomorrowWeatherCard;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;

/**
 * Created by david.hodge on 2/4/14.
 */
public class HomeScreen extends SherlockFragment {

    View view;
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
        footer = inflater.inflate(R.layout.listview_footer, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Card> cards = new ArrayList<Card>();

        TodayHoursCard todayHoursCard = new TodayHoursCard(getSherlockActivity());
        cards.add(todayHoursCard);

        TodayWeatherCard card = new TodayWeatherCard(getActivity());
        cards.add(card);

        TomorrowHourCard tomorrowHourCard = new TomorrowHourCard(getSherlockActivity());
        cards.add(tomorrowHourCard);

        TomorrowWeatherCard tomorrowWeatherCard = new TomorrowWeatherCard(getSherlockActivity());
        cards.add(tomorrowWeatherCard);

        cardGridArrayAdapter = new CardArrayAdapter(getSherlockActivity(), cards);
        cardListView.setAdapter(cardGridArrayAdapter);
        cardListView.addFooterView(footer);
    }
}
