package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import sberid.sdk.auth.model.SberIDResultModel;

/* loaded from: classes4.dex */
public final class An extends co {
    public final SberIDResultModel a;

    public An(SberIDResultModel sberIDResultModel) {
        super(0);
        this.a = sberIDResultModel;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof An) && Intrinsics.areEqual(this.a, ((An) obj).a);
    }

    public final int hashCode() {
        SberIDResultModel sberIDResultModel = this.a;
        if (sberIDResultModel == null) {
            return 0;
        }
        return sberIDResultModel.hashCode();
    }

    public final String toString() {
        return "HandleBankAuthorization(sberIDResultModel=" + this.a + ')';
    }
}
