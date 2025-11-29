package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.qe, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1867qe extends AbstractC2016we {
    public final C2012wa a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1867qe(C2012wa item) {
        super(0);
        Intrinsics.checkNotNullParameter(item, "item");
        this.a = item;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1867qe) && Intrinsics.areEqual(this.a, ((C1867qe) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "OnCloseHintClickEvent(item=" + this.a + ')';
    }
}
