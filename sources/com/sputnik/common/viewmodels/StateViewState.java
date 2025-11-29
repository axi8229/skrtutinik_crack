package com.sputnik.common.viewmodels;

import com.sputnik.common.base.VMState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StateViewModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0003\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/sputnik/common/viewmodels/StateViewState;", "Lcom/sputnik/common/base/VMState;", "", "isVpnEnabled", "<init>", "(Z)V", "copy", "(Z)Lcom/sputnik/common/viewmodels/StateViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class StateViewState implements VMState {
    private final boolean isVpnEnabled;

    public StateViewState() {
        this(false, 1, null);
    }

    public final StateViewState copy(boolean isVpnEnabled) {
        return new StateViewState(isVpnEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StateViewState) && this.isVpnEnabled == ((StateViewState) other).isVpnEnabled;
    }

    public int hashCode() {
        boolean z = this.isVpnEnabled;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "StateViewState(isVpnEnabled=" + this.isVpnEnabled + ")";
    }

    public StateViewState(boolean z) {
        this.isVpnEnabled = z;
    }

    public /* synthetic */ StateViewState(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    /* renamed from: isVpnEnabled, reason: from getter */
    public final boolean getIsVpnEnabled() {
        return this.isVpnEnabled;
    }
}
