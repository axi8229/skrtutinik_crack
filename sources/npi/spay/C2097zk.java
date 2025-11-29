package npi.spay;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.zk, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2097zk implements Bk {
    public final int a;
    public final List b;

    public C2097zk(int i, List args) {
        Intrinsics.checkNotNullParameter(args, "args");
        this.a = i;
        this.b = args;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2097zk)) {
            return false;
        }
        C2097zk c2097zk = (C2097zk) obj;
        return this.a == c2097zk.a && Intrinsics.areEqual(this.b, c2097zk.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Integer.hashCode(this.a) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Resource(resId=");
        sb.append(this.a);
        sb.append(", args=");
        return U0.a(sb, this.b, ')');
    }
}
