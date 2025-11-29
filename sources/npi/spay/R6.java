package npi.spay;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class R6 extends S6 {
    public final List b;

    public R6(List list) {
        this.b = list;
    }

    @Override // npi.spay.S6
    public final List a() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof R6) && Intrinsics.areEqual(this.b, ((R6) obj).b);
    }

    public final int hashCode() {
        List list = this.b;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final String toString() {
        return U0.a(new StringBuilder("NoMoneyYesHelpers(bannerData="), this.b, ')');
    }
}
