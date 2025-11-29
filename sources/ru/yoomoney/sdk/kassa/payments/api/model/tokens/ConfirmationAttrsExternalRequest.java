package ru.yoomoney.sdk.kassa.payments.api.model.tokens;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.ConfirmationType;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/tokens/ConfirmationAttrsExternalRequest;", "Lru/yoomoney/sdk/kassa/payments/api/model/tokens/ConfirmationRequest;", "type", "Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/ConfirmationType;", "(Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/ConfirmationType;)V", "getType", "()Lru/yoomoney/sdk/kassa/payments/api/model/packageoptions/ConfirmationType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConfirmationAttrsExternalRequest extends ConfirmationRequest {
    public static final int $stable = 0;
    private final ConfirmationType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmationAttrsExternalRequest(@JsonProperty("type") ConfirmationType type) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
    }

    public static /* synthetic */ ConfirmationAttrsExternalRequest copy$default(ConfirmationAttrsExternalRequest confirmationAttrsExternalRequest, ConfirmationType confirmationType, int i, Object obj) {
        if ((i & 1) != 0) {
            confirmationType = confirmationAttrsExternalRequest.type;
        }
        return confirmationAttrsExternalRequest.copy(confirmationType);
    }

    /* renamed from: component1, reason: from getter */
    public final ConfirmationType getType() {
        return this.type;
    }

    public final ConfirmationAttrsExternalRequest copy(@JsonProperty("type") ConfirmationType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new ConfirmationAttrsExternalRequest(type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ConfirmationAttrsExternalRequest) && this.type == ((ConfirmationAttrsExternalRequest) other).type;
    }

    public final ConfirmationType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public String toString() {
        return "ConfirmationAttrsExternalRequest(type=" + this.type + ")";
    }
}
