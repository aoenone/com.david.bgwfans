package com.david.bgtfans.bgt.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.david.bgtfans.R;
import com.google.analytics.tracking.android.EasyTracker;
import com.viewpagerindicator.TitlePageIndicator;

import java.util.ArrayList;

/**
 * Created by david.hodge on 2/4/14.
 */
public class AttractionsFragment extends SherlockFragment {

    View view;
    ViewPager attractionsPager;
    TitlePageIndicator attractionsTPI;
    CoastersFragment coastersFragment = new CoastersFragment();
    FlatsFragment flatsFragment = new FlatsFragment();
    KidsidFragment kidsidFragment = new KidsidFragment();
    TransportationFragment transportationFragment = new TransportationFragment();
    WaterFragment waterFragment = new WaterFragment();
    WildlifeFragment wildlifeFragment = new WildlifeFragment();
    private ArrayList<Fragment> mFragments;
    private ArrayList<String> mtitles;
    FragmentManager fm;
    AttractionsAdapter attractionsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.attractions_view, container, false);

        attractionsPager = (ViewPager) view.findViewById(R.id.attractions_view_pager);
        attractionsTPI = (TitlePageIndicator) view.findViewById(R.id.attractions_tpi);

        mtitles = new ArrayList<String>();
        mtitles.add("Coasters");
        mtitles.add("Flats");
        mtitles.add("Water");
        mtitles.add("Wildlife");
        mtitles.add("Other");
        mtitles.add("Kidsiderate");

        mFragments =  new ArrayList<Fragment>();
        mFragments.add(coastersFragment);
        mFragments.add(flatsFragment);
        mFragments.add(waterFragment);
        mFragments.add(wildlifeFragment);
        mFragments.add(transportationFragment);
        mFragments.add(kidsidFragment);

        attractionsAdapter = new AttractionsAdapter(getActivity(), mtitles, mFragments);

        attractionsPager.setAdapter(attractionsAdapter);
//        attractionsPager.setPageTransformer(true, new ZoomOutPageTransformer());
        attractionsTPI.setViewPager(attractionsPager);
        attractionsTPI.setOnPageChangeListener(attractionsOPCL);
        FragmentManager fm = getChildFragmentManager();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EasyTracker.getInstance().activityStart(getActivity()); // Add this method.
    }

    @Override
    public void onStop() {
        super.onStop();
        EasyTracker.getInstance().activityStop(getActivity()); // Add this method.
    }

    class AttractionsAdapter extends FragmentPagerAdapter {
        Context context;
        private LayoutInflater inflater;
        private ArrayList<String> titles;
        private ArrayList<Fragment> mFragments;

        public AttractionsAdapter(Context context, ArrayList<String> strings, ArrayList<Fragment> fragments){
            super(AttractionsFragment.this.getChildFragmentManager());
            this.context = context;
            this.titles = strings;
            this.mFragments = fragments;
            this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return this.titles.size();

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        @Override
        public Fragment getItem(int i) {
            return mFragments.get(i);
        }

        public void setTitles(ArrayList<String> titles) {
            this.titles = titles;
        }

        public void setFragments(ArrayList<Fragment> fragments) {
            this.mFragments = fragments;
        }
    }

    private ViewPager.OnPageChangeListener attractionsOPCL = new ViewPager.OnPageChangeListener(){
        @Override
        public void onPageScrolled(int i, float v, int i1) {
        }

        @Override
        public void onPageSelected(int i) {
        }

        @Override
        public void onPageScrollStateChanged(int i) {
        }
    };
}
