package ru.yoomoney.sdk.kassa.payments.userAuth;

/* renamed from: ru.yoomoney.sdk.kassa.payments.userAuth.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2545h extends AbstractC2546i {
    public final boolean a;

    public C2545h(boolean z) {
        super(0);
        this.a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2545h) && this.a == ((C2545h) obj).a;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.a);
    }

    public final String toString() {
        return "RequireAuth(isYooMoneyCouldBeOpened=" + this.a + ")";
    }
}
