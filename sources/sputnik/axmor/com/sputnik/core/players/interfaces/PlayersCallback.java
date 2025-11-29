package sputnik.axmor.com.sputnik.core.players.interfaces;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import sputnik.axmor.com.sputnik.core.players.models.PlayerStates;

/* compiled from: PlayersCallback.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayersCallback;", "", "Lsputnik/axmor/com/sputnik/core/players/models/PlayerStates;", "state", "Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayersCallback$Players;", "player", "", "onStateChanged", "(Lsputnik/axmor/com/sputnik/core/players/models/PlayerStates;Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayersCallback$Players;)V", "Players", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface PlayersCallback {
    void onStateChanged(PlayerStates state, Players player);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: PlayersCallback.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayersCallback$Players;", "", "(Ljava/lang/String;I)V", "EXO", "WEBRTC", "VLC", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Players {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Players[] $VALUES;
        public static final Players EXO = new Players("EXO", 0);
        public static final Players WEBRTC = new Players("WEBRTC", 1);
        public static final Players VLC = new Players("VLC", 2);

        private static final /* synthetic */ Players[] $values() {
            return new Players[]{EXO, WEBRTC, VLC};
        }

        public static Players valueOf(String str) {
            return (Players) Enum.valueOf(Players.class, str);
        }

        public static Players[] values() {
            return (Players[]) $VALUES.clone();
        }

        private Players(String str, int i) {
        }

        static {
            Players[] playersArr$values = $values();
            $VALUES = playersArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(playersArr$values);
        }
    }
}
