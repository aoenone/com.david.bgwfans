package com.david.bgwfans.cards;


import com.david.bgwfans.R;
import com.fima.cardsui.objects.Card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class PmCard extends Card {

    public PmCard(String title) {
        super(title);
    }


    @Override
    public View getCardContent(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.pmcard, null);

        ((TextView) view.findViewById(R.id.title)).setText(title);


        return view;
    }


}