package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class J2 extends Z2 {
    public final S6 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J2(S6 helpers) {
        super(0);
        Intrinsics.checkNotNullParameter(helpers, "helpers");
        this.a = helpers;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof J2) && Intrinsics.areEqual(this.a, ((J2) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "HelpersState(helpers=" + this.a + ')';
    }
}
