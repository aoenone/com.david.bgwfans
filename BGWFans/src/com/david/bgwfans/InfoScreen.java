package com.david.bgwfans;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class InfoScreen extends SideMenuActivity{

	private CardUI mCardView;
	private AdView adView;
    String adMobId = "a151350c50621fc";
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//View myFragmentView = inflater.inflate(R.layout.wccard, container, false);
		RelativeLayout layout = (RelativeLayout)findViewById(R.id.homelayout);
		RelativeLayout.LayoutParams lay = new RelativeLayout.LayoutParams(
        	    RelativeLayout.LayoutParams.MATCH_PARENT, 
        	    RelativeLayout.LayoutParams.MATCH_PARENT);
        lay.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        adView = new AdView(this, AdSize.BANNER, adMobId);
        layout.addView(adView, lay);
        adView.setGravity(Gravity.BOTTOM);
        adView.loadAd(new AdRequest());
        
		android.app.ActionBar actionbar = getActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
		actionbar.setListNavigationCallbacks(null, null);
        actionbar.setDisplayHomeAsUpEnabled(true);
        
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
		eventstack.add(new XmasCard("Christmas Town"));
		eventstack.add(new HosCard("Howl-O-Scream"));
		eventstack.add(new IllCard("Illuminights"));
		eventstack.add(new WineCard("Food and Wine Festival"));
		eventstack.add(new PmCard("Passmember Preview Weekend"));
		mCardView.addStack(eventstack);
		
		CardStack wcstack = new CardStack();
		wcstack.add(new WcCard("Water Country USA"));
		mCardView.addStack(wcstack);
		
		CardStack paidstack = new CardStack();
		paidstack.add(new PaidCard("Go Platinum!"));
		mCardView.addStack(paidstack);
		//WineCard androidViewsCard = new WineCard("Food and Wine Festival");
		//androidViewsCard.setOnClickListener(new OnClickListener() {
		/**
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://www.androidviews.net/"));
				startActivity(intent);

			}
		});**/
		//mCardView.addCardToLastStack(androidViewsCard);

		// draw cards
		mCardView.refresh();
	
	}
	
	@Override
    public void onDestroy() {
      if (adView != null) {
        adView.destroy();
      }
      super.onDestroy();
    }
}
