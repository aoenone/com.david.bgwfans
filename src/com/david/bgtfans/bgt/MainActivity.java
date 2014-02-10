package com.david.bgtfans.bgt;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.MenuItem;
import com.crittercism.app.Crittercism;
import com.david.bgtfans.R;
import com.david.bgtfans.bgt.fragments.AttractionsFragment;
import com.david.bgtfans.bgt.fragments.BGTFansRssFragment;
import com.david.bgtfans.bgt.fragments.BGTOBlog;
import com.david.bgtfans.bgt.fragments.BGTOSite;
import com.david.bgtfans.bgt.fragments.EateriesFragment;
import com.david.bgtfans.bgt.fragments.ForumFragment;
import com.david.bgtfans.bgt.fragments.HomeScreen;
import com.david.bgtfans.bgt.fragments.ParkMap;
import com.david.bgtfans.bgt.fragments.ShowFragment;
import com.david.bgtfans.utils.FontTypefaceSpan;
import com.david.bgtfans.utils.SystemBarTintManager;
import com.david.bgtfans.viewcomponents.NavigationDrawerItem;
import com.david.bgtfans.webviews.Wiki;
import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockFragmentActivity;
import com.google.analytics.tracking.android.EasyTracker;

import roboguice.RoboGuice;
import roboguice.inject.RoboInjector;


/**
 * Created by david.hodge on 6/27/13.
 */
public class MainActivity extends RoboSherlockFragmentActivity {

    //when card ui breaks, remove backgrounds, change all paddings
    //for bgw shit
    public static final int NAV_ID_INFO_SCREEN = R.id.drawer_info_screen;
    public static final int NAV_ID_ATTRACTIONS = R.id.drawer_attractions;
    public static final int NAV_ID_SHOWS = R.id.drawer_shows;
    public static final int NAV_ID_EATERIES = R.id.drawer_eateries;
    public static final int NAV_ID_MAP = R.id.drawer_map;

//    //for HOS shit
//    public static final int NAV_HOS_INFO = R.id.drawer_hos_info;
//    public static final int NAV_HOS_HOUSES = R.id.drawer_hos_houses;
//    public static final int NAV_HOS_SHOWS = R.id.drawer_hos_shows;
////    public static final int NAV_HOS_CULINARY = R.id.drawer_hos_food;
////    public static final int NAV_HOS_EXP = R.id.drawer_hos_exp;
//    public static final int NAV_EVENT_SITE = R.id.drawer_event_site;
//    public static final int NAV_HOS_MAP = R.id.drawer_hos_map;

    //for BGWTans shit
    public static final int NAV_ID_BLOG = R.id.drawer_blog;
    public static final int NAV_ID_FORUMS = R.id.drawer_forums;
    public static final int NAV_ID_WIKI = R.id.drawer_wiki;

    //for official things
    public static final int NAV_ID_OBLOG = R.id.drawer_o_blog;
    public static final int NAV_ID_OSITE = R.id.drawer_o_site;

    //for extra app shit
    public static final int NAV_ID_SETTINGS = R.id.drawer_settings;
    public static final int NAV_ID_ABOUT = R.id.drawer_about;

    public static final int NAV_ID_BGW = R.id.drawer_bgwthreed;


//    @InjectView(R.id.drawer_root)
    DrawerLayout mDrawerLayout;
//    @InjectView (R.id.fragment_container)
    FrameLayout mContent;

    //Used for future User profile. will add back in once complete
//   @InjectView (R.id.drawer_user_profile) RelativeLayout userProfile;

    ActionBarDrawerToggle mActionBarDrawerToggle;
    FragmentManager mfragmentManager;
    NavigationDrawerItem currentNavigationDrawerItem;
    Context mContext;
    FragmentTransaction ft;
    ActionBar actionBar;
    SystemBarTintManager systemBarTintManager;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= 19){
            systemBarTintManager = new SystemBarTintManager(MainActivity.this);
            systemBarTintManager.setStatusBarTintEnabled(true);
            systemBarTintManager.setStatusBarTintColor(getResources().getColor(R.color.ab_color));
            SystemBarTintManager.SystemBarConfig config = systemBarTintManager.getConfig();
//            mContent.setPadding(0, config.getPixelInsetTop(true), 0, 0);
        }

        Crittercism.initialize(getApplicationContext(), "522b49fe558d6a77d3000001");
        setContentView(R.layout.app_main);
        mContext = this;
        mfragmentManager = getSupportFragmentManager();
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setIcon(android.R.color.transparent);
        actionBar.setLogo(android.R.color.transparent);
        FontTypefaceSpan.setActionBarTitle(this, actionBar, "BGTFans");
