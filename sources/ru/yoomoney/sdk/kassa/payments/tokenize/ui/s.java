package ru.yoomoney.sdk.kassa.payments.tokenize.ui;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

/* loaded from: classes5.dex */
public final class s implements t {
    public final String a;
    public final String b;
    public final Function0 c;

    public s(String subtitle, String actionText, u onAction) {
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(actionText, "actionText");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        this.a = subtitle;
        this.b = actionText;
        this.c = onAction;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return Intrinsics.areEqual(this.a, sVar.a) && Intrinsics.areEqual(this.b, sVar.b) && Intrinsics.areEqual(this.c, sVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + AbstractC1553e.a(this.b, this.a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "TokenizeError(subtitle=" + this.a + ", actionText=" + this.b + ", onAction=" + this.c + ")";
    }
}
