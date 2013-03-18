package com.david.bgwfans;

import android.app.ActionBar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuInflater;
import android.widget.SeekBar;

import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;


public class ParkMap extends BaseActivity {	

    private GoogleMap mMap;
    //geo points for all the roller coasters in the park
    private static final LatLng VBOLT = new LatLng(37.232449, -76.645534);
    private Marker vbolt;
    private static final LatLng ALPEN = new LatLng(37.232821, -76.647430);
    private Marker alpen;
    private static final LatLng APOLLO = new LatLng(37.234992, -76.642588);
    private Marker apollo;
    private static final LatLng GRIFFON = new LatLng(37.234516, -76.648023);
    private Marker griffon;
    private static final LatLng LOCH = new LatLng(37.234728, -76.646113);
    private Marker loch;
    private static final LatLng GROVER = new LatLng(37.236186, -76.644455);
    private Marker grover;

    //geo points for all the "flat" and "dark" rides in the park
    private static final LatLng MACH = new LatLng(37.232588, -76.645552);
    private Marker mach;
    private static final LatLng CASTLE = new LatLng(37.232181, -76.64655);
    private Marker castle;
    private static final LatLng EITA = new LatLng(37.235983, -76.64745);
    private Marker eita;
    private static final LatLng AUTO = new LatLng(37.231535, -76.645713);
    private Marker auto;
    private static final LatLng CRADLE = new LatLng(37.234559, -76.643358);
    private Marker cradle;
    private static final LatLng MACHINE = new LatLng(37.234747, -76.643374);
    private Marker machine;
    private static final LatLng WIND = new LatLng(37.232101, -76.6457);
    private Marker wind;
    private static final LatLng TWIND = new LatLng(37.234394, -76.642012);
    private Marker twind;
    private static final LatLng CATAPULT = new LatLng(37.233352, -76.649015);
    private Marker catapult;
    private static final LatLng DELIGHT = new LatLng(37.234546, -76.642438);
    private Marker delight;
    private static final LatLng RAM = new LatLng(37.234798, -76.643428);
    private Marker ram;

    //geo points for all the water rides in the park
    private static final LatLng SCOOT = new LatLng(37.233046, -76.648452);
    private Marker scoot;
    private static final LatLng POMPEII = new LatLng(37.235597, -76.64467);
    private Marker pompeii;
    private static final LatLng RAPID = new LatLng(37.234292, -76.641388);
    private Marker rapid;

    //geo points for transport attractions in the park
    private static final LatLng ETRAIN = new LatLng(37.235323, -76.645719);
    private Marker etrain;
    private static final LatLng FTRAIN = new LatLng(37.234245, -76.64245);
    private Marker ftrain;
    private static final LatLng NTRAIN = new LatLng(37.232983, -76.649069);
    private Marker ntrain;
    private static final LatLng RSKYRIDE = new LatLng(37.233228, -76.645984);
    private Marker rskyride;
    private static final LatLng ESKYRIDE = new LatLng(37.235928, -76.645437);
    private Marker eskyride;
    private static final LatLng ASKYRIDE = new LatLng(37.234617, -76.648591);
    private Marker askyride;
    private static final LatLng RRC = new LatLng(37.233472, -76.645332);
    private Marker rrc;

    //geo points for the animal attractions in the park
    private static final LatLng GLEN = new LatLng(37.235405, -76.649079);
    private Marker glen;
    private static final LatLng STABLES = new LatLng(37.235476, -76.646315);
    private Marker stables;
    private static final LatLng RIDGE = new LatLng(37.236187, -76.64854);
    private Marker ridge;
    private static final LatLng VALLEY = new LatLng(37.236058, -76.648782);
    private Marker valley;

    //geo points for the main eating areas in the park
    private static final LatLng BEER = new LatLng(37.232464, -76.64566);
    private Marker beer;
    private static final LatLng FESTHAUS = new LatLng(37.2314, -76.646201);
    private Marker festhaus;
    private static final LatLng SMOKEHOUSE = new LatLng(37.23381, -76.648819);
    private Marker smokehouse;
    private static final LatLng PIAZZA = new LatLng(37.233835, -76.643954);
    private Marker piazza;
    private static final LatLng GRILLE = new LatLng(37.236133, -76.645618);
    private Marker grille;
    private static final LatLng CUCINA = new LatLng(37.234501, -76.641524);
    private Marker cucina;
    private static final LatLng PUB = new LatLng(37.236011, -76.647567);
    private Marker pub;
    private static final LatLng GRILL = new LatLng(37.235862, -76.647386);
    private Marker grill;

