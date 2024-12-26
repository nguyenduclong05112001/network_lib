

package com.sdk.androidnetworking.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.sdk.androidnetworking.common.ANConstants;
import com.sdk.androidnetworking.interfaces.UploadProgressListener;
import com.sdk.androidnetworking.model.Progress;

public class UploadProgressHandler extends Handler {

    private final UploadProgressListener mUploadProgressListener;

    public UploadProgressHandler(UploadProgressListener uploadProgressListener) {
        super(Looper.getMainLooper());
        mUploadProgressListener = uploadProgressListener;
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case ANConstants.UPDATE:
                if (mUploadProgressListener != null) {
                    final Progress progress = (Progress) msg.obj;
                    mUploadProgressListener.onProgress(progress.currentBytes, progress.totalBytes);
                }
                break;
            default:
                super.handleMessage(msg);
                break;
        }
    }
}
