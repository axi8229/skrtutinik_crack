package npi.spay;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.o1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1804o1 {
    public final List a;
    public final List b;
    public final Integer[] c;

    public /* synthetic */ C1804o1(List list) {
        this(list, CollectionsKt.emptyList());
    }

    public final int a(int i) {
        Integer num = this.c[i];
        Integer num2 = null;
        if (num.intValue() == -1) {
            num = null;
        }
        if (num == null) {
            Iterator it = this.a.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                Dk dk = (Dk) it.next();
                List items = this.b;
                dk.getClass();
                Intrinsics.checkNotNullParameter(items, "items");
                if (dk.b(items.get(i))) {
                    break;
                }
                i2++;
            }
            Integer numValueOf = Integer.valueOf(i2);
            if (i2 == -1) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                this.c[i] = Integer.valueOf(numValueOf.intValue());
                num2 = numValueOf;
            }
            if (num2 == null) {
                throw new IllegalStateException(("Provide adapter for type " + this.b.get(i).getClass() + " at position: " + i).toString());
            }
            num = num2;
        }
        return num.intValue();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1804o1)) {
            return false;
        }
        C1804o1 c1804o1 = (C1804o1) obj;
        return Intrinsics.areEqual(this.a, c1804o1.a) && Intrinsics.areEqual(this.b, c1804o1.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AdaptersState(adapters=");
        sb.append(this.a);
        sb.append(", data=");
        return U0.a(sb, this.b, ')');
    }

    public C1804o1(List adapters, List data) {
        Intrinsics.checkNotNullParameter(adapters, "adapters");
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = adapters;
        this.b = data;
        int size = data.size();
        Integer[] numArr = new Integer[size];
        for (int i = 0; i < size; i++) {
            numArr[i] = -1;
        }
        this.c = numArr;
    }
}
