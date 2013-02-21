package com.david.bgwfans;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.fima.cardsui.objects.Card;


public class TodayCard extends Card {

	//TextView t;
	int date;
	// All static variables
	static final String URL = "http://weather.yahooapis.com/forecastrss?w=2520842";

	public TodayCard(String title){
		super(title);
	}
	


	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.todaycard, null);

		Date cDate = new Date();
		String fDate = new SimpleDateFormat("yyyy-MM-dd").format(cDate);

		((TextView) view.findViewById(R.id.title)).setText(title);
		
		
		TextView t = (TextView) view.findViewById(R.id.hours);
		//t.setText(fDate);
		if (fDate.equals("2013-03-17"))
		{
			t.setText("Hours: 10am - 6pm");
		}
		else if (fDate.equals("2013-03-22"))
		{
			t.setText("Hours: 10am - 7pm");
		}
		else if (fDate.equals("2013-03-23"))
		{
			t.setText("Hours: 10am - 8pm");
		}
		else if (fDate.equals("2013-03-24"))
		{
			t.setText("Hours: 10am - 7pm");
		}
		else if (fDate.equals("2013-03-25") || fDate.equals("2013-03-26") || fDate.equals("2013-03-27") || fDate.equals("2013-03-28") || fDate.equals("2013-03-29"))
		{
			t.setText("Hours: 9am - 8pm");
		}
		else if (fDate.equals("2013-03-30") || fDate.equals("2013-03-31"))
		{
			t.setText("Hours: 9am - 10pm");
		}
		else
		{
			t.setText("Hours: Closed");
		}
		return view;
		
	}
	
	
	
}