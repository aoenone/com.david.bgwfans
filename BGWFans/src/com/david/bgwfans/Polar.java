package com.david.bgwfans;

import android.app.ActionBar;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.cyrilmottier.polaris.PolarisMapView;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import net.simonvt.widget.MenuDrawerManager;

import java.util.List;


public class Polar extends BaseActivity implements View.OnClickListener {
	private PolarisMapView mapView;
	private MenuDrawerManager mMenuDrawer;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.polar);
	
	ActionBar actionbar = getActionBar();
    actionbar.setDisplayShowTitleEnabled(false);
    actionbar.setDisplayHomeAsUpEnabled(true);

    mapView = (PolarisMapView) findViewById(R.id.vmapview);
    //mapView = new PolarisMapView (this, mapApiKey);
    //vmapView.addView(vmapView);
    //setContentView(vmapView);
	//vmapView.setSatellite(true);
	//removeView();
    List<Overlay> mapOverlays = mapView.getOverlays();
    Drawable drawable = this.getResources().getDrawable(R.drawable.map_pin_holed_blue);
    HelloItemizedOverlay itemizedoverlay = new HelloItemizedOverlay(drawable,this);
    GeoPoint point = new GeoPoint((int)(37.235753*1E6),(int)(-76.644563*1E6));
    OverlayItem overlayitem = new OverlayItem(point, "Mistletoe Marketplace", "Outdoor German Marketplace");
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
	mapController.setZoom(19);
    
    //Typeface rt = Typeface.createFromAsset(getAssets(),
    //        "fonts/Roboto-Thin.ttf");
    //TextView attr = (TextView) findViewById(R.id.attr);
    //TextView wiki = (TextView) findViewById(R.id.wiki);
    //attr.setTypeface(rt);
    //wiki.setTypeface(rt);
    
}


	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	

}
