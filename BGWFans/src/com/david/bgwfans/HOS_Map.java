package com.david.bgwfans;

import java.util.List;
import net.simonvt.widget.MenuDrawer;
import net.simonvt.widget.MenuDrawerManager;
import android.app.ActionBar;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.readystatesoftware.maps.OnSingleTapListener;
import com.readystatesoftware.maps.TapControlledMapView;

public class HOS_Map<MapListener> extends MapActivity implements View.OnClickListener, LocationListener {

		List<Overlay> mapOverlays;
		Drawable drawable;
		Drawable drawable2;
		Drawable drawable3;
		Drawable drawable4;
		Drawable drawable5;
		Drawable drawable6;
		Drawable drawable7;
		Drawable drawable8;
		CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay;
		CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay2;
		CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay3;
		CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay4;
		CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay5;
		CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay6;
		CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay7;
		CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay8;
		TapControlledMapView mapView; // use the custom TapControlledMapView
		private MenuDrawerManager mMenuDrawer;
		private Context c;
		private LocationListener locationListener;
		private LocationManager locManager;
		private MapController mapController;
		private MyLocationOverlay myLocationOverlay;
		private MapListener listener;
		GeoPoint pointLoc;
		GeoPoint point15;
		
		
		@Override
	    public void onCreate(Bundle savedInstanceState) {
			
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.hos_map);
	        //setupListener();
	        //mapView.invalidate();
	        ActionBar actionbar = getActionBar();
	        actionbar.setDisplayShowTitleEnabled(false);
			actionbar.setListNavigationCallbacks(null, null);
	        actionbar.setDisplayHomeAsUpEnabled(true);
	        createNavigation();
	        
	        mMenuDrawer = new MenuDrawerManager(this, MenuDrawer.MENU_DRAG_WINDOW);
	        //mMenuDrawer.setContentView(R.layout.activity_windowsample);
	        mMenuDrawer.setMenuView(R.layout.menu_scrollview);

	        MenuScrollView msv = (MenuScrollView) mMenuDrawer.getMenuView();
	        msv.setOnScrollChangedListener(new MenuScrollView.OnScrollChangedListener() {
	            public void onScrollChanged() {
	                mMenuDrawer.getMenuDrawer().invalidate();
	            }
	        });
	       
	       // locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	       // LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
	       // Location location = locationManager.getLastKnownLocation(provider);
	       // boolean enabled = service
	       // 		.isProviderEnabled(LocationManager.GPS_PROVIDER);
	       // if (!enabled){
	       // 	Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
	       // 	startActivity(intent);
	       // }
	        //if (locaManager == null) {
	        //    Toast.makeText(HOS_Map.this,
	        //            "Location Manager Not Available", Toast.LENGTH_SHORT)
	        //            .show();
	        //   return;
	       //}
	      // myLocation = new MyLocationOverlay(this, mapView);
	      // ((MapView) mapOverlays).getOverlays().add(myLocation);
	      // mapView.postInvalidate();
	        
	        mapView = (TapControlledMapView) findViewById(R.id.mapview);
			mapView.setSatellite(true);
			
			mapView.setOnSingleTapListener(new OnSingleTapListener() {		
				public boolean onSingleTap(MotionEvent e) {
					itemizedOverlay5.hideAllBalloons();
					itemizedOverlay6.hideAllBalloons();
					itemizedOverlay7.hideAllBalloons();
					return true;
				}
			});
			
			mapOverlays = mapView.getOverlays();
			
			//HOS Houses markers
			drawable5 = getResources().getDrawable(R.drawable.hos_marker);
			itemizedOverlay5 = new CustomItemizedOverlay<CustomOverlayItem>(drawable5, mapView);
			
			GeoPoint point15 = new GeoPoint((int)(37.23629715622509*1E6),(int)(-76.64818346500397*1E6));
			CustomOverlayItem overlayItem15 = new CustomOverlayItem(point15, "13: Your Number's up", 
					"(Is your number up?)", null);		
			itemizedOverlay5.addOverlay(overlayItem15);
			
			GeoPoint point16 = new GeoPoint((int)(37.2309489*1E6),(int)(-76.645898*1E6));
			CustomOverlayItem overlayItem16 = new CustomOverlayItem(point16, "Bitten", 
					"(Full of legends and lore of vampires)", null);		
			itemizedOverlay5.addOverlay(overlayItem16);
			
			GeoPoint point17 = new GeoPoint((int)(37.234301*1E6),(int)(-76.641639*1E6));
			CustomOverlayItem overlayItem17 = new CustomOverlayItem(point17, "Fear Fair", 
					"(a traveling carnival is waiting..)", null);		
			itemizedOverlay5.addOverlay(overlayItem17);
			
