package ru.yoomoney.sdk.kassa.payments.utils;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class i {
    public final String a;
    public final List b;
    public final int c;

    public i(String id, List bins, int i) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(bins, "bins");
        this.a = id;
        this.b = bins;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Intrinsics.areEqual(this.a, iVar.a) && Intrinsics.areEqual(this.b, iVar.b) && this.c == iVar.c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.c) + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PaymentSystemInfo(id=" + this.a + ", bins=" + this.b + ", icon=" + this.c + ")";
    }
}
