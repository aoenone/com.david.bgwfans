package com.david.bgwfans;

import java.util.List;
import net.simonvt.widget.MenuDrawer;
import net.simonvt.widget.MenuDrawerManager;
import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.Overlay;
import com.readystatesoftware.maps.OnSingleTapListener;
import com.readystatesoftware.maps.TapControlledMapView;

public class MapScreen<MapListener> extends MapActivity implements View.OnClickListener, LocationListener {

		TapControlledMapView mapView;
		List<Overlay> mapOverlays;
		Drawable drawable;
		Drawable drawable2;
		Drawable drawable3;
		Drawable drawable4;
		Drawable drawable5;
		CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay;
		CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay2;
		CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay3;
		CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay4;
		CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay5;
		CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay6;
		CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay7;
		CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay8;
		
		private MenuDrawerManager mMenuDrawer;
		
		@Override
	    public void onCreate(Bundle savedInstanceState) {
			
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.mapscreen);
	        
	        ActionBar actionbar = getActionBar();
	        actionbar.setDisplayShowTitleEnabled(false);
			actionbar.setListNavigationCallbacks(null, null);
	        actionbar.setDisplayHomeAsUpEnabled(true);
	        createNavigation();
	        
	        findViewById(R.id.item1).setOnClickListener(this);
	        findViewById(R.id.item2).setOnClickListener(this);
	        findViewById(R.id.item3).setOnClickListener(this);
	        findViewById(R.id.item4).setOnClickListener(this);
	        findViewById(R.id.item5).setOnClickListener(this);
	        findViewById(R.id.item6).setOnClickListener(this);
	        findViewById(R.id.item7).setOnClickListener(this);
	        findViewById(R.id.item8).setOnClickListener(this);
	        findViewById(R.id.item9).setOnClickListener(this);
	        findViewById(R.id.item10).setOnClickListener(this);
	        findViewById(R.id.item11).setOnClickListener(this);
	        findViewById(R.id.item12).setOnClickListener(this);
	        findViewById(R.id.item13).setOnClickListener(this);
	        
	        
	        mMenuDrawer = new MenuDrawerManager(this, MenuDrawer.MENU_DRAG_WINDOW);
	        //mMenuDrawer.setContentView(R.layout.activity_windowsample);
	        mMenuDrawer.setMenuView(R.layout.menu_scrollview);

	        MenuScrollView msv = (MenuScrollView) mMenuDrawer.getMenuView();
	        msv.setOnScrollChangedListener(new MenuScrollView.OnScrollChangedListener() {
	            public void onScrollChanged() {
	                mMenuDrawer.getMenuDrawer().invalidate();
	            }
	        });
	        
	        
	        mapView = (TapControlledMapView) findViewById(R.id.mapview);
			mapView.setSatellite(true);
			
			mapView.setOnSingleTapListener(new OnSingleTapListener() {		
				public boolean onSingleTap(MotionEvent e) {
					itemizedOverlay.hideAllBalloons();
					itemizedOverlay2.hideAllBalloons();
					//itemizedOverlay3.hideAllBalloons();
					itemizedOverlay4.hideAllBalloons();
					itemizedOverlay5.hideAllBalloons();
					itemizedOverlay6.hideAllBalloons();
					itemizedOverlay7.hideAllBalloons();
					itemizedOverlay8.hideAllBalloons();
					return true;
				}
			});
			
			mapOverlays = mapView.getOverlays();
			
			// general info points
			drawable = getResources().getDrawable(R.drawable.maps_icon2);
			itemizedOverlay = new CustomItemizedOverlay<CustomOverlayItem>(drawable, mapView);
			
			GeoPoint point = new GeoPoint((int)(37.235452*1E6),(int)(-76.645974*1E6));
			CustomOverlayItem overlayItem = new CustomOverlayItem(point, "Restroom", 
					null, 
					null);
			itemizedOverlay.addOverlay(overlayItem);
			
			GeoPoint point2 = new GeoPoint((int)(37.236357*1E6),(int)(-76.645663*1E6));
			CustomOverlayItem overlayItem2 = new CustomOverlayItem(point, "Restroom", 
					null, 
					null);
			itemizedOverlay.addOverlay(overlayItem2);
			
			GeoPoint point3 = new GeoPoint((int)(37.234975*1E6),(int)(-76.649074*1E6));
			CustomOverlayItem overlayItem3 = new CustomOverlayItem(point2, "First Aid", 
					"(First Aid location)", null);		
			itemizedOverlay.addOverlay(overlayItem3);
			
