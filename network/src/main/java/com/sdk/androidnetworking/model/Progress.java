

package com.sdk.androidnetworking.model;

import java.io.Serializable;

public class Progress implements Serializable {

    public long currentBytes;
    public long totalBytes;

    public Progress(long currentBytes, long totalBytes) {
        this.currentBytes = currentBytes;
        this.totalBytes = totalBytes;
    }

}