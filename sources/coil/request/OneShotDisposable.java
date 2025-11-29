package coil.request;

import kotlin.Metadata;
import kotlinx.coroutines.Deferred;

/* compiled from: Disposable.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcoil/request/OneShotDisposable;", "Lcoil/request/Disposable;", "Lkotlinx/coroutines/Deferred;", "Lcoil/request/ImageResult;", "job", "<init>", "(Lkotlinx/coroutines/Deferred;)V", "Lkotlinx/coroutines/Deferred;", "getJob", "()Lkotlinx/coroutines/Deferred;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OneShotDisposable implements Disposable {
    private final Deferred<ImageResult> job;

    /* JADX WARN: Multi-variable type inference failed */
    public OneShotDisposable(Deferred<? extends ImageResult> deferred) {
        this.job = deferred;
    }
}
