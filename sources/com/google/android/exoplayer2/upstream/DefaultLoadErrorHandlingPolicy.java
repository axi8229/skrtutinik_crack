package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes2.dex */
public class DefaultLoadErrorHandlingPolicy implements LoadErrorHandlingPolicy {
    private final int minimumLoadableRetryCount;

    public DefaultLoadErrorHandlingPolicy() {
        this(-1);
    }

    public DefaultLoadErrorHandlingPolicy(int minimumLoadableRetryCount) {
        this.minimumLoadableRetryCount = minimumLoadableRetryCount;
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public long getBlacklistDurationMsFor(int dataType, long loadDurationMs, IOException exception, int errorCount) {
        if (!(exception instanceof HttpDataSource.InvalidResponseCodeException)) {
            return -9223372036854775807L;
        }
        int i = ((HttpDataSource.InvalidResponseCodeException) exception).responseCode;
        return (i == 404 || i == 410 || i == 416) ? 60000L : -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public long getRetryDelayMsFor(int dataType, long loadDurationMs, IOException exception, int errorCount) {
        if ((exception instanceof ParserException) || (exception instanceof FileNotFoundException) || (exception instanceof Loader.UnexpectedLoaderException)) {
            return -9223372036854775807L;
        }
        return Math.min((errorCount - 1) * 1000, 5000);
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public int getMinimumLoadableRetryCount(int dataType) {
        int i = this.minimumLoadableRetryCount;
        return i == -1 ? dataType == 7 ? 6 : 3 : i;
    }
}
