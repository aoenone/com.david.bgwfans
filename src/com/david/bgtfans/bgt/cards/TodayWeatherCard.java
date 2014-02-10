package com.david.bgtfans.bgt.cards;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.david.bgtfans.JSONWeatherParser;
import com.david.bgtfans.R;
import com.david.bgtfans.Weather;
import com.david.bgtfans.WeatherHttpClient;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by david.hodge on 2/9/14.
 */
public class TodayWeatherCard extends Card {

    TextView currentTemp;
    TextView currentConditions;
    TextView highLowTemp;
    ImageView weatherIcon;
    String city = "Williamsburg,VA&units=imperial";

    /**
     * Constructor with a custom inner layout
     *
     * @param context
     */
    public TodayWeatherCard(Context context) {
        this(context, R.layout.today_weather_card);
    }

    /**
     * @param context
     * @param innerLayout
     */
    public TodayWeatherCard(Context context, int innerLayout) {
        super(context, innerLayout);
        init();
    }

    /**
     * Init
     */
    private void init() {

        //No Header

        /*
        //Set a OnClickListener listener
        setOnClickListener(new OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(getContext(), "Click Listener card=", Toast.LENGTH_LONG).show();
            }
        });*/
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {

        if (isNetworkAvailable(mContext)) {
            JSONWeatherTask task = new JSONWeatherTask();
            task.execute(new String[]{city});
        }
        //Retrieve elements
        currentTemp = (TextView) parent.findViewById(R.id.cur_temp_text);
        currentConditions = (TextView) parent.findViewById(R.id.weather);
        highLowTemp = (TextView) parent.findViewById(R.id.avg_temp_text);
        weatherIcon = (ImageView) parent.findViewById(R.id.weather_icon);

    }

    public boolean isNetworkAvailable(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting() && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    public class JSONWeatherTask extends AsyncTask<String, Void, Weather> {
        @Override
        protected Weather doInBackground(String... params) {
            Weather weather = new Weather();
            String data = ((new WeatherHttpClient()).getWeatherData(params[0]));

            try {
                weather = JSONWeatherParser.getWeather(data);
            } catch (JSONException e) {
                e.printStackTrace();
                currentTemp.setText("N/A");
                currentConditions.setText("Unavailable due to network error");
            }
            return weather;
        }


        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);

            currentConditions.setText(weather.currentCondition.getCondition() + "(" + weather.currentCondition.getDescr() + ")");
            Log.d("weather", weather.currentCondition.getIcon());

            //Future reference http://bugs.openweathermap.org/projects/api/wiki/Weather_Condition_Codes
            String weatherIconUrl =  "http://openweathermap.org/img/w/" + weather.currentCondition.getIcon() + ".png";
            Picasso.with(mContext)
                    .load(weatherIconUrl)
                    .into(weatherIcon);

            long high = Math.round(weather.temperature.getMaxTemp());
            long low = Math.round(weather.temperature.getMinTemp());
            long itemPos = Math.round(weather.temperature.getTemp());
            DecimalFormat df = new DecimalFormat("###.#");
            String itemPosString = df.format(itemPos);
            String lowTemp = df.format(low);
            String highTemp = df.format(high);
            currentTemp.setText(itemPosString + (char) 0x00B0);
            highLowTemp.setText(highTemp + (char) 0x00B0 + "/" + lowTemp + (char) 0x00B0);
            Date d = new Date(weather.location.getSunset());
            SimpleDateFormat f = new SimpleDateFormat("hh:mm aa");
            f.setTimeZone(TimeZone.getTimeZone("EST"));
            String s = f.format(d);
//            sunset.setText("Sunrise: " + s);

        }
    }
}
