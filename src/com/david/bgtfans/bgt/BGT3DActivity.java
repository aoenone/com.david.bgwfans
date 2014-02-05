package com.david.bgtfans.bgt;

import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.beyondar.android.fragment.BeyondarFragmentSupport;
import com.beyondar.android.view.OnClickBeyondarObjectListener;
import com.beyondar.android.world.BeyondarObject;
import com.beyondar.android.world.GeoObject;
import com.beyondar.android.world.World;
import com.david.bgtfans.R;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationRequest;

import java.util.ArrayList;

/**
 * Created by david.hodge on 2/4/14.
 */
public class BGT3DActivity extends SherlockFragmentActivity {

    BeyondarFragmentSupport beyondarFragmentSupport;
    World world;
    LocationClient locationClient;
    LocationRequest locationRequest;
    LocationManager locationManager;
    android.location.Location location;
    Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bgw_threed_view);
        beyondarFragmentSupport = (BeyondarFragmentSupport)
                getSupportFragmentManager().findFragmentById(R.id.beyondarFragment);
        mContext = this;
        getStandardLocation();
    }

    private void getStandardLocation(){
        try {
            locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            String bestProvider = locationManager.getBestProvider(new Criteria(), false);
            location = locationManager.getLastKnownLocation(bestProvider);
            setUpView(location);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void setUpView(android.location.Location location) {
        Toast.makeText(mContext, Double.toString(location.getLatitude()) + " , " + Double.toString(location.getLongitude()), Toast.LENGTH_LONG).show();
        world = new World(mContext);
        world.setDefaultBitmap(R.drawable.iconv2);
        world.setGeoPosition(38.2127, -78.26768);
//        world.setLocation(location);
        world.setArViewDistance(50000000);

        //TODO add coasters and shit
        GeoObject go1 = new GeoObject(1l);
        go1.setGeoPosition(38.2125, -78.26753);
        go1.setImageResource(R.drawable.iconv2);
        go1.setName("Verbolten");

        GeoObject go2 = new GeoObject(2l);
        go2.setGeoPosition(38.2117, -78.26789);
        go2.setImageResource(R.drawable.iconv2);
        go2.setName("Alpengeist");

        GeoObject go3 = new GeoObject(3l);
        go3.setGeoPosition(38.2117, -78.26789);
        go3.setImageResource(R.drawable.iconv2);
        go3.setName("Apollo's Chariot");

        GeoObject go4 = new GeoObject(4l);
        go4.setGeoPosition(37.234728, -76.646113);
        go4.setImageResource(R.drawable.iconv2);
        go4.setName("Loch Ness Monster");

        GeoObject go5 = new GeoObject(5l);
        go5.setGeoPosition(37.234516, -76.648023);
        go5.setImageResource(R.drawable.iconv2);
        go5.setName("Griffon");

        GeoObject go6 = new GeoObject(6l);
        go6.setGeoPosition(37.236186, -76.644455);
        go6.setImageResource(R.drawable.iconv2);
        go6.setName("Grover");

        world.addBeyondarObject(go1);
        world.addBeyondarObject(go2);
        world.addBeyondarObject(go3);
        world.addBeyondarObject(go4);
        world.addBeyondarObject(go5);
        world.addBeyondarObject(go6);

        beyondarFragmentSupport.setWorld(world);
        beyondarFragmentSupport.setOnClickBeyondarObjectListener(new OnClickBeyondarObjectListener() {
            @Override
            public void onClickBeyondarObject(ArrayList<BeyondarObject> beyondarObjects) {
                try {
                    Toast.makeText(mContext, "Clicked on: " + beyondarObjects.get(0).getName(), Toast.LENGTH_LONG).show();
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        EasyTracker.getInstance().activityStart(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EasyTracker.getInstance().activityStop(this);
        try {
            locationClient.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        if (locationClient != null)
            locationClient.disconnect();
        super.onDestroy();
    }
}
