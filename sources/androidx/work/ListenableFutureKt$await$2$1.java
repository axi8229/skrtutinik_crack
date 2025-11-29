package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: ListenableFuture.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "R", "run"}, k = 3, mv = {1, 8, 0}, xi = 176)
/* loaded from: classes.dex */
public final class ListenableFutureKt$await$2$1 implements Runnable {
    final /* synthetic */ CancellableContinuation<Object> $cancellableContinuation;
    final /* synthetic */ ListenableFuture<Object> $this_await;

    public ListenableFutureKt$await$2$1(CancellableContinuation<Object> cancellableContinuation, ListenableFuture<Object> listenableFuture) {
        this.$cancellableContinuation = cancellableContinuation;
        this.$this_await = listenableFuture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            CancellableContinuation<Object> cancellableContinuation = this.$cancellableContinuation;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m2628constructorimpl(this.$this_await.get()));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                cause = th;
            }
            if (th instanceof CancellationException) {
                this.$cancellableContinuation.cancel(cause);
                return;
            }
            CancellableContinuation<Object> cancellableContinuation2 = this.$cancellableContinuation;
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m2628constructorimpl(ResultKt.createFailure(cause)));
        }
    }
}
