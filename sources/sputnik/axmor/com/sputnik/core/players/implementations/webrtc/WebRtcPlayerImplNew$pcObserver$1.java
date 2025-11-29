package sputnik.axmor.com.sputnik.core.players.implementations.webrtc;

import com.sputnik.common.utils.LogUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.webrtc.CandidatePairChangeEvent;
import org.webrtc.DataChannel;
import org.webrtc.IceCandidate;
import org.webrtc.MediaStream;
import org.webrtc.MediaStreamTrack;
import org.webrtc.PeerConnection;
import org.webrtc.RendererCommon;
import org.webrtc.RtpReceiver;
import org.webrtc.RtpTransceiver;
import org.webrtc.SessionDescription;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoTrack;
import sputnik.axmor.com.sputnik.core.players.models.PlayerStates;
import sputnik.axmor.com.sputnik.core.players.sdp.CustomSdpObserver;
import sputnik.axmor.com.sputnik.core.players.webrtc.PeerConnectionObserver;
import sputnik.axmor.com.sputnik.core.players.webrtc.UtilsKt;
import sputnik.axmor.com.sputnik.core.players.whap.IWhapManager;

/* compiled from: WebRtcPlayerImplNew.kt */
@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016¨\u0006\u0012"}, d2 = {"sputnik/axmor/com/sputnik/core/players/implementations/webrtc/WebRtcPlayerImplNew$pcObserver$1", "Lsputnik/axmor/com/sputnik/core/players/webrtc/PeerConnectionObserver;", "onAddTrack", "", "p0", "Lorg/webrtc/RtpReceiver;", "p1", "", "Lorg/webrtc/MediaStream;", "(Lorg/webrtc/RtpReceiver;[Lorg/webrtc/MediaStream;)V", "onConnectionChange", "newState", "Lorg/webrtc/PeerConnection$PeerConnectionState;", "onIceCandidate", "Lorg/webrtc/IceCandidate;", "onIceGatheringChange", "Lorg/webrtc/PeerConnection$IceGatheringState;", "onRenegotiationNeeded", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WebRtcPlayerImplNew$pcObserver$1 implements PeerConnectionObserver {
    final /* synthetic */ WebRtcPlayerImplNew this$0;

    /* compiled from: WebRtcPlayerImplNew.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[PeerConnection.IceGatheringState.values().length];
            try {
                iArr[PeerConnection.IceGatheringState.GATHERING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PeerConnection.IceGatheringState.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MediaStreamTrack.State.values().length];
            try {
                iArr2[MediaStreamTrack.State.LIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[PeerConnection.PeerConnectionState.values().length];
            try {
                iArr3[PeerConnection.PeerConnectionState.DISCONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr3[PeerConnection.PeerConnectionState.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    WebRtcPlayerImplNew$pcObserver$1(WebRtcPlayerImplNew webRtcPlayerImplNew) {
        this.this$0 = webRtcPlayerImplNew;
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onAddStream(MediaStream mediaStream) {
        PeerConnectionObserver.DefaultImpls.onAddStream(this, mediaStream);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onDataChannel(DataChannel dataChannel) {
        PeerConnectionObserver.DefaultImpls.onDataChannel(this, dataChannel);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
        PeerConnectionObserver.DefaultImpls.onIceCandidatesRemoved(this, iceCandidateArr);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
        PeerConnectionObserver.DefaultImpls.onIceConnectionChange(this, iceConnectionState);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceConnectionReceivingChange(boolean z) {
        PeerConnectionObserver.DefaultImpls.onIceConnectionReceivingChange(this, z);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onRemoveStream(MediaStream mediaStream) {
        PeerConnectionObserver.DefaultImpls.onRemoveStream(this, mediaStream);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onSelectedCandidatePairChanged(CandidatePairChangeEvent candidatePairChangeEvent) {
        PeerConnectionObserver.DefaultImpls.onSelectedCandidatePairChanged(this, candidatePairChangeEvent);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onSignalingChange(PeerConnection.SignalingState signalingState) {
        PeerConnectionObserver.DefaultImpls.onSignalingChange(this, signalingState);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onStandardizedIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
        PeerConnectionObserver.DefaultImpls.onStandardizedIceConnectionChange(this, iceConnectionState);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onTrack(RtpTransceiver rtpTransceiver) {
        PeerConnectionObserver.DefaultImpls.onTrack(this, rtpTransceiver);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceCandidate(IceCandidate p0) {
        PeerConnectionObserver.DefaultImpls.onIceCandidate(this, p0);
        PeerConnection peerConnection = this.this$0.peerConnection;
        if (peerConnection != null) {
            peerConnection.addIceCandidate(new IceCandidate(p0 != null ? p0.sdpMid : null, p0 != null ? p0.sdpMLineIndex : 0, p0 != null ? p0.sdp : null));
        }
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceGatheringChange(PeerConnection.IceGatheringState p0) {
        SessionDescription localDescription;
        PeerConnectionObserver.DefaultImpls.onIceGatheringChange(this, p0);
        if (this.this$0.isDeviceSupportH264) {
            if ((p0 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[p0.ordinal()]) != 2) {
                return;
            }
            this.this$0.needToAddTrack = true;
            if (this.this$0.getLastKnownUrl() != null) {
                IWhapManager iWhapManager = this.this$0.whapManager;
                String strValueOf = String.valueOf(this.this$0.getLastKnownUrl());
                PeerConnection peerConnection = this.this$0.peerConnection;
                iWhapManager.requestSdp(strValueOf, String.valueOf((peerConnection == null || (localDescription = peerConnection.getLocalDescription()) == null) ? null : localDescription.description));
            }
        }
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onAddTrack(RtpReceiver p0, MediaStream[] p1) {
        MediaStream mediaStream;
        MediaStreamTrack mediaStreamTrackTrack;
        PeerConnectionObserver.DefaultImpls.onAddTrack(this, p0, p1);
        if (this.this$0.needToAddTrack) {
            if (p0 != null && (mediaStreamTrackTrack = p0.track()) != null) {
                mediaStreamTrackTrack.setEnabled(true);
            }
            if (p1 == null || (mediaStream = (MediaStream) ArraysKt.firstOrNull(p1)) == null) {
                return;
            }
            final WebRtcPlayerImplNew webRtcPlayerImplNew = this.this$0;
            List<VideoTrack> list = mediaStream.videoTracks;
            if (list != null) {
                Intrinsics.checkNotNull(list);
                int i = 0;
                for (Object obj : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    VideoTrack videoTrack = (VideoTrack) obj;
                    webRtcPlayerImplNew.videoTrack = videoTrack;
                    videoTrack.addSink(webRtcPlayerImplNew.surfaceViewRenderer);
                    MediaStreamTrack.State state = videoTrack.state();
                    if ((state == null ? -1 : WhenMappings.$EnumSwitchMapping$1[state.ordinal()]) == 1) {
                        Intrinsics.checkNotNull(videoTrack);
                        videoTrack.setEnabled(true);
                        webRtcPlayerImplNew.activity.runOnUiThread(new Runnable() { // from class: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImplNew$pcObserver$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                WebRtcPlayerImplNew$pcObserver$1.onAddTrack$lambda$5$lambda$4$lambda$3(webRtcPlayerImplNew);
                            }
                        });
                    }
                    i = i2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAddTrack$lambda$5$lambda$4$lambda$3(final WebRtcPlayerImplNew this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SurfaceViewRenderer surfaceViewRenderer = this$0.surfaceViewRenderer;
        surfaceViewRenderer.setMirror(false);
        surfaceViewRenderer.setEnableHardwareScaler(true);
        surfaceViewRenderer.disableFpsReduction();
        try {
            surfaceViewRenderer.init(this$0.rootEglBase.getEglBaseContext(), new RendererCommon.RendererEvents() { // from class: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImplNew$pcObserver$1$onAddTrack$1$1$2$1$1$1
                @Override // org.webrtc.RendererCommon.RendererEvents
                public void onFrameResolutionChanged(int p0, int p1, int p2) {
                }

                @Override // org.webrtc.RendererCommon.RendererEvents
                public void onFirstFrameRendered() {
                    this$0.playerCallback.onStateChanged(PlayerStates.LOADED);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onRenegotiationNeeded() {
        PeerConnectionObserver.DefaultImpls.onRenegotiationNeeded(this);
        PeerConnection peerConnection = this.this$0.peerConnection;
        if (peerConnection != null) {
            final WebRtcPlayerImplNew webRtcPlayerImplNew = this.this$0;
            peerConnection.createOffer(new CustomSdpObserver() { // from class: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImplNew$pcObserver$1$onRenegotiationNeeded$1
                @Override // org.webrtc.SdpObserver
                public void onCreateFailure(String str) {
                    CustomSdpObserver.DefaultImpls.onCreateFailure(this, str);
                }

                @Override // org.webrtc.SdpObserver
                public void onSetFailure(String str) {
                    CustomSdpObserver.DefaultImpls.onSetFailure(this, str);
                }

                @Override // org.webrtc.SdpObserver
                public void onSetSuccess() {
                    CustomSdpObserver.DefaultImpls.onSetSuccess(this);
                }

                @Override // org.webrtc.SdpObserver
                public void onCreateSuccess(SessionDescription p0) {
                    CustomSdpObserver.DefaultImpls.onCreateSuccess(this, p0);
                    PeerConnection peerConnection2 = webRtcPlayerImplNew.peerConnection;
                    if (peerConnection2 != null) {
                        final WebRtcPlayerImplNew webRtcPlayerImplNew2 = webRtcPlayerImplNew;
                        peerConnection2.setLocalDescription(new CustomSdpObserver() { // from class: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImplNew$pcObserver$1$onRenegotiationNeeded$1$onCreateSuccess$1
                            @Override // org.webrtc.SdpObserver
                            public void onCreateFailure(String str) {
                                CustomSdpObserver.DefaultImpls.onCreateFailure(this, str);
                            }

                            @Override // org.webrtc.SdpObserver
                            public void onCreateSuccess(SessionDescription sessionDescription) {
                                CustomSdpObserver.DefaultImpls.onCreateSuccess(this, sessionDescription);
                            }

                            @Override // org.webrtc.SdpObserver
                            public void onSetSuccess() {
                                CustomSdpObserver.DefaultImpls.onSetSuccess(this);
                            }

                            @Override // org.webrtc.SdpObserver
                            public void onSetFailure(String p02) {
                                CustomSdpObserver.DefaultImpls.onSetFailure(this, p02);
                                webRtcPlayerImplNew2.playerCallback.onStateChanged(PlayerStates.ERROR);
                            }
                        }, p0);
                    }
                }
            }, UtilsKt.getMediaConstraints());
        }
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onConnectionChange(PeerConnection.PeerConnectionState newState) {
        PeerConnectionObserver.DefaultImpls.onConnectionChange(this, newState);
        int i = newState == null ? -1 : WhenMappings.$EnumSwitchMapping$2[newState.ordinal()];
        if (i == 1) {
            LogUtilsKt.writeLog("WEBRTC PLAY - DISCONNECTED");
        } else {
            if (i != 2) {
                return;
            }
            this.this$0.playerCallback.onStateChanged(PlayerStates.ERROR);
        }
    }
}
