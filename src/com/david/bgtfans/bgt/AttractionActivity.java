package com.david.bgtfans.bgt;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.david.bgtfans.R;
import com.david.bgtfans.bgt.cards.attraction.AttractionForumCard;
import com.david.bgtfans.bgt.cards.attraction.AttractionInfoCard;
import com.david.bgtfans.bgt.cards.attraction.AttractionMapCard;
import com.david.bgtfans.utils.SmoothProgressBar.SmoothProgressBar;
import com.david.bgtfans.utils.SystemBarTintManager;
import com.haarman.listviewanimations.swinginadapters.AnimationAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;

/**
 * Created by david.hodge on 2/10/14.
 */
public class AttractionActivity extends SherlockActivity {

    Context mContext;
    CardListView cardListView;
    View footer;
    View header;
    SmoothProgressBar empty;
    AttractionInfoCard attractionInfoCard;
    AttractionMapCard attractionMapCard;
    AttractionForumCard attractionForumCard;
    CardArrayAdapter cardArrayAdapter;
    AnimationAdapter animCardArrayAdapter;
    ArrayList<Card> cards;
    SystemBarTintManager systemBarTintManager;

    ImageView headerImage;
    TextView headerText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= 19){
            systemBarTintManager = new SystemBarTintManager(this);
            systemBarTintManager.setStatusBarTintEnabled(true);
            systemBarTintManager.setStatusBarTintColor(getResources().getColor(R.color.ab_color));
        }

        setContentView(R.layout.attraction_activity);
        mContext = this;

        cardListView = (CardListView) findViewById(R.id.card_list_base);
        empty = (SmoothProgressBar) findViewById(R.id.empty_loader);
        footer = (View) getLayoutInflater().inflate(R.layout.listview_footer, null);
        header = (View) getLayoutInflater().inflate(R.layout.attraction_header, null);

        headerImage = (ImageView) header.findViewById(R.id.attraction_header_image);
        headerText = (TextView) header.findViewById(R.id.attraction_header_text);

        headerText.setText("New Test");
        headerImage.setBackground(getResources().getDrawable(R.drawable.hos_test));
        cardListView.setEmptyView(empty);
        cardListView.addFooterView(footer);
        cardListView.addHeaderView(header);

        attractionInfoCard = new AttractionInfoCard(this);
        attractionMapCard = new AttractionMapCard(this);
        attractionForumCard = new AttractionForumCard(this);

        cards = new ArrayList<Card>();
        cards.add(attractionInfoCard);
        cards.add(attractionMapCard);
        cards.add(attractionForumCard);

        cardArrayAdapter = new CardArrayAdapter(this, cards);
        animCardArrayAdapter = new SwingBottomInAnimationAdapter(cardArrayAdapter);
        animCardArrayAdapter.setAbsListView(cardListView);
        cardListView.setAdapter(animCardArrayAdapter);
    }

}
