package androidx.paging;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: AsyncPagingDataDiffer.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"androidx/paging/AsyncPagingDataDiffer$LoadStateListenerRunnable$1", "Ljava/lang/Runnable;", "", "run", "()V", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/paging/CombinedLoadStates;", "loadState", "Ljava/util/concurrent/atomic/AtomicReference;", "getLoadState", "()Ljava/util/concurrent/atomic/AtomicReference;", "setLoadState", "(Ljava/util/concurrent/atomic/AtomicReference;)V", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AsyncPagingDataDiffer$LoadStateListenerRunnable$1 implements Runnable {
    private AtomicReference<CombinedLoadStates> loadState = new AtomicReference<>(null);
    final /* synthetic */ AsyncPagingDataDiffer<T> this$0;

    AsyncPagingDataDiffer$LoadStateListenerRunnable$1(AsyncPagingDataDiffer<T> asyncPagingDataDiffer) {
        this.this$0 = asyncPagingDataDiffer;
    }

    public final AtomicReference<CombinedLoadStates> getLoadState() {
        return this.loadState;
    }

    @Override // java.lang.Runnable
    public void run() {
        CombinedLoadStates combinedLoadStates = this.loadState.get();
        if (combinedLoadStates != null) {
            Iterator it = ((AsyncPagingDataDiffer) this.this$0).childLoadStateListeners.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(combinedLoadStates);
            }
        }
    }
}