//        actionBar.setTitle("BGTFans");
//        actionBar.setSubtitle("Home");

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_root);
        if(savedInstanceState == null){
            setContentFragment(NAV_ID_INFO_SCREEN);
            FontTypefaceSpan.setActionBarSubTitle(this, actionBar, "Shows");
        }

//        userProfile.setOnClickListener(new View.OnClickListener() {
//                userProfileClick();
//        });

        initDrawerLayout();
    }

//    public void userProfileClick(){
//        RoboInjector injector = RoboGuice.getInjector(MainActivity.this);
//        Fragment fragment;
////        fragment = injector.getInstance(UserNoLogin.class);
//
//        ft = mfragmentManager.beginTransaction();
//        ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
//        ft.replace(R.id.fragment_container, fragment).addToBackStack("tag");
//        ft.addToBackStack(null);
//        ft.commit();
//        mDrawerLayout.closeDrawers();
//    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void initDrawerLayout(){
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_navigation_drawer,
                R.string.drawer_open, R.string.drawer_close);
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
    }

    public void navigationDrawerItemClick(View v){
        setSupportProgressBarIndeterminateVisibility(false);
        switch (v.getId()) {
            default:
                if(currentNavigationDrawerItem != v){
                    setContentFragment(v.getId());
                    mDrawerLayout.closeDrawers();
                }
        }
    }

    private void setContentFragment(int fragID){
        RoboInjector injector = RoboGuice.getInjector(this);
        Fragment fragment;
        Bundle args = new Bundle();
        switch (fragID){
            case NAV_ID_INFO_SCREEN:
                fragment = injector.getInstance(HomeScreen.class);
                actionBar.setSplitBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black_overlay)));
                systemBarTintManager.setNavigationBarTintEnabled(true);
                systemBarTintManager.setNavigationBarTintColor(getResources().getColor(R.color.md__transparent));
                FontTypefaceSpan.setActionBarSubTitle(this, actionBar, "Home");
                break;
            case NAV_ID_ATTRACTIONS:
                fragment = injector.getInstance(AttractionsFragment.class);
                actionBar.setSplitBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black_overlay)));
                systemBarTintManager.setNavigationBarTintEnabled(true);
                systemBarTintManager.setNavigationBarTintColor(getResources().getColor(R.color.md__transparent));
                FontTypefaceSpan.setActionBarSubTitle(this, actionBar, "Attractions");
                break;
            case NAV_ID_SHOWS:
                fragment = injector.getInstance(ShowFragment.class);
                actionBar.setSplitBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black_overlay)));
                systemBarTintManager.setNavigationBarTintEnabled(true);
                systemBarTintManager.setNavigationBarTintColor(getResources().getColor(R.color.md__transparent));
                FontTypefaceSpan.setActionBarSubTitle(this, actionBar, "Shows");
                break;
            case NAV_ID_EATERIES:
                fragment = injector.getInstance(EateriesFragment.class);
                actionBar.setSplitBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black_overlay)));
                systemBarTintManager.setNavigationBarTintEnabled(true);
                systemBarTintManager.setNavigationBarTintColor(getResources().getColor(R.color.md__transparent));
                FontTypefaceSpan.setActionBarSubTitle(this, actionBar, "Eateries");
                break;
            case NAV_ID_MAP:
                fragment = injector.getInstance(com.david.bgtfans.bgt.fragments.ParkMap.class);
                actionBar.setSplitBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black_overlay)));
                systemBarTintManager.setNavigationBarTintEnabled(true);
                systemBarTintManager.setNavigationBarTintColor(getResources().getColor(R.color.black_overlay));
                FontTypefaceSpan.setActionBarSubTitle(this, actionBar, "Park Map");
                break;
            //used for special events as needed
