package ru.yoomoney.sdk.kassa.payments.api.model.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/config/GetConfigResponse;", "", "config", "Lru/yoomoney/sdk/kassa/payments/api/model/config/MobileSdkConfig;", "(Lru/yoomoney/sdk/kassa/payments/api/model/config/MobileSdkConfig;)V", "getConfig", "()Lru/yoomoney/sdk/kassa/payments/api/model/config/MobileSdkConfig;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GetConfigResponse {
    public static final int $stable = 8;
    private final MobileSdkConfig config;

    public GetConfigResponse(@JsonProperty("config") MobileSdkConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    public static /* synthetic */ GetConfigResponse copy$default(GetConfigResponse getConfigResponse, MobileSdkConfig mobileSdkConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            mobileSdkConfig = getConfigResponse.config;
        }
        return getConfigResponse.copy(mobileSdkConfig);
    }

    /* renamed from: component1, reason: from getter */
    public final MobileSdkConfig getConfig() {
        return this.config;
    }

    public final GetConfigResponse copy(@JsonProperty("config") MobileSdkConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return new GetConfigResponse(config);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GetConfigResponse) && Intrinsics.areEqual(this.config, ((GetConfigResponse) other).config);
    }

    public final MobileSdkConfig getConfig() {
        return this.config;
    }

    public int hashCode() {
        return this.config.hashCode();
    }

    public String toString() {
        return "GetConfigResponse(config=" + this.config + ")";
    }
}
