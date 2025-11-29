package ru.yoomoney.sdk.two_fa.domain;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Domain.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/two_fa/domain/AuthStatus;", "", "(Ljava/lang/String;I)V", "PENDING", "AUTHORIZED", "DENIED", "UNKNOWN_ENUM", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AuthStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AuthStatus[] $VALUES;
    public static final AuthStatus PENDING = new AuthStatus("PENDING", 0);
    public static final AuthStatus AUTHORIZED = new AuthStatus("AUTHORIZED", 1);
    public static final AuthStatus DENIED = new AuthStatus("DENIED", 2);
    public static final AuthStatus UNKNOWN_ENUM = new AuthStatus("UNKNOWN_ENUM", 3);

    private static final /* synthetic */ AuthStatus[] $values() {
        return new AuthStatus[]{PENDING, AUTHORIZED, DENIED, UNKNOWN_ENUM};
    }

    public static EnumEntries<AuthStatus> getEntries() {
        return $ENTRIES;
    }

    public static AuthStatus valueOf(String str) {
        return (AuthStatus) Enum.valueOf(AuthStatus.class, str);
    }

    public static AuthStatus[] values() {
        return (AuthStatus[]) $VALUES.clone();
    }

    private AuthStatus(String str, int i) {
    }

    static {
        AuthStatus[] authStatusArr$values = $values();
        $VALUES = authStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(authStatusArr$values);
    }
}