//            case NAV_HOS_INFO:
//                fragment = injector.getInstance(XmasInfoFragment.class);
//                break;
//            case NAV_HOS_HOUSES:
//                fragment = injector.getInstance(XmasAttractions.class);
//                break;
//            case NAV_HOS_SHOWS:
//                fragment = injector.getInstance(XmasShows.class);
//                break;
////            case NAV_HOS_CULINARY:
////                fragment = injector.getInstance(XmasFood.class);
////                break;
//            case NAV_EVENT_SITE:
//                fragment = injector.getInstance(XmasSiteFragment.class);
//                break;
//            case NAV_HOS_MAP:
//                fragment = injector.getInstance(XmasMap.class);
//                break;
            case NAV_ID_BLOG:
                fragment = injector.getInstance(BGTFansRssFragment.class);
                FontTypefaceSpan.setActionBarSubTitle(this, actionBar, "BGTFans News");
                break;
            case NAV_ID_FORUMS:
                fragment = injector.getInstance(ForumFragment.class);
                actionBar.setSplitBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black_overlay)));
                systemBarTintManager.setNavigationBarTintEnabled(true);
                systemBarTintManager.setNavigationBarTintColor(getResources().getColor(R.color.black_overlay));
                FontTypefaceSpan.setActionBarSubTitle(this, actionBar, "Forums");
                break;
            case NAV_ID_WIKI:
                fragment = injector.getInstance(Wiki.class);
                actionBar.setSplitBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black_overlay)));
                systemBarTintManager.setNavigationBarTintEnabled(true);
                systemBarTintManager.setNavigationBarTintColor(getResources().getColor(R.color.black_overlay));
                FontTypefaceSpan.setActionBarSubTitle(this, actionBar, "Wiki");
                break;
            case NAV_ID_OBLOG:
                fragment = injector.getInstance(BGTOBlog.class);
                FontTypefaceSpan.setActionBarSubTitle(this, actionBar, "BGT Blog");
                break;
            case NAV_ID_OSITE:
                fragment = injector.getInstance(BGTOSite.class);
                actionBar.setSplitBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black_overlay)));
                systemBarTintManager.setNavigationBarTintEnabled(true);
                systemBarTintManager.setNavigationBarTintColor(getResources().getColor(R.color.black_overlay));
                FontTypefaceSpan.setActionBarSubTitle(this, actionBar, "BGT Site");
                break;
            //TODO ADD THIS BACK
//            case NAV_ID_SETTINGS:
//                fragment = injector.getInstance(Settings.class);
//                FontTypefaceSpan.setActionBarSubTitle(this, actionBar, "Settings");
//                break;
//            case NAV_ID_ABOUT:
//                fragment = injector.getInstance(About.class);
//                FontTypefaceSpan.setActionBarSubTitle(this, actionBar, "About");
//                break;
            case NAV_ID_BGW:
                startActivity(new Intent(mContext, BGT3DActivity.class));
                fragment = injector.getInstance(ParkMap.class);
                break;
            default:
                return;
        }

        if (fragment != null){
            fragment.setArguments(args);
            fragment.setRetainInstance(true);
        }

        ft = mfragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
//        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(R.id.fragment_container, fragment).addToBackStack("tag");
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        getFragmentManager().getBackStackEntryCount();
        if(mfragmentManager.getBackStackEntryCount() == 1){
            this.finish();
        }
        mfragmentManager.popBackStack();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mActionBarDrawerToggle.onOptionsItemSelected(getMenuItem(item))) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mActionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
//        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    private android.view.MenuItem getMenuItem(final MenuItem item) {
        return new android.view.MenuItem() {
            @Override
            public int getItemId() {
                return item.getItemId();
            }

            public boolean isEnabled() {
                return true;
            }

            @Override
            public boolean collapseActionView() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean expandActionView() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public ActionProvider getActionProvider() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public View getActionView() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public char getAlphabeticShortcut() {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public int getGroupId() {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public Drawable getIcon() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Intent getIntent() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public ContextMenu.ContextMenuInfo getMenuInfo() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public char getNumericShortcut() {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public int getOrder() {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public SubMenu getSubMenu() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public CharSequence getTitle() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public CharSequence getTitleCondensed() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public boolean hasSubMenu() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean isActionViewExpanded() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean isCheckable() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean isChecked() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean isVisible() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public android.view.MenuItem setActionProvider(ActionProvider actionProvider) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public android.view.MenuItem setActionView(View view) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public android.view.MenuItem setActionView(int resId) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public android.view.MenuItem setAlphabeticShortcut(char alphaChar) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public android.view.MenuItem setCheckable(boolean checkable) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public android.view.MenuItem setChecked(boolean checked) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public android.view.MenuItem setEnabled(boolean enabled) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public android.view.MenuItem setIcon(Drawable icon) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public android.view.MenuItem setIcon(int iconRes) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public android.view.MenuItem setIntent(Intent intent) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public android.view.MenuItem setNumericShortcut(char numericChar) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public android.view.MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public android.view.MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public android.view.MenuItem setShortcut(char numericChar, char alphaChar) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void setShowAsAction(int actionEnum) {
                // TODO Auto-generated method stub

            }

            @Override
            public android.view.MenuItem setShowAsActionFlags(int actionEnum) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public android.view.MenuItem setTitle(CharSequence title) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public android.view.MenuItem setTitle(int title) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public android.view.MenuItem setTitleCondensed(CharSequence title) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public android.view.MenuItem setVisible(boolean visible) {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        EasyTracker.getInstance().activityStart(this); // Add this method.
    }

    @Override
    public void onStop() {
        super.onStop();
        EasyTracker.getInstance().activityStop(this); // Add this method.
    }

}

