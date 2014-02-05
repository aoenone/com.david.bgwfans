package com.david.bgtfans.hos;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.david.bgtfans.R;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created with IntelliJ IDEA.
 * User: david.hodge
 * Date: 8/12/13
 * Time: 9:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class HOSMap extends RoboSherlockFragment {

    //HOS House points
    private static final LatLng LOC_BITTEN = new LatLng(37.230948,-76.645898);
    private Marker bitten;
    private static final LatLng LOC_COVE = new LatLng(37.234301,-76.641639);
    private Marker cove;
    private static final LatLng LOC_THIRTEEN = new LatLng(37.236297,-76.648183);
    private Marker thirteen;
    private static final LatLng LOC_CATACOMBS = new LatLng(37.234629,-76.648988);
    private Marker catacombs;
    private static final LatLng LOC_DEADLINE = new LatLng(37.235691,-76.644651);
    private Marker deadline;
    private static final LatLng LOC_ROOT = new LatLng(37.232678, -76.646738);
    private Marker root;

    //HOS Show points
    private static final LatLng LOC_DIG = new LatLng(37.233495,-76.644024);
    private Marker dig;
    private static final LatLng LOC_NIGHT = new LatLng(37.231328,-76.646218);
    private Marker nightBeats;
    private static final LatLng LOC_FIENDS = new LatLng(37.236105,-76.647993);
    private Marker fiends;

    //HOS Scare zone (territories <- stupid fucking name) points
    private static final LatLng LOC_DEMON_STREET = new LatLng(37.234384, -76.648724);
    private Marker demonStreet;
    private static final LatLng LOC_PORTS = new LatLng(37.23461,-76.643638);
    private Marker ports;
    private static final LatLng LOC_RIPPER_ROW = new LatLng(37.236167,-76.645904);
    private Marker ripperRow;
    private static final LatLng LOC_VAMPIRE_POINT = new LatLng(37.232972,-76.64662);
    private Marker vampirePoint;


    //HOS theme zones
    private static final LatLng LOC_HEATHERDOWNS = new LatLng(37.235321,-76.646191);
    private Marker hosHeatehrdowns;
    private static final LatLng LOC_PORTS_FESTA = new LatLng(37.234482,-76.642195);
    private Marker portsFesta;
    private static final LatLng LOC_IRELAND = new LatLng(37.235917,-76.647583);
    private Marker hosIreland;
    private static final LatLng LOC_WILD = new LatLng(37.235716,-76.649023);
    private Marker hosWild;
    private static final LatLng LOC_NEW_FRANCE = new LatLng(37.233344,-76.648573);
    private Marker hosNewFrance;


    //HOS Culinary points
    private static final LatLng LOC_INOC_STATION = new LatLng(37.235966,-76.647725);
    private Marker incoStation;
    private static final LatLng LOC_OPEN_CASK = new LatLng(37.231578,-76.646258);
    private Marker openCask;
    private static final LatLng LOC_BLOOD_BANQ = new LatLng(37.233203,-76.646703);
    private Marker bloodBanq;
    private static final LatLng LOC_BUC_GALLERY = new LatLng(37.234484,-76.641519);
    private Marker bucGallery;
    private static final LatLng LOC_FRIGHT_FEAST = new LatLng(37.236228,-76.647827);
    private Marker frightFeast;
    private static final LatLng LOC_DEMON_DRINKS = new LatLng(37.234498,-76.648872);
    private Marker demonDrinks;
    private static final LatLng LOC_PIRATE_ARG = new LatLng(37.234182,-76.644042);
    private Marker pirateArg;
    private static final LatLng LOC_PLANK_BAR = new LatLng(37.233935,-76.644154);
    private Marker plankBar;



    MapView mapView;
    Bundle bundle;
    GoogleAnalytics mGaInstance;
    Tracker mGaTracker;
    GoogleMap mMap;

    static final CameraPosition HOME =
            new CameraPosition.Builder().target(new LatLng(37.235466, -76.646328))
                    .zoom(17)
                    .bearing(-100)
                    .tilt(25)
                    .build();

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.mapv2, container, false);


        try {
            MapsInitializer.initialize(getActivity());
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }


        mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(bundle);
//        mapView.onResume();
        setUpMapIfNeeded(view);