			GeoPoint point4 = new GeoPoint((int)(37.235768*1E6),(int)(-76.647556*1E6));
			CustomOverlayItem overlayItem4 = new CustomOverlayItem(point2, "Restroom", 
					null, null);		
			itemizedOverlay.addOverlay(overlayItem4);
			
			GeoPoint point5 = new GeoPoint((int)(37.236265*1E6),(int)(-76.647742*1E6));
			CustomOverlayItem overlayItem5 = new CustomOverlayItem(point2, "Restroom", 
					null, null);		
			itemizedOverlay.addOverlay(overlayItem5);
			
			GeoPoint point6 = new GeoPoint((int)(37.234072*1E6),(int)(-76.648717*1E6));
			CustomOverlayItem overlayItem6 = new CustomOverlayItem(point2, "Restroom", 
					null, null);		
			itemizedOverlay.addOverlay(overlayItem6);
			
			GeoPoint point7 = new GeoPoint((int)(37.233079*1E6),(int)(-76.646847*1E6));
			CustomOverlayItem overlayItem7 = new CustomOverlayItem(point2, "Restroom", 
					null, null);		
			itemizedOverlay.addOverlay(overlayItem7);
			
			GeoPoint point8 = new GeoPoint((int)(37.231436*1E6),(int)(-76.646203*1E6));
			CustomOverlayItem overlayItem8 = new CustomOverlayItem(point2, "Restroom", 
					null, null);		
			itemizedOverlay.addOverlay(overlayItem8);
			
			GeoPoint point9 = new GeoPoint((int)(37.233756*1E6),(int)(-76.643855*1E6));
			CustomOverlayItem overlayItem9 = new CustomOverlayItem(point2, "Restroom", 
					null, null);		
			itemizedOverlay.addOverlay(overlayItem9);
			
			GeoPoint point10 = new GeoPoint((int)(37.234635*1E6),(int)(-76.641682*1E6));
			CustomOverlayItem overlayItem10 = new CustomOverlayItem(point2, "Restroom", 
					null, null);		
			itemizedOverlay.addOverlay(overlayItem10);
			
			GeoPoint point11 = new GeoPoint((int)(37.237228*1E6),(int)(-76.645271*1E6));
			CustomOverlayItem overlayItem11 = new CustomOverlayItem(point2, "Restroom", 
					null, null);		
			itemizedOverlay.addOverlay(overlayItem11);
			
			mapOverlays.add(itemizedOverlay);
			
			// roller coaster points
			drawable2 = getResources().getDrawable(R.drawable.maps_icon2);
			itemizedOverlay2 = new CustomItemizedOverlay<CustomOverlayItem>(drawable2, mapView);
			
			GeoPoint point12 = new GeoPoint((int)(37.23244*1E6),(int)(-76.645533*1E6));
			CustomOverlayItem overlayItem12 = new CustomOverlayItem(point3, "Verbolten", 
					"(Ride through the Black Forest)", null);
			itemizedOverlay2.addOverlay(overlayItem12);
			
			GeoPoint point13 = new GeoPoint((int)(37.234523*1E6),(int)(-76.647988*1E6));
			CustomOverlayItem overlayItem13 = new CustomOverlayItem(point4, "Griffon", 
					"(Zachary doesn't like this ride)", 
					"http://www.bgwfans.com/wiki/images/2/26/Griffon1.JPG");		
			itemizedOverlay2.addOverlay(overlayItem13);
			
			GeoPoint point14 = new GeoPoint((int)(37.232802*1E6),(int)(-76.647414*1E6));
			CustomOverlayItem overlayItem14 = new CustomOverlayItem(point5, "Alpengeist", 
					"(Snow Alert)", 
					"http://www.bgwfans.com/wiki/images/4/4d/AlpengeistSign1.JPG");		
			itemizedOverlay2.addOverlay(overlayItem14);
			
			GeoPoint point15 = new GeoPoint((int)(37.234714*1E6),(int)(-76.646097*1E6));
			CustomOverlayItem overlayItem15 = new CustomOverlayItem(point6, "Loch Ness Monster", 
					"(The Lengendary Loch Ness Monster)", 
					"http://www.bgwfans.com/wiki/images/c/c1/LochNess1.JPG");		
			itemizedOverlay2.addOverlay(overlayItem15);
			
			GeoPoint point16 = new GeoPoint((int)(37.234992*1E6),(int)(-76.642575*1E6));
			CustomOverlayItem overlayItem16 = new CustomOverlayItem(point7, "Apollo's Chariot", 
					"(Ride on the wings of Apollo)", 
					"http://www.bgwfans.com/wiki/images/d/df/ApollosChariot1.JPG");		
			itemizedOverlay2.addOverlay(overlayItem16);
			
