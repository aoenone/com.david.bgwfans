package com.david.bgwfans;

import java.util.ArrayList;

import net.simonvt.widget.MenuDrawer;
import net.simonvt.widget.MenuDrawerManager;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class Attractions extends FragmentActivity implements OnClickListener{
        
        FragmentTransaction transaction;
        static ViewPager mViewPager;
        private MenuDrawerManager mMenuDrawer;
        RelativeLayout b1;
        
    /** Called when the activity is first created. 
     * @param AFragmentTab */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mMenuDrawer = new MenuDrawerManager(this, MenuDrawer.MENU_DRAG_WINDOW);
        //mMenuDrawer.setContentView(R.layout.activity_windowsample);
        mMenuDrawer.setMenuView(R.layout.menu_scrollview);

        MenuScrollView msv = (MenuScrollView) mMenuDrawer.getMenuView();
        msv.setOnScrollChangedListener(new MenuScrollView.OnScrollChangedListener() {
            public void onScrollChanged() {
                mMenuDrawer.getMenuDrawer().invalidate();
            }
        });
        
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
                
                findViewById(R.id.item1).setOnClickListener(this);
                findViewById(R.id.item2).setOnClickListener(this);
                findViewById(R.id.item3).setOnClickListener(this);
                findViewById(R.id.item4).setOnClickListener(this);
                findViewById(R.id.item5).setOnClickListener(this);
                findViewById(R.id.item6).setOnClickListener(this);
                findViewById(R.id.item7).setOnClickListener(this);
                findViewById(R.id.item8).setOnClickListener(this);
                findViewById(R.id.item9).setOnClickListener(this);
                findViewById(R.id.item10).setOnClickListener(this);
                findViewById(R.id.item11).setOnClickListener(this);
                findViewById(R.id.item12).setOnClickListener(this);
                findViewById(R.id.item13).setOnClickListener(this);
                findViewById(R.id.item14).setOnClickListener(this);
             
        
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
    
    


	public void onClick(View v) {
		switch(v.getId())
    	{
		case R.id.item1: Intent infoActivity = new Intent(this, InfoScreen.class);
			startActivity(infoActivity);
			break;
		case R.id.item2: Intent attrActivity = new Intent(this, Attractions.class);
			startActivity(attrActivity);
			break;
		case R.id.item3: Intent showsActivity = new Intent(this, HOS_Shows.class);
			startActivity(showsActivity);
			break;
		case R.id.item4: Intent eatActivity = new Intent(this, Eateries.class);
			startActivity(eatActivity);
			break;
		case R.id.item5: Intent mapActivity = new Intent(this, MapScreen.class);
			startActivity(mapActivity);
			break;
		case R.id.item6: Intent hhActivity = new Intent(this, HOS_Houses.class);
			startActivity(hhActivity);
			break;
		case R.id.item7: Intent hshowActivity = new Intent(this, HOS_Shows.class);
			startActivity(hshowActivity);
			break;
		case R.id.item8: Intent featuresActivity = new Intent(this, HOS_Features.class);
			startActivity(featuresActivity);
			break;
		case R.id.item14: Intent hosMapActivity = new Intent(this, HOS_Map.class);
			startActivity(hosMapActivity);
			break;
    	case R.id.item9: Intent blogActivity = new Intent(this, BGWFans.class);
    		startActivity(blogActivity);
    		break;
    	case R.id.item10: Intent forumActivity = new Intent(this, Forums.class);
    		startActivity(forumActivity);
    		break;
    	case R.id.item11: Intent wikiActivity = new Intent(this, Wiki.class);
    		startActivity(wikiActivity);
    		break;
    	case R.id.item12: Intent settingsActivity = new Intent(this, Settings.class);
			startActivity(settingsActivity);
			break;
    	case R.id.item13: Intent aboutActivity = new Intent(this, About.class);
			startActivity(aboutActivity);
			break;
    	}
        mMenuDrawer.setActiveView(v);
        //mContentTextView.setText("Active item: " + ((TextView) v).getText());
        mMenuDrawer.closeMenu();
        //mActiveViewId = v.getId();
		
	}
	
	public void Verbolten(View view){
		Intent vboltActivity = new Intent(this, Verbolten.class);
		startActivity(vboltActivity);
	}
	
	public void Griffon(View view){
		Intent vboltActivity = new Intent(this, Verbolten.class);
		startActivity(vboltActivity);
	}
	
	public void Apollo(View view){
		Intent vboltActivity = new Intent(this, Verbolten.class);
		startActivity(vboltActivity);
	}
    
	public void Alpen(View view){
		Intent vboltActivity = new Intent(this, Verbolten.class);
		startActivity(vboltActivity);
	}
	
	public void Lochness(View view){
		Intent vboltActivity = new Intent(this, Verbolten.class);
		startActivity(vboltActivity);
	}
	
	public void Grover(View view){
		Intent vboltActivity = new Intent(this, Verbolten.class);
		startActivity(vboltActivity);
	}
}

