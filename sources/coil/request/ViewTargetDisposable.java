package coil.request;

import android.view.View;
import kotlin.Metadata;
import kotlinx.coroutines.Deferred;

/* compiled from: Disposable.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\tR(\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcoil/request/ViewTargetDisposable;", "Lcoil/request/Disposable;", "Landroid/view/View;", "view", "Lkotlinx/coroutines/Deferred;", "Lcoil/request/ImageResult;", "job", "<init>", "(Landroid/view/View;Lkotlinx/coroutines/Deferred;)V", "Landroid/view/View;", "Lkotlinx/coroutines/Deferred;", "getJob", "()Lkotlinx/coroutines/Deferred;", "setJob", "(Lkotlinx/coroutines/Deferred;)V", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ViewTargetDisposable implements Disposable {
    private volatile Deferred<? extends ImageResult> job;
    private final View view;

    public ViewTargetDisposable(View view, Deferred<? extends ImageResult> deferred) {
        this.view = view;
        this.job = deferred;
    }

    public void setJob(Deferred<? extends ImageResult> deferred) {
        this.job = deferred;
    }
}
