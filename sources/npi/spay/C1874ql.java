package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import sberid.sdk.auth.model.SberIDResultModel;

/* renamed from: npi.spay.ql, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1874ql implements Eg {
    public final Object a;
    public final String b;
    public final boolean c;

    public C1874ql(SberIDResultModel sberIDResultModel, String str, boolean z) {
        this.a = sberIDResultModel;
        this.b = str;
        this.c = z;
    }

    @Override // npi.spay.Eg
    public final boolean a() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1874ql)) {
            return false;
        }
        C1874ql c1874ql = (C1874ql) obj;
        return Intrinsics.areEqual(this.a, c1874ql.a) && Intrinsics.areEqual(this.b, c1874ql.b) && this.c == c1874ql.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z = this.c;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode2 + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BankAuthResult(authData=");
        sb.append(this.a);
        sb.append(", error=");
        sb.append(this.b);
        sb.append(", isAuthSuccess=");
        return AbstractC1901s.a(sb, this.c, ')');
    }

    public /* synthetic */ C1874ql(SberIDResultModel sberIDResultModel, String str, boolean z, int i) {
        this((i & 1) != 0 ? null : sberIDResultModel, (i & 2) != 0 ? null : str, z);
    }
}
