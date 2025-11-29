package spay.sdk.api;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.U0;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\n¨\u0006\u0014"}, d2 = {"Lspay/sdk/api/SPayHelperConfig;", "", "isHelperEnabled", "", "disabledHelpers", "", "Lspay/sdk/api/SPayHelpers;", "(ZLjava/util/List;)V", "getDisabledHelpers", "()Ljava/util/List;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SPayHelperConfig {
    private final List<SPayHelpers> disabledHelpers;
    private final boolean isHelperEnabled;

    /* JADX WARN: Multi-variable type inference failed */
    public SPayHelperConfig(boolean z, List<? extends SPayHelpers> disabledHelpers) {
        Intrinsics.checkNotNullParameter(disabledHelpers, "disabledHelpers");
        this.isHelperEnabled = z;
        this.disabledHelpers = disabledHelpers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SPayHelperConfig copy$default(SPayHelperConfig sPayHelperConfig, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = sPayHelperConfig.isHelperEnabled;
        }
        if ((i & 2) != 0) {
            list = sPayHelperConfig.disabledHelpers;
        }
        return sPayHelperConfig.copy(z, list);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsHelperEnabled() {
        return this.isHelperEnabled;
    }

    public final List<SPayHelpers> component2() {
        return this.disabledHelpers;
    }

    public final SPayHelperConfig copy(boolean isHelperEnabled, List<? extends SPayHelpers> disabledHelpers) {
        Intrinsics.checkNotNullParameter(disabledHelpers, "disabledHelpers");
        return new SPayHelperConfig(isHelperEnabled, disabledHelpers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SPayHelperConfig)) {
            return false;
        }
        SPayHelperConfig sPayHelperConfig = (SPayHelperConfig) other;
        return this.isHelperEnabled == sPayHelperConfig.isHelperEnabled && Intrinsics.areEqual(this.disabledHelpers, sPayHelperConfig.disabledHelpers);
    }

    public final List<SPayHelpers> getDisabledHelpers() {
        return this.disabledHelpers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    public int hashCode() {
        boolean z = this.isHelperEnabled;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return this.disabledHelpers.hashCode() + (r0 * 31);
    }

    public final boolean isHelperEnabled() {
        return this.isHelperEnabled;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SPayHelperConfig(isHelperEnabled=");
        sb.append(this.isHelperEnabled);
        sb.append(", disabledHelpers=");
        return U0.a(sb, this.disabledHelpers, ')');
    }

    public /* synthetic */ SPayHelperConfig(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, list);
    }
}