    //geo points for all shows in the park'
    private static final LatLng ENGLANDSHOW = new LatLng(37.236323, -76.645976);
    private Marker englandshow;
    private static final LatLng ITALYSHOW = new LatLng(37.233538, -76.644061);
    private Marker italyshow;
    private static final LatLng FESTSHOW = new LatLng(37.231193, -76.64626);
    private Marker festshow;
    private static final LatLng FRENCHSHOW = new LatLng(37.234251, -76.649176);
    private Marker frenchshow;
    private static final LatLng PETSHOW = new LatLng(37.235649, -76.648825);
    private Marker petshow;
    private static final LatLng IRELANDSHOW = new LatLng(37.236089, -76.647955);
    private Marker irelandshow;

    //geo points for all bathrooms in the park
    private Marker b1;
    private static final LatLng B1 = new LatLng(37.235452, -76.645974);
    private Marker b2;
    private static final LatLng B2 = new LatLng(37.236357, -76.645663);
    private Marker b3;
    private static final LatLng B3 = new LatLng(37.234975, -76.649074);
    private Marker b4;
    private static final LatLng B4 = new LatLng(37.235768, -76.647556);
    private Marker b5;
    private static final LatLng B5 = new LatLng(37.236265, -76.647742);
    private Marker b6;
    private static final LatLng B6 = new LatLng(37.234072, -76.648717);
    private Marker b7;
    private static final LatLng B7 = new LatLng(37.233079, -76.646847);
    private Marker b8;
    private static final LatLng B8 = new LatLng(37.231436, -76.646203);
    private Marker b9;
    private static final LatLng B9 = new LatLng(37.233756, -76.643855);
    private Marker b10;
    private static final LatLng B10 = new LatLng(37.234635, -76.641682);
    private Marker b11;
    private static final LatLng B11 = new LatLng(37.237228, -76.645271);

    //geo points for ATM's in the park
    private Marker a1;
    private static final LatLng A1 = new LatLng(37.236391, -76.646529);
    private Marker a2;
    private static final LatLng A2 = new LatLng(37.234191, -76.648491);
    private Marker a3;
    private static final LatLng A3 = new LatLng(37.231714, -76.646054);

    //geopoints for main shops in the park
    private Marker s1;
    private static final LatLng S1 = new LatLng(37.235307, -76.645841);
    private Marker s2;
    private static final LatLng S2 = new LatLng(37.235614, -76.647399);
    private Marker s3;
    private static final LatLng S3 = new LatLng(37.235844, -76.64765);
    private Marker s4;
    private static final LatLng S4 = new LatLng(37.234529, -76.648741);
    private Marker s5;
    private static final LatLng S5 = new LatLng(37.233398, -76.648453);
    private Marker s6;
    private static final LatLng S6 = new LatLng(37.232947, -76.646853);
    private Marker s7;
    private static final LatLng S7 = new LatLng(37.232238, -76.646329);
    private Marker s8;
    private static final LatLng S8 = new LatLng(37.233964, -76.644144);
    private Marker s9;
    private static final LatLng S9 = new LatLng(37.23486, -76.642759);
    private Marker s10;
    private static final LatLng S10 = new LatLng(37.236154, -76.646235);

    //set up ploygons for each hamlet in the park
    private Polygon England;
    private Polygon Banbury;
    private Tracker mGaTracker;
    private GoogleAnalytics mGaInstance;


    static final CameraPosition HOME =
            new CameraPosition.Builder().target(new LatLng(37.235466, -76.646328))
                    .zoom(17)
                    .bearing(0)
                    .tilt(25)
                    .build();

    static final CameraPosition COASTER =
            new CameraPosition.Builder().target(new LatLng(37.232449, -76.645534))
                    .zoom(17)
                    .bearing(0)
                    .tilt(25)
                    .build();

