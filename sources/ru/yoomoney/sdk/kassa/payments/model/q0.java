package ru.yoomoney.sdk.kassa.payments.model;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class q0 {
    public final boolean a;
    public final boolean b;
    public final String c;

    public q0(boolean z, boolean z2, String str) {
        this.a = z;
        this.b = z2;
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return this.a == q0Var.a && this.b == q0Var.b && Intrinsics.areEqual(this.c, q0Var.c);
    }

    public final int hashCode() {
        int iA = ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.b, Boolean.hashCode(this.a) * 31, 31);
        String str = this.c;
        return iA + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "ShopProperties(isSafeDeal=" + this.a + ", isMarketplace=" + this.b + ", agentSchemeData=" + this.c + ")";
    }
}
