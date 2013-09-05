package com.david.bgwfans;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.fima.cardsui.objects.Card;

public class IllCard extends Card {

    public IllCard(String title) {
        super(title);
    }


    @Override
    public View getCardContent(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.illcard, null);

        ((TextView) view.findViewById(R.id.title)).setText(title);


        return view;
    }


}