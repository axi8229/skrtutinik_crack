package ru.yoomoney.sdk.two_fa.api.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ApiSessionType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/model/ApiSessionType;", "", "(Ljava/lang/String;I)V", "SMS", "EMAIL", "PUSH_APP", "PUSH_CODE", "PHONE_CALL", "UNKNOWN_ENUM", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ApiSessionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ApiSessionType[] $VALUES;

    @JsonProperty("Sms")
    public static final ApiSessionType SMS = new ApiSessionType("SMS", 0);

    @JsonProperty("Email")
    public static final ApiSessionType EMAIL = new ApiSessionType("EMAIL", 1);

    @JsonProperty("PushApp")
    public static final ApiSessionType PUSH_APP = new ApiSessionType("PUSH_APP", 2);

    @JsonProperty("PushCode")
    public static final ApiSessionType PUSH_CODE = new ApiSessionType("PUSH_CODE", 3);

    @JsonProperty("PhoneCall")
    public static final ApiSessionType PHONE_CALL = new ApiSessionType("PHONE_CALL", 4);

    @JsonEnumDefaultValue
    public static final ApiSessionType UNKNOWN_ENUM = new ApiSessionType("UNKNOWN_ENUM", 5);

    private static final /* synthetic */ ApiSessionType[] $values() {
        return new ApiSessionType[]{SMS, EMAIL, PUSH_APP, PUSH_CODE, PHONE_CALL, UNKNOWN_ENUM};
    }

    public static EnumEntries<ApiSessionType> getEntries() {
        return $ENTRIES;
    }

    public static ApiSessionType valueOf(String str) {
        return (ApiSessionType) Enum.valueOf(ApiSessionType.class, str);
    }

    public static ApiSessionType[] values() {
        return (ApiSessionType[]) $VALUES.clone();
    }

    private ApiSessionType(String str, int i) {
    }

    static {
        ApiSessionType[] apiSessionTypeArr$values = $values();
        $VALUES = apiSessionTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(apiSessionTypeArr$values);
    }
}
