package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Mi implements Eg {
    public final String a;
    public final boolean b;

    public /* synthetic */ Mi(int i, String str, boolean z) {
        this((i & 2) != 0 ? null : str, z);
    }

    @Override // npi.spay.Eg
    public final boolean a() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mi)) {
            return false;
        }
        Mi mi = (Mi) obj;
        mi.getClass();
        return Intrinsics.areEqual(null, null) && Intrinsics.areEqual(this.a, mi.a) && this.b == mi.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.b;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BiometricAuthResult(authData=null, error=");
        sb.append(this.a);
        sb.append(", isAuthSuccess=");
        return AbstractC1901s.a(sb, this.b, ')');
    }

    public Mi(String str, boolean z) {
        this.a = str;
        this.b = z;
    }
}
