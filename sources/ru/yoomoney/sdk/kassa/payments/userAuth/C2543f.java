package ru.yoomoney.sdk.kassa.payments.userAuth;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.model.UserAccount;
import ru.yoomoney.sdk.kassa.payments.metrics.AbstractC2316z;

/* renamed from: ru.yoomoney.sdk.kassa.payments.userAuth.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2543f extends AbstractC2546i {
    public final String a;
    public final UserAccount b;
    public final String c;
    public final AbstractC2316z d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2543f(String str, UserAccount userAccount, String str2, AbstractC2316z typeAuth) {
        super(0);
        Intrinsics.checkNotNullParameter(typeAuth, "typeAuth");
        this.a = str;
        this.b = userAccount;
        this.c = str2;
        this.d = typeAuth;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2543f)) {
            return false;
        }
        C2543f c2543f = (C2543f) obj;
        return Intrinsics.areEqual(this.a, c2543f.a) && Intrinsics.areEqual(this.b, c2543f.b) && Intrinsics.areEqual(this.c, c2543f.c) && Intrinsics.areEqual(this.d, c2543f.d);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        UserAccount userAccount = this.b;
        int iHashCode2 = (iHashCode + (userAccount == null ? 0 : userAccount.hashCode())) * 31;
        String str2 = this.c;
        return this.d.hashCode() + ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "Authorized(token=" + this.a + ", userAccount=" + this.b + ", tmxSessionId=" + this.c + ", typeAuth=" + this.d + ")";
    }
}
