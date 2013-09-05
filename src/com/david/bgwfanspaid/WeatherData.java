package com.david.bgwfanspaid;

/**
 * A helper class representing weather data, for use with {@link WeatherExtension}.
 */
public class WeatherData {
    public static final int INVALID_TEMPERATURE = Integer.MIN_VALUE;
    public static final int INVALID_CONDITION = -1;

    public static int getConditionIconId(int conditionCode) {
        // http://developer.yahoo.com/weather/
        switch (conditionCode) {
            case 20: // foggy
            case 21: // haze
            case 22: // smoky
            case 23: // blustery
            case 24: // windy
                return R.drawable.foggy;
            case 25: // cold
            case 26: // cloudy
            case 27: // mostly cloudy (night)
            case 28: // mostly cloudy (day)
                return R.drawable.cloudy;
            case 29: // partly cloudy (night)
            case 30: // partly cloudy (day)
            case 44: // partly cloudy
                return R.drawable.partlycloudy;
            case 31: // clear (night)
            case 33: // fair (night)
            case 34: // fair (day)
            case 32: // sunny
            case 36: // hot
                return R.drawable.sunny;
            case 0: // tornado
            case 1: // tropical storm
            case 2: // hurricane
            case 3: // severe thunderstorms
            case 4: // thunderstorms
            case 5: // mixed rain and snow
            case 6: // mixed rain and sleet
            case 7: // mixed snow and sleet
            case 8: // freezing drizzle
            case 9: // drizzle
            case 10: // freezing rain
            case 11: // showers
            case 12: // showers
            case 17: // hail
            case 18: // sleet
            case 19: // dust
            case 35: // mixed rain and hail
            case 37: // isolated thunderstorms
            case 38: // scattered thunderstorms
            case 39: // scattered thunderstorms
            case 40: // scattered showers
            case 45: // thundershowers
            case 47: // isolated thundershowers
                return R.drawable.raining;
            case 13: // snow flurries
            case 14: // light snow showers
            case 15: // blowing snow
            case 16: // snow
            case 41: // heavy snow
            case 42: // scattered snow showers
            case 43: // heavy snow
            case 46: // snow showers
                return R.drawable.snow;
        }

        return R.drawable.na;
    }

    public int temperature = INVALID_TEMPERATURE;
    public int conditionCode = INVALID_CONDITION;
    public int todayForecastConditionCode = INVALID_CONDITION;
    public String conditionText;
    public String forecastText;

    public String location;

    public WeatherData() {
    }

    public boolean hasValidTemperature() {
        return temperature > Integer.MIN_VALUE;
    }
}

