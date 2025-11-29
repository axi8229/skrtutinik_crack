package ru.yoomoney.sdk.two_fa.api.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ApiAuthStatus.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/model/ApiAuthStatus;", "", "(Ljava/lang/String;I)V", "PENDING", "AUTHORIZED", "DENIED", "UNKNOWN_ENUM", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ApiAuthStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ApiAuthStatus[] $VALUES;

    @JsonProperty("Pending")
    public static final ApiAuthStatus PENDING = new ApiAuthStatus("PENDING", 0);

    @JsonProperty("Authorized")
    public static final ApiAuthStatus AUTHORIZED = new ApiAuthStatus("AUTHORIZED", 1);

    @JsonProperty("Denied")
    public static final ApiAuthStatus DENIED = new ApiAuthStatus("DENIED", 2);

    @JsonEnumDefaultValue
    public static final ApiAuthStatus UNKNOWN_ENUM = new ApiAuthStatus("UNKNOWN_ENUM", 3);

    private static final /* synthetic */ ApiAuthStatus[] $values() {
        return new ApiAuthStatus[]{PENDING, AUTHORIZED, DENIED, UNKNOWN_ENUM};
    }

    public static EnumEntries<ApiAuthStatus> getEntries() {
        return $ENTRIES;
    }

    public static ApiAuthStatus valueOf(String str) {
        return (ApiAuthStatus) Enum.valueOf(ApiAuthStatus.class, str);
    }

    public static ApiAuthStatus[] values() {
        return (ApiAuthStatus[]) $VALUES.clone();
    }

    private ApiAuthStatus(String str, int i) {
    }

    static {
        ApiAuthStatus[] apiAuthStatusArr$values = $values();
        $VALUES = apiAuthStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(apiAuthStatusArr$values);
    }
}