    private void addAnimalToMap() {
        glen = mMap.addMarker(new MarkerOptions()
                .position(GLEN)
                .title("Lorikeet Glen")
                .snippet("bird exhibit"));

        stables = mMap.addMarker(new MarkerOptions()
                .position(STABLES)
                .title("Highland Stables")
                .snippet("Horse, sheep, and dog exhibit"));

        ridge = mMap.addMarker(new MarkerOptions()
                .position(RIDGE)
                .title("Eagle Ridge")
                .snippet("Eagle exhibit"));

        valley = mMap.addMarker(new MarkerOptions()
                .position(VALLEY)
                .title("Wolf Valley")
                .snippet("wolf exhibit"));

    }

    public void addAquaToMap() {
        griffon = mMap.addMarker(new MarkerOptions()
                .position(GRIFFON)
                .title("Griffon")
                .snippet("Escape the Griffon"));

        frenchshow = mMap.addMarker(new MarkerOptions()
                .position(FRENCHSHOW)
                .title("Summer Concert Series")
                .snippet("Various artist play throughout the summer, check the site for dates"));

        askyride = mMap.addMarker(new MarkerOptions()
                .position(ASKYRIDE)
                .title("Aquitaine Skyride")
                .snippet("Departs to Rhinefeld"));
    }

    public void addATMToMap() {
        a1 = mMap.addMarker(new MarkerOptions()
                .position(A1)
                .title("ATM"));

        a2 = mMap.addMarker(new MarkerOptions()
                .position(A2)
                .title("ATM"));

        a3 = mMap.addMarker(new MarkerOptions()
                .position(A3)
                .title("ATM"));
    }

    public void addBanburyToMap() {

        PolygonOptions rectOptions = new PolygonOptions()
                .add(new LatLng(37.236758, -76.646559),
                        new LatLng(37.236632, -76.646091),
                        new LatLng(37.236686, -76.645847),
                        new LatLng(37.236624, -76.645713),
                        new LatLng(37.236368, -76.645571),
                        new LatLng(37.236265, -76.645356),
                        new LatLng(37.235558, -76.645322),
                        new LatLng(37.235742, -76.646209),
                        new LatLng(37.236178, -76.64666),
                        new LatLng(37.236449, -76.646746),
                        new LatLng(37.236705, -76.646625))
                .strokeWidth(4)
                .strokeColor(Color.BLACK);

        //Polygon polygon = mMap.addPolygon(rectOptions);

        englandshow = mMap.addMarker(new MarkerOptions()
                .position(ENGLANDSHOW)
                .title("Pirates 4D")
                .snippet("A 4d Pirate Adventure"));

        grille = mMap.addMarker(new MarkerOptions()
                .position(GRILLE)
                .title("Squire's Grille")
                .snippet("serves breakfast, along with a diverse lunch and dinner menu"));


    }

    public void addBathroomsToMap() {
        b1 = mMap.addMarker(new MarkerOptions()
                .position(B1)
                .title("Bathroom"));

        b2 = mMap.addMarker(new MarkerOptions()
                .position(B2)
                .title("Bathroom"));

        b3 = mMap.addMarker(new MarkerOptions()
                .position(B3)
                .title("Bathroom"));

        b4 = mMap.addMarker(new MarkerOptions()
                .position(B4)
                .title("Bathroom"));

        b5 = mMap.addMarker(new MarkerOptions()
                .position(B5)
                .title("Bathroom"));

        b6 = mMap.addMarker(new MarkerOptions()
                .position(B6)
                .title("Bathroom"));

        b7 = mMap.addMarker(new MarkerOptions()
                .position(B7)
                .title("Bathroom"));

        b8 = mMap.addMarker(new MarkerOptions()
                .position(B8)
                .title("Bathroom"));

        b9 = mMap.addMarker(new MarkerOptions()
                .position(B9)
                .title("Bathroom"));

        b10 = mMap.addMarker(new MarkerOptions()
                .position(B10)
                .title("Bathroom"));

        b11 = mMap.addMarker(new MarkerOptions()
                .position(B11)
                .title("Bathroom"));
    }

