package com.david.bgtfans.bgt.fragments;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.david.bgtfans.R;
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
 * Created by david.hodge on 2/4/14.
 */
public class ParkMap extends SherlockFragment {


    //BGT Coasters
    //Xmas attractions
    private static final LatLng LOC_MISTLETOE_MARKETPLACE = new LatLng(37.231774,-76.646398);
    private Marker mistoleMarket;

    private static final LatLng LOC_HOLIDAY_HILLS = new LatLng(37.234467,-76.642219);
    private Marker holidayHills;

    private static final LatLng LOC_POLAR_PATHWAY = new LatLng(37.235689,-76.644305);
    private Marker polarPath;

    private static final LatLng LOC_HIGHLAND_STABLES = new LatLng(37.235398,-76.646054);
    private Marker highlandStables;

    private static final LatLng LOC_ICE_PALACE = new LatLng(37.234609,-76.649042);
    private Marker icePalace;

    private static final LatLng LOC_SANTA_FIRESIDE = new LatLng(37.236272,-76.647857);
    private Marker santaFireside;

    private static final LatLng LOC_SANTA_WORKSHOP = new LatLng(37.233255,-76.646657);
    private Marker santaWorkshop;

    //xmas places to eat
    private static final LatLng LOC_COCOA_CAFE = new LatLng(0,0);
    private Marker cocoaCafe;

    private static final LatLng LOC_DASHER_DINER = new LatLng(37.23455,-76.641435);
    private Marker dasherDiner;

    private static final LatLng LOC_CONFEC_FACTORY = new LatLng(0,0);
    private Marker confecFactory;

    private static final LatLng LOC_SQUIRE_GRILLE = new LatLng(0,0);
    private Marker squireGrille;

    private static final LatLng LOC_BRIT_BAKER = new LatLng(0,0);
    private Marker britBaker;

    private static final LatLng LOC_CAFE_LULU = new LatLng(0,0);
    private Marker cafeLulu;

    private static final LatLng LOC_COFFEE_CREPES = new LatLng(0,0);
    private Marker coffeeCrepes;

    private static final LatLng LOC_TRAPPERS_SHOW_GRILL = new LatLng(0,0);
    private Marker trapperShowGrill;

    private static final LatLng LOC_TRAPPERS_SMOKEHOUSE = new LatLng(37.233805,-76.64875);
    private Marker trapperSmokehouse;

    private static final LatLng LOC_ANNIE_CAFE= new LatLng(37.233673,-76.648673);
    private Marker annieCafe;

    private static final LatLng LOC_GROGAN_GRILL = new LatLng(0,0);
    private Marker groganGrill;

    private static final LatLng LOC_GROGAN_PUB = new LatLng(0,0);
    private Marker groganPub;

    private static final LatLng LOC_SANTA_FEAST = new LatLng(0,0);
    private Marker santaFeast;

    private static final LatLng LOC_FROST_BITES = new LatLng(0,0);
    private Marker frostBites;

    private static final LatLng LOC_DELLA_PIAZZA = new LatLng(0,0);
    private Marker dellaPiazza;

    private static final LatLng LOC_VINO_NATALE = new LatLng(0,0);
    private Marker vinoNatale;

    private static final LatLng LOC_DAS_EDELWEISS = new LatLng(0,0);
    private Marker dasEdelweiss;

    private static final LatLng LOC_GINGERBREAD_HAUS = new LatLng(0,0);
    private Marker gingerbreadHouse;

    private static final LatLng LOC_BESTE_BIER = new LatLng(0,0);
    private Marker besteBier;

    private static final LatLng LOC_DAS_FESTHUAS = new LatLng(0,0);
    private Marker dasFesthuas;

    private static final LatLng LOC_TANNENBAUM_TREATS = new LatLng(0,0);
    private Marker tannenbaumTreats;

    //xmas shows
    private static final LatLng LOC_DECK_THE_HALLS = new LatLng(37.231343,-76.646226);
    private Marker deckTheHalls;

    private static final LatLng LOC_GLORIA = new LatLng(37.236094,-76.647996);
    private Marker gloria;

    private static final LatLng LOC_MIRACLES = new LatLng(37.233491,-76.644021);
    private Marker miracles;

