package com.david.bgwfans;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

public class InfoScreen extends SideMenuActivity implements OnClickListener {

	private CardUI mCardView;
	private AdView adView;
    String adMobId = "a151350c50621fc";
    private Tracker mGaTracker;
    private GoogleAnalytics mGaInstance;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("BillingService", "Starting");
		setContentView(R.layout.activity_main);
		
		 mGaInstance = GoogleAnalytics.getInstance(this);
		 mGaTracker = mGaInstance.getTracker("UA-39204043-1");
		 
		//View myFragmentView = inflater.inflate(R.layout.wccard, container, false);
		RelativeLayout layout = (RelativeLayout)findViewById(R.id.homelayout);
		RelativeLayout.LayoutParams lay = new RelativeLayout.LayoutParams(
        	    RelativeLayout.LayoutParams.MATCH_PARENT, 
        	    RelativeLayout.LayoutParams.MATCH_PARENT);
        lay.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        adView = new AdView(this, AdSize.SMART_BANNER, adMobId);
        layout.addView(adView, lay);
        adView.setGravity(Gravity.BOTTOM);
        adView.loadAd(new AdRequest());
		
        
        //AdRequest adRequest = new AdRequest();
		//adView = (AdView)findViewById(R.id.adMob);
		//adView.loadAd(new AdRequest());
		//adView.loadAd(adRequest);
        
        //sm.attachToActivity(this,  SlidingMenu.SLIDING_CONTENT);

		// init CardView
		mCardView = (CardUI) findViewById(R.id.cardsview);
		mCardView.setSwipeable(false);
		
		// add one card, and then add another one to the last stack.
		mCardView.addCard(new TomCard("Tomorrow"));
		mCardView.addCardToLastStack(new TodayCard("Today"));
		
		//current event card
		//CardStack Ceventstack = new CardStack();
		//Ceventstack.add(new XmasCard("Christmas Town"));
		//mCardView.addStack(Ceventstack);
		
		//event card stack
		CardStack eventstack = new CardStack();
		XmasCard xmas = new XmasCard("Christmas Town");
		HosCard hos = new HosCard("Howl-O-Scream");
		IllCard ill = new IllCard("IllumiNights");
		WineCard wine = new WineCard("Food & Wine Festival");
		PmCard pm = new PmCard("Pass Member Preview Day");
		eventstack.add(xmas);
		eventstack.add(hos);
		eventstack.add(ill);
		eventstack.add(wine);
		eventstack.add(pm);
		//eventstack.add(new XmasCard("Christmas Town"));
		//eventstack.add(new HosCard("Howl-O-Scream"));
		//eventstack.add(new IllCard("Illuminights"));
		//eventstack.add(new WineCard("Food and Wine Festival"));
		//eventstack.add(new PmCard("Passmember Preview Weekend"));
		mCardView.addStack(eventstack);
		xmas.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(getApplicationContext(), HiddenWiki.class);
				i.putExtra("wikiLink", "http://www.christmastown.com/mobi/#home");
				startActivity(i);	
			}
		});
		
		hos.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(getApplicationContext(), HiddenWiki.class);
				i.putExtra("wikiLink", "http://www.howloscream.com/williamsburg/mobi/#home");
				startActivity(i);		
			}
		});
		
		ill.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), HiddenWiki.class);
				i.putExtra("wikiLink", "http://seaworldparks.com/buschgardens-williamsburg/Park-Info/Events/Content/IllumiNights");
				startActivity(i);		
			}
		});
		
		
		CardStack wcstack = new CardStack();
		WcCard wccard = new WcCard("Water Country USA");
		wcstack.add(wccard);
		//wcstack.add(new WcCard("Water Country USA"));
		mCardView.addStack(wcstack);
		wccard.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), HiddenWiki.class);
				i.putExtra("wikiLink", "http://watercountryusa.com/wc/");
				startActivity(i);	
			}
		});
		
		
		CardStack paidstack = new CardStack();
		PaidCard paidOpen = new PaidCard("Go Platinum!");
		paidstack.add(paidOpen);
		//paidstack.add(new PaidCard("Go Platinum!"));
		mCardView.addStack(paidstack);
		paidOpen.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), HiddenWiki.class);
				i.putExtra("wikiLink", "http://www.bgwfans.com");
				startActivity(i);	
			}
		});
		
		mCardView.refresh();
	
	}
	
	@Override
    public void onDestroy() {
      if (adView != null) {
    	adView.removeAllViews();
        adView.destroy();
      }
      super.onDestroy();
    }
}
