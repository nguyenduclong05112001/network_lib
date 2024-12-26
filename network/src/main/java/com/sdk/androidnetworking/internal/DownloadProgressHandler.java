

package com.sdk.androidnetworking.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.sdk.androidnetworking.common.ANConstants;
import com.sdk.androidnetworking.interfaces.DownloadProgressListener;
import com.sdk.androidnetworking.model.Progress;

public class DownloadProgressHandler extends Handler {

    private final DownloadProgressListener mDownloadProgressListener;

    public DownloadProgressHandler(DownloadProgressListener downloadProgressListener) {
        super(Looper.getMainLooper());
        mDownloadProgressListener = downloadProgressListener;
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case ANConstants.UPDATE:
                if (mDownloadProgressListener != null) {
                    final Progress progress = (Progress) msg.obj;
                    mDownloadProgressListener.onProgress(progress.currentBytes, progress.totalBytes);
                }
                break;
            default:
                super.handleMessage(msg);
                break;
        }
    }
}
