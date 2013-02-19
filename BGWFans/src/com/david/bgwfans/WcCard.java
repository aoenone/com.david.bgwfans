package com.david.bgwfans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.fima.cardsui.objects.Card;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.support.v4.app.Fragment;

public class WcCard extends Card {

	private GoogleMap mMap;
	
	static final CameraPosition WCUSA =
            new CameraPosition.Builder().target(new LatLng(37.264849, -76.640051))
                    .zoom(17)
                    .bearing(0)
                    .tilt(25)
                    .build();
	
	public WcCard(String title){
		super(title);
	}


	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.wccard, null);

		((TextView) view.findViewById(R.id.title)).setText(title);
		setUpMapIfNeeded();
		return view;
		
	}
	
	private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            if (mMap != null) {
                setUpMap();
            }
        }
    }

	private void setUpMap() {
		 
		 	mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			mMap.getUiSettings().setZoomControlsEnabled(false);
			mMap.moveCamera(CameraUpdateFactory.newCameraPosition(WCUSA));
	    }

	
	
	
}
