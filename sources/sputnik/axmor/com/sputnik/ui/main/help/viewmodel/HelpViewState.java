package sputnik.axmor.com.sputnik.ui.main.help.viewmodel;

import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.help.Announce;
import com.sputnik.common.entities.help.CompanyContacts;
import com.sputnik.domain.common.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.entities.company.Company;

/* compiled from: HelpViewModel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJL\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/help/viewmodel/HelpViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "companyContactsServerState", "", "Lsputnik/axmor/com/sputnik/entities/company/Company;", "companiesList", "Lcom/sputnik/common/entities/help/Announce;", "announce", "Lcom/sputnik/common/entities/help/CompanyContacts;", "companyContacts", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;Lcom/sputnik/common/entities/help/Announce;Lcom/sputnik/common/entities/help/CompanyContacts;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;Lcom/sputnik/common/entities/help/Announce;Lcom/sputnik/common/entities/help/CompanyContacts;)Lsputnik/axmor/com/sputnik/ui/main/help/viewmodel/HelpViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "getCompanyContactsServerState", "Ljava/util/List;", "getCompaniesList", "()Ljava/util/List;", "Lcom/sputnik/common/entities/help/Announce;", "getAnnounce", "()Lcom/sputnik/common/entities/help/Announce;", "Lcom/sputnik/common/entities/help/CompanyContacts;", "getCompanyContacts", "()Lcom/sputnik/common/entities/help/CompanyContacts;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class HelpViewState implements VMState {
    private final Announce announce;
    private final List<Company> companiesList;
    private final CompanyContacts companyContacts;
    private final Resource.Status companyContactsServerState;
    private final Resource.Status serverState;

    public HelpViewState() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ HelpViewState copy$default(HelpViewState helpViewState, Resource.Status status, Resource.Status status2, List list, Announce announce, CompanyContacts companyContacts, int i, Object obj) {
        if ((i & 1) != 0) {
            status = helpViewState.serverState;
        }
        if ((i & 2) != 0) {
            status2 = helpViewState.companyContactsServerState;
        }
        Resource.Status status3 = status2;
        if ((i & 4) != 0) {
            list = helpViewState.companiesList;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            announce = helpViewState.announce;
        }
        Announce announce2 = announce;
        if ((i & 16) != 0) {
            companyContacts = helpViewState.companyContacts;
        }
        return helpViewState.copy(status, status3, list2, announce2, companyContacts);
    }

    public final HelpViewState copy(Resource.Status serverState, Resource.Status companyContactsServerState, List<Company> companiesList, Announce announce, CompanyContacts companyContacts) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(companyContactsServerState, "companyContactsServerState");
        Intrinsics.checkNotNullParameter(companiesList, "companiesList");
        return new HelpViewState(serverState, companyContactsServerState, companiesList, announce, companyContacts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HelpViewState)) {
            return false;
        }
        HelpViewState helpViewState = (HelpViewState) other;
        return this.serverState == helpViewState.serverState && this.companyContactsServerState == helpViewState.companyContactsServerState && Intrinsics.areEqual(this.companiesList, helpViewState.companiesList) && Intrinsics.areEqual(this.announce, helpViewState.announce) && Intrinsics.areEqual(this.companyContacts, helpViewState.companyContacts);
    }

    public int hashCode() {
        int iHashCode = ((((this.serverState.hashCode() * 31) + this.companyContactsServerState.hashCode()) * 31) + this.companiesList.hashCode()) * 31;
        Announce announce = this.announce;
        int iHashCode2 = (iHashCode + (announce == null ? 0 : announce.hashCode())) * 31;
        CompanyContacts companyContacts = this.companyContacts;
        return iHashCode2 + (companyContacts != null ? companyContacts.hashCode() : 0);
    }

    public String toString() {
        return "HelpViewState(serverState=" + this.serverState + ", companyContactsServerState=" + this.companyContactsServerState + ", companiesList=" + this.companiesList + ", announce=" + this.announce + ", companyContacts=" + this.companyContacts + ")";
    }

    public HelpViewState(Resource.Status serverState, Resource.Status companyContactsServerState, List<Company> companiesList, Announce announce, CompanyContacts companyContacts) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(companyContactsServerState, "companyContactsServerState");
        Intrinsics.checkNotNullParameter(companiesList, "companiesList");
        this.serverState = serverState;
        this.companyContactsServerState = companyContactsServerState;
        this.companiesList = companiesList;
        this.announce = announce;
        this.companyContacts = companyContacts;
    }

    public /* synthetic */ HelpViewState(Resource.Status status, Resource.Status status2, List list, Announce announce, CompanyContacts companyContacts, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? Resource.Status.NONE : status2, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? null : announce, (i & 16) != 0 ? null : companyContacts);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final Resource.Status getCompanyContactsServerState() {
        return this.companyContactsServerState;
    }

    public final List<Company> getCompaniesList() {
        return this.companiesList;
    }

    public final Announce getAnnounce() {
        return this.announce;
    }

    public final CompanyContacts getCompanyContacts() {
        return this.companyContacts;
    }
}
