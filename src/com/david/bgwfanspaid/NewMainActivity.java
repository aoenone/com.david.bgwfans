package com.david.bgwfanspaid;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.MenuItem;
import com.crittercism.app.Crittercism;
import com.david.bgwfanspaid.fragments.About;
import com.david.bgwfanspaid.fragments.AttractionsView;
import com.david.bgwfanspaid.fragments.BGWFans;
import com.david.bgwfanspaid.fragments.Eateries;
import com.david.bgwfanspaid.fragments.Forums;
import com.david.bgwfanspaid.fragments.InfoScreen;
import com.david.bgwfanspaid.fragments.ParkMap;
import com.david.bgwfanspaid.fragments.Settings;
import com.david.bgwfanspaid.fragments.UserNoLogin;
import com.david.bgwfanspaid.geofence.GeofenceRemover;
import com.david.bgwfanspaid.geofence.GeofenceRequester;
import com.david.bgwfanspaid.geofence.GeofenceStore;
import com.david.bgwfanspaid.geofence.GeofenceUtils;
import com.david.bgwfanspaid.geofence.ParkGeofence;
import com.david.bgwfanspaid.hos.HOSHouses;
import com.david.bgwfanspaid.hos.HOSMap;
import com.david.bgwfanspaid.hos.HOS_Culinary;
import com.david.bgwfanspaid.hos.HOS_Shows;
import com.david.bgwfanspaid.hos.HOS_TERROR;
import com.david.bgwfanspaid.hos.HosShows;
import com.david.bgwfanspaid.geofence.GeofenceUtils.REMOVE_TYPE;
import com.david.bgwfanspaid.geofence.GeofenceUtils.REQUEST_TYPE;
import com.david.bgwfanspaid.viewcomponents.NavigationDrawerItem;
import com.david.bgwfanspaid.webviews.Wiki;
import com.david.bgwfanspaid.xmas.fragments.XmasAttractions;
import com.david.bgwfanspaid.xmas.fragments.XmasFood;
import com.david.bgwfanspaid.xmas.fragments.XmasInfoFragment;
import com.david.bgwfanspaid.xmas.fragments.XmasMap;
import com.david.bgwfanspaid.xmas.fragments.XmasShows;
import com.david.bgwfanspaid.xmas.fragments.XmasSiteFragment;
import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockFragmentActivity;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.Geofence;
import roboguice.RoboGuice;
import roboguice.inject.InjectView;
import roboguice.inject.RoboInjector;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by david.hodge on 6/27/13.
 */
public class NewMainActivity extends RoboSherlockFragmentActivity {

    //when card ui breaks, remove backgrounds, change all paddings
    //for bgw shit
    public static final int NAV_ID_INFO_SCREEN = R.id.drawer_info_screen;
    public static final int NAV_ID_ATTRACTIONS = R.id.drawer_attractions;
    public static final int NAV_ID_SHOWS = R.id.drawer_shows;
    public static final int NAV_ID_EATERIES = R.id.drawer_eateries;
    public static final int NAV_ID_MAP = R.id.drawer_map;

    //for HOS shit
    public static final int NAV_HOS_INFO = R.id.drawer_hos_info;
    public static final int NAV_HOS_HOUSES = R.id.drawer_hos_houses;
    public static final int NAV_HOS_SHOWS = R.id.drawer_hos_shows;
//    public static final int NAV_HOS_CULINARY = R.id.drawer_hos_food;
//    public static final int NAV_HOS_EXP = R.id.drawer_hos_exp;
    public static final int NAV_EVENT_SITE = R.id.drawer_event_site;
    public static final int NAV_HOS_MAP = R.id.drawer_hos_map;

    //for BGWFans shit
    public static final int NAV_ID_BLOG = R.id.drawer_blog;
    public static final int NAV_ID_FORUMS = R.id.drawer_forums;
    public static final int NAV_ID_WIKI = R.id.drawer_wiki;

    //for extra app shit
    public static final int NAV_ID_SETTINGS = R.id.drawer_settings;
    public static final int NAV_ID_ABOUT = R.id.drawer_about;


   @InjectView(R.id.drawer_root) DrawerLayout mDrawerLayout;
   @InjectView (R.id.fragment_container) FrameLayout mContent;

    //Used for future User profile. will add back in once complete
//   @InjectView (R.id.drawer_user_profile) RelativeLayout userProfile;

