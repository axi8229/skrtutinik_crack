package ru.yoomoney.sdk.auth.api.account.socialAccount.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import ru.yoomoney.sdk.auth.socialAccounts.esia.impl.EsiaViewModelFactoryImpl;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "", "(Ljava/lang/String;I)V", "APPLE", "SBER", "VK", "ESIA", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OauthServiceProvider {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ OauthServiceProvider[] $VALUES;

    @SerializedName("Apple")
    public static final OauthServiceProvider APPLE = new OauthServiceProvider("APPLE", 0);

    @SerializedName("Sber")
    public static final OauthServiceProvider SBER = new OauthServiceProvider("SBER", 1);

    @SerializedName("Vk")
    public static final OauthServiceProvider VK = new OauthServiceProvider("VK", 2);

    @SerializedName(EsiaViewModelFactoryImpl.FEATURE)
    public static final OauthServiceProvider ESIA = new OauthServiceProvider("ESIA", 3);

    private static final /* synthetic */ OauthServiceProvider[] $values() {
        return new OauthServiceProvider[]{APPLE, SBER, VK, ESIA};
    }

    static {
        OauthServiceProvider[] oauthServiceProviderArr$values = $values();
        $VALUES = oauthServiceProviderArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(oauthServiceProviderArr$values);
    }

    private OauthServiceProvider(String str, int i) {
    }

    public static EnumEntries<OauthServiceProvider> getEntries() {
        return $ENTRIES;
    }

    public static OauthServiceProvider valueOf(String str) {
        return (OauthServiceProvider) Enum.valueOf(OauthServiceProvider.class, str);
    }

    public static OauthServiceProvider[] values() {
        return (OauthServiceProvider[]) $VALUES.clone();
    }
}
