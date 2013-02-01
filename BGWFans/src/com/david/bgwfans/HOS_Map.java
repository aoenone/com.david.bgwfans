package com.david.bgwfans;

import android.app.ActionBar;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.cyrilmottier.polaris.Annotation;
import com.cyrilmottier.polaris.MapCalloutView;
import com.cyrilmottier.polaris.MapViewUtils;
import com.cyrilmottier.polaris.PolarisMapView;
import com.cyrilmottier.polaris.PolarisMapView.OnAnnotationSelectionChangedListener;
import com.cyrilmottier.polaris.PolarisMapView.OnRegionChangedListener;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;

import java.util.ArrayList;

public class HOS_Map extends BaseActivity implements OnRegionChangedListener, OnAnnotationSelectionChangedListener, View.OnClickListener {

    private static final String LOG_TAG = "MainActivity";

    //@formatter:off
    private static final Annotation[] sFrance = {
        new Annotation(new GeoPoint(48635600, -1510600), "Mont Saint Michel", "Mont Saint-Michel is a rocky tidal island and a commune in Normandy, France. It is located approximately one kilometre (just over half a mile) off the country's north-western coast, at the mouth of the Couesnon River near Avranches."),
        new Annotation(new GeoPoint(48856600, 2351000), "Paris", "The city of love"),
        new Annotation(new GeoPoint(44837400, -576100), "Bordeaux", "A port city in southwestern France"),
        new Annotation(new GeoPoint(48593100, -647500), "Domfront", "A commune in the Orne department in north-western France"),
    };
    
    private static final Annotation[] sEurope = {
        new Annotation(new GeoPoint(55755800, 37617600), "Moscow"),
        new Annotation(new GeoPoint(59332800, 18064500), "Stockholm"),
        new Annotation(new GeoPoint(59939000, 30315800), "Saint Petersburg"),
        new Annotation(new GeoPoint(60169800, 24938200), "Helsinki"),
        new Annotation(new GeoPoint(60451400, 22268700), "Turku"),
        new Annotation(new GeoPoint(65584200, 22154700), "Lule\u00E5"),
        new Annotation(new GeoPoint(59438900, 24754500), "Talinn"),
        new Annotation(new GeoPoint(66498700, 25721100), "Rovaniemi"),
    };
    
    private static final Annotation[] sUsaWestCoast = {
        new Annotation(new GeoPoint(37234617, -76642543), "Holiday Hills", "Stroll through retro lane"),
        new Annotation(new GeoPoint(37233248, -76646549), "Santa's Workshop", "Create memories that will last a life time" ),
        new Annotation(new GeoPoint(37235407, -76646019), "Highland Stables", "Explore the Scottish countryside under a star-filled wintery sky"),
        new Annotation(new GeoPoint(37231909, -76646395), "Mistletoe Marketplace", "Traditional outdoor German market"),
        new Annotation(new GeoPoint(37234632, -76649002), "Ice Palace: A Penguin Paradise", "Explore the ice-themed world"),
        new Annotation(new GeoPoint(37235757, -76643920), "Polar Pathway", "Enjoy the waterfall of lights!"),
    };
    
    private static final Annotation[] xShows = {
    	new Annotation(new GeoPoint(37231238, -76646237), "Deck the Halls", "Live musical tribute to Christmas traditions"),
        new Annotation(new GeoPoint(37236103, -76647999), "Gloria!", "Greatest story ever told comes to life as only Busch Gardens can imagine"),
        new Annotation(new GeoPoint(37233618, -76644174), "Miracles", "Celebrate the spirit of Christmas through powerful movement and dance"),
        new Annotation(new GeoPoint(37231582, -76646261), "O Tannenbaum", "Larger than life, spectacular lightshow"),
        new Annotation(new GeoPoint(37236243, -76646041), "A Sesame Street Christmas", "Gather in the Globe Theatre for a production of A Sesame Street Christmas"),   	
    };
    
    private static final Annotation[] xShopping = {
    	new Annotation(new GeoPoint(37233933, -76644146), "Artisans of Italy", "A visit is not complete without a stop in Artisans of Italy"),
        new Annotation(new GeoPoint(37235828, -76647603), "Emerald Isle Gifts", "the place for irish scarves, sweaters, hats, and fine jewelry" ),
        new Annotation(new GeoPoint(37234529, -76648806), "La Belle Maison", "Find something for everyone on your list a La Belle Maison in France"),
        new Annotation(new GeoPoint(37233488, -76648654), "The Caribou Pottery", "Explore your creative side as you decorate unique pottery and dip your own candles"),
        new Annotation(new GeoPoint(37232954, -76646753), "The Christmas Town Shoppe", "Offer personalized ornaments and toys for everyone on your list"),
        new Annotation(new GeoPoint(37235322, -76645889), "Tweedside Gifts", "Scotland's personalized gifts, glassware, and leather goods"),   	
    };
    
