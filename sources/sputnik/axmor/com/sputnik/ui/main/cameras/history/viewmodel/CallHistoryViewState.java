package sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel;

import androidx.paging.PagingData;
import com.sputnik.common.base.VMState;
import com.sputnik.domain.common.Resource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import sputnik.axmor.com.sputnik.entities.call_history.CallHistoryUi;

/* compiled from: CallHistoryViewModel.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ<\u0010\f\u001a\u00020\u00002\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R%\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/history/viewmodel/CallHistoryViewState;", "Lcom/sputnik/common/base/VMState;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi;", "callHistoryList", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "", "promoAvailable", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lcom/sputnik/domain/common/Resource$Status;Z)V", "copy", "(Lkotlinx/coroutines/flow/Flow;Lcom/sputnik/domain/common/Resource$Status;Z)Lsputnik/axmor/com/sputnik/ui/main/cameras/history/viewmodel/CallHistoryViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/flow/Flow;", "getCallHistoryList", "()Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "Z", "getPromoAvailable", "()Z", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CallHistoryViewState implements VMState {
    private final Flow<PagingData<CallHistoryUi>> callHistoryList;
    private final boolean promoAvailable;
    private final Resource.Status serverState;

    public CallHistoryViewState() {
        this(null, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallHistoryViewState copy$default(CallHistoryViewState callHistoryViewState, Flow flow, Resource.Status status, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            flow = callHistoryViewState.callHistoryList;
        }
        if ((i & 2) != 0) {
            status = callHistoryViewState.serverState;
        }
        if ((i & 4) != 0) {
            z = callHistoryViewState.promoAvailable;
        }
        return callHistoryViewState.copy(flow, status, z);
    }

    public final CallHistoryViewState copy(Flow<PagingData<CallHistoryUi>> callHistoryList, Resource.Status serverState, boolean promoAvailable) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        return new CallHistoryViewState(callHistoryList, serverState, promoAvailable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallHistoryViewState)) {
            return false;
        }
        CallHistoryViewState callHistoryViewState = (CallHistoryViewState) other;
        return Intrinsics.areEqual(this.callHistoryList, callHistoryViewState.callHistoryList) && this.serverState == callHistoryViewState.serverState && this.promoAvailable == callHistoryViewState.promoAvailable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Flow<PagingData<CallHistoryUi>> flow = this.callHistoryList;
        int iHashCode = (((flow == null ? 0 : flow.hashCode()) * 31) + this.serverState.hashCode()) * 31;
        boolean z = this.promoAvailable;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        return "CallHistoryViewState(callHistoryList=" + this.callHistoryList + ", serverState=" + this.serverState + ", promoAvailable=" + this.promoAvailable + ")";
    }

    public CallHistoryViewState(Flow<PagingData<CallHistoryUi>> flow, Resource.Status serverState, boolean z) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        this.callHistoryList = flow;
        this.serverState = serverState;
        this.promoAvailable = z;
    }

    public final Flow<PagingData<CallHistoryUi>> getCallHistoryList() {
        return this.callHistoryList;
    }

    public /* synthetic */ CallHistoryViewState(Flow flow, Resource.Status status, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : flow, (i & 2) != 0 ? Resource.Status.NONE : status, (i & 4) != 0 ? false : z);
    }

    public final boolean getPromoAvailable() {
        return this.promoAvailable;
    }
}