			mapOverlays.add(itemizedOverlay2);
			
			/*//show points
			drawable3 = getResources().getDrawable(R.drawable.maps_icon2);
			itemizedOverlay3 = new CustomItemizedOverlay<CustomOverlayItem>(drawable3, mapView);
			
			GeoPoint point8 = new GeoPoint((int)(37.23108*1E6),(int)(-76.64629*1E6));
			CustomOverlayItem overlayItem8 = new CustomOverlayItem(point8, "Entwined", 
					"(A forest wonderland!)", null);		
			itemizedOverlay3.addOverlay(overlayItem8);
			
			GeoPoint point9 = new GeoPoint((int)(37.236114*1E6),(int)(-76.647972*1E6));
			CustomOverlayItem overlayItem9 = new CustomOverlayItem(point9, "Celtic Fyre", 
					"(Pure energy of irish dance)", null);		
			itemizedOverlay3.addOverlay(overlayItem9);
			
			GeoPoint point10 = new GeoPoint((int)(37.233542*1E6),(int)(-76.644074*1E6));
			CustomOverlayItem overlayItem10 = new CustomOverlayItem(point10, "Mix it Up!", 
					"(team of chef-inspired muscians cook up)", null);		
			itemizedOverlay3.addOverlay(overlayItem10);
			
			GeoPoint point11 = new GeoPoint((int)(37.2358082*1E6),(int)(-76.648947*1E6));
			CustomOverlayItem overlayItem11 = new CustomOverlayItem(point11, "More... Pet Shenanigans", 
					"(delightful celebration of the human/animal connection)", null);		
			itemizedOverlay3.addOverlay(overlayItem11);
			
			GeoPoint point12 = new GeoPoint((int)(37.236265*1E6),(int)(-76.646016*1E6));
			CustomOverlayItem overlayItem12 = new CustomOverlayItem(point12, "Pirates 4D", 
					"(swashbuckling 4-d adventure)", null);		
			itemizedOverlay3.addOverlay(overlayItem12);
			
			GeoPoint point13 = new GeoPoint((int)(37.236304*1E6),(int)(-76.645018*1E6));
			CustomOverlayItem overlayItem13 = new CustomOverlayItem(point13, "Sunny Days Celebration", 
					"(seasame street friends sing-a-long)", null);		
			itemizedOverlay3.addOverlay(overlayItem13);
			
			mapOverlays.add(itemizedOverlay3);*/
			
			//transportation points
			drawable4 = getResources().getDrawable(R.drawable.maps_icon2);
			itemizedOverlay4 = new CustomItemizedOverlay<CustomOverlayItem>(drawable4, mapView);
			
			GeoPoint point20 = new GeoPoint((int)(37.235992*1E6),(int)(-76.645474*1E6));
			CustomOverlayItem overlayItem20 = new CustomOverlayItem(point14, "England Skyride", 
					"(Departs to Aquitaine)", null);		
			itemizedOverlay4.addOverlay(overlayItem20);
			
			mapOverlays.add(itemizedOverlay4);
			
			//HOS markers
			drawable5 = getResources().getDrawable(R.drawable.hos_marker);
			itemizedOverlay5 = new CustomItemizedOverlay<CustomOverlayItem>(drawable5, mapView);
			
			GeoPoint point21= new GeoPoint((int)(37.23629715622509*1E6),(int)(-76.64818346500397*1E6));
			CustomOverlayItem overlayItem21= new CustomOverlayItem(point15, "13: Your Number's up", 
					"(Is your number up?)", null);		
			itemizedOverlay5.addOverlay(overlayItem21);
			
			GeoPoint point22 = new GeoPoint((int)(37.2309489*1E6),(int)(-76.645898*1E6));
			CustomOverlayItem overlayItem22 = new CustomOverlayItem(point16, "Bitten", 
					"(Full of legends and lore of vampires)", null);		
			itemizedOverlay5.addOverlay(overlayItem22);
			
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
			
