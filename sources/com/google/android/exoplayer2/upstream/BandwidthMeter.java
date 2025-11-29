package com.google.android.exoplayer2.upstream;

import android.os.Handler;

/* loaded from: classes2.dex */
public interface BandwidthMeter {

    public interface EventListener {
        void onBandwidthSample(int elapsedMs, long bytesTransferred, long bitrateEstimate);
    }

    void addEventListener(Handler eventHandler, EventListener eventListener);

    long getBitrateEstimate();

    TransferListener getTransferListener();

    void removeEventListener(EventListener eventListener);
}
