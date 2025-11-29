package spay.sdk.domain.model;

import com.huawei.hms.adapter.internal.CommonCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Q1;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lspay/sdk/domain/model/FraudMonInfo;", "", CommonCode.MapKey.HAS_RESOLUTION, "", "(Ljava/lang/String;)V", "getResolution", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FraudMonInfo {
    public static final String CONFIRMED_FRAUD = "CONFIRMED_FRAUD";
    public static final String CONFIRMED_GENUINE = "CONFIRMED_GENUINE";
    public static final String UNKNOWN = "UNKNOWN";
    private final String resolution;

    public FraudMonInfo(String resolution) {
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        this.resolution = resolution;
    }

    public static /* synthetic */ FraudMonInfo copy$default(FraudMonInfo fraudMonInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fraudMonInfo.resolution;
        }
        return fraudMonInfo.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getResolution() {
        return this.resolution;
    }

    public final FraudMonInfo copy(String resolution) {
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        return new FraudMonInfo(resolution);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FraudMonInfo) && Intrinsics.areEqual(this.resolution, ((FraudMonInfo) other).resolution);
    }

    public final String getResolution() {
        return this.resolution;
    }

    public int hashCode() {
        return this.resolution.hashCode();
    }

    public String toString() {
        return Q1.a(new StringBuilder("FraudMonInfo(resolution="), this.resolution, ')');
    }
}
