package com.david.bgwfans;


import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import net.simonvt.widget.MenuDrawerManager;

public class HOS_Shows extends SideMenuActivity implements View.OnClickListener{

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hos_shows);

 
}
	
	public void Barrel(View view)
	{
		Intent barrelActivity = new Intent(this, Barrel.class);
		startActivity(barrelActivity);
	}
	
	public void Entwined(View view)
	{
		Intent entwinedActivity = new Intent(this, Entwined.class);
		startActivity(entwinedActivity);
	}
	
	public void Mix(View view)
	{
		Intent mixActivity = new Intent(this, Mix.class);
		startActivity(mixActivity);
	}
	
	public void Pets (View view)
	{
		Intent petsActivity = new Intent(this, Pets.class);
		startActivity(petsActivity);
	}
	
	public void Celtic (View view)
	{
		Intent celticActivity = new Intent(this, Celtic.class);
		startActivity(celticActivity);
	}
	
}
