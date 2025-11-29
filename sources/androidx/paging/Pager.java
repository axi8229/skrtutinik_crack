package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: Pager.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001BM\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t¢\u0006\u0004\b\f\u0010\rB7\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t¢\u0006\u0004\b\f\u0010\u000eR)\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00100\u000f8\u0006¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroidx/paging/Pager;", "", "Key", "Value", "Landroidx/paging/PagingConfig;", "config", "initialKey", "Landroidx/paging/RemoteMediator;", "remoteMediator", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "pagingSourceFactory", "<init>", "(Landroidx/paging/PagingConfig;Ljava/lang/Object;Landroidx/paging/RemoteMediator;Lkotlin/jvm/functions/Function0;)V", "(Landroidx/paging/PagingConfig;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "flow", "Lkotlinx/coroutines/flow/Flow;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "getFlow$annotations", "()V", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Pager<Key, Value> {
    private final Flow<PagingData<Value>> flow;

    public Pager(PagingConfig config, Key key, RemoteMediator<Key, Value> remoteMediator, Function0<? extends PagingSource<Key, Value>> pagingSourceFactory) {
        Function1 pager$flow$2;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(pagingSourceFactory, "pagingSourceFactory");
        if (pagingSourceFactory instanceof SuspendingPagingSourceFactory) {
            pager$flow$2 = new Pager$flow$1(pagingSourceFactory);
        } else {
            pager$flow$2 = new Pager$flow$2(pagingSourceFactory, null);
        }
        this.flow = new PageFetcher(pager$flow$2, key, config, remoteMediator).getFlow();
    }

    public /* synthetic */ Pager(PagingConfig pagingConfig, Object obj, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pagingConfig, (i & 2) != 0 ? null : obj, function0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Pager(PagingConfig config, Key key, Function0<? extends PagingSource<Key, Value>> pagingSourceFactory) {
        this(config, key, null, pagingSourceFactory);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(pagingSourceFactory, "pagingSourceFactory");
    }

    public final Flow<PagingData<Value>> getFlow() {
        return this.flow;
    }
}
