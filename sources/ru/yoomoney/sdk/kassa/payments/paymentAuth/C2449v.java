package ru.yoomoney.sdk.kassa.payments.paymentAuth;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.v, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2449v extends E {
    public final boolean a;

    public C2449v(boolean z) {
        super(0);
        this.a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2449v) && this.a == ((C2449v) obj).a;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.a);
    }

    public final String toString() {
        return "Action.ProcessAuthNotRequired";
    }
}
