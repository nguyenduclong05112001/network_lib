

package com.sdk.androidnetworking.core;

import java.util.concurrent.Executor;

/**
 * Created by amitshekhar on 22/03/16.
 */
public interface ExecutorSupplier {

    ANExecutor forNetworkTasks();

    ANExecutor forImmediateNetworkTasks();

    Executor forMainThreadTasks();
}
