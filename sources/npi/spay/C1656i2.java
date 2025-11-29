package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.i2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1656i2 extends AbstractC1855q2 {
    public final AbstractC1687j9 a;
    public final long b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1656i2(AbstractC1687j9 state, long j) {
        super(0);
        Intrinsics.checkNotNullParameter(state, "state");
        this.a = state;
        this.b = j;
    }

    public final AbstractC1687j9 a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1656i2)) {
            return false;
        }
        C1656i2 c1656i2 = (C1656i2) obj;
        return Intrinsics.areEqual(this.a, c1656i2.a) && this.b == c1656i2.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "OneTimePassword(state=" + this.a + ", timerTime=" + this.b + ')';
    }
}
