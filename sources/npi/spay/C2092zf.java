package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.bnpl.ButtonBnpl;

/* renamed from: npi.spay.zf, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2092zf {
    public final String a;
    public final Long b;
    public final Boolean c;
    public final boolean d;
    public final ButtonBnpl e;

    public /* synthetic */ C2092zf(String str, Long l, Boolean bool, ButtonBnpl buttonBnpl, int i) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : bool, (i & 8) != 0, (i & 16) != 0 ? null : buttonBnpl);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2092zf)) {
            return false;
        }
        C2092zf c2092zf = (C2092zf) obj;
        return Intrinsics.areEqual(this.a, c2092zf.a) && Intrinsics.areEqual(this.b, c2092zf.b) && Intrinsics.areEqual(this.c, c2092zf.c) && this.d == c2092zf.d && Intrinsics.areEqual(this.e, c2092zf.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.b;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Boolean bool = this.c;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        boolean z = this.d;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        ButtonBnpl buttonBnpl = this.e;
        return i2 + (buttonBnpl != null ? buttonBnpl.hashCode() : 0);
    }

    public final String toString() {
        return "BnplButtonData(numOfPayments=" + this.a + ", payment=" + this.b + ", isButtonEnable=" + this.c + ", isButtonVisible=" + this.d + ", bnplButton=" + this.e + ')';
    }

    public C2092zf(String str, Long l, Boolean bool, boolean z, ButtonBnpl buttonBnpl) {
        this.a = str;
        this.b = l;
        this.c = bool;
        this.d = z;
        this.e = buttonBnpl;
    }
}
