package sputnik.axmor.com.sputnik.core.players.models;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PlayerStates.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lsputnik/axmor/com/sputnik/core/players/models/PlayerStates;", "", "(Ljava/lang/String;I)V", "DEFAULT", "LOADING", "LOADED", "ERROR", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PlayerStates {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PlayerStates[] $VALUES;
    public static final PlayerStates DEFAULT = new PlayerStates("DEFAULT", 0);
    public static final PlayerStates LOADING = new PlayerStates("LOADING", 1);
    public static final PlayerStates LOADED = new PlayerStates("LOADED", 2);
    public static final PlayerStates ERROR = new PlayerStates("ERROR", 3);

    private static final /* synthetic */ PlayerStates[] $values() {
        return new PlayerStates[]{DEFAULT, LOADING, LOADED, ERROR};
    }

    public static PlayerStates valueOf(String str) {
        return (PlayerStates) Enum.valueOf(PlayerStates.class, str);
    }

    public static PlayerStates[] values() {
        return (PlayerStates[]) $VALUES.clone();
    }

    private PlayerStates(String str, int i) {
    }

    static {
        PlayerStates[] playerStatesArr$values = $values();
        $VALUES = playerStatesArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(playerStatesArr$values);
    }
}