    ActionBarDrawerToggle mActionBarDrawerToggle;
    FragmentManager mfragmentManager;
    NavigationDrawerItem currentNavigationDrawerItem;
    Context mContext;
    FragmentTransaction ft;

    /*
     * Use to set an expiration time for a geofence. After this amount
     * of time Location Services will stop tracking the geofence.
     * Remember to unregister a geofence when you're finished with it.
     * Otherwise, your app will use up battery. To continue monitoring
     * a geofence indefinitely, set the expiration time to
     * Geofence#NEVER_EXPIRE.
     */
    private static final long GEOFENCE_EXPIRATION_IN_HOURS = 6;
    private static final long GEOFENCE_EXPIRATION_IN_MILLISECONDS =
            GEOFENCE_EXPIRATION_IN_HOURS * DateUtils.HOUR_IN_MILLIS;

    // Store the current request
    private REQUEST_TYPE mRequestType;

    // Store the current type of removal
    private REMOVE_TYPE mRemoveType;

    // Persistent storage for geofences
    private GeofenceStore mPrefs;

    // Store a list of geofences to add
    List<Geofence> mCurrentGeofences;

    // Add geofences handler
    private GeofenceRequester mGeofenceRequester;
    // Remove geofences handler
    private GeofenceRemover mGeofenceRemover;
    // Handle to geofence 1 latitude in the UI
    private EditText mLatitude1;

    // Handle to geofence 1 longitude in the UI
    private EditText mLongitude1;

    // Handle to geofence 1 radius in the UI
    private EditText mRadius1;

    // Handle to geofence 2 latitude in the UI
    private EditText mLatitude2;

    // Handle to geofence 2 longitude in the UI
    private EditText mLongitude2;

    // Handle to geofence 2 radius in the UI
    private EditText mRadius2;

    /*
     * Internal lightweight geofence objects for geofence 1 and 2
     */
    private ParkGeofence mUIGeofence1;
    private ParkGeofence mUIGeofence2;
    private ParkGeofence mUIGeofence3;
    ParkGeofence mUIGeofence4;


    // decimal formats for latitude, longitude, and radius
    private DecimalFormat mLatLngFormat;
    private DecimalFormat mRadiusFormat;

    /*
     * An instance of an inner class that receives broadcasts from listeners and from the
     * IntentService that receives geofence transition events
     */
    private GeofenceSampleReceiver mBroadcastReceiver;

    // An intent filter for the broadcast receiver
    private IntentFilter mIntentFilter;

    // Store the list of geofences to remove
    private List<String> mGeofenceIdsToRemove;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Crittercism.initialize(getApplicationContext(), "522b49fe558d6a77d3000001");
        setContentView(R.layout.app_main);
        mContext = this;
        mfragmentManager = getSupportFragmentManager();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setIcon(android.R.color.transparent);

        if(savedInstanceState == null){
            setContentFragment(NAV_ID_INFO_SCREEN);
        }

//        userProfile.setOnClickListener(new View.OnClickListener() {
//                userProfileClick();
//        });

        setUpGeofenceBuilders();
        onRegisterClicked();

        initDrawerLayout();
    }

    public void userProfileClick(){
                RoboInjector injector = RoboGuice.getInjector(NewMainActivity.this);
                Fragment fragment;
                fragment = injector.getInstance(UserNoLogin.class);

                ft = mfragmentManager.beginTransaction();
                ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                ft.replace(R.id.fragment_container, fragment).addToBackStack("tag");
                ft.addToBackStack(null);
                ft.commit();
                mDrawerLayout.closeDrawers();
    }

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
                fragment = injector.getInstance(InfoScreen.class);
                break;
            case NAV_ID_ATTRACTIONS:
                fragment = injector.getInstance(AttractionsView.class);
                break;
            case NAV_ID_SHOWS:
                fragment = injector.getInstance(HOS_Shows.class);
                break;
            case NAV_ID_EATERIES:
                fragment = injector.getInstance(Eateries.class);
                break;
            case NAV_ID_MAP:
                fragment = injector.getInstance(ParkMap.class);
                break;
            case NAV_HOS_INFO:
                fragment = injector.getInstance(XmasInfoFragment.class);
                break;
            case NAV_HOS_HOUSES:
                fragment = injector.getInstance(XmasAttractions.class);
                break;
            case NAV_HOS_SHOWS:
                fragment = injector.getInstance(XmasShows.class);
                break;
