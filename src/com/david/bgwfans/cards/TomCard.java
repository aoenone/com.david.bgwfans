package com.david.bgwfans.cards;

import java.io.BufferedReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.david.bgwfans.R;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.fima.cardsui.objects.Card;

import android.content.Context;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class TomCard extends Card {

    class MyWeather {
        String description;
        String city;
        String region;
        String country;

        String windChill;
        String windDirection;
        String windSpeed;

        String sunrise;
        String sunset;

        String tempHigh;
        String tempLow;

        String conditiontext;
        String conditiondate;
        String conditioncode;

        public String toString() {

            return "Will be " + conditiontext + "\nwith a high of " + conditiondate + (char) 0x00B0;
        }
    }

    public TomCard(String title) {
        super(title);
    }


    private Document convertStringToDocument(String src) {
        Document dest = null;

        DocumentBuilderFactory dbFactory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder parser;

        try {
            parser = dbFactory.newDocumentBuilder();
            dest = parser.parse(new ByteArrayInputStream(src.getBytes()));
        } catch (ParserConfigurationException e1) {
            e1.printStackTrace();

        } catch (SAXException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

        return dest;
    }


    @Override
    public View getCardContent(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.tomcard, null);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        TextView weather = (TextView) view.findViewById(R.id.weather);

        String weatherString = QueryYahooWeather();
        Document weatherDoc = convertStringToDocument(weatherString);

        MyWeather weatherResult = parseWeather(weatherDoc);
        weather.setText(weatherResult.toString());

        Date cDate = new Date();
        String fDate = new SimpleDateFormat("yyyy-MM-dd").format(cDate);

        ((TextView) view.findViewById(R.id.title)).setText(title);

        TextView t = (TextView) view.findViewById(R.id.hours);

        if (fDate.equals("2013-03-25") || fDate.equals("2013-03-26") || fDate.equals("2013-03-27") || fDate.equals("2013-03-28") || fDate.equals("2013-03-31") || fDate.equals("2013-04-01") || fDate.equals("2013-04-02") || fDate.equals("2013-04-03") || fDate.equals("2013-04-04") || fDate.equals("2013-04-06")) {
            t.setText("Hours: 9am - 8pm"); }

        else if (fDate.equals("2013-03-29")) {
            t.setText("Hours: 9am - 10pm");}

        else if (fDate.equals("2013-03-30")) {
            t.setText("Hours: 9am - 8pm"); }

        else if(fDate.equals("2013-04-11") || fDate.equals("2013-04-11") || fDate.equals("2013-04-13") || fDate.equals("2013-04-18") || fDate.equals("2013-04-20") || fDate.equals("2013-04-25") || fDate.equals("2013-04-27") || fDate.equals("2013-05-02") || fDate.equals("2013-05-04")){
        	t.setText("Hours: 10am - 8pm"); }

        else if (fDate.equals("2013-04-05") || fDate.equals("2013-04-12") || fDate.equals("2013-04-19") || fDate.equals("2013-04-26") || fDate.equals("2013-05-03") || fDate.equals("2013-05-10") || fDate.equals("2013-05-17") || fDate.equals("2013-05-24") || fDate.equals("2013-05-31")) {
            t.setText("Hours: 10am - 10pm"); }

        else {
            t.setText("Hours: Closed"); }

        return view;
    }

    private MyWeather parseWeather(Document srcDoc) {

        MyWeather myWeather = new MyWeather();

        //<yweather:condition text="Fair" code="33" temp="60" date="Fri, 23 Mar 2012 8:49 pm EDT"/>
        Node conditionNode = srcDoc.getElementsByTagName("yweather:forecast").item(0);
        myWeather.conditiontext = conditionNode.getAttributes()
                .getNamedItem("text")
                .getNodeValue()
                .toString();
        myWeather.conditiondate = conditionNode.getAttributes()
                .getNamedItem("high")
                .getNodeValue()
                .toString();
        myWeather.conditioncode = conditionNode.getAttributes()
                .getNamedItem("code")
                .getNodeValue()
                .toString();
        return myWeather;
    }

    private String QueryYahooWeather() {

        String qResult = "";
        String queryString = "http://weather.yahooapis.com/forecastrss?w=12767253";

        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(queryString);

        try {
            HttpEntity httpEntity = httpClient.execute(httpGet).getEntity();

            if (httpEntity != null) {

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
           qResult = "Not Avilable";
        } catch (IOException e) {
            e.printStackTrace();
            qResult = "Not Avilable";
        }

        return qResult;
    }


}