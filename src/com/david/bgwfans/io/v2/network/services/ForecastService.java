package com.david.bgwfans.io.v2.network.services;

import java.util.ArrayList;
import java.util.List;

import android.net.Uri;
import com.david.bgwfans.io.network.Network;
import com.david.bgwfans.io.network.requests.NetworkRequest;
import com.david.bgwfans.io.network.responses.INetworkResponse;
import com.david.bgwfans.io.network.responses.NetworkResponse;
import com.david.bgwfans.io.utilities.NetworkUtils;
import com.david.bgwfans.io.v2.network.responses.ForecastResponse;
import com.david.bgwfans.io.v2.transfer.DataBlock;
import com.david.bgwfans.io.v2.transfer.DataPoint;
import com.david.bgwfans.io.v2.transfer.LatLng;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ForecastService {

	private ForecastService() {
		super();

		throw new InstantiationError();
	}

	public static class Request extends NetworkRequest {

		private LatLng mLatLng;

        private double mLatitude;

        private double mLongitude;

        private String mApiKey;

		public Request( Builder builder ) {
			super();

            mLatLng = builder.latLng;

            mLatitude = builder.latitude;

            mLongitude = builder.longitude;


            mApiKey = builder.apiKey;
		}

        @Override
        public Class<? extends INetworkResponse> getResponse() {
            return Response.class;
        }

        @Override
        public Uri.Builder getUri() {
            return Network.newBuilder()
                    .setApiKey( mApiKey )
                    .setName( "forecast" )
                    .setParts( getPath() )
                    .setVersion( NetworkUtils.Version.V2 )
                    .setProtocol( NetworkUtils.Protocol.HTTPS )
                    .build()
                    .getUri();
        }

		private List<String> getPath() {

                List<String> parts = new ArrayList<String>();

                StringBuilder builder = new StringBuilder();
                builder.append(mLatitude);
                builder.append(",");
                builder.append(mLongitude);
                parts.add(builder.toString());

//				parts.add( mLatLng.toConcatenatedString() );

			    return parts;
		}

        public static Builder newBuilder( String apiKey ) {
            return new Builder( apiKey );
        }

	}

	public static class Response extends NetworkResponse {

		private ForecastResponse mForecast;

		public ForecastResponse getForecast() {
			return mForecast;
		}

		@Override
		public void onNetworkResponse( JSONObject data ) throws JSONException, IllegalStateException {
			super.onNetworkResponse( data );

			if ( getStatus() == Status.SUCCESS ) {
				mForecast = ForecastResponse.newBuilder()
						.setLatitude( data.optDouble( "latitude" ) )
						.setLongitude( data.optDouble( "longitude" ) )
						.setTimezone( data.optString( "timezone" ) )
						.setOffset( data.optInt( "offset" ) )
						.setDaily( getDataBlock( data.optJSONObject( "daily" ) ) )
					    .setHourly( getDataBlock( data.optJSONObject( "hourly" ) ) )
					    .setMinutely( getDataBlock( data.optJSONObject( "minutely" ) ) )
					    .setCurrently( getDataPoint( data.optJSONObject( "currently" ) ) ).build();
			}
		}

		private DataPoint getDataPoint( JSONObject data ) {
			if ( data != null ) {
				return DataPoint.newPointBuilder()
					.setTime( data.optLong( "time" ) )
					.setSummary( data.optString( "summary" ) )
					.setIcon( data.optString( "icon" ) )
					.setPrecipIntensity( data.optDouble( "precipIntensity" ) )
					.setTemperature( data.optDouble( "temperature" ) )
					.setWindSpeed( data.optDouble( "windSpeed" ) )
					.setWindBearing( data.optDouble( "windBearing" ) )
					.setCloudCover( data.optDouble( "cloudCover" ) )
					.setHumidity( data.optDouble( "humidity" ) )
					.setPressure( data.optDouble( "pressure" ) )
					.setPrecipIntensityError( data.optDouble( "precipIntensityError" ) )
					.setWindSpeedError( data.optDouble( "windSpeedError" ) )
					.setPressureError( data.optDouble( "pressureError" ) )
					.setVisibility( data.optDouble( "visibility" ) ).build();
			}

			return null;
		}

		private DataBlock getDataBlock( JSONObject data ) {
			if ( data != null ) {
                DataBlock.Builder builder = DataBlock.newBuilder()
						.setIcon( data.optString( "icon" ) )
						.setSummary( data.optString( "summary" ) );

				JSONArray collection = data.optJSONArray( "data" );

				if ( collection != null ) {
					for ( int i = 0; i < collection.length(); i ++ ) {
						builder.withDataPoint( getDataPoint( collection.optJSONObject( i ) ) );
					}

				}

				return builder.build();
			}

			return null;
		}
	}

	public static class Builder {

		private LatLng latLng;
        private double latitude;
        private double longitude;

        private String apiKey;

        public Builder( String apiKey ) throws IllegalArgumentException {
            super();

            this.apiKey = apiKey;
        }

        public Builder setLatitude( double latitude ) {
            this.latitude = latitude;

            return this;
        }

        public Builder setLongitude( double longitude ) {
            this.longitude = longitude;

            return this;
        }

//		public Builder setLatLng( LatLng latLng ) {
//			this.latLng = latLng;
//
//			return this;
//		}
//
		public Request build() {
			return new Request( this );
		}

	}

}
