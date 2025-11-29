package ru.yoomoney.sdk.kassa.payments.model;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0017\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0083\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015¨\u00061"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/model/Config;", "", "yooMoneyLogoUrlLight", "", "yooMoneyLogoUrlDark", "paymentMethods", "", "Lru/yoomoney/sdk/kassa/payments/model/ConfigPaymentOption;", "savePaymentMethodOptionTexts", "Lru/yoomoney/sdk/kassa/payments/model/SavePaymentMethodOptionTexts;", "userAgreementUrl", "googlePayGateway", "yooMoneyApiEndpoint", "yooMoneyPaymentAuthorizationApiEndpoint", "yooMoneyAuthApiEndpoint", "agentSchemeProviderAgreement", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lru/yoomoney/sdk/kassa/payments/model/SavePaymentMethodOptionTexts;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAgentSchemeProviderAgreement", "()Ljava/util/Map;", "getGooglePayGateway", "()Ljava/lang/String;", "getPaymentMethods", "()Ljava/util/List;", "getSavePaymentMethodOptionTexts", "()Lru/yoomoney/sdk/kassa/payments/model/SavePaymentMethodOptionTexts;", "getUserAgreementUrl", "getYooMoneyApiEndpoint", "getYooMoneyAuthApiEndpoint", "getYooMoneyLogoUrlDark", "getYooMoneyLogoUrlLight", "getYooMoneyPaymentAuthorizationApiEndpoint", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Config {
    public static final int $stable = 8;
    private final Map<String, String> agentSchemeProviderAgreement;
    private final String googlePayGateway;
    private final List<ConfigPaymentOption> paymentMethods;
    private final SavePaymentMethodOptionTexts savePaymentMethodOptionTexts;
    private final String userAgreementUrl;
    private final String yooMoneyApiEndpoint;
    private final String yooMoneyAuthApiEndpoint;
    private final String yooMoneyLogoUrlDark;
    private final String yooMoneyLogoUrlLight;
    private final String yooMoneyPaymentAuthorizationApiEndpoint;

    public Config(String yooMoneyLogoUrlLight, String yooMoneyLogoUrlDark, List<ConfigPaymentOption> paymentMethods, SavePaymentMethodOptionTexts savePaymentMethodOptionTexts, String userAgreementUrl, String googlePayGateway, String yooMoneyApiEndpoint, String yooMoneyPaymentAuthorizationApiEndpoint, String str, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(yooMoneyLogoUrlLight, "yooMoneyLogoUrlLight");
        Intrinsics.checkNotNullParameter(yooMoneyLogoUrlDark, "yooMoneyLogoUrlDark");
        Intrinsics.checkNotNullParameter(paymentMethods, "paymentMethods");
        Intrinsics.checkNotNullParameter(savePaymentMethodOptionTexts, "savePaymentMethodOptionTexts");
        Intrinsics.checkNotNullParameter(userAgreementUrl, "userAgreementUrl");
        Intrinsics.checkNotNullParameter(googlePayGateway, "googlePayGateway");
        Intrinsics.checkNotNullParameter(yooMoneyApiEndpoint, "yooMoneyApiEndpoint");
        Intrinsics.checkNotNullParameter(yooMoneyPaymentAuthorizationApiEndpoint, "yooMoneyPaymentAuthorizationApiEndpoint");
        this.yooMoneyLogoUrlLight = yooMoneyLogoUrlLight;
        this.yooMoneyLogoUrlDark = yooMoneyLogoUrlDark;
        this.paymentMethods = paymentMethods;
        this.savePaymentMethodOptionTexts = savePaymentMethodOptionTexts;
        this.userAgreementUrl = userAgreementUrl;
        this.googlePayGateway = googlePayGateway;
        this.yooMoneyApiEndpoint = yooMoneyApiEndpoint;
        this.yooMoneyPaymentAuthorizationApiEndpoint = yooMoneyPaymentAuthorizationApiEndpoint;
        this.yooMoneyAuthApiEndpoint = str;
        this.agentSchemeProviderAgreement = map;
    }

    /* renamed from: component1, reason: from getter */
    public final String getYooMoneyLogoUrlLight() {
        return this.yooMoneyLogoUrlLight;
    }

    public final Map<String, String> component10() {
        return this.agentSchemeProviderAgreement;
    }

    /* renamed from: component2, reason: from getter */
    public final String getYooMoneyLogoUrlDark() {
        return this.yooMoneyLogoUrlDark;
    }

    public final List<ConfigPaymentOption> component3() {
        return this.paymentMethods;
    }

    /* renamed from: component4, reason: from getter */
    public final SavePaymentMethodOptionTexts getSavePaymentMethodOptionTexts() {
        return this.savePaymentMethodOptionTexts;
    }

    /* renamed from: component5, reason: from getter */
    public final String getUserAgreementUrl() {
        return this.userAgreementUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final String getGooglePayGateway() {
        return this.googlePayGateway;
    }

    /* renamed from: component7, reason: from getter */
    public final String getYooMoneyApiEndpoint() {
        return this.yooMoneyApiEndpoint;
    }

    /* renamed from: component8, reason: from getter */
    public final String getYooMoneyPaymentAuthorizationApiEndpoint() {
        return this.yooMoneyPaymentAuthorizationApiEndpoint;
    }

    /* renamed from: component9, reason: from getter */
    public final String getYooMoneyAuthApiEndpoint() {
        return this.yooMoneyAuthApiEndpoint;
    }

    public final Config copy(String yooMoneyLogoUrlLight, String yooMoneyLogoUrlDark, List<ConfigPaymentOption> paymentMethods, SavePaymentMethodOptionTexts savePaymentMethodOptionTexts, String userAgreementUrl, String googlePayGateway, String yooMoneyApiEndpoint, String yooMoneyPaymentAuthorizationApiEndpoint, String yooMoneyAuthApiEndpoint, Map<String, String> agentSchemeProviderAgreement) {
        Intrinsics.checkNotNullParameter(yooMoneyLogoUrlLight, "yooMoneyLogoUrlLight");
        Intrinsics.checkNotNullParameter(yooMoneyLogoUrlDark, "yooMoneyLogoUrlDark");
        Intrinsics.checkNotNullParameter(paymentMethods, "paymentMethods");
        Intrinsics.checkNotNullParameter(savePaymentMethodOptionTexts, "savePaymentMethodOptionTexts");
        Intrinsics.checkNotNullParameter(userAgreementUrl, "userAgreementUrl");
        Intrinsics.checkNotNullParameter(googlePayGateway, "googlePayGateway");
        Intrinsics.checkNotNullParameter(yooMoneyApiEndpoint, "yooMoneyApiEndpoint");
        Intrinsics.checkNotNullParameter(yooMoneyPaymentAuthorizationApiEndpoint, "yooMoneyPaymentAuthorizationApiEndpoint");
        return new Config(yooMoneyLogoUrlLight, yooMoneyLogoUrlDark, paymentMethods, savePaymentMethodOptionTexts, userAgreementUrl, googlePayGateway, yooMoneyApiEndpoint, yooMoneyPaymentAuthorizationApiEndpoint, yooMoneyAuthApiEndpoint, agentSchemeProviderAgreement);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Config)) {
            return false;
        }
        Config config = (Config) other;
        return Intrinsics.areEqual(this.yooMoneyLogoUrlLight, config.yooMoneyLogoUrlLight) && Intrinsics.areEqual(this.yooMoneyLogoUrlDark, config.yooMoneyLogoUrlDark) && Intrinsics.areEqual(this.paymentMethods, config.paymentMethods) && Intrinsics.areEqual(this.savePaymentMethodOptionTexts, config.savePaymentMethodOptionTexts) && Intrinsics.areEqual(this.userAgreementUrl, config.userAgreementUrl) && Intrinsics.areEqual(this.googlePayGateway, config.googlePayGateway) && Intrinsics.areEqual(this.yooMoneyApiEndpoint, config.yooMoneyApiEndpoint) && Intrinsics.areEqual(this.yooMoneyPaymentAuthorizationApiEndpoint, config.yooMoneyPaymentAuthorizationApiEndpoint) && Intrinsics.areEqual(this.yooMoneyAuthApiEndpoint, config.yooMoneyAuthApiEndpoint) && Intrinsics.areEqual(this.agentSchemeProviderAgreement, config.agentSchemeProviderAgreement);
    }

    public final Map<String, String> getAgentSchemeProviderAgreement() {
        return this.agentSchemeProviderAgreement;
    }

    public final String getGooglePayGateway() {
        return this.googlePayGateway;
    }

    public final List<ConfigPaymentOption> getPaymentMethods() {
        return this.paymentMethods;
    }

    public final SavePaymentMethodOptionTexts getSavePaymentMethodOptionTexts() {
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
        int iA = AbstractC1553e.a(this.yooMoneyPaymentAuthorizationApiEndpoint, AbstractC1553e.a(this.yooMoneyApiEndpoint, AbstractC1553e.a(this.googlePayGateway, AbstractC1553e.a(this.userAgreementUrl, (this.savePaymentMethodOptionTexts.hashCode() + ((this.paymentMethods.hashCode() + AbstractC1553e.a(this.yooMoneyLogoUrlDark, this.yooMoneyLogoUrlLight.hashCode() * 31, 31)) * 31)) * 31, 31), 31), 31), 31);
        String str = this.yooMoneyAuthApiEndpoint;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, String> map = this.agentSchemeProviderAgreement;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "Config(yooMoneyLogoUrlLight=" + this.yooMoneyLogoUrlLight + ", yooMoneyLogoUrlDark=" + this.yooMoneyLogoUrlDark + ", paymentMethods=" + this.paymentMethods + ", savePaymentMethodOptionTexts=" + this.savePaymentMethodOptionTexts + ", userAgreementUrl=" + this.userAgreementUrl + ", googlePayGateway=" + this.googlePayGateway + ", yooMoneyApiEndpoint=" + this.yooMoneyApiEndpoint + ", yooMoneyPaymentAuthorizationApiEndpoint=" + this.yooMoneyPaymentAuthorizationApiEndpoint + ", yooMoneyAuthApiEndpoint=" + this.yooMoneyAuthApiEndpoint + ", agentSchemeProviderAgreement=" + this.agentSchemeProviderAgreement + ")";
    }
}
