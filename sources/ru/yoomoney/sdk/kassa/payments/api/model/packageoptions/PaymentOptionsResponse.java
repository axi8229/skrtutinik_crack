package ru.yoomoney.sdk.kassa.payments.api.model.packageoptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentOptionsResponse;", "", "items", "", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/PaymentOptionResponse;", "shopProperties", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/ShopProperties;", "(Ljava/util/List;Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/ShopProperties;)V", "getItems", "()Ljava/util/List;", "getShopProperties", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/ShopProperties;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentOptionsResponse {
    public static final int $stable = 8;
    private final List<PaymentOptionResponse> items;
    private final ShopProperties shopProperties;

    /* JADX WARN: Multi-variable type inference failed */
    public PaymentOptionsResponse(@JsonProperty("items") List<? extends PaymentOptionResponse> items, @JsonProperty("shop_properties") ShopProperties shopProperties) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(shopProperties, "shopProperties");
        this.items = items;
        this.shopProperties = shopProperties;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PaymentOptionsResponse copy$default(PaymentOptionsResponse paymentOptionsResponse, List list, ShopProperties shopProperties, int i, Object obj) {
        if ((i & 1) != 0) {
            list = paymentOptionsResponse.items;
        }
        if ((i & 2) != 0) {
            shopProperties = paymentOptionsResponse.shopProperties;
        }
        return paymentOptionsResponse.copy(list, shopProperties);
    }

    public final List<PaymentOptionResponse> component1() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final ShopProperties getShopProperties() {
        return this.shopProperties;
    }

    public final PaymentOptionsResponse copy(@JsonProperty("items") List<? extends PaymentOptionResponse> items, @JsonProperty("shop_properties") ShopProperties shopProperties) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(shopProperties, "shopProperties");
        return new PaymentOptionsResponse(items, shopProperties);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentOptionsResponse)) {
            return false;
        }
        PaymentOptionsResponse paymentOptionsResponse = (PaymentOptionsResponse) other;
        return Intrinsics.areEqual(this.items, paymentOptionsResponse.items) && Intrinsics.areEqual(this.shopProperties, paymentOptionsResponse.shopProperties);
    }

    public final List<PaymentOptionResponse> getItems() {
        return this.items;
    }

    @JsonProperty("shop_properties")
    public final ShopProperties getShopProperties() {
        return this.shopProperties;
    }

    public int hashCode() {
        return this.shopProperties.hashCode() + (this.items.hashCode() * 31);
    }

    public String toString() {
        return "PaymentOptionsResponse(items=" + this.items + ", shopProperties=" + this.shopProperties + ")";
    }
}
