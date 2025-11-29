package sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.viewmodel;

import com.sputnik.common.base.VMState;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FrServiceViewModel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\nJJ\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001e\u0010\u001c¨\u0006\u001f"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/viewmodel/FrServiceViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverStatus", "Lcom/sputnik/domain/common/Event;", "", "dataIsUpdated", "dataIsError", "handleData", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;)Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/viewmodel/FrServiceViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerStatus", "()Lcom/sputnik/domain/common/Resource$Status;", "Lcom/sputnik/domain/common/Event;", "getDataIsUpdated", "()Lcom/sputnik/domain/common/Event;", "getDataIsError", "getHandleData", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FrServiceViewState implements VMState {
    private final Event<Boolean> dataIsError;
    private final Event<Boolean> dataIsUpdated;
    private final Event<Boolean> handleData;
    private final Resource.Status serverStatus;

    public FrServiceViewState() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FrServiceViewState copy$default(FrServiceViewState frServiceViewState, Resource.Status status, Event event, Event event2, Event event3, int i, Object obj) {
        if ((i & 1) != 0) {
            status = frServiceViewState.serverStatus;
        }
        if ((i & 2) != 0) {
            event = frServiceViewState.dataIsUpdated;
        }
        if ((i & 4) != 0) {
            event2 = frServiceViewState.dataIsError;
        }
        if ((i & 8) != 0) {
            event3 = frServiceViewState.handleData;
        }
        return frServiceViewState.copy(status, event, event2, event3);
    }

    public final FrServiceViewState copy(Resource.Status serverStatus, Event<Boolean> dataIsUpdated, Event<Boolean> dataIsError, Event<Boolean> handleData) {
        Intrinsics.checkNotNullParameter(serverStatus, "serverStatus");
        Intrinsics.checkNotNullParameter(dataIsUpdated, "dataIsUpdated");
        Intrinsics.checkNotNullParameter(dataIsError, "dataIsError");
        Intrinsics.checkNotNullParameter(handleData, "handleData");
        return new FrServiceViewState(serverStatus, dataIsUpdated, dataIsError, handleData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FrServiceViewState)) {
            return false;
        }
        FrServiceViewState frServiceViewState = (FrServiceViewState) other;
        return this.serverStatus == frServiceViewState.serverStatus && Intrinsics.areEqual(this.dataIsUpdated, frServiceViewState.dataIsUpdated) && Intrinsics.areEqual(this.dataIsError, frServiceViewState.dataIsError) && Intrinsics.areEqual(this.handleData, frServiceViewState.handleData);
    }

    public int hashCode() {
        return (((((this.serverStatus.hashCode() * 31) + this.dataIsUpdated.hashCode()) * 31) + this.dataIsError.hashCode()) * 31) + this.handleData.hashCode();
    }

    public String toString() {
        return "FrServiceViewState(serverStatus=" + this.serverStatus + ", dataIsUpdated=" + this.dataIsUpdated + ", dataIsError=" + this.dataIsError + ", handleData=" + this.handleData + ")";
    }

    public FrServiceViewState(Resource.Status serverStatus, Event<Boolean> dataIsUpdated, Event<Boolean> dataIsError, Event<Boolean> handleData) {
        Intrinsics.checkNotNullParameter(serverStatus, "serverStatus");
        Intrinsics.checkNotNullParameter(dataIsUpdated, "dataIsUpdated");
        Intrinsics.checkNotNullParameter(dataIsError, "dataIsError");
        Intrinsics.checkNotNullParameter(handleData, "handleData");
        this.serverStatus = serverStatus;
        this.dataIsUpdated = dataIsUpdated;
        this.dataIsError = dataIsError;
        this.handleData = handleData;
    }

    public /* synthetic */ FrServiceViewState(Resource.Status status, Event event, Event event2, Event event3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? new Event(Boolean.FALSE) : event, (i & 4) != 0 ? new Event(Boolean.FALSE) : event2, (i & 8) != 0 ? new Event(Boolean.FALSE) : event3);
    }

    public final Resource.Status getServerStatus() {
        return this.serverStatus;
    }

    public final Event<Boolean> getDataIsUpdated() {
        return this.dataIsUpdated;
    }

    public final Event<Boolean> getDataIsError() {
        return this.dataIsError;
    }

    public final Event<Boolean> getHandleData() {
        return this.handleData;
    }
}
