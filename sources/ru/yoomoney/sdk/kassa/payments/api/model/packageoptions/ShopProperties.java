package ru.yoomoney.sdk.kassa.payments.api.model.packageoptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/ShopProperties;", "", "isSafeDeal", "", "isMarketplace", "agentSchemeData", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/AgentSchemeData;", "(ZZLru/yoomoney/sdk/kassa/payments/api/model/packageoptions/AgentSchemeData;)V", "getAgentSchemeData", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/AgentSchemeData;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ShopProperties {
    public static final int $stable = 0;
    private final AgentSchemeData agentSchemeData;
    private final boolean isMarketplace;
    private final boolean isSafeDeal;

    public ShopProperties(@JsonProperty("is_safe_deal") boolean z, @JsonProperty("is_marketplace") boolean z2, @JsonProperty("agent_scheme_data") AgentSchemeData agentSchemeData) {
        this.isSafeDeal = z;
        this.isMarketplace = z2;
        this.agentSchemeData = agentSchemeData;
    }

    public static /* synthetic */ ShopProperties copy$default(ShopProperties shopProperties, boolean z, boolean z2, AgentSchemeData agentSchemeData, int i, Object obj) {
        if ((i & 1) != 0) {
            z = shopProperties.isSafeDeal;
        }
        if ((i & 2) != 0) {
            z2 = shopProperties.isMarketplace;
        }
        if ((i & 4) != 0) {
            agentSchemeData = shopProperties.agentSchemeData;
        }
        return shopProperties.copy(z, z2, agentSchemeData);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsSafeDeal() {
        return this.isSafeDeal;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsMarketplace() {
        return this.isMarketplace;
    }

    /* renamed from: component3, reason: from getter */
    public final AgentSchemeData getAgentSchemeData() {
        return this.agentSchemeData;
    }

    public final ShopProperties copy(@JsonProperty("is_safe_deal") boolean isSafeDeal, @JsonProperty("is_marketplace") boolean isMarketplace, @JsonProperty("agent_scheme_data") AgentSchemeData agentSchemeData) {
        return new ShopProperties(isSafeDeal, isMarketplace, agentSchemeData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShopProperties)) {
            return false;
        }
        ShopProperties shopProperties = (ShopProperties) other;
        return this.isSafeDeal == shopProperties.isSafeDeal && this.isMarketplace == shopProperties.isMarketplace && Intrinsics.areEqual(this.agentSchemeData, shopProperties.agentSchemeData);
    }

    @JsonProperty("agent_scheme_data")
    public final AgentSchemeData getAgentSchemeData() {
        return this.agentSchemeData;
    }

    public int hashCode() {
        int iA = a.a(this.isMarketplace, Boolean.hashCode(this.isSafeDeal) * 31, 31);
        AgentSchemeData agentSchemeData = this.agentSchemeData;
        return iA + (agentSchemeData == null ? 0 : agentSchemeData.hashCode());
    }

    @JsonProperty("is_marketplace")
    public final boolean isMarketplace() {
        return this.isMarketplace;
    }

    @JsonProperty("is_safe_deal")
    public final boolean isSafeDeal() {
        return this.isSafeDeal;
    }

    public String toString() {
        return "ShopProperties(isSafeDeal=" + this.isSafeDeal + ", isMarketplace=" + this.isMarketplace + ", agentSchemeData=" + this.agentSchemeData + ")";
    }
}
