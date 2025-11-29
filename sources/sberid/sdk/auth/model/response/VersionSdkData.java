package sberid.sdk.auth.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfigModel.kt */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lsberid/sdk/auth/model/response/VersionSdkData;", "", "androidCheck", "Lsberid/sdk/auth/model/response/AndroidVersionSdkData;", "(Lsberid/sdk/auth/model/response/AndroidVersionSdkData;)V", "getAndroidCheck", "()Lsberid/sdk/auth/model/response/AndroidVersionSdkData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "SberIdSDK_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final /* data */ class VersionSdkData {
    private final AndroidVersionSdkData androidCheck;

    public static /* synthetic */ VersionSdkData copy$default(VersionSdkData versionSdkData, AndroidVersionSdkData androidVersionSdkData, int i, Object obj) {
        if ((i & 1) != 0) {
            androidVersionSdkData = versionSdkData.androidCheck;
        }
        return versionSdkData.copy(androidVersionSdkData);
    }

    /* renamed from: component1, reason: from getter */
    public final AndroidVersionSdkData getAndroidCheck() {
        return this.androidCheck;
    }

    public final VersionSdkData copy(@JsonProperty("sdk_android_check") AndroidVersionSdkData androidCheck) {
        Intrinsics.checkNotNullParameter(androidCheck, "androidCheck");
        return new VersionSdkData(androidCheck);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof VersionSdkData) && Intrinsics.areEqual(this.androidCheck, ((VersionSdkData) other).androidCheck);
        }
        return true;
    }

    public int hashCode() {
        AndroidVersionSdkData androidVersionSdkData = this.androidCheck;
        if (androidVersionSdkData != null) {
            return androidVersionSdkData.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "VersionSdkData(androidCheck=" + this.androidCheck + ")";
    }

    public VersionSdkData(@JsonProperty("sdk_android_check") AndroidVersionSdkData androidCheck) {
        Intrinsics.checkNotNullParameter(androidCheck, "androidCheck");
        this.androidCheck = androidCheck;
    }

    public final AndroidVersionSdkData getAndroidCheck() {
        return this.androidCheck;
    }
}
