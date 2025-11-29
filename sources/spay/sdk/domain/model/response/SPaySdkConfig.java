package spay.sdk.domain.model.response;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import npi.spay.AbstractC1901s;
import npi.spay.Q1;
import npi.spay.U0;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\u0005\u001e\u001f !\"B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\n\u0012\u0006\u0012\u0004\u0018\u00010\b`\t\u0012\u001a\u0010\n\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007j\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\t¢\u0006\u0002\u0010\u0011R%\u0010\n\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007j\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0006\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\n\u0012\u0006\u0012\u0004\u0018\u00010\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R%\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lspay/sdk/domain/model/response/SPaySdkConfig;", "", "version", "", "localization", "Lspay/sdk/domain/model/response/SPaySdkConfig$Localization;", "schemas", "Ljava/util/ArrayList;", "Lspay/sdk/domain/model/response/SPaySdkConfig$Schema;", "Lkotlin/collections/ArrayList;", "featuresToggle", "Lspay/sdk/domain/model/response/SPaySdkConfig$FeatureToggle;", "versionInfo", "Lspay/sdk/domain/model/response/SPaySdkConfig$VersionInfo;", "images", "Lspay/sdk/domain/model/response/SPaySdkConfig$Images;", "sslPins", "(Ljava/lang/String;Lspay/sdk/domain/model/response/SPaySdkConfig$Localization;Ljava/util/ArrayList;Ljava/util/ArrayList;Lspay/sdk/domain/model/response/SPaySdkConfig$VersionInfo;Lspay/sdk/domain/model/response/SPaySdkConfig$Images;Ljava/util/ArrayList;)V", "getFeaturesToggle", "()Ljava/util/ArrayList;", "getImages", "()Lspay/sdk/domain/model/response/SPaySdkConfig$Images;", "getLocalization", "()Lspay/sdk/domain/model/response/SPaySdkConfig$Localization;", "getSchemas", "getSslPins", "getVersion", "()Ljava/lang/String;", "getVersionInfo", "()Lspay/sdk/domain/model/response/SPaySdkConfig$VersionInfo;", "FeatureToggle", "Images", "Localization", "Schema", "VersionInfo", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SPaySdkConfig {
    private final ArrayList<FeatureToggle> featuresToggle;
    private final Images images;
    private final Localization localization;
    private final ArrayList<Schema> schemas;
    private final ArrayList<String> sslPins;
    private final String version;
    private final VersionInfo versionInfo;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lspay/sdk/domain/model/response/SPaySdkConfig$FeatureToggle;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "(Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getValue", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class FeatureToggle {
        private final String name;
        private final boolean value;

        public FeatureToggle(String name, boolean z) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.value = z;
        }

        public static /* synthetic */ FeatureToggle copy$default(FeatureToggle featureToggle, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = featureToggle.name;
            }
            if ((i & 2) != 0) {
                z = featureToggle.value;
            }
            return featureToggle.copy(str, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getValue() {
            return this.value;
        }

        public final FeatureToggle copy(String name, boolean value) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new FeatureToggle(name, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeatureToggle)) {
                return false;
            }
            FeatureToggle featureToggle = (FeatureToggle) other;
            return Intrinsics.areEqual(this.name, featureToggle.name) && this.value == featureToggle.value;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean getValue() {
            return this.value;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iHashCode = this.name.hashCode() * 31;
            boolean z = this.value;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("FeatureToggle(name=");
            sb.append(this.name);
            sb.append(", value=");
            return AbstractC1901s.a(sb, this.value, ')');
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lspay/sdk/domain/model/response/SPaySdkConfig$Images;", "", "logoIcon", "", "(Ljava/lang/String;)V", "getLogoIcon", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Images {
        private final String logoIcon;

        public Images(String logoIcon) {
            Intrinsics.checkNotNullParameter(logoIcon, "logoIcon");
            this.logoIcon = logoIcon;
        }

        public static /* synthetic */ Images copy$default(Images images, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = images.logoIcon;
            }
            return images.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLogoIcon() {
            return this.logoIcon;
        }

        public final Images copy(String logoIcon) {
            Intrinsics.checkNotNullParameter(logoIcon, "logoIcon");
            return new Images(logoIcon);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Images) && Intrinsics.areEqual(this.logoIcon, ((Images) other).logoIcon);
        }

        public final String getLogoIcon() {
            return this.logoIcon;
        }

        public int hashCode() {
            return this.logoIcon.hashCode();
        }

        public String toString() {
            return Q1.a(new StringBuilder("Images(logoIcon="), this.logoIcon, ')');
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lspay/sdk/domain/model/response/SPaySdkConfig$Localization;", "", "bankApp", "", "bankAppLoading", "payLoading", "payError", "enableSPay", "successEnableSPay", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBankApp", "()Ljava/lang/String;", "getBankAppLoading", "getEnableSPay", "getPayError", "getPayLoading", "getSuccessEnableSPay", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Localization {
        private final String bankApp;
        private final String bankAppLoading;
        private final String enableSPay;
        private final String payError;
        private final String payLoading;
        private final String successEnableSPay;

        public Localization(String bankApp, String bankAppLoading, String payLoading, String payError, String enableSPay, String successEnableSPay) {
            Intrinsics.checkNotNullParameter(bankApp, "bankApp");
            Intrinsics.checkNotNullParameter(bankAppLoading, "bankAppLoading");
            Intrinsics.checkNotNullParameter(payLoading, "payLoading");
            Intrinsics.checkNotNullParameter(payError, "payError");
            Intrinsics.checkNotNullParameter(enableSPay, "enableSPay");
            Intrinsics.checkNotNullParameter(successEnableSPay, "successEnableSPay");
            this.bankApp = bankApp;
            this.bankAppLoading = bankAppLoading;
            this.payLoading = payLoading;
            this.payError = payError;
            this.enableSPay = enableSPay;
            this.successEnableSPay = successEnableSPay;
        }

        public static /* synthetic */ Localization copy$default(Localization localization, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = localization.bankApp;
            }
            if ((i & 2) != 0) {
                str2 = localization.bankAppLoading;
            }
            String str7 = str2;
            if ((i & 4) != 0) {
                str3 = localization.payLoading;
            }
            String str8 = str3;
            if ((i & 8) != 0) {
                str4 = localization.payError;
            }
            String str9 = str4;
            if ((i & 16) != 0) {
                str5 = localization.enableSPay;
            }
            String str10 = str5;
            if ((i & 32) != 0) {
                str6 = localization.successEnableSPay;
            }
            return localization.copy(str, str7, str8, str9, str10, str6);
        }

        /* renamed from: component1, reason: from getter */
        public final String getBankApp() {
            return this.bankApp;
        }

        /* renamed from: component2, reason: from getter */
        public final String getBankAppLoading() {
            return this.bankAppLoading;
        }

        /* renamed from: component3, reason: from getter */
        public final String getPayLoading() {
            return this.payLoading;
        }

        /* renamed from: component4, reason: from getter */
        public final String getPayError() {
            return this.payError;
        }

        /* renamed from: component5, reason: from getter */
        public final String getEnableSPay() {
            return this.enableSPay;
        }

        /* renamed from: component6, reason: from getter */
        public final String getSuccessEnableSPay() {
            return this.successEnableSPay;
        }

        public final Localization copy(String bankApp, String bankAppLoading, String payLoading, String payError, String enableSPay, String successEnableSPay) {
            Intrinsics.checkNotNullParameter(bankApp, "bankApp");
            Intrinsics.checkNotNullParameter(bankAppLoading, "bankAppLoading");
            Intrinsics.checkNotNullParameter(payLoading, "payLoading");
            Intrinsics.checkNotNullParameter(payError, "payError");
            Intrinsics.checkNotNullParameter(enableSPay, "enableSPay");
            Intrinsics.checkNotNullParameter(successEnableSPay, "successEnableSPay");
            return new Localization(bankApp, bankAppLoading, payLoading, payError, enableSPay, successEnableSPay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Localization)) {
                return false;
            }
            Localization localization = (Localization) other;
            return Intrinsics.areEqual(this.bankApp, localization.bankApp) && Intrinsics.areEqual(this.bankAppLoading, localization.bankAppLoading) && Intrinsics.areEqual(this.payLoading, localization.payLoading) && Intrinsics.areEqual(this.payError, localization.payError) && Intrinsics.areEqual(this.enableSPay, localization.enableSPay) && Intrinsics.areEqual(this.successEnableSPay, localization.successEnableSPay);
        }

        public final String getBankApp() {
            return this.bankApp;
        }

        public final String getBankAppLoading() {
            return this.bankAppLoading;
        }

        public final String getEnableSPay() {
            return this.enableSPay;
        }

        public final String getPayError() {
            return this.payError;
        }

        public final String getPayLoading() {
            return this.payLoading;
        }

        public final String getSuccessEnableSPay() {
            return this.successEnableSPay;
        }

        public int hashCode() {
            return this.successEnableSPay.hashCode() + AbstractC1553e.a(this.enableSPay, AbstractC1553e.a(this.payError, AbstractC1553e.a(this.payLoading, AbstractC1553e.a(this.bankAppLoading, this.bankApp.hashCode() * 31, 31), 31), 31), 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Localization(bankApp=");
            sb.append(this.bankApp);
            sb.append(", bankAppLoading=");
            sb.append(this.bankAppLoading);
            sb.append(", payLoading=");
            sb.append(this.payLoading);
            sb.append(", payError=");
            sb.append(this.payError);
            sb.append(", enableSPay=");
            sb.append(this.enableSPay);
            sb.append(", successEnableSPay=");
            return Q1.a(sb, this.successEnableSPay, ')');
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JS\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lspay/sdk/domain/model/response/SPaySdkConfig$Schema;", "", "stand", "", "bankAppAuthUri", "dynatraceBeaconUri", "dynatraceApplicationId", "getIpUrl", "clickStreamUrl", "clickStreamAppId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBankAppAuthUri", "()Ljava/lang/String;", "getClickStreamAppId", "getClickStreamUrl", "getDynatraceApplicationId", "getDynatraceBeaconUri", "getGetIpUrl", "getStand", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Schema {
        private final String bankAppAuthUri;
        private final String clickStreamAppId;
        private final String clickStreamUrl;
        private final String dynatraceApplicationId;
        private final String dynatraceBeaconUri;
        private final String getIpUrl;
        private final String stand;

        public Schema(String stand, String bankAppAuthUri, String dynatraceBeaconUri, String dynatraceApplicationId, String getIpUrl, String str, String str2) {
            Intrinsics.checkNotNullParameter(stand, "stand");
            Intrinsics.checkNotNullParameter(bankAppAuthUri, "bankAppAuthUri");
            Intrinsics.checkNotNullParameter(dynatraceBeaconUri, "dynatraceBeaconUri");
            Intrinsics.checkNotNullParameter(dynatraceApplicationId, "dynatraceApplicationId");
            Intrinsics.checkNotNullParameter(getIpUrl, "getIpUrl");
            this.stand = stand;
            this.bankAppAuthUri = bankAppAuthUri;
            this.dynatraceBeaconUri = dynatraceBeaconUri;
            this.dynatraceApplicationId = dynatraceApplicationId;
            this.getIpUrl = getIpUrl;
            this.clickStreamUrl = str;
            this.clickStreamAppId = str2;
        }

        public static /* synthetic */ Schema copy$default(Schema schema, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
            if ((i & 1) != 0) {
                str = schema.stand;
            }
            if ((i & 2) != 0) {
                str2 = schema.bankAppAuthUri;
            }
            String str8 = str2;
            if ((i & 4) != 0) {
                str3 = schema.dynatraceBeaconUri;
            }
            String str9 = str3;
            if ((i & 8) != 0) {
                str4 = schema.dynatraceApplicationId;
            }
            String str10 = str4;
            if ((i & 16) != 0) {
                str5 = schema.getIpUrl;
            }
            String str11 = str5;
            if ((i & 32) != 0) {
                str6 = schema.clickStreamUrl;
            }
            String str12 = str6;
            if ((i & 64) != 0) {
                str7 = schema.clickStreamAppId;
            }
            return schema.copy(str, str8, str9, str10, str11, str12, str7);
        }

        /* renamed from: component1, reason: from getter */
        public final String getStand() {
            return this.stand;
        }

        /* renamed from: component2, reason: from getter */
        public final String getBankAppAuthUri() {
            return this.bankAppAuthUri;
        }

        /* renamed from: component3, reason: from getter */
        public final String getDynatraceBeaconUri() {
            return this.dynatraceBeaconUri;
        }

        /* renamed from: component4, reason: from getter */
        public final String getDynatraceApplicationId() {
            return this.dynatraceApplicationId;
        }

        /* renamed from: component5, reason: from getter */
        public final String getGetIpUrl() {
            return this.getIpUrl;
        }

        /* renamed from: component6, reason: from getter */
        public final String getClickStreamUrl() {
            return this.clickStreamUrl;
        }

        /* renamed from: component7, reason: from getter */
        public final String getClickStreamAppId() {
            return this.clickStreamAppId;
        }

        public final Schema copy(String stand, String bankAppAuthUri, String dynatraceBeaconUri, String dynatraceApplicationId, String getIpUrl, String clickStreamUrl, String clickStreamAppId) {
            Intrinsics.checkNotNullParameter(stand, "stand");
            Intrinsics.checkNotNullParameter(bankAppAuthUri, "bankAppAuthUri");
            Intrinsics.checkNotNullParameter(dynatraceBeaconUri, "dynatraceBeaconUri");
            Intrinsics.checkNotNullParameter(dynatraceApplicationId, "dynatraceApplicationId");
            Intrinsics.checkNotNullParameter(getIpUrl, "getIpUrl");
            return new Schema(stand, bankAppAuthUri, dynatraceBeaconUri, dynatraceApplicationId, getIpUrl, clickStreamUrl, clickStreamAppId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Schema)) {
                return false;
            }
            Schema schema = (Schema) other;
            return Intrinsics.areEqual(this.stand, schema.stand) && Intrinsics.areEqual(this.bankAppAuthUri, schema.bankAppAuthUri) && Intrinsics.areEqual(this.dynatraceBeaconUri, schema.dynatraceBeaconUri) && Intrinsics.areEqual(this.dynatraceApplicationId, schema.dynatraceApplicationId) && Intrinsics.areEqual(this.getIpUrl, schema.getIpUrl) && Intrinsics.areEqual(this.clickStreamUrl, schema.clickStreamUrl) && Intrinsics.areEqual(this.clickStreamAppId, schema.clickStreamAppId);
        }

        public final String getBankAppAuthUri() {
            return this.bankAppAuthUri;
        }

        public final String getClickStreamAppId() {
            return this.clickStreamAppId;
        }

        public final String getClickStreamUrl() {
            return this.clickStreamUrl;
        }

        public final String getDynatraceApplicationId() {
            return this.dynatraceApplicationId;
        }

        public final String getDynatraceBeaconUri() {
            return this.dynatraceBeaconUri;
        }

        public final String getGetIpUrl() {
            return this.getIpUrl;
        }

        public final String getStand() {
            return this.stand;
        }

        public int hashCode() {
            int iA = AbstractC1553e.a(this.getIpUrl, AbstractC1553e.a(this.dynatraceApplicationId, AbstractC1553e.a(this.dynatraceBeaconUri, AbstractC1553e.a(this.bankAppAuthUri, this.stand.hashCode() * 31, 31), 31), 31), 31);
            String str = this.clickStreamUrl;
            int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.clickStreamAppId;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Schema(stand=");
            sb.append(this.stand);
            sb.append(", bankAppAuthUri=");
            sb.append(this.bankAppAuthUri);
            sb.append(", dynatraceBeaconUri=");
            sb.append(this.dynatraceBeaconUri);
            sb.append(", dynatraceApplicationId=");
            sb.append(this.dynatraceApplicationId);
            sb.append(", getIpUrl=");
            sb.append(this.getIpUrl);
            sb.append(", clickStreamUrl=");
            sb.append(this.clickStreamUrl);
            sb.append(", clickStreamAppId=");
            return Q1.a(sb, this.clickStreamAppId, ')');
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lspay/sdk/domain/model/response/SPaySdkConfig$VersionInfo;", "", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "", "deprecated", "", "(Ljava/lang/String;Ljava/util/List;)V", "getActive", "()Ljava/lang/String;", "getDeprecated", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class VersionInfo {
        private final String active;
        private final List<String> deprecated;

        public VersionInfo(String active, List<String> deprecated) {
            Intrinsics.checkNotNullParameter(active, "active");
            Intrinsics.checkNotNullParameter(deprecated, "deprecated");
            this.active = active;
            this.deprecated = deprecated;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VersionInfo copy$default(VersionInfo versionInfo, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = versionInfo.active;
            }
            if ((i & 2) != 0) {
                list = versionInfo.deprecated;
            }
            return versionInfo.copy(str, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getActive() {
            return this.active;
        }

        public final List<String> component2() {
            return this.deprecated;
        }

        public final VersionInfo copy(String active, List<String> deprecated) {
            Intrinsics.checkNotNullParameter(active, "active");
            Intrinsics.checkNotNullParameter(deprecated, "deprecated");
            return new VersionInfo(active, deprecated);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VersionInfo)) {
                return false;
            }
            VersionInfo versionInfo = (VersionInfo) other;
            return Intrinsics.areEqual(this.active, versionInfo.active) && Intrinsics.areEqual(this.deprecated, versionInfo.deprecated);
        }

        public final String getActive() {
            return this.active;
        }

        public final List<String> getDeprecated() {
            return this.deprecated;
        }

        public int hashCode() {
            return this.deprecated.hashCode() + (this.active.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("VersionInfo(active=");
            sb.append(this.active);
            sb.append(", deprecated=");
            return U0.a(sb, this.deprecated, ')');
        }
    }

    public SPaySdkConfig(String version, Localization localization, ArrayList<Schema> schemas, ArrayList<FeatureToggle> featuresToggle, VersionInfo versionInfo, Images images, ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(schemas, "schemas");
        Intrinsics.checkNotNullParameter(featuresToggle, "featuresToggle");
        Intrinsics.checkNotNullParameter(images, "images");
        this.version = version;
        this.localization = localization;
        this.schemas = schemas;
        this.featuresToggle = featuresToggle;
        this.versionInfo = versionInfo;
        this.images = images;
        this.sslPins = arrayList;
    }

    public final ArrayList<FeatureToggle> getFeaturesToggle() {
        return this.featuresToggle;
    }

    public final Images getImages() {
        return this.images;
    }

    public final Localization getLocalization() {
        return this.localization;
    }

    public final ArrayList<Schema> getSchemas() {
        return this.schemas;
    }

    public final ArrayList<String> getSslPins() {
        return this.sslPins;
    }

    public final String getVersion() {
        return this.version;
    }

    public final VersionInfo getVersionInfo() {
        return this.versionInfo;
    }
}
