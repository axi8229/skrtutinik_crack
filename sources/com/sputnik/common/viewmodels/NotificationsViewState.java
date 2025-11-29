package com.sputnik.common.viewmodels;

import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.notifications.Notification;
import com.sputnik.domain.common.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationsViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ4\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/sputnik/common/viewmodels/NotificationsViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "", "Lcom/sputnik/common/entities/notifications/Notification;", "notifications", "", "needToShowOnboarding", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;Z)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;Z)Lcom/sputnik/common/viewmodels/NotificationsViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "Ljava/util/List;", "getNotifications", "()Ljava/util/List;", "Z", "getNeedToShowOnboarding", "()Z", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class NotificationsViewState implements VMState {
    private final boolean needToShowOnboarding;
    private final List<Notification> notifications;
    private final Resource.Status serverState;

    public NotificationsViewState() {
        this(null, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NotificationsViewState copy$default(NotificationsViewState notificationsViewState, Resource.Status status, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            status = notificationsViewState.serverState;
        }
        if ((i & 2) != 0) {
            list = notificationsViewState.notifications;
        }
        if ((i & 4) != 0) {
            z = notificationsViewState.needToShowOnboarding;
        }
        return notificationsViewState.copy(status, list, z);
    }

    public final NotificationsViewState copy(Resource.Status serverState, List<Notification> notifications, boolean needToShowOnboarding) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(notifications, "notifications");
        return new NotificationsViewState(serverState, notifications, needToShowOnboarding);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationsViewState)) {
            return false;
        }
        NotificationsViewState notificationsViewState = (NotificationsViewState) other;
        return this.serverState == notificationsViewState.serverState && Intrinsics.areEqual(this.notifications, notificationsViewState.notifications) && this.needToShowOnboarding == notificationsViewState.needToShowOnboarding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((this.serverState.hashCode() * 31) + this.notifications.hashCode()) * 31;
        boolean z = this.needToShowOnboarding;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        return "NotificationsViewState(serverState=" + this.serverState + ", notifications=" + this.notifications + ", needToShowOnboarding=" + this.needToShowOnboarding + ")";
    }

    public NotificationsViewState(Resource.Status serverState, List<Notification> notifications, boolean z) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(notifications, "notifications");
        this.serverState = serverState;
        this.notifications = notifications;
        this.needToShowOnboarding = z;
    }

    public /* synthetic */ NotificationsViewState(Resource.Status status, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? false : z);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final List<Notification> getNotifications() {
        return this.notifications;
    }

    public final boolean getNeedToShowOnboarding() {
        return this.needToShowOnboarding;
    }
}
