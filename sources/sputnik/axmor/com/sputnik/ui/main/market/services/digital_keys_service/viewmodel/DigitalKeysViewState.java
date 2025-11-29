package sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.viewmodel;

import com.sputnik.common.base.VMState;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.entities.digital_keys.DigitalKey;

/* compiled from: DigitalKeysViewModel.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\f\u0010\rJb\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b \u0010\u001fR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\t\u0010\"R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\n\u0010\"R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b\u000b\u0010\"¨\u0006#"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/services/digital_keys_service/viewmodel/DigitalKeysViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "Lsputnik/axmor/com/sputnik/entities/digital_keys/DigitalKey;", "tempCode", "permCode", "Lcom/sputnik/domain/common/Event;", "", "isUpdateTemp", "isUpdatePerm", "isDeleteTemp", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lsputnik/axmor/com/sputnik/entities/digital_keys/DigitalKey;Lsputnik/axmor/com/sputnik/entities/digital_keys/DigitalKey;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lsputnik/axmor/com/sputnik/entities/digital_keys/DigitalKey;Lsputnik/axmor/com/sputnik/entities/digital_keys/DigitalKey;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;)Lsputnik/axmor/com/sputnik/ui/main/market/services/digital_keys_service/viewmodel/DigitalKeysViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "Lsputnik/axmor/com/sputnik/entities/digital_keys/DigitalKey;", "getTempCode", "()Lsputnik/axmor/com/sputnik/entities/digital_keys/DigitalKey;", "getPermCode", "Lcom/sputnik/domain/common/Event;", "()Lcom/sputnik/domain/common/Event;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DigitalKeysViewState implements VMState {
    private final Event<Boolean> isDeleteTemp;
    private final Event<Boolean> isUpdatePerm;
    private final Event<Boolean> isUpdateTemp;
    private final DigitalKey permCode;
    private final Resource.Status serverState;
    private final DigitalKey tempCode;

    public DigitalKeysViewState() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ DigitalKeysViewState copy$default(DigitalKeysViewState digitalKeysViewState, Resource.Status status, DigitalKey digitalKey, DigitalKey digitalKey2, Event event, Event event2, Event event3, int i, Object obj) {
        if ((i & 1) != 0) {
            status = digitalKeysViewState.serverState;
        }
        if ((i & 2) != 0) {
            digitalKey = digitalKeysViewState.tempCode;
        }
        DigitalKey digitalKey3 = digitalKey;
        if ((i & 4) != 0) {
            digitalKey2 = digitalKeysViewState.permCode;
        }
        DigitalKey digitalKey4 = digitalKey2;
        if ((i & 8) != 0) {
            event = digitalKeysViewState.isUpdateTemp;
        }
        Event event4 = event;
        if ((i & 16) != 0) {
            event2 = digitalKeysViewState.isUpdatePerm;
        }
        Event event5 = event2;
        if ((i & 32) != 0) {
            event3 = digitalKeysViewState.isDeleteTemp;
        }
        return digitalKeysViewState.copy(status, digitalKey3, digitalKey4, event4, event5, event3);
    }

    public final DigitalKeysViewState copy(Resource.Status serverState, DigitalKey tempCode, DigitalKey permCode, Event<Boolean> isUpdateTemp, Event<Boolean> isUpdatePerm, Event<Boolean> isDeleteTemp) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(isUpdateTemp, "isUpdateTemp");
        Intrinsics.checkNotNullParameter(isUpdatePerm, "isUpdatePerm");
        Intrinsics.checkNotNullParameter(isDeleteTemp, "isDeleteTemp");
        return new DigitalKeysViewState(serverState, tempCode, permCode, isUpdateTemp, isUpdatePerm, isDeleteTemp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DigitalKeysViewState)) {
            return false;
        }
        DigitalKeysViewState digitalKeysViewState = (DigitalKeysViewState) other;
        return this.serverState == digitalKeysViewState.serverState && Intrinsics.areEqual(this.tempCode, digitalKeysViewState.tempCode) && Intrinsics.areEqual(this.permCode, digitalKeysViewState.permCode) && Intrinsics.areEqual(this.isUpdateTemp, digitalKeysViewState.isUpdateTemp) && Intrinsics.areEqual(this.isUpdatePerm, digitalKeysViewState.isUpdatePerm) && Intrinsics.areEqual(this.isDeleteTemp, digitalKeysViewState.isDeleteTemp);
    }

    public int hashCode() {
        int iHashCode = this.serverState.hashCode() * 31;
        DigitalKey digitalKey = this.tempCode;
        int iHashCode2 = (iHashCode + (digitalKey == null ? 0 : digitalKey.hashCode())) * 31;
        DigitalKey digitalKey2 = this.permCode;
        return ((((((iHashCode2 + (digitalKey2 != null ? digitalKey2.hashCode() : 0)) * 31) + this.isUpdateTemp.hashCode()) * 31) + this.isUpdatePerm.hashCode()) * 31) + this.isDeleteTemp.hashCode();
    }

    public String toString() {
        return "DigitalKeysViewState(serverState=" + this.serverState + ", tempCode=" + this.tempCode + ", permCode=" + this.permCode + ", isUpdateTemp=" + this.isUpdateTemp + ", isUpdatePerm=" + this.isUpdatePerm + ", isDeleteTemp=" + this.isDeleteTemp + ")";
    }

    public DigitalKeysViewState(Resource.Status serverState, DigitalKey digitalKey, DigitalKey digitalKey2, Event<Boolean> isUpdateTemp, Event<Boolean> isUpdatePerm, Event<Boolean> isDeleteTemp) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(isUpdateTemp, "isUpdateTemp");
        Intrinsics.checkNotNullParameter(isUpdatePerm, "isUpdatePerm");
        Intrinsics.checkNotNullParameter(isDeleteTemp, "isDeleteTemp");
        this.serverState = serverState;
        this.tempCode = digitalKey;
        this.permCode = digitalKey2;
        this.isUpdateTemp = isUpdateTemp;
        this.isUpdatePerm = isUpdatePerm;
        this.isDeleteTemp = isDeleteTemp;
    }

    public /* synthetic */ DigitalKeysViewState(Resource.Status status, DigitalKey digitalKey, DigitalKey digitalKey2, Event event, Event event2, Event event3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.LOADING : status, (i & 2) != 0 ? null : digitalKey, (i & 4) == 0 ? digitalKey2 : null, (i & 8) != 0 ? new Event(Boolean.FALSE) : event, (i & 16) != 0 ? new Event(Boolean.FALSE) : event2, (i & 32) != 0 ? new Event(Boolean.FALSE) : event3);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final DigitalKey getTempCode() {
        return this.tempCode;
    }

    public final DigitalKey getPermCode() {
        return this.permCode;
    }
}
