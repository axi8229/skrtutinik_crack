package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.ui;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

/* loaded from: classes5.dex */
public final class o implements q {
    public final String a;
    public final String b;
    public final Function0 c;

    public o(String failureTitle, String actionText, b onAction) {
        Intrinsics.checkNotNullParameter(failureTitle, "failureTitle");
        Intrinsics.checkNotNullParameter(actionText, "actionText");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        this.a = failureTitle;
        this.b = actionText;
        this.c = onAction;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return Intrinsics.areEqual(this.a, oVar.a) && Intrinsics.areEqual(this.b, oVar.b) && Intrinsics.areEqual(this.c, oVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + AbstractC1553e.a(this.b, this.a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "InitialError(failureTitle=" + this.a + ", actionText=" + this.b + ", onAction=" + this.c + ")";
    }
}
