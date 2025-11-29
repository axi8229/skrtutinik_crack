package com.sputnik.common.viewmodels;

import com.sputnik.common.entities.sessions.LocalSession;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginViewModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0003\u0010\u0013R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/sputnik/common/viewmodels/SessionsState;", "", "", "isAddingAccountLocked", "", "Lcom/sputnik/common/entities/sessions/LocalSession;", "accounts", "<init>", "(ZLjava/util/List;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ljava/util/List;", "getAccounts", "()Ljava/util/List;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SessionsState {
    private final List<LocalSession> accounts;
    private final boolean isAddingAccountLocked;

    public SessionsState() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionsState)) {
            return false;
        }
        SessionsState sessionsState = (SessionsState) other;
        return this.isAddingAccountLocked == sessionsState.isAddingAccountLocked && Intrinsics.areEqual(this.accounts, sessionsState.accounts);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.isAddingAccountLocked;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.accounts.hashCode();
    }

    public String toString() {
        return "SessionsState(isAddingAccountLocked=" + this.isAddingAccountLocked + ", accounts=" + this.accounts + ")";
    }

    public SessionsState(boolean z, List<LocalSession> accounts) {
        Intrinsics.checkNotNullParameter(accounts, "accounts");
        this.isAddingAccountLocked = z;
        this.accounts = accounts;
    }

    /* renamed from: isAddingAccountLocked, reason: from getter */
    public final boolean getIsAddingAccountLocked() {
        return this.isAddingAccountLocked;
    }

    public /* synthetic */ SessionsState(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<LocalSession> getAccounts() {
        return this.accounts;
    }
}
