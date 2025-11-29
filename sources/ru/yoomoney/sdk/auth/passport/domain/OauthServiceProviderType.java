package ru.yoomoney.sdk.auth.passport.domain;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/passport/domain/OauthServiceProviderType;", "", "(Ljava/lang/String;I)V", "SBER", "VK", "ESIA", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OauthServiceProviderType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ OauthServiceProviderType[] $VALUES;
    public static final OauthServiceProviderType SBER = new OauthServiceProviderType("SBER", 0);
    public static final OauthServiceProviderType VK = new OauthServiceProviderType("VK", 1);
    public static final OauthServiceProviderType ESIA = new OauthServiceProviderType("ESIA", 2);

    private static final /* synthetic */ OauthServiceProviderType[] $values() {
        return new OauthServiceProviderType[]{SBER, VK, ESIA};
    }

    static {
        OauthServiceProviderType[] oauthServiceProviderTypeArr$values = $values();
        $VALUES = oauthServiceProviderTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(oauthServiceProviderTypeArr$values);
    }

    private OauthServiceProviderType(String str, int i) {
    }

    public static EnumEntries<OauthServiceProviderType> getEntries() {
        return $ENTRIES;
    }

    public static OauthServiceProviderType valueOf(String str) {
        return (OauthServiceProviderType) Enum.valueOf(OauthServiceProviderType.class, str);
    }

    public static OauthServiceProviderType[] values() {
        return (OauthServiceProviderType[]) $VALUES.clone();
    }
}
