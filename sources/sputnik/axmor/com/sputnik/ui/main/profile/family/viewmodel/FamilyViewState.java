package sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel;

import com.sputnik.common.base.VMState;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.entities.family.Family;

/* compiled from: FamilyViewModel.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011Jv\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b!\u0010 R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u001f\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0006¢\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010(\u001a\u0004\b\r\u0010)R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b\u000e\u0010)R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b*\u0010)¨\u0006+"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "resetAddresServerState", "", "Lsputnik/axmor/com/sputnik/entities/family/Family;", "familyList", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "Lcom/sputnik/domain/common/Event;", "", "isDeleted", "isMadeAdmin", "needUpdate", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;Ljava/lang/Exception;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;Ljava/lang/Exception;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;)Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "getResetAddresServerState", "Ljava/util/List;", "getFamilyList", "()Ljava/util/List;", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "Lcom/sputnik/domain/common/Event;", "()Lcom/sputnik/domain/common/Event;", "getNeedUpdate", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FamilyViewState implements VMState {
    private final Exception exception;
    private final List<Family> familyList;
    private final Event<Boolean> isDeleted;
    private final Event<Boolean> isMadeAdmin;
    private final Event<Boolean> needUpdate;
    private final Resource.Status resetAddresServerState;
    private final Resource.Status serverState;

    public FamilyViewState() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ FamilyViewState copy$default(FamilyViewState familyViewState, Resource.Status status, Resource.Status status2, List list, Exception exc, Event event, Event event2, Event event3, int i, Object obj) {
        if ((i & 1) != 0) {
            status = familyViewState.serverState;
        }
        if ((i & 2) != 0) {
            status2 = familyViewState.resetAddresServerState;
        }
        Resource.Status status3 = status2;
        if ((i & 4) != 0) {
            list = familyViewState.familyList;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            exc = familyViewState.exception;
        }
        Exception exc2 = exc;
        if ((i & 16) != 0) {
            event = familyViewState.isDeleted;
        }
        Event event4 = event;
        if ((i & 32) != 0) {
            event2 = familyViewState.isMadeAdmin;
        }
        Event event5 = event2;
        if ((i & 64) != 0) {
            event3 = familyViewState.needUpdate;
        }
        return familyViewState.copy(status, status3, list2, exc2, event4, event5, event3);
    }

    public final FamilyViewState copy(Resource.Status serverState, Resource.Status resetAddresServerState, List<Family> familyList, Exception exception, Event<Boolean> isDeleted, Event<Boolean> isMadeAdmin, Event<Boolean> needUpdate) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(resetAddresServerState, "resetAddresServerState");
        Intrinsics.checkNotNullParameter(familyList, "familyList");
        Intrinsics.checkNotNullParameter(isDeleted, "isDeleted");
        Intrinsics.checkNotNullParameter(isMadeAdmin, "isMadeAdmin");
        Intrinsics.checkNotNullParameter(needUpdate, "needUpdate");
        return new FamilyViewState(serverState, resetAddresServerState, familyList, exception, isDeleted, isMadeAdmin, needUpdate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FamilyViewState)) {
            return false;
        }
        FamilyViewState familyViewState = (FamilyViewState) other;
        return this.serverState == familyViewState.serverState && this.resetAddresServerState == familyViewState.resetAddresServerState && Intrinsics.areEqual(this.familyList, familyViewState.familyList) && Intrinsics.areEqual(this.exception, familyViewState.exception) && Intrinsics.areEqual(this.isDeleted, familyViewState.isDeleted) && Intrinsics.areEqual(this.isMadeAdmin, familyViewState.isMadeAdmin) && Intrinsics.areEqual(this.needUpdate, familyViewState.needUpdate);
    }

    public int hashCode() {
        int iHashCode = ((((this.serverState.hashCode() * 31) + this.resetAddresServerState.hashCode()) * 31) + this.familyList.hashCode()) * 31;
        Exception exc = this.exception;
        return ((((((iHashCode + (exc == null ? 0 : exc.hashCode())) * 31) + this.isDeleted.hashCode()) * 31) + this.isMadeAdmin.hashCode()) * 31) + this.needUpdate.hashCode();
    }

    public String toString() {
        return "FamilyViewState(serverState=" + this.serverState + ", resetAddresServerState=" + this.resetAddresServerState + ", familyList=" + this.familyList + ", exception=" + this.exception + ", isDeleted=" + this.isDeleted + ", isMadeAdmin=" + this.isMadeAdmin + ", needUpdate=" + this.needUpdate + ")";
    }

    public FamilyViewState(Resource.Status serverState, Resource.Status resetAddresServerState, List<Family> familyList, Exception exc, Event<Boolean> isDeleted, Event<Boolean> isMadeAdmin, Event<Boolean> needUpdate) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(resetAddresServerState, "resetAddresServerState");
        Intrinsics.checkNotNullParameter(familyList, "familyList");
        Intrinsics.checkNotNullParameter(isDeleted, "isDeleted");
        Intrinsics.checkNotNullParameter(isMadeAdmin, "isMadeAdmin");
        Intrinsics.checkNotNullParameter(needUpdate, "needUpdate");
        this.serverState = serverState;
        this.resetAddresServerState = resetAddresServerState;
        this.familyList = familyList;
        this.exception = exc;
        this.isDeleted = isDeleted;
        this.isMadeAdmin = isMadeAdmin;
        this.needUpdate = needUpdate;
    }

    public /* synthetic */ FamilyViewState(Resource.Status status, Resource.Status status2, List list, Exception exc, Event event, Event event2, Event event3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? Resource.Status.NONE : status2, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? null : exc, (i & 16) != 0 ? new Event(Boolean.FALSE) : event, (i & 32) != 0 ? new Event(Boolean.FALSE) : event2, (i & 64) != 0 ? new Event(Boolean.FALSE) : event3);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final Resource.Status getResetAddresServerState() {
        return this.resetAddresServerState;
    }

    public final List<Family> getFamilyList() {
        return this.familyList;
    }

    public final Event<Boolean> isDeleted() {
        return this.isDeleted;
    }

    public final Event<Boolean> isMadeAdmin() {
        return this.isMadeAdmin;
    }

    public final Event<Boolean> getNeedUpdate() {
        return this.needUpdate;
    }
}
