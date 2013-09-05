package com.david.bgwfanspaid.io.network.requests;


import android.net.Uri;
import com.david.bgwfanspaid.io.network.responses.INetworkResponse;
import com.david.bgwfanspaid.io.utilities.NetworkUtils;

/**
 * Created by Pequots34 on 7/31/13.
 */
public abstract class NetworkRequest implements INetworkRequest<INetworkResponse> {

    @Override
    public NetworkUtils.Method getMethod() {
        return NetworkUtils.Method.GET;
    }

    public String getContentType() {
        return NetworkUtils.APPLICATION_JSON_CONTENT_TYPE;
    }

    public String getPostBody() { return null; }

    public abstract Class<? extends INetworkResponse> getResponse();

    public abstract Uri.Builder getUri();

}
