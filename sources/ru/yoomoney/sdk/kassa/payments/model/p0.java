package ru.yoomoney.sdk.kassa.payments.model;

/* loaded from: classes5.dex */
public final class p0 extends o0 {
    public final int a;

    public p0(int i) {
        this.a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof p0) && this.a == ((p0) obj).a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.a);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return "SelectedOptionNotFoundException(optionId=" + this.a + ")";
    }
}
