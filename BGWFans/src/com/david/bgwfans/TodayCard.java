package com.david.bgwfans;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import android.content.Context;

import android.net.Uri;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.fima.cardsui.objects.Card;



public class TodayCard extends Card {

	WeatherData data = new WeatherData();
	ImageView wImg;
	//TextView t;
	int date;
	static final String baseURL = "http://weather.yahooapis.com/forecastrss?w=12767253";

	public TodayCard(String title){
		super(title);
	}
	
	class MyWeather{
		String description;
		String city;
		String region;
		String country;

		String windChill;
		String windDirection;
		String windSpeed;

		String sunrise;
		String sunset;
	
		String conditiontext;
		String conditiondate;
		String conditioncode;
		
	public String toString(){

		 return "It's currently " + conditiondate + (char) 0x00B0 + "\nand "+ conditiontext;	 
		 		
		}
	}

	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.todaycard, null);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        ImageView wImg = (ImageView) view.findViewById(R.id.wimg);
		TextView weather = (TextView) view.findViewById(R.id.weather);

	    String weatherString = QueryYahooWeather();
	    Document weatherDoc = convertStringToDocument(weatherString);

	    MyWeather weatherResult = parseWeather(weatherDoc);
	    weather.setText(weatherResult.toString());
	    
	    //MyWeather conditioncode = parseWeather(weatherDoc);
	    //wImg.setImageDrawable(conditioncode);
		
		
		Date cDate = new Date();
		String fDate = new SimpleDateFormat("yyyy-MM-dd").format(cDate);

		((TextView) view.findViewById(R.id.title)).setText(title);
		TextView t = (TextView) view.findViewById(R.id.hours);
		//t.setText(fDate);
		if (fDate.equals("2013-03-16"))
		{
			t.setText("(Pass holders only) 10am - 6pm");
		}
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
	
	private MyWeather parseWeather(Document srcDoc){

		  MyWeather myWeather = new MyWeather();

		 /** //<description>Yahoo! Weather for New York, NY</description>
		  myWeather.description = srcDoc.getElementsByTagName("description")
		    .item(0)
		    .getTextContent();

		  //<yweather:location city="New York" region="NY" country="United States"/>
		  Node locationNode = srcDoc.getElementsByTagName("yweather:location").item(0);
		  myWeather.city = locationNode.getAttributes()
		  .getNamedItem("city")
		  .getNodeValue()
		  .toString();
		myWeather.region = locationNode.getAttributes()
		  .getNamedItem("region")
		  .getNodeValue()
		  .toString();
		myWeather.country = locationNode.getAttributes()
		  .getNamedItem("country")
		  .getNodeValue()
		  .toString();

		//<yweather:wind chill="60" direction="0" speed="0"/>
		Node windNode = srcDoc.getElementsByTagName("yweather:wind").item(0);
		myWeather.windChill = windNode.getAttributes()
		  .getNamedItem("chill")
		  .getNodeValue()
		  .toString();
		myWeather.windDirection = windNode.getAttributes()
		  .getNamedItem("direction")
		  .getNodeValue()
		  .toString();
		myWeather.windSpeed = windNode.getAttributes()
		  .getNamedItem("speed")
		  .getNodeValue()
		  .toString();

		//<yweather:astronomy sunrise="6:52 am" sunset="7:10 pm"/>
		Node astronomyNode = srcDoc.getElementsByTagName("yweather:astronomy").item(0);
		myWeather.sunrise = astronomyNode.getAttributes()
		  .getNamedItem("sunrise")
		  .getNodeValue()
		  .toString();
		myWeather.sunset = astronomyNode.getAttributes()
		  .getNamedItem("sunset")
		  .getNodeValue()
		  .toString();  **/

		//<yweather:condition text="Fair" code="33" temp="60" date="Fri, 23 Mar 2012 8:49 pm EDT"/>
		Node conditionNode = srcDoc.getElementsByTagName("yweather:condition").item(0);
		myWeather.conditiontext = conditionNode.getAttributes()
		  .getNamedItem("text")
		  .getNodeValue()
		  .toString();
		myWeather.conditiondate = conditionNode.getAttributes()
		  .getNamedItem("temp")
		  .getNodeValue()
		  .toString();
		myWeather.conditioncode = conditionNode.getAttributes()
		   .getNamedItem("code")
		   .getNodeValue()
		   .toString();
		  return myWeather;
		 }

		 private Document convertStringToDocument(String src){
		  Document dest = null;

		  DocumentBuilderFactory dbFactory =
		    DocumentBuilderFactory.newInstance();
		  DocumentBuilder parser;

		  try {
		   parser = dbFactory.newDocumentBuilder();
		 dest = parser.parse(new ByteArrayInputStream(src.getBytes()));
		} catch (ParserConfigurationException e1) {
		 e1.printStackTrace();
		 //Toast.makeText(TodayCard.this,
		 //    e1.toString(), Toast.LENGTH_LONG).show();
		} catch (SAXException e) {
		 e.printStackTrace();
		// Toast.makeText(AndroidYahooWeatherDOMActivity.this,
		 //    e.toString(), Toast.LENGTH_LONG).show();
		} catch (IOException e) {
		 e.printStackTrace();
		 //Toast.makeText(AndroidYahooWeatherDOMActivity.this,
		 //    e.toString(), Toast.LENGTH_LONG).show();
		}

		  return dest;
		 }

		 private String QueryYahooWeather(){

		  String qResult = "";
		  String queryString = "http://weather.yahooapis.com/forecastrss?w=12767253";

		  HttpClient httpClient = new DefaultHttpClient();
		     HttpGet httpGet = new HttpGet(queryString);
		  
		     try {
		      HttpEntity httpEntity = httpClient.execute(httpGet).getEntity();
		    
		      if (httpEntity != null){
		       InputStream inputStream = httpEntity.getContent();
		       Reader in = new InputStreamReader(inputStream);
		       BufferedReader bufferedreader = new BufferedReader(in);
		       StringBuilder stringBuilder = new StringBuilder();
		     
		       String stringReadLine = null;

		       while ((stringReadLine = bufferedreader.readLine()) != null) {
		        stringBuilder.append(stringReadLine + "\n");
		       }
		     
		       qResult = stringBuilder.toString();
		      }

		} catch (ClientProtocolException e) {
		 e.printStackTrace();
		// Toast.makeText(TodayCard.this,
		//     e.toString(), Toast.LENGTH_LONG).show();
		} catch (IOException e) {
		 e.printStackTrace();
		// Toast.makeText(TodayCard.this,
		//     e.toString(), Toast.LENGTH_LONG).show();
		}

		     return qResult;
		 }
	}
	