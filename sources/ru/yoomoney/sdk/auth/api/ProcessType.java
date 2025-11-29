package ru.yoomoney.sdk.auth.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/ProcessType;", "", "(Ljava/lang/String;I)V", "ENROLLMENT", "REGISTRATION", "LOGIN", "MIGRATION", "CHANGE_EMAIL", "CHANGE_PHONE", "CHANGE_PASSWORD", "PASSWORD_RECOVERY", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ProcessType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ProcessType[] $VALUES;
    public static final ProcessType ENROLLMENT = new ProcessType("ENROLLMENT", 0);
    public static final ProcessType REGISTRATION = new ProcessType("REGISTRATION", 1);
    public static final ProcessType LOGIN = new ProcessType("LOGIN", 2);
    public static final ProcessType MIGRATION = new ProcessType("MIGRATION", 3);
    public static final ProcessType CHANGE_EMAIL = new ProcessType("CHANGE_EMAIL", 4);
    public static final ProcessType CHANGE_PHONE = new ProcessType("CHANGE_PHONE", 5);
    public static final ProcessType CHANGE_PASSWORD = new ProcessType("CHANGE_PASSWORD", 6);
    public static final ProcessType PASSWORD_RECOVERY = new ProcessType("PASSWORD_RECOVERY", 7);

    private static final /* synthetic */ ProcessType[] $values() {
        return new ProcessType[]{ENROLLMENT, REGISTRATION, LOGIN, MIGRATION, CHANGE_EMAIL, CHANGE_PHONE, CHANGE_PASSWORD, PASSWORD_RECOVERY};
    }

    static {
        ProcessType[] processTypeArr$values = $values();
        $VALUES = processTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(processTypeArr$values);
    }

    private ProcessType(String str, int i) {
    }

    public static EnumEntries<ProcessType> getEntries() {
        return $ENTRIES;
    }

    public static ProcessType valueOf(String str) {
        return (ProcessType) Enum.valueOf(ProcessType.class, str);
    }

    public static ProcessType[] values() {
        return (ProcessType[]) $VALUES.clone();
    }
}
