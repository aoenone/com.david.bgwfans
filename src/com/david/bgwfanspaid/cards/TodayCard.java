package com.david.bgwfanspaid.cards;

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

import com.david.bgwfanspaid.R;
import com.david.bgwfanspaid.WeatherData;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import com.fima.cardsui.objects.Card;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TodayCard extends Card {

    class MyWeather {

        public String conditiontext;
        public String conditiondate;
        public String conditioncode;

        public String toString() {

            return "It's currently " + conditiondate + (char) 0x00B0 + "\nand " + conditiontext;

        }
    }

    WeatherData data = new WeatherData();
    ImageView wImg;
    //TextView t;
    int date;
    String Weather;
    //TextView weatherView;

    static final String baseURL = "http://weather.yahooapis.com/forecastrss?w=12767253";

    public TodayCard(String title) {
        super(title);
    }

   /** public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    	View view = inflater.inflate(R.layout.todaycard, container, false);
    	TextView weatherView = (TextView) view.findViewById(R.id.weather);
		return view;

    }**/

    @Override
    public View getCardContent(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.todaycard, null);
        //View view = inflater.inflate(R.layout.todaycard, container, false);

        String city = "Williamsburg,VA&units=imperial";

       // weatherView = (TextView) view.findViewById(R.id.weather);
        //weatherView.setText(Weather);
        //((TextView) view.findViewById(R.id.weather)).setText(weatherData);
        //ImageView wImage = (ImageView) view.findViewById(R.id.wimg);


        //weather.setText(weatherResult.toString());
        //MyWeather conditioncode = parseWeather(weatherDoc);
        //wImg.setImageDrawable(conditioncode);

        Date cDate = new Date();
        String fDate = new SimpleDateFormat("yyyy-MM-dd").format(cDate);

        ((TextView) view.findViewById(R.id.title)).setText(title);

        //Fixed this area for midly easier readability
        TextView t = (TextView) view.findViewById(R.id.hours);

        if (fDate.equals("2013-03-25") || fDate.equals("2013-03-26") || fDate.equals("2013-03-27") || fDate.equals("2013-03-28") || fDate.equals("2013-03-29") || fDate.equals("2013-03-31")) {
            t.setText("Hours: 9am - 8pm"); }

        else if (fDate.equals("2013-03-30") || fDate.equals("2013-04-06")) {
            t.setText("Hours: 9am - 10pm"); }

        else if (fDate.equals("2013-04-13") || fDate.equals("2013-04-20") || fDate.equals("2013-04-27") || fDate.equals("2013-05-04") || fDate.equals("2013-05-11") || fDate.equals("2013-05-18") || fDate.equals("2013-05-25") || fDate.equals("2013-05-26")) {
            t.setText("Hours: 10am - 10pm"); }

        else if (fDate.equals("2013-04-12") || fDate.equals("2013-04-19") || fDate.equals("2013-04-26") || fDate.equals("2013-04-28") || fDate.equals("2013-05-03") || fDate.equals("2013-05-05") || fDate.equals("2013-05-10") || fDate.equals("2013-05-12") || fDate.equals("2013-05-17") || fDate.equals("2013-05-19") || fDate.equals("2013-05-24") || fDate.equals("2013-05-27") || fDate.equals("2013-05-28") || fDate.equals("2013-05-29") || fDate.equals("2013-05-30") || fDate.equals("2013-05-31")) {
            t.setText("Hours: 10am - 8pm"); }

        else {
            t.setText("Hours: Closed"); }

      //  JSONWeatherTask task = new JSONWeatherTask();
     //   task.execute(new String[]{city});

        return view;
    }

 /** public class JSONWeatherTask extends AsyncTask<String, Void, Weather> {

		@Override
		protected Weather doInBackground(String... params) {
			Weather weather = new Weather();
			String data = ( (new WeatherHttpClient()).getWeatherData(params[0]));

			try {
				weather = JSONWeatherParser.getWeather(data);

				// Let's retrieve the icon
				//weather.iconData = ( (new WeatherHttpClient()).getImage(weather.currentCondition.getIcon()));

			} catch (JSONException e) {
				e.printStackTrace();
			}
			return weather;

	}




	@Override
		protected void onPostExecute(Weather weather) {
			super.onPostExecute(weather);

			if (weather.iconData != null && weather.iconData.length > 0) {
				//Bitmap img = BitmapFactory.decodeByteArray(weather.iconData, 0, weather.iconData.length);
				//imgView.setImageBitmap(img);
			}
			//TextView weatherView = (TextView) view.findViewById(R.id.weather);
			//TextView weatherText = getActivity().findViewById(R.id.weather);
			//weatherView.setText(weather.currentCondition.getCondition() + weather.currentCondition.getDescr());
			//String Weather = weather.currentCondition.getCondition() + weather.currentCondition.getDescr();

		/**	cityText.setText(weather.location.getCity() + "," + weather.location.getCountry());
			condDescr.setText(weather.currentCondition.getCondition() + "(" + weather.currentCondition.getDescr() + ")");
			temp.setText("" + Math.round((weather.temperature.getTemp() - 275.15)) + "�C");
			hum.setText("" + weather.currentCondition.getHumidity() + "%");
			press.setText("" + weather.currentCondition.getPressure() + " hPa");
			windSpeed.setText("" + weather.wind.getSpeed() + " mps");
			windDeg.setText("" + weather.wind.getDeg() + "�");

		}
    } **/
}

