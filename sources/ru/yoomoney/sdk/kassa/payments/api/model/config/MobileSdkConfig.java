package ru.yoomoney.sdk.kassa.payments.api.model.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\u000e\b\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0083\u0001\u0010*\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\t2\u000e\b\u0003\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0003\u0010\r\u001a\u00020\u00032\b\b\u0003\u0010\u000e\u001a\u00020\u00032\u0016\b\u0003\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015¨\u00061"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/config/MobileSdkConfig;", "", "yooMoneyAuthApiEndpoint", "", "yooMoneyPaymentAuthorizationApiEndpoint", "yooMoneyApiEndpoint", "googlePayGateway", "userAgreementUrl", "savePaymentMethodOptionTexts", "Lru/yoomoney/sdk/kassa/payments/api/model/config/SavePaymentMethodOptionTextsResponse;", "paymentMethods", "", "Lru/yoomoney/sdk/kassa/payments/api/model/config/PaymentMethods;", "yooMoneyLogoUrlLight", "yooMoneyLogoUrlDark", "agentSchemeProviderAgreement", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/kassa/payments/api/model/config/SavePaymentMethodOptionTextsResponse;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAgentSchemeProviderAgreement", "()Ljava/util/Map;", "getGooglePayGateway", "()Ljava/lang/String;", "getPaymentMethods", "()Ljava/util/List;", "getSavePaymentMethodOptionTexts", "()Lru/yoomoney/sdk/kassa/payments/api/model/config/SavePaymentMethodOptionTextsResponse;", "getUserAgreementUrl", "getYooMoneyApiEndpoint", "getYooMoneyAuthApiEndpoint", "getYooMoneyLogoUrlDark", "getYooMoneyLogoUrlLight", "getYooMoneyPaymentAuthorizationApiEndpoint", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MobileSdkConfig {
    public static final int $stable = 8;
    private final Map<String, String> agentSchemeProviderAgreement;
    private final String googlePayGateway;
    private final List<PaymentMethods> paymentMethods;
    private final SavePaymentMethodOptionTextsResponse savePaymentMethodOptionTexts;
    private final String userAgreementUrl;
    private final String yooMoneyApiEndpoint;
    private final String yooMoneyAuthApiEndpoint;
    private final String yooMoneyLogoUrlDark;
    private final String yooMoneyLogoUrlLight;
    private final String yooMoneyPaymentAuthorizationApiEndpoint;

    public MobileSdkConfig(@JsonProperty("yooMoneyAuthApiEndpoint") String str, @JsonProperty("yooMoneyPaymentAuthorizationApiEndpoint") String yooMoneyPaymentAuthorizationApiEndpoint, @JsonProperty("yooMoneyApiEndpoint") String yooMoneyApiEndpoint, @JsonProperty("googlePayGateway") String googlePayGateway, @JsonProperty("userAgreementUrl") String userAgreementUrl, @JsonProperty("savePaymentMethodOptionTexts") SavePaymentMethodOptionTextsResponse savePaymentMethodOptionTexts, @JsonProperty("paymentMethods") List<PaymentMethods> paymentMethods, @JsonProperty("yooMoneyLogoUrlLight") String yooMoneyLogoUrlLight, @JsonProperty("yooMoneyLogoUrlDark") String yooMoneyLogoUrlDark, @JsonProperty("agentSchemeProviderAgreement") Map<String, String> map) {
        Intrinsics.checkNotNullParameter(yooMoneyPaymentAuthorizationApiEndpoint, "yooMoneyPaymentAuthorizationApiEndpoint");
        Intrinsics.checkNotNullParameter(yooMoneyApiEndpoint, "yooMoneyApiEndpoint");
        Intrinsics.checkNotNullParameter(googlePayGateway, "googlePayGateway");
        Intrinsics.checkNotNullParameter(userAgreementUrl, "userAgreementUrl");
        Intrinsics.checkNotNullParameter(savePaymentMethodOptionTexts, "savePaymentMethodOptionTexts");
        Intrinsics.checkNotNullParameter(paymentMethods, "paymentMethods");
        Intrinsics.checkNotNullParameter(yooMoneyLogoUrlLight, "yooMoneyLogoUrlLight");
        Intrinsics.checkNotNullParameter(yooMoneyLogoUrlDark, "yooMoneyLogoUrlDark");
        this.yooMoneyAuthApiEndpoint = str;
        this.yooMoneyPaymentAuthorizationApiEndpoint = yooMoneyPaymentAuthorizationApiEndpoint;
        this.yooMoneyApiEndpoint = yooMoneyApiEndpoint;
        this.googlePayGateway = googlePayGateway;
        this.userAgreementUrl = userAgreementUrl;
        this.savePaymentMethodOptionTexts = savePaymentMethodOptionTexts;
        this.paymentMethods = paymentMethods;
        this.yooMoneyLogoUrlLight = yooMoneyLogoUrlLight;
        this.yooMoneyLogoUrlDark = yooMoneyLogoUrlDark;
        this.agentSchemeProviderAgreement = map;
    }

    /* renamed from: component1, reason: from getter */
    public final String getYooMoneyAuthApiEndpoint() {
        return this.yooMoneyAuthApiEndpoint;
    }

    public final Map<String, String> component10() {
        return this.agentSchemeProviderAgreement;
    }

    /* renamed from: component2, reason: from getter */
    public final String getYooMoneyPaymentAuthorizationApiEndpoint() {
        return this.yooMoneyPaymentAuthorizationApiEndpoint;
    }

    /* renamed from: component3, reason: from getter */
    public final String getYooMoneyApiEndpoint() {
        return this.yooMoneyApiEndpoint;
    }

    /* renamed from: component4, reason: from getter */
    public final String getGooglePayGateway() {
        return this.googlePayGateway;
    }

    /* renamed from: component5, reason: from getter */
    public final String getUserAgreementUrl() {
        return this.userAgreementUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final SavePaymentMethodOptionTextsResponse getSavePaymentMethodOptionTexts() {
        return this.savePaymentMethodOptionTexts;
    }

    public final List<PaymentMethods> component7() {
        return this.paymentMethods;
    }

    /* renamed from: component8, reason: from getter */
    public final String getYooMoneyLogoUrlLight() {
        return this.yooMoneyLogoUrlLight;
    }

    /* renamed from: component9, reason: from getter */
    public final String getYooMoneyLogoUrlDark() {
        return this.yooMoneyLogoUrlDark;
    }

    public final MobileSdkConfig copy(@JsonProperty("yooMoneyAuthApiEndpoint") String yooMoneyAuthApiEndpoint, @JsonProperty("yooMoneyPaymentAuthorizationApiEndpoint") String yooMoneyPaymentAuthorizationApiEndpoint, @JsonProperty("yooMoneyApiEndpoint") String yooMoneyApiEndpoint, @JsonProperty("googlePayGateway") String googlePayGateway, @JsonProperty("userAgreementUrl") String userAgreementUrl, @JsonProperty("savePaymentMethodOptionTexts") SavePaymentMethodOptionTextsResponse savePaymentMethodOptionTexts, @JsonProperty("paymentMethods") List<PaymentMethods> paymentMethods, @JsonProperty("yooMoneyLogoUrlLight") String yooMoneyLogoUrlLight, @JsonProperty("yooMoneyLogoUrlDark") String yooMoneyLogoUrlDark, @JsonProperty("agentSchemeProviderAgreement") Map<String, String> agentSchemeProviderAgreement) {
        Intrinsics.checkNotNullParameter(yooMoneyPaymentAuthorizationApiEndpoint, "yooMoneyPaymentAuthorizationApiEndpoint");
        Intrinsics.checkNotNullParameter(yooMoneyApiEndpoint, "yooMoneyApiEndpoint");
        Intrinsics.checkNotNullParameter(googlePayGateway, "googlePayGateway");
        Intrinsics.checkNotNullParameter(userAgreementUrl, "userAgreementUrl");
        Intrinsics.checkNotNullParameter(savePaymentMethodOptionTexts, "savePaymentMethodOptionTexts");
        Intrinsics.checkNotNullParameter(paymentMethods, "paymentMethods");
        Intrinsics.checkNotNullParameter(yooMoneyLogoUrlLight, "yooMoneyLogoUrlLight");
        Intrinsics.checkNotNullParameter(yooMoneyLogoUrlDark, "yooMoneyLogoUrlDark");
        return new MobileSdkConfig(yooMoneyAuthApiEndpoint, yooMoneyPaymentAuthorizationApiEndpoint, yooMoneyApiEndpoint, googlePayGateway, userAgreementUrl, savePaymentMethodOptionTexts, paymentMethods, yooMoneyLogoUrlLight, yooMoneyLogoUrlDark, agentSchemeProviderAgreement);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MobileSdkConfig)) {
            return false;
        }
        MobileSdkConfig mobileSdkConfig = (MobileSdkConfig) other;
        return Intrinsics.areEqual(this.yooMoneyAuthApiEndpoint, mobileSdkConfig.yooMoneyAuthApiEndpoint) && Intrinsics.areEqual(this.yooMoneyPaymentAuthorizationApiEndpoint, mobileSdkConfig.yooMoneyPaymentAuthorizationApiEndpoint) && Intrinsics.areEqual(this.yooMoneyApiEndpoint, mobileSdkConfig.yooMoneyApiEndpoint) && Intrinsics.areEqual(this.googlePayGateway, mobileSdkConfig.googlePayGateway) && Intrinsics.areEqual(this.userAgreementUrl, mobileSdkConfig.userAgreementUrl) && Intrinsics.areEqual(this.savePaymentMethodOptionTexts, mobileSdkConfig.savePaymentMethodOptionTexts) && Intrinsics.areEqual(this.paymentMethods, mobileSdkConfig.paymentMethods) && Intrinsics.areEqual(this.yooMoneyLogoUrlLight, mobileSdkConfig.yooMoneyLogoUrlLight) && Intrinsics.areEqual(this.yooMoneyLogoUrlDark, mobileSdkConfig.yooMoneyLogoUrlDark) && Intrinsics.areEqual(this.agentSchemeProviderAgreement, mobileSdkConfig.agentSchemeProviderAgreement);
    }

    public final Map<String, String> getAgentSchemeProviderAgreement() {
        return this.agentSchemeProviderAgreement;
    }

    public final String getGooglePayGateway() {
        return this.googlePayGateway;
    }

    public final List<PaymentMethods> getPaymentMethods() {
        return this.paymentMethods;
    }

    public final SavePaymentMethodOptionTextsResponse getSavePaymentMethodOptionTexts() {
        return this.savePaymentMethodOptionTexts;
    }

    public final String getUserAgreementUrl() {
        return this.userAgreementUrl;
    }

    public final String getYooMoneyApiEndpoint() {
        return this.yooMoneyApiEndpoint;
    }

    public final String getYooMoneyAuthApiEndpoint() {
        return this.yooMoneyAuthApiEndpoint;
    }

    public final String getYooMoneyLogoUrlDark() {
        return this.yooMoneyLogoUrlDark;
    }

    public final String getYooMoneyLogoUrlLight() {
        return this.yooMoneyLogoUrlLight;
    }

    public final String getYooMoneyPaymentAuthorizationApiEndpoint() {
        return this.yooMoneyPaymentAuthorizationApiEndpoint;
    }

    public int hashCode() {
        String str = this.yooMoneyAuthApiEndpoint;
        int iA = AbstractC1553e.a(this.yooMoneyLogoUrlDark, AbstractC1553e.a(this.yooMoneyLogoUrlLight, (this.paymentMethods.hashCode() + ((this.savePaymentMethodOptionTexts.hashCode() + AbstractC1553e.a(this.userAgreementUrl, AbstractC1553e.a(this.googlePayGateway, AbstractC1553e.a(this.yooMoneyApiEndpoint, AbstractC1553e.a(this.yooMoneyPaymentAuthorizationApiEndpoint, (str == null ? 0 : str.hashCode()) * 31, 31), 31), 31), 31)) * 31)) * 31, 31), 31);
        Map<String, String> map = this.agentSchemeProviderAgreement;
        return iA + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "MobileSdkConfig(yooMoneyAuthApiEndpoint=" + this.yooMoneyAuthApiEndpoint + ", yooMoneyPaymentAuthorizationApiEndpoint=" + this.yooMoneyPaymentAuthorizationApiEndpoint + ", yooMoneyApiEndpoint=" + this.yooMoneyApiEndpoint + ", googlePayGateway=" + this.googlePayGateway + ", userAgreementUrl=" + this.userAgreementUrl + ", savePaymentMethodOptionTexts=" + this.savePaymentMethodOptionTexts + ", paymentMethods=" + this.paymentMethods + ", yooMoneyLogoUrlLight=" + this.yooMoneyLogoUrlLight + ", yooMoneyLogoUrlDark=" + this.yooMoneyLogoUrlDark + ", agentSchemeProviderAgreement=" + this.agentSchemeProviderAgreement + ")";
    }
}
