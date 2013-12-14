package com.david.bgwfanspaid.activity;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.crittercism.app.Crittercism;
import com.david.bgwfanspaid.JSONWeatherParser;
import com.david.bgwfanspaid.Weather;
import com.david.bgwfanspaid.WeatherHttpClient;
import com.david.bgwfanspaid.io.network.responses.INetworkResponse;
import com.david.bgwfanspaid.io.network.responses.NetworkResponse;
import com.david.bgwfanspaid.io.toolbox.NetworkServiceTask;
import com.david.bgwfanspaid.io.v2.network.services.ForecastService;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by david.hodge on 12/13/13.
 */
public class GlassActivity extends Activity {

    private CardScrollView mCardScrollView;
    private List<Card> mCards;
    Card card;
    String city;
    String lat;
    String lon;
    Context mContext;
    private final SimpleDateFormat updateTime = new SimpleDateFormat("hh:mm aa");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Crittercism.initialize(getApplicationContext(), "522b8d96a7928a2f76000001");

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        mContext = this;

        mCards = new ArrayList<Card>();

        if(isNetworkAvailable(GlassActivity.this)) {
            getHours();
            getUserLocation();
            getBgwWeather();
        }else {
            card = new Card(GlassActivity.this);
            card.setText("Network Error");
            card.setInfo("Please check your network connection");
            card.setTimestamp(updateTime.format(new Date()));
            mCards.add(card);
        }

        mCardScrollView = new CardScrollView(this);
        ExampleCardScrollAdapter adapter = new ExampleCardScrollAdapter();
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);

    }

    private void getUserLocation(){
        lat = Double.toString(37.233823);
        lon = Double.toString(-76.644827);
        city = "lat=" + lat + "&lon=" + lon + "&units=imperial";
        try{
            JSONWeatherTask task = new JSONWeatherTask();
            task.execute(new String[]{city});
        }catch (Exception e){
            Log.e("weather", e.toString());
        }
    }

    private void getHours(){
        Date cDate = new Date();
        String fDate = new SimpleDateFormat("yyyy-MM-dd").format(cDate);
        String todayHours;
        if((fDate.equals("2013-11-24") || fDate.equals("2013-12-01") || fDate.equals("2013-12-08") || fDate.equals("2013-12-15") || fDate.equals("2013-12-24"))){
            todayHours = "Hours: 3pm - 9pm";

        } else if(fDate.equals("2013-11-22") || fDate.equals("2013-11-23") || fDate.equals("2013-11-29") || fDate.equals("2013-11-30") || fDate.equals("2013-12-06") || fDate.equals("2013-12-07") || fDate.equals("2013-12-13") || fDate.equals("2013-12-14") || fDate.equals("2013-12-16") || fDate.equals("2013-12-17") || fDate.equals("2013-12-18") || fDate.equals("2013-12-19") || fDate.equals("2013-12-20") || fDate.equals("2013-12-21") || fDate.equals("2013-12-22") || fDate.equals("2013-12-23") || fDate.equals("2013-12-26")
                || fDate.equals("2013-12-27") || fDate.equals("2013-12-28") || fDate.equals("2013-12-29") || fDate.equals("2013-12-30") || fDate.equals("2013-12-31")){
            todayHours = "Hours: 3pm - 10pm";

        } else{
            todayHours = "Hours: Closed";
        }

        card = new Card(GlassActivity.this);
        card.setText(todayHours);
        card.setInfo("Today's park hours");
        card.setTimestamp(updateTime.format(new Date()));
        mCards.add(card);
    }

    private void getBgwWeather(){
        ForecastService.Request request1 = ForecastService.Request.newBuilder("9127a75d40728c2aeab21957e38a5a62")
                .setLatitude(37.233823)
                .setLongitude(-76.644827)
                .build();

        new NetworkServiceTask() {

            @Override
            protected void onPostExecute( INetworkResponse network ) {
                if ( network == null || network.getStatus() == NetworkResponse.Status.FAIL ) {
                    Toast.makeText(mContext, "FORECAST ERROR", Toast.LENGTH_SHORT).show();
                    return;
                }

                ForecastService.Response response = ( ForecastService.Response ) network;

                long itemPos = Math.round(response.getForecast().getCurrently().getTemperature());
                DecimalFormat df = new DecimalFormat("###.#");
                String itemPosString = df.format(itemPos);

                card = new Card(GlassActivity.this);
                card.setText(itemPosString + (char) 0x00B0 + "f");
                card.setInfo(response.getForecast().getCurrently().getSummary());
                card.setTimestamp(updateTime.format(new Date()));
                mCards.add(card);
            }
        }.execute(request1);
    }

    public boolean isNetworkAvailable(Context ctx){
        ConnectivityManager cm = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()&& cm.getActiveNetworkInfo().isAvailable()&& cm.getActiveNetworkInfo().isConnected()) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }

    private class JSONWeatherTask extends AsyncTask<String, Void, Weather> {

        @Override
        protected Weather doInBackground(String... params) {
            Weather weather = new Weather();
            String data = (new WeatherHttpClient().getWeatherData(params[0]));

            try {
                weather = JSONWeatherParser.getWeather(data);
            } catch (Exception e) {
                e.printStackTrace();
                Crittercism.logHandledException(e);
            }
            return weather;
        }

        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);
            long itemPos = Math.round(weather.temperature.getTemp());
            DecimalFormat df = new DecimalFormat("###.#");
            String itemPosString = df.format(itemPos);
            int value = Math.round(weather.temperature.getTemp());

            card = new Card(GlassActivity.this);
            card.setInfo(weather.currentCondition.getDescr());
            card.setText(Integer.toString(value)+ (char) 0x00B0  + "f");
            card.setTimestamp(updateTime.format(new Date()));
            mCards.add(card);
        }
    }

    private class ExampleCardScrollAdapter extends CardScrollAdapter {
        @Override
        public int findIdPosition(Object id) {
            return -1;
        }

        @Override
        public int findItemPosition(Object item) {
            return mCards.indexOf(item);
        }

        @Override
        public int getCount() {
            return mCards.size();
        }

        @Override
        public Object getItem(int position) {
            return mCards.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return mCards.get(position).toView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();
        EasyTracker.getInstance().activityStart(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EasyTracker.getInstance().activityStop(this);
    }

}
