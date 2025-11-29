package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.WindowManager;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes2.dex */
public final class VideoFrameReleaseTimeHelper {
    private long adjustedLastFrameTimeNs;
    private final DefaultDisplayListener displayListener;
    private long frameCount;
    private boolean haveSync;
    private long lastFramePresentationTimeUs;
    private long pendingAdjustedFrameTimeNs;
    private long syncFramePresentationTimeNs;
    private long syncUnadjustedReleaseTimeNs;
    private long vsyncDurationNs;
    private long vsyncOffsetNs;
    private final VSyncSampler vsyncSampler;
    private final WindowManager windowManager;

    public VideoFrameReleaseTimeHelper(Context context) {
        if (context != null) {
            context = context.getApplicationContext();
            this.windowManager = (WindowManager) context.getSystemService("window");
        } else {
            this.windowManager = null;
        }
        if (this.windowManager != null) {
            this.displayListener = Util.SDK_INT >= 17 ? maybeBuildDefaultDisplayListenerV17(context) : null;
            this.vsyncSampler = VSyncSampler.getInstance();
        } else {
            this.displayListener = null;
            this.vsyncSampler = null;
        }
        this.vsyncDurationNs = -9223372036854775807L;
        this.vsyncOffsetNs = -9223372036854775807L;
    }

    @TargetApi(17)
    public void enable() {
        this.haveSync = false;
        if (this.windowManager != null) {
            this.vsyncSampler.addObserver();
            DefaultDisplayListener defaultDisplayListener = this.displayListener;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.register();
            }
            updateDefaultDisplayRefreshRateParams();
        }
    }

    @TargetApi(17)
    public void disable() {
        if (this.windowManager != null) {
            DefaultDisplayListener defaultDisplayListener = this.displayListener;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.unregister();
            }
            this.vsyncSampler.removeObserver();
        }
    }

    public long adjustReleaseTime(long framePresentationTimeUs, long unadjustedReleaseTimeNs) {
        long j;
        long j2;
        long j3 = 1000 * framePresentationTimeUs;
        if (this.haveSync) {
            if (framePresentationTimeUs != this.lastFramePresentationTimeUs) {
                this.frameCount++;
                this.adjustedLastFrameTimeNs = this.pendingAdjustedFrameTimeNs;
            }
            long j4 = this.frameCount;
            if (j4 >= 6) {
                j2 = this.adjustedLastFrameTimeNs + ((j3 - this.syncFramePresentationTimeNs) / j4);
                if (isDriftTooLarge(j2, unadjustedReleaseTimeNs)) {
                    this.haveSync = false;
                } else {
                    j = (this.syncUnadjustedReleaseTimeNs + j2) - this.syncFramePresentationTimeNs;
                }
            } else if (isDriftTooLarge(j3, unadjustedReleaseTimeNs)) {
                this.haveSync = false;
            }
            j = unadjustedReleaseTimeNs;
            j2 = j3;
        } else {
            j = unadjustedReleaseTimeNs;
            j2 = j3;
        }
        if (!this.haveSync) {
            this.syncFramePresentationTimeNs = j3;
            this.syncUnadjustedReleaseTimeNs = unadjustedReleaseTimeNs;
            this.frameCount = 0L;
            this.haveSync = true;
        }
        this.lastFramePresentationTimeUs = framePresentationTimeUs;
        this.pendingAdjustedFrameTimeNs = j2;
        VSyncSampler vSyncSampler = this.vsyncSampler;
        if (vSyncSampler == null || this.vsyncDurationNs == -9223372036854775807L) {
            return j;
        }
        long j5 = vSyncSampler.sampledVsyncTimeNs;
        return j5 == -9223372036854775807L ? j : closestVsync(j, j5, this.vsyncDurationNs) - this.vsyncOffsetNs;
    }

    private DefaultDisplayListener maybeBuildDefaultDisplayListenerV17(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new DefaultDisplayListener(displayManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDefaultDisplayRefreshRateParams() {
        if (this.windowManager.getDefaultDisplay() != null) {
            long refreshRate = (long) (1.0E9d / r0.getRefreshRate());
            this.vsyncDurationNs = refreshRate;
            this.vsyncOffsetNs = (refreshRate * 80) / 100;
        }
    }

    private boolean isDriftTooLarge(long frameTimeNs, long releaseTimeNs) {
        return Math.abs((releaseTimeNs - this.syncUnadjustedReleaseTimeNs) - (frameTimeNs - this.syncFramePresentationTimeNs)) > 20000000;
    }

    private static long closestVsync(long releaseTime, long sampledVsyncTime, long vsyncDuration) {
        long j;
        long j2 = sampledVsyncTime + (((releaseTime - sampledVsyncTime) / vsyncDuration) * vsyncDuration);
        if (releaseTime <= j2) {
            j = j2 - vsyncDuration;
        } else {
            j2 = vsyncDuration + j2;
            j = j2;
        }
        return j2 - releaseTime < releaseTime - j ? j2 : j;
    }

    private final class DefaultDisplayListener implements DisplayManager.DisplayListener {
        private final DisplayManager displayManager;

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int displayId) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int displayId) {
        }

        public DefaultDisplayListener(DisplayManager displayManager) {
            this.displayManager = displayManager;
        }

        public void register() {
            this.displayManager.registerDisplayListener(this, null);
        }

        public void unregister() {
            this.displayManager.unregisterDisplayListener(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int displayId) {
            if (displayId == 0) {
                VideoFrameReleaseTimeHelper.this.updateDefaultDisplayRefreshRateParams();
            }
        }
    }

    private static final class VSyncSampler implements Choreographer.FrameCallback, Handler.Callback {
        private static final VSyncSampler INSTANCE = new VSyncSampler();
        private Choreographer choreographer;
        private final HandlerThread choreographerOwnerThread;
        private final Handler handler;
        private int observerCount;
        public volatile long sampledVsyncTimeNs = -9223372036854775807L;

        public static VSyncSampler getInstance() {
            return INSTANCE;
        }

        private VSyncSampler() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.choreographerOwnerThread = handlerThread;
            handlerThread.start();
            Handler handlerCreateHandler = Util.createHandler(handlerThread.getLooper(), this);
            this.handler = handlerCreateHandler;
            handlerCreateHandler.sendEmptyMessage(0);
        }

        public void addObserver() {
            this.handler.sendEmptyMessage(1);
        }

        public void removeObserver() {
            this.handler.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long vsyncTimeNs) {
            this.sampledVsyncTimeNs = vsyncTimeNs;
            this.choreographer.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                createChoreographerInstanceInternal();
                return true;
            }
            if (i == 1) {
                addObserverInternal();
                return true;
            }
            if (i != 2) {
                return false;
            }
            removeObserverInternal();
            return true;
        }

        private void createChoreographerInstanceInternal() {
            this.choreographer = Choreographer.getInstance();
        }

        private void addObserverInternal() {
            int i = this.observerCount + 1;
            this.observerCount = i;
            if (i == 1) {
                this.choreographer.postFrameCallback(this);
            }
        }

        private void removeObserverInternal() {
            int i = this.observerCount - 1;
            this.observerCount = i;
            if (i == 0) {
                this.choreographer.removeFrameCallback(this);
                this.sampledVsyncTimeNs = -9223372036854775807L;
            }
        }
    }
}
