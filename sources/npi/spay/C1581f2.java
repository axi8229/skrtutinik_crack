package npi.spay;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.f2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1581f2 extends AbstractC1855q2 {
    public final Function1 a;

    public C1581f2(Function1 function1) {
        super(0);
        this.a = function1;
    }

    public final Function1 a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1581f2) && Intrinsics.areEqual(this.a, ((C1581f2) obj).a);
    }

    public final int hashCode() {
        Function1 function1 = this.a;
        if (function1 == null) {
            return 0;
        }
        return function1.hashCode();
    }

    public final String toString() {
        return "NoInternetConnectionError(caller=" + this.a + ')';
    }
}
