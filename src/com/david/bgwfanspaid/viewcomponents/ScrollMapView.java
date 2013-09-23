package com.david.bgwfanspaid.viewcomponents;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;

/**
 * Created by david.hodge on 6/13/13.
 */
public class ScrollMapView extends MapView {

    private float mCurrX = 0.0f;
    private float mCurrY = 0.0f;
    private float mStartX, mStartY;

    public ScrollMapView (Context context, GoogleMapOptions options){
        super(context, options);
    }

    public ScrollMapView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public ScrollMapView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        super.onInterceptTouchEvent(event);
        final int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            mCurrX = event.getX();
            mCurrY = event.getY();
            mStartX = event.getX();
            mStartY = event.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (Math.abs(event.getY() - mStartY) > Math.abs(event.getX() - mStartX)) {
            // User scrolled vertically
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == MotionEvent.ACTION_MOVE) {
            // Shouldn't need to do anything
        } else if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(event);
    }
}
