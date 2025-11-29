package ru.yoomoney.sdk.kassa.payments.contract;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2218b extends AbstractC2236k {
    public final boolean a;

    public C2218b(boolean z) {
        super(0);
        this.a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2218b) && this.a == ((C2218b) obj).a;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.a);
    }

    public final String toString() {
        return "ChangeSavePaymentMethod(savePaymentMethod=" + this.a + ")";
    }
}
