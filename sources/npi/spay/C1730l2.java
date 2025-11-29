package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.l2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1730l2 extends AbstractC1855q2 {
    public final InterfaceC1850pm a;
    public final Oi b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1730l2(InterfaceC1850pm mode, Oi preparedListOfCards) {
        super(0);
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(preparedListOfCards, "preparedListOfCards");
        this.a = mode;
        this.b = preparedListOfCards;
    }

    public final InterfaceC1850pm a() {
        return this.a;
    }

    public final Oi b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1730l2)) {
            return false;
        }
        C1730l2 c1730l2 = (C1730l2) obj;
        return Intrinsics.areEqual(this.a, c1730l2.a) && Intrinsics.areEqual(this.b, c1730l2.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "OrderScreenSelectCard(mode=" + this.a + ", preparedListOfCards=" + this.b + ')';
    }
}
