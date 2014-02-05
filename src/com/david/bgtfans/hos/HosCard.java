package com.david.bgtfans.hos;

import com.david.bgtfans.R;
import com.fima.cardsui.objects.Card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class HosCard extends Card {

    public HosCard(String title) {
        super(title);
    }


    @Override
    public View getCardContent(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.hoscard, null);

        ((TextView) view.findViewById(R.id.title)).setText(title);


        return view;
    }


}
