package com.sputnik.data.repositories.call_history;

import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import com.sputnik.data.api.CallApi;
import com.sputnik.data.entities.call_history.DataCallHistory;
import com.sputnik.data.local.PrefManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallHistoryPageSource.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ#\u0010\t\u001a\u0004\u0018\u00010\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bH\u0016¢\u0006\u0002\u0010\fJ+\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/sputnik/data/repositories/call_history/CallHistoryPageSource;", "Landroidx/paging/PagingSource;", "", "Lcom/sputnik/data/entities/call_history/DataCallHistory;", "callHistoryApi", "Lcom/sputnik/data/api/CallApi;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "(Lcom/sputnik/data/api/CallApi;Lcom/sputnik/data/local/PrefManager;)V", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "load", "Landroidx/paging/PagingSource$LoadResult;", "params", "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CallHistoryPageSource extends PagingSource<Integer, DataCallHistory> {
    private final CallApi callHistoryApi;
    private final PrefManager prefManager;

    /* compiled from: CallHistoryPageSource.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.data.repositories.call_history.CallHistoryPageSource", f = "CallHistoryPageSource.kt", l = {34}, m = "load")
    /* renamed from: com.sputnik.data.repositories.call_history.CallHistoryPageSource$load$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallHistoryPageSource.this.load(null, this);
        }
    }

    public CallHistoryPageSource(CallApi callHistoryApi, PrefManager prefManager) {
        Intrinsics.checkNotNullParameter(callHistoryApi, "callHistoryApi");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        this.callHistoryApi = callHistoryApi;
        this.prefManager = prefManager;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.paging.PagingSource
    public Integer getRefreshKey(PagingState<Integer, DataCallHistory> state) {
        PagingSource.LoadResult.Page<Integer, DataCallHistory> pageClosestPageToPosition;
        int iIntValue;
        Intrinsics.checkNotNullParameter(state, "state");
        Integer anchorPosition = state.getAnchorPosition();
        if (anchorPosition == null || (pageClosestPageToPosition = state.closestPageToPosition(anchorPosition.intValue())) == null) {
            return null;
        }
        Integer prevKey = pageClosestPageToPosition.getPrevKey();
        if (prevKey != null) {
            iIntValue = prevKey.intValue() + 1;
        } else {
            Integer nextKey = pageClosestPageToPosition.getNextKey();
            if (nextKey == null) {
                return null;
            }
            iIntValue = nextKey.intValue() - 1;
        }
        return Integer.valueOf(iIntValue);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // androidx.paging.PagingSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(androidx.paging.PagingSource.LoadParams<java.lang.Integer> r11, kotlin.coroutines.Continuation<? super androidx.paging.PagingSource.LoadResult<java.lang.Integer, com.sputnik.data.entities.call_history.DataCallHistory>> r12) {
        /*
            Method dump skipped, instructions count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sputnik.data.repositories.call_history.CallHistoryPageSource.load(androidx.paging.PagingSource$LoadParams, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
