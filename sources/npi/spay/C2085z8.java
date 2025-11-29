package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.z8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2085z8 {
    public final InterfaceC1850pm a;

    public C2085z8(InterfaceC1850pm mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.a = mode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2085z8) && Intrinsics.areEqual(this.a, ((C2085z8) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "CardSelectionData(mode=" + this.a + ')';
    }
}