    private void addCoastersToMap() {
        vbolt = mMap.addMarker(new MarkerOptions()
                .position(VBOLT)
                .title("Verbolten")
                .snippet("Brave the black forest!"));

        alpen = mMap.addMarker(new MarkerOptions()
                .position(ALPEN)
                .title("Alpengeist")
                .snippet("Slopes are closed"));

        apollo = mMap.addMarker(new MarkerOptions()
                .position(APOLLO)
                .title("Apollo's Chariot")
                .snippet("Ride the wings to the sun"));

        griffon = mMap.addMarker(new MarkerOptions()
                .position(GRIFFON)
                .title("Griffon"));

        loch = mMap.addMarker(new MarkerOptions()
                .position(LOCH)
                .title("Loch Ness Monster")
                .snippet("Legendary Loch Ness Monster"));

        grover = mMap.addMarker(new MarkerOptions()
                .position(GROVER)
                .title("Grover's Alpine Express"));
    }


    private void addEatToMap() {
        beer = mMap.addMarker(new MarkerOptions()
                .position(BEER)
                .title("Beste Brezeln und Bier")
                .snippet("speciality beer and pretzels"));

        festhaus = mMap.addMarker(new MarkerOptions()
                .position(FESTHAUS)
                .title("Das Festhaus")
                .snippet("German style eatery with daily shows"));

        smokehouse = mMap.addMarker(new MarkerOptions()
                .position(SMOKEHOUSE)
                .title("Trapper's Smokehouse")
                .snippet("Classic smokehouse style food and scenery"));

        piazza = mMap.addMarker(new MarkerOptions()
                .position(PIAZZA)
                .title("Ristorante Della Piazza")
                .snippet("Italian stlye eatery with daily shows"));

        grille = mMap.addMarker(new MarkerOptions()
                .position(GRILLE)
                .title("Squire's Grille")
                .snippet("serves breakfast, along with a diverse lunch and dinner menu"));

        grill = mMap.addMarker(new MarkerOptions()
                .position(GRILL)
                .title("Grogran's Grill")
                .snippet("Irish style eatery, with nearby street performers"));

        pub = mMap.addMarker(new MarkerOptions()
                .position(PUB)
                .title("Grogan's Pub")
                .snippet("Drinks, snacks and speciality beers"));

        cucina = mMap.addMarker(new MarkerOptions()
                .position(CUCINA)
                .title("La Cucina")
                .snippet("All you can eat pizza and pasta buffet"));

    }

    public void addFestaToMap() {
        apollo = mMap.addMarker(new MarkerOptions()
                .position(APOLLO)
                .title("Apollo's Chariot")
                .snippet("Ride the wings to the sun"));

        twind = mMap.addMarker(new MarkerOptions()
                .position(TWIND)
                .title("The Trade Wind")
                .snippet("music express"));

        delight = mMap.addMarker(new MarkerOptions()
                .position(DELIGHT)
                .title("Turkish Delight"));

        rapid = mMap.addMarker(new MarkerOptions()
                .position(RAPID)
                .title("Roman Rapids")
                .snippet("flume rapids"));

        ftrain = mMap.addMarker(new MarkerOptions()
                .position(FTRAIN)
                .title("Festa Italia train station")
                .snippet("departs to New France"));

        cucina = mMap.addMarker(new MarkerOptions()
                .position(CUCINA)
                .title("La Cucina")
                .snippet("All you can eat pizza and pasta buffet"));

    }

    private void addFlatsToMap() {
        mach = mMap.addMarker(new MarkerOptions()
                .position(MACH)
                .title("Mach Tower"));

        eita = mMap.addMarker(new MarkerOptions()
                .position(EITA)
                .title("Europe in the Air")
                .snippet("A high flying adventure over Europe"));

        castle = mMap.addMarker(new MarkerOptions()
                .position(CASTLE)
                .title("DarKastle"));

        auto = mMap.addMarker(new MarkerOptions()
                .position(AUTO)
                .title("Der Autobahn")
                .snippet("bumper cars"));

        cradle = mMap.addMarker(new MarkerOptions()
                .position(CRADLE)
                .title("Da Vinci's Cradle")
                .snippet("flying carpet"));

        machine = mMap.addMarker(new MarkerOptions()
                .position(MACHINE)
                .title("The Flying Machine"));

        wind = mMap.addMarker(new MarkerOptions()
                .position(WIND)
                .title("Der Wirbelwind")
                .snippet("Wave Swinger"));

        twind = mMap.addMarker(new MarkerOptions()
                .position(TWIND)
                .title("The Trade Wind")
                .snippet("music express"));

        catapult = mMap.addMarker(new MarkerOptions()
                .position(CATAPULT)
                .title("Le Catapult")
                .snippet("scrambler"));

        delight = mMap.addMarker(new MarkerOptions()
                .position(DELIGHT)
                .title("Turkish Delight")
                .snippet("spinning tea cups"));

        ram = mMap.addMarker(new MarkerOptions()
                .position(RAM)
                .title("Battering Ram")
                .snippet("swinging boat"));
    }


