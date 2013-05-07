package com.david.bgwfans;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class EventMap extends BaseActivity {
	public static final LatLng Austria = new LatLng(37.233181, -76.646596);
	private Marker austria;
	public static final LatLng Canada = new LatLng(37.233305,-76.648709);
	private Marker canada;
	public static final LatLng France = new LatLng(37.234377, -76.648736);
	private Marker france;
	public static final LatLng Belgium = new LatLng(37.234228,-76.648505);
	private Marker belgium;
	public static final LatLng Greece = new LatLng(37.235778,-76.644562);
	private Marker greece;
	public static final LatLng Italy = new LatLng(37.233677,-76.644332);
	private Marker italy;
	public static final LatLng Scandianvia = new LatLng(37.235983,-76.647475);
	private Marker scandinavia;
	public static final LatLng Scotland = new LatLng(37.235232,-76.646102);
	private Marker scotland;
	public static final LatLng Spain = new LatLng(37.234275,-76.643752);
	private Marker spain;
	public static final LatLng Germany = new LatLng(37.231582, -76.646244);
	private Marker germany;
	
	static final CameraPosition HOME =
	            new CameraPosition.Builder().target(new LatLng(37.235466, -76.646328))
	                    .zoom(16)
	                    .bearing(0)
	                    .tilt(25)
	                    .build();
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapv2);
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
	
	private void setUpMap(){
		mMap.setMyLocationEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(HOME));
        setUpPoints();
	}
	
	@Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

	
	private void setUpPoints()
	{
		austria = mMap.addMarker(new MarkerOptions()
				.position(Austria)
				.title("Austia"));
		
		canada = mMap.addMarker(new MarkerOptions()
				.position(Canada)
				.title("Canada"));
		
		france = mMap.addMarker(new MarkerOptions()
				.position(France)
				.title("France"));
		
		belgium = mMap.addMarker(new MarkerOptions()
				.position(Belgium)
				.title("Belgium"));
		
		greece = mMap.addMarker(new MarkerOptions()
				.position(Greece)
				.title("Greece"));
		
		italy = mMap.addMarker(new MarkerOptions()
				.position(Italy)
				.title("Italy"));
		
		scandinavia = mMap.addMarker(new MarkerOptions()
				.position(Scandianvia)
				.title("Scandinavia"));
		
		scotland = mMap.addMarker(new MarkerOptions()
				.position(Scotland)
				.title("Scotland"));
		
		spain = mMap.addMarker(new MarkerOptions()
				.position(Spain)
				.title("Spain"));
		
		germany = mMap.addMarker(new MarkerOptions()
				.position(Germany)
				.title("Germany"));
		
	}
}
