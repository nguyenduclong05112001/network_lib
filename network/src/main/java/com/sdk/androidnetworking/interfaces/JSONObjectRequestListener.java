

package com.sdk.androidnetworking.interfaces;

import com.sdk.androidnetworking.error.ANError;

import org.json.JSONObject;

/**
 * Created by amitshekhar on 23/05/16.
 */
public interface JSONObjectRequestListener {

    void onResponse(JSONObject response);

    void onError(ANError anError);

}
