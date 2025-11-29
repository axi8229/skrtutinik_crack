package androidx.paging;

import androidx.paging.PageEvent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: PagingDataPresenter.kt */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B#\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJX\u0010\u0017\u001a\u00020\u00162\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u001b\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H¦@¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\u001e\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086@¢\u0006\u0004\b\u001e\u0010\u001fJ\u001c\u0010!\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010 \u001a\u00020\fH\u0087\u0002¢\u0006\u0004\b!\u0010\"J\u0013\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0016¢\u0006\u0004\b&\u0010'J\u001b\u0010*\u001a\u00020\u00162\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00160(¢\u0006\u0004\b*\u0010+J!\u0010.\u001a\u00020\u00162\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00160,¢\u0006\u0004\b.\u0010/J!\u00100\u001a\u00020\u00162\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00160,¢\u0006\u0004\b0\u0010/R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00028\u0000078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R0\u0010?\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160(0=j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160(`>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000f0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001f\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0K8\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00160P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0011\u0010U\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00160V8F¢\u0006\u0006\u001a\u0004\bW\u0010X¨\u0006Z"}, d2 = {"Landroidx/paging/PagingDataPresenter;", "", "T", "Lkotlin/coroutines/CoroutineContext;", "mainContext", "Landroidx/paging/PagingData;", "cachedPagingData", "<init>", "(Lkotlin/coroutines/CoroutineContext;Landroidx/paging/PagingData;)V", "", "Landroidx/paging/TransformablePage;", "pages", "", "placeholdersBefore", "placeholdersAfter", "", "dispatchLoadStates", "Landroidx/paging/LoadStates;", "sourceLoadStates", "mediatorLoadStates", "Landroidx/paging/HintReceiver;", "newHintReceiver", "", "presentNewList", "(Ljava/util/List;IIZLandroidx/paging/LoadStates;Landroidx/paging/LoadStates;Landroidx/paging/HintReceiver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PagingDataEvent;", "event", "presentPagingDataEvent", "(Landroidx/paging/PagingDataEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pagingData", "collectFrom", "(Landroidx/paging/PagingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "index", "get", "(I)Ljava/lang/Object;", "Landroidx/paging/ItemSnapshotList;", "snapshot", "()Landroidx/paging/ItemSnapshotList;", "retry", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addOnPagesUpdatedListener", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Landroidx/paging/CombinedLoadStates;", "addLoadStateListener", "(Lkotlin/jvm/functions/Function1;)V", "removeLoadStateListener", "Lkotlin/coroutines/CoroutineContext;", "hintReceiver", "Landroidx/paging/HintReceiver;", "Landroidx/paging/UiReceiver;", "uiReceiver", "Landroidx/paging/UiReceiver;", "Landroidx/paging/PageStore;", "pageStore", "Landroidx/paging/PageStore;", "Landroidx/paging/MutableCombinedLoadStateCollection;", "combinedLoadStatesCollection", "Landroidx/paging/MutableCombinedLoadStateCollection;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/paging/internal/CopyOnWriteArrayList;", "onPagesUpdatedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/paging/SingleRunner;", "collectFromRunner", "Landroidx/paging/SingleRunner;", "lastAccessedIndexUnfulfilled", "Z", "lastAccessedIndex", "I", "Lkotlinx/coroutines/flow/MutableStateFlow;", "inGetItem", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "loadStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getLoadStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_onPagesUpdatedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getSize", "()I", "size", "Lkotlinx/coroutines/flow/Flow;", "getOnPagesUpdatedFlow", "()Lkotlinx/coroutines/flow/Flow;", "onPagesUpdatedFlow", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PagingDataPresenter<T> {
    private final MutableSharedFlow<Unit> _onPagesUpdatedFlow;
    private final SingleRunner collectFromRunner;
    private final MutableCombinedLoadStateCollection combinedLoadStatesCollection;
    private HintReceiver hintReceiver;
    private final MutableStateFlow<Boolean> inGetItem;
    private volatile int lastAccessedIndex;
    private volatile boolean lastAccessedIndexUnfulfilled;
    private final StateFlow<CombinedLoadStates> loadStateFlow;
    private final CoroutineContext mainContext;
    private final CopyOnWriteArrayList<Function0<Unit>> onPagesUpdatedListeners;
    private PageStore<T> pageStore;
    private UiReceiver uiReceiver;

    /* compiled from: PagingDataPresenter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PagingDataPresenter", f = "PagingDataPresenter.kt", l = {478}, m = "presentNewList")
    /* renamed from: androidx.paging.PagingDataPresenter$presentNewList$1, reason: invalid class name and case insensitive filesystem */
    static final class C04901 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PagingDataPresenter<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04901(PagingDataPresenter<T> pagingDataPresenter, Continuation<? super C04901> continuation) {
            super(continuation);
            this.this$0 = pagingDataPresenter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.presentNewList(null, 0, 0, false, null, null, null, this);
        }
    }

    public PagingDataPresenter() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public abstract Object presentPagingDataEvent(PagingDataEvent<T> pagingDataEvent, Continuation<Unit> continuation);

    public final void retry() {
        PagingLogger pagingLogger = PagingLogger.INSTANCE;
        if (pagingLogger.isLoggable(3)) {
            pagingLogger.log(3, "Retry signal received", null);
        }
        UiReceiver uiReceiver = this.uiReceiver;
        if (uiReceiver != null) {
            uiReceiver.retry();
        }
    }

    public PagingDataPresenter(CoroutineContext mainContext, PagingData<T> pagingData) {
        PageEvent.Insert<T> insertCachedEvent$paging_common_release;
        Intrinsics.checkNotNullParameter(mainContext, "mainContext");
        this.mainContext = mainContext;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.pageStore = PageStore.INSTANCE.initial$paging_common_release(pagingData != null ? pagingData.cachedEvent$paging_common_release() : null);
        MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection = new MutableCombinedLoadStateCollection();
        if (pagingData != null && (insertCachedEvent$paging_common_release = pagingData.cachedEvent$paging_common_release()) != null) {
            mutableCombinedLoadStateCollection.set(insertCachedEvent$paging_common_release.getSourceLoadStates(), insertCachedEvent$paging_common_release.getMediatorLoadStates());
        }
        this.combinedLoadStatesCollection = mutableCombinedLoadStateCollection;
        this.onPagesUpdatedListeners = new CopyOnWriteArrayList<>();
        this.collectFromRunner = new SingleRunner(false, 1, defaultConstructorMarker);
        this.inGetItem = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.loadStateFlow = mutableCombinedLoadStateCollection.getStateFlow();
        this._onPagesUpdatedFlow = SharedFlowKt.MutableSharedFlow(0, 64, BufferOverflow.DROP_OLDEST);
        addOnPagesUpdatedListener(new Function0<Unit>(this) { // from class: androidx.paging.PagingDataPresenter.1
            final /* synthetic */ PagingDataPresenter<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((PagingDataPresenter) this.this$0)._onPagesUpdatedFlow.tryEmit(Unit.INSTANCE);
            }
        });
    }

    public /* synthetic */ PagingDataPresenter(CoroutineContext coroutineContext, PagingData pagingData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dispatchers.getMain() : coroutineContext, (i & 2) != 0 ? null : pagingData);
    }

    /* compiled from: PagingDataPresenter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PagingDataPresenter$collectFrom$2", f = "PagingDataPresenter.kt", l = {121}, m = "invokeSuspend")
    /* renamed from: androidx.paging.PagingDataPresenter$collectFrom$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ PagingData<T> $pagingData;
        int label;
        final /* synthetic */ PagingDataPresenter<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PagingDataPresenter<T> pagingDataPresenter, PagingData<T> pagingData, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.this$0 = pagingDataPresenter;
            this.$pagingData = pagingData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$pagingData, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ((PagingDataPresenter) this.this$0).uiReceiver = this.$pagingData.getUiReceiver();
                Flow<PageEvent<T>> flow$paging_common_release = this.$pagingData.getFlow$paging_common_release();
                final PagingDataPresenter<T> pagingDataPresenter = this.this$0;
                final PagingData<T> pagingData = this.$pagingData;
                FlowCollector<? super PageEvent<T>> flowCollector = new FlowCollector() { // from class: androidx.paging.PagingDataPresenter.collectFrom.2.1
                    public final Object emit(PageEvent<T> pageEvent, Continuation<? super Unit> continuation) {
                        PagingLogger pagingLogger = PagingLogger.INSTANCE;
                        if (pagingLogger.isLoggable(2)) {
                            pagingLogger.log(2, "Collected " + pageEvent, null);
                        }
                        Object objWithContext = BuildersKt.withContext(((PagingDataPresenter) pagingDataPresenter).mainContext, new C00562(pageEvent, pagingDataPresenter, pagingData, null), continuation);
                        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((PageEvent) obj2, (Continuation<? super Unit>) continuation);
                    }

                    /* compiled from: PagingDataPresenter.kt */
                    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.paging.PagingDataPresenter$collectFrom$2$1$2", f = "PagingDataPresenter.kt", l = {141, 158, 170, 173, 225, 228}, m = "invokeSuspend")
                    /* renamed from: androidx.paging.PagingDataPresenter$collectFrom$2$1$2, reason: invalid class name and collision with other inner class name */
                    static final class C00562 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ PageEvent<T> $event;
                        final /* synthetic */ PagingData<T> $pagingData;
                        int label;
                        final /* synthetic */ PagingDataPresenter<T> this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00562(PageEvent<T> pageEvent, PagingDataPresenter<T> pagingDataPresenter, PagingData<T> pagingData, Continuation<? super C00562> continuation) {
                            super(2, continuation);
                            this.$event = pageEvent;
                            this.this$0 = pagingDataPresenter;
                            this.$pagingData = pagingData;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C00562(this.$event, this.this$0, this.$pagingData, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C00562) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:102:0x0289  */
                        /* JADX WARN: Removed duplicated region for block: B:105:0x0299 A[LOOP:0: B:103:0x0293->B:105:0x0299, LOOP_END] */
                        /* JADX WARN: Removed duplicated region for block: B:39:0x0103 A[RETURN] */
                        /* JADX WARN: Removed duplicated region for block: B:42:0x012f  */
                        /* JADX WARN: Removed duplicated region for block: B:43:0x0134  */
                        /* JADX WARN: Removed duplicated region for block: B:45:0x0137  */
                        /* JADX WARN: Removed duplicated region for block: B:80:0x0203  */
                        /* JADX WARN: Removed duplicated region for block: B:91:0x0240 A[RETURN] */
                        /* JADX WARN: Removed duplicated region for block: B:98:0x0281  */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
                            /*
                                Method dump skipped, instructions count: 696
                                To view this dump change 'Code comments level' option to 'DEBUG'
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagingDataPresenter.AnonymousClass2.AnonymousClass1.C00562.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }
                };
                this.label = 1;
                if (flow$paging_common_release.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object collectFrom(PagingData<T> pagingData, Continuation<Unit> continuation) {
        Object objRunInIsolation$default = SingleRunner.runInIsolation$default(this.collectFromRunner, 0, new AnonymousClass2(this, pagingData, null), continuation, 1, null);
        return objRunInIsolation$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunInIsolation$default : Unit.INSTANCE;
    }

    public final T get(int index) {
        Boolean value;
        Boolean value2;
        MutableStateFlow<Boolean> mutableStateFlow = this.inGetItem;
        do {
            value = mutableStateFlow.getValue();
            value.booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, Boolean.TRUE));
        this.lastAccessedIndexUnfulfilled = true;
        this.lastAccessedIndex = index;
        PagingLogger pagingLogger = PagingLogger.INSTANCE;
        if (pagingLogger.isLoggable(2)) {
            pagingLogger.log(2, "Accessing item index[" + index + ']', null);
        }
        HintReceiver hintReceiver = this.hintReceiver;
        if (hintReceiver != null) {
            hintReceiver.accessHint(this.pageStore.accessHintForPresenterIndex(index));
        }
        T t = this.pageStore.get(index);
        MutableStateFlow<Boolean> mutableStateFlow2 = this.inGetItem;
        do {
            value2 = mutableStateFlow2.getValue();
            value2.booleanValue();
        } while (!mutableStateFlow2.compareAndSet(value2, Boolean.FALSE));
        return t;
    }

    public final ItemSnapshotList<T> snapshot() {
        return this.pageStore.snapshot();
    }

    public final int getSize() {
        return this.pageStore.getSize();
    }

    public final StateFlow<CombinedLoadStates> getLoadStateFlow() {
        return this.loadStateFlow;
    }

    public final Flow<Unit> getOnPagesUpdatedFlow() {
        return FlowKt.asSharedFlow(this._onPagesUpdatedFlow);
    }

    public final void addOnPagesUpdatedListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onPagesUpdatedListeners.add(listener);
    }

    public final void addLoadStateListener(Function1<CombinedLoadStates, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.combinedLoadStatesCollection.addListener(listener);
    }

    public final void removeLoadStateListener(Function1<CombinedLoadStates, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.combinedLoadStatesCollection.removeListener(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object presentNewList(java.util.List<androidx.paging.TransformablePage<T>> r8, int r9, int r10, boolean r11, androidx.paging.LoadStates r12, androidx.paging.LoadStates r13, androidx.paging.HintReceiver r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagingDataPresenter.presentNewList(java.util.List, int, int, boolean, androidx.paging.LoadStates, androidx.paging.LoadStates, androidx.paging.HintReceiver, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
