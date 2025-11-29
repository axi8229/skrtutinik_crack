package ru.yoomoney.sdk.auth.api.account.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/model/Language;", "", "(Ljava/lang/String;I)V", "RU", "EN", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Language {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Language[] $VALUES;

    @SerializedName("ru")
    public static final Language RU = new Language("RU", 0);

    @SerializedName("en")
    public static final Language EN = new Language("EN", 1);

    private static final /* synthetic */ Language[] $values() {
        return new Language[]{RU, EN};
    }

    static {
        Language[] languageArr$values = $values();
        $VALUES = languageArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(languageArr$values);
    }

    private Language(String str, int i) {
    }

    public static EnumEntries<Language> getEntries() {
        return $ENTRIES;
    }

    public static Language valueOf(String str) {
        return (Language) Enum.valueOf(Language.class, str);
    }

    public static Language[] values() {
        return (Language[]) $VALUES.clone();
    }
}
