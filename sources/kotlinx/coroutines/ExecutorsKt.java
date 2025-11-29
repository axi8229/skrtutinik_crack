package kotlinx.coroutines;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* compiled from: Executors.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003*\f\b\u0007\u0010\u0006\"\u00020\u00052\u00020\u0005¨\u0006\u0007"}, d2 = {"Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/CoroutineDispatcher;", RemoteMessageConst.FROM, "(Ljava/util/concurrent/Executor;)Lkotlinx/coroutines/CoroutineDispatcher;", "asCoroutineDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "CloseableCoroutineDispatcher", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExecutorsKt {
    public static final CoroutineDispatcher from(Executor executor) {
        CoroutineDispatcher coroutineDispatcher;
        DispatcherExecutor dispatcherExecutor = executor instanceof DispatcherExecutor ? (DispatcherExecutor) executor : null;
        return (dispatcherExecutor == null || (coroutineDispatcher = dispatcherExecutor.dispatcher) == null) ? new ExecutorCoroutineDispatcherImpl(executor) : coroutineDispatcher;
    }
}
