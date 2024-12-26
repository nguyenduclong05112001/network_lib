

package com.sdk.androidnetworking.interfaces;

import com.sdk.androidnetworking.error.ANError;

/**
 * Created by amitshekhar on 23/05/16.
 */
public interface StringRequestListener {

    void onResponse(String response);

    void onError(ANError anError);

}
