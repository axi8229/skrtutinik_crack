package sputnik.axmor.com.sputnik.core.players.implementations.webrtc;

import android.app.Activity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.sputnik.common.utils.LogUtilsKt;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import org.webrtc.DefaultVideoDecoderFactory;
import org.webrtc.DefaultVideoEncoderFactory;
import org.webrtc.EglBase;
import org.webrtc.Loggable;
import org.webrtc.Logging;
import org.webrtc.MediaStreamTrack;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.RendererCommon;
import org.webrtc.RtpTransceiver;
import org.webrtc.SessionDescription;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoTrack;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImplNew;
import sputnik.axmor.com.sputnik.core.players.interfaces.PlayerCallback;
import sputnik.axmor.com.sputnik.core.players.models.PlayerStates;
import sputnik.axmor.com.sputnik.core.players.sdp.CustomSdpObserver;
import sputnik.axmor.com.sputnik.core.players.webrtc.UtilsKt;
import sputnik.axmor.com.sputnik.core.players.whap.IWhapManager;
import sputnik.axmor.com.sputnik.core.players.whap.WhapCallback;
import sputnik.axmor.com.sputnik.core.players.whap.WhapManager;

/* compiled from: WebRtcPlayerImpl.kt */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u00016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\r\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010\u000f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u0012R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00105¨\u0006@"}, d2 = {"Lsputnik/axmor/com/sputnik/core/players/implementations/webrtc/WebRtcPlayerImpl;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayerCallback;", "playerCallback", "Lorg/webrtc/SurfaceViewRenderer;", "surfaceViewRenderer", "Landroid/app/Activity;", "activity", "<init>", "(Landroidx/lifecycle/Lifecycle;Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayerCallback;Lorg/webrtc/SurfaceViewRenderer;Landroid/app/Activity;)V", "", "initConnection", "()V", "", "url", "play", "(Ljava/lang/String;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onResume", "(Landroidx/lifecycle/LifecycleOwner;)V", "onStop", "onDestroy", "release", "Landroidx/lifecycle/Lifecycle;", "Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayerCallback;", "Lorg/webrtc/SurfaceViewRenderer;", "Landroid/app/Activity;", "Lokhttp3/OkHttpClient;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "setOkHttpClient", "(Lokhttp3/OkHttpClient;)V", "Lorg/webrtc/VideoTrack;", "videoTrack", "Lorg/webrtc/VideoTrack;", "lastKnownUrl", "Ljava/lang/String;", "getLastKnownUrl", "()Ljava/lang/String;", "setLastKnownUrl", "Lorg/webrtc/EglBase;", "rootEglBase", "Lorg/webrtc/EglBase;", "Lsputnik/axmor/com/sputnik/core/players/whap/IWhapManager;", "whapManager", "Lsputnik/axmor/com/sputnik/core/players/whap/IWhapManager;", "", "needToAddTrack", "Z", "sputnik/axmor/com/sputnik/core/players/implementations/webrtc/WebRtcPlayerImpl$pcObserver$1", "pcObserver", "Lsputnik/axmor/com/sputnik/core/players/implementations/webrtc/WebRtcPlayerImpl$pcObserver$1;", "Lorg/webrtc/PeerConnectionFactory;", "peerConnectionFactory", "Lorg/webrtc/PeerConnectionFactory;", "Lorg/webrtc/PeerConnection;", "peerConnection", "Lorg/webrtc/PeerConnection;", "dontHandleLifecycle", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WebRtcPlayerImpl implements DefaultLifecycleObserver {
    private final Activity activity;
    private boolean dontHandleLifecycle;
    private String lastKnownUrl;
    private final Lifecycle lifecycle;
    private boolean needToAddTrack;
    public OkHttpClient okHttpClient;
    private final WebRtcPlayerImpl$pcObserver$1 pcObserver;
    private PeerConnection peerConnection;
    private PeerConnectionFactory peerConnectionFactory;
    private final PlayerCallback playerCallback;
    private EglBase rootEglBase;
    private SurfaceViewRenderer surfaceViewRenderer;
    private VideoTrack videoTrack;
    private IWhapManager whapManager;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(String str, Logging.Severity severity, String str2) {
    }

    public WebRtcPlayerImpl(Lifecycle lifecycle, PlayerCallback playerCallback, SurfaceViewRenderer surfaceViewRenderer, Activity activity) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(playerCallback, "playerCallback");
        Intrinsics.checkNotNullParameter(surfaceViewRenderer, "surfaceViewRenderer");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.lifecycle = lifecycle;
        this.playerCallback = playerCallback;
        this.surfaceViewRenderer = surfaceViewRenderer;
        this.activity = activity;
        SputnikApp.INSTANCE.applicationContext().getAppComponent().inject(this);
        lifecycle.addObserver(this);
        SurfaceViewRenderer surfaceViewRenderer2 = this.surfaceViewRenderer;
        surfaceViewRenderer2.setEnableHardwareScaler(false);
        RendererCommon.ScalingType scalingType = RendererCommon.ScalingType.SCALE_ASPECT_FIT;
        surfaceViewRenderer2.setScalingType(scalingType, scalingType);
        PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(activity.getApplicationContext()).setEnableInternalTracer(true).setInjectableLogger(new Loggable() { // from class: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImpl$$ExternalSyntheticLambda0
            @Override // org.webrtc.Loggable
            public final void onLogMessage(String str, Logging.Severity severity, String str2) {
                WebRtcPlayerImpl._init_$lambda$1(str, severity, str2);
            }
        }, Logging.Severity.LS_VERBOSE).createInitializationOptions());
        EglBase eglBaseCreate = EglBase.create();
        Intrinsics.checkNotNullExpressionValue(eglBaseCreate, "create(...)");
        this.rootEglBase = eglBaseCreate;
        this.whapManager = new WhapManager(new WhapCallback() { // from class: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImpl$whapManager$1
            @Override // sputnik.axmor.com.sputnik.core.players.whap.WhapCallback
            public void onResult(String sdp) {
                Intrinsics.checkNotNullParameter(sdp, "sdp");
                PeerConnection peerConnection = this.this$0.peerConnection;
                if (peerConnection != null) {
                    final WebRtcPlayerImpl webRtcPlayerImpl = this.this$0;
                    peerConnection.setRemoteDescription(new CustomSdpObserver() { // from class: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImpl$whapManager$1$onResult$1
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
                        public void onSetFailure(String p0) {
                            CustomSdpObserver.DefaultImpls.onSetFailure(this, p0);
                            webRtcPlayerImpl.playerCallback.onStateChanged(PlayerStates.ERROR);
                        }
                    }, new SessionDescription(SessionDescription.Type.ANSWER, sdp));
                }
            }

            @Override // sputnik.axmor.com.sputnik.core.players.whap.WhapCallback
            public void onError(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                this.this$0.playerCallback.onStateChanged(PlayerStates.ERROR);
            }

            @Override // sputnik.axmor.com.sputnik.core.players.whap.WhapCallback
            public void onIncorrectUrl() {
                this.this$0.playerCallback.onCodecNotSupported(WebRtcPlayerImplNew.NotSupportedReasons.CAMERA);
            }
        }, getOkHttpClient());
        this.pcObserver = new WebRtcPlayerImpl$pcObserver$1(this);
        PeerConnectionFactory.Builder videoEncoderFactory = PeerConnectionFactory.builder().setVideoDecoderFactory(new DefaultVideoDecoderFactory(this.rootEglBase.getEglBaseContext())).setVideoEncoderFactory(new DefaultVideoEncoderFactory(this.rootEglBase.getEglBaseContext(), false, true));
        PeerConnectionFactory.Options options = new PeerConnectionFactory.Options();
        options.networkIgnoreMask = 0;
        Unit unit = Unit.INSTANCE;
        PeerConnectionFactory peerConnectionFactoryCreatePeerConnectionFactory = videoEncoderFactory.setOptions(options).createPeerConnectionFactory();
        Intrinsics.checkNotNullExpressionValue(peerConnectionFactoryCreatePeerConnectionFactory, "createPeerConnectionFactory(...)");
        this.peerConnectionFactory = peerConnectionFactoryCreatePeerConnectionFactory;
    }

    public final OkHttpClient getOkHttpClient() {
        OkHttpClient okHttpClient = this.okHttpClient;
        if (okHttpClient != null) {
            return okHttpClient;
        }
        Intrinsics.throwUninitializedPropertyAccessException("okHttpClient");
        return null;
    }

    protected final String getLastKnownUrl() {
        return this.lastKnownUrl;
    }

    private final void initConnection() {
        PeerConnection peerConnectionCreatePeerConnection = this.peerConnectionFactory.createPeerConnection(CollectionsKt.emptyList(), this.pcObserver);
        this.peerConnection = peerConnectionCreatePeerConnection;
        if (peerConnectionCreatePeerConnection != null) {
            peerConnectionCreatePeerConnection.addTransceiver(MediaStreamTrack.MediaType.MEDIA_TYPE_VIDEO, new RtpTransceiver.RtpTransceiverInit());
        }
        PeerConnection peerConnection = this.peerConnection;
        if (peerConnection != null) {
            peerConnection.addTransceiver(MediaStreamTrack.MediaType.MEDIA_TYPE_AUDIO, new RtpTransceiver.RtpTransceiverInit());
        }
        PeerConnection peerConnection2 = this.peerConnection;
        if (peerConnection2 != null) {
            peerConnection2.createOffer(new CustomSdpObserver() { // from class: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImpl.initConnection.1
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
                    PeerConnection peerConnection3 = WebRtcPlayerImpl.this.peerConnection;
                    if (peerConnection3 != null) {
                        peerConnection3.setLocalDescription(new CustomSdpObserver() { // from class: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImpl$initConnection$1$onCreateSuccess$1
                            @Override // org.webrtc.SdpObserver
                            public void onCreateFailure(String str) {
                                CustomSdpObserver.DefaultImpls.onCreateFailure(this, str);
                            }

                            @Override // org.webrtc.SdpObserver
                            public void onCreateSuccess(SessionDescription sessionDescription) {
                                CustomSdpObserver.DefaultImpls.onCreateSuccess(this, sessionDescription);
                            }

                            @Override // org.webrtc.SdpObserver
                            public void onSetFailure(String str) {
                                CustomSdpObserver.DefaultImpls.onSetFailure(this, str);
                            }

                            @Override // org.webrtc.SdpObserver
                            public void onSetSuccess() {
                                CustomSdpObserver.DefaultImpls.onSetSuccess(this);
                            }
                        }, p0);
                    }
                }
            }, UtilsKt.getMediaConstraints());
        }
    }

    public final void play(String url) {
        if (!Intrinsics.areEqual(url, this.lastKnownUrl)) {
            url = String.valueOf(url != null ? StringsKt.replace$default(url, "video1.ts", "whap", false, 4, (Object) null) : null);
        }
        VideoTrack videoTrack = this.videoTrack;
        if ((videoTrack != null ? videoTrack.state() : null) == MediaStreamTrack.State.LIVE) {
            return;
        }
        this.playerCallback.onStateChanged(PlayerStates.LOADING);
        try {
            new URL(url);
            this.lastKnownUrl = url;
            try {
                new URL(this.lastKnownUrl);
                if (url != null) {
                    this.lastKnownUrl = url;
                }
                try {
                    this.rootEglBase.releaseSurface();
                    PeerConnection peerConnection = this.peerConnection;
                    if (peerConnection != null) {
                        peerConnection.setAudioPlayout(true);
                    }
                    VideoTrack videoTrack2 = this.videoTrack;
                    if (videoTrack2 != null) {
                        videoTrack2.removeSink(this.surfaceViewRenderer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                initConnection();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onResume(owner);
        if (this.lastKnownUrl != null) {
            VideoTrack videoTrack = this.videoTrack;
            if ((videoTrack != null ? videoTrack.state() : null) != MediaStreamTrack.State.LIVE) {
                play(String.valueOf(this.lastKnownUrl));
            }
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onStop(owner);
        LogUtilsKt.writeLog("LIFECYCLE: STOPPING");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onDestroy(owner);
        if (!this.dontHandleLifecycle) {
            release();
        }
        LogUtilsKt.writeLog("LIFECYCLE: DESTROY");
    }

    public final void release() {
        PeerConnection peerConnection = this.peerConnection;
        if (peerConnection != null) {
            peerConnection.dispose();
        }
        this.peerConnectionFactory.dispose();
        this.peerConnection = null;
        this.surfaceViewRenderer.release();
    }
}
