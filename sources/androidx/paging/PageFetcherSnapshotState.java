package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import androidx.paging.PagingSource;
import androidx.paging.ViewportHint;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: PageFetcherSnapshotState.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0001FB\u000f\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000b0/J\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0/J#\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0000¢\u0006\u0002\b5J\u0014\u00106\u001a\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u000109J\u001e\u0010:\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u0001092\u0006\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u0013J\u0015\u0010=\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u0012H\u0000¢\u0006\u0002\b>J,\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u00122\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH\u0007J+\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00010D*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010;\u001a\u00020\u0012H\u0000¢\u0006\u0002\bER \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R&\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t0\u001bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\"R$\u0010#\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\"R\u000e\u0010&\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020(@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0019¨\u0006G"}, d2 = {"Landroidx/paging/PageFetcherSnapshotState;", "Key", "", "Value", "config", "Landroidx/paging/PagingConfig;", "(Landroidx/paging/PagingConfig;)V", "_pages", "", "Landroidx/paging/PagingSource$LoadResult$Page;", "_placeholdersAfter", "", "_placeholdersBefore", "appendGenerationId", "appendGenerationIdCh", "Lkotlinx/coroutines/channels/Channel;", "failedHintsByLoadType", "", "Landroidx/paging/LoadType;", "Landroidx/paging/ViewportHint;", "getFailedHintsByLoadType$paging_common_release", "()Ljava/util/Map;", "<set-?>", "initialPageIndex", "getInitialPageIndex$paging_common_release", "()I", "pages", "", "getPages$paging_common_release", "()Ljava/util/List;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "placeholdersAfter", "getPlaceholdersAfter$paging_common_release", "setPlaceholdersAfter$paging_common_release", "(I)V", "placeholdersBefore", "getPlaceholdersBefore$paging_common_release", "setPlaceholdersBefore$paging_common_release", "prependGenerationId", "prependGenerationIdCh", "Landroidx/paging/MutableLoadStateCollection;", "sourceLoadStates", "getSourceLoadStates$paging_common_release", "()Landroidx/paging/MutableLoadStateCollection;", "storageCount", "getStorageCount$paging_common_release", "consumeAppendGenerationIdAsFlow", "Lkotlinx/coroutines/flow/Flow;", "consumePrependGenerationIdAsFlow", "currentPagingState", "Landroidx/paging/PagingState;", "viewportHint", "Landroidx/paging/ViewportHint$Access;", "currentPagingState$paging_common_release", "drop", "", "event", "Landroidx/paging/PageEvent$Drop;", "dropEventOrNull", "loadType", "hint", "generationId", "generationId$paging_common_release", "insert", "", "loadId", "page", "toPageEvent", "Landroidx/paging/PageEvent;", "toPageEvent$paging_common_release", "Holder", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PageFetcherSnapshotState<Key, Value> {
    private final List<PagingSource.LoadResult.Page<Key, Value>> _pages;
    private int _placeholdersAfter;
    private int _placeholdersBefore;
    private int appendGenerationId;
    private final Channel<Integer> appendGenerationIdCh;
    private final PagingConfig config;
    private final Map<LoadType, ViewportHint> failedHintsByLoadType;
    private int initialPageIndex;
    private final List<PagingSource.LoadResult.Page<Key, Value>> pages;
    private int prependGenerationId;
    private final Channel<Integer> prependGenerationIdCh;
    private MutableLoadStateCollection sourceLoadStates;

    /* compiled from: PageFetcherSnapshotState.kt */
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

    public /* synthetic */ PageFetcherSnapshotState(PagingConfig pagingConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(pagingConfig);
    }

    private PageFetcherSnapshotState(PagingConfig pagingConfig) {
        this.config = pagingConfig;
        ArrayList arrayList = new ArrayList();
        this._pages = arrayList;
        this.pages = arrayList;
        this.prependGenerationIdCh = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.appendGenerationIdCh = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.failedHintsByLoadType = new LinkedHashMap();
        MutableLoadStateCollection mutableLoadStateCollection = new MutableLoadStateCollection();
        mutableLoadStateCollection.set(LoadType.REFRESH, LoadState.Loading.INSTANCE);
        this.sourceLoadStates = mutableLoadStateCollection;
    }

    public final List<PagingSource.LoadResult.Page<Key, Value>> getPages$paging_common_release() {
        return this.pages;
    }

    /* renamed from: getInitialPageIndex$paging_common_release, reason: from getter */
    public final int getInitialPageIndex() {
        return this.initialPageIndex;
    }

    public final int getStorageCount$paging_common_release() {
        Iterator<T> it = this.pages.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((PagingSource.LoadResult.Page) it.next()).getData().size();
        }
        return size;
    }

    public final int getPlaceholdersBefore$paging_common_release() {
        if (this.config.enablePlaceholders) {
            return this._placeholdersBefore;
        }
        return 0;
    }

    public final void setPlaceholdersBefore$paging_common_release(int i) {
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        this._placeholdersBefore = i;
    }

    public final int getPlaceholdersAfter$paging_common_release() {
        if (this.config.enablePlaceholders) {
            return this._placeholdersAfter;
        }
        return 0;
    }

    public final void setPlaceholdersAfter$paging_common_release(int i) {
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        this._placeholdersAfter = i;
    }

    public final int generationId$paging_common_release(LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException("Cannot get loadId for loadType: REFRESH");
        }
        if (i == 2) {
            return this.prependGenerationId;
        }
        if (i == 3) {
            return this.appendGenerationId;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Map<LoadType, ViewportHint> getFailedHintsByLoadType$paging_common_release() {
        return this.failedHintsByLoadType;
    }

    /* renamed from: getSourceLoadStates$paging_common_release, reason: from getter */
    public final MutableLoadStateCollection getSourceLoadStates() {
        return this.sourceLoadStates;
    }

    /* compiled from: PageFetcherSnapshotState.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1", f = "PageFetcherSnapshotState.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.paging.PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1, reason: invalid class name and case insensitive filesystem */
    static final class C04881 extends SuspendLambda implements Function2<FlowCollector<? super Integer>, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PageFetcherSnapshotState<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04881(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, Continuation<? super C04881> continuation) {
            super(2, continuation);
            this.this$0 = pageFetcherSnapshotState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04881(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Integer> flowCollector, Continuation<? super Unit> continuation) {
            return ((C04881) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((PageFetcherSnapshotState) this.this$0).prependGenerationIdCh.mo2240trySendJP2dKIU(Boxing.boxInt(((PageFetcherSnapshotState) this.this$0).prependGenerationId));
            return Unit.INSTANCE;
        }
    }

    public final Flow<Integer> consumePrependGenerationIdAsFlow() {
        return FlowKt.onStart(FlowKt.consumeAsFlow(this.prependGenerationIdCh), new C04881(this, null));
    }

    /* compiled from: PageFetcherSnapshotState.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1", f = "PageFetcherSnapshotState.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.paging.PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Integer>, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PageFetcherSnapshotState<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = pageFetcherSnapshotState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Integer> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((PageFetcherSnapshotState) this.this$0).appendGenerationIdCh.mo2240trySendJP2dKIU(Boxing.boxInt(((PageFetcherSnapshotState) this.this$0).appendGenerationId));
            return Unit.INSTANCE;
        }
    }

    public final Flow<Integer> consumeAppendGenerationIdAsFlow() {
        return FlowKt.onStart(FlowKt.consumeAsFlow(this.appendGenerationIdCh), new AnonymousClass1(this, null));
    }

    public final PageEvent<Value> toPageEvent$paging_common_release(PagingSource.LoadResult.Page<Key, Value> page, LoadType loadType) {
        Intrinsics.checkNotNullParameter(page, "<this>");
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i = iArr[loadType.ordinal()];
        int size = 0;
        if (i != 1) {
            if (i == 2) {
                size = 0 - this.initialPageIndex;
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                size = (this.pages.size() - this.initialPageIndex) - 1;
            }
        }
        List listListOf = CollectionsKt.listOf(new TransformablePage(size, page.getData()));
        int i2 = iArr[loadType.ordinal()];
        if (i2 == 1) {
            return PageEvent.Insert.INSTANCE.Refresh(listListOf, getPlaceholdersBefore$paging_common_release(), getPlaceholdersAfter$paging_common_release(), this.sourceLoadStates.snapshot(), null);
        }
        if (i2 == 2) {
            return PageEvent.Insert.INSTANCE.Prepend(listListOf, getPlaceholdersBefore$paging_common_release(), this.sourceLoadStates.snapshot(), null);
        }
        if (i2 == 3) {
            return PageEvent.Insert.INSTANCE.Append(listListOf, getPlaceholdersAfter$paging_common_release(), this.sourceLoadStates.snapshot(), null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean insert(int loadId, LoadType loadType, PagingSource.LoadResult.Page<Key, Value> page) {
        int itemsBefore;
        int itemsAfter;
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(page, "page");
        int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    if (this.pages.isEmpty()) {
                        throw new IllegalStateException("should've received an init before append");
                    }
                    if (loadId != this.appendGenerationId) {
                        return false;
                    }
                    this._pages.add(page);
                    if (page.getItemsAfter() == Integer.MIN_VALUE) {
                        itemsAfter = RangesKt.coerceAtLeast(getPlaceholdersAfter$paging_common_release() - page.getData().size(), 0);
                    } else {
                        itemsAfter = page.getItemsAfter();
                    }
                    setPlaceholdersAfter$paging_common_release(itemsAfter);
                    this.failedHintsByLoadType.remove(LoadType.APPEND);
                }
            } else {
                if (this.pages.isEmpty()) {
                    throw new IllegalStateException("should've received an init before prepend");
                }
                if (loadId != this.prependGenerationId) {
                    return false;
                }
                this._pages.add(0, page);
                this.initialPageIndex++;
                if (page.getItemsBefore() == Integer.MIN_VALUE) {
                    itemsBefore = RangesKt.coerceAtLeast(getPlaceholdersBefore$paging_common_release() - page.getData().size(), 0);
                } else {
                    itemsBefore = page.getItemsBefore();
                }
                setPlaceholdersBefore$paging_common_release(itemsBefore);
                this.failedHintsByLoadType.remove(LoadType.PREPEND);
            }
        } else {
            if (!this.pages.isEmpty()) {
                throw new IllegalStateException("cannot receive multiple init calls");
            }
            if (loadId != 0) {
                throw new IllegalStateException("init loadId must be the initial value, 0");
            }
            this._pages.add(page);
            this.initialPageIndex = 0;
            setPlaceholdersAfter$paging_common_release(page.getItemsAfter());
            setPlaceholdersBefore$paging_common_release(page.getItemsBefore());
        }
        return true;
    }

    public final void drop(PageEvent.Drop<Value> event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getPageCount() > this.pages.size()) {
            throw new IllegalStateException(("invalid drop count. have " + this.pages.size() + " but wanted to drop " + event.getPageCount()).toString());
        }
        this.failedHintsByLoadType.remove(event.getLoadType());
        this.sourceLoadStates.set(event.getLoadType(), LoadState.NotLoading.INSTANCE.getIncomplete$paging_common_release());
        int i = WhenMappings.$EnumSwitchMapping$0[event.getLoadType().ordinal()];
        if (i == 2) {
            int pageCount = event.getPageCount();
            for (int i2 = 0; i2 < pageCount; i2++) {
                this._pages.remove(0);
            }
            this.initialPageIndex -= event.getPageCount();
            setPlaceholdersBefore$paging_common_release(event.getPlaceholdersRemaining());
            int i3 = this.prependGenerationId + 1;
            this.prependGenerationId = i3;
            this.prependGenerationIdCh.mo2240trySendJP2dKIU(Integer.valueOf(i3));
            return;
        }
        if (i == 3) {
            int pageCount2 = event.getPageCount();
            for (int i4 = 0; i4 < pageCount2; i4++) {
                this._pages.remove(this.pages.size() - 1);
            }
            setPlaceholdersAfter$paging_common_release(event.getPlaceholdersRemaining());
            int i5 = this.appendGenerationId + 1;
            this.appendGenerationId = i5;
            this.appendGenerationIdCh.mo2240trySendJP2dKIU(Integer.valueOf(i5));
            return;
        }
        throw new IllegalArgumentException("cannot drop " + event.getLoadType());
    }

    public final PageEvent.Drop<Value> dropEventOrNull(LoadType loadType, ViewportHint hint) {
        int lastIndex;
        int lastIndex2;
        int size;
        int presentedItemsAfter;
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(hint, "hint");
        PageEvent.Drop<Value> drop = null;
        if (this.config.maxSize == Integer.MAX_VALUE || this.pages.size() <= 2 || getStorageCount$paging_common_release() <= this.config.maxSize) {
            return null;
        }
        if (loadType == LoadType.REFRESH) {
            throw new IllegalArgumentException(("Drop LoadType must be PREPEND or APPEND, but got " + loadType).toString());
        }
        int placeholdersBefore$paging_common_release = 0;
        int i = 0;
        int i2 = 0;
        while (i < this.pages.size() && getStorageCount$paging_common_release() - i2 > this.config.maxSize) {
            int[] iArr = WhenMappings.$EnumSwitchMapping$0;
            if (iArr[loadType.ordinal()] == 2) {
                size = this.pages.get(i).getData().size();
            } else {
                List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
                size = list.get(CollectionsKt.getLastIndex(list) - i).getData().size();
            }
            if (iArr[loadType.ordinal()] == 2) {
                presentedItemsAfter = hint.getPresentedItemsBefore();
            } else {
                presentedItemsAfter = hint.getPresentedItemsAfter();
            }
            if ((presentedItemsAfter - i2) - size < this.config.prefetchDistance) {
                break;
            }
            i2 += size;
            i++;
        }
        if (i != 0) {
            int[] iArr2 = WhenMappings.$EnumSwitchMapping$0;
            if (iArr2[loadType.ordinal()] == 2) {
                lastIndex = -this.initialPageIndex;
            } else {
                lastIndex = (CollectionsKt.getLastIndex(this.pages) - this.initialPageIndex) - (i - 1);
            }
            if (iArr2[loadType.ordinal()] == 2) {
                lastIndex2 = (i - 1) - this.initialPageIndex;
            } else {
                lastIndex2 = CollectionsKt.getLastIndex(this.pages) - this.initialPageIndex;
            }
            if (this.config.enablePlaceholders) {
                placeholdersBefore$paging_common_release = (loadType == LoadType.PREPEND ? getPlaceholdersBefore$paging_common_release() : getPlaceholdersAfter$paging_common_release()) + i2;
            }
            drop = new PageEvent.Drop<>(loadType, lastIndex, lastIndex2, placeholdersBefore$paging_common_release);
        }
        return drop;
    }

    public final PagingState<Key, Value> currentPagingState$paging_common_release(ViewportHint.Access viewportHint) {
        Integer numValueOf;
        int size;
        List list = CollectionsKt.toList(this.pages);
        if (viewportHint != null) {
            int placeholdersBefore$paging_common_release = getPlaceholdersBefore$paging_common_release();
            int i = -this.initialPageIndex;
            int lastIndex = CollectionsKt.getLastIndex(this.pages) - this.initialPageIndex;
            int pageOffset = viewportHint.getPageOffset();
            for (int i2 = i; i2 < pageOffset; i2++) {
                if (i2 > lastIndex) {
                    size = this.config.pageSize;
                } else {
                    size = this.pages.get(this.initialPageIndex + i2).getData().size();
                }
                placeholdersBefore$paging_common_release += size;
            }
            int indexInPage = placeholdersBefore$paging_common_release + viewportHint.getIndexInPage();
            if (viewportHint.getPageOffset() < i) {
                indexInPage -= this.config.pageSize;
            }
            numValueOf = Integer.valueOf(indexInPage);
        } else {
            numValueOf = null;
        }
        return new PagingState<>(list, numValueOf, this.config, getPlaceholdersBefore$paging_common_release());
    }

    /* compiled from: PageFetcherSnapshotState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/paging/PageFetcherSnapshotState$Holder;", "", "Key", "Value", "Landroidx/paging/PagingConfig;", "config", "<init>", "(Landroidx/paging/PagingConfig;)V", "Landroidx/paging/PagingConfig;", "Lkotlinx/coroutines/sync/Mutex;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "Landroidx/paging/PageFetcherSnapshotState;", "state", "Landroidx/paging/PageFetcherSnapshotState;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Holder<Key, Value> {
        private final PagingConfig config;
        private final Mutex lock;
        private final PageFetcherSnapshotState<Key, Value> state;

        public Holder(PagingConfig config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.config = config;
            this.lock = MutexKt.Mutex$default(false, 1, null);
            this.state = new PageFetcherSnapshotState<>(config, null);
        }
    }
}
