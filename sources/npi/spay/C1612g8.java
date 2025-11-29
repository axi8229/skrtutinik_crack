package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.paymentToken.errorResponse.FraudMonCheckResult;

/* renamed from: npi.spay.g8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1612g8 {
    public static Zi a(FraudMonCheckResult fraudMonCheckResult) {
        if (fraudMonCheckResult != null) {
            if (Intrinsics.areEqual(fraudMonCheckResult.getActionCode(), "REVIEW") && Intrinsics.areEqual(fraudMonCheckResult.getConfirmMethodFactor(), "SMSP") && !fraudMonCheckResult.isClientBlock()) {
                return new Xi(fraudMonCheckResult);
            }
            if (Intrinsics.areEqual(fraudMonCheckResult.getActionCode(), "REVIEW") && Intrinsics.areEqual(fraudMonCheckResult.getConfirmMethodFactor(), "HINT") && !fraudMonCheckResult.isClientBlock()) {
                return new Yi(fraudMonCheckResult);
            }
            if (Intrinsics.areEqual(fraudMonCheckResult.getActionCode(), "DENY") && !fraudMonCheckResult.isClientBlock()) {
                return new Ui(fraudMonCheckResult);
            }
            if (Intrinsics.areEqual(fraudMonCheckResult.getActionCode(), "DENY") && fraudMonCheckResult.isClientBlock()) {
                return new Vi(fraudMonCheckResult);
            }
        }
        return Wi.a;
    }
}
