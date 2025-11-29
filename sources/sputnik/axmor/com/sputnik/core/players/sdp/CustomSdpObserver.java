package sputnik.axmor.com.sputnik.core.players.sdp;

import com.sputnik.common.utils.LogUtilsKt;
import kotlin.Metadata;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;

/* compiled from: CustomSdpObserver.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lsputnik/axmor/com/sputnik/core/players/sdp/CustomSdpObserver;", "Lorg/webrtc/SdpObserver;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface CustomSdpObserver extends SdpObserver {

    /* compiled from: CustomSdpObserver.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onCreateSuccess(CustomSdpObserver customSdpObserver, SessionDescription sessionDescription) {
            LogUtilsKt.writeLog("onCreateSuccess " + (sessionDescription != null ? sessionDescription.type : null));
            LogUtilsKt.writeLog(String.valueOf(sessionDescription != null ? sessionDescription.description : null));
        }

        public static void onSetSuccess(CustomSdpObserver customSdpObserver) {
            LogUtilsKt.writeLog("onSetSuccess");
        }

        public static void onCreateFailure(CustomSdpObserver customSdpObserver, String str) {
            LogUtilsKt.writeLog("onCreateFailure");
            LogUtilsKt.writeLog(String.valueOf(str));
        }

        public static void onSetFailure(CustomSdpObserver customSdpObserver, String str) {
            LogUtilsKt.writeLog("onSetFailure");
            LogUtilsKt.writeLog(String.valueOf(str));
        }
    }
}
