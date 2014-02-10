package com.david.bgtfans.bgt.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.david.bgtfans.R;
import com.david.bgtfans.adapters.AttractionAdapter;
import com.david.bgtfans.models.Attractions;
import com.david.bgtfans.utils.SmoothProgressBar.SmoothProgressBar;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;

import java.util.ArrayList;

/**
 * Created by david.hodge on 2/6/14.
 */
public class KidsidFragment extends SherlockFragment {

    View view;
    View footer;
    ListView listView;
    SmoothProgressBar emptyView;
    ArrayList<Attractions> attractions;
    AttractionAdapter attractionAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attractions = new ArrayList<Attractions>();
        attractions.add(new Attractions("Cheetah Hunt", R.drawable.bgt_test));
        attractions.add(new Attractions("SheiKra", R.drawable.bgt_test));
        attractions.add(new Attractions("Air Grover", R.drawable.bgt_test));
        attractions.add(new Attractions("MSandSerpent", R.drawable.bgt_test));
        attractions.add(new Attractions("Gwazi", R.drawable.bgt_test));
        attractions.add(new Attractions("Kumba", R.drawable.bgt_test));
        attractions.add(new Attractions("Montu", R.drawable.bgt_test));
        attractions.add(new Attractions("Scorpion", R.drawable.bgt_test));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.attractionslist, container, false);
        footer = inflater.inflate(R.layout.listview_footer, null);
        listView = (ListView) view.findViewById(R.id.activity_googlecards_listview);
        emptyView = (SmoothProgressBar) view.findViewById(R.id.empty_loader);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView.addFooterView(footer);
        attractionAdapter = new AttractionAdapter(getSherlockActivity(), attractions);
        SwingBottomInAnimationAdapter swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(attractionAdapter);
        swingBottomInAnimationAdapter.setInitialDelayMillis(300);
        swingBottomInAnimationAdapter.setAbsListView(listView);
        listView.setAdapter(swingBottomInAnimationAdapter);
        attractionAdapter.setData(attractions);
        attractionAdapter.notifyDataSetChanged();
    }

}
