package com.david.bgwfanspaid.xmas.cards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.david.bgwfanspaid.R;
import com.fima.cardsui.objects.Card;

/**
 * Created by david.hodge on 12/9/13.
 */
public class XmasAttrInfo extends Card {

    View view;

    public XmasAttrInfo(String title) {
        super(title);
    }

    @Override
    public View getCardContent(final Context context) {
        view = LayoutInflater.from(context).inflate(R.layout.xmas_attr_info, null);

        ((TextView) view.findViewById(R.id.title)).setText(title);
        return view;
    }
}
