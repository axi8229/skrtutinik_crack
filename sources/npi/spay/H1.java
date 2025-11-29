package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import sberid.sdk.auth.model.SberIDResultModel;

/* loaded from: classes4.dex */
public final class H1 extends AbstractC1855q2 {
    public final SberIDResultModel a;

    public H1(SberIDResultModel sberIDResultModel) {
        super(0);
        this.a = sberIDResultModel;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof H1) && Intrinsics.areEqual(this.a, ((H1) obj).a);
    }

    public final int hashCode() {
        SberIDResultModel sberIDResultModel = this.a;
        if (sberIDResultModel == null) {
            return 0;
        }
        return sberIDResultModel.hashCode();
    }

    public final String toString() {
        return "BankAuthResult(sberIDResultModel=" + this.a + ')';
    }
}
