package coil.request;

import androidx.lifecycle.DefaultLifecycleObserver;
import kotlin.Metadata;

/* compiled from: RequestDelegate.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0006\u0010\u0004\u0082\u0001\u0002\u0007\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcoil/request/RequestDelegate;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "", "assertActive", "()V", "start", "complete", "Lcoil/request/BaseRequestDelegate;", "Lcoil/request/ViewTargetRequestDelegate;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface RequestDelegate extends DefaultLifecycleObserver {
    default void assertActive() {
    }

    default void complete() {
    }

    default void start() {
    }
}
