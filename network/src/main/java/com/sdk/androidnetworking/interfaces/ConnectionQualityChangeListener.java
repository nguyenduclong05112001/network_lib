

package com.sdk.androidnetworking.interfaces;

import com.sdk.androidnetworking.common.ConnectionQuality;

/**
 * Created by amitshekhar on 29/05/16.
 */
public interface ConnectionQualityChangeListener {

    void onChange(ConnectionQuality currentConnectionQuality, int currentBandwidth);
}
