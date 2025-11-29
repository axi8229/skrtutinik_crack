package com.google.android.exoplayer2;

import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes2.dex */
public final class PlayerMessage {
    private Handler handler;
    private boolean isCanceled;
    private boolean isDelivered;
    private boolean isProcessed;
    private boolean isSent;
    private Object payload;
    private final Sender sender;
    private final Target target;
    private final Timeline timeline;
    private int type;
    private int windowIndex;
    private long positionMs = -9223372036854775807L;
    private boolean deleteAfterDelivery = true;

    public interface Sender {
        void sendMessage(PlayerMessage message);
    }

    public interface Target {
        void handleMessage(int messageType, Object payload) throws ExoPlaybackException;
    }

    public PlayerMessage(Sender sender, Target target, Timeline timeline, int defaultWindowIndex, Handler defaultHandler) {
        this.sender = sender;
        this.target = target;
        this.timeline = timeline;
        this.handler = defaultHandler;
        this.windowIndex = defaultWindowIndex;
    }

    public Timeline getTimeline() {
        return this.timeline;
    }

    public Target getTarget() {
        return this.target;
    }

    public PlayerMessage setType(int messageType) {
        Assertions.checkState(!this.isSent);
        this.type = messageType;
        return this;
    }

    public int getType() {
        return this.type;
    }

    public PlayerMessage setPayload(Object payload) {
        Assertions.checkState(!this.isSent);
        this.payload = payload;
        return this;
    }

    public Object getPayload() {
        return this.payload;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public long getPositionMs() {
        return this.positionMs;
    }

    public int getWindowIndex() {
        return this.windowIndex;
    }

    public boolean getDeleteAfterDelivery() {
        return this.deleteAfterDelivery;
    }

    public PlayerMessage send() {
        Assertions.checkState(!this.isSent);
        if (this.positionMs == -9223372036854775807L) {
            Assertions.checkArgument(this.deleteAfterDelivery);
        }
        this.isSent = true;
        this.sender.sendMessage(this);
        return this;
    }

    public synchronized boolean isCanceled() {
        return this.isCanceled;
    }

    public synchronized boolean blockUntilDelivered() throws InterruptedException {
        try {
            Assertions.checkState(this.isSent);
            Assertions.checkState(this.handler.getLooper().getThread() != Thread.currentThread());
            while (!this.isProcessed) {
                wait();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.isDelivered;
    }

    public synchronized void markAsProcessed(boolean isDelivered) {
        this.isDelivered = isDelivered | this.isDelivered;
        this.isProcessed = true;
        notifyAll();
    }
}