//        setRetainInstance(true);

        setHasOptionsMenu(true);
        getSherlockActivity().getWindow().setUiOptions(ActivityInfo.UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW);
        mGaInstance = GoogleAnalytics.getInstance(getActivity());
        mGaTracker = mGaInstance.getTracker("UA-39204043-1");

        return view;
    }

    private void setUpMap(){
        mMap.setIndoorEnabled(true);
        mMap.setMyLocationEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(HOME));
        addHosHousesToMap();
        addHosShowsToMap();
        addAddtionalToMap();
        addGeoFencesToMap();
        addCulinaryToMap();
        addZonesToMap();
    }

    private void setUpMapIfNeeded(View view){
        if(mMap == null){
            mMap = ((MapView) view.findViewById(R.id.map)).getMap();
            if(mMap != null){
                setUpMap();
            }
        }

    }

    public void addHosHousesToMap(){
        bitten = mMap.addMarker(new MarkerOptions()
                .position(LOC_BITTEN)
                .title("Bitten")
                .snippet("1800's Eastern Europe house full of legends and lore of vampires, that prey on the innocent"));

        cove = mMap.addMarker(new MarkerOptions()
                .position(LOC_COVE)
                .title("Cut Throat Cove")
                .snippet("The haven for bloodthirsty, dangerous rouges - where the scurvy dogs, buccaneers and scoundrels go for shelter"));

        thirteen = mMap.addMarker(new MarkerOptions()
                .position(LOC_THIRTEEN)
                .title("13: Your Numbers Up")
                .snippet("For 13 long years, the dark tower was locked away from the world... " +
                        "only exisiting in the nightmares of those who had dared to experience " +
                        "Howl-O-Scream's first and most terrifying maze"));

        catacombs = mMap.addMarker(new MarkerOptions()
                .position(LOC_CATACOMBS)
                .title("Catacombs")
                .snippet("Through a ruined cemetery filled with statues lies a tunnel that leads to an underground city. " +
                        "It's history is more terrifying than that of France's worst revolutions"));

        root = mMap.addMarker(new MarkerOptions()
                .position(LOC_ROOT)
                .title("Root of All Evil")
                .snippet("The seeds of evil have been sown. Venture if you dare into a decrepit greenhouse"));

        deadline = mMap.addMarker(new MarkerOptions()
                .position(LOC_DEADLINE)
                .title("Deadline")
                .snippet("Deep underground, construction of the newest line of the Pompeii Metro was moving smoothly until an ancient pipe was accidentally struck"));
    }

    public void addHosShowsToMap(){

        dig = mMap.addMarker(new MarkerOptions()
                .position(LOC_DIG)
                .title("Dig it Up!")
                .snippet("Relics long forgotten and buried in the vaults of the Museo di San Marco " +
                        "have recently been dug up, dusted off and brought to life through song"));

        nightBeats = mMap.addMarker(new MarkerOptions()
                .position(LOC_NIGHT)
                .title("Night Beats")
                .snippet("Things that go bump in the night sing, dance and transport you on a musical journey"));

        fiends = mMap.addMarker(new MarkerOptions()
                .position(LOC_FIENDS)
                .title("Fiends")
                .snippet("The wacky doctor and his manic nurses are creating the ultimate Fiends, " +
                        "and there's not a bad seat in the lab"));

    }

    public void addAddtionalToMap(){

    }

    public void addGeoFencesToMap(){

    }

    public void addCulinaryToMap(){

        incoStation = mMap.addMarker(new MarkerOptions()
                .position(LOC_INOC_STATION)
                .title("Inoculation Station")
                .snippet("No appointments necessary for the shot of a lifetime with your favorite fiends in pink"));

        openCask = mMap.addMarker(new MarkerOptions()
                .position(LOC_OPEN_CASK)
                .title("OPEN CASKet")
                .snippet("The dead are alive and so is the fun at the OPEN CASKet bar"));

        bloodBanq = mMap.addMarker(new MarkerOptions()
                .position(LOC_BLOOD_BANQ)
                .title("Blood Banquet")
                .snippet("Join Count Vlad and a host of paranormal characters for a truly otherworldly eating experience"));

        bucGallery = mMap.addMarker(new MarkerOptions()
                .position(LOC_BUC_GALLERY)
                .title("Buccaneer Gallery")
                .snippet("the gallery, the hostess, and her cutthroat crew serve up a captains feast buffet-style"));

        frightFeast = mMap.addMarker(new MarkerOptions()
                .position(LOC_FRIGHT_FEAST)
                .title("Fright Feast")
                .snippet("Experiment with the surgeon, his assistant and their kooky monster"));

        demonDrinks = mMap.addMarker(new MarkerOptions()
                .position(LOC_DEMON_DRINKS)
                .title("Demon Drinks")
                .snippet("Demon Drinks'DJ and his too-hot-to-handle hosts are happy to serve guest as they fan the flames of fun"));

        pirateArg = mMap.addMarker(new MarkerOptions()
                .position(LOC_PIRATE_ARG)
                .title("Pirate Baarrrgh")
                .snippet("Grab a swill o' the grog stolen from Davy Jones' locker and mingle with the likes of Peg Leg Pete, Billy Bones and Blackbeard"));

        plankBar = mMap.addMarker(new MarkerOptions()
                .position(LOC_PLANK_BAR)
                .title("Walk the Plank bar"));

    }

    public void addZonesToMap(){

        //terror zones (red)
        CircleOptions demonGeo = new CircleOptions()
                .center(LOC_DEMON_STREET)
                .radius(60)
                .fillColor(0x40ff0000)
                .strokeColor(Color.TRANSPARENT)
                .strokeWidth(2);
        Circle demonZone = mMap.addCircle(demonGeo);
        demonStreet = mMap.addMarker(new MarkerOptions()
                .position(LOC_DEMON_STREET)
                .title("Demon Street")
                .snippet("Paris is burning, can you escape before the city is engulfed in flames?")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));


        CircleOptions portGeo = new CircleOptions()
                .center(LOC_PORTS)
                .radius(80)
                .fillColor(0x40ff0000)
                .strokeColor(Color.TRANSPARENT)
                .strokeWidth(2);
        Circle portZone= mMap.addCircle(portGeo);
        ports = mMap.addMarker(new MarkerOptions()
                .position(LOC_PORTS)
                .title("Ports of Skull")
                .snippet("The Jolly Roger has risen over a ship graveyard filled with lost souls doomed to haunt the vessels they once sailed")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));


        CircleOptions ripperGeo = new CircleOptions()
                .center(LOC_RIPPER_ROW)
                .radius(60)
                .fillColor(0x40ff0000)
                .strokeColor(Color.TRANSPARENT)
                .strokeWidth(2);
        Circle ripperZone = mMap.addCircle(ripperGeo);
        ripperRow = mMap.addMarker(new MarkerOptions()
                .position(LOC_RIPPER_ROW)
                .title("Ripper Row")
                .snippet("Things are looking a bit unsettling in England with a murderer on the loose plucking unsuspecting victims from the city streets")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));


        CircleOptions vampireGeo = new CircleOptions()
                .center(LOC_VAMPIRE_POINT)
                .radius(80)
                .fillColor(0x40ff0000)
                .strokeColor(Color.TRANSPARENT)
                .strokeWidth(2);
        Circle vampireZone = mMap.addCircle(vampireGeo);
        vampirePoint = mMap.addMarker(new MarkerOptions()
                .position(LOC_VAMPIRE_POINT)
                .title("Vampire Point")
                .snippet("even vampires need a vacation once in a while and Vampire Point is the perfect destination for bloodsuckers")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));



        //shouldnt be scary hamlet zones (green)
        CircleOptions heatherGeo = new CircleOptions()
                .center(LOC_HEATHERDOWNS)
                .radius(50)
                .fillColor(0x4000FF00)
                .strokeColor(Color.TRANSPARENT)
                .strokeWidth(2);
        Circle heatherZone = mMap.addCircle(heatherGeo);
        hosHeatehrdowns = mMap.addMarker(new MarkerOptions()
                .position(LOC_HEATHERDOWNS)
                .title("Pumpkins")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));


        CircleOptions irelandGeo = new CircleOptions()
                .center(LOC_IRELAND)
                .radius(80)
                .fillColor(0x4000FF00)
                .strokeColor(Color.TRANSPARENT)
                .strokeWidth(2);
        Circle irelandZone = mMap.addCircle(irelandGeo);
        hosIreland = mMap.addMarker(new MarkerOptions()
                .position(LOC_IRELAND)
                .title("Frankenstein's Laboratory")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));



        //mild scary hamlet zones (yellow)
        CircleOptions newFranceGeo = new CircleOptions()
                .center(LOC_NEW_FRANCE)
                .radius(65)
                .fillColor(0x40FFFF00)
                .strokeColor(Color.TRANSPARENT)
                .strokeWidth(2);
        Circle newFranceZone = mMap.addCircle(newFranceGeo);
        hosNewFrance = mMap.addMarker(new MarkerOptions()
                .position(LOC_NEW_FRANCE)
                .title("Spiders")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));


        CircleOptions wildGeo = new CircleOptions()
                .center(LOC_WILD)
                .radius(60)
                .fillColor(0x40FFFF00)
                .strokeColor(Color.TRANSPARENT)
                .strokeWidth(2);
        Circle wildZone = mMap.addCircle(wildGeo);
        hosWild = mMap.addMarker(new MarkerOptions()
                .position(LOC_WILD)
                .title("Ghost")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));


        CircleOptions festaGeo = new CircleOptions()
                .center(LOC_PORTS_FESTA)
                .radius(70)
                .fillColor(0x40FFFF00)
                .strokeColor(Color.TRANSPARENT)
                .strokeWidth(2);
        Circle festaZone = mMap.addCircle(festaGeo);
        portsFesta = mMap.addMarker(new MarkerOptions()
                .position(LOC_PORTS_FESTA)
                .title("Ports of Skull")
                .snippet("Part of Ports of Skull")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

    }


    public void addEnglandToMap(){

        CircleOptions ripperGeo = new CircleOptions()
                .center(LOC_RIPPER_ROW)
                .radius(60)
                .fillColor(0x40ff0000)
                .strokeColor(Color.TRANSPARENT)
                .strokeWidth(2);
        Circle ripperZone = mMap.addCircle(ripperGeo);
        ripperRow = mMap.addMarker(new MarkerOptions()
                .position(LOC_RIPPER_ROW)
                .title("Ripper Row")
                .snippet("Things are looking a bit unsettling in England with a murderer on the loose plucking unsuspecting victims from the city streets")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        final CameraPosition england =
                new CameraPosition.Builder().target(LOC_RIPPER_ROW)
                        .zoom(17)
                        .bearing(0)
                        .tilt(25)
                        .build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(england));

    }

    public void addIrelandToMap(){

        incoStation = mMap.addMarker(new MarkerOptions()
                .position(LOC_INOC_STATION)
                .title("Inoculation Station")
                .snippet("No appointments necessary for the shot of a lifetime with your favorite fiends in pink"));

        frightFeast = mMap.addMarker(new MarkerOptions()
                .position(LOC_FRIGHT_FEAST)
                .title("Fright Feast")
                .snippet("Experiment with the surgeon, his assistant and their kooky monster"));

        thirteen = mMap.addMarker(new MarkerOptions()
                .position(LOC_THIRTEEN)
                .title("13: Your Numbers Up")
                .snippet("For 13 long years, the dark tower was locked away from the world... " +
                        "only exisiting in the nightmares of those who had dared to experience " +
                        "Howl-O-Scream's first and most terrifying maze"));

        fiends = mMap.addMarker(new MarkerOptions()
                .position(LOC_FIENDS)
                .title("Fiends")
                .snippet("The wacky doctor and his manic nurses are creating the ultimate Fiends, " +
                        "and there's not a bad seat in the lab"));

        CircleOptions irelandGeo = new CircleOptions()
                .center(LOC_IRELAND)
                .radius(80)
                .fillColor(0x4000FF00)
                .strokeColor(Color.TRANSPARENT)
                .strokeWidth(2);
        Circle irelandZone = mMap.addCircle(irelandGeo);
        hosIreland = mMap.addMarker(new MarkerOptions()
                .position(LOC_IRELAND)
                .title("Frankenstein's Laboratory")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        final CameraPosition ireland =
                new CameraPosition.Builder().target(LOC_IRELAND)
                        .zoom(17)
                        .bearing(0)
                        .tilt(25)
                        .build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(ireland));

    }

    public void addAquToMap(){

        CircleOptions demonGeo = new CircleOptions()
                .center(LOC_DEMON_STREET)
                .radius(60)
                .fillColor(0x40ff0000)
                .strokeColor(Color.TRANSPARENT)
                .strokeWidth(2);
        Circle demonZone = mMap.addCircle(demonGeo);
        demonStreet = mMap.addMarker(new MarkerOptions()
                .position(LOC_DEMON_STREET)
                .title("Demon Street")
                .snippet("Paris is burning, can you escape before the city is engulfed in flames?")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));


        CircleOptions newFranceGeo = new CircleOptions()
                .center(LOC_NEW_FRANCE)
                .radius(65)
                .fillColor(0x40FFFF00)
                .strokeColor(Color.TRANSPARENT)
                .strokeWidth(2);
        Circle newFranceZone = mMap.addCircle(newFranceGeo);
        hosNewFrance = mMap.addMarker(new MarkerOptions()
                .position(LOC_NEW_FRANCE)
                .title("Spiders")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        catacombs = mMap.addMarker(new MarkerOptions()
                .position(LOC_CATACOMBS)
                .title("Catacombs")
                .snippet("Through a ruined cemetery filled with statues lies a tunnel that leads to an underground city. " +
                        "It's history is more terrifying than that of France's worst revolutions"));


        demonDrinks = mMap.addMarker(new MarkerOptions()
                .position(LOC_DEMON_DRINKS)
                .title("Demon Drinks")
                .snippet("Demon Drinks'DJ and his too-hot-to-handle hosts are happy to serve guest as they fan the flames of fun"));

        final CameraPosition france =
                new CameraPosition.Builder().target(LOC_DEMON_STREET)
                        .zoom(17)
                        .bearing(0)
                        .tilt(25)
                        .build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(france));

    }

    public void addRhinefeldToMap(){

        CircleOptions vampireGeo = new CircleOptions()
                .center(LOC_VAMPIRE_POINT)
                .radius(80)
                .fillColor(0x40ff0000)
                .strokeColor(Color.TRANSPARENT)
                .strokeWidth(2);
        Circle vampireZone = mMap.addCircle(vampireGeo);
        vampirePoint = mMap.addMarker(new MarkerOptions()
                .position(LOC_VAMPIRE_POINT)
                .title("Vampire Point")
                .snippet("even vampires need a vacation once in a while and Vampire Point is the perfect destination for bloodsuckers")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));


        bloodBanq = mMap.addMarker(new MarkerOptions()
                .position(LOC_BLOOD_BANQ)
                .title("Blood Banquet")
                .snippet("Join Count Vlad and a host of paranormal characters for a truly otherworldly eating experience"));

        root = mMap.addMarker(new MarkerOptions()
                .position(LOC_ROOT)
                .title("Root of All Evil")
                .snippet("The seeds of evil have been sown. Venture if you dare into a decrepit greenhouse"));

        final CameraPosition rhine =
                new CameraPosition.Builder().target(LOC_VAMPIRE_POINT)
                        .zoom(17)
                        .bearing(0)
                        .tilt(25)
                        .build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(rhine));

    }

    public void addOktoberToMap(){

        bitten = mMap.addMarker(new MarkerOptions()
                .position(LOC_BITTEN)
                .title("Bitten")
                .snippet("1800's Eastern Europe house full of legends and lore of vampires, that prey on the innocent"));

        nightBeats = mMap.addMarker(new MarkerOptions()
                .position(LOC_NIGHT)
                .title("Night Beats")
                .snippet("Things that go bump in the night sing, dance and transport you on a musical journey"));

        openCask = mMap.addMarker(new MarkerOptions()
                .position(LOC_OPEN_CASK)
                .title("OPEN CASKet")
                .snippet("The dead are alive and so is the fun at the OPEN CASKet bar"));

        final CameraPosition okt =
                new CameraPosition.Builder().target(LOC_OPEN_CASK)
                        .zoom(17)
                        .bearing(0)
                        .tilt(25)
                        .build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(okt));
    }

    public void addItalyToMap(){

        CircleOptions portGeo = new CircleOptions()
                .center(LOC_PORTS)
                .radius(80)
                .fillColor(0x40ff0000)
                .strokeColor(Color.TRANSPARENT)
                .strokeWidth(2);
        Circle portZone= mMap.addCircle(portGeo);
        ports = mMap.addMarker(new MarkerOptions()
                .position(LOC_PORTS)
                .title("Ports of Skull")
                .snippet("The Jolly Roger has risen over a ship graveyard filled with lost souls doomed to haunt the vessels they once sailed")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        CircleOptions festaGeo = new CircleOptions()
                .center(LOC_PORTS_FESTA)
                .radius(70)
                .fillColor(0x40FFFF00)
                .strokeColor(Color.TRANSPARENT)
                .strokeWidth(2);
        Circle festaZone = mMap.addCircle(festaGeo);
        portsFesta = mMap.addMarker(new MarkerOptions()
                .position(LOC_PORTS_FESTA)
                .title("Ports of Skull")
                .snippet("Part of Ports of Skull")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        bucGallery = mMap.addMarker(new MarkerOptions()
                .position(LOC_BUC_GALLERY)
                .title("Buccaneer Gallery")
                .snippet("the gallery, the hostess, and her cutthroat crew serve up a captains feast buffet-style"));

        cove = mMap.addMarker(new MarkerOptions()
                .position(LOC_COVE)
                .title("Cut Throat Cove")
                .snippet("The haven for bloodthirsty, dangerous rouges - where the scurvy dogs, buccaneers and scoundrels go for shelter"));

        dig = mMap.addMarker(new MarkerOptions()
                .position(LOC_DIG)
                .title("Dig it Up!")
                .snippet("Relics long forgotten and buried in the vaults of the Museo di San Marco " +
                        "have recently been dug up, dusted off and brought to life through song"));

        pirateArg = mMap.addMarker(new MarkerOptions()
                .position(LOC_PIRATE_ARG)
                .title("Pirate Baarrrgh")
                .snippet("Grab a swill o' the grog stolen from Davy Jones' locker and mingle with the likes of Peg Leg Pete, Billy Bones and Blackbeard"));

        deadline = mMap.addMarker(new MarkerOptions()
                .position(LOC_DEADLINE)
                .title("Deadline")
                .snippet("Deep underground, construction of the newest line of the Pompeii Metro was moving smoothly until an ancient pipe was accidentally struck"));

        plankBar = mMap.addMarker(new MarkerOptions()
                .position(LOC_PLANK_BAR)
                .title("Walk the Plank bar"));

        final CameraPosition italy =
                new CameraPosition.Builder().target(LOC_PORTS)
                        .zoom(17)
                        .bearing(0)
                        .tilt(25)
                        .build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(italy));

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.hosmapmenu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.hos_clear:
                mMap.clear();
                break;
            case R.id.hos_all:
                mMap.clear();
                addHosHousesToMap();
                addHosShowsToMap();
                addZonesToMap();
                addCulinaryToMap();
                break;
            case R.id.hos_houses:
                mMap.clear();
                addHosHousesToMap();
                break;
            case R.id.hos_shows:
                mMap.clear();
                addHosShowsToMap();
                break;
            case R.id.hos_terror:
                mMap.clear();
                addZonesToMap();
                break;
            case R.id.hos_eat:
                mMap.clear();
                addCulinaryToMap();
                break;
            case R.id.banbury:
                mMap.clear();
                addEnglandToMap();
                break;
            case R.id.ireland:
                mMap.clear();
                addIrelandToMap();
                break;
            case R.id.aquitaine:
                mMap.clear();
                addAquToMap();
                break;
            case R.id.rhinefeld:
                mMap.clear();
                addRhinefeldToMap();
                break;
            case R.id.oktoberfest:
                mMap.clear();
                addOktoberToMap();
                break;
            case R.id.italy:
                mMap.clear();
                addItalyToMap();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = savedInstanceState;
    }



    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory(){
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onStart() {
        super.onStart();
        EasyTracker.getInstance().activityStart(getActivity()); // Add this method.
    }

    @Override
    public void onStop() {
        super.onStop();
        EasyTracker.getInstance().activityStop(getActivity()); // Add this method.
    }

}
