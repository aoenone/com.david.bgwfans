package com.david.bgwfans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.fima.cardsui.objects.Card;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class WcCard extends Card {

	private GoogleMap mMap;
	
	public WcCard(String title){
		super(title);
	}


	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.wccard, null);

		((TextView) view.findViewById(R.id.title)).setText(title);
		 
		return view;
		
	}

	
	
	
}
