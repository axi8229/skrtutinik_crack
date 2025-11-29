package ru.yoomoney.sdk.auth.api.crypt.oauth.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/crypt/oauth/model/VkApplicationType;", "", "(Ljava/lang/String;I)V", "WALLET", "INDIE", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VkApplicationType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VkApplicationType[] $VALUES;
    public static final VkApplicationType WALLET = new VkApplicationType("WALLET", 0);
    public static final VkApplicationType INDIE = new VkApplicationType("INDIE", 1);

    private static final /* synthetic */ VkApplicationType[] $values() {
        return new VkApplicationType[]{WALLET, INDIE};
    }

    static {
        VkApplicationType[] vkApplicationTypeArr$values = $values();
        $VALUES = vkApplicationTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(vkApplicationTypeArr$values);
    }

    private VkApplicationType(String str, int i) {
    }

    public static EnumEntries<VkApplicationType> getEntries() {
        return $ENTRIES;
    }

    public static VkApplicationType valueOf(String str) {
        return (VkApplicationType) Enum.valueOf(VkApplicationType.class, str);
    }

    public static VkApplicationType[] values() {
        return (VkApplicationType[]) $VALUES.clone();
    }
}
