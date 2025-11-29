package androidx.camera.core.impl;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface Observable<T> {

    public interface Observer<T> {
        void onError(Throwable th);

        void onNewData(T t);
    }

    void addObserver(Executor executor, Observer<? super T> observer);

    void removeObserver(Observer<? super T> observer);
}
