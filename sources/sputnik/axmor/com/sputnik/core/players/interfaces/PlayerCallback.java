package sputnik.axmor.com.sputnik.core.players.interfaces;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImplNew;
import sputnik.axmor.com.sputnik.core.players.models.PlayerStates;

/* compiled from: PlayerCallback.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayerCallback;", "", "Lsputnik/axmor/com/sputnik/core/players/models/PlayerStates;", "state", "", "onStateChanged", "(Lsputnik/axmor/com/sputnik/core/players/models/PlayerStates;)V", "Lsputnik/axmor/com/sputnik/core/players/implementations/webrtc/WebRtcPlayerImplNew$NotSupportedReasons;", "where", "onCodecNotSupported", "(Lsputnik/axmor/com/sputnik/core/players/implementations/webrtc/WebRtcPlayerImplNew$NotSupportedReasons;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface PlayerCallback {

    /* compiled from: PlayerCallback.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onCodecNotSupported(PlayerCallback playerCallback, WebRtcPlayerImplNew.NotSupportedReasons where) {
            Intrinsics.checkNotNullParameter(where, "where");
        }
    }

    void onCodecNotSupported(WebRtcPlayerImplNew.NotSupportedReasons where);

    void onStateChanged(PlayerStates state);
}