//            case NAV_HOS_CULINARY:
//                fragment = injector.getInstance(XmasFood.class);
//                break;
            case NAV_EVENT_SITE:
                fragment = injector.getInstance(XmasSiteFragment.class);
                break;
            case NAV_HOS_MAP:
                fragment = injector.getInstance(XmasMap.class);
                break;
            case NAV_ID_BLOG:
                fragment = injector.getInstance(BGWFans.class);
                break;
            case NAV_ID_FORUMS:
                fragment = injector.getInstance(Forums.class);
                break;
            case NAV_ID_WIKI:
                fragment = injector.getInstance(Wiki.class);
                break;
            case NAV_ID_SETTINGS:
                fragment = injector.getInstance(Settings.class);
                break;
            case NAV_ID_ABOUT:
                fragment = injector.getInstance(About.class);
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

    public void setUpGeofenceBuilders(){
        // Set the pattern for the latitude and longitude format
        String latLngPattern = getString(R.string.lat_lng_pattern);

        // Set the format for latitude and longitude
        mLatLngFormat = new DecimalFormat(latLngPattern);

        // Localize the format
        mLatLngFormat.applyLocalizedPattern(mLatLngFormat.toLocalizedPattern());

        // Set the pattern for the radius format
        String radiusPattern = getString(R.string.radius_pattern);

        // Set the format for the radius
        mRadiusFormat = new DecimalFormat(radiusPattern);

        // Localize the pattern
        mRadiusFormat.applyLocalizedPattern(mRadiusFormat.toLocalizedPattern());

        // Create a new broadcast receiver to receive updates from the listeners and service
        mBroadcastReceiver = new GeofenceSampleReceiver();

        // Create an intent filter for the broadcast receiver
        mIntentFilter = new IntentFilter();

        // Action for broadcast Intents that report successful addition of geofences
        mIntentFilter.addAction(GeofenceUtils.ACTION_GEOFENCES_ADDED);

        // Action for broadcast Intents that report successful removal of geofences
        mIntentFilter.addAction(GeofenceUtils.ACTION_GEOFENCES_REMOVED);

        // Action for broadcast Intents containing various types of geofencing errors
        mIntentFilter.addAction(GeofenceUtils.ACTION_GEOFENCE_ERROR);

        // All Location Services sample apps use this category
        mIntentFilter.addCategory(GeofenceUtils.CATEGORY_LOCATION_SERVICES);

        // Instantiate a new geofence storage area
        mPrefs = new GeofenceStore(this);

        // Instantiate the current List of geofences
        mCurrentGeofences = new ArrayList<Geofence>();

        // Instantiate a Geofence requester
        mGeofenceRequester = new GeofenceRequester(this);

        // Instantiate a Geofence remover
        mGeofenceRemover = new GeofenceRemover(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Register the broadcast receiver to receive status updates
        LocalBroadcastManager.getInstance(this).registerReceiver(mBroadcastReceiver, mIntentFilter);
        /*
         * Get existing geofences from the latitude, longitude, and
         * radius values stored in SharedPreferences. If no values
         * exist, null is returned.
         */
//        mUIGeofence1 = mPrefs.getGeofence("1");
//        mUIGeofence2 = mPrefs.getGeofence("2");
//        mUIGeofence3 = mPrefs.getGeofence("3");
//        mUIGeofence4 = mPrefs.getGeofence("4");
    }

    @Override
    protected void onPause() {
        super.onPause();
//        mPrefs.setGeofence("1", mUIGeofence1);
//        mPrefs.setGeofence("2", mUIGeofence2);
//        mPrefs.setGeofence("3", mUIGeofence3);
//        mPrefs.setGeofence("4", mUIGeofence4);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        // Choose what to do based on the request code
        switch (requestCode) {

            // If the request code matches the code sent in onConnectionFailed
            case GeofenceUtils.CONNECTION_FAILURE_RESOLUTION_REQUEST :

                switch (resultCode) {
                    // If Google Play services resolved the problem
                    case Activity.RESULT_OK:

                        // If the request was to add geofences
                        if (GeofenceUtils.REQUEST_TYPE.ADD == mRequestType) {

                            // Toggle the request flag and send a new request
                            mGeofenceRequester.setInProgressFlag(false);

                            // Restart the process of adding the current geofences
                            mGeofenceRequester.addGeofences(mCurrentGeofences);

                            // If the request was to remove geofences
                        } else if (GeofenceUtils.REQUEST_TYPE.REMOVE == mRequestType ){

                            // Toggle the removal flag and send a new removal request
                            mGeofenceRemover.setInProgressFlag(false);

                            // If the removal was by Intent
                            if (GeofenceUtils.REMOVE_TYPE.INTENT == mRemoveType) {

                                // Restart the removal of all geofences for the PendingIntent
                                mGeofenceRemover.removeGeofencesByIntent(
                                        mGeofenceRequester.getRequestPendingIntent());

                                // If the removal was by a List of geofence IDs
                            } else {

                                // Restart the removal of the geofence list
                                mGeofenceRemover.removeGeofencesById(mGeofenceIdsToRemove);
                            }
                        }
                        break;

                    // If any other result was returned by Google Play services
                    default:

                        // Report that Google Play services was unable to resolve the problem.
                        Log.d(GeofenceUtils.APPTAG, getString(R.string.no_resolution));
                }

                // If any other request code was received
            default:
                // Report that this Activity received an unknown requestCode
                Log.d(GeofenceUtils.APPTAG,
                        getString(R.string.unknown_activity_request_code, requestCode));

                break;
        }
    }

    /**
     * Called when the user clicks the "Register geofences" button.
     * Get the geofence parameters for each geofence and add them to
     * a List. Create the PendingIntent containing an Intent that
     * Location Services sends to this app's broadcast receiver when
     * Location Services detects a geofence transition. Send the List
     * and the PendingIntent to Location Services.
     */
    public void onRegisterClicked() {

        /*
         * Record the request as an ADD. If a connection error occurs,
         * the app can automatically restart the add request if Google Play services
         * can fix the error
         */
        mRequestType = GeofenceUtils.REQUEST_TYPE.ADD;

        /*
         * Check for Google Play services. Do this after
         * setting the request type. If connecting to Google Play services
         * fails, onActivityResult is eventually called, and it needs to
         * know what type of request was in progress.
         */
        if (!servicesConnected()) {

            return;
        }

        /*
         * Create a version of geofence 1 that is "flattened" into individual fields. This
         * allows it to be stored in SharedPreferences.
         */
        //Setting up Demon Street geofence
        mUIGeofence1 = new ParkGeofence(
                "1",
                // Get latitude, longitude, and radius from the UI
                37.234384,
                -76.648724,
                60,
                // Set the expiration time
                GEOFENCE_EXPIRATION_IN_MILLISECONDS,
                // Only detect entry transitions
                Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT);

        // Store this flat version in SharedPreferences
        mPrefs.setGeofence("1", mUIGeofence1);


        /*
         * Create a version of geofence 2 that is "flattened" into individual fields. This
         * allows it to be stored in SharedPreferences.
         */
        //Setting up Port of Skulls geofence
        mUIGeofence2 = new ParkGeofence(
                "2",
                // Get latitude, longitude, and radius from the UI
//                38.0354832,
//                -78.44585660000001,
                37.23461,
                -76.643638,
                80,
                // Set the expiration time
                GEOFENCE_EXPIRATION_IN_MILLISECONDS,
                // Detect both entry and exit transitions
                Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT
        );
        // Store this flat version in SharedPreferences
        mPrefs.setGeofence("2", mUIGeofence2);

        //set up ripper row geofence
        mUIGeofence3 = new ParkGeofence(
                "3",
                // Get latitude, longitude, and radius from the UI
//                38.0354832,
//                -78.44585660000001,
                37.236167,
                -76.645904,
                60,
                // Set the expiration time
                GEOFENCE_EXPIRATION_IN_MILLISECONDS,
                // Detect both entry and exit transitions
                Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT
        );
        // Store this flat version in SharedPreferences
        mPrefs.setGeofence("3", mUIGeofence3);

        //set up vampire point geofence
        mUIGeofence4 = new ParkGeofence(
                "4",
                // Get latitude, longitude, and radius from the UI
                37.232972,
                -76.64662,
                80,
                // Set the expiration time
                GEOFENCE_EXPIRATION_IN_MILLISECONDS,
                // Detect both entry and exit transitions
                Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT
        );
        // Store this flat version in SharedPreferences
        mPrefs.setGeofence("4", mUIGeofence4);


        /*
         * Add Geofence objects to a List. toGeofence()
         * creates a Location Services Geofence object from a
         * flat object
         */
        mCurrentGeofences.add(mUIGeofence1.toGeofence());
        mCurrentGeofences.add(mUIGeofence2.toGeofence());
        mCurrentGeofences.add(mUIGeofence3.toGeofence());
        mCurrentGeofences.add(mUIGeofence4.toGeofence());

        // Start the request. Fail if there's already a request in progress
        try {
            // Try to add geofences
            mGeofenceRequester.addGeofences(mCurrentGeofences);
        } catch (UnsupportedOperationException e) {
            // Notify user that previous request hasn't finished.
            Toast.makeText(this, R.string.add_geofences_already_requested_error,
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Verify that Google Play services is available before making a request.
     *
     * @return true if Google Play services is available, otherwise false
     */
    private boolean servicesConnected() {

        // Check that Google Play services is available
        int resultCode =
                GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);

        // If Google Play services is available
        if (ConnectionResult.SUCCESS == resultCode) {

            // In debug mode, log the status
            Log.d(GeofenceUtils.APPTAG, getString(R.string.play_services_available));

            // Continue
            return true;

            // Google Play services was not available for some reason
        } else {

            // Display an error dialog
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(resultCode, this, 0);
            if (dialog != null) {
                ErrorDialogFragment errorFragment = new ErrorDialogFragment();
                errorFragment.setDialog(dialog);
                errorFragment.show(getSupportFragmentManager(), GeofenceUtils.APPTAG);
            }
            return false;
        }
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


    /**
     * Define a Broadcast receiver that receives updates from connection listeners and
     * the geofence transition service.
     */
    public class GeofenceSampleReceiver extends BroadcastReceiver {
        /*
         * Define the required method for broadcast receivers
         * This method is invoked when a broadcast Intent triggers the receiver
         */
        @Override
        public void onReceive(Context context, Intent intent) {

            // Check the action code and determine what to do
            String action = intent.getAction();

            // Intent contains information about errors in adding or removing geofences
            if (TextUtils.equals(action, GeofenceUtils.ACTION_GEOFENCE_ERROR)) {

                handleGeofenceError(context, intent);

                // Intent contains information about successful addition or removal of geofences
            } else if (
                    TextUtils.equals(action, GeofenceUtils.ACTION_GEOFENCES_ADDED)
                            ||
                            TextUtils.equals(action, GeofenceUtils.ACTION_GEOFENCES_REMOVED)) {

                handleGeofenceStatus(context, intent);

                // Intent contains information about a geofence transition
            } else if (TextUtils.equals(action, GeofenceUtils.ACTION_GEOFENCE_TRANSITION)) {

                handleGeofenceTransition(context, intent);

                // The Intent contained an invalid action
            } else {
                Log.e(GeofenceUtils.APPTAG, getString(R.string.invalid_action_detail, action));
                Toast.makeText(context, R.string.invalid_action, Toast.LENGTH_LONG).show();
            }
        }

        /**
         * If you want to display a UI message about adding or removing geofences, put it here.
         *
         * @param context A Context for this component
         * @param intent The received broadcast Intent
         */
        private void handleGeofenceStatus(Context context, Intent intent) {

        }

        /**
         * Report geofence transitions to the UI
         *
         * @param context A Context for this component
         * @param intent The Intent containing the transition
         */
        private void handleGeofenceTransition(Context context, Intent intent) {
            /*
             * If you want to change the UI when a transition occurs, put the code
             * here. The current design of the app uses a notification to inform the
             * user that a transition has occurred.
             */
        }

        /**
         * Report addition or removal errors to the UI, using a Toast
         *
         * @param intent A broadcast Intent sent by ReceiveTransitionsIntentService
         */
        private void handleGeofenceError(Context context, Intent intent) {
            String msg = intent.getStringExtra(GeofenceUtils.EXTRA_GEOFENCE_STATUS);
            Log.e(GeofenceUtils.APPTAG, msg);
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        }
    }
    /**
     * Define a DialogFragment to display the error dialog generated in
     * showErrorDialog.
     */
    public static class ErrorDialogFragment extends DialogFragment {

        // Global field to contain the error dialog
        private Dialog mDialog;

        /**
         * Default constructor. Sets the dialog field to null
         */
        public ErrorDialogFragment() {
            super();
            mDialog = null;
        }

        /**
         * Set the dialog to display
         *
         * @param dialog An error dialog
         */
        public void setDialog(Dialog dialog) {
            mDialog = dialog;
        }

        /*
         * This method must return a Dialog to the DialogFragment.
         */
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return mDialog;
        }
    }

}
