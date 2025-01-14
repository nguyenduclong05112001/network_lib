

package com.sdk.androidnetworking.interfaces;

import android.graphics.Bitmap;

import com.sdk.androidnetworking.error.ANError;

/**
 * Created by amitshekhar on 23/05/16.
 */
public interface BitmapRequestListener {

    void onResponse(Bitmap response);

    void onError(ANError anError);

}
