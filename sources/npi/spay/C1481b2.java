package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.b2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1481b2 extends AbstractC1855q2 {
    public final InterfaceC1812o9 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1481b2(InterfaceC1812o9 mode) {
        super(0);
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.a = mode;
    }

    public final InterfaceC1812o9 a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1481b2) && Intrinsics.areEqual(this.a, ((C1481b2) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "UserProfile(mode=" + this.a + ')';
    }
}
