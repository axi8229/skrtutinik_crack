package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import org.pjsip.pjsua2.pj_ssl_sock_proto;

/* loaded from: classes2.dex */
public class DefaultLoadControl implements LoadControl {
    private final DefaultAllocator allocator;
    private final long backBufferDurationUs;
    private final long bufferForPlaybackAfterRebufferUs;
    private final long bufferForPlaybackUs;
    private boolean isBuffering;
    private final long maxBufferUs;
    private final long minBufferUs;
    private final boolean prioritizeTimeOverSizeThresholds;
    private final boolean retainBackBufferFromKeyframe;
    private int targetBufferBytes;
    private final int targetBufferBytesOverwrite;

    public static final class Builder {
        private DefaultAllocator allocator;
        private boolean createDefaultLoadControlCalled;
        private int minBufferMs = 50000;
        private int maxBufferMs = 50000;
        private int bufferForPlaybackMs = 2500;
        private int bufferForPlaybackAfterRebufferMs = 5000;
        private int targetBufferBytes = -1;
        private boolean prioritizeTimeOverSizeThresholds = false;
        private int backBufferDurationMs = 0;
        private boolean retainBackBufferFromKeyframe = false;

        public Builder setBufferDurationsMs(int minBufferMs, int maxBufferMs, int bufferForPlaybackMs, int bufferForPlaybackAfterRebufferMs) {
            Assertions.checkState(!this.createDefaultLoadControlCalled);
            DefaultLoadControl.assertGreaterOrEqual(bufferForPlaybackMs, 0, "bufferForPlaybackMs", "0");
            DefaultLoadControl.assertGreaterOrEqual(bufferForPlaybackAfterRebufferMs, 0, "bufferForPlaybackAfterRebufferMs", "0");
            DefaultLoadControl.assertGreaterOrEqual(minBufferMs, bufferForPlaybackMs, "minBufferMs", "bufferForPlaybackMs");
            DefaultLoadControl.assertGreaterOrEqual(minBufferMs, bufferForPlaybackAfterRebufferMs, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            DefaultLoadControl.assertGreaterOrEqual(maxBufferMs, minBufferMs, "maxBufferMs", "minBufferMs");
            this.minBufferMs = minBufferMs;
            this.maxBufferMs = maxBufferMs;
            this.bufferForPlaybackMs = bufferForPlaybackMs;
            this.bufferForPlaybackAfterRebufferMs = bufferForPlaybackAfterRebufferMs;
            return this;
        }

        public Builder setBackBuffer(int backBufferDurationMs, boolean retainBackBufferFromKeyframe) {
            Assertions.checkState(!this.createDefaultLoadControlCalled);
            DefaultLoadControl.assertGreaterOrEqual(backBufferDurationMs, 0, "backBufferDurationMs", "0");
            this.backBufferDurationMs = backBufferDurationMs;
            this.retainBackBufferFromKeyframe = retainBackBufferFromKeyframe;
            return this;
        }

        public DefaultLoadControl createDefaultLoadControl() {
            Assertions.checkState(!this.createDefaultLoadControlCalled);
            this.createDefaultLoadControlCalled = true;
            if (this.allocator == null) {
                this.allocator = new DefaultAllocator(true, pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1);
            }
            return new DefaultLoadControl(this.allocator, this.minBufferMs, this.maxBufferMs, this.bufferForPlaybackMs, this.bufferForPlaybackAfterRebufferMs, this.targetBufferBytes, this.prioritizeTimeOverSizeThresholds, this.backBufferDurationMs, this.retainBackBufferFromKeyframe);
        }
    }

    public DefaultLoadControl() {
        this(new DefaultAllocator(true, pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1));
    }

