package com.google.android.exoplayer2.util;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class EventDispatcher<T> {
    private final CopyOnWriteArrayList<HandlerAndListener<T>> listeners = new CopyOnWriteArrayList<>();

    public interface Event<T> {
        void sendTo(T listener);
    }

    public void addListener(Handler handler, T eventListener) {
        Assertions.checkArgument((handler == null || eventListener == null) ? false : true);
        removeListener(eventListener);
        this.listeners.add(new HandlerAndListener<>(handler, eventListener));
    }

    public void removeListener(T eventListener) {
        Iterator<HandlerAndListener<T>> it = this.listeners.iterator();
        while (it.hasNext()) {
            HandlerAndListener<T> next = it.next();
            if (((HandlerAndListener) next).listener == eventListener) {
                next.release();
                this.listeners.remove(next);
            }
        }
    }

    public void dispatch(Event<T> event) {
        Iterator<HandlerAndListener<T>> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().dispatch(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class HandlerAndListener<T> {
        private final Handler handler;
        private final T listener;
        private boolean released;

        public HandlerAndListener(Handler handler, T eventListener) {
            this.handler = handler;
            this.listener = eventListener;
        }

        public void release() {
            this.released = true;
        }

        public void dispatch(final Event<T> event) {
            this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.util.EventDispatcher$HandlerAndListener$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$dispatch$0(event);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$dispatch$0(final Event event) {
            if (this.released) {
                return;
            }
            event.sendTo(this.listener);
        }
    }
}