			GeoPoint point18 = new GeoPoint((int)(37.235612*1E6),(int)(-76.644788*1E6));
			CustomOverlayItem overlayItem18 = new CustomOverlayItem(point18, "Dead Line", 
					"(The Dead line is off the grid)", null);		
			itemizedOverlay5.addOverlay(overlayItem18);
			
			GeoPoint point19 = new GeoPoint((int)(37.234629*1E6),(int)(-76.648988*1E6));
			CustomOverlayItem overlayItem19 = new CustomOverlayItem(point19, "Catacombs", 
					"(Tunnel that leads to an underground city)", null);		
			itemizedOverlay5.addOverlay(overlayItem19);
			
			GeoPoint point20 = new GeoPoint((int)(37.232807*1E6),(int)(-76.646577*1E6));
			CustomOverlayItem overlayItem20 = new CustomOverlayItem(point20, "Root of All Evil", 
					"(The seeds of evil have been sewn)", null);		
			itemizedOverlay5.addOverlay(overlayItem20);
			
			mapOverlays.add(itemizedOverlay5);
			
			
			//HOS shows
			drawable6 = getResources().getDrawable(R.drawable.hos_marker);
			itemizedOverlay6 = new CustomItemizedOverlay<CustomOverlayItem>(drawable6, mapView);
			
			GeoPoint point21 = new GeoPoint((int)(37.23598965339457*1E6),(int)(-76.6478106379509*1E6));
			CustomOverlayItem overlayItem21 = new CustomOverlayItem(point21, "Fiends", 
					"(The wacky doctor and his manic nurses are creating the ultimate Fiend...)", null);		
			itemizedOverlay6.addOverlay(overlayItem21);
			
			GeoPoint point22 = new GeoPoint((int)(37.231046*1E6),(int)(-76.646279*1E6));
			CustomOverlayItem overlayItem22 = new CustomOverlayItem(point22, "Night Beats", 
					"(From the devilish sounds of the roading 20's to vamping it up with the music of today...)", null);		
			itemizedOverlay6.addOverlay(overlayItem22);
			
			GeoPoint point23 = new GeoPoint((int)(37.233557*1E6),(int)(-76.644058*1E6));
			CustomOverlayItem overlayItem23 = new CustomOverlayItem(point23, "Dig it Up!", 
					"(Relics long forgotten and buried in the vaults of the Muse di San Marco have recently been dug up...)", null);		
			itemizedOverlay6.addOverlay(overlayItem23);
			
			mapOverlays.add(itemizedOverlay6);
			
			//HOS features
			drawable7 = getResources().getDrawable(R.drawable.hos_marker);
			itemizedOverlay7 = new CustomItemizedOverlay<CustomOverlayItem>(drawable7, mapView);
			
			GeoPoint point24 = new GeoPoint((int)(37.23156*1E6),(int)(-76.646266*1E6));
			CustomOverlayItem overlayItem24 = new CustomOverlayItem(point24, "OPEN CASKet", 
					"(The dead are alive and so is the fun at the OPEN CASKet bar)", null);		
			itemizedOverlay7.addOverlay(overlayItem24);
			
			GeoPoint point25 = new GeoPoint((int)(37.236556*1E6),(int)(-76.646473*1E6));
			CustomOverlayItem overlayItem25 = new CustomOverlayItem(point25, "Roaming Hordes", 
					"(Busch Gardens' path ways are taken over by roaming minions from your deepest fears)", null);		
			itemizedOverlay7.addOverlay(overlayItem25);
			
			GeoPoint point26 = new GeoPoint((int)(37.235963*1E6),(int)(-76.647730*1E6));
			CustomOverlayItem overlayItem26 = new CustomOverlayItem(point26, "Inoculation Station", 
					"(No appointments necessay for the shot of a lifetime with your favorite fiends in pink)", null);		
			itemizedOverlay7.addOverlay(overlayItem26);
			
			GeoPoint point27 = new GeoPoint((int)(37.232244*1E6),(int)(-76.646314*1E6));
			CustomOverlayItem overlayItem27 = new CustomOverlayItem(point27, "Dark Side of the Gardens Store", 
					"(Howl-O-Scream exclusive merchandise)", null);		
			itemizedOverlay7.addOverlay(overlayItem27);
			
			mapOverlays.add(itemizedOverlay7);
			
			
			locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
			locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
			Location location = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			locManager.removeUpdates(this);
			MyLocationOverlay mylocationOverlay = new MyLocationOverlay(this, mapView);
			mylocationOverlay.enableMyLocation();
			//mylocationOverlay.enableCompass();
			mapView.getOverlays().add(mylocationOverlay);
			
			//locationManager2.removeUpdates(locationListener);
			
