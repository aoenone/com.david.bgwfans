package com.david.bgtfans.bgt.cards.attraction;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.david.bgtfans.R;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by david.hodge on 2/10/14.
 */
public class AttractionForumCard extends Card {

    String forumLink;

    /**
     * Constructor with a custom inner layout
     *
     * @param context
     */
    public AttractionForumCard(Context context, String forumLink) {
        this(context, R.layout.attraction_forum_card);
        this.forumLink = forumLink;
    }

    /**
     * @param context
     * @param innerLayout
     */
    public AttractionForumCard(Context context, int innerLayout) {
        super(context, innerLayout);
    }


    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {


    }
}
