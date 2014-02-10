package com.david.bgtfans.io.v2.transfer;

import android.os.Parcel;
import android.os.Parcelable;

public class Alert implements Parcelable {

    String mTitle;
    Long time;
    Long expires;
    String description;

	public Alert(Builder builder) {
        super();
        mTitle = builder.title;
        time = builder.time;
        expires = builder.expires;
        description = builder.description;
	}

	public Alert(Parcel in) {
        super();
       mTitle = in.readString();
        time = in.readLong();
        expires = in.readLong();
        description = in.readString();

	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeLong(time);
        dest.writeLong(expires);
        dest.writeString(description);
	}

    public String getTitle(){
        return mTitle;
    }

    public Long getTime(){
        return time;
    }

    public Long getExpires(){
        return expires;
    }

    public String getDescription(){
        return description;
    }

    public static final class Builder {
        private String title;
        private Long time;
        private Long expires;
        private String description;

    }


	public static final Creator<Alert> CREATOR = new Creator<Alert>() {

        public Alert createFromParcel( Parcel in ) {
            return new Alert( in );
        }

        public Alert[] newArray( int size ) {
            return new Alert[ size ];
        }
    };

}
