package androidx.paging;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ContextKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: AsyncPagingDataDiffer.kt */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007*\u0001N\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B3\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001d\u001a\u00020\u000e2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000e0\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u00020\u000e2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000e0\u001a¢\u0006\u0004\b\u001f\u0010\u001eJ#\u0010!\u001a\u00020\u000e2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000e0\u001aH\u0000¢\u0006\u0004\b \u0010\u001eR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\"R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010#R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010$R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010$R \u0010'\u001a\b\u0012\u0004\u0012\u00020&0%8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R \u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R \u00102\u001a\b\u0012\u0004\u0012\u00028\u0000018\u0000X\u0080\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001b098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000e098\u0006¢\u0006\f\n\u0004\b>\u0010;\u001a\u0004\b?\u0010=R(\u0010@\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001a0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u00100R&\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000e0\u001a0A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR&\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000e0\u001a8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0011\u0010S\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\bQ\u0010R¨\u0006T"}, d2 = {"Landroidx/paging/AsyncPagingDataDiffer;", "", "T", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "updateCallback", "Lkotlin/coroutines/CoroutineContext;", "mainDispatcher", "workerDispatcher", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Landroidx/recyclerview/widget/ListUpdateCallback;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;)V", "Landroidx/paging/PagingData;", "pagingData", "", "submitData", "(Landroidx/paging/PagingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retry", "()V", "", "index", "getItem", "(I)Ljava/lang/Object;", "Landroidx/paging/ItemSnapshotList;", "snapshot", "()Landroidx/paging/ItemSnapshotList;", "Lkotlin/Function1;", "Landroidx/paging/CombinedLoadStates;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addLoadStateListener", "(Lkotlin/jvm/functions/Function1;)V", "removeLoadStateListener", "addLoadStateListenerInternal$paging_runtime_release", "addLoadStateListenerInternal", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "inGetItem", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getInGetItem$paging_runtime_release", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "lastAccessedIndex", "I", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/paging/PlaceholderPaddedList;", "previousPresenter", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/paging/PagingDataPresenter;", "presenter", "Landroidx/paging/PagingDataPresenter;", "getPresenter$paging_runtime_release", "()Landroidx/paging/PagingDataPresenter;", "Ljava/util/concurrent/atomic/AtomicInteger;", "submitDataId", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lkotlinx/coroutines/flow/Flow;", "loadStateFlow", "Lkotlinx/coroutines/flow/Flow;", "getLoadStateFlow", "()Lkotlinx/coroutines/flow/Flow;", "onPagesUpdatedFlow", "getOnPagesUpdatedFlow", "parentLoadStateListener", "Ljava/util/concurrent/CopyOnWriteArrayList;", "childLoadStateListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "internalLoadStateListener", "Lkotlin/jvm/functions/Function1;", "getInternalLoadStateListener$paging_runtime_release", "()Lkotlin/jvm/functions/Function1;", "Landroid/os/Handler;", "LoadStateListenerHandler$delegate", "Lkotlin/Lazy;", "getLoadStateListenerHandler", "()Landroid/os/Handler;", "LoadStateListenerHandler", "androidx/paging/AsyncPagingDataDiffer$LoadStateListenerRunnable$1", "LoadStateListenerRunnable", "Landroidx/paging/AsyncPagingDataDiffer$LoadStateListenerRunnable$1;", "getItemCount", "()I", "itemCount", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AsyncPagingDataDiffer<T> {

    /* renamed from: LoadStateListenerHandler$delegate, reason: from kotlin metadata */
    private final Lazy LoadStateListenerHandler;
    private final AsyncPagingDataDiffer$LoadStateListenerRunnable$1 LoadStateListenerRunnable;
    private final CopyOnWriteArrayList<Function1<CombinedLoadStates, Unit>> childLoadStateListeners;
    private final DiffUtil.ItemCallback<T> diffCallback;
    private final MutableStateFlow<Boolean> inGetItem;
    private final Function1<CombinedLoadStates, Unit> internalLoadStateListener;
    private int lastAccessedIndex;
    private final Flow<CombinedLoadStates> loadStateFlow;
    private final CoroutineContext mainDispatcher;
    private final Flow<Unit> onPagesUpdatedFlow;
    private final AtomicReference<Function1<CombinedLoadStates, Unit>> parentLoadStateListener;
    private final PagingDataPresenter<T> presenter;
    private final AtomicReference<PlaceholderPaddedList<T>> previousPresenter;
    private final AtomicInteger submitDataId;
    private final ListUpdateCallback updateCallback;
    private final CoroutineContext workerDispatcher;

    public AsyncPagingDataDiffer(DiffUtil.ItemCallback<T> diffCallback, ListUpdateCallback updateCallback, CoroutineContext mainDispatcher, CoroutineContext workerDispatcher) {
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(updateCallback, "updateCallback");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(workerDispatcher, "workerDispatcher");
        this.diffCallback = diffCallback;
        this.updateCallback = updateCallback;
        this.mainDispatcher = mainDispatcher;
        this.workerDispatcher = workerDispatcher;
        this.inGetItem = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.previousPresenter = new AtomicReference<>(null);
        AsyncPagingDataDiffer$presenter$1 asyncPagingDataDiffer$presenter$1 = new AsyncPagingDataDiffer$presenter$1(this, mainDispatcher);
        this.presenter = asyncPagingDataDiffer$presenter$1;
        this.submitDataId = new AtomicInteger(0);
        this.loadStateFlow = FlowKt.flowOn(FlowKt.flow(new AsyncPagingDataDiffer$special$$inlined$transform$1(FlowKt__ContextKt.buffer$default(FlowKt.filterNotNull(asyncPagingDataDiffer$presenter$1.getLoadStateFlow()), -1, null, 2, null), null, this)), Dispatchers.getMain());
        this.onPagesUpdatedFlow = asyncPagingDataDiffer$presenter$1.getOnPagesUpdatedFlow();
        this.parentLoadStateListener = new AtomicReference<>(null);
        this.childLoadStateListeners = new CopyOnWriteArrayList<>();
        this.internalLoadStateListener = new Function1<CombinedLoadStates, Unit>(this) { // from class: androidx.paging.AsyncPagingDataDiffer$internalLoadStateListener$1
            final /* synthetic */ AsyncPagingDataDiffer<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CombinedLoadStates combinedLoadStates) {
                invoke2(combinedLoadStates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CombinedLoadStates loadState) {
                Intrinsics.checkNotNullParameter(loadState, "loadState");
                if (this.this$0.getInGetItem$paging_runtime_release().getValue().booleanValue()) {
                    Handler loadStateListenerHandler = this.this$0.getLoadStateListenerHandler();
                    AsyncPagingDataDiffer<T> asyncPagingDataDiffer = this.this$0;
                    loadStateListenerHandler.removeCallbacks(((AsyncPagingDataDiffer) asyncPagingDataDiffer).LoadStateListenerRunnable);
                    ((AsyncPagingDataDiffer) asyncPagingDataDiffer).LoadStateListenerRunnable.getLoadState().set(loadState);
                    loadStateListenerHandler.post(((AsyncPagingDataDiffer) asyncPagingDataDiffer).LoadStateListenerRunnable);
                    return;
                }
                Iterator it = ((AsyncPagingDataDiffer) this.this$0).childLoadStateListeners.iterator();
                while (it.hasNext()) {
                    ((Function1) it.next()).invoke(loadState);
                }
            }
        };
        this.LoadStateListenerHandler = LazyKt.lazy(new Function0<Handler>() { // from class: androidx.paging.AsyncPagingDataDiffer$LoadStateListenerHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.LoadStateListenerRunnable = new AsyncPagingDataDiffer$LoadStateListenerRunnable$1(this);
    }

    public final MutableStateFlow<Boolean> getInGetItem$paging_runtime_release() {
        return this.inGetItem;
    }

    public final Object submitData(PagingData<T> pagingData, Continuation<? super Unit> continuation) {
        this.submitDataId.incrementAndGet();
        Object objCollectFrom = this.presenter.collectFrom(pagingData, continuation);
        return objCollectFrom == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollectFrom : Unit.INSTANCE;
    }

    public final void retry() {
        this.presenter.retry();
    }

    public final T getItem(int index) {
        Boolean value;
        Boolean value2;
        Boolean value3;
        try {
            MutableStateFlow<Boolean> mutableStateFlow = this.inGetItem;
            do {
                value2 = mutableStateFlow.getValue();
                value2.booleanValue();
            } while (!mutableStateFlow.compareAndSet(value2, Boolean.TRUE));
            this.lastAccessedIndex = index;
            PlaceholderPaddedList<T> placeholderPaddedList = this.previousPresenter.get();
            T t = placeholderPaddedList != null ? (T) AsyncPagingDataDifferKt.get(placeholderPaddedList, index) : this.presenter.get(index);
            MutableStateFlow<Boolean> mutableStateFlow2 = this.inGetItem;
            do {
                value3 = mutableStateFlow2.getValue();
                value3.booleanValue();
            } while (!mutableStateFlow2.compareAndSet(value3, Boolean.FALSE));
            return t;
        } catch (Throwable th) {
            MutableStateFlow<Boolean> mutableStateFlow3 = this.inGetItem;
            do {
                value = mutableStateFlow3.getValue();
                value.booleanValue();
            } while (!mutableStateFlow3.compareAndSet(value, Boolean.FALSE));
            throw th;
        }
    }

    public final ItemSnapshotList<T> snapshot() {
        ItemSnapshotList<T> itemSnapshotListSnapshot;
        PlaceholderPaddedList<T> placeholderPaddedList = this.previousPresenter.get();
        return (placeholderPaddedList == null || (itemSnapshotListSnapshot = AsyncPagingDataDifferKt.snapshot(placeholderPaddedList)) == null) ? this.presenter.snapshot() : itemSnapshotListSnapshot;
    }

    public final int getItemCount() {
        PlaceholderPaddedList<T> placeholderPaddedList = this.previousPresenter.get();
        return placeholderPaddedList != null ? placeholderPaddedList.getSize() : this.presenter.getSize();
    }

    public final Flow<CombinedLoadStates> getLoadStateFlow() {
        return this.loadStateFlow;
    }

    public final Flow<Unit> getOnPagesUpdatedFlow() {
        return this.onPagesUpdatedFlow;
    }

    public final void addLoadStateListener(Function1<? super CombinedLoadStates, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.parentLoadStateListener.get() == null) {
            addLoadStateListenerInternal$paging_runtime_release(this.internalLoadStateListener);
        }
        this.childLoadStateListeners.add(listener);
    }

    public final void removeLoadStateListener(Function1<? super CombinedLoadStates, Unit> listener) {
        Function1<CombinedLoadStates, Unit> function1;
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.childLoadStateListeners.remove(listener);
        if (!this.childLoadStateListeners.isEmpty() || (function1 = this.parentLoadStateListener.get()) == null) {
            return;
        }
        this.presenter.removeLoadStateListener(function1);
    }

    public final void addLoadStateListenerInternal$paging_runtime_release(Function1<? super CombinedLoadStates, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.parentLoadStateListener.set(listener);
        this.presenter.addLoadStateListener(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler getLoadStateListenerHandler() {
        return (Handler) this.LoadStateListenerHandler.getValue();
    }
}
