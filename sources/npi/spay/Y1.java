package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Y1 extends AbstractC1855q2 {
    public final S6 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y1(S6 helpers) {
        super(0);
        Intrinsics.checkNotNullParameter(helpers, "helpers");
        this.a = helpers;
    }

    public final S6 a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Y1) && Intrinsics.areEqual(this.a, ((Y1) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "HelpersState(helpers=" + this.a + ')';
    }
}
