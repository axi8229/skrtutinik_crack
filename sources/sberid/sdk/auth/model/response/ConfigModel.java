package sberid.sdk.auth.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfigModel.kt */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0003\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\rJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0017\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003Jc\u0010\u001f\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\b\u0003\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0003\u0010\n\u001a\u00020\u000b2\u000e\b\u0003\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lsberid/sdk/auth/model/response/ConfigModel;", "", "blackList", "", "", "sberIDOidcWebUrl", "oidcUrlMap", "", "toggles", "Lsberid/sdk/auth/model/response/Toggles;", "versionData", "Lsberid/sdk/auth/model/response/VersionSdkData;", "hostWhiteList", "(Ljava/util/Set;Ljava/lang/String;Ljava/util/Map;Lsberid/sdk/auth/model/response/Toggles;Lsberid/sdk/auth/model/response/VersionSdkData;Ljava/util/Set;)V", "getBlackList", "()Ljava/util/Set;", "getHostWhiteList", "getOidcUrlMap", "()Ljava/util/Map;", "getSberIDOidcWebUrl", "()Ljava/lang/String;", "getToggles", "()Lsberid/sdk/auth/model/response/Toggles;", "getVersionData", "()Lsberid/sdk/auth/model/response/VersionSdkData;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "SberIdSDK_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final /* data */ class ConfigModel {
    private final Set<String> blackList;
    private final Set<String> hostWhiteList;
    private final Map<String, String> oidcUrlMap;
    private final String sberIDOidcWebUrl;
    private final Toggles toggles;
    private final VersionSdkData versionData;

    public static /* synthetic */ ConfigModel copy$default(ConfigModel configModel, Set set, String str, Map map, Toggles toggles, VersionSdkData versionSdkData, Set set2, int i, Object obj) {
        if ((i & 1) != 0) {
            set = configModel.blackList;
        }
        if ((i & 2) != 0) {
            str = configModel.sberIDOidcWebUrl;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            map = configModel.oidcUrlMap;
        }
        Map map2 = map;
        if ((i & 8) != 0) {
            toggles = configModel.toggles;
        }
        Toggles toggles2 = toggles;
        if ((i & 16) != 0) {
            versionSdkData = configModel.versionData;
        }
        VersionSdkData versionSdkData2 = versionSdkData;
        if ((i & 32) != 0) {
            set2 = configModel.hostWhiteList;
        }
        return configModel.copy(set, str2, map2, toggles2, versionSdkData2, set2);
    }

    public final Set<String> component1() {
        return this.blackList;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSberIDOidcWebUrl() {
        return this.sberIDOidcWebUrl;
    }

    public final Map<String, String> component3() {
        return this.oidcUrlMap;
    }

    /* renamed from: component4, reason: from getter */
    public final Toggles getToggles() {
        return this.toggles;
    }

    /* renamed from: component5, reason: from getter */
    public final VersionSdkData getVersionData() {
        return this.versionData;
    }

    public final Set<String> component6() {
        return this.hostWhiteList;
    }

    public final ConfigModel copy(@JsonProperty("blackList") Set<String> blackList, @JsonProperty("sberIDOidcWebUrl") String sberIDOidcWebUrl, @JsonProperty("oidcUrlMap") Map<String, String> oidcUrlMap, @JsonProperty("toggles") Toggles toggles, @JsonProperty("versions") VersionSdkData versionData, @JsonProperty("hostWhiteList") Set<String> hostWhiteList) {
        Intrinsics.checkNotNullParameter(blackList, "blackList");
        Intrinsics.checkNotNullParameter(versionData, "versionData");
        Intrinsics.checkNotNullParameter(hostWhiteList, "hostWhiteList");
        return new ConfigModel(blackList, sberIDOidcWebUrl, oidcUrlMap, toggles, versionData, hostWhiteList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigModel)) {
            return false;
        }
        ConfigModel configModel = (ConfigModel) other;
        return Intrinsics.areEqual(this.blackList, configModel.blackList) && Intrinsics.areEqual(this.sberIDOidcWebUrl, configModel.sberIDOidcWebUrl) && Intrinsics.areEqual(this.oidcUrlMap, configModel.oidcUrlMap) && Intrinsics.areEqual(this.toggles, configModel.toggles) && Intrinsics.areEqual(this.versionData, configModel.versionData) && Intrinsics.areEqual(this.hostWhiteList, configModel.hostWhiteList);
    }

    public int hashCode() {
        Set<String> set = this.blackList;
        int iHashCode = (set != null ? set.hashCode() : 0) * 31;
        String str = this.sberIDOidcWebUrl;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        Map<String, String> map = this.oidcUrlMap;
        int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        Toggles toggles = this.toggles;
        int iHashCode4 = (iHashCode3 + (toggles != null ? toggles.hashCode() : 0)) * 31;
        VersionSdkData versionSdkData = this.versionData;
        int iHashCode5 = (iHashCode4 + (versionSdkData != null ? versionSdkData.hashCode() : 0)) * 31;
        Set<String> set2 = this.hostWhiteList;
        return iHashCode5 + (set2 != null ? set2.hashCode() : 0);
    }

    public String toString() {
        return "ConfigModel(blackList=" + this.blackList + ", sberIDOidcWebUrl=" + this.sberIDOidcWebUrl + ", oidcUrlMap=" + this.oidcUrlMap + ", toggles=" + this.toggles + ", versionData=" + this.versionData + ", hostWhiteList=" + this.hostWhiteList + ")";
    }

    public ConfigModel(@JsonProperty("blackList") Set<String> blackList, @JsonProperty("sberIDOidcWebUrl") String str, @JsonProperty("oidcUrlMap") Map<String, String> map, @JsonProperty("toggles") Toggles toggles, @JsonProperty("versions") VersionSdkData versionData, @JsonProperty("hostWhiteList") Set<String> hostWhiteList) {
        Intrinsics.checkNotNullParameter(blackList, "blackList");
        Intrinsics.checkNotNullParameter(versionData, "versionData");
        Intrinsics.checkNotNullParameter(hostWhiteList, "hostWhiteList");
        this.blackList = blackList;
        this.sberIDOidcWebUrl = str;
        this.oidcUrlMap = map;
        this.toggles = toggles;
        this.versionData = versionData;
        this.hostWhiteList = hostWhiteList;
    }

    public final Set<String> getBlackList() {
        return this.blackList;
    }

    public final String getSberIDOidcWebUrl() {
        return this.sberIDOidcWebUrl;
    }

    public final Map<String, String> getOidcUrlMap() {
        return this.oidcUrlMap;
    }

    public /* synthetic */ ConfigModel(Set set, String str, Map map, Toggles toggles, VersionSdkData versionSdkData, Set set2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : toggles, versionSdkData, set2);
    }

    public final Toggles getToggles() {
        return this.toggles;
    }

    public final VersionSdkData getVersionData() {
        return this.versionData;
    }

    public final Set<String> getHostWhiteList() {
        return this.hostWhiteList;
    }
}
