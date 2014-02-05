package com.david.bgwfans.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.david.bgwfans.ArticleActivity;
import com.david.bgwfans.R;

import java.util.List;

import at.theengine.android.simple_rss2_android.RSSItem;

/**
 * Created by david.hodge on 1/27/14.
 */
public class RssAdapter extends BaseAdapter {

    private List<RSSItem> rssItems;
    private ViewHolder holder;
    private LayoutInflater mInflater;
    private Context context;

    public RssAdapter(Context c, List<RSSItem> mRssItems) {
        context = c;
        mInflater = LayoutInflater.from(c);
        rssItems = mRssItems;
    }

    public void setData(List<RSSItem> mRssItems) {
        rssItems = mRssItems;
    }

    public int getCount() {
        return rssItems.size();
    }

    public RSSItem getItem(int position) {
        return rssItems.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {

        TextView mTitle;
        TextView mPubDate;
        TextView mContent;
        TextView mDesc;
        String mLink;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = mInflater.inflate(R.layout.rss_item, null);
            holder = new ViewHolder();

            holder.mTitle = (TextView) view.findViewById(R.id.rss_title_text);
//            holder.mDesc = (TextView) view.findViewById(R.id.rss_desc_text);
            holder.mPubDate = (TextView) view.findViewById(R.id.rss_pub_text);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        final RSSItem mItem = rssItems.get(position);

        holder.mTitle.setText(mItem.getTitle());
//        holder.mDesc.setText(mItem.getLink().toString());
        holder.mPubDate.setText(removeLastChar(mItem.getDate()));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewArticle = new Intent(context, ArticleActivity.class);
                viewArticle.putExtra("article_title", mItem.getTitle());
                viewArticle.putExtra("article_date", mItem.getDate());
                viewArticle.putExtra("article_content", mItem.getContent());
                viewArticle.putExtra("article_link", mItem.getLink().toString());
                context.startActivity(viewArticle);
            }
        });

        return view;
    }

    private static String removeLastChar(String str) {
        return str.substring(0,str.length()-15);
    }

}
