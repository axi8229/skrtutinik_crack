package com.google.android.exoplayer2.upstream;

import java.io.IOException;

/* loaded from: classes2.dex */
public interface LoadErrorHandlingPolicy {
    long getBlacklistDurationMsFor(int dataType, long loadDurationMs, IOException exception, int errorCount);

    int getMinimumLoadableRetryCount(int dataType);

    long getRetryDelayMsFor(int dataType, long loadDurationMs, IOException exception, int errorCount);
}
