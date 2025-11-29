package ru.yoomoney.sdk.auth.api.registrationV2.api.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/model/ApiOrigin;", "", "(Ljava/lang/String;I)V", "WALLET", "CHECKOUT", "CORPORATE_BANKING", "UNKNOWN_ENUM", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApiOrigin {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ApiOrigin[] $VALUES;

    @JsonProperty("Wallet")
    public static final ApiOrigin WALLET = new ApiOrigin("WALLET", 0);

    @JsonProperty("Checkout")
    public static final ApiOrigin CHECKOUT = new ApiOrigin("CHECKOUT", 1);

    @JsonProperty("CorporateBanking")
    public static final ApiOrigin CORPORATE_BANKING = new ApiOrigin("CORPORATE_BANKING", 2);

    @JsonEnumDefaultValue
    public static final ApiOrigin UNKNOWN_ENUM = new ApiOrigin("UNKNOWN_ENUM", 3);

    private static final /* synthetic */ ApiOrigin[] $values() {
        return new ApiOrigin[]{WALLET, CHECKOUT, CORPORATE_BANKING, UNKNOWN_ENUM};
    }

    static {
        ApiOrigin[] apiOriginArr$values = $values();
        $VALUES = apiOriginArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(apiOriginArr$values);
    }

    private ApiOrigin(String str, int i) {
    }

    public static EnumEntries<ApiOrigin> getEntries() {
        return $ENTRIES;
    }

    public static ApiOrigin valueOf(String str) {
        return (ApiOrigin) Enum.valueOf(ApiOrigin.class, str);
    }

    public static ApiOrigin[] values() {
        return (ApiOrigin[]) $VALUES.clone();
    }
}
