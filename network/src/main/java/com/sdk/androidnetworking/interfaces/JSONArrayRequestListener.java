

package com.sdk.androidnetworking.interfaces;

import com.sdk.androidnetworking.error.ANError;

import org.json.JSONArray;

/**
 * Created by amitshekhar on 23/05/16.
 */
public interface JSONArrayRequestListener {

    void onResponse(JSONArray response);

    void onError(ANError anError);

}
