package npi.spay;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class S7 extends T7 {
    public final ArrayList b;

    public S7(ArrayList arrayList) {
        this.b = arrayList;
    }

    @Override // npi.spay.T7
    public final List a() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof S7) && Intrinsics.areEqual(this.b, ((S7) obj).b);
    }

    public final int hashCode() {
        ArrayList arrayList = this.b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.hashCode();
    }

    public final String toString() {
        return "YesCardsYesHelpers(bannerData=" + this.b + ')';
    }
}
