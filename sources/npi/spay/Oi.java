package npi.spay;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Oi {
    public final ArrayList a;
    public final int b;

    public Oi(int i, ArrayList cardsList) {
        Intrinsics.checkNotNullParameter(cardsList, "cardsList");
        this.a = cardsList;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Oi)) {
            return false;
        }
        Oi oi = (Oi) obj;
        return Intrinsics.areEqual(this.a, oi.a) && this.b == oi.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "CardsListData(cardsList=" + this.a + ", selectedCardPosition=" + this.b + ')';
    }
}
