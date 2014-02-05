package com.david.bgtfans.hos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.david.bgtfans.R;
import com.fima.cardsui.objects.Card;


/**
 * Created with IntelliJ IDEA.
 * User: david.hodge
 * Date: 8/24/13
 * Time: 1:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class HosCardAge extends Card{

    public HosCardAge(String title) {
        super(title);
    }

    @Override
    public View getCardContent(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.hos_age_card, null);

        ((TextView) view.findViewById(R.id.title)).setText(title);


        return view;
    }
}
