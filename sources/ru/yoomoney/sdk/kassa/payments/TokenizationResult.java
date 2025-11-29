package ru.yoomoney.sdk.kassa.payments;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/TokenizationResult;", "", "paymentToken", "", "paymentMethodType", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;", "(Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;)V", "getPaymentMethodType", "()Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;", "getPaymentToken", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TokenizationResult {
    public static final int $stable = 0;

    @Keep
    private final PaymentMethodType paymentMethodType;

    @Keep
    private final String paymentToken;

    public TokenizationResult(String paymentToken, PaymentMethodType paymentMethodType) {
        Intrinsics.checkNotNullParameter(paymentToken, "paymentToken");
        Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
        this.paymentToken = paymentToken;
        this.paymentMethodType = paymentMethodType;
    }

    public static /* synthetic */ TokenizationResult copy$default(TokenizationResult tokenizationResult, String str, PaymentMethodType paymentMethodType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tokenizationResult.paymentToken;
        }
        if ((i & 2) != 0) {
            paymentMethodType = tokenizationResult.paymentMethodType;
        }
        return tokenizationResult.copy(str, paymentMethodType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPaymentToken() {
        return this.paymentToken;
    }

    /* renamed from: component2, reason: from getter */
    public final PaymentMethodType getPaymentMethodType() {
        return this.paymentMethodType;
    }

    public final TokenizationResult copy(String paymentToken, PaymentMethodType paymentMethodType) {
        Intrinsics.checkNotNullParameter(paymentToken, "paymentToken");
        Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
        return new TokenizationResult(paymentToken, paymentMethodType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TokenizationResult)) {
            return false;
        }
        TokenizationResult tokenizationResult = (TokenizationResult) other;
        return Intrinsics.areEqual(this.paymentToken, tokenizationResult.paymentToken) && this.paymentMethodType == tokenizationResult.paymentMethodType;
    }

    public final PaymentMethodType getPaymentMethodType() {
        return this.paymentMethodType;
    }

    public final String getPaymentToken() {
        return this.paymentToken;
    }

    public int hashCode() {
        return this.paymentMethodType.hashCode() + (this.paymentToken.hashCode() * 31);
    }

    public String toString() {
        return "TokenizationResult(paymentToken=" + this.paymentToken + ", paymentMethodType=" + this.paymentMethodType + ")";
    }
}
