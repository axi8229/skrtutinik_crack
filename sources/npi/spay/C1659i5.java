package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.i5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1659i5 extends AbstractC1733l5 {
    public final int a;
    public final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1659i5(int i, String uri) {
        super(0);
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.a = i;
        this.b = uri;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1659i5)) {
            return false;
        }
        C1659i5 c1659i5 = (C1659i5) obj;
        return this.a == c1659i5.a && Intrinsics.areEqual(this.b, c1659i5.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Integer.hashCode(this.a) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OpenAgreementConditionsClickedEvent(index=");
        sb.append(this.a);
        sb.append(", uri=");
        return Q1.a(sb, this.b, ')');
    }
}
