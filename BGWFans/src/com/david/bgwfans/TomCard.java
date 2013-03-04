package com.david.bgwfans;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.fima.cardsui.objects.Card;

public class TomCard extends Card {

	public TomCard(String title){
		super(title);
	}


	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.tomcard, null);
		
		Date cDate = new Date();
		String fDate = new SimpleDateFormat("yyyy-MM-dd").format(cDate);

		((TextView) view.findViewById(R.id.title)).setText(title);
		
		TextView t = (TextView) view.findViewById(R.id.hours);
		//t.setText(fDate);
		if (fDate.equals("2013-03-17"))
		{
			t.setText("Hours: Closed");
		}
		else if (fDate.equals("2013-03-21"))
		{
			t.setText("Hours: 10am - 7pm");
		}
		else if (fDate.equals("2013-03-22"))
		{
			t.setText("Hours: 10am - 8pm");
		}
		else if (fDate.equals("2013-03-23"))
		{
			t.setText("Hours: 10am - 7pm");
		}
		else if (fDate.equals("2013-03-24"))
		{
			t.setText("Hours: 9am - 8pm");
		}
		else if (fDate.equals("2013-03-25") || fDate.equals("2013-03-26") || fDate.equals("2013-03-27") || fDate.equals("2013-03-28"))
		{
			t.setText("Hours: 9am - 8pm");
		}
		else if (fDate.equals("2013-03-29"))
		{
			t.setText("Hours: 9am - 10pm");
		}
		else if (fDate.equals("2013-03-30"))
		{
			t.setText("Hours: 9am - 8pm");
		}
		else
		{
			t.setText("Hours: Closed");
		}

		
		return view;
	}

	
	
	
}