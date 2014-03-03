package com.david.bgtfans.bgt.cards.attraction;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.david.bgtfans.R;
import com.squareup.picasso.Picasso;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by david.hodge on 2/10/14.
 */
public class AttractionMapCard extends Card {

    String lat;
    String lon;
    Context mContext;
    ImageView imageView;

    /**
     * Constructor with a custom inner layout
     *
     * @param context
     */
    public AttractionMapCard(Context context, String lat, String lon) {
        this(context, R.layout.attraction_map_card);
        this.mContext = context;
        this.lat = lat;
        this.lon = lon;
    }

    /**
     * @param context
     * @param innerLayout
     */
    public AttractionMapCard(Context context, int innerLayout) {
        super(context, innerLayout);
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {
        imageView = (ImageView) parent.findViewById(R.id.map);
        String getMapURL = "http://maps.googleapis.com/maps/api/staticmap?zoom=18&size=750x500&maptype=satellite&markers=size:mid|color:red|"
                + lat
                + ","
                + lon
                + "&sensor=false";
        Log.d("map", getMapURL);

        Picasso.with(mContext)
                .load(getMapURL)
                .into(imageView);

    }
}
