package com.google.android.exoplayer2.upstream;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class DataSourceException extends IOException {
    public final int reason;

    public DataSourceException(int reason) {
        this.reason = reason;
    }
}
