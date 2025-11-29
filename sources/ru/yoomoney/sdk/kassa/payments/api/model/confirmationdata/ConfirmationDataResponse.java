package ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

@JsonSubTypes({@JsonSubTypes.Type(name = "sbp", value = SbpConfirmationDataResponse.class), @JsonSubTypes.Type(name = "sberbank", value = SberPayConfirmationDataResponse.class)})
@JsonTypeInfo(defaultImpl = UnknownConfirmationDataResponse.class, include = JsonTypeInfo.As.PROPERTY, property = "type", use = JsonTypeInfo.Id.NAME)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bq\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/confirmationdata/ConfirmationDataResponse;", "", "SberPayConfirmationDataResponse", "SbpConfirmationDataResponse", "UnknownConfirmationDataResponse", "Lru/yoomoney/sdk/kassa/payments/api/model/confirmationdata/ConfirmationDataResponse$SberPayConfirmationDataResponse;", "Lru/yoomoney/sdk/kassa/payments/api/model/confirmationdata/ConfirmationDataResponse$SbpConfirmationDataResponse;", "Lru/yoomoney/sdk/kassa/payments/api/model/confirmationdata/ConfirmationDataResponse$UnknownConfirmationDataResponse;", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ConfirmationDataResponse {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/confirmationdata/ConfirmationDataResponse$SberPayConfirmationDataResponse;", "Lru/yoomoney/sdk/kassa/payments/api/model/confirmationdata/ConfirmationDataResponse;", "merchantLogin", "", "orderId", "orderNumber", "apiKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApiKey", "()Ljava/lang/String;", "getMerchantLogin", "getOrderId", "getOrderNumber", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class SberPayConfirmationDataResponse implements ConfirmationDataResponse {
        public static final int $stable = 0;
        private final String apiKey;
        private final String merchantLogin;
        private final String orderId;
        private final String orderNumber;

        public SberPayConfirmationDataResponse(@JsonProperty("merchant_login") String merchantLogin, @JsonProperty("order_id") String orderId, @JsonProperty("order_number") String orderNumber, @JsonProperty("api_key") String str) {
            Intrinsics.checkNotNullParameter(merchantLogin, "merchantLogin");
            Intrinsics.checkNotNullParameter(orderId, "orderId");
            Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
            this.merchantLogin = merchantLogin;
            this.orderId = orderId;
            this.orderNumber = orderNumber;
            this.apiKey = str;
        }

        public static /* synthetic */ SberPayConfirmationDataResponse copy$default(SberPayConfirmationDataResponse sberPayConfirmationDataResponse, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sberPayConfirmationDataResponse.merchantLogin;
            }
            if ((i & 2) != 0) {
                str2 = sberPayConfirmationDataResponse.orderId;
            }
            if ((i & 4) != 0) {
                str3 = sberPayConfirmationDataResponse.orderNumber;
            }
            if ((i & 8) != 0) {
                str4 = sberPayConfirmationDataResponse.apiKey;
            }
            return sberPayConfirmationDataResponse.copy(str, str2, str3, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMerchantLogin() {
            return this.merchantLogin;
        }

        /* renamed from: component2, reason: from getter */
        public final String getOrderId() {
            return this.orderId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getOrderNumber() {
            return this.orderNumber;
        }

        /* renamed from: component4, reason: from getter */
        public final String getApiKey() {
            return this.apiKey;
        }

        public final SberPayConfirmationDataResponse copy(@JsonProperty("merchant_login") String merchantLogin, @JsonProperty("order_id") String orderId, @JsonProperty("order_number") String orderNumber, @JsonProperty("api_key") String apiKey) {
            Intrinsics.checkNotNullParameter(merchantLogin, "merchantLogin");
            Intrinsics.checkNotNullParameter(orderId, "orderId");
            Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
            return new SberPayConfirmationDataResponse(merchantLogin, orderId, orderNumber, apiKey);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SberPayConfirmationDataResponse)) {
                return false;
            }
            SberPayConfirmationDataResponse sberPayConfirmationDataResponse = (SberPayConfirmationDataResponse) other;
            return Intrinsics.areEqual(this.merchantLogin, sberPayConfirmationDataResponse.merchantLogin) && Intrinsics.areEqual(this.orderId, sberPayConfirmationDataResponse.orderId) && Intrinsics.areEqual(this.orderNumber, sberPayConfirmationDataResponse.orderNumber) && Intrinsics.areEqual(this.apiKey, sberPayConfirmationDataResponse.apiKey);
        }

        public final String getApiKey() {
            return this.apiKey;
        }

        public final String getMerchantLogin() {
            return this.merchantLogin;
        }

        public final String getOrderId() {
            return this.orderId;
        }

        public final String getOrderNumber() {
            return this.orderNumber;
        }

        public int hashCode() {
            int iA = AbstractC1553e.a(this.orderNumber, AbstractC1553e.a(this.orderId, this.merchantLogin.hashCode() * 31, 31), 31);
            String str = this.apiKey;
            return iA + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "SberPayConfirmationDataResponse(merchantLogin=" + this.merchantLogin + ", orderId=" + this.orderId + ", orderNumber=" + this.orderNumber + ", apiKey=" + this.apiKey + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/confirmationdata/ConfirmationDataResponse$SbpConfirmationDataResponse;", "Lru/yoomoney/sdk/kassa/payments/api/model/confirmationdata/ConfirmationDataResponse;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class SbpConfirmationDataResponse implements ConfirmationDataResponse {
        public static final int $stable = 0;
        private final String url;

        public SbpConfirmationDataResponse(@JsonProperty("url") String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public static /* synthetic */ SbpConfirmationDataResponse copy$default(SbpConfirmationDataResponse sbpConfirmationDataResponse, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sbpConfirmationDataResponse.url;
            }
            return sbpConfirmationDataResponse.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final SbpConfirmationDataResponse copy(@JsonProperty("url") String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new SbpConfirmationDataResponse(url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SbpConfirmationDataResponse) && Intrinsics.areEqual(this.url, ((SbpConfirmationDataResponse) other).url);
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "SbpConfirmationDataResponse(url=" + this.url + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/confirmationdata/ConfirmationDataResponse$UnknownConfirmationDataResponse;", "Lru/yoomoney/sdk/kassa/payments/api/model/confirmationdata/ConfirmationDataResponse;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class UnknownConfirmationDataResponse implements ConfirmationDataResponse {
        public static final int $stable = 0;
        public static final UnknownConfirmationDataResponse INSTANCE = new UnknownConfirmationDataResponse();

        private UnknownConfirmationDataResponse() {
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof UnknownConfirmationDataResponse);
        }

        public int hashCode() {
            return 1976861060;
        }

        public String toString() {
            return "UnknownConfirmationDataResponse";
        }
    }
}
