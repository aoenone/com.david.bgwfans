package com.david.bgtfans.bgt.fragments;

import android.os.Bundle;
import android.support.v4.app.NavUtils;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.MenuItem;

/**
 * Created by david.hodge on 2/9/14.
 */
public abstract class BaseFragment extends SherlockFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTitle();
    }

    @Override
    public void onResume() {
        super.onResume();
        setTitle();
    }

    protected void setTitle(){
        if (getActivity()!=null){
            getActivity().setTitle(getTitleResourceId());
            getSherlockActivity().getSupportActionBar().setTitle(getTitleResourceId());
        }
    }

    public abstract int getTitleResourceId();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // This ID represents the Home or Up button. In the case of this
                // activity, the Up button is shown. Use NavUtils to allow users
                // to navigate up one level in the application structure. For
                // more details, see the Navigation pattern on Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back
                //
                NavUtils.navigateUpFromSameTask(getActivity());
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
