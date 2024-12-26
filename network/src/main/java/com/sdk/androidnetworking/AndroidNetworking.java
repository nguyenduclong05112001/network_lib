

package com.sdk.androidnetworking;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.sdk.androidnetworking.common.ANConstants;
import com.sdk.androidnetworking.common.ANRequest;
import com.sdk.androidnetworking.common.ConnectionClassManager;
import com.sdk.androidnetworking.common.ConnectionQuality;
import com.sdk.androidnetworking.core.Core;
import com.sdk.androidnetworking.interceptors.HttpLoggingInterceptor.Level;
import com.sdk.androidnetworking.interfaces.ConnectionQualityChangeListener;
import com.sdk.androidnetworking.interfaces.Parser;
import com.sdk.androidnetworking.internal.ANImageLoader;
import com.sdk.androidnetworking.internal.ANRequestQueue;
import com.sdk.androidnetworking.internal.InternalNetworking;
import com.sdk.androidnetworking.utils.ParseUtil;
import com.sdk.androidnetworking.utils.Utils;

import okhttp3.OkHttpClient;

@SuppressWarnings("unused")
public class AndroidNetworking {

    private AndroidNetworking() {
    }

    public static void initialize(Context context) {
        InternalNetworking.setClientWithCache(context.getApplicationContext());
        ANRequestQueue.initialize();
        ANImageLoader.initialize();
    }

    public static void initialize(Context context, OkHttpClient okHttpClient) {
        if (okHttpClient != null && okHttpClient.cache() == null) {
            okHttpClient = okHttpClient
                    .newBuilder()
                    .cache(Utils.getCache(context.getApplicationContext(),
                            ANConstants.MAX_CACHE_SIZE, ANConstants.CACHE_DIR_NAME))
                    .build();
        }
        InternalNetworking.setClient(okHttpClient);
        ANRequestQueue.initialize();
        ANImageLoader.initialize();
    }

    public static void setBitmapDecodeOptions(BitmapFactory.Options decodeOptions) {
        if (decodeOptions != null) {
            ANImageLoader.getInstance().setBitmapDecodeOptions(decodeOptions);
        }
    }

    public static void setConnectionQualityChangeListener(ConnectionQualityChangeListener connectionChangeListener) {
        ConnectionClassManager.getInstance().setListener(connectionChangeListener);
    }

    public static void removeConnectionQualityChangeListener() {
        ConnectionClassManager.getInstance().removeListener();
    }

    public static ANRequest.GetRequestBuilder get(String url) {
        return new ANRequest.GetRequestBuilder(url);
    }

    public static ANRequest.HeadRequestBuilder head(String url) {
        return new ANRequest.HeadRequestBuilder(url);
    }

    public static ANRequest.OptionsRequestBuilder options(String url) {
        return new ANRequest.OptionsRequestBuilder(url);
    }

    public static ANRequest.PostRequestBuilder post(String url) {
        return new ANRequest.PostRequestBuilder(url);
    }

    public static ANRequest.PutRequestBuilder put(String url) {
        return new ANRequest.PutRequestBuilder(url);
    }

    public static ANRequest.DeleteRequestBuilder delete(String url) {
        return new ANRequest.DeleteRequestBuilder(url);
    }

    public static ANRequest.PatchRequestBuilder patch(String url) {
        return new ANRequest.PatchRequestBuilder(url);
    }

    public static ANRequest.DownloadBuilder download(String url, String dirPath, String fileName) {
        return new ANRequest.DownloadBuilder(url, dirPath, fileName);
    }

    public static ANRequest.MultiPartBuilder upload(String url) {
        return new ANRequest.MultiPartBuilder(url);
    }

    public static ANRequest.DynamicRequestBuilder request(String url, int method) {
        return new ANRequest.DynamicRequestBuilder(url, method);
    }

    public static void cancel(Object tag) {
        ANRequestQueue.getInstance().cancelRequestWithGivenTag(tag, false);
    }

    public static void forceCancel(Object tag) {
        ANRequestQueue.getInstance().cancelRequestWithGivenTag(tag, true);
    }

    public static void cancelAll() {
        ANRequestQueue.getInstance().cancelAll(false);
    }

    public static void forceCancelAll() {
        ANRequestQueue.getInstance().cancelAll(true);
    }

    public static void enableLogging() {
        enableLogging(Level.BASIC);
    }

    public static void enableLogging(Level level) {
        InternalNetworking.enableLogging(level);
    }

    public static void evictBitmap(String key) {
        final ANImageLoader.ImageCache imageCache = ANImageLoader.getInstance().getImageCache();
        if (imageCache != null && key != null) {
            imageCache.evictBitmap(key);
        }
    }

    public static void evictAllBitmap() {
        final ANImageLoader.ImageCache imageCache = ANImageLoader.getInstance().getImageCache();
        if (imageCache != null) {
            imageCache.evictAllBitmap();
        }
    }

    public static void setUserAgent(String userAgent) {
        InternalNetworking.setUserAgent(userAgent);
    }

    public static int getCurrentBandwidth() {
        return ConnectionClassManager.getInstance().getCurrentBandwidth();
    }

    public static ConnectionQuality getCurrentConnectionQuality() {
        return ConnectionClassManager.getInstance().getCurrentConnectionQuality();
    }

    public static void setParserFactory(Parser.Factory parserFactory) {
        ParseUtil.setParserFactory(parserFactory);
    }

    public static boolean isRequestRunning(Object tag) {
        return ANRequestQueue.getInstance().isRequestRunning(tag);
    }

    public static void shutDown() {
        Core.shutDown();
        evictAllBitmap();
        ConnectionClassManager.getInstance().removeListener();
        ConnectionClassManager.shutDown();
        ParseUtil.shutDown();
    }
}
