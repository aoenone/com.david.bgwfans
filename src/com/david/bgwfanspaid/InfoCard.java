package com.david.bgwfanspaid;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.fima.cardsui.objects.Card;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InfoCard extends Card{
	
	private TextView weatherView;
	private TextView currentTemp;
	
	public InfoCard(String title) {
        super(title); 
    } 

	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.info_card, null);
		String city = "Williamsburg,VA&units=imperial";
		
	    weatherView = (TextView) view.findViewById(R.id.weather);
	    currentTemp = (TextView) view.findViewById(R.id.cur_temp_text);
	    
	    Date cDate = new Date();
        String fDate = new SimpleDateFormat("yyyy-MM-dd").format(cDate);

        ((TextView) view.findViewById(R.id.title)).setText(title);
        
        //Fixed this area for midly easier readability 
        TextView t = (TextView) view.findViewById(R.id.hours);
        if(fDate.equals(fDate.equals("2013-07-03") || fDate.equals("2013-07-04"))){
            t.setText("Hours: 10am - 11pm");}
        
        else {
            t.setText("Hours: 10am - 10pm"); }
        
        TextView t2 = (TextView) view.findViewById(R.id.hours2);
         if (fDate.equals("2013-08-11")){
         	t2.setText("Hours: 10am - 9pm");
		} else {
			t2.setText("Hours: 10am - 10pm");
		}

        if(isNetworkAvailable(context))
        {
            JSONWeatherTask task = new JSONWeatherTask();
            task.execute(new String[]{city});
        }

        return view; 
	}

    public boolean isNetworkAvailable(Context ctx)
    {
        ConnectivityManager cm = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()&& cm.getActiveNetworkInfo().isAvailable()&& cm.getActiveNetworkInfo().isConnected())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
	
  public class JSONWeatherTask extends AsyncTask<String, Void, Weather> {
		@Override
		protected Weather doInBackground(String... params) {
			Weather weather = new Weather();
			String data = ( (new WeatherHttpClient()).getWeatherData(params[0]));

			try {
				weather = JSONWeatherParser.getWeather(data);				
			} catch (JSONException e) {				
				e.printStackTrace();
                currentTemp.setText("0");
                weatherView.setText("Unavailable due to network error");
			}
			return weather;
	}
		 
			
	    @Override
		protected void onPostExecute(Weather weather) {			
			super.onPostExecute(weather);
			
			weatherView.setText(weather.currentCondition.getCondition() + "(" + weather.currentCondition.getDescr() + ")");
			
			currentTemp.setText((Double.toString(Math.round(weather.temperature.getTemp())) + (char) 0x00B0 ));
			
		/**	cityText.setText(weather.location.getCity() + "," + weather.location.getCountry());
			condDescr.setText(weather.currentCondition.getCondition() + "(" + weather.currentCondition.getDescr() + ")");
			temp.setText("" + Math.round((weather.temperature.getTemp() - 275.15)) + "�C");
			hum.setText("" + weather.currentCondition.getHumidity() + "%");
			press.setText("" + weather.currentCondition.getPressure() + " hPa");
			windSpeed.setText("" + weather.wind.getSpeed() + " mps");
			windDeg.setText("" + weather.wind.getDeg() + "�");    **/
				
		}
    }

}
