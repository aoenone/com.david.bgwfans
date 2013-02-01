package com.david.bgwfans;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class Verbolten extends android.support.v4.app.FragmentActivity implements View.OnClickListener {
	private GoogleMap mMap;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.vbolt2);
	setUpMapIfNeeded();
	
	ActionBar actionbar = getActionBar();
    actionbar.setDisplayShowTitleEnabled(false);
    actionbar.setDisplayHomeAsUpEnabled(true);

    /** mapView = (PolarisMapView) findViewById(R.id.vmapview);
    //mapView = new PolarisMapView (this, mapApiKey);
    //vmapView.addView(vmapView);
    //setContentView(vmapView);
	//vmapView.setSatellite(true);
	//removeView();
    List<Overlay> mapOverlays = mapView.getOverlays();
    Drawable drawable = this.getResources().getDrawable(R.drawable.maps_icon2);
    HelloItemizedOverlay itemizedoverlay = new HelloItemizedOverlay(drawable,this);
    GeoPoint point = new GeoPoint((int)(37.232443*1E6),(int)(-76.645534*1E6));
    OverlayItem overlayitem = new OverlayItem(point, "Verbolten", "Brave the Balck forest!");
    //OverlayItem overlayitem = new OverlayItem(point, Verbolten.class, null);
    itemizedoverlay.addOverlay(overlayitem);
    mapOverlays.add(itemizedoverlay);
	
	
	//GeoPoint point25 = new GeoPoint((int)(37.236556*1E6),(int)(-76.646473*1E6));
	//CustomOverlayItem overlayItem25 = new CustomOverlayItem(point25, "Roaming Hordes", 
	///"(Busch Gardens' path ways are taken over by roaming minions from your deepest fears)", null);		
	//itemizedOverlay7.addOverlay(overlayItem25);
	
	//mapOverlays = vmapView.getOverlays();
	MapController mapController = mapView.getController();
	mapController.animateTo(point);
	//mapView.invalidate();
	mapController.setZoom(19); **/
    
    //Typeface rt = Typeface.createFromAsset(getAssets(),
    //        "fonts/Roboto-Thin.ttf");
    //TextView attr = (TextView) findViewById(R.id.attr);
    //TextView wiki = (TextView) findViewById(R.id.wiki);
    //attr.setTypeface(rt);
    //wiki.setTypeface(rt);
    
}
	
	@Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }
	
	private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }
	
	private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(37.232449, -76.645534)).title("Brave the Black Forest!"));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
