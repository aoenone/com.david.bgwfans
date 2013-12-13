package com.david.bgwfans;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by david.hodge on 11/19/13.
 */
public class GlassActivity extends Activity {

    private CardScrollView mCardScrollView;
    private List<Card> mCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        createCards();

        mCardScrollView = new CardScrollView(this);
        ExampleCardScrollAdapter adapter = new ExampleCardScrollAdapter();
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);
    }

    private void createCards(){
        mCards = new ArrayList<Card>();

        Card card;

        card = new Card(this);
        card.setText("This card has a footer.");
        card.setInfo("I'm the footer!");
        mCards.add(card);

        card = new Card(this);
        card.setText("This card has a puppy background image.");
        card.setInfo("How can you resist?");
        card.setFullScreenImages(true);
        card.addImage(R.drawable.iconv2);
        mCards.add(card);

    }

    private class ExampleCardScrollAdapter extends CardScrollAdapter {
        @Override
        public int findIdPosition(Object id) {
            return -1;
        }

        @Override
        public int findItemPosition(Object item) {
            return mCards.indexOf(item);
        }

        @Override
        public int getCount() {
            return mCards.size();
        }

        @Override
        public Object getItem(int position) {
            return mCards.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return mCards.get(position).toView();
        }
    }

}
