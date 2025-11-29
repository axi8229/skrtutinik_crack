package kotlinx.coroutines;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: CancellableContinuation.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002J9\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H'¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0015\u001a\u00020\b2\u0018\u0010\u0014\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0018\u001a\u00020\b*\u00020\u00172\u0006\u0010\u0003\u001a\u00028\u0000H'¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00028\u00002\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H'¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/CancellableContinuation;", "T", "Lkotlin/coroutines/Continuation;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "idempotent", "Lkotlin/Function1;", "", "", "onCancellation", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "token", "completeResume", "(Ljava/lang/Object;)V", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "isActive", "()Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CancellableContinuation<T> extends Continuation<T> {
    boolean cancel(Throwable cause);

    void completeResume(Object token);

    void invokeOnCancellation(Function1<? super Throwable, Unit> handler);

    boolean isActive();

    void resume(T value, Function1<? super Throwable, Unit> onCancellation);

    void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, T t);

    Object tryResume(T value, Object idempotent, Function1<? super Throwable, Unit> onCancellation);

    /* compiled from: CancellableContinuation.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean cancel$default(CancellableContinuation cancellableContinuation, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                th = null;
            }
            return cancellableContinuation.cancel(th);
        }
    }
}
