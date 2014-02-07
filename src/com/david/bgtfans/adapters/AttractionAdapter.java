package com.david.bgtfans.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.david.bgtfans.R;
import com.david.bgtfans.models.Attractions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by david.hodge on 2/6/14.
 */
public class AttractionAdapter extends BaseAdapter {

    private ArrayList<Attractions> rssItems;
    private ViewHolder holder;
    private LayoutInflater mInflater;
    private Context context;

    public AttractionAdapter(Context c, ArrayList<Attractions> attractions) {
        context = c;
        mInflater = LayoutInflater.from(c);
        rssItems = attractions;
    }

    public void setData(ArrayList<Attractions> mRssItems) {
        rssItems = mRssItems;
    }

    public int getCount() {
        return rssItems.size();
    }

    public Attractions getItem(int position) {
        return rssItems.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {

        TextView mTitle;
        ImageView attractionImage;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = mInflater.inflate(R.layout.attraction_item, null);
            holder = new ViewHolder();

            holder.mTitle = (TextView) view.findViewById(R.id.attraction_name);
            holder.attractionImage = (ImageView) view.findViewById(R.id.attraction_image);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        final Attractions mItem = rssItems.get(position);
        holder.mTitle.setText(mItem.getName());
//        holder.attractionImage.setImageResource(mItem.getImage());

        Picasso.with(context)
                .load(mItem.getImage())
                .into(holder.attractionImage);

        return view;
    }

    private static String removeLastChar(String str) {
        return str.substring(0,str.length()-15);
    }
}
