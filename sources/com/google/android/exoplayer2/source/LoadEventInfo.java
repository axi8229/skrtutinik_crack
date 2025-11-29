package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class LoadEventInfo {
    private static final AtomicLong idSource = new AtomicLong();
    public final long bytesLoaded;
    public final DataSpec dataSpec;
    public final long elapsedRealtimeMs;
    public final long loadDurationMs;
    public final Map<String, List<String>> responseHeaders;
    public final Uri uri;

    public LoadEventInfo(DataSpec dataSpec, Uri uri, Map<String, List<String>> responseHeaders, long elapsedRealtimeMs, long loadDurationMs, long bytesLoaded) {
        this.dataSpec = dataSpec;
        this.uri = uri;
        this.responseHeaders = responseHeaders;
        this.elapsedRealtimeMs = elapsedRealtimeMs;
        this.loadDurationMs = loadDurationMs;
        this.bytesLoaded = bytesLoaded;
    }
}
