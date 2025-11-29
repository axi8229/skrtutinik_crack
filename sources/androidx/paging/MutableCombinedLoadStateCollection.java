package androidx.paging;

import androidx.paging.LoadState;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: MutableCombinedLoadStateCollection.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ+\u0010\u0006\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0006\u0010\u000eJ1\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u001eJ!\u0010 \u001a\u00020\u00072\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b \u0010\tJ!\u0010!\u001a\u00020\u00072\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b!\u0010\tR<\u0010$\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00040\"j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0004`#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001f\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u0006."}, d2 = {"Landroidx/paging/MutableCombinedLoadStateCollection;", "", "<init>", "()V", "Lkotlin/Function1;", "Landroidx/paging/CombinedLoadStates;", "computeNewState", "", "dispatchNewState", "(Lkotlin/jvm/functions/Function1;)V", "previousState", "Landroidx/paging/LoadStates;", "newSource", "newRemote", "(Landroidx/paging/CombinedLoadStates;Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)Landroidx/paging/CombinedLoadStates;", "Landroidx/paging/LoadState;", "sourceRefreshState", "sourceState", "remoteState", "computeHelperState", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;)Landroidx/paging/LoadState;", "sourceLoadStates", "remoteLoadStates", "set", "(Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "Landroidx/paging/LoadType;", "type", "", "remote", "state", "(Landroidx/paging/LoadType;ZLandroidx/paging/LoadState;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addListener", "removeListener", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/paging/internal/CopyOnWriteArrayList;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableCombinedLoadStateCollection {
    private final MutableStateFlow<CombinedLoadStates> _stateFlow;
    private final CopyOnWriteArrayList<Function1<CombinedLoadStates, Unit>> listeners = new CopyOnWriteArrayList<>();
    private final StateFlow<CombinedLoadStates> stateFlow;

    public MutableCombinedLoadStateCollection() {
        MutableStateFlow<CombinedLoadStates> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._stateFlow = MutableStateFlow;
        this.stateFlow = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final StateFlow<CombinedLoadStates> getStateFlow() {
        return this.stateFlow;
    }

    public final void set(final LoadStates sourceLoadStates, final LoadStates remoteLoadStates) {
        Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
        dispatchNewState(new Function1<CombinedLoadStates, CombinedLoadStates>() { // from class: androidx.paging.MutableCombinedLoadStateCollection.set.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CombinedLoadStates invoke(CombinedLoadStates combinedLoadStates) {
                return MutableCombinedLoadStateCollection.this.computeNewState(combinedLoadStates, sourceLoadStates, remoteLoadStates);
            }
        });
    }

    public final void set(final LoadType type, final boolean remote, final LoadState state) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(state, "state");
        dispatchNewState(new Function1<CombinedLoadStates, CombinedLoadStates>() { // from class: androidx.paging.MutableCombinedLoadStateCollection.set.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CombinedLoadStates invoke(CombinedLoadStates combinedLoadStates) {
                LoadStates idle;
                if (combinedLoadStates == null || (idle = combinedLoadStates.getSource()) == null) {
                    idle = LoadStates.INSTANCE.getIDLE();
                }
                LoadStates mediator = combinedLoadStates != null ? combinedLoadStates.getMediator() : null;
                if (remote) {
                    mediator = LoadStates.INSTANCE.getIDLE().modifyState$paging_common_release(type, state);
                } else {
                    idle = idle.modifyState$paging_common_release(type, state);
                }
                return this.computeNewState(combinedLoadStates, idle, mediator);
            }
        });
    }

    public final void addListener(Function1<? super CombinedLoadStates, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
        CombinedLoadStates value = this._stateFlow.getValue();
        if (value != null) {
            listener.invoke(value);
        }
    }

    public final void removeListener(Function1<? super CombinedLoadStates, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    private final void dispatchNewState(Function1<? super CombinedLoadStates, CombinedLoadStates> computeNewState) {
        CombinedLoadStates value;
        CombinedLoadStates combinedLoadStatesInvoke;
        MutableStateFlow<CombinedLoadStates> mutableStateFlow = this._stateFlow;
        do {
            value = mutableStateFlow.getValue();
            CombinedLoadStates combinedLoadStates = value;
            combinedLoadStatesInvoke = computeNewState.invoke(combinedLoadStates);
            if (Intrinsics.areEqual(combinedLoadStates, combinedLoadStatesInvoke)) {
                return;
            }
        } while (!mutableStateFlow.compareAndSet(value, combinedLoadStatesInvoke));
        if (combinedLoadStatesInvoke != null) {
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(combinedLoadStatesInvoke);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CombinedLoadStates computeNewState(CombinedLoadStates previousState, LoadStates newSource, LoadStates newRemote) {
        LoadState incomplete$paging_common_release;
        LoadState incomplete$paging_common_release2;
        LoadState incomplete$paging_common_release3;
        if (previousState == null || (incomplete$paging_common_release = previousState.getRefresh()) == null) {
            incomplete$paging_common_release = LoadState.NotLoading.INSTANCE.getIncomplete$paging_common_release();
        }
        LoadState loadStateComputeHelperState = computeHelperState(incomplete$paging_common_release, newSource.getRefresh(), newSource.getRefresh(), newRemote != null ? newRemote.getRefresh() : null);
        if (previousState == null || (incomplete$paging_common_release2 = previousState.getPrepend()) == null) {
            incomplete$paging_common_release2 = LoadState.NotLoading.INSTANCE.getIncomplete$paging_common_release();
        }
        LoadState loadStateComputeHelperState2 = computeHelperState(incomplete$paging_common_release2, newSource.getRefresh(), newSource.getPrepend(), newRemote != null ? newRemote.getPrepend() : null);
        if (previousState == null || (incomplete$paging_common_release3 = previousState.getAppend()) == null) {
            incomplete$paging_common_release3 = LoadState.NotLoading.INSTANCE.getIncomplete$paging_common_release();
        }
        return new CombinedLoadStates(loadStateComputeHelperState, loadStateComputeHelperState2, computeHelperState(incomplete$paging_common_release3, newSource.getRefresh(), newSource.getAppend(), newRemote != null ? newRemote.getAppend() : null), newSource, newRemote);
    }

    private final LoadState computeHelperState(LoadState previousState, LoadState sourceRefreshState, LoadState sourceState, LoadState remoteState) {
        return remoteState == null ? sourceState : (!(previousState instanceof LoadState.Loading) || ((sourceRefreshState instanceof LoadState.NotLoading) && (remoteState instanceof LoadState.NotLoading)) || (remoteState instanceof LoadState.Error)) ? remoteState : previousState;
    }
}
