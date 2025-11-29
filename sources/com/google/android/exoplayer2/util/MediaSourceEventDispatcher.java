package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.source.MediaSource;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class MediaSourceEventDispatcher {
    protected final CopyOnWriteMultiset<ListenerInfo> listenerInfos;
    public final MediaSource.MediaPeriodId mediaPeriodId;
    protected final long mediaTimeOffsetMs;
    public final int windowIndex;

    public interface EventWithPeriodId<T> {
        void sendTo(T listener, int windowIndex, MediaSource.MediaPeriodId mediaPeriodId);
    }

    public MediaSourceEventDispatcher() {
        this(new CopyOnWriteMultiset(), 0, null, 0L);
    }

    protected MediaSourceEventDispatcher(CopyOnWriteMultiset<ListenerInfo> listenerInfos, int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, long mediaTimeOffsetMs) {
        this.listenerInfos = listenerInfos;
        this.windowIndex = windowIndex;
        this.mediaPeriodId = mediaPeriodId;
        this.mediaTimeOffsetMs = mediaTimeOffsetMs;
    }

    public <T> void addEventListener(Handler handler, T eventListener, Class<T> listenerClass) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(eventListener);
        this.listenerInfos.add(new ListenerInfo(handler, eventListener, listenerClass));
    }

    public <T> void removeEventListener(T eventListener, Class<T> listenerClass) {
        Iterator<ListenerInfo> it = this.listenerInfos.iterator();
        while (it.hasNext()) {
            ListenerInfo next = it.next();
            if (next.listener == eventListener && next.listenerClass.equals(listenerClass)) {
                this.listenerInfos.remove(next);
                return;
            }
        }
    }

    public <T> void dispatch(final EventWithPeriodId<T> event, Class<T> listenerClass) {
        for (final ListenerInfo listenerInfo : this.listenerInfos.elementSet()) {
            if (listenerInfo.listenerClass.equals(listenerClass)) {
                postOrRun(listenerInfo.handler, new Runnable() { // from class: com.google.android.exoplayer2.util.MediaSourceEventDispatcher$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$dispatch$0(event, listenerInfo);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dispatch$0(final EventWithPeriodId event, final ListenerInfo listenerInfo) {
        event.sendTo(listenerInfo.listener, this.windowIndex, this.mediaPeriodId);
    }

    private static void postOrRun(Handler handler, Runnable runnable) {
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public static long adjustMediaTime(long mediaTimeUs, long mediaTimeOffsetMs) {
        long jUsToMs = C.usToMs(mediaTimeUs);
        if (jUsToMs == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return mediaTimeOffsetMs + jUsToMs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final class ListenerInfo {
        public final Handler handler;
        public final Object listener;
        public final Class<?> listenerClass;

        public ListenerInfo(Handler handler, Object listener, Class<?> listenerClass) {
            this.handler = handler;
            this.listener = listener;
            this.listenerClass = listenerClass;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof ListenerInfo)) {
                return false;
            }
            ListenerInfo listenerInfo = (ListenerInfo) o;
            return this.listener.equals(listenerInfo.listener) && this.listenerClass.equals(listenerInfo.listenerClass);
        }

        public int hashCode() {
            return (this.listener.hashCode() * 31) + (this.listenerClass.hashCode() * 31);
        }
    }
}
