package com.david.bgwfans;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.app.ListFragment;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class Attractions extends SideMenuActivity implements OnClickListener{
        
        FragmentTransaction transaction;
        static ViewPager mViewPager;
        //private JazzyViewPager mJazzy;
        RelativeLayout b1;
        private AdView adView;
        String adMobId = "a151350c50621fc";
        //Button button;
        
        @Override
        public void onDestroy() {
          if (adView != null) {
            adView.destroy();
          }
          super.onDestroy();
        }
        
    /** Called when the activity is first created. 
     * @param AFragmentTab */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //LinearLayout layout = (LinearLayout)findViewById(R.id.mainlayout);
        RelativeLayout.LayoutParams lay = new RelativeLayout.LayoutParams(
        	    RelativeLayout.LayoutParams.MATCH_PARENT, 
        	    RelativeLayout.LayoutParams.MATCH_PARENT);
        lay.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        adView = new AdView(this, AdSize.BANNER, adMobId);
        //layout.addView(adView, lay);
        adView.setGravity(Gravity.BOTTOM);
        adView.loadAd(new AdRequest());
  
        // Register the onClick listener with the implementation above
        //ImageView apolloimg = (ImageView)findViewById(R.id.apolloimg);
        Fragment tabOneFragment = new TabOne();
        Fragment tabTwoFragment = new TabTwo();
        Fragment tabThreeFragment = new TabThree();
        Fragment tabFourFragment = new TabFour();
        
        PagerAdapter mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mPagerAdapter.addFragment(tabOneFragment);
        mPagerAdapter.addFragment(tabTwoFragment);
        mPagerAdapter.addFragment(tabThreeFragment);
        mPagerAdapter.addFragment(tabFourFragment);
        
        //transaction = getSupportFragmentManager().beginTransaction();
        	mViewPager = (ViewPager) findViewById(R.id.pager);
       		mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
            mViewPager.setAdapter(mPagerAdapter);
            mViewPager.setOffscreenPageLimit(2);
            mViewPager.setCurrentItem(0);
                
                mViewPager.setOnPageChangeListener(
                    new ViewPager.SimpleOnPageChangeListener() {
                        @Override
                        public void onPageSelected(int position) {
                            // When swiping between pages, select the
                            // corresponding tab.
                            getActionBar().setSelectedNavigationItem(position);
                        }
                    });
             
        
        ActionBar ab = getActionBar();
        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);
        
        Tab tab1 = ab.newTab().setText("Coasters")
                .setTabListener(new TabListener<TabOne>(
        this, "coasters", TabOne.class));

        Tab tab2 = ab.newTab().setText("Flats")
                .setTabListener(new TabListener<TabTwo>(
        this, "coasters", TabTwo.class));
        
        Tab tab3 = ab.newTab().setText("Water")
                .setTabListener(new TabListener<TabThree>(
        this, "coasters", TabThree.class));
        
        Tab tab4 = ab.newTab().setText("Additional")
                .setTabListener(new TabListener<TabFour>(
        this, "coasters", TabFour.class));
                
                ab.addTab(tab1);
                ab.addTab(tab2);
                ab.addTab(tab3);
                ab.addTab(tab4);         
    }
    
    public static class TabListener<T extends Fragment> implements ActionBar.TabListener {
        private Fragment mFragment;
        private final Activity mActivity;
        private final String mTag;
        private final Class<T> mClass;

        /** Constructor used each time a new tab is created.
          * @param activity  The host Activity, used to instantiate the fragment
          * @param tag  The identifier tag for the fragment
          * @param class1  The fragment's Class, used to instantiate the fragment
          */
        public TabListener(Activity activity, String tag, Class<T> clz) {
            mActivity = activity;
            mTag = tag;
            mClass = clz;
        }

        /* The following are each of the ActionBar.TabListener callbacks */

        public void onTabSelected(Tab tab, FragmentTransaction ft) {
            // Check if the fragment is already initialized
            if (mFragment == null) {
                // If not, instantiate and add it to the activity
                mFragment = Fragment.instantiate(mActivity, mClass.getName());
                ft.add(android.R.id.content, mFragment, mTag);
            } else {
                // If it exists, simply attach it in order to show it
                ft.attach(mFragment);
            }
        }

        public void onTabUnselected(Tab tab, FragmentTransaction ft) {
            if (mFragment != null) {
                // Detach the fragment, because another one is being attached
                ft.detach(mFragment);
            }
        }

        

                public void onTabReselected(Tab arg0,
                                android.app.FragmentTransaction arg1)
                {
                        // TODO Auto-generated method stub
                        
                }

                public void onTabSelected(Tab arg0, android.app.FragmentTransaction arg1)
                {
                        // TODO Auto-generated method stub
                        mViewPager.setCurrentItem(arg0.getPosition());
                }

                public void onTabUnselected(Tab arg0,
                                android.app.FragmentTransaction arg1)
                {
                        // TODO Auto-generated method stub
                        
                }
    }
    
    public class PagerAdapter extends FragmentPagerAdapter {

        private final ArrayList<Fragment> mFragments = new ArrayList<Fragment>();

        public PagerAdapter(FragmentManager manager) {
            super(manager);
        }

        public void addFragmentActivity(FragmentActivity tabOneFragment) {
			// TODO Auto-generated method stub
			
		}

		public void addFragment(Fragment fragment) {
            mFragments.add(fragment);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
    
    
	
	public void Verbolten(View view){
		Intent vboltActivity = new Intent(this, Verbolten.class);
		startActivity(vboltActivity);
	}
	
	public void Griffon(View view){
		Intent griffonActivity = new Intent(this, Griffon.class);
		startActivity(griffonActivity);
	}
		
	public void Apollo(View view){
		Intent apolloActivity = new Intent(this, Apollo.class);
		startActivity(apolloActivity);
	}
    
	public void Alpen(View view){
		Intent alpenActivity = new Intent(this, Alpen.class);
		startActivity(alpenActivity);
	}
	
	public void Lochness(View view){
		Intent lochnessActivity = new Intent(this, LochNess.class);
		startActivity(lochnessActivity);
	}
	
	public void Grover(View view){
		Intent groverActivity = new Intent(this, Grover.class);
		startActivity(groverActivity);
	}
	
	public void SteamTrain(View view){
		Intent steamActivity = new Intent(this, Train.class);
		startActivity(steamActivity);
	}
	
	public void Skyride(View view){
		Intent skyrideActivity = new Intent(this, Skyride.class);
		startActivity(skyrideActivity);
	}
	
	public void Cruise(View view){
		Intent cruiseActivity = new Intent(this, Cruise.class);
		startActivity(cruiseActivity);
	}
}