    public void addFranceToMap() {
        catapult = mMap.addMarker(new MarkerOptions()
                .position(CATAPULT)
                .title("Le Catapult")
                .snippet("scrambler"));


        scoot = mMap.addMarker(new MarkerOptions()
                .position(SCOOT)
                .title("Le Scoot")
                .snippet("log flume"));


        ntrain = mMap.addMarker(new MarkerOptions()
                .position(NTRAIN)
                .title("New France train station")
                .snippet("departs to England"));

        smokehouse = mMap.addMarker(new MarkerOptions()
                .position(SMOKEHOUSE)
                .title("Trapper's Smokehouse")
                .snippet("Classic smokehouse style food and scenery"));
    }


    public void addIrelandToMap() {

        eita = mMap.addMarker(new MarkerOptions()
                .position(EITA)
                .title("Europe in the Air")
                .snippet("A high flying adventure over Europe"));

        grill = mMap.addMarker(new MarkerOptions()
                .position(GRILL)
                .title("Grogran's Grill")
                .snippet("Irish style eatery, with nearby street performers"));

        pub = mMap.addMarker(new MarkerOptions()
                .position(PUB)
                .title("Grogan's Pub")
                .snippet("Drinks, snacks and speciality beers"));

        irelandshow = mMap.addMarker(new MarkerOptions()
                .position(IRELANDSHOW)
                .title("Celtic Fyre")
                .snippet("Pure energy of Irish dance explode on stage"));
    }

    public void addItalyToMap() {
        cradle = mMap.addMarker(new MarkerOptions()
                .position(CRADLE)
                .title("Da Vinci's Cradle")
                .snippet("flying carpet"));

        machine = mMap.addMarker(new MarkerOptions()
                .position(MACHINE)
                .title("The Flying Machine"));

        ram = mMap.addMarker(new MarkerOptions()
                .position(RAM)
                .title("Battering Ram")
                .snippet("swinging boat"));

        pompeii = mMap.addMarker(new MarkerOptions()
                .position(POMPEII)
                .title("Escape from Pompeii")
                .snippet("shoot-the-chutes"));

        piazza = mMap.addMarker(new MarkerOptions()
                .position(PIAZZA)
                .title("Ristorante Della Piazza")
                .snippet("Italian stlye eatery with daily shows"));

        italyshow = mMap.addMarker(new MarkerOptions()
                .position(ITALYSHOW)
                .title("Mix it up!")
                .snippet("The chefs are at it again"));


    }

    public void addOktoberToMap() {
        vbolt = mMap.addMarker(new MarkerOptions()
                .position(VBOLT)
                .title("Verbolten")
                .snippet("Brave the black forest!"));


        mach = mMap.addMarker(new MarkerOptions()
                .position(MACH)
                .title("Mach Tower"));

        castle = mMap.addMarker(new MarkerOptions()
                .position(CASTLE)
                .title("DarKastle"));

        auto = mMap.addMarker(new MarkerOptions()
                .position(AUTO)
                .title("Der Autobahn")
                .snippet("bumper cars"));

        festhaus = mMap.addMarker(new MarkerOptions()
                .position(FESTHAUS)
                .title("Das Festhaus")
                .snippet("German style eatery with daily shows"));

        beer = mMap.addMarker(new MarkerOptions()
                .position(BEER)
                .title("Beste Brezeln und Bier")
                .snippet("speciality beer and pretzels"));

        festshow = mMap.addMarker(new MarkerOptions()
                .position(FESTSHOW)
                .title("Entwined(AM)/This is Oktoberfest(PM)")
                .snippet("Entwined runs during the day, Oktoberfest runs at night"));

        wind = mMap.addMarker(new MarkerOptions()
                .position(WIND)
                .title("Der Wirbelwind")
                .snippet("Wave Swinger"));

    }

