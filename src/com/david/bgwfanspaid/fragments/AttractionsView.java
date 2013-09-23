package com.david.bgwfanspaid.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.david.bgwfanspaid.R;
import com.david.bgwfanspaid.viewcomponents.ZoomOutPageTransformer;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.EasyTracker;
import com.viewpagerindicator.TitlePageIndicator;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: david.hodge
 * Date: 7/5/13
 * Time: 10:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class AttractionsView extends RoboSherlockFragment {

    View view;
    ViewPager attractionsPager;
    TitlePageIndicator attractionsTPI;
    private TabOne coastersFragment = new TabOne();
    private TabTwo flatsFragment = new TabTwo();
    private TabThree waterFragment = new TabThree();
    private TabFour additionalFragment = new TabFour();
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
        mtitles.add(getString(R.string.coasters));
        mtitles.add(getString(R.string.flats));
        mtitles.add(getString(R.string.water));
        mtitles.add(getString(R.string.additonal));

        mFragments =  new ArrayList<Fragment>();
        mFragments.add(coastersFragment);
        mFragments.add(flatsFragment);
        mFragments.add(waterFragment);
        mFragments.add(additionalFragment);

        attractionsAdapter = new AttractionsAdapter(getActivity(), mtitles, mFragments);

        attractionsPager.setAdapter(attractionsAdapter);
        attractionsPager.setPageTransformer(true, new ZoomOutPageTransformer());
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

    class AttractionsAdapter extends FragmentPagerAdapter{
        Context context;
        private LayoutInflater inflater;
        private ArrayList<String> titles;
        private ArrayList<Fragment> mFragments;

            public AttractionsAdapter(Context context, ArrayList<String> strings, ArrayList<Fragment> fragments){
                super(AttractionsView.this.getChildFragmentManager());
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
