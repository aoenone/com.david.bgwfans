package com.david.bgtfans;

import android.os.Bundle;

import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockFragmentActivity;

/**
 * Created by david.hodge on 1/7/14.
 */
public class BaseAttractionActivity extends RoboSherlockFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main);
    }
}