    public void addRhineToMap() {
        alpen = mMap.addMarker(new MarkerOptions()
                .position(ALPEN)
                .title("Alpengeist")
                .snippet("Slopes are closed"));


        rskyride = mMap.addMarker(new MarkerOptions()
                .position(RSKYRIDE)
                .title("Rhinefeld Skyride")
                .snippet("Departs to England"));

        rrc = mMap.addMarker(new MarkerOptions()
                .position(RRC)
                .title("Rhine River Cruise")
                .snippet("Boat ride on the Rhine River"));
    }

    public void addScotlandToMap() {
        loch = mMap.addMarker(new MarkerOptions()
                .position(LOCH)
                .title("Loch Ness Monster")
                .snippet("Legendary Loch Ness Monster"));

        etrain = mMap.addMarker(new MarkerOptions()
                .position(ETRAIN)
                .title("England train stop")
                .snippet("Departs to Festa Italia"));

        stables = mMap.addMarker(new MarkerOptions()
                .position(STABLES)
                .title("Highland Stables")
                .snippet("Horse, sheep, and dog exhibit"));

    }

    private void addShopsToMap() {
        s1 = mMap.addMarker(new MarkerOptions()
                .position(S1)
                .title("Shop"));

        s2 = mMap.addMarker(new MarkerOptions()
                .position(S2)
                .title("Shop"));

        s3 = mMap.addMarker(new MarkerOptions()
                .position(S3)
                .title("Shop"));

        s4 = mMap.addMarker(new MarkerOptions()
                .position(S4)
                .title("Shop"));

        s5 = mMap.addMarker(new MarkerOptions()
                .position(S5)
                .title("Shop"));

        s6 = mMap.addMarker(new MarkerOptions()
                .position(S6)
                .title("Shop"));

        s7 = mMap.addMarker(new MarkerOptions()
                .position(S7)
                .title("Shop"));

        s8 = mMap.addMarker(new MarkerOptions()
                .position(S8)
                .title("Shop"));

        s9 = mMap.addMarker(new MarkerOptions()
                .position(S9)
                .title("Shop"));

        s10 = mMap.addMarker(new MarkerOptions()
                .position(S10)
                .title("Shop"));
    }

    public void addShowsToMap() {
        englandshow = mMap.addMarker(new MarkerOptions()
                .position(ENGLANDSHOW)
                .title("Pirates 4D")
                .snippet("A 4d Pirate Adventure"));

        italyshow = mMap.addMarker(new MarkerOptions()
                .position(ITALYSHOW)
                .title("Mix it up!")
                .snippet("The chefs are at it again"));

        festshow = mMap.addMarker(new MarkerOptions()
                .position(FESTSHOW)
                .title("Entwined(AM)/Roll out the Barrel(PM)")
                .snippet("Entwined runs during the day, RotB runs at night"));

        frenchshow = mMap.addMarker(new MarkerOptions()
                .position(FRENCHSHOW)
                .title("Summer Concert Series")
                .snippet("Various artist play throughout the summer, check the site for dates"));

        petshow = mMap.addMarker(new MarkerOptions()
                .position(PETSHOW)
                .title("More Pet Shinnanigans")
                .snippet("Pet tricks and more"));

        irelandshow = mMap.addMarker(new MarkerOptions()
                .position(IRELANDSHOW)
                .title("Celtic Fyre")
                .snippet("Pure energy of Irish dance explode on stage"));

    }


    private void addTransportationToMap() {
        etrain = mMap.addMarker(new MarkerOptions()
                .position(ETRAIN)
                .title("England train stop")
                .snippet("Departs to Festa Italia"));

        ftrain = mMap.addMarker(new MarkerOptions()
                .position(FTRAIN)
                .title("Festa Italia train station")
                .snippet("Departs to New France"));

        ntrain = mMap.addMarker(new MarkerOptions()
                .position(NTRAIN)
                .title("New France train station")
                .snippet("Departs to England"));

        rskyride = mMap.addMarker(new MarkerOptions()
                .position(RSKYRIDE)
                .title("Rhinefeld Skyride")
                .snippet("Departs to England"));

        eskyride = mMap.addMarker(new MarkerOptions()
                .position(ESKYRIDE)
                .title("England Skyride")
                .snippet("Departs to Aquaitaine"));

        askyride = mMap.addMarker(new MarkerOptions()
                .position(ASKYRIDE)
                .title("Aquitaine Skyride")
                .snippet("Departs to Rhinefeld"));

        rrc = mMap.addMarker(new MarkerOptions()
                .position(RRC)
                .title("Rhine River Cruise")
                .snippet("Boat ride on the Rhine River"));
    }

