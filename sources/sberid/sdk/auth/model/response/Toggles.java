package sberid.sdk.auth.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;

/* compiled from: ConfigModel.kt */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lsberid/sdk/auth/model/response/Toggles;", "", "sberIDWebViewEnabled", "", "sberIDOIDC2AppEnabled", "(ZZ)V", "getSberIDOIDC2AppEnabled", "()Z", "getSberIDWebViewEnabled", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "SberIdSDK_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final /* data */ class Toggles {
    private final boolean sberIDOIDC2AppEnabled;
    private final boolean sberIDWebViewEnabled;

    public static /* synthetic */ Toggles copy$default(Toggles toggles, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = toggles.sberIDWebViewEnabled;
        }
        if ((i & 2) != 0) {
            z2 = toggles.sberIDOIDC2AppEnabled;
        }
        return toggles.copy(z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSberIDWebViewEnabled() {
        return this.sberIDWebViewEnabled;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSberIDOIDC2AppEnabled() {
        return this.sberIDOIDC2AppEnabled;
    }

    public final Toggles copy(@JsonProperty("sberIDWebViewEnabled") boolean sberIDWebViewEnabled, @JsonProperty("sberIDOIDC2AppEnabled") boolean sberIDOIDC2AppEnabled) {
        return new Toggles(sberIDWebViewEnabled, sberIDOIDC2AppEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Toggles)) {
            return false;
        }
        Toggles toggles = (Toggles) other;
        return this.sberIDWebViewEnabled == toggles.sberIDWebViewEnabled && this.sberIDOIDC2AppEnabled == toggles.sberIDOIDC2AppEnabled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.sberIDWebViewEnabled;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.sberIDOIDC2AppEnabled;
        return i + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "Toggles(sberIDWebViewEnabled=" + this.sberIDWebViewEnabled + ", sberIDOIDC2AppEnabled=" + this.sberIDOIDC2AppEnabled + ")";
    }

    public Toggles(@JsonProperty("sberIDWebViewEnabled") boolean z, @JsonProperty("sberIDOIDC2AppEnabled") boolean z2) {
        this.sberIDWebViewEnabled = z;
        this.sberIDOIDC2AppEnabled = z2;
    }

    public final boolean getSberIDWebViewEnabled() {
        return this.sberIDWebViewEnabled;
    }

    public final boolean getSberIDOIDC2AppEnabled() {
        return this.sberIDOIDC2AppEnabled;
    }
}
