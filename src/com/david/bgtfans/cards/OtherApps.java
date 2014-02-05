package com.david.bgtfans.cards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.david.bgtfans.R;
import com.fima.cardsui.objects.Card;



/**
 * Created with IntelliJ IDEA.
 * User: david.hodge
 * Date: 7/7/13
 * Time: 9:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class OtherApps extends Card {

    public OtherApps(String title) {
        super(title);
    }


    @Override
    public View getCardContent(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.appscard, null);

        ((TextView) view.findViewById(R.id.title)).setText(title);

        return view;

    }

}
