package com.david.bgwfanspaid;


import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;

import com.actionbarsherlock.view.MenuItem;
import com.david.bgwfanspaid.hos.HOS_Shows;
import com.google.android.gms.maps.GoogleMap;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.SlidingMenu.OnOpenedListener;
import com.slidingmenu.lib.app.SlidingActivityHelper;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

public class BaseActivity extends SlidingFragmentActivity implements View.OnClickListener {


    public GoogleMap mMap;
    private SlidingActivityHelper mHelper;
    private Fragment mFrag;
    public SlidingMenu sm;

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.item1) {
            Intent infoActivity = new Intent(this, InfoScreen.class);
            toggle();
            startActivity(infoActivity);
        } else if (id == R.id.item2) {
            Intent attrActivity = new Intent(this, Attractions.class);
            toggle();
            startActivity(attrActivity);
        } else if (id == R.id.item3) {
            Intent showsActivity = new Intent(this, HOS_Shows.class);
            startActivity(showsActivity);
            toggle();
        } else if (id == R.id.item4) {
            Intent eatActivity = new Intent(this, Eateries.class);
            startActivity(eatActivity);
            toggle();
        } else if (id == R.id.item5) {
            Intent mapActivity = new Intent(this, ParkMap.class);
            startActivity(mapActivity);
            toggle();
        } else if (id == R.id.item9) {
            Intent blogActivity = new Intent(this, BGWFans.class);
            startActivity(blogActivity);
            toggle();
        } else if (id == R.id.item10) {
            Intent forumActivity = new Intent(this, Forums.class);
            startActivity(forumActivity);
            toggle();
        } else if (id == R.id.item11) {
            Intent wikiActivity = new Intent(this, Wiki.class);
            startActivity(wikiActivity);
            toggle();
        } else if (id == R.id.item12) {
            Intent settingsActivity = new Intent(this, Settings.class);
            startActivity(settingsActivity);
            toggle();
        } else if (id == R.id.item13) {
            Intent aboutActivity = new Intent(this, About.class);
            startActivity(aboutActivity);
            toggle();
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.DrawerTheme);
        //setTitle(mTitleRes);
        // set the Behind View
        setBehindContentView(R.layout.menu_scrollview);

        final ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        // customize the SlidingMenu
        sm = getSlidingMenu();
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        sm.setMode(SlidingMenu.LEFT);
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        sm.setShadowDrawable(R.drawable.shadow);
        sm.setShadowWidthRes(R.dimen.shadow_width);
        sm.setShadowWidthRes(R.dimen.shadow_width);
        sm.setFadeEnabled(true);
        sm.setFadeEnabled(true);
        sm.setFadeDegree(0.95f);
        //sm.setSecondaryMenu(R.layout.sidemenumap);
        //sm.setSecondaryShadowDrawable(R.drawable.shadowright);
        sm.setBackgroundColor(0x000000000);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getSlidingMenu().setOnOpenedListener(new OnOpenedListener() {
            public void onOpened() {
                getSlidingMenu().invalidate();
                //mMap.setMyLocationEnabled(true);
            }
        });


        findViewById(R.id.item1).setOnClickListener(this);
        findViewById(R.id.item2).setOnClickListener(this);
        findViewById(R.id.item3).setOnClickListener(this);
        findViewById(R.id.item4).setOnClickListener(this);
        findViewById(R.id.item5).setOnClickListener(this);
        findViewById(R.id.item9).setOnClickListener(this);
        findViewById(R.id.item10).setOnClickListener(this);
        findViewById(R.id.item11).setOnClickListener(this);
        findViewById(R.id.item12).setOnClickListener(this);
        findViewById(R.id.item13).setOnClickListener(this);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            //Put the code for an action menu from the top here
            toggle();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    /**
     * public boolean onCreateOptionsMenu(android.view.Menu menu) {
     * super.onCreateOptionsMenu(menu);
     * MenuInflater inflater = getMenuInflater();
     * inflater.inflate(R.menu.sidemapmenu, menu);
     * return true;
     * } *
     */


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                sm.toggle();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }
}

