package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.n9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1787n9 implements InterfaceC1812o9 {
    public C1787n9() {
        C1825om orderScreenMode = C1825om.a;
        Intrinsics.checkNotNullParameter(orderScreenMode, "orderScreenMode");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1787n9)) {
            return false;
        }
        C1825om c1825om = C1825om.a;
        ((C1787n9) obj).getClass();
        return Intrinsics.areEqual(c1825om, c1825om);
    }

    public final int hashCode() {
        return C1825om.a.hashCode();
    }

    public final String toString() {
        return "ReturnOrderScreenType(orderScreenMode=" + C1825om.a + ')';
    }
}
