package ru.yoomoney.sdk.kassa.payments.navigation;

/* loaded from: classes5.dex */
public final class j extends v {
    public final f a;

    public j(f fVar) {
        super(0);
        this.a = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && this.a == ((j) obj).a;
    }

    public final int hashCode() {
        f fVar = this.a;
        if (fVar == null) {
            return 0;
        }
        return fVar.hashCode();
    }

    public final String toString() {
        return "PaymentOptions(moneyAuthResult=" + this.a + ")";
    }
}