    private static final Annotation[] sUsaEastCoast = {
        new Annotation(new GeoPoint(37774900, -122419400), "San Francisco"),
        new Annotation(new GeoPoint(37770600, -119510800), "Yosemite National Park"),
        new Annotation(new GeoPoint(36878200, -121947300), "Monteray Bay"),
        new Annotation(new GeoPoint(35365800, -120849900), "Morro Bay"),
        new Annotation(new GeoPoint(34420800, -119698200), "Santa Barbara"),
        new Annotation(new GeoPoint(34052200, -118243700), "Los Angeles"),
        new Annotation(new GeoPoint(32715300, -117157300), "San Diego"),
        new Annotation(new GeoPoint(36114600, -115172800), "Las Vegas"),
        new Annotation(new GeoPoint(36220100, -116881700), "Death Valley"),
        new Annotation(new GeoPoint(36355200, -112661200), "Grand Canyon"),
        new Annotation(new GeoPoint(37289900, -113048900), "Zion National Park"),
        new Annotation(new GeoPoint(37628300, -112167700), "Bryce Canyon"),
        new Annotation(new GeoPoint(36936900, -111483800), "Lake Powell"),
    };
    
    private static final Annotation[][] sRegions = {sFrance, sEurope, sUsaEastCoast, sUsaWestCoast, xShows};
    private static final Annotation[][] shopping = {xShopping};
    private static final Annotation[][] shows = {xShows};
    private static final Annotation[][] features = {sUsaWestCoast};
    //@formatter:on

    private PolarisMapView mMapView;

    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hos_map);
        
        ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
		actionbar.setListNavigationCallbacks(null, null);
        actionbar.setDisplayHomeAsUpEnabled(true);

        //mMapView = new PolarisMapView(this, Config.GOOGLE_MAPS_API_KEY);
        mMapView = (PolarisMapView) findViewById(R.id.mapview);
        mMapView.setUserTrackingButtonEnabled(true);
        mMapView.setOnRegionChangedListenerListener(this);
        mMapView.setOnAnnotationSelectionChangedListener(this);
        mMapView.setSatellite(true);
        MapController mapController = mMapView.getController();
		mapController.animateTo(new GeoPoint(37235407, -76646019));
		mMapView.invalidate();
		mapController.setZoom(19);

        // Prepare an alternate pin Drawable
        final Drawable altMarker = MapViewUtils.boundMarkerCenterBottom(getResources().getDrawable(R.drawable.map_pin_holed_violet));

        // Prepare the list of Annotation using the alternate Drawable for all
        // Annotation located in France
        final ArrayList<Annotation> annotations = new ArrayList<Annotation>();
        for (Annotation[] region : sRegions) {
            for (Annotation annotation : region) {
                //if (region == sFrance) {
                 //   annotation.setMarker(altMarker);
                //}
                annotations.add(annotation);
            }
        }
        
        final ArrayList<Annotation> shop = new ArrayList<Annotation>();
        for (Annotation[] shops : shopping){
        for (Annotation annotation : shops) {
        	shop.add(annotation);
        }
        }
        mMapView.setAnnotations(annotations, R.drawable.map_pin_holed_blue);
        //mMapView.setAnnotations(shop, R.drawable.map_pin_holed_violet);

        //final FrameLayout mapViewContainer = (FrameLayout) findViewById(R.id.mapview);
        //mapViewContainer.addView(mMapView, new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    	
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMapView.onStop();
    }
    
    /**@Override
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
		 case R.id.experiences:
			 mMapView.invalidate();
			 //xShopping.visibility(Visibility.GONE);
			 break;
		 case R.id.shows2:
			 break;
		 case R.id.shopping:
			 break;
		 }
		 return false;
    } **/
    


	@Override
    protected boolean isRouteDisplayed() {
        return false;
    }

    public void onRegionChanged(PolarisMapView mapView) {
        if (com.cyrilmottier.polaris.internal.Config.INFO_LOGS_ENABLED) {
            Log.i(LOG_TAG, "onRegionChanged");
        }
    }

    public void onRegionChangeConfirmed(PolarisMapView mapView) {
        if (com.cyrilmottier.polaris.internal.Config.INFO_LOGS_ENABLED) {
            Log.i(LOG_TAG, "onRegionChangeConfirmed");
        }
    }

    public void onAnnotationSelected(PolarisMapView mapView, MapCalloutView calloutView, int position, Annotation annotation) {
        if (com.cyrilmottier.polaris.internal.Config.INFO_LOGS_ENABLED) {
            Log.i(LOG_TAG, "onAnnotationSelected");
        }
        calloutView.setDisclosureEnabled(true);
        calloutView.setClickable(true);
        if (!TextUtils.isEmpty(annotation.getSnippet())) {
            calloutView.setLeftAccessoryView(getLayoutInflater().inflate(R.layout.accessory, calloutView, false));
        } else {
            calloutView.setLeftAccessoryView(null);
        }
    }

    public void onAnnotationDeselected(PolarisMapView mapView, MapCalloutView calloutView, int position, Annotation annotation) {
        if (com.cyrilmottier.polaris.internal.Config.INFO_LOGS_ENABLED) {
            Log.i(LOG_TAG, "onAnnotationDeselected");
        }
    }

    public void onAnnotationClicked(PolarisMapView mapView, MapCalloutView calloutView, int position, Annotation annotation) {
        if (com.cyrilmottier.polaris.internal.Config.INFO_LOGS_ENABLED) {
            Log.i(LOG_TAG, "onAnnotationClicked");
        }
        Toast.makeText(this, getString(R.string.annotation_clicked, annotation.getTitle()), Toast.LENGTH_SHORT).show();
    }

}
