package sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.viewmodel;

import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.archive.Flussonic;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.archive.DomainArchiveUrls;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArchiveViewModel.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ6\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/viewmodel/ArchiveViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "", "Lcom/sputnik/common/entities/archive/Flussonic;", "flussonicResponse", "Lcom/sputnik/domain/entities/archive/DomainArchiveUrls;", "archive", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;Lcom/sputnik/domain/entities/archive/DomainArchiveUrls;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;Lcom/sputnik/domain/entities/archive/DomainArchiveUrls;)Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/viewmodel/ArchiveViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "Ljava/util/List;", "getFlussonicResponse", "()Ljava/util/List;", "Lcom/sputnik/domain/entities/archive/DomainArchiveUrls;", "getArchive", "()Lcom/sputnik/domain/entities/archive/DomainArchiveUrls;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ArchiveViewState implements VMState {
    private final DomainArchiveUrls archive;
    private final List<Flussonic> flussonicResponse;
    private final Resource.Status serverState;

    public ArchiveViewState() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArchiveViewState copy$default(ArchiveViewState archiveViewState, Resource.Status status, List list, DomainArchiveUrls domainArchiveUrls, int i, Object obj) {
        if ((i & 1) != 0) {
            status = archiveViewState.serverState;
        }
        if ((i & 2) != 0) {
            list = archiveViewState.flussonicResponse;
        }
        if ((i & 4) != 0) {
            domainArchiveUrls = archiveViewState.archive;
        }
        return archiveViewState.copy(status, list, domainArchiveUrls);
    }

    public final ArchiveViewState copy(Resource.Status serverState, List<Flussonic> flussonicResponse, DomainArchiveUrls archive) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(flussonicResponse, "flussonicResponse");
        return new ArchiveViewState(serverState, flussonicResponse, archive);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArchiveViewState)) {
            return false;
        }
        ArchiveViewState archiveViewState = (ArchiveViewState) other;
        return this.serverState == archiveViewState.serverState && Intrinsics.areEqual(this.flussonicResponse, archiveViewState.flussonicResponse) && Intrinsics.areEqual(this.archive, archiveViewState.archive);
    }

    public int hashCode() {
        int iHashCode = ((this.serverState.hashCode() * 31) + this.flussonicResponse.hashCode()) * 31;
        DomainArchiveUrls domainArchiveUrls = this.archive;
        return iHashCode + (domainArchiveUrls == null ? 0 : domainArchiveUrls.hashCode());
    }

    public String toString() {
        return "ArchiveViewState(serverState=" + this.serverState + ", flussonicResponse=" + this.flussonicResponse + ", archive=" + this.archive + ")";
    }

    public ArchiveViewState(Resource.Status serverState, List<Flussonic> flussonicResponse, DomainArchiveUrls domainArchiveUrls) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(flussonicResponse, "flussonicResponse");
        this.serverState = serverState;
        this.flussonicResponse = flussonicResponse;
        this.archive = domainArchiveUrls;
    }

    public /* synthetic */ ArchiveViewState(Resource.Status status, List list, DomainArchiveUrls domainArchiveUrls, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : domainArchiveUrls);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final DomainArchiveUrls getArchive() {
        return this.archive;
    }
}
