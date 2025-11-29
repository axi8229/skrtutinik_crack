package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.n6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1784n6 {
    public final Z2 a;

    public C1784n6(Z2 state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.a = state;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1784n6) && Intrinsics.areEqual(this.a, ((C1784n6) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "SheetState(state=" + this.a + ')';
    }
}
