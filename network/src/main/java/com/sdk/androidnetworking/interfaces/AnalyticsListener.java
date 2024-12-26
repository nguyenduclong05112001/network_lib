

package com.sdk.androidnetworking.interfaces;

/**
 * Created by amitshekhar on 31/05/16.
 */
public interface AnalyticsListener {

    void onReceived(long timeTakenInMillis, long bytesSent, long bytesReceived, boolean isFromCache);

}
