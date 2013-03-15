package com.david.bgwfans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

public class Eateries extends SideMenuActivity implements View.OnClickListener{
	private Tracker mGaTracker;
	private GoogleAnalytics mGaInstance;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.park_eateries);
		
		mGaInstance = GoogleAnalytics.getInstance(this);
		mGaTracker = mGaInstance.getTracker("UA-39204043-1");
		}
	
	public void Festhaus(View view)
	{
		Intent festhausActivity = new Intent(this, Festhaus.class);
		startActivity(festhausActivity);
	}
	
	public void Smokehouse(View view)
	{
		Intent smokehouseActivity = new Intent(this, Smokehouse.class);
		startActivity(smokehouseActivity);
	}
	
	public void Piazza(View view)
	{
		Intent piazzaActivity = new Intent(this, Piazza.class);
		startActivity(piazzaActivity);
	}
	
	public void Grille(View view)
	{
		Intent grilleActivity = new Intent(this, Grille.class);
		startActivity(grilleActivity);
	}
	
	public void Cucina(View view)
	{
		Intent cucinaActivity = new Intent(this, Cucina.class);
		startActivity(cucinaActivity);
	}
	
	public void Pub(View view)
	{
		Intent pubActivity = new Intent(this, Pub.class);
		startActivity(pubActivity);
	}
	
	public void Grill(View view)
	{
		Intent grillActivity = new Intent(this, Grill.class);
		startActivity(grillActivity);
	}
	
	public void Bier(View view)
	{
		Intent bierActivity = new Intent(this, Bier.class);
		startActivity(bierActivity);
	}
	

}
