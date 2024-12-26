

package com.sdk.androidnetworking.interfaces;

import com.sdk.androidnetworking.error.ANError;

/**
 * Created by amitshekhar on 29/04/16.
 */
public interface DownloadListener {

    void onDownloadComplete();

    void onError(ANError anError);
}
