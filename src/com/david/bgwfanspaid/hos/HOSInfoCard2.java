package com.david.bgwfanspaid.hos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.david.bgwfanspaid.R;
import com.fima.cardsui.objects.Card;

/**
 * Created with IntelliJ IDEA.
 * User: david.hodge
 * Date: 8/24/13
 * Time: 2:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class HOSInfoCard2 extends Card {

    public HOSInfoCard2(String title) {
        super(title);
    }


    @Override
    public View getCardContent(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.hos_info_2, null);

        ((TextView) view.findViewById(R.id.title)).setText(title);


        return view;
    }
}
