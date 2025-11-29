package sberid.sdk.auth.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfigModel.kt */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lsberid/sdk/auth/model/response/AndroidVersionSdkData;", "", "currentVersion", "", "warningVersion", "errorSet", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "getCurrentVersion", "()Ljava/lang/String;", "getErrorSet", "()Ljava/util/Set;", "getWarningVersion", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "SberIdSDK_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final /* data */ class AndroidVersionSdkData {
    private final String currentVersion;
    private final Set<String> errorSet;
    private final String warningVersion;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AndroidVersionSdkData copy$default(AndroidVersionSdkData androidVersionSdkData, String str, String str2, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            str = androidVersionSdkData.currentVersion;
        }
        if ((i & 2) != 0) {
            str2 = androidVersionSdkData.warningVersion;
        }
        if ((i & 4) != 0) {
            set = androidVersionSdkData.errorSet;
        }
        return androidVersionSdkData.copy(str, str2, set);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCurrentVersion() {
        return this.currentVersion;
    }

    /* renamed from: component2, reason: from getter */
    public final String getWarningVersion() {
        return this.warningVersion;
    }

    public final Set<String> component3() {
        return this.errorSet;
    }

    public final AndroidVersionSdkData copy(@JsonProperty("current") String currentVersion, @JsonProperty("warning") String warningVersion, @JsonProperty("error") Set<String> errorSet) {
        Intrinsics.checkNotNullParameter(currentVersion, "currentVersion");
        Intrinsics.checkNotNullParameter(warningVersion, "warningVersion");
        Intrinsics.checkNotNullParameter(errorSet, "errorSet");
        return new AndroidVersionSdkData(currentVersion, warningVersion, errorSet);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AndroidVersionSdkData)) {
            return false;
        }
        AndroidVersionSdkData androidVersionSdkData = (AndroidVersionSdkData) other;
        return Intrinsics.areEqual(this.currentVersion, androidVersionSdkData.currentVersion) && Intrinsics.areEqual(this.warningVersion, androidVersionSdkData.warningVersion) && Intrinsics.areEqual(this.errorSet, androidVersionSdkData.errorSet);
    }

    public int hashCode() {
        String str = this.currentVersion;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.warningVersion;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Set<String> set = this.errorSet;
        return iHashCode2 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "AndroidVersionSdkData(currentVersion=" + this.currentVersion + ", warningVersion=" + this.warningVersion + ", errorSet=" + this.errorSet + ")";
    }

    public AndroidVersionSdkData(@JsonProperty("current") String currentVersion, @JsonProperty("warning") String warningVersion, @JsonProperty("error") Set<String> errorSet) {
        Intrinsics.checkNotNullParameter(currentVersion, "currentVersion");
        Intrinsics.checkNotNullParameter(warningVersion, "warningVersion");
        Intrinsics.checkNotNullParameter(errorSet, "errorSet");
        this.currentVersion = currentVersion;
        this.warningVersion = warningVersion;
        this.errorSet = errorSet;
    }

    public final String getCurrentVersion() {
        return this.currentVersion;
    }

    public final String getWarningVersion() {
        return this.warningVersion;
    }

    public final Set<String> getErrorSet() {
        return this.errorSet;
    }
}
