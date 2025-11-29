package spay.sdk.data.dto.response;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Kg;
import npi.spay.Q1;
import npi.spay.U0;
import spay.sdk.domain.model.response.SPaySdkConfig;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005/0123B\u0089\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u001e\u0010\u0007\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bj\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\bj\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\n¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010!\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bj\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\nHÆ\u0003J!\u0010\"\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\bj\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u001d\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\nHÆ\u0003J\u009b\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bj\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n2 \b\u0002\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\bj\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\nHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\b\u0010-\u001a\u00020\u0002H\u0016J\t\u0010.\u001a\u00020\u0004HÖ\u0001R.\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\bj\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R.\u0010\u0007\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bj\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R*\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00064"}, d2 = {"Lspay/sdk/data/dto/response/SPaySdkConfigDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/SPaySdkConfig;", "version", "", "localization", "Lspay/sdk/data/dto/response/SPaySdkConfigDto$LocalizationDto;", "schemas", "Ljava/util/ArrayList;", "Lspay/sdk/data/dto/response/SPaySdkConfigDto$SchemaDto;", "Lkotlin/collections/ArrayList;", "featuresToggle", "Lspay/sdk/data/dto/response/SPaySdkConfigDto$FeatureToggleDto;", "images", "Lspay/sdk/data/dto/response/SPaySdkConfigDto$ImagesDto;", "versionInfoDto", "Lspay/sdk/data/dto/response/SPaySdkConfigDto$VersionInfoDto;", "sslPins", "(Ljava/lang/String;Lspay/sdk/data/dto/response/SPaySdkConfigDto$LocalizationDto;Ljava/util/ArrayList;Ljava/util/ArrayList;Lspay/sdk/data/dto/response/SPaySdkConfigDto$ImagesDto;Lspay/sdk/data/dto/response/SPaySdkConfigDto$VersionInfoDto;Ljava/util/ArrayList;)V", "getFeaturesToggle", "()Ljava/util/ArrayList;", "getImages", "()Lspay/sdk/data/dto/response/SPaySdkConfigDto$ImagesDto;", "getLocalization", "()Lspay/sdk/data/dto/response/SPaySdkConfigDto$LocalizationDto;", "getSchemas", "getSslPins", "getVersion", "()Ljava/lang/String;", "getVersionInfoDto", "()Lspay/sdk/data/dto/response/SPaySdkConfigDto$VersionInfoDto;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toModel", "toString", "FeatureToggleDto", "ImagesDto", "LocalizationDto", "SchemaDto", "VersionInfoDto", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SPaySdkConfigDto implements DataDtoInterface<SPaySdkConfig> {

    @SerializedName("featuresToggle")
    private final ArrayList<FeatureToggleDto> featuresToggle;

    @SerializedName("images")
    private final ImagesDto images;

    @SerializedName("localization")
    private final LocalizationDto localization;

    @SerializedName("schemas")
    private final ArrayList<SchemaDto> schemas;

    @SerializedName("sslPins")
    private final ArrayList<String> sslPins;

    @SerializedName("version")
    private final String version;

    @SerializedName("versionInfo")
    private final VersionInfoDto versionInfoDto;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lspay/sdk/data/dto/response/SPaySdkConfigDto$FeatureToggleDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/SPaySdkConfig$FeatureToggle;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getName", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lspay/sdk/data/dto/response/SPaySdkConfigDto$FeatureToggleDto;", "equals", "other", "", "hashCode", "", "toModel", "toString", "Companion", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class FeatureToggleDto implements DataDtoInterface<SPaySdkConfig.FeatureToggle> {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
        private final String name;

        @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)
        private final Boolean value;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006*\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\u0006¨\u0006\b"}, d2 = {"Lspay/sdk/data/dto/response/SPaySdkConfigDto$FeatureToggleDto$Companion;", "", "()V", "toModelArray", "Ljava/util/ArrayList;", "Lspay/sdk/domain/model/response/SPaySdkConfig$FeatureToggle;", "Lkotlin/collections/ArrayList;", "Lspay/sdk/data/dto/response/SPaySdkConfigDto$FeatureToggleDto;", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ArrayList<SPaySdkConfig.FeatureToggle> toModelArray(ArrayList<FeatureToggleDto> arrayList) {
                Intrinsics.checkNotNullParameter(arrayList, "<this>");
                ArrayList<SPaySdkConfig.FeatureToggle> arrayList2 = new ArrayList<>();
                Iterator<FeatureToggleDto> it = arrayList.iterator();
                while (it.hasNext()) {
                    FeatureToggleDto next = it.next();
                    arrayList2.add(next != null ? next.toModel() : null);
                }
                return arrayList2;
            }
        }

        public FeatureToggleDto(String str, Boolean bool) {
            this.name = str;
            this.value = bool;
        }

        public static /* synthetic */ FeatureToggleDto copy$default(FeatureToggleDto featureToggleDto, String str, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = featureToggleDto.name;
            }
            if ((i & 2) != 0) {
                bool = featureToggleDto.value;
            }
            return featureToggleDto.copy(str, bool);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getValue() {
            return this.value;
        }

        public final FeatureToggleDto copy(String name, Boolean value) {
            return new FeatureToggleDto(name, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeatureToggleDto)) {
                return false;
            }
            FeatureToggleDto featureToggleDto = (FeatureToggleDto) other;
            return Intrinsics.areEqual(this.name, featureToggleDto.name) && Intrinsics.areEqual(this.value, featureToggleDto.value);
        }

        public final String getName() {
            return this.name;
        }

        public final Boolean getValue() {
            return this.value;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Boolean bool = this.value;
            return iHashCode + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "FeatureToggleDto(name=" + this.name + ", value=" + this.value + ')';
        }

        @Override // spay.sdk.data.dto.response.DataDtoInterface
        public SPaySdkConfig.FeatureToggle toModel() {
            String str = this.name;
            if (str == null) {
                throw new Kg(AppMeasurementSdk.ConditionalUserProperty.NAME);
            }
            Boolean bool = this.value;
            if (bool != null) {
                return new SPaySdkConfig.FeatureToggle(str, bool.booleanValue());
            }
            throw new Kg(AppMeasurementSdk.ConditionalUserProperty.VALUE);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lspay/sdk/data/dto/response/SPaySdkConfigDto$ImagesDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/SPaySdkConfig$Images;", "logoIcon", "", "(Ljava/lang/String;)V", "getLogoIcon", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toModel", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ImagesDto implements DataDtoInterface<SPaySdkConfig.Images> {

        @SerializedName("logoIcon")
        private final String logoIcon;

        public ImagesDto(String str) {
            this.logoIcon = str;
        }

        public static /* synthetic */ ImagesDto copy$default(ImagesDto imagesDto, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = imagesDto.logoIcon;
            }
            return imagesDto.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLogoIcon() {
            return this.logoIcon;
        }

        public final ImagesDto copy(String logoIcon) {
            return new ImagesDto(logoIcon);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ImagesDto) && Intrinsics.areEqual(this.logoIcon, ((ImagesDto) other).logoIcon);
        }

        public final String getLogoIcon() {
            return this.logoIcon;
        }

        public int hashCode() {
            String str = this.logoIcon;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return Q1.a(new StringBuilder("ImagesDto(logoIcon="), this.logoIcon, ')');
        }

        @Override // spay.sdk.data.dto.response.DataDtoInterface
        public SPaySdkConfig.Images toModel() {
            String str = this.logoIcon;
            if (str != null) {
                return new SPaySdkConfig.Images(str);
            }
            throw new Kg("logoIcon");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BA\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003JQ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\t\u0010 \u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006!"}, d2 = {"Lspay/sdk/data/dto/response/SPaySdkConfigDto$LocalizationDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/SPaySdkConfig$Localization;", "bankApp", "", "bankAppLoading", "payLoading", "payError", "enableSPay", "successEnableSPay", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBankApp", "()Ljava/lang/String;", "getBankAppLoading", "getEnableSPay", "getPayError", "getPayLoading", "getSuccessEnableSPay", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toModel", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class LocalizationDto implements DataDtoInterface<SPaySdkConfig.Localization> {

        @SerializedName("bankApp")
        private final String bankApp;

        @SerializedName("bankAppLoading")
        private final String bankAppLoading;

        @SerializedName("enableSPay")
        private final String enableSPay;

        @SerializedName("payError")
        private final String payError;

        @SerializedName("payLoading")
        private final String payLoading;

        @SerializedName("successEnableSPay")
        private final String successEnableSPay;

        public LocalizationDto(String str, String str2, String str3, String str4, String str5, String str6) {
            this.bankApp = str;
            this.bankAppLoading = str2;
            this.payLoading = str3;
            this.payError = str4;
            this.enableSPay = str5;
            this.successEnableSPay = str6;
        }

        public static /* synthetic */ LocalizationDto copy$default(LocalizationDto localizationDto, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = localizationDto.bankApp;
            }
            if ((i & 2) != 0) {
                str2 = localizationDto.bankAppLoading;
            }
            String str7 = str2;
            if ((i & 4) != 0) {
                str3 = localizationDto.payLoading;
            }
            String str8 = str3;
            if ((i & 8) != 0) {
                str4 = localizationDto.payError;
            }
            String str9 = str4;
            if ((i & 16) != 0) {
                str5 = localizationDto.enableSPay;
            }
            String str10 = str5;
            if ((i & 32) != 0) {
                str6 = localizationDto.successEnableSPay;
            }
            return localizationDto.copy(str, str7, str8, str9, str10, str6);
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

        public final LocalizationDto copy(String bankApp, String bankAppLoading, String payLoading, String payError, String enableSPay, String successEnableSPay) {
            return new LocalizationDto(bankApp, bankAppLoading, payLoading, payError, enableSPay, successEnableSPay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LocalizationDto)) {
                return false;
            }
            LocalizationDto localizationDto = (LocalizationDto) other;
            return Intrinsics.areEqual(this.bankApp, localizationDto.bankApp) && Intrinsics.areEqual(this.bankAppLoading, localizationDto.bankAppLoading) && Intrinsics.areEqual(this.payLoading, localizationDto.payLoading) && Intrinsics.areEqual(this.payError, localizationDto.payError) && Intrinsics.areEqual(this.enableSPay, localizationDto.enableSPay) && Intrinsics.areEqual(this.successEnableSPay, localizationDto.successEnableSPay);
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
            String str = this.bankApp;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.bankAppLoading;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.payLoading;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.payError;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.enableSPay;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.successEnableSPay;
            return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("LocalizationDto(bankApp=");
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

        @Override // spay.sdk.data.dto.response.DataDtoInterface
        public SPaySdkConfig.Localization toModel() {
            String str = this.bankApp;
            if (str == null) {
                throw new Kg("bankApp");
            }
            String str2 = this.bankAppLoading;
            if (str2 == null) {
                throw new Kg("bankAppLoading");
            }
            String str3 = this.payLoading;
            if (str3 == null) {
                throw new Kg("payLoading");
            }
            String str4 = this.payError;
            if (str4 == null) {
                throw new Kg("payError");
            }
            String str5 = this.enableSPay;
            if (str5 == null) {
                throw new Kg("enableSPay");
            }
            String str6 = this.successEnableSPay;
            if (str6 != null) {
                return new SPaySdkConfig.Localization(str, str2, str3, str4, str5, str6);
            }
            throw new Kg("successEnableSPay");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$BK\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J]\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\b\u0010\"\u001a\u00020\u0002H\u0016J\t\u0010#\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006%"}, d2 = {"Lspay/sdk/data/dto/response/SPaySdkConfigDto$SchemaDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/SPaySdkConfig$Schema;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "bankAppAuthUri", "dynatraceBeaconUri", "dynatraceApplicationId", "getIpServiceUrl", "clickStreamUrl", "clickStreamAppId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBankAppAuthUri", "()Ljava/lang/String;", "getClickStreamAppId", "getClickStreamUrl", "getDynatraceApplicationId", "getDynatraceBeaconUri", "getGetIpServiceUrl", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toModel", "toString", "Companion", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class SchemaDto implements DataDtoInterface<SPaySdkConfig.Schema> {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @SerializedName("baau")
        private final String bankAppAuthUri;

        @SerializedName("clsai")
        private final String clickStreamAppId;

        @SerializedName("clsu")
        private final String clickStreamUrl;

        @SerializedName("dtaid")
        private final String dynatraceApplicationId;

        @SerializedName("dtbu")
        private final String dynatraceBeaconUri;

        @SerializedName("giu")
        private final String getIpServiceUrl;

        @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
        private final String name;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006*\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\u0006¨\u0006\b"}, d2 = {"Lspay/sdk/data/dto/response/SPaySdkConfigDto$SchemaDto$Companion;", "", "()V", "toModelArray", "Ljava/util/ArrayList;", "Lspay/sdk/domain/model/response/SPaySdkConfig$Schema;", "Lkotlin/collections/ArrayList;", "Lspay/sdk/data/dto/response/SPaySdkConfigDto$SchemaDto;", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ArrayList<SPaySdkConfig.Schema> toModelArray(ArrayList<SchemaDto> arrayList) {
                Intrinsics.checkNotNullParameter(arrayList, "<this>");
                ArrayList<SPaySdkConfig.Schema> arrayList2 = new ArrayList<>();
                Iterator<SchemaDto> it = arrayList.iterator();
                while (it.hasNext()) {
                    SchemaDto next = it.next();
                    arrayList2.add(next != null ? next.toModel() : null);
                }
                return arrayList2;
            }
        }

        public SchemaDto(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.name = str;
            this.bankAppAuthUri = str2;
            this.dynatraceBeaconUri = str3;
            this.dynatraceApplicationId = str4;
            this.getIpServiceUrl = str5;
            this.clickStreamUrl = str6;
            this.clickStreamAppId = str7;
        }

        public static /* synthetic */ SchemaDto copy$default(SchemaDto schemaDto, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
            if ((i & 1) != 0) {
                str = schemaDto.name;
            }
            if ((i & 2) != 0) {
                str2 = schemaDto.bankAppAuthUri;
            }
            String str8 = str2;
            if ((i & 4) != 0) {
                str3 = schemaDto.dynatraceBeaconUri;
            }
            String str9 = str3;
            if ((i & 8) != 0) {
                str4 = schemaDto.dynatraceApplicationId;
            }
            String str10 = str4;
            if ((i & 16) != 0) {
                str5 = schemaDto.getIpServiceUrl;
            }
            String str11 = str5;
            if ((i & 32) != 0) {
                str6 = schemaDto.clickStreamUrl;
            }
            String str12 = str6;
            if ((i & 64) != 0) {
                str7 = schemaDto.clickStreamAppId;
            }
            return schemaDto.copy(str, str8, str9, str10, str11, str12, str7);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
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
        public final String getGetIpServiceUrl() {
            return this.getIpServiceUrl;
        }

        /* renamed from: component6, reason: from getter */
        public final String getClickStreamUrl() {
            return this.clickStreamUrl;
        }

        /* renamed from: component7, reason: from getter */
        public final String getClickStreamAppId() {
            return this.clickStreamAppId;
        }

        public final SchemaDto copy(String name, String bankAppAuthUri, String dynatraceBeaconUri, String dynatraceApplicationId, String getIpServiceUrl, String clickStreamUrl, String clickStreamAppId) {
            return new SchemaDto(name, bankAppAuthUri, dynatraceBeaconUri, dynatraceApplicationId, getIpServiceUrl, clickStreamUrl, clickStreamAppId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SchemaDto)) {
                return false;
            }
            SchemaDto schemaDto = (SchemaDto) other;
            return Intrinsics.areEqual(this.name, schemaDto.name) && Intrinsics.areEqual(this.bankAppAuthUri, schemaDto.bankAppAuthUri) && Intrinsics.areEqual(this.dynatraceBeaconUri, schemaDto.dynatraceBeaconUri) && Intrinsics.areEqual(this.dynatraceApplicationId, schemaDto.dynatraceApplicationId) && Intrinsics.areEqual(this.getIpServiceUrl, schemaDto.getIpServiceUrl) && Intrinsics.areEqual(this.clickStreamUrl, schemaDto.clickStreamUrl) && Intrinsics.areEqual(this.clickStreamAppId, schemaDto.clickStreamAppId);
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

        public final String getGetIpServiceUrl() {
            return this.getIpServiceUrl;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.bankAppAuthUri;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.dynatraceBeaconUri;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.dynatraceApplicationId;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.getIpServiceUrl;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.clickStreamUrl;
            int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.clickStreamAppId;
            return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("SchemaDto(name=");
            sb.append(this.name);
            sb.append(", bankAppAuthUri=");
            sb.append(this.bankAppAuthUri);
            sb.append(", dynatraceBeaconUri=");
            sb.append(this.dynatraceBeaconUri);
            sb.append(", dynatraceApplicationId=");
            sb.append(this.dynatraceApplicationId);
            sb.append(", getIpServiceUrl=");
            sb.append(this.getIpServiceUrl);
            sb.append(", clickStreamUrl=");
            sb.append(this.clickStreamUrl);
            sb.append(", clickStreamAppId=");
            return Q1.a(sb, this.clickStreamAppId, ')');
        }

        @Override // spay.sdk.data.dto.response.DataDtoInterface
        public SPaySdkConfig.Schema toModel() {
            String str = this.name;
            if (str == null) {
                throw new Kg(AppMeasurementSdk.ConditionalUserProperty.NAME);
            }
            String str2 = this.bankAppAuthUri;
            if (str2 == null) {
                throw new Kg("bankAppAuthUri");
            }
            String str3 = this.dynatraceBeaconUri;
            if (str3 == null) {
                throw new Kg("dynatraceBeaconUri");
            }
            String str4 = this.dynatraceApplicationId;
            if (str4 == null) {
                throw new Kg("dynatraceApplicationId");
            }
            String str5 = this.getIpServiceUrl;
            if (str5 != null) {
                return new SPaySdkConfig.Schema(str, str2, str3, str4, str5, this.clickStreamUrl, this.clickStreamAppId);
            }
            throw new Kg("getIpServiceUrl");
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0013\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lspay/sdk/data/dto/response/SPaySdkConfigDto$VersionInfoDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/SPaySdkConfig$VersionInfo;", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "", "deprecated", "", "(Ljava/lang/String;Ljava/util/List;)V", "getActive", "()Ljava/lang/String;", "getDeprecated", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toModel", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class VersionInfoDto implements DataDtoInterface<SPaySdkConfig.VersionInfo> {

        @SerializedName(AppMeasurementSdk.ConditionalUserProperty.ACTIVE)
        private final String active;

        @SerializedName("deprecated")
        private final List<String> deprecated;

        public VersionInfoDto(String str, List<String> list) {
            this.active = str;
            this.deprecated = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VersionInfoDto copy$default(VersionInfoDto versionInfoDto, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = versionInfoDto.active;
            }
            if ((i & 2) != 0) {
                list = versionInfoDto.deprecated;
            }
            return versionInfoDto.copy(str, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getActive() {
            return this.active;
        }

        public final List<String> component2() {
            return this.deprecated;
        }

        public final VersionInfoDto copy(String active, List<String> deprecated) {
            return new VersionInfoDto(active, deprecated);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VersionInfoDto)) {
                return false;
            }
            VersionInfoDto versionInfoDto = (VersionInfoDto) other;
            return Intrinsics.areEqual(this.active, versionInfoDto.active) && Intrinsics.areEqual(this.deprecated, versionInfoDto.deprecated);
        }

        public final String getActive() {
            return this.active;
        }

        public final List<String> getDeprecated() {
            return this.deprecated;
        }

        public int hashCode() {
            String str = this.active;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            List<String> list = this.deprecated;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("VersionInfoDto(active=");
            sb.append(this.active);
            sb.append(", deprecated=");
            return U0.a(sb, this.deprecated, ')');
        }

        @Override // spay.sdk.data.dto.response.DataDtoInterface
        public SPaySdkConfig.VersionInfo toModel() {
            List listEmptyList;
            String str = this.active;
            if (str == null) {
                str = "";
            }
            List<String> list = this.deprecated;
            if (list == null || (listEmptyList = CollectionsKt.filterNotNull(list)) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return new SPaySdkConfig.VersionInfo(str, listEmptyList);
        }
    }

    public SPaySdkConfigDto(String str, LocalizationDto localizationDto, ArrayList<SchemaDto> arrayList, ArrayList<FeatureToggleDto> arrayList2, ImagesDto imagesDto, VersionInfoDto versionInfoDto, ArrayList<String> arrayList3) {
        this.version = str;
        this.localization = localizationDto;
        this.schemas = arrayList;
        this.featuresToggle = arrayList2;
        this.images = imagesDto;
        this.versionInfoDto = versionInfoDto;
        this.sslPins = arrayList3;
    }

    public static /* synthetic */ SPaySdkConfigDto copy$default(SPaySdkConfigDto sPaySdkConfigDto, String str, LocalizationDto localizationDto, ArrayList arrayList, ArrayList arrayList2, ImagesDto imagesDto, VersionInfoDto versionInfoDto, ArrayList arrayList3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sPaySdkConfigDto.version;
        }
        if ((i & 2) != 0) {
            localizationDto = sPaySdkConfigDto.localization;
        }
        LocalizationDto localizationDto2 = localizationDto;
        if ((i & 4) != 0) {
            arrayList = sPaySdkConfigDto.schemas;
        }
        ArrayList arrayList4 = arrayList;
        if ((i & 8) != 0) {
            arrayList2 = sPaySdkConfigDto.featuresToggle;
        }
        ArrayList arrayList5 = arrayList2;
        if ((i & 16) != 0) {
            imagesDto = sPaySdkConfigDto.images;
        }
        ImagesDto imagesDto2 = imagesDto;
        if ((i & 32) != 0) {
            versionInfoDto = sPaySdkConfigDto.versionInfoDto;
        }
        VersionInfoDto versionInfoDto2 = versionInfoDto;
        if ((i & 64) != 0) {
            arrayList3 = sPaySdkConfigDto.sslPins;
        }
        return sPaySdkConfigDto.copy(str, localizationDto2, arrayList4, arrayList5, imagesDto2, versionInfoDto2, arrayList3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalizationDto getLocalization() {
        return this.localization;
    }

    public final ArrayList<SchemaDto> component3() {
        return this.schemas;
    }

    public final ArrayList<FeatureToggleDto> component4() {
        return this.featuresToggle;
    }

    /* renamed from: component5, reason: from getter */
    public final ImagesDto getImages() {
        return this.images;
    }

    /* renamed from: component6, reason: from getter */
    public final VersionInfoDto getVersionInfoDto() {
        return this.versionInfoDto;
    }

    public final ArrayList<String> component7() {
        return this.sslPins;
    }

    public final SPaySdkConfigDto copy(String version, LocalizationDto localization, ArrayList<SchemaDto> schemas, ArrayList<FeatureToggleDto> featuresToggle, ImagesDto images, VersionInfoDto versionInfoDto, ArrayList<String> sslPins) {
        return new SPaySdkConfigDto(version, localization, schemas, featuresToggle, images, versionInfoDto, sslPins);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SPaySdkConfigDto)) {
            return false;
        }
        SPaySdkConfigDto sPaySdkConfigDto = (SPaySdkConfigDto) other;
        return Intrinsics.areEqual(this.version, sPaySdkConfigDto.version) && Intrinsics.areEqual(this.localization, sPaySdkConfigDto.localization) && Intrinsics.areEqual(this.schemas, sPaySdkConfigDto.schemas) && Intrinsics.areEqual(this.featuresToggle, sPaySdkConfigDto.featuresToggle) && Intrinsics.areEqual(this.images, sPaySdkConfigDto.images) && Intrinsics.areEqual(this.versionInfoDto, sPaySdkConfigDto.versionInfoDto) && Intrinsics.areEqual(this.sslPins, sPaySdkConfigDto.sslPins);
    }

    public final ArrayList<FeatureToggleDto> getFeaturesToggle() {
        return this.featuresToggle;
    }

    public final ImagesDto getImages() {
        return this.images;
    }

    public final LocalizationDto getLocalization() {
        return this.localization;
    }

    public final ArrayList<SchemaDto> getSchemas() {
        return this.schemas;
    }

    public final ArrayList<String> getSslPins() {
        return this.sslPins;
    }

    public final String getVersion() {
        return this.version;
    }

    public final VersionInfoDto getVersionInfoDto() {
        return this.versionInfoDto;
    }

    public int hashCode() {
        String str = this.version;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        LocalizationDto localizationDto = this.localization;
        int iHashCode2 = (iHashCode + (localizationDto == null ? 0 : localizationDto.hashCode())) * 31;
        ArrayList<SchemaDto> arrayList = this.schemas;
        int iHashCode3 = (iHashCode2 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<FeatureToggleDto> arrayList2 = this.featuresToggle;
        int iHashCode4 = (iHashCode3 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        ImagesDto imagesDto = this.images;
        int iHashCode5 = (iHashCode4 + (imagesDto == null ? 0 : imagesDto.hashCode())) * 31;
        VersionInfoDto versionInfoDto = this.versionInfoDto;
        int iHashCode6 = (iHashCode5 + (versionInfoDto == null ? 0 : versionInfoDto.hashCode())) * 31;
        ArrayList<String> arrayList3 = this.sslPins;
        return iHashCode6 + (arrayList3 != null ? arrayList3.hashCode() : 0);
    }

    public String toString() {
        return "SPaySdkConfigDto(version=" + this.version + ", localization=" + this.localization + ", schemas=" + this.schemas + ", featuresToggle=" + this.featuresToggle + ", images=" + this.images + ", versionInfoDto=" + this.versionInfoDto + ", sslPins=" + this.sslPins + ')';
    }

    @Override // spay.sdk.data.dto.response.DataDtoInterface
    public SPaySdkConfig toModel() {
        SPaySdkConfig.Localization model;
        ArrayList<SPaySdkConfig.Schema> modelArray;
        ArrayList<SPaySdkConfig.FeatureToggle> modelArray2;
        SPaySdkConfig.Images model2;
        String str = this.version;
        if (str == null) {
            throw new Kg("version");
        }
        LocalizationDto localizationDto = this.localization;
        if (localizationDto == null || (model = localizationDto.toModel()) == null) {
            throw new Kg("localization");
        }
        ArrayList<SchemaDto> arrayList = this.schemas;
        if (arrayList == null || (modelArray = SchemaDto.INSTANCE.toModelArray(arrayList)) == null) {
            throw new Kg("schemas");
        }
        ArrayList<FeatureToggleDto> arrayList2 = this.featuresToggle;
        if (arrayList2 == null || (modelArray2 = FeatureToggleDto.INSTANCE.toModelArray(arrayList2)) == null) {
            throw new Kg("featuresToggle");
        }
        ImagesDto imagesDto = this.images;
        if (imagesDto == null || (model2 = imagesDto.toModel()) == null) {
            throw new Kg("images");
        }
        VersionInfoDto versionInfoDto = this.versionInfoDto;
        return new SPaySdkConfig(str, model, modelArray, modelArray2, versionInfoDto != null ? versionInfoDto.toModel() : null, model2, this.sslPins);
    }
}
