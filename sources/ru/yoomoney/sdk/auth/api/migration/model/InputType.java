package ru.yoomoney.sdk.auth.api.migration.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/model/InputType;", "", "(Ljava/lang/String;I)V", "RAW", "SUGGESTION", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InputType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InputType[] $VALUES;

    @SerializedName("Raw")
    public static final InputType RAW = new InputType("RAW", 0);

    @SerializedName("Suggestion")
    public static final InputType SUGGESTION = new InputType("SUGGESTION", 1);

    private static final /* synthetic */ InputType[] $values() {
        return new InputType[]{RAW, SUGGESTION};
    }

    static {
        InputType[] inputTypeArr$values = $values();
        $VALUES = inputTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(inputTypeArr$values);
    }

    private InputType(String str, int i) {
    }

    public static EnumEntries<InputType> getEntries() {
        return $ENTRIES;
    }

    public static InputType valueOf(String str) {
        return (InputType) Enum.valueOf(InputType.class, str);
    }

    public static InputType[] values() {
        return (InputType[]) $VALUES.clone();
    }
}
