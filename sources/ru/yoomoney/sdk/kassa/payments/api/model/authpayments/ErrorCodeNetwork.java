package ru.yoomoney.sdk.kassa.payments.api.model.authpayments;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/authpayments/ErrorCodeNetwork;", "", "(Ljava/lang/String;I)V", "INVALID_CONTEXT", "UNSUPPORTED_AUTH_TYPE", "VERIFY_ATTEMPTS_EXCEEDED", "INVALID_ANSWER", "SESSION_DOES_NOT_EXIST", "SESSION_EXPIRED", "UNKNOWN", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ErrorCodeNetwork {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ErrorCodeNetwork[] $VALUES;

    @JsonProperty("InvalidContext")
    public static final ErrorCodeNetwork INVALID_CONTEXT = new ErrorCodeNetwork("INVALID_CONTEXT", 0);

    @JsonProperty("UnsupportedAuthType")
    public static final ErrorCodeNetwork UNSUPPORTED_AUTH_TYPE = new ErrorCodeNetwork("UNSUPPORTED_AUTH_TYPE", 1);

    @JsonProperty("VerifyAttemptsExceeded")
    public static final ErrorCodeNetwork VERIFY_ATTEMPTS_EXCEEDED = new ErrorCodeNetwork("VERIFY_ATTEMPTS_EXCEEDED", 2);

    @JsonProperty("InvalidAnswer")
    public static final ErrorCodeNetwork INVALID_ANSWER = new ErrorCodeNetwork("INVALID_ANSWER", 3);

    @JsonProperty("SessionDoesNotExist")
    public static final ErrorCodeNetwork SESSION_DOES_NOT_EXIST = new ErrorCodeNetwork("SESSION_DOES_NOT_EXIST", 4);

    @JsonProperty("SessionExpired")
    public static final ErrorCodeNetwork SESSION_EXPIRED = new ErrorCodeNetwork("SESSION_EXPIRED", 5);

    @JsonEnumDefaultValue
    public static final ErrorCodeNetwork UNKNOWN = new ErrorCodeNetwork("UNKNOWN", 6);

    private static final /* synthetic */ ErrorCodeNetwork[] $values() {
        return new ErrorCodeNetwork[]{INVALID_CONTEXT, UNSUPPORTED_AUTH_TYPE, VERIFY_ATTEMPTS_EXCEEDED, INVALID_ANSWER, SESSION_DOES_NOT_EXIST, SESSION_EXPIRED, UNKNOWN};
    }

    static {
        ErrorCodeNetwork[] errorCodeNetworkArr$values = $values();
        $VALUES = errorCodeNetworkArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(errorCodeNetworkArr$values);
    }

    private ErrorCodeNetwork(String str, int i) {
    }

    public static EnumEntries<ErrorCodeNetwork> getEntries() {
        return $ENTRIES;
    }

    public static ErrorCodeNetwork valueOf(String str) {
        return (ErrorCodeNetwork) Enum.valueOf(ErrorCodeNetwork.class, str);
    }

    public static ErrorCodeNetwork[] values() {
        return (ErrorCodeNetwork[]) $VALUES.clone();
    }
}