    private static final LatLng LOC_O_TANNENBAUM = new LatLng(37.231565,-76.646263);
    private Marker oTannenbaum;


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
        addAttractionsToMap();
        addShowsToMap();
        addFoodToMap();
    }

    private void setUpMapIfNeeded(View view){
        if(mMap == null){
            mMap = ((MapView) view.findViewById(R.id.map)).getMap();
            if(mMap != null){
                setUpMap();
            }
        }

    }

    private void addAttractionsToMap(){

        CircleOptions portGeo = new CircleOptions()
                .center(LOC_HOLIDAY_HILLS)
                .radius(80)
                .fillColor(0x66FFFFFF)
                .strokeColor(Color.TRANSPARENT)
                .strokeWidth(2);
        Circle portZone= mMap.addCircle(portGeo);
        holidayHills = mMap.addMarker(new MarkerOptions()
                .position(LOC_HOLIDAY_HILLS)
                .title("Holiday Hills")
                .snippet("Experience a Christmas from your past!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));

        mistoleMarket = mMap.addMarker(new MarkerOptions()
                .position(LOC_MISTLETOE_MARKETPLACE)
                .title("Mistletoe Marketplace")
                .snippet("Merriment and cheer abound in Germany amid the hustle and bustle of local artisans and crafts in our traditional outdoor German market."));

        polarPath = mMap.addMarker(new MarkerOptions()
                .position(LOC_POLAR_PATHWAY)
                .title("Polar Pathway")
                .snippet("Polar Pathway turns Escape from Pompeii into breathtaking waterfalls of light"));

        highlandStables = mMap.addMarker(new MarkerOptions()
                .position(LOC_HIGHLAND_STABLES)
                .title("Highland Stables")
                .snippet("Travel back to simpler times and explore the Scottish countryside under a star-filled wintery sky during Christmas Town®."));

        icePalace = mMap.addMarker(new MarkerOptions()
                .position(LOC_ICE_PALACE)
                .title("Ice Palace: A Penguin Paradise")
                .snippet("Come to France to explore an ice-themed world with dazzling lights, snow and an up-close encounter with live penguins."));

        santaFeast = mMap.addMarker(new MarkerOptions()
                .position(LOC_SANTA_FEAST)
                .title("Santa's Fireside Feast")
                .snippet("The grand dining room of Castle O’Sullivan springs to life as Santa and Mrs. Claus host the most intimate and exclusive event of the season, Santa’s "));

        santaWorkshop = mMap.addMarker(new MarkerOptions()
                .position(LOC_SANTA_WORKSHOP)
                .title("Santa's Workshop")
                .snippet("Create memories that will last a lifetime at Christmas Town®."));

    }

    private void addShowsToMap(){

        deckTheHalls = mMap.addMarker(new MarkerOptions()
                .position(LOC_DECK_THE_HALLS)
                .title("Deck the Halls")
                .snippet("Warm up inside Das Festhaus with a live musical tribute to Christmas traditions, and create new ones with your family this holiday season."));

        gloria = mMap.addMarker(new MarkerOptions()
                .position(LOC_GLORIA)
                .title("Gloria!")
                .snippet("The greatest story ever told comes to life as only Busch Gardens can imagine."));

        miracles = mMap.addMarker(new MarkerOptions()
                .position(LOC_MIRACLES)
                .title("Miracles")
                .snippet("Celebrate the spirit of Christmas through powerful movement and dance."));

        oTannenbaum = mMap.addMarker(new MarkerOptions()
                .position(LOC_O_TANNENBAUM)
                .title("O Tannenbaum")
                .snippet("The culmination of your Christmas Town experience unfolds in a larger than life format with the spectacular lightshow, O Tannenbaum."));

    }

    private void addFoodToMap(){

        confecFactory = mMap.addMarker(new MarkerOptions()
                .position(LOC_CONFEC_FACTORY)
                .title("M. Sweets Confectionary Factory")
                .snippet("Nothing says “Christmas” like a sweet shop.  England’s favorite destination for children of all ages features the candy you loved as a child, and today’s holiday confections.  Snack as you walk through the streets of England, or take a box home to extend the warmth of your Christmas Town experience."));

        squireGrille = mMap.addMarker(new MarkerOptions()
                .position(LOC_SQUIRE_GRILLE)
                .title("Squire's Grille")
                .snippet("England’s Squire’s Grille is nestled like a special treasure in the town square.  Decorated for the holidays and brimming with good cheer, family and friends can feast on a steaming bowl of Brunswick stew served in a bread bowl and finish with a delectable dessert.  Take a break from winter’s chill for a quick snack in regal holiday surroundings. "));

        britBaker = mMap.addMarker(new MarkerOptions()
                .position(LOC_BRIT_BAKER)
                .title("British Baker")
                .snippet("Awaken your senses with a warm funnel cake topped with powdered sugar, prepared right before your eyes at The British Baker.  Savor your sweet treat’s aroma and the holiday moment in England’s picturesque Banbury Cross."));

        cafeLulu = mMap.addMarker(new MarkerOptions()
                .position(LOC_CAFE_LULU)
                .title("Cafe Lulu")
                .snippet("As you enjoy Christmas Town’s dazzling holiday lights and cheerful holiday tunes, enhance your experience with a warm beverage from Café Lulu"));

        coffeeCrepes = mMap.addMarker(new MarkerOptions()
                .position(LOC_COFFEE_CREPES)
                .title("Coffee & Crepes")
                .snippet("Enjoy delectable crepes and hot beverages that are sure to awaken your senses."));

        trapperShowGrill = mMap.addMarker(new MarkerOptions()
                .position(LOC_TRAPPERS_SHOW_GRILL)
                .title("Trappers Show Grill")
                .snippet("Take in the savory smells of freshly smoked turkey legs, pork shanks, hot dogs and sausages."));

        trapperSmokehouse = mMap.addMarker(new MarkerOptions()
                .position(LOC_TRAPPERS_SMOKEHOUSE)
                .title("Trappers Smokehouse")
                .snippet("Walking through New France’s evergreen forest, nestled with cabins and rustic antiquities, the smell of hot wassail will rekindle your feelings of Christmas in the country."));

        cocoaCafe = mMap.addMarker(new MarkerOptions()
                .position(LOC_COCOA_CAFE)
                .title("Cocoa Cafe")
                .snippet("Savor the sweet aroma of Ghirardelli® hot chocolate, and enjoy a sweet treat of brownies and cookies."));

        dasherDiner = mMap.addMarker(new MarkerOptions()
                .position(LOC_DASHER_DINER)
                .title("Dasher's Diner")
                .snippet("Christmas Town is so special that one of Santa’s favorite reindeer has its own eatery.  Dasher’s Diner is a retro American diner serving childhood favorites and an all-you-care-to-eat buffet that will give the entire family great food options."));

        annieCafe = mMap.addMarker(new MarkerOptions()
                .position(LOC_ANNIE_CAFE)
                .title("Annie's Cafe")
                .snippet("After you've reveled in Christmas Town’s festive spirit and frosty air, Annie’s Café has a selection of hot beverages to warm you. Choose from a wide variety of Starbucks’ holiday coffees and espresso drinks."));

        groganGrill = mMap.addMarker(new MarkerOptions()
                .position(LOC_GROGAN_GRILL)
                .title("Grogran's Grill")
                .snippet("The Irish are known for hearty fare, so visit Grogran’s Grill which features great hot soups and hand-carved turkey sandwiches, all served with Christmas verve.  You will be warmed by the Irish hospitality that is alive in Christmas Town. "));

        groganPub = mMap.addMarker(new MarkerOptions()
                .position(LOC_GROGAN_PUB)
                .title("Grogan's Pub")
                .snippet("Toast the season with a pint at Grogan’s Pub’s hand-carved antique bar.  Or, nestle with your family in one of the many booths and enjoy hot toddies or festive cocktails."));

        santaFireside = mMap.addMarker(new MarkerOptions()
                .position(LOC_SANTA_FIRESIDE)
                .title("Santa's Fireside Feast")
                .snippet("You’re invited to Santa’s Fireside Feast in Ireland’s Castle O’Sullivan’s grand dining room.  It is Christmas Town’s most intimate and exclusive event of the season."));

        frostBites = mMap.addMarker(new MarkerOptions()
                .position(LOC_FROST_BITES)
                .title("Frost Bites")
                .snippet("Enjoy homemade doughnut holes and delicious warm beverages for the whole family."));

        dellaPiazza = mMap.addMarker(new MarkerOptions()
                .position(LOC_DELLA_PIAZZA)
                .title("Ristorante della Piazza")
                .snippet("Gather around the holiday table at Italy’s Ristorante della Piazza, decked for the holidays and rich with the warmth of traditional Italian favorites including pastas, sandwiches, salads and desserts."));

        vinoNatale = mMap.addMarker(new MarkerOptions()
                .position(LOC_VINO_NATALE)
                .title("Vino di Natale")
                .snippet("Chase away winter’s chill with a glass of your favorite vino, our signature hot chocolate or holiday wassail. A sophisticated toast to the holiday season!"));

        dasEdelweiss = mMap.addMarker(new MarkerOptions()
                .position(LOC_DAS_EDELWEISS)
                .title("Das Edelweiss")
                .snippet("Stop in for a savory schnitzel sandwich or a delightful chicken and funnel cake entree."));

        gingerbreadHouse = mMap.addMarker(new MarkerOptions()
                .position(LOC_GINGERBREAD_HAUS)
                .title("Das Gingerbread Haus")
                .snippet("Enjoy some of your favorite confections at Das Gingerbread Haus, including homemade fudge, gourmet-dipped apples and delicious hot beverages."));

        besteBier = mMap.addMarker(new MarkerOptions()
                .position(LOC_BESTE_BIER)
                .title("Beste Brezeln und Bier")
                .snippet("After marveling at Germany’s 50-foot light animated tree, sneak a peek at our bakers hand rolling and twisting pretzels along with making other holiday goodies"));

        dasFesthuas = mMap.addMarker(new MarkerOptions()
                .position(LOC_DAS_FESTHUAS)
                .title("Das Festhaus")
                .snippet("Dine in glorious holiday style at Das Festhaus, festooned with Christmas garlands and multi-colored lights"));

        tannenbaumTreats = mMap.addMarker(new MarkerOptions()
                .position(LOC_TANNENBAUM_TREATS)
                .title("Tannenbaum Treats™")
                .snippet("Enjoy a delicious array of specialty Coca-Cola® drinks and treats."));

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.xmasmap, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.xmas_attr:
                mMap.clear();
                addAttractionsToMap();
                break;
            case R.id.xmas_eat:
                mMap.clear();
                addFoodToMap();
                break;
            case R.id.xmas_shows:
                mMap.clear();
                addShowsToMap();
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
