package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.m9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1762m9 implements InterfaceC1812o9 {
    public final S6 a;

    public C1762m9(S6 helpersScreenMode) {
        Intrinsics.checkNotNullParameter(helpersScreenMode, "helpersScreenMode");
        this.a = helpersScreenMode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1762m9) && Intrinsics.areEqual(this.a, ((C1762m9) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ReturnHelpersScreenType(helpersScreenMode=" + this.a + ')';
    }
}
