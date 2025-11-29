package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;

/* loaded from: classes2.dex */
public final class DefaultHttpDataSourceFactory extends HttpDataSource.BaseFactory {
    private final boolean allowCrossProtocolRedirects;
    private final int connectTimeoutMillis;
    private final TransferListener listener;
    private final int readTimeoutMillis;
    private final String userAgent;

    public DefaultHttpDataSourceFactory(String userAgent) {
        this(userAgent, null);
    }

    public DefaultHttpDataSourceFactory(String userAgent, TransferListener listener) {
        this(userAgent, listener, JosStatusCodes.RTN_CODE_COMMON_ERROR, JosStatusCodes.RTN_CODE_COMMON_ERROR, false);
    }

    public DefaultHttpDataSourceFactory(String userAgent, TransferListener listener, int connectTimeoutMillis, int readTimeoutMillis, boolean allowCrossProtocolRedirects) {
        this.userAgent = Assertions.checkNotEmpty(userAgent);
        this.listener = listener;
        this.connectTimeoutMillis = connectTimeoutMillis;
        this.readTimeoutMillis = readTimeoutMillis;
        this.allowCrossProtocolRedirects = allowCrossProtocolRedirects;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.BaseFactory
    public DefaultHttpDataSource createDataSourceInternal(HttpDataSource.RequestProperties defaultRequestProperties) {
        DefaultHttpDataSource defaultHttpDataSource = new DefaultHttpDataSource(this.userAgent, this.connectTimeoutMillis, this.readTimeoutMillis, this.allowCrossProtocolRedirects, defaultRequestProperties);
        TransferListener transferListener = this.listener;
        if (transferListener != null) {
            defaultHttpDataSource.addTransferListener(transferListener);
        }
        return defaultHttpDataSource;
    }
}
