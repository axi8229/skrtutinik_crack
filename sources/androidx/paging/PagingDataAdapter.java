package androidx.paging;

import androidx.paging.LoadState;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;

/* compiled from: PagingDataAdapter.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00010\u0005B+\b\u0007\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fB+\b\u0017\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\r\u0012\b\b\u0002\u0010\n\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\u001f\u001a\u00020\u00112\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0086@¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0011¢\u0006\u0004\b!\u0010\"J\u001b\u0010#\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010\u0015\u001a\u00020\u0014H\u0005¢\u0006\u0004\b#\u0010$J\u0013\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0014H\u0016¢\u0006\u0004\b(\u0010)J!\u0010-\u001a\u00020\u00112\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00110*¢\u0006\u0004\b-\u0010.J!\u0010/\u001a\u00020\u00112\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00110*¢\u0006\u0004\b/\u0010.J%\u00104\u001a\u0002032\n\u00101\u001a\u0006\u0012\u0002\b\u0003002\n\u00102\u001a\u0006\u0012\u0002\b\u000300¢\u0006\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00028\u0000088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020+0;8\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00110;8\u0006¢\u0006\f\n\u0004\b@\u0010=\u001a\u0004\bA\u0010?¨\u0006B"}, d2 = {"Landroidx/paging/PagingDataAdapter;", "", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "Lkotlin/coroutines/CoroutineContext;", "mainDispatcher", "workerDispatcher", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter$StateRestorationPolicy;", "strategy", "", "setStateRestorationPolicy", "(Landroidx/recyclerview/widget/RecyclerView$Adapter$StateRestorationPolicy;)V", "", "position", "", "getItemId", "(I)J", "", "hasStableIds", "setHasStableIds", "(Z)V", "Landroidx/paging/PagingData;", "pagingData", "submitData", "(Landroidx/paging/PagingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retry", "()V", "getItem", "(I)Ljava/lang/Object;", "Landroidx/paging/ItemSnapshotList;", "snapshot", "()Landroidx/paging/ItemSnapshotList;", "getItemCount", "()I", "Lkotlin/Function1;", "Landroidx/paging/CombinedLoadStates;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addLoadStateListener", "(Lkotlin/jvm/functions/Function1;)V", "removeLoadStateListener", "Landroidx/paging/LoadStateAdapter;", "header", "footer", "Landroidx/recyclerview/widget/ConcatAdapter;", "withLoadStateHeaderAndFooter", "(Landroidx/paging/LoadStateAdapter;Landroidx/paging/LoadStateAdapter;)Landroidx/recyclerview/widget/ConcatAdapter;", "userSetRestorationPolicy", "Z", "Landroidx/paging/AsyncPagingDataDiffer;", "differ", "Landroidx/paging/AsyncPagingDataDiffer;", "Lkotlinx/coroutines/flow/Flow;", "loadStateFlow", "Lkotlinx/coroutines/flow/Flow;", "getLoadStateFlow", "()Lkotlinx/coroutines/flow/Flow;", "onPagesUpdatedFlow", "getOnPagesUpdatedFlow", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PagingDataAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private final AsyncPagingDataDiffer<T> differ;
    private final Flow<CombinedLoadStates> loadStateFlow;
    private final Flow<Unit> onPagesUpdatedFlow;
    private boolean userSetRestorationPolicy;

    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback itemCallback, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemCallback, (i & 2) != 0 ? Dispatchers.getMain() : coroutineContext, (i & 4) != 0 ? Dispatchers.getDefault() : coroutineContext2);
    }

    public PagingDataAdapter(DiffUtil.ItemCallback<T> diffCallback, CoroutineContext mainDispatcher, CoroutineContext workerDispatcher) {
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(workerDispatcher, "workerDispatcher");
        AsyncPagingDataDiffer<T> asyncPagingDataDiffer = new AsyncPagingDataDiffer<>(diffCallback, new AdapterListUpdateCallback(this), mainDispatcher, workerDispatcher);
        this.differ = asyncPagingDataDiffer;
        super.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT);
        registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(this) { // from class: androidx.paging.PagingDataAdapter.1
            final /* synthetic */ PagingDataAdapter<T, VH> this$0;

            {
                this.this$0 = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int positionStart, int itemCount) {
                PagingDataAdapter._init_$considerAllowingStateRestoration(this.this$0);
                this.this$0.unregisterAdapterDataObserver(this);
                super.onItemRangeInserted(positionStart, itemCount);
            }
        });
        addLoadStateListener(new Function1<CombinedLoadStates, Unit>(this) { // from class: androidx.paging.PagingDataAdapter.2
            private boolean ignoreNextEvent = true;
            final /* synthetic */ PagingDataAdapter<T, VH> this$0;

            {
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CombinedLoadStates combinedLoadStates) {
                invoke2(combinedLoadStates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public void invoke2(CombinedLoadStates loadStates) {
                Intrinsics.checkNotNullParameter(loadStates, "loadStates");
                if (this.ignoreNextEvent) {
                    this.ignoreNextEvent = false;
                } else if (loadStates.getSource().getRefresh() instanceof LoadState.NotLoading) {
                    PagingDataAdapter._init_$considerAllowingStateRestoration(this.this$0);
                    this.this$0.removeLoadStateListener(this);
                }
            }
        });
        this.loadStateFlow = asyncPagingDataDiffer.getLoadStateFlow();
        this.onPagesUpdatedFlow = asyncPagingDataDiffer.getOnPagesUpdatedFlow();
    }

    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback itemCallback, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemCallback, (i & 2) != 0 ? Dispatchers.getMain() : coroutineDispatcher, (i & 4) != 0 ? Dispatchers.getDefault() : coroutineDispatcher2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback diffCallback, CoroutineDispatcher mainDispatcher, CoroutineDispatcher workerDispatcher) {
        this(diffCallback, (CoroutineContext) mainDispatcher, (CoroutineContext) workerDispatcher);
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(workerDispatcher, "workerDispatcher");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.userSetRestorationPolicy = true;
        super.setStateRestorationPolicy(strategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T, VH extends RecyclerView.ViewHolder> void _init_$considerAllowingStateRestoration(PagingDataAdapter<T, VH> pagingDataAdapter) {
        if (pagingDataAdapter.getStateRestorationPolicy() != RecyclerView.Adapter.StateRestorationPolicy.PREVENT || ((PagingDataAdapter) pagingDataAdapter).userSetRestorationPolicy) {
            return;
        }
        pagingDataAdapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.ALLOW);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean hasStableIds) {
        throw new UnsupportedOperationException("Stable ids are unsupported on PagingDataAdapter.");
    }

    public final Object submitData(PagingData<T> pagingData, Continuation<? super Unit> continuation) {
        Object objSubmitData = this.differ.submitData(pagingData, continuation);
        return objSubmitData == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSubmitData : Unit.INSTANCE;
    }

    public final void retry() {
        this.differ.retry();
    }

    protected final T getItem(int position) {
        return this.differ.getItem(position);
    }

    public final ItemSnapshotList<T> snapshot() {
        return this.differ.snapshot();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.differ.getItemCount();
    }

    public final void addLoadStateListener(Function1<? super CombinedLoadStates, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.differ.addLoadStateListener(listener);
    }

    public final void removeLoadStateListener(Function1<? super CombinedLoadStates, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.differ.removeLoadStateListener(listener);
    }

    public final ConcatAdapter withLoadStateHeaderAndFooter(final LoadStateAdapter<?> header, final LoadStateAdapter<?> footer) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(footer, "footer");
        addLoadStateListener(new Function1<CombinedLoadStates, Unit>() { // from class: androidx.paging.PagingDataAdapter.withLoadStateHeaderAndFooter.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CombinedLoadStates combinedLoadStates) {
                invoke2(combinedLoadStates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CombinedLoadStates loadStates) {
                Intrinsics.checkNotNullParameter(loadStates, "loadStates");
                header.setLoadState(loadStates.getPrepend());
                footer.setLoadState(loadStates.getAppend());
            }
        });
        return new ConcatAdapter(header, this, footer);
    }
}
