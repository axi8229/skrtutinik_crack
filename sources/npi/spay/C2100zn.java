package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.zn, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2100zn extends co {
    public final InterfaceC1850pm a;
    public final Oi b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2100zn(InterfaceC1850pm mode, Oi listOfCards) {
        super(0);
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(listOfCards, "listOfCards");
        this.a = mode;
        this.b = listOfCards;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2100zn)) {
            return false;
        }
        C2100zn c2100zn = (C2100zn) obj;
        return Intrinsics.areEqual(this.a, c2100zn.a) && Intrinsics.areEqual(this.b, c2100zn.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "ShowSelectCardScreenEvent(mode=" + this.a + ", listOfCards=" + this.b + ')';
    }
}