    private void addWaterToMap() {
        scoot = mMap.addMarker(new MarkerOptions()
                .position(SCOOT)
                .title("Le Scoot")
                .snippet("log flume"));

        pompeii = mMap.addMarker(new MarkerOptions()
                .position(POMPEII)
                .title("Escape from Pompeii")
                .snippet("shoot-the-chutes"));

        rapid = mMap.addMarker(new MarkerOptions()
                .position(RAPID)
                .title("Roman Rapids")
                .snippet("flume rapids"));

    }

    public void addWildToMap() {
        ridge = mMap.addMarker(new MarkerOptions()
                .position(RIDGE)
                .title("Eagle Ridge")
                .snippet("Eagle exhibit"));

        valley = mMap.addMarker(new MarkerOptions()
                .position(VALLEY)
                .title("Wolf Valley")
                .snippet("wolf exhibit"));


        glen = mMap.addMarker(new MarkerOptions()
                .position(GLEN)
                .title("Lorikeet Glen")
                .snippet("bird exhibit"));

        petshow = mMap.addMarker(new MarkerOptions()
                .position(PETSHOW)
                .title("More Pet Shinnanigans")
                .snippet("Pet tricks and more"));

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapv2);
        setUpMapIfNeeded();

        mGaInstance = GoogleAnalytics.getInstance(this);
        mGaTracker = mGaInstance.getTracker("UA-39204043-1");

        ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setDisplayHomeAsUpEnabled(true);
        setSlidingActionBarEnabled(false);

    }

    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mapmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            toggle();
            return true;
        } else if (itemId == R.id.clear) {
            mMap.clear();
        } else if (itemId == R.id.bathrooms) {
            mMap.clear();
            addBathroomsToMap();
        } else if (itemId == R.id.atm) {
            mMap.clear();
            addATMToMap();
        } else if (itemId == R.id.shops) {
            mMap.clear();
            addShopsToMap();
        } else if (itemId == R.id.alloption) {
            mMap.clear();
            addCoastersToMap();
            addFlatsToMap();
            addWaterToMap();
            addTransportationToMap();
            addAnimalToMap();
            addShowsToMap();
        } else if (itemId == R.id.coastersoption) {
            mMap.clear();
            addCoastersToMap();
        } else if (itemId == R.id.flatsoption) {
            mMap.clear();
            addFlatsToMap();
        } else if (itemId == R.id.wateroption) {
            mMap.clear();
            addWaterToMap();
        } else if (itemId == R.id.transportation) {
            mMap.clear();
            addTransportationToMap();
        } else if (itemId == R.id.animal) {
            mMap.clear();
            addAnimalToMap();
        } else if (itemId == R.id.eatoption) {
            mMap.clear();
            addEatToMap();
        } else if (itemId == R.id.shows) {
            mMap.clear();
            addShowsToMap();
        } else if (itemId == R.id.banbury) {
            mMap.clear();
            addBanburyToMap();
        } else if (itemId == R.id.scotland) {
            mMap.clear();
            addScotlandToMap();
        } else if (itemId == R.id.ireland) {
            mMap.clear();
            addIrelandToMap();
        } else if (itemId == R.id.wildlife) {
            mMap.clear();
            addWildToMap();
        } else if (itemId == R.id.aquitaine) {
            mMap.clear();
            addAquaToMap();
        } else if (itemId == R.id.newfrance) {
            mMap.clear();
            addFranceToMap();
        } else if (itemId == R.id.rhinefeld) {
            mMap.clear();
            addRhineToMap();
        } else if (itemId == R.id.oktoberfest) {
            mMap.clear();
            addOktoberToMap();
        } else if (itemId == R.id.italy) {
            mMap.clear();
            addItalyToMap();
        } else if (itemId == R.id.festa) {
            mMap.clear();
            addFestaToMap();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMap() {
        addCoastersToMap();
        addFlatsToMap();
        addWaterToMap();
        addTransportationToMap();
        addAnimalToMap();
        addShowsToMap();
        addEatToMap();
        addATMToMap();
        addBathroomsToMap();
        mMap.setMyLocationEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(HOME));
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

}
