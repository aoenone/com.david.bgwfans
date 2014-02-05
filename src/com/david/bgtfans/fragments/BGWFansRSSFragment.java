package com.david.bgtfans.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.david.bgtfans.R;
import com.david.bgtfans.adapters.RssAdapter;
import com.david.bgtfans.utils.Constants;
import com.david.bgtfans.utils.SmoothProgressBar.SmoothProgressBar;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;

import java.util.List;

import at.theengine.android.simple_rss2_android.RSSItem;
import at.theengine.android.simple_rss2_android.SimpleRss2Parser;
import at.theengine.android.simple_rss2_android.SimpleRss2ParserCallback;

/**
 * Created by david.hodge on 1/27/14.
 */
public class BGWFansRSSFragment extends SherlockFragment {

    View view;
    Context mContext;
    RssAdapter rssAdapter;
    ListView listView;
    SmoothProgressBar emptyView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.rss_view, container, false);
        listView = (ListView) view.findViewById(R.id.activity_googlecards_listview);
        emptyView = (SmoothProgressBar) view.findViewById(R.id.empty_loader);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView.setEmptyView(emptyView);
        mContext = getSherlockActivity();
        SimpleRss2Parser parser = new SimpleRss2Parser(Constants.BGWFANS_RSS,
                new SimpleRss2ParserCallback() {
                    @Override
                    public void onFeedParsed(List<RSSItem> items) {
                        rssAdapter = new RssAdapter(mContext, items);
                        SwingBottomInAnimationAdapter swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(rssAdapter);
                        swingBottomInAnimationAdapter.setInitialDelayMillis(300);
                        swingBottomInAnimationAdapter.setAbsListView(listView);
                        listView.setAdapter(swingBottomInAnimationAdapter);
                        rssAdapter.setData(items);
                        rssAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Exception e) {
                        e.printStackTrace();
                    }
                });
        parser.parseAsync();
    }
}