    @Deprecated
    public DefaultLoadControl(DefaultAllocator allocator) {
        this(allocator, 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    protected DefaultLoadControl(DefaultAllocator allocator, int minBufferMs, int maxBufferMs, int bufferForPlaybackMs, int bufferForPlaybackAfterRebufferMs, int targetBufferBytes, boolean prioritizeTimeOverSizeThresholds, int backBufferDurationMs, boolean retainBackBufferFromKeyframe) {
        assertGreaterOrEqual(bufferForPlaybackMs, 0, "bufferForPlaybackMs", "0");
        assertGreaterOrEqual(bufferForPlaybackAfterRebufferMs, 0, "bufferForPlaybackAfterRebufferMs", "0");
        assertGreaterOrEqual(minBufferMs, bufferForPlaybackMs, "minBufferMs", "bufferForPlaybackMs");
        assertGreaterOrEqual(minBufferMs, bufferForPlaybackAfterRebufferMs, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        assertGreaterOrEqual(maxBufferMs, minBufferMs, "maxBufferMs", "minBufferMs");
        assertGreaterOrEqual(backBufferDurationMs, 0, "backBufferDurationMs", "0");
        this.allocator = allocator;
        this.minBufferUs = C.msToUs(minBufferMs);
        this.maxBufferUs = C.msToUs(maxBufferMs);
        this.bufferForPlaybackUs = C.msToUs(bufferForPlaybackMs);
        this.bufferForPlaybackAfterRebufferUs = C.msToUs(bufferForPlaybackAfterRebufferMs);
        this.targetBufferBytesOverwrite = targetBufferBytes;
        this.targetBufferBytes = targetBufferBytes == -1 ? 13107200 : targetBufferBytes;
        this.prioritizeTimeOverSizeThresholds = prioritizeTimeOverSizeThresholds;
        this.backBufferDurationUs = C.msToUs(backBufferDurationMs);
        this.retainBackBufferFromKeyframe = retainBackBufferFromKeyframe;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onPrepared() {
        reset(false);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onTracksSelected(Renderer[] renderers, TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
        int iCalculateTargetBufferBytes = this.targetBufferBytesOverwrite;
        if (iCalculateTargetBufferBytes == -1) {
            iCalculateTargetBufferBytes = calculateTargetBufferBytes(renderers, trackSelections);
        }
        this.targetBufferBytes = iCalculateTargetBufferBytes;
        this.allocator.setTargetBufferSize(iCalculateTargetBufferBytes);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onStopped() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onReleased() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public Allocator getAllocator() {
        return this.allocator;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public long getBackBufferDurationUs() {
        return this.backBufferDurationUs;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean retainBackBufferFromKeyframe() {
        return this.retainBackBufferFromKeyframe;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldContinueLoading(long bufferedDurationUs, float playbackSpeed) {
        boolean z = true;
        boolean z2 = this.allocator.getTotalBytesAllocated() >= this.targetBufferBytes;
        long jMin = this.minBufferUs;
        if (playbackSpeed > 1.0f) {
            jMin = Math.min(Util.getMediaDurationForPlayoutDuration(jMin, playbackSpeed), this.maxBufferUs);
        }
        if (bufferedDurationUs < Math.max(jMin, 500000L)) {
            if (!this.prioritizeTimeOverSizeThresholds && z2) {
                z = false;
            }
            this.isBuffering = z;
            if (!z && bufferedDurationUs < 500000) {
                Log.w("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (bufferedDurationUs >= this.maxBufferUs || z2) {
            this.isBuffering = false;
        }
        return this.isBuffering;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldStartPlayback(long bufferedDurationUs, float playbackSpeed, boolean rebuffering) {
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(bufferedDurationUs, playbackSpeed);
        long j = rebuffering ? this.bufferForPlaybackAfterRebufferUs : this.bufferForPlaybackUs;
        return j <= 0 || playoutDurationForMediaDuration >= j || (!this.prioritizeTimeOverSizeThresholds && this.allocator.getTotalBytesAllocated() >= this.targetBufferBytes);
    }

    protected int calculateTargetBufferBytes(Renderer[] renderers, TrackSelectionArray trackSelectionArray) {
        int defaultBufferSize = 0;
        for (int i = 0; i < renderers.length; i++) {
            if (trackSelectionArray.get(i) != null) {
                defaultBufferSize += getDefaultBufferSize(renderers[i].getTrackType());
            }
        }
        return Math.max(13107200, defaultBufferSize);
    }

    private void reset(boolean resetAllocator) {
        int i = this.targetBufferBytesOverwrite;
        if (i == -1) {
            i = 13107200;
        }
        this.targetBufferBytes = i;
        this.isBuffering = false;
        if (resetAllocator) {
            this.allocator.reset();
        }
    }

    private static int getDefaultBufferSize(int trackType) {
        switch (trackType) {
            case 0:
                return 144310272;
            case 1:
                return 13107200;
            case 2:
                return 131072000;
            case 3:
            case 4:
            case 5:
                return 131072;
            case 6:
                return 0;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void assertGreaterOrEqual(int value1, int value2, String name1, String name2) {
        Assertions.checkArgument(value1 >= value2, name1 + " cannot be less than " + name2);
    }
}