			mapOverlays.add(itemizedOverlay5);
			
			
			final MapController mc = mapView.getController();
			mc.animateTo(point);
			mc.setZoom(19);
			
	    }
		
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			super.onCreateOptionsMenu(menu);
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.menu.mapmenu, menu);
			return true;
		}
		
		
		
		 @Override
		public boolean onOptionsItemSelected(MenuItem item) {
		        switch (item.getItemId()) {
		            case android.R.id.home:
		                mMenuDrawer.toggleMenu();
		                return true;
		            case R.id.info:
		            	 mapView.invalidate();
		            	 if(mapOverlays.contains(itemizedOverlay)){
							 mapOverlays.remove(itemizedOverlay);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay2)){
							 mapOverlays.remove(itemizedOverlay2);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay3)){
							 mapOverlays.remove(itemizedOverlay3);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay4)){
							 mapOverlays.remove(itemizedOverlay4);
						 }
						 if(mapOverlays.contains(itemizedOverlay5)){
							 mapOverlays.remove(itemizedOverlay5);
						 }
						 if(mapOverlays.contains(itemizedOverlay6)){
							 mapOverlays.remove(itemizedOverlay6);
						 }
						 if(mapOverlays.contains(itemizedOverlay7)){
							 mapOverlays.remove(itemizedOverlay7);
						 }
						 if(mapOverlays.contains(itemizedOverlay8)){
							 mapOverlays.remove(itemizedOverlay8);
						 }
						 mapView.invalidate();
						 mapOverlays.add(itemizedOverlay);
						 break;
						 
		            case R.id.coastersoption:
		            	 mapView.invalidate();
		            	 if(mapOverlays.contains(itemizedOverlay)){
							 mapOverlays.remove(itemizedOverlay);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay2)){
							 mapOverlays.remove(itemizedOverlay2);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay3)){
							 mapOverlays.remove(itemizedOverlay3);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay4)){
							 mapOverlays.remove(itemizedOverlay4);
						 }
						 if(mapOverlays.contains(itemizedOverlay5)){
							 mapOverlays.remove(itemizedOverlay5);
						 }
						 if(mapOverlays.contains(itemizedOverlay6)){
							 mapOverlays.remove(itemizedOverlay6);
						 }
						 if(mapOverlays.contains(itemizedOverlay7)){
							 mapOverlays.remove(itemizedOverlay7);
						 }
						 if(mapOverlays.contains(itemizedOverlay8)){
							 mapOverlays.remove(itemizedOverlay8);
						 }
						 mapView.invalidate();
						 mapOverlays.add(itemizedOverlay2);
						 break;
						 
		            case R.id.flatsoption:
		            	 mapView.invalidate();
		            	 if(mapOverlays.contains(itemizedOverlay)){
							 mapOverlays.remove(itemizedOverlay);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay2)){
							 mapOverlays.remove(itemizedOverlay2);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay3)){
							 mapOverlays.remove(itemizedOverlay3);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay4)){
							 mapOverlays.remove(itemizedOverlay4);
						 }
						 if(mapOverlays.contains(itemizedOverlay5)){
							 mapOverlays.remove(itemizedOverlay5);
						 }
						 if(mapOverlays.contains(itemizedOverlay6)){
							 mapOverlays.remove(itemizedOverlay6);
						 }
						 if(mapOverlays.contains(itemizedOverlay7)){
							 mapOverlays.remove(itemizedOverlay7);
						 }
						 if(mapOverlays.contains(itemizedOverlay8)){
							 mapOverlays.remove(itemizedOverlay8);
						 }
						 mapView.invalidate();
						 mapOverlays.add(itemizedOverlay3);
						 break;
						 
		            case R.id.wateroption:
		            	 mapView.invalidate();
		            	 if(mapOverlays.contains(itemizedOverlay)){
							 mapOverlays.remove(itemizedOverlay);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay2)){
							 mapOverlays.remove(itemizedOverlay2);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay3)){
							 mapOverlays.remove(itemizedOverlay3);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay4)){
							 mapOverlays.remove(itemizedOverlay4);
						 }
						 if(mapOverlays.contains(itemizedOverlay5)){
							 mapOverlays.remove(itemizedOverlay5);
						 }
						 if(mapOverlays.contains(itemizedOverlay6)){
							 mapOverlays.remove(itemizedOverlay6);
						 }
						 if(mapOverlays.contains(itemizedOverlay7)){
							 mapOverlays.remove(itemizedOverlay7);
						 }
						 if(mapOverlays.contains(itemizedOverlay8)){
							 mapOverlays.remove(itemizedOverlay8);
						 }
						 mapView.invalidate();
						 mapOverlays.add(itemizedOverlay4);
						 break;
						 
		            case R.id.addoption:
		            	 mapView.invalidate();
		            	 if(mapOverlays.contains(itemizedOverlay)){
							 mapOverlays.remove(itemizedOverlay);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay2)){
							 mapOverlays.remove(itemizedOverlay2);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay3)){
							 mapOverlays.remove(itemizedOverlay3);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay4)){
							 mapOverlays.remove(itemizedOverlay4);
						 }
						 if(mapOverlays.contains(itemizedOverlay5)){
							 mapOverlays.remove(itemizedOverlay5);
						 }
						 if(mapOverlays.contains(itemizedOverlay6)){
							 mapOverlays.remove(itemizedOverlay6);
						 }
						 if(mapOverlays.contains(itemizedOverlay7)){
							 mapOverlays.remove(itemizedOverlay7);
						 }
						 if(mapOverlays.contains(itemizedOverlay8)){
							 mapOverlays.remove(itemizedOverlay8);
						 }
						 mapView.invalidate();
						 mapOverlays.add(itemizedOverlay5);
						 break;
						 
		            case R.id.kidoption:
		            	 mapView.invalidate();
		            	 if(mapOverlays.contains(itemizedOverlay)){
							 mapOverlays.remove(itemizedOverlay);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay2)){
							 mapOverlays.remove(itemizedOverlay2);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay3)){
							 mapOverlays.remove(itemizedOverlay3);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay4)){
							 mapOverlays.remove(itemizedOverlay4);
						 }
						 if(mapOverlays.contains(itemizedOverlay5)){
							 mapOverlays.remove(itemizedOverlay5);
						 }
						 if(mapOverlays.contains(itemizedOverlay6)){
							 mapOverlays.remove(itemizedOverlay6);
						 }
						 if(mapOverlays.contains(itemizedOverlay7)){
							 mapOverlays.remove(itemizedOverlay7);
						 }
						 if(mapOverlays.contains(itemizedOverlay8)){
							 mapOverlays.remove(itemizedOverlay8);
						 }
						 mapView.invalidate();
						 mapOverlays.add(itemizedOverlay6);
						 break;
						 
		            case R.id.eatoption:
		            	 mapView.invalidate();
		            	 if(mapOverlays.contains(itemizedOverlay)){
							 mapOverlays.remove(itemizedOverlay);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay2)){
							 mapOverlays.remove(itemizedOverlay2);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay3)){
							 mapOverlays.remove(itemizedOverlay3);
						 }
		            	 if(mapOverlays.contains(itemizedOverlay4)){
							 mapOverlays.remove(itemizedOverlay4);
						 }
						 if(mapOverlays.contains(itemizedOverlay5)){
							 mapOverlays.remove(itemizedOverlay5);
						 }
						 if(mapOverlays.contains(itemizedOverlay6)){
							 mapOverlays.remove(itemizedOverlay6);
						 }
						 if(mapOverlays.contains(itemizedOverlay7)){
							 mapOverlays.remove(itemizedOverlay7);
						 }
						 if(mapOverlays.contains(itemizedOverlay8)){
							 mapOverlays.remove(itemizedOverlay8);
						 }
						 mapView.invalidate();
						 mapOverlays.add(itemizedOverlay7);
						 break;
						 default:
							 return super.onOptionsItemSelected(item);
		        }
		        return false;
		 }
		
		
		private void createNavigation() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected boolean isRouteDisplayed() {
			return false;
		}

		public void onClick(View v) {
			switch(v.getId()){
		case R.id.item1: Intent infoActivity = new Intent(this, InfoScreen.class);
		startActivity(infoActivity);
		break;
    	case R.id.item2: Intent attrActivity = new Intent(this, Attractions.class);
		startActivity(attrActivity);
		break;
		case R.id.item3: Intent showsActivity = new Intent(this, HOS_Shows.class);
		startActivity(showsActivity);
		break;
    	case R.id.item4: Intent eatActivity = new Intent(this, Eateries.class);
		startActivity(eatActivity);
		break;
    	case R.id.item5: Intent mapActivity = new Intent(this, MapScreen.class);
		startActivity(mapActivity);
		break;
    	case R.id.item6: Intent hhActivity = new Intent(this, HOS_Houses.class);
		startActivity(hhActivity);
		break;
    	case R.id.item7: Intent hshowActivity = new Intent(this, HOS_Shows.class);
		startActivity(hshowActivity);
		break;
    	case R.id.item8: Intent featuresActivity = new Intent(this, HOS_Features.class);
		startActivity(featuresActivity);
		break;
    	case R.id.item9: Intent blogActivity = new Intent(this, BGWFans.class);
		startActivity(blogActivity);
		break;
    	case R.id.item10: Intent forumActivity = new Intent(this, Forums.class);
		startActivity(forumActivity);
		break;
    	case R.id.item11: Intent wikiActivity = new Intent(this, Wiki.class);
		startActivity(wikiActivity);
		break;
    	case R.id.item12: Intent settingsActivity = new Intent(this, Settings.class);
		startActivity(settingsActivity);
		break;
    	case R.id.item13: Intent aboutActivity = new Intent(this, About.class);
		startActivity(aboutActivity);
		break;
			}
			
		}

		public void onLocationChanged(Location arg0) {
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


