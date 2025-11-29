package ru.yoomoney.sdk.kassa.payments.api.model.paymentdetails;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/paymentdetails/PaymentStatusResponse;", "", "(Ljava/lang/String;I)V", "PENDING", "WAITING_FOR_CAPTURE", "SUCCEEDED", "CANCELED", "UNKNOWN", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PaymentStatusResponse {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PaymentStatusResponse[] $VALUES;

    @JsonProperty("pending")
    public static final PaymentStatusResponse PENDING = new PaymentStatusResponse("PENDING", 0);

    @JsonProperty("waiting_for_capture")
    public static final PaymentStatusResponse WAITING_FOR_CAPTURE = new PaymentStatusResponse("WAITING_FOR_CAPTURE", 1);

    @JsonProperty("succeeded")
    public static final PaymentStatusResponse SUCCEEDED = new PaymentStatusResponse("SUCCEEDED", 2);

    @JsonProperty("canceled")
    public static final PaymentStatusResponse CANCELED = new PaymentStatusResponse("CANCELED", 3);

    @JsonEnumDefaultValue
    public static final PaymentStatusResponse UNKNOWN = new PaymentStatusResponse("UNKNOWN", 4);

    private static final /* synthetic */ PaymentStatusResponse[] $values() {
        return new PaymentStatusResponse[]{PENDING, WAITING_FOR_CAPTURE, SUCCEEDED, CANCELED, UNKNOWN};
    }

    static {
        PaymentStatusResponse[] paymentStatusResponseArr$values = $values();
        $VALUES = paymentStatusResponseArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(paymentStatusResponseArr$values);
    }

    private PaymentStatusResponse(String str, int i) {
    }

    public static EnumEntries<PaymentStatusResponse> getEntries() {
        return $ENTRIES;
    }

    public static PaymentStatusResponse valueOf(String str) {
        return (PaymentStatusResponse) Enum.valueOf(PaymentStatusResponse.class, str);
    }

    public static PaymentStatusResponse[] values() {
        return (PaymentStatusResponse[]) $VALUES.clone();
    }
}
