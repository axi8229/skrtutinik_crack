package androidx.lifecycle.viewmodel.internal;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: CloseableCoroutineScope.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/lifecycle/viewmodel/internal/CloseableCoroutineScope;", "createViewModelScope", "()Landroidx/lifecycle/viewmodel/internal/CloseableCoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "asCloseable", "(Lkotlinx/coroutines/CoroutineScope;)Landroidx/lifecycle/viewmodel/internal/CloseableCoroutineScope;", "lifecycle-viewmodel_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CloseableCoroutineScopeKt {
    public static final CloseableCoroutineScope createViewModelScope() {
        CoroutineContext immediate;
        try {
            immediate = Dispatchers.getMain().getImmediate();
        } catch (IllegalStateException unused) {
            immediate = EmptyCoroutineContext.INSTANCE;
        } catch (NotImplementedError unused2) {
            immediate = EmptyCoroutineContext.INSTANCE;
        }
        return new CloseableCoroutineScope(immediate.plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static final CloseableCoroutineScope asCloseable(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        return new CloseableCoroutineScope(coroutineScope);
    }
}
