package ru.yoomoney.sdk.kassa.payments.contract;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2216a extends AbstractC2236k {
    public final boolean a;

    public C2216a(boolean z) {
        super(0);
        this.a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2216a) && this.a == ((C2216a) obj).a;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.a);
    }

    public final String toString() {
        return "ChangeAllowWalletLinking(isAllowed=" + this.a + ")";
    }
}
