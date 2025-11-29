package npi.spay;

import spay.sdk.domain.model.response.paymentToken.errorResponse.FraudMonCheckResult;

/* loaded from: classes4.dex */
public abstract class M8 {
    public final FraudMonCheckResult a;

    public M8(FraudMonCheckResult fraudMonCheckResult) {
        this.a = fraudMonCheckResult;
    }

    public FraudMonCheckResult a() {
        return this.a;
    }

    public /* synthetic */ M8(FraudMonCheckResult fraudMonCheckResult, int i) {
        this(fraudMonCheckResult);
    }
}
