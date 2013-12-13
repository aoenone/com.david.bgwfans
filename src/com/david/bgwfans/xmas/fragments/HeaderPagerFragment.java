package com.david.bgwfans.xmas.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.david.bgwfans.xmas.fragments.ImageFragments.ImageFragmentOne;
import com.david.bgwfans.xmas.fragments.ImageFragments.ImageFragmentThree;
import com.david.bgwfans.xmas.fragments.ImageFragments.ImageFragmentTwo;
import com.david.bgwfans.viewcomponents.ZoomOutPageTransformer;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.viewpagerindicator.UnderlinePageIndicator;
import com.david.bgwfans.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: david.hodge
 * Date: 10/22/13
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class HeaderPagerFragment extends RoboSherlockFragment {

    View view;
    UnderlinePageIndicator headerCPI;
    ViewPager headerPager;
    ArrayList<Fragment> mFragments;
    ArrayList<String> mtitles;
    HeaderAdapter headerAdapter;
    ImageFragmentOne imageFragment;
    ImageFragmentTwo imageFragment2;
    ImageFragmentThree imageFragment3;
    Context mContext;
    Timer timer;
    int page = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.header_pager_fragment, container, false);

        headerPager = (ViewPager) view.findViewById(R.id.header_view_pager);
        headerCPI = (UnderlinePageIndicator) view.findViewById(R.id.header_cpi);

        mtitles = new ArrayList<String>();
        mtitles.add("Test");
        mtitles.add("Image");
        mtitles.add("Image2");

        imageFragment = new ImageFragmentOne("http://c0026106.cdn1.cloudfiles.rackspacecloud.com/527b963bba004d948d6640c499d43ff4_polarpathway.png", "Holiday Hills");
        imageFragment2 = new ImageFragmentTwo("http://c0026106.cdn1.cloudfiles.rackspacecloud.com/bc482d36fa1645dd97f944d891a2e025_dashersdiner_594x335.png");
        imageFragment3 = new ImageFragmentThree("http://c0026106.cdn1.cloudfiles.rackspacecloud.com/19029ea2cab34e0a8653b5f37c2be6bf_highland1.png");

        mFragments = new ArrayList<Fragment>();
        mFragments.add(imageFragment);
        mFragments.add(imageFragment2);
        mFragments.add(imageFragment3);


        headerAdapter = new HeaderAdapter(getActivity(), mtitles, mFragments);

        headerPager.setAdapter(headerAdapter);
        headerPager.setPageTransformer(true, new ZoomOutPageTransformer());
        headerCPI.setViewPager(headerPager);
        headerCPI.setOnPageChangeListener(headerOPCL);
        headerCPI.notifyDataSetChanged();

        pageSwitcher(3);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        headerPager.setCurrentItem(page);
    }

    public void pageSwitcher(int seconds){
        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000);
    }

    class RemindTask extends TimerTask {

        @Override
        public void run() {

            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            getSherlockActivity().runOnUiThread(new Runnable() {
                public void run() {

                    if (page >= headerAdapter.getCount()) { // In my case the number of pages are 5
                        page = 0;
                        headerPager.setCurrentItem(page);
                    } else {
                        headerPager.setCurrentItem(page++);
                    }
                }
            });

        }
    }


    class HeaderAdapter extends FragmentPagerAdapter {
        Context mContext;
        private LayoutInflater inflater;
        private ArrayList<String> mTitles;
        private ArrayList<Fragment> mFragments;

        public HeaderAdapter(Context context, ArrayList<String> strings, ArrayList<Fragment> fragments){
            super(HeaderPagerFragment.this.getChildFragmentManager());
            this.mContext = context;
            this.mTitles = strings;
            this.mFragments = fragments;
            this.inflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return this.mTitles.size();

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }

        @Override
        public Fragment getItem(int i) {
            return mFragments.get(i);
        }

        public void setTitles(ArrayList<String> titles) {
            this.mTitles = titles;
        }

        public void setFragments(ArrayList<Fragment> fragments) {
            this.mFragments = fragments;
        }
    }

    private ViewPager.OnPageChangeListener headerOPCL = new ViewPager.OnPageChangeListener(){
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
