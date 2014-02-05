package com.david.bgtfans.fragments;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdLayout;
import com.amazon.device.ads.AdListener;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.AdTargetingOptions;
import com.crittercism.app.Crittercism;
import com.david.bgtfans.webviews.HiddenWiki;
import com.david.bgtfans.cards.OtherApps;
import com.david.bgtfans.R;
import com.david.bgtfans.cards.WcCard;
import com.david.bgtfans.cards.XmasCard;
import com.david.bgtfans.cards.BGTFansCard;
import com.david.bgtfans.cards.InfoCard;
import com.david.bgtfans.cards.KDFansCard;
import com.david.bgtfans.hos.HosCard;
import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;
import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockFragment;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;


public class InfoScreen extends RoboSherlockFragment {

    private CardUI mCardView;
    private Tracker mGaTracker;
    private GoogleAnalytics mGaInstance;
    View view;
    AdLayout adLayout;
    AdTargetingOptions adTargetingOptions;
    LinearLayout adFail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.activity_main, container, false);

        mGaInstance = GoogleAnalytics.getInstance(getActivity());
        mGaTracker = mGaInstance.getTracker("UA-39204043-1");

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Light.ttf");
        //AdRequest adRequest = new AdRequest();
        //adView = (AdView)findViewById(R.id.adMob);
        //adView.loadAd(new AdRequest());
        //adView.loadAd(adRequest);

        //sm.attachToActivity(this,  SlidingMenu.SLIDING_CONTENT);

        // init CardView
        mCardView = (CardUI) view.findViewById(R.id.cardsview);
        mCardView.setSwipeable(false);

        InfoCard infoCard = new InfoCard("Park Info");
        mCardView.addCard(infoCard);
//        mCardView.addCard(new InfoCard("Park Info"));

        // add one card, and then add another one to the last stack.
       // mCardView.addCard(new TomCard("Tomorrow"));
        //mCardView.addCardToLastStack(new TodayCard("Today"));

        //current event card
        //CardStack Ceventstack = new CardStack();
        //Ceventstack.add(new XmasCard("Christmas Town"));
        //mCardView.addStack(Ceventstack);

        //event card stack
        CardStack eventstack = new CardStack();
        XmasCard xmas = new XmasCard("Christmas Town");
        HosCard hos = new HosCard("Howl-O-Scream");
        eventstack.add(xmas);
        eventstack.add(hos);
        mCardView.addStack(eventstack);
        xmas.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), HiddenWiki.class);
                i.putExtra("wikiLink", "http://www.christmastown.com/mobi/#home");
                startActivity(i);
            }
        });

        hos.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), HiddenWiki.class);
                i.putExtra("wikiLink", "http://www.howloscream.com/williamsburg/mobi/#home");
                startActivity(i);
            }
        });


        CardStack appsStack = new CardStack();
        OtherApps appsCard = new OtherApps("My other apps");
        appsStack.add(appsCard);
        mCardView.addStack(appsStack);

        appsCard.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Vapr-Ware"));
                startActivity(intent);
            }
        });



        CardStack wcstack = new CardStack();
        WcCard wccard = new WcCard("Water Country USA");
        wcstack.add(wccard);
        mCardView.addStack(wcstack);
        wccard.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), HiddenWiki.class);
                i.putExtra("wikiLink", "http://seaworldparks.com/en/buschgardens-williamsburg/Water-Country-USA");
                startActivity(i);
            }
        });

        CardStack bgtstack = new CardStack();
        BGTFansCard bgtFansCard = new BGTFansCard("BGTFans");
        bgtstack.add(bgtFansCard);
        mCardView.addStack(bgtstack);

        CardStack kdstack = new CardStack();
        KDFansCard kdFansCard = new KDFansCard("KDFans");
        kdstack.add(kdFansCard);
        mCardView.addStack(kdstack);

        mCardView.refresh();

        final Runnable mRunnable;
        final Handler mHandler=new Handler();

        mRunnable=new Runnable() {

            @Override
            public void run() {
                adLayout.loadAd(adTargetingOptions);
            }
        };

        adFail = (LinearLayout) view.findViewById(R.id.ad_fail_view);
        adFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goProIntent();
            }
        });

        try {
//            AdRegistration.enableTesting(true);
            AdRegistration.setAppKey("9dc03c16047340d88ed5e306f717b2ac");
        } catch (Exception e) {
            Crittercism.logHandledException(e);
        }

        adLayout = (AdLayout) view.findViewById(R.id.ad_view);
        adTargetingOptions = new AdTargetingOptions();
        adLayout.loadAd(adTargetingOptions);
        adLayout.setListener(new AdListener() {
            @Override
            public void onAdLoaded(AdLayout adLayout, AdProperties adProperties) {
                adFail.setVisibility(View.GONE);
            }

            @Override
            public void onAdExpanded(AdLayout adLayout) {
                //
            }

            @Override
            public void onAdCollapsed(AdLayout adLayout) {
                //
            }

            @Override
            public void onAdFailedToLoad(AdLayout adLayout, AdError adError) {
                adFail.setVisibility(View.VISIBLE);
                mHandler.postDelayed(mRunnable,10*1000);
                Log.d("aderror", adError.getMessage());
            }
        });

        return view;
    }

    private void goProIntent(){
        Tracker tracker = EasyTracker.getTracker();
        tracker.sendEvent("go_pro", "go_pro_clicked", "user_go_pro", null);
        String url = "https://play.google.com/store/apps/details?id=com.david.bgwfanspaid";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
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
