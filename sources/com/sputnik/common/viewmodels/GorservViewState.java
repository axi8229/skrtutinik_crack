package com.sputnik.common.viewmodels;

import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.gorserv.GorservCatalog;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.prefs.OnboardingSettings;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GorservViewModel.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJL\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010\u0011R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/sputnik/common/viewmodels/GorservViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "createTicketState", "", "currentPhone", "Lcom/sputnik/domain/entities/prefs/OnboardingSettings$GorservOnboardingSettings;", "gorservOnboardingSettings", "", "Lcom/sputnik/common/entities/gorserv/GorservCatalog;", "catalogs", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Ljava/lang/String;Lcom/sputnik/domain/entities/prefs/OnboardingSettings$GorservOnboardingSettings;Ljava/util/List;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Ljava/lang/String;Lcom/sputnik/domain/entities/prefs/OnboardingSettings$GorservOnboardingSettings;Ljava/util/List;)Lcom/sputnik/common/viewmodels/GorservViewState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "getCreateTicketState", "Ljava/lang/String;", "getCurrentPhone", "Lcom/sputnik/domain/entities/prefs/OnboardingSettings$GorservOnboardingSettings;", "getGorservOnboardingSettings", "()Lcom/sputnik/domain/entities/prefs/OnboardingSettings$GorservOnboardingSettings;", "Ljava/util/List;", "getCatalogs", "()Ljava/util/List;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GorservViewState implements VMState {
    private final List<GorservCatalog> catalogs;
    private final Resource.Status createTicketState;
    private final String currentPhone;
    private final OnboardingSettings.GorservOnboardingSettings gorservOnboardingSettings;
    private final Resource.Status serverState;

    public GorservViewState() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ GorservViewState copy$default(GorservViewState gorservViewState, Resource.Status status, Resource.Status status2, String str, OnboardingSettings.GorservOnboardingSettings gorservOnboardingSettings, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            status = gorservViewState.serverState;
        }
        if ((i & 2) != 0) {
            status2 = gorservViewState.createTicketState;
        }
        Resource.Status status3 = status2;
        if ((i & 4) != 0) {
            str = gorservViewState.currentPhone;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            gorservOnboardingSettings = gorservViewState.gorservOnboardingSettings;
        }
        OnboardingSettings.GorservOnboardingSettings gorservOnboardingSettings2 = gorservOnboardingSettings;
        if ((i & 16) != 0) {
            list = gorservViewState.catalogs;
        }
        return gorservViewState.copy(status, status3, str2, gorservOnboardingSettings2, list);
    }

    public final GorservViewState copy(Resource.Status serverState, Resource.Status createTicketState, String currentPhone, OnboardingSettings.GorservOnboardingSettings gorservOnboardingSettings, List<GorservCatalog> catalogs) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(createTicketState, "createTicketState");
        Intrinsics.checkNotNullParameter(catalogs, "catalogs");
        return new GorservViewState(serverState, createTicketState, currentPhone, gorservOnboardingSettings, catalogs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GorservViewState)) {
            return false;
        }
        GorservViewState gorservViewState = (GorservViewState) other;
        return this.serverState == gorservViewState.serverState && this.createTicketState == gorservViewState.createTicketState && Intrinsics.areEqual(this.currentPhone, gorservViewState.currentPhone) && Intrinsics.areEqual(this.gorservOnboardingSettings, gorservViewState.gorservOnboardingSettings) && Intrinsics.areEqual(this.catalogs, gorservViewState.catalogs);
    }

    public int hashCode() {
        int iHashCode = ((this.serverState.hashCode() * 31) + this.createTicketState.hashCode()) * 31;
        String str = this.currentPhone;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        OnboardingSettings.GorservOnboardingSettings gorservOnboardingSettings = this.gorservOnboardingSettings;
        return ((iHashCode2 + (gorservOnboardingSettings != null ? gorservOnboardingSettings.hashCode() : 0)) * 31) + this.catalogs.hashCode();
    }

    public String toString() {
        return "GorservViewState(serverState=" + this.serverState + ", createTicketState=" + this.createTicketState + ", currentPhone=" + this.currentPhone + ", gorservOnboardingSettings=" + this.gorservOnboardingSettings + ", catalogs=" + this.catalogs + ")";
    }

    public GorservViewState(Resource.Status serverState, Resource.Status createTicketState, String str, OnboardingSettings.GorservOnboardingSettings gorservOnboardingSettings, List<GorservCatalog> catalogs) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(createTicketState, "createTicketState");
        Intrinsics.checkNotNullParameter(catalogs, "catalogs");
        this.serverState = serverState;
        this.createTicketState = createTicketState;
        this.currentPhone = str;
        this.gorservOnboardingSettings = gorservOnboardingSettings;
        this.catalogs = catalogs;
    }

    public /* synthetic */ GorservViewState(Resource.Status status, Resource.Status status2, String str, OnboardingSettings.GorservOnboardingSettings gorservOnboardingSettings, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? Resource.Status.NONE : status2, (i & 4) != 0 ? null : str, (i & 8) == 0 ? gorservOnboardingSettings : null, (i & 16) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final Resource.Status getCreateTicketState() {
        return this.createTicketState;
    }

    public final String getCurrentPhone() {
        return this.currentPhone;
    }

    public final OnboardingSettings.GorservOnboardingSettings getGorservOnboardingSettings() {
        return this.gorservOnboardingSettings;
    }

    public final List<GorservCatalog> getCatalogs() {
        return this.catalogs;
    }
}
