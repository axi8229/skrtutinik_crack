package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Bn extends co {
    public final InterfaceC1812o9 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Bn(InterfaceC1812o9 mode) {
        super(0);
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.a = mode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Bn) && Intrinsics.areEqual(this.a, ((Bn) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ShowUserProfile(mode=" + this.a + ')';
    }
}
