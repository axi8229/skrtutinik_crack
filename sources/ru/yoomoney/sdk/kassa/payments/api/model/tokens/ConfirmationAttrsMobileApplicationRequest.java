package ru.yoomoney.sdk.kassa.payments.api.model.tokens;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.ConfirmationType;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/tokens/ConfirmationAttrsMobileApplicationRequest;", "Lru/yoomoney/sdk/kassa/payments/api/model/tokens/ConfirmationRequest;", "type", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/ConfirmationType;", "returnUrl", "", "(Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/ConfirmationType;Ljava/lang/String;)V", "getReturnUrl", "()Ljava/lang/String;", "getType", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/ConfirmationType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConfirmationAttrsMobileApplicationRequest extends ConfirmationRequest {
    public static final int $stable = 0;
    private final String returnUrl;
    private final ConfirmationType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmationAttrsMobileApplicationRequest(@JsonProperty("type") ConfirmationType type, @JsonProperty("return_url") String returnUrl) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(returnUrl, "returnUrl");
        this.type = type;
        this.returnUrl = returnUrl;
    }

    public static /* synthetic */ ConfirmationAttrsMobileApplicationRequest copy$default(ConfirmationAttrsMobileApplicationRequest confirmationAttrsMobileApplicationRequest, ConfirmationType confirmationType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            confirmationType = confirmationAttrsMobileApplicationRequest.type;
        }
        if ((i & 2) != 0) {
            str = confirmationAttrsMobileApplicationRequest.returnUrl;
        }
        return confirmationAttrsMobileApplicationRequest.copy(confirmationType, str);
    }

    /* renamed from: component1, reason: from getter */
    public final ConfirmationType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getReturnUrl() {
        return this.returnUrl;
    }

    public final ConfirmationAttrsMobileApplicationRequest copy(@JsonProperty("type") ConfirmationType type, @JsonProperty("return_url") String returnUrl) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(returnUrl, "returnUrl");
        return new ConfirmationAttrsMobileApplicationRequest(type, returnUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfirmationAttrsMobileApplicationRequest)) {
            return false;
        }
        ConfirmationAttrsMobileApplicationRequest confirmationAttrsMobileApplicationRequest = (ConfirmationAttrsMobileApplicationRequest) other;
        return this.type == confirmationAttrsMobileApplicationRequest.type && Intrinsics.areEqual(this.returnUrl, confirmationAttrsMobileApplicationRequest.returnUrl);
    }

    @JsonProperty("return_url")
    public final String getReturnUrl() {
        return this.returnUrl;
    }

    public final ConfirmationType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.returnUrl.hashCode() + (this.type.hashCode() * 31);
    }

    public String toString() {
        return "ConfirmationAttrsMobileApplicationRequest(type=" + this.type + ", returnUrl=" + this.returnUrl + ")";
    }
}
