package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import androidx.paging.PageFetcherSnapshotState;
import androidx.paging.PagingSource;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import org.pjsip.pjsua2.pjsip_status_code;

/* compiled from: PageFetcherSnapshot.kt */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B{\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000eH\u0086@¢\u0006\u0004\b\u001a\u0010\u001bJ\"\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0082@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010!\u001a\u00020\n*\u00020 H\u0002¢\u0006\u0004\b!\u0010\"J\"\u0010$\u001a\u00020\n*\b\u0012\u0004\u0012\u00020#0\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0082@¢\u0006\u0004\b$\u0010%J'\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\nH\u0082@¢\u0006\u0004\b*\u0010\u001bJ \u0010-\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020+H\u0082@¢\u0006\u0004\b-\u0010.J7\u00103\u001a\u0002022\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010/\u001a\u0004\u0018\u00018\u00002\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u000100H\u0002¢\u0006\u0004\b3\u00104J(\u00106\u001a\u00020\n*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001052\u0006\u0010\u001d\u001a\u00020\u001cH\u0082@¢\u0006\u0004\b6\u00107J0\u0010:\u001a\u00020\n*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001052\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u00109\u001a\u000208H\u0082@¢\u0006\u0004\b:\u0010;J9\u0010>\u001a\u0004\u0018\u00018\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001052\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020#H\u0002¢\u0006\u0004\b>\u0010?R\u001c\u0010\u0004\u001a\u0004\u0018\u00018\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010@\u001a\u0004\bA\u0010BR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010C\u001a\u0004\bD\u0010ER\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010FR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010GR%\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010H\u001a\u0004\bI\u0010JR\"\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010KR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u00060Pj\u0002`Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR \u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010U0T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR \u0010Y\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010\\\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R#\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010U0\t8\u0006¢\u0006\f\n\u0004\b^\u0010G\u001a\u0004\b_\u0010`¨\u0006a"}, d2 = {"Landroidx/paging/PageFetcherSnapshot;", "", "Key", "Value", "initialKey", "Landroidx/paging/PagingSource;", "pagingSource", "Landroidx/paging/PagingConfig;", "config", "Lkotlinx/coroutines/flow/Flow;", "", "retryFlow", "Landroidx/paging/RemoteMediatorConnection;", "remoteMediatorConnection", "Landroidx/paging/PagingState;", "previousPagingState", "Lkotlin/Function0;", "jumpCallback", "<init>", "(Ljava/lang/Object;Landroidx/paging/PagingSource;Landroidx/paging/PagingConfig;Lkotlinx/coroutines/flow/Flow;Landroidx/paging/RemoteMediatorConnection;Landroidx/paging/PagingState;Lkotlin/jvm/functions/Function0;)V", "Landroidx/paging/ViewportHint;", "viewportHint", "accessHint", "(Landroidx/paging/ViewportHint;)V", "close", "()V", "currentPagingState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/LoadType;", "loadType", "retryLoadError", "(Landroidx/paging/LoadType;Landroidx/paging/ViewportHint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "startConsumingHints", "(Lkotlinx/coroutines/CoroutineScope;)V", "", "collectAsGenerationalViewportHints", "(Lkotlinx/coroutines/flow/Flow;Landroidx/paging/LoadType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "key", "Landroidx/paging/PagingSource$LoadParams;", "loadParams", "(Landroidx/paging/LoadType;Ljava/lang/Object;)Landroidx/paging/PagingSource$LoadParams;", "doInitialLoad", "Landroidx/paging/GenerationalViewportHint;", "generationalHint", "doLoad", "(Landroidx/paging/LoadType;Landroidx/paging/GenerationalViewportHint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadKey", "Landroidx/paging/PagingSource$LoadResult;", "result", "", "loadResultLog", "(Landroidx/paging/LoadType;Ljava/lang/Object;Landroidx/paging/PagingSource$LoadResult;)Ljava/lang/String;", "Landroidx/paging/PageFetcherSnapshotState;", "setLoading", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/LoadState$Error;", "error", "setError", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;Landroidx/paging/LoadState$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generationId", "presentedItemsBeyondAnchor", "nextLoadKeyOrNull", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;II)Ljava/lang/Object;", "Ljava/lang/Object;", "getInitialKey$paging_common_release", "()Ljava/lang/Object;", "Landroidx/paging/PagingSource;", "getPagingSource$paging_common_release", "()Landroidx/paging/PagingSource;", "Landroidx/paging/PagingConfig;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/RemoteMediatorConnection;", "getRemoteMediatorConnection", "()Landroidx/paging/RemoteMediatorConnection;", "Landroidx/paging/PagingState;", "Lkotlin/jvm/functions/Function0;", "Landroidx/paging/HintHandler;", "hintHandler", "Landroidx/paging/HintHandler;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/paging/internal/AtomicBoolean;", "pageEventChCollected", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/paging/PageEvent;", "pageEventCh", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/paging/PageFetcherSnapshotState$Holder;", "stateHolder", "Landroidx/paging/PageFetcherSnapshotState$Holder;", "Lkotlinx/coroutines/CompletableJob;", "pageEventChannelFlowJob", "Lkotlinx/coroutines/CompletableJob;", "pageEventFlow", "getPageEventFlow", "()Lkotlinx/coroutines/flow/Flow;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PageFetcherSnapshot<Key, Value> {
    private final PagingConfig config;
    private final HintHandler hintHandler;
    private final Key initialKey;
    private final Function0<Unit> jumpCallback;
    private final Channel<PageEvent<Value>> pageEventCh;
    private final AtomicBoolean pageEventChCollected;
    private final CompletableJob pageEventChannelFlowJob;
    private final Flow<PageEvent<Value>> pageEventFlow;
    private final PagingSource<Key, Value> pagingSource;
    private final PagingState<Key, Value> previousPagingState;
    private final RemoteMediatorConnection<Key, Value> remoteMediatorConnection;
    private final Flow<Unit> retryFlow;
    private final PageFetcherSnapshotState.Holder<Key, Value> stateHolder;

    /* compiled from: PageFetcherSnapshot.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.PREPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: PageFetcherSnapshot.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", l = {646}, m = "currentPagingState")
    /* renamed from: androidx.paging.PageFetcherSnapshot$currentPagingState$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = pageFetcherSnapshot;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.currentPagingState(this);
        }
    }

    /* compiled from: PageFetcherSnapshot.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", l = {646, 284, 290, 667, 688, 326, 709, 730, 354}, m = "doInitialLoad")
    /* renamed from: androidx.paging.PageFetcherSnapshot$doInitialLoad$1, reason: invalid class name and case insensitive filesystem */
    static final class C04841 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04841(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Continuation<? super C04841> continuation) {
            super(continuation);
            this.this$0 = pageFetcherSnapshot;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.doInitialLoad(this);
        }
    }

    /* compiled from: PageFetcherSnapshot.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", l = {647, 658, pjsip_status_code.PJSIP_SC_UNSUPPORTED_MEDIA_TYPE, pjsip_status_code.PJSIP_SC_BAD_LOCATION_INFORMATION, 679, 720, 472, 741, 495, 521, 752}, m = "doLoad")
    /* renamed from: androidx.paging.PageFetcherSnapshot$doLoad$1, reason: invalid class name and case insensitive filesystem */
    static final class C04851 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04851(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Continuation<? super C04851> continuation) {
            super(continuation);
            this.this$0 = pageFetcherSnapshot;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.doLoad(null, null, this);
        }
    }

    public PageFetcherSnapshot(Key key, PagingSource<Key, Value> pagingSource, PagingConfig config, Flow<Unit> retryFlow, RemoteMediatorConnection<Key, Value> remoteMediatorConnection, PagingState<Key, Value> pagingState, Function0<Unit> jumpCallback) {
        Intrinsics.checkNotNullParameter(pagingSource, "pagingSource");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(retryFlow, "retryFlow");
        Intrinsics.checkNotNullParameter(jumpCallback, "jumpCallback");
        this.initialKey = key;
        this.pagingSource = pagingSource;
        this.config = config;
        this.retryFlow = retryFlow;
        this.remoteMediatorConnection = remoteMediatorConnection;
        this.previousPagingState = pagingState;
        this.jumpCallback = jumpCallback;
        if (config.jumpThreshold != Integer.MIN_VALUE && !pagingSource.getJumpingSupported()) {
            throw new IllegalArgumentException("PagingConfig.jumpThreshold was set, but the associated PagingSource has not marked support for jumps by overriding PagingSource.jumpingSupported to true.");
        }
        this.hintHandler = new HintHandler();
        this.pageEventChCollected = new AtomicBoolean(false);
        this.pageEventCh = ChannelKt.Channel$default(-2, null, null, 6, null);
        this.stateHolder = new PageFetcherSnapshotState.Holder<>(config);
        CompletableJob completableJobJob$default = JobKt__JobKt.Job$default(null, 1, null);
        this.pageEventChannelFlowJob = completableJobJob$default;
        this.pageEventFlow = FlowKt.onStart(CancelableChannelFlowKt.cancelableChannelFlow(completableJobJob$default, new PageFetcherSnapshot$pageEventFlow$1(this, null)), new PageFetcherSnapshot$pageEventFlow$2(this, null));
    }

    public final PagingSource<Key, Value> getPagingSource$paging_common_release() {
        return this.pagingSource;
    }

    public final RemoteMediatorConnection<Key, Value> getRemoteMediatorConnection() {
        return this.remoteMediatorConnection;
    }

    public final Flow<PageEvent<Value>> getPageEventFlow() {
        return this.pageEventFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object collectAsGenerationalViewportHints(Flow<Integer> flow, final LoadType loadType, Continuation<? super Unit> continuation) {
        Object objCollect = FlowKt.conflate(FlowExtKt.simpleRunningReduce(FlowExtKt.simpleTransformLatest(flow, new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1(null, this, loadType)), new AnonymousClass3(loadType, null))).collect(new FlowCollector(this) { // from class: androidx.paging.PageFetcherSnapshot.collectAsGenerationalViewportHints.4
            final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((GenerationalViewportHint) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(GenerationalViewportHint generationalViewportHint, Continuation<? super Unit> continuation2) throws Throwable {
                Object objDoLoad = this.this$0.doLoad(loadType, generationalViewportHint, continuation2);
                return objDoLoad == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDoLoad : Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object retryLoadError(LoadType loadType, ViewportHint viewportHint, Continuation<? super Unit> continuation) throws Throwable {
        if (WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()] == 1) {
            Object objDoInitialLoad = doInitialLoad(continuation);
            return objDoInitialLoad == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDoInitialLoad : Unit.INSTANCE;
        }
        if (viewportHint == null) {
            throw new IllegalStateException("Cannot retry APPEND / PREPEND load on PagingSource without ViewportHint");
        }
        this.hintHandler.forceSetHint(loadType, viewportHint);
        return Unit.INSTANCE;
    }

    public final void accessHint(ViewportHint viewportHint) {
        Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
        this.hintHandler.processHint(viewportHint);
    }

    public final void close() {
        Job.DefaultImpls.cancel$default(this.pageEventChannelFlowJob, null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object currentPagingState(kotlin.coroutines.Continuation<? super androidx.paging.PagingState<Key, Value>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.paging.PageFetcherSnapshot.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.paging.PageFetcherSnapshot$currentPagingState$1 r0 = (androidx.paging.PageFetcherSnapshot.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.paging.PageFetcherSnapshot$currentPagingState$1 r0 = new androidx.paging.PageFetcherSnapshot$currentPagingState$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r1 = r0.L$2
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r2 = r0.L$1
            androidx.paging.PageFetcherSnapshotState$Holder r2 = (androidx.paging.PageFetcherSnapshotState.Holder) r2
            java.lang.Object r0 = r0.L$0
            androidx.paging.PageFetcherSnapshot r0 = (androidx.paging.PageFetcherSnapshot) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L58
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3e:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.paging.PageFetcherSnapshotState$Holder<Key, Value> r2 = r5.stateHolder
            kotlinx.coroutines.sync.Mutex r6 = androidx.paging.PageFetcherSnapshotState.Holder.access$getLock$p(r2)
            r0.L$0 = r5
            r0.L$1 = r2
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r0 = r6.lock(r4, r0)
            if (r0 != r1) goto L56
            return r1
        L56:
            r0 = r5
            r1 = r6
        L58:
            androidx.paging.PageFetcherSnapshotState r6 = androidx.paging.PageFetcherSnapshotState.Holder.access$getState$p(r2)     // Catch: java.lang.Throwable -> L6a
            androidx.paging.HintHandler r0 = r0.hintHandler     // Catch: java.lang.Throwable -> L6a
            androidx.paging.ViewportHint$Access r0 = r0.getLastAccessHint()     // Catch: java.lang.Throwable -> L6a
            androidx.paging.PagingState r6 = r6.currentPagingState$paging_common_release(r0)     // Catch: java.lang.Throwable -> L6a
            r1.unlock(r4)
            return r6
        L6a:
            r6 = move-exception
            r1.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.currentPagingState(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: PageFetcherSnapshot.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$1", f = "PageFetcherSnapshot.kt", l = {220}, m = "invokeSuspend")
    /* renamed from: androidx.paging.PageFetcherSnapshot$startConsumingHints$1, reason: invalid class name and case insensitive filesystem */
    static final class C04861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04861(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Continuation<? super C04861> continuation) {
            super(2, continuation);
            this.this$0 = pageFetcherSnapshot;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04861(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04861) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowMerge = FlowKt.merge(((PageFetcherSnapshot) this.this$0).hintHandler.hintFor(LoadType.APPEND), ((PageFetcherSnapshot) this.this$0).hintHandler.hintFor(LoadType.PREPEND));
                PageFetcherSnapshot$startConsumingHints$1$jumpHint$1 pageFetcherSnapshot$startConsumingHints$1$jumpHint$1 = new PageFetcherSnapshot$startConsumingHints$1$jumpHint$1(this.this$0, null);
                this.label = 1;
                obj = FlowKt.firstOrNull(flowMerge, pageFetcherSnapshot$startConsumingHints$1$jumpHint$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ViewportHint viewportHint = (ViewportHint) obj;
            if (viewportHint != null) {
                PageFetcherSnapshot<Key, Value> pageFetcherSnapshot = this.this$0;
                PagingLogger pagingLogger = PagingLogger.INSTANCE;
                if (pagingLogger.isLoggable(3)) {
                    pagingLogger.log(3, "Jump triggered on PagingSource " + pageFetcherSnapshot.getPagingSource$paging_common_release() + " by " + viewportHint, null);
                }
                ((PageFetcherSnapshot) this.this$0).jumpCallback.invoke();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startConsumingHints(CoroutineScope coroutineScope) {
        if (this.config.jumpThreshold != Integer.MIN_VALUE) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C04861(this, null), 3, null);
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C04873(this, null), 3, null);
    }

    /* compiled from: PageFetcherSnapshot.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$2", f = "PageFetcherSnapshot.kt", l = {646, 233}, m = "invokeSuspend")
    /* renamed from: androidx.paging.PageFetcherSnapshot$startConsumingHints$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = pageFetcherSnapshot;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PageFetcherSnapshot<Key, Value> pageFetcherSnapshot;
            PageFetcherSnapshotState.Holder holder;
            Mutex mutex;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    pageFetcherSnapshot = this.this$0;
                    holder = ((PageFetcherSnapshot) pageFetcherSnapshot).stateHolder;
                    Mutex mutex2 = holder.lock;
                    this.L$0 = holder;
                    this.L$1 = mutex2;
                    this.L$2 = pageFetcherSnapshot;
                    this.label = 1;
                    if (mutex2.lock(null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutex = mutex2;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    pageFetcherSnapshot = (PageFetcherSnapshot) this.L$2;
                    mutex = (Mutex) this.L$1;
                    holder = (PageFetcherSnapshotState.Holder) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Flow<Integer> flowConsumePrependGenerationIdAsFlow = holder.state.consumePrependGenerationIdAsFlow();
                mutex.unlock(null);
                LoadType loadType = LoadType.PREPEND;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 2;
                if (pageFetcherSnapshot.collectAsGenerationalViewportHints(flowConsumePrependGenerationIdAsFlow, loadType, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
    }

    /* compiled from: PageFetcherSnapshot.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$3", f = "PageFetcherSnapshot.kt", l = {646, 238}, m = "invokeSuspend")
    /* renamed from: androidx.paging.PageFetcherSnapshot$startConsumingHints$3, reason: invalid class name and case insensitive filesystem */
    static final class C04873 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04873(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Continuation<? super C04873> continuation) {
            super(2, continuation);
            this.this$0 = pageFetcherSnapshot;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04873(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04873) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PageFetcherSnapshot<Key, Value> pageFetcherSnapshot;
            PageFetcherSnapshotState.Holder holder;
            Mutex mutex;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    pageFetcherSnapshot = this.this$0;
                    holder = ((PageFetcherSnapshot) pageFetcherSnapshot).stateHolder;
                    Mutex mutex2 = holder.lock;
                    this.L$0 = holder;
                    this.L$1 = mutex2;
                    this.L$2 = pageFetcherSnapshot;
                    this.label = 1;
                    if (mutex2.lock(null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutex = mutex2;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    pageFetcherSnapshot = (PageFetcherSnapshot) this.L$2;
                    mutex = (Mutex) this.L$1;
                    holder = (PageFetcherSnapshotState.Holder) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Flow<Integer> flowConsumeAppendGenerationIdAsFlow = holder.state.consumeAppendGenerationIdAsFlow();
                mutex.unlock(null);
                LoadType loadType = LoadType.APPEND;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 2;
                if (pageFetcherSnapshot.collectAsGenerationalViewportHints(flowConsumeAppendGenerationIdAsFlow, loadType, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
    }

    /* compiled from: PageFetcherSnapshot.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroidx/paging/GenerationalViewportHint;", "Key", "", "Value", "previous", "next"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$3", f = "PageFetcherSnapshot.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function3<GenerationalViewportHint, GenerationalViewportHint, Continuation<? super GenerationalViewportHint>, Object> {
        final /* synthetic */ LoadType $loadType;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(LoadType loadType, Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
            this.$loadType = loadType;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(GenerationalViewportHint generationalViewportHint, GenerationalViewportHint generationalViewportHint2, Continuation<? super GenerationalViewportHint> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$loadType, continuation);
            anonymousClass3.L$0 = generationalViewportHint;
            anonymousClass3.L$1 = generationalViewportHint2;
            return anonymousClass3.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            GenerationalViewportHint generationalViewportHint = (GenerationalViewportHint) this.L$0;
            GenerationalViewportHint generationalViewportHint2 = (GenerationalViewportHint) this.L$1;
            return PageFetcherSnapshotKt.shouldPrioritizeOver(generationalViewportHint2, generationalViewportHint, this.$loadType) ? generationalViewportHint2 : generationalViewportHint;
        }
    }

    private final PagingSource.LoadParams<Key> loadParams(LoadType loadType, Key key) {
        return PagingSource.LoadParams.INSTANCE.create(loadType, key, loadType == LoadType.REFRESH ? this.config.initialLoadSize : this.config.pageSize, this.config.enablePlaceholders);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0186 A[Catch: all -> 0x0194, TryCatch #1 {all -> 0x0194, blocks: (B:54:0x0162, B:56:0x0186, B:59:0x0197, B:61:0x01a0), top: B:131:0x0162 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a0 A[Catch: all -> 0x0194, TRY_LEAVE, TryCatch #1 {all -> 0x0194, blocks: (B:54:0x0162, B:56:0x0186, B:59:0x0197, B:61:0x01a0), top: B:131:0x0162 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01fe A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0271  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v40, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v9, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object doInitialLoad(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 774
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.doInitialLoad(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0357, code lost:
    
        r0 = r9;
        r8 = r12;
        r9 = r13;
        r12 = r14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:200:0x0654, B:203:0x065f], limit reached: 255 */
    /* JADX WARN: Path cross not found for [B:206:0x0664, B:209:0x066e], limit reached: 255 */
    /* JADX WARN: Removed duplicated region for block: B:123:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0526 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0551  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x057f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0580  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x059c A[Catch: all -> 0x05d7, TRY_LEAVE, TryCatch #6 {all -> 0x05d7, blocks: (B:174:0x058e, B:176:0x059c), top: B:252:0x058e }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x05f5 A[Catch: all -> 0x0096, TryCatch #3 {all -> 0x0096, blocks: (B:180:0x05cd, B:184:0x05de, B:186:0x05f5, B:188:0x0601, B:190:0x0609, B:192:0x0616, B:191:0x0610, B:193:0x0619, B:197:0x064a, B:14:0x0087, B:19:0x00c2), top: B:247:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0609 A[Catch: all -> 0x0096, TryCatch #3 {all -> 0x0096, blocks: (B:180:0x05cd, B:184:0x05de, B:186:0x05f5, B:188:0x0601, B:190:0x0609, B:192:0x0616, B:191:0x0610, B:193:0x0619, B:197:0x064a, B:14:0x0087, B:19:0x00c2), top: B:247:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0610 A[Catch: all -> 0x0096, TryCatch #3 {all -> 0x0096, blocks: (B:180:0x05cd, B:184:0x05de, B:186:0x05f5, B:188:0x0601, B:190:0x0609, B:192:0x0616, B:191:0x0610, B:193:0x0619, B:197:0x064a, B:14:0x0087, B:19:0x00c2), top: B:247:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0643 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x06b8  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x06c1  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x06d3  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x06e6 A[Catch: all -> 0x0257, TRY_ENTER, TryCatch #4 {all -> 0x0257, blocks: (B:43:0x0223, B:68:0x02d4, B:50:0x023a, B:52:0x024a, B:55:0x025b, B:57:0x0265, B:59:0x027e, B:60:0x0281, B:62:0x029a, B:65:0x02b8, B:67:0x02d1, B:235:0x06e6, B:236:0x06eb), top: B:249:0x0223 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0324 A[Catch: all -> 0x0347, TRY_LEAVE, TryCatch #5 {all -> 0x0347, blocks: (B:73:0x030b, B:75:0x0324), top: B:250:0x030b }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03c0  */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v38 */
    /* JADX WARN: Type inference failed for: r12v39 */
    /* JADX WARN: Type inference failed for: r12v40 */
    /* JADX WARN: Type inference failed for: r12v50, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v52, types: [androidx.paging.PageFetcherSnapshot] */
    /* JADX WARN: Type inference failed for: r12v55 */
    /* JADX WARN: Type inference failed for: r12v58 */
    /* JADX WARN: Type inference failed for: r12v59 */
    /* JADX WARN: Type inference failed for: r14v20, types: [androidx.paging.PageFetcherSnapshot] */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r1v16, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v10, types: [T] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [int] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r6v41, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v44 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r6v61 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v58, types: [androidx.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v61 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:217:0x069f -> B:254:0x06a4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object doLoad(androidx.paging.LoadType r19, androidx.paging.GenerationalViewportHint r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1810
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.doLoad(androidx.paging.LoadType, androidx.paging.GenerationalViewportHint, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String loadResultLog(LoadType loadType, Key loadKey, PagingSource.LoadResult<Key, Value> result) {
        if (result == null) {
            return "End " + loadType + " with loadkey " + loadKey + ". Load CANCELLED.";
        }
        return "End " + loadType + " with loadKey " + loadKey + ". Returned " + result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object setLoading(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, LoadType loadType, Continuation<? super Unit> continuation) {
        LoadState loadState = pageFetcherSnapshotState.getSourceLoadStates().get(loadType);
        LoadState.Loading loading = LoadState.Loading.INSTANCE;
        if (!Intrinsics.areEqual(loadState, loading)) {
            pageFetcherSnapshotState.getSourceLoadStates().set(loadType, loading);
            Object objSend = this.pageEventCh.send(new PageEvent.LoadStateUpdate(pageFetcherSnapshotState.getSourceLoadStates().snapshot(), null), continuation);
            return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final Object setError(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, LoadType loadType, LoadState.Error error, Continuation<? super Unit> continuation) {
        if (!Intrinsics.areEqual(pageFetcherSnapshotState.getSourceLoadStates().get(loadType), error)) {
            pageFetcherSnapshotState.getSourceLoadStates().set(loadType, error);
            Object objSend = this.pageEventCh.send(new PageEvent.LoadStateUpdate(pageFetcherSnapshotState.getSourceLoadStates().snapshot(), null), continuation);
            return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final Key nextLoadKeyOrNull(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, LoadType loadType, int i, int i2) {
        if (i != pageFetcherSnapshotState.generationId$paging_common_release(loadType) || (pageFetcherSnapshotState.getSourceLoadStates().get(loadType) instanceof LoadState.Error) || i2 >= this.config.prefetchDistance) {
            return null;
        }
        if (loadType == LoadType.PREPEND) {
            return (Key) ((PagingSource.LoadResult.Page) CollectionsKt.first((List) pageFetcherSnapshotState.getPages$paging_common_release())).getPrevKey();
        }
        return (Key) ((PagingSource.LoadResult.Page) CollectionsKt.last((List) pageFetcherSnapshotState.getPages$paging_common_release())).getNextKey();
    }
}
