package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: WithLifecycleState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"androidx/lifecycle/WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements LifecycleEventObserver {
    final /* synthetic */ Function0<Object> $block;
    final /* synthetic */ CancellableContinuation<Object> $co;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked;

    WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1(Lifecycle.State state, Lifecycle lifecycle, CancellableContinuation<Object> cancellableContinuation, Function0<Object> function0) {
        this.$state = state;
        this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
        this.$co = cancellableContinuation;
        this.$block = function0;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Object objM2628constructorimpl;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.INSTANCE.upTo(this.$state)) {
            this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this);
            CancellableContinuation<Object> cancellableContinuation = this.$co;
            Function0<Object> function0 = this.$block;
            try {
                Result.Companion companion = Result.INSTANCE;
                objM2628constructorimpl = Result.m2628constructorimpl(function0.invoke());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM2628constructorimpl = Result.m2628constructorimpl(ResultKt.createFailure(th));
            }
            cancellableContinuation.resumeWith(objM2628constructorimpl);
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this);
            CancellableContinuation<Object> cancellableContinuation2 = this.$co;
            Result.Companion companion3 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m2628constructorimpl(ResultKt.createFailure(new LifecycleDestroyedException())));
        }
    }
}
