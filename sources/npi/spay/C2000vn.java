package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.vn, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2000vn extends co {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2000vn(String uri) {
        super(0);
        C1775mm mode = C1775mm.a;
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.a = uri;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2000vn)) {
            return false;
        }
        C2000vn c2000vn = (C2000vn) obj;
        C1775mm c1775mm = C1775mm.a;
        c2000vn.getClass();
        return Intrinsics.areEqual(c1775mm, c1775mm) && Intrinsics.areEqual(this.a, c2000vn.a);
    }

    public final int hashCode() {
        return this.a.hashCode() + (C1775mm.a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ShowOrderBnplAgreementScreen(mode=");
        sb.append(C1775mm.a);
        sb.append(", uri=");
        return Q1.a(sb, this.a, ')');
    }
}
