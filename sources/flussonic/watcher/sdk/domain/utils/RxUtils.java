package flussonic.watcher.sdk.domain.utils;

import io.reactivex.disposables.Disposable;

/* loaded from: classes3.dex */
public class RxUtils {
    public static void dispose(Disposable disposable) {
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        disposable.dispose();
    }
}