			MapController mapController = mapView.getController();
			mapController.animateTo(point25);
			//mapView.invalidate();
			mapController.setZoom(19);
			
	    }
		
		/*private void setupListener() {
			 LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
			//MapListener listener = new MapListener();
			MapView mapView = (MapView) findViewById(R.id.mapview);
			LocationListener locationListener = new LocationListener(){
				

				@Override
				public void onProviderDisabled(String provider) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onStatusChanged(String provider, int status,
						Bundle extras) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onLocationChanged(Location arg0) {
					// TODO Auto-generated method stub
					
				}
	        	
	        };
	        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
	        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
			
		}*/
		
		//public void onLocationChanged(Location location) {
		//	GeoPoint pointLoc = new GeoPoint((int)(location.getLatitude()*1E6), (int)(location.getLongitude()*1E6));
		//	CustomOverlayItem overlayItem28 = new CustomOverlayItem(pointLoc, "This is your current location!", null, null);
		//	itemizedOverlay7.addOverlay(overlayItem28);
		//	//mapView.invalidate();
		//	//mapController.animateTo(pointLoc);	
		//}
		
		
		//protected final boolean onTap(int index){
		//	swtich (item.getItemId()){
		//		case R.id.overlayitem27:
		//	}
		//}
		
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			super.onCreateOptionsMenu(menu);
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.menu.hosmenu, menu);
			return true;
		}
		
		
		
		 @Override
		public boolean onOptionsItemSelected(MenuItem item) {
			 switch(item.getItemId()){	
			 case android.R.id.home:
	                mMenuDrawer.toggleMenu();
	                return true;
			 case R.id.hos_user:
				 //MapController mapController = mapView.getController();
				 //return true;
			 case R.id.houses:
				 mapView.invalidate();
				 if(mapOverlays.contains(itemizedOverlay5)){
					 mapOverlays.remove(itemizedOverlay5);
				 }
				 if(mapOverlays.contains(itemizedOverlay6)){
					 mapOverlays.remove(itemizedOverlay6);
				 }
				 if(mapOverlays.contains(itemizedOverlay7)){
					 mapOverlays.remove(itemizedOverlay7);
				 }
				 mapView.invalidate();
				 mapOverlays.add(itemizedOverlay5);
				 break;
			 case R.id.shows2:
				 mapView.invalidate();
				 if(mapOverlays.contains(itemizedOverlay5)){
					 mapOverlays.remove(itemizedOverlay5);
				 }
				 if(mapOverlays.contains(itemizedOverlay6)){
					 mapOverlays.remove(itemizedOverlay6);
				 }
				 if(mapOverlays.contains(itemizedOverlay7)){
					 mapOverlays.remove(itemizedOverlay7);
				 }
				 mapView.invalidate();
				 mapOverlays.add(itemizedOverlay6);
				 break;
				 
			 case R.id.features:
				 mapView.invalidate();
				 if(mapOverlays.contains(itemizedOverlay5)){
					 mapOverlays.remove(itemizedOverlay5);
				 }
				 if(mapOverlays.contains(itemizedOverlay6)){
					 mapOverlays.remove(itemizedOverlay6);
				 }
				 if(mapOverlays.contains(itemizedOverlay7)){
					 mapOverlays.remove(itemizedOverlay7);
				 }
				 mapView.invalidate();
				 mapOverlays.add(itemizedOverlay7);
				 break;
			 default:
				 return super.onOptionsItemSelected(item);
			 }
			return false;
			  
			 
			 
		  //      switch (item.getItemId()) {
		  //          case android.R.id.home:
		  //              mMenuDrawer.toggleMenu();
		  //          break;
		  //          case R.id.hos_user: 
		  //          	MapController mapController = mapView.getController();
		  //          	mapController.animateTo(pointLoc);
		//			break;
		//			default:
		//				return super.onOptionsItemSelected(item);	
		  //      }
		  //      return true;
		 }
		 

		// @Override
		// protected void onResume(){
		//	 super.onResume();
		//	 locationManager2.addUpdates(locationListener);
			 //locationListener.enableUpdates(this);
			 //myLocationOverlay.enableMyLocation();
			 //mapOverlays.add(myLocationOverlay);
			 //super.onResume();
			 //locationManager2.requestLocationUpdates(locationManager, 400, 1, this);
		//}
		 
		// @Override
		// protected void onStop(){
		//	 super.onStop();
		//	 locationManager2.removeUpdates(locationListener);
		//	 //myLocationOverlay.disableMyLocation();
			 //mapOverlays.remove(myLocationOverlay);
			 //super.onStop();
			 //locationManager2.removeUpdates(locationManager);
		 //}
		// 
		 
		 @Override
		    protected void onResume() {
		        super.onResume();
		        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
		                0, this);
		    }
		 
		 @Override
		 public void onPause(){
			 super.onPause();
			 locManager.removeUpdates(this);
			 //myLocationOverlay.disableMyLocation();
			 //myLocationOverlay.disableFollowLocation();
		 }

		private void createNavigation() {
			// TODO Auto-generated method stub
		}
		
		

		@Override
		protected boolean isRouteDisplayed() {
			return false;
		}

		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}

		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			
		}

		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
		
		
		

		

	}
