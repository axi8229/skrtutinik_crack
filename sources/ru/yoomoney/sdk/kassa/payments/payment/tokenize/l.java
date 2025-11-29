package ru.yoomoney.sdk.kassa.payments.payment.tokenize;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.Q;
import ru.yoomoney.sdk.kassa.payments.model.T;

/* loaded from: classes5.dex */
public final class l {
    public final String a;
    public final T b;
    public final Q c;

    public l(String token, T option, Q q) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(option, "option");
        this.a = token;
        this.b = option;
        this.c = q;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return Intrinsics.areEqual(this.a, lVar.a) && Intrinsics.areEqual(this.b, lVar.b) && Intrinsics.areEqual(this.c, lVar.c);
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        Q q = this.c;
        return iHashCode + (q == null ? 0 : q.hashCode());
    }

    public final String toString() {
        return "TokenizeOutputModel(token=" + this.a + ", option=" + this.b + ", instrumentBankCard=" + this.c + ")";
    }
}
