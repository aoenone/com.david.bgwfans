package com.david.bgwfanspaid.io.network;

import android.net.Uri;
import com.david.bgwfanspaid.io.utilities.NetworkUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by Pequots34 on 7/31/13.
 */
public class Network {

    private NetworkUtils.Protocol mProtocol;

    private NetworkUtils.Version mVersion;

    private String mKey;

    private List<String> mParts;

    private Map<String, String> mParameters;

    private String mName;

    public Network( Builder builder ) throws IllegalStateException {
        super();

        mProtocol = builder.protocol;

        mVersion = builder.version;

        mKey = builder.key;

        mParts = builder.parts;

        mParameters = builder.parameters;

        mName = builder.name;

        if ( mVersion == null ) {
            throw new IllegalStateException();
        }

        if ( mProtocol == null ) {
            mProtocol = NetworkUtils.Protocol.HTTPS;
        }
    }

    public Uri.Builder getUri() {
        Uri.Builder builder = Uri.parse( mProtocol.toString().toLowerCase().concat( "://".concat( mVersion.getDomain() ) ) ).buildUpon();

        if ( mVersion == NetworkUtils.Version.V1 ) {
            builder.appendPath( mVersion.toString().toLowerCase() );
        }

        builder.appendPath( mName );

        builder.appendPath( mKey );

        if ( mParts != null && !mParts.isEmpty() ) {
            for ( String part : mParts ) {
                if ( part != null && !part.isEmpty() ) {
                    builder.appendPath( part );
                }
            }
        }

        if ( mParameters != null && !mParameters.isEmpty() ) {
            for ( Map.Entry<String, String> entry : mParameters.entrySet() ) {
                if ( entry != null ) {
                    builder.appendQueryParameter( entry.getKey(), entry.getValue() );
                }
            }
        }

        return builder;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private NetworkUtils.Protocol protocol;

        private NetworkUtils.Version version;

        private String key;

        private List<String> parts;

        private Map<String, String> parameters;

        private String name;

        public Builder() {
            super();
        }

        public Builder setName( String name ) {
            this.name = name;

            return this;
        }

        public Builder setParameters( Map<String, String> parameters ) {
            this.parameters = parameters;

            return this;
        }

        public Builder setParts( List<String> parts ) {
            this.parts = parts;

            return this;
        }

        public Builder setApiKey( String key ) {
            this.key = key;

            return this;
        }

        public Builder setProtocol( NetworkUtils.Protocol protocol ) {
            this.protocol = protocol;

            return this;
        }

        public Builder setVersion( NetworkUtils.Version version ) {
            this.version = version;

            return this;
        }

        public Network build() {
            return new Network( this );
        }
    }

}
