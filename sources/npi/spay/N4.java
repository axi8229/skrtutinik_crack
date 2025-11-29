package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class N4 {
    public final C2097zk a;
    public final C2097zk b;

    public N4(C2097zk title, C2097zk description) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        this.a = title;
        this.b = description;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N4)) {
            return false;
        }
        N4 n4 = (N4) obj;
        return Intrinsics.areEqual(this.a, n4.a) && Intrinsics.areEqual(this.b, n4.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "CardListHeaderItem(title=" + this.a + ", description=" + this.b + ')';
    }
}
