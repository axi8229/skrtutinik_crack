package spay.sdk.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Q1;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lspay/sdk/api/PaymentTokenResult;", "", "()V", "Error", "Success", "Lspay/sdk/api/PaymentTokenResult$Error;", "Lspay/sdk/api/PaymentTokenResult$Success;", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class PaymentTokenResult {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lspay/sdk/api/PaymentTokenResult$Error;", "Lspay/sdk/api/PaymentTokenResult;", "merchantError", "Lspay/sdk/api/MerchantError;", "(Lspay/sdk/api/MerchantError;)V", "getMerchantError", "()Lspay/sdk/api/MerchantError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Error extends PaymentTokenResult {
        private final MerchantError merchantError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(MerchantError merchantError) {
            super(null);
            Intrinsics.checkNotNullParameter(merchantError, "merchantError");
            this.merchantError = merchantError;
        }

        public static /* synthetic */ Error copy$default(Error error, MerchantError merchantError, int i, Object obj) {
            if ((i & 1) != 0) {
                merchantError = error.merchantError;
            }
            return error.copy(merchantError);
        }

        /* renamed from: component1, reason: from getter */
        public final MerchantError getMerchantError() {
            return this.merchantError;
        }

        public final Error copy(MerchantError merchantError) {
            Intrinsics.checkNotNullParameter(merchantError, "merchantError");
            return new Error(merchantError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.merchantError, ((Error) other).merchantError);
        }

        public final MerchantError getMerchantError() {
            return this.merchantError;
        }

        public int hashCode() {
            return this.merchantError.hashCode();
        }

        public String toString() {
            return "Error(merchantError=" + this.merchantError + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lspay/sdk/api/PaymentTokenResult$Success;", "Lspay/sdk/api/PaymentTokenResult;", "paymentToken", "", "(Ljava/lang/String;)V", "getPaymentToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Success extends PaymentTokenResult {
        private final String paymentToken;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String paymentToken) {
            super(null);
            Intrinsics.checkNotNullParameter(paymentToken, "paymentToken");
            this.paymentToken = paymentToken;
        }

        public static /* synthetic */ Success copy$default(Success success, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.paymentToken;
            }
            return success.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPaymentToken() {
            return this.paymentToken;
        }

        public final Success copy(String paymentToken) {
            Intrinsics.checkNotNullParameter(paymentToken, "paymentToken");
            return new Success(paymentToken);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && Intrinsics.areEqual(this.paymentToken, ((Success) other).paymentToken);
        }

        public final String getPaymentToken() {
            return this.paymentToken;
        }

        public int hashCode() {
            return this.paymentToken.hashCode();
        }

        public String toString() {
            return Q1.a(new StringBuilder("Success(paymentToken="), this.paymentToken, ')');
        }
    }

    private PaymentTokenResult() {
    }

    public /* synthetic */ PaymentTokenResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
