package sputnik.axmor.com.sputnik.core.players.webrtc;

import com.sputnik.common.utils.LogUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import org.webrtc.CandidatePairChangeEvent;
import org.webrtc.DataChannel;
import org.webrtc.IceCandidate;
import org.webrtc.MediaStream;
import org.webrtc.PeerConnection;
import org.webrtc.RtpReceiver;
import org.webrtc.RtpTransceiver;
import org.webrtc.VideoTrack;

/* compiled from: PeerConnectionObserver.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lsputnik/axmor/com/sputnik/core/players/webrtc/PeerConnectionObserver;", "Lorg/webrtc/PeerConnection$Observer;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface PeerConnectionObserver extends PeerConnection.Observer {

    /* compiled from: PeerConnectionObserver.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onIceCandidate(PeerConnectionObserver peerConnectionObserver, IceCandidate iceCandidate) {
        }

        public static void onSignalingChange(PeerConnectionObserver peerConnectionObserver, PeerConnection.SignalingState signalingState) {
            LogUtilsKt.writeLog("onSignalingChange = " + (signalingState != null ? signalingState.toString() : null));
        }

        public static void onIceConnectionChange(PeerConnectionObserver peerConnectionObserver, PeerConnection.IceConnectionState iceConnectionState) {
            LogUtilsKt.writeLog("onIceConnectionChange = " + (iceConnectionState != null ? iceConnectionState.toString() : null));
        }

        public static void onIceConnectionReceivingChange(PeerConnectionObserver peerConnectionObserver, boolean z) {
            LogUtilsKt.writeLog("onIceConnectionReceivingChange = " + z);
        }

        public static void onIceGatheringChange(PeerConnectionObserver peerConnectionObserver, PeerConnection.IceGatheringState iceGatheringState) {
            LogUtilsKt.writeLog("onIceGatheringChange: " + iceGatheringState);
        }

        public static void onIceCandidatesRemoved(PeerConnectionObserver peerConnectionObserver, IceCandidate[] iceCandidateArr) {
            LogUtilsKt.writeLog("onIceCandidatesRemoved");
        }

        public static void onAddStream(PeerConnectionObserver peerConnectionObserver, MediaStream mediaStream) {
            List<VideoTrack> list;
            LogUtilsKt.writeLog("onAddStream = " + ((mediaStream == null || (list = mediaStream.videoTracks) == null) ? null : Integer.valueOf(list.size())));
        }

        public static void onRemoveStream(PeerConnectionObserver peerConnectionObserver, MediaStream mediaStream) {
            List<VideoTrack> list;
            LogUtilsKt.writeLog("onRemoveStream  = " + ((mediaStream == null || (list = mediaStream.videoTracks) == null) ? null : Integer.valueOf(list.size())));
        }

        public static void onDataChannel(PeerConnectionObserver peerConnectionObserver, DataChannel dataChannel) {
            LogUtilsKt.writeLog("onDataChannel");
        }

        public static void onRenegotiationNeeded(PeerConnectionObserver peerConnectionObserver) {
            LogUtilsKt.writeLog("onRenegotiationNeeded");
        }

        public static void onAddTrack(PeerConnectionObserver peerConnectionObserver, RtpReceiver rtpReceiver, MediaStream[] mediaStreamArr) {
            MediaStream mediaStream;
            List<VideoTrack> list;
            LogUtilsKt.writeLog("onAddTrack = " + rtpReceiver + " ");
            Integer numValueOf = null;
            Integer numValueOf2 = mediaStreamArr != null ? Integer.valueOf(mediaStreamArr.length) : null;
            if (mediaStreamArr != null && (mediaStream = (MediaStream) ArraysKt.firstOrNull(mediaStreamArr)) != null && (list = mediaStream.videoTracks) != null) {
                numValueOf = Integer.valueOf(list.size());
            }
            LogUtilsKt.writeLog("onAddTrack = " + numValueOf2 + " " + numValueOf);
        }

        public static void onStandardizedIceConnectionChange(PeerConnectionObserver peerConnectionObserver, PeerConnection.IceConnectionState iceConnectionState) {
            LogUtilsKt.writeLog("onStandardizedIceConnectionChange: " + iceConnectionState);
        }

        public static void onConnectionChange(PeerConnectionObserver peerConnectionObserver, PeerConnection.PeerConnectionState peerConnectionState) {
            LogUtilsKt.writeLog("onConnectionChange = " + peerConnectionState);
        }

        public static void onSelectedCandidatePairChanged(PeerConnectionObserver peerConnectionObserver, CandidatePairChangeEvent candidatePairChangeEvent) {
            LogUtilsKt.writeLog("onSelectedCandidatePairChanged");
        }

        public static void onTrack(PeerConnectionObserver peerConnectionObserver, RtpTransceiver rtpTransceiver) {
            LogUtilsKt.writeLog("onTrack");
        }
    }
}
