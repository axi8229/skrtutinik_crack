package sputnik.axmor.com.sputnik.core.players.implementations.webrtc;

import android.app.Activity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.sputnik.common.utils.LogUtilsKt;
import java.net.URL;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import org.webrtc.DefaultVideoDecoderFactory;
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
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.CustomVideoEncoderFactory;
import sputnik.axmor.com.sputnik.core.players.interfaces.PlayerCallback;
import sputnik.axmor.com.sputnik.core.players.models.PlayerStates;
import sputnik.axmor.com.sputnik.core.players.sdp.CustomSdpObserver;
import sputnik.axmor.com.sputnik.core.players.webrtc.UtilsKt;
import sputnik.axmor.com.sputnik.core.players.whap.IWhapManager;
import sputnik.axmor.com.sputnik.core.players.whap.WhapCallback;
import sputnik.axmor.com.sputnik.core.players.whap.WhapManager;

/* compiled from: WebRtcPlayerImplNew.kt */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001;\u0018\u00002\u00020\u0001:\u0001DB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u0016J\r\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u000e¢\u0006\u0004\b\u001c\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010 R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R$\u0010,\u001a\u0004\u0018\u00010\f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u0010\u0010R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00103R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006E"}, d2 = {"Lsputnik/axmor/com/sputnik/core/players/implementations/webrtc/WebRtcPlayerImplNew;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayerCallback;", "playerCallback", "Lorg/webrtc/SurfaceViewRenderer;", "surfaceViewRenderer", "Landroid/app/Activity;", "activity", "<init>", "(Landroidx/lifecycle/Lifecycle;Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayerCallback;Lorg/webrtc/SurfaceViewRenderer;Landroid/app/Activity;)V", "", "baseUrl", "", "initConnection", "(Ljava/lang/String;)V", "url", "play", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onResume", "(Landroidx/lifecycle/LifecycleOwner;)V", "onPause", "onStop", "onDestroy", "pause", "()V", "resume", "release", "Landroidx/lifecycle/Lifecycle;", "Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayerCallback;", "Lorg/webrtc/SurfaceViewRenderer;", "Landroid/app/Activity;", "Lokhttp3/OkHttpClient;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "setOkHttpClient", "(Lokhttp3/OkHttpClient;)V", "Lorg/webrtc/VideoTrack;", "videoTrack", "Lorg/webrtc/VideoTrack;", "lastKnownUrl", "Ljava/lang/String;", "getLastKnownUrl", "()Ljava/lang/String;", "setLastKnownUrl", "", "isDeviceSupportH264", "Z", "Lorg/webrtc/EglBase;", "rootEglBase", "Lorg/webrtc/EglBase;", "Lsputnik/axmor/com/sputnik/core/players/whap/IWhapManager;", "whapManager", "Lsputnik/axmor/com/sputnik/core/players/whap/IWhapManager;", "needToAddTrack", "sputnik/axmor/com/sputnik/core/players/implementations/webrtc/WebRtcPlayerImplNew$pcObserver$1", "pcObserver", "Lsputnik/axmor/com/sputnik/core/players/implementations/webrtc/WebRtcPlayerImplNew$pcObserver$1;", "Lorg/webrtc/PeerConnectionFactory;", "peerConnectionFactory", "Lorg/webrtc/PeerConnectionFactory;", "Lorg/webrtc/PeerConnection;", "peerConnection", "Lorg/webrtc/PeerConnection;", "NotSupportedReasons", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WebRtcPlayerImplNew implements DefaultLifecycleObserver {
    private final Activity activity;
    private boolean isDeviceSupportH264;
    private String lastKnownUrl;
    private final Lifecycle lifecycle;
    private boolean needToAddTrack;
    public OkHttpClient okHttpClient;
    private final WebRtcPlayerImplNew$pcObserver$1 pcObserver;
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

    public WebRtcPlayerImplNew(Lifecycle lifecycle, PlayerCallback playerCallback, SurfaceViewRenderer surfaceViewRenderer, Activity activity) {
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
        PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(activity.getApplicationContext()).setEnableInternalTracer(true).setInjectableLogger(new Loggable() { // from class: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImplNew$$ExternalSyntheticLambda0
            @Override // org.webrtc.Loggable
            public final void onLogMessage(String str, Logging.Severity severity, String str2) {
                WebRtcPlayerImplNew._init_$lambda$1(str, severity, str2);
            }
        }, Logging.Severity.LS_VERBOSE).createInitializationOptions());
        EglBase eglBaseCreate = EglBase.create();
        Intrinsics.checkNotNullExpressionValue(eglBaseCreate, "create(...)");
        this.rootEglBase = eglBaseCreate;
        this.whapManager = new WhapManager(new WhapCallback() { // from class: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImplNew$whapManager$1
            @Override // sputnik.axmor.com.sputnik.core.players.whap.WhapCallback
            public void onResult(String sdp) {
                Intrinsics.checkNotNullParameter(sdp, "sdp");
                String lowerCase = sdp.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (!StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "h264", false, 2, (Object) null)) {
                    this.this$0.playerCallback.onCodecNotSupported(WebRtcPlayerImplNew.NotSupportedReasons.CAMERA);
                    return;
                }
                PeerConnection peerConnection = this.this$0.peerConnection;
                if (peerConnection != null) {
                    final WebRtcPlayerImplNew webRtcPlayerImplNew = this.this$0;
                    peerConnection.setRemoteDescription(new CustomSdpObserver() { // from class: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImplNew$whapManager$1$onResult$1
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
                            webRtcPlayerImplNew.playerCallback.onStateChanged(PlayerStates.ERROR);
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
        this.pcObserver = new WebRtcPlayerImplNew$pcObserver$1(this);
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

    public final void initConnection(String baseUrl) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        this.lastKnownUrl = StringsKt.replace$default(baseUrl, "video1.ts", "whap", false, 4, (Object) null);
        EglBase eglBaseCreate = EglBase.create();
        Intrinsics.checkNotNullExpressionValue(eglBaseCreate, "create(...)");
        this.rootEglBase = eglBaseCreate;
        PeerConnectionFactory.Builder videoEncoderFactory = PeerConnectionFactory.builder().setVideoDecoderFactory(new DefaultVideoDecoderFactory(this.rootEglBase.getEglBaseContext())).setVideoEncoderFactory(new CustomVideoEncoderFactory(this.rootEglBase.getEglBaseContext(), false, true));
        PeerConnectionFactory.Options options = new PeerConnectionFactory.Options();
        options.networkIgnoreMask = 0;
        Unit unit = Unit.INSTANCE;
        PeerConnectionFactory peerConnectionFactoryCreatePeerConnectionFactory = videoEncoderFactory.setOptions(options).createPeerConnectionFactory();
        this.peerConnectionFactory = peerConnectionFactoryCreatePeerConnectionFactory;
        PeerConnection peerConnectionCreatePeerConnection = peerConnectionFactoryCreatePeerConnectionFactory != null ? peerConnectionFactoryCreatePeerConnectionFactory.createPeerConnection(CollectionsKt.emptyList(), this.pcObserver) : null;
        this.peerConnection = peerConnectionCreatePeerConnection;
        if (peerConnectionCreatePeerConnection != null) {
            peerConnectionCreatePeerConnection.addTransceiver(MediaStreamTrack.MediaType.MEDIA_TYPE_VIDEO, new RtpTransceiver.RtpTransceiverInit());
        }
        PeerConnection peerConnection = this.peerConnection;
        if (peerConnection != null) {
            peerConnection.createOffer(new CustomSdpObserver() { // from class: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImplNew.initConnection.2
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
                    String str;
                    CustomSdpObserver.DefaultImpls.onCreateSuccess(this, p0);
                    LogUtilsKt.writeLog("DD: CREATE LOCAL SUCCESS");
                    WebRtcPlayerImplNew.this.isDeviceSupportH264 = false;
                    if (p0 != null && (str = p0.description) != null) {
                        String lowerCase = str.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        if (lowerCase != null && !StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "h264", false, 2, (Object) null)) {
                            WebRtcPlayerImplNew.this.playerCallback.onCodecNotSupported(NotSupportedReasons.DEVICE);
                            return;
                        }
                    }
                    WebRtcPlayerImplNew.this.isDeviceSupportH264 = true;
                    PeerConnection peerConnection2 = WebRtcPlayerImplNew.this.peerConnection;
                    if (peerConnection2 != null) {
                        peerConnection2.setLocalDescription(new CustomSdpObserver() { // from class: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImplNew$initConnection$2$onCreateSuccess$1
                            @Override // org.webrtc.SdpObserver
                            public void onCreateFailure(String str2) {
                                CustomSdpObserver.DefaultImpls.onCreateFailure(this, str2);
                            }

                            @Override // org.webrtc.SdpObserver
                            public void onCreateSuccess(SessionDescription sessionDescription) {
                                CustomSdpObserver.DefaultImpls.onCreateSuccess(this, sessionDescription);
                            }

                            @Override // org.webrtc.SdpObserver
                            public void onSetFailure(String str2) {
                                CustomSdpObserver.DefaultImpls.onSetFailure(this, str2);
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
        LogUtilsKt.writeLog(String.valueOf(url));
        this.playerCallback.onStateChanged(PlayerStates.LOADING);
        try {
            new URL(url);
            this.lastKnownUrl = url;
            try {
                new URL(this.lastKnownUrl);
                if (url != null) {
                    this.lastKnownUrl = url;
                }
                LogUtilsKt.writeLog(String.valueOf(this.lastKnownUrl));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onResume(owner);
        resume();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onPause(owner);
        pause();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onStop(owner);
        release();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onDestroy(owner);
        LogUtilsKt.writeLog("LIFECYCLE: DESTROY");
    }

    public final void pause() {
        release();
    }

    public final void resume() {
        play(this.lastKnownUrl);
    }

    public final void release() {
        PeerConnection peerConnection = this.peerConnection;
        if (peerConnection != null) {
            peerConnection.dispose();
        }
        try {
            this.rootEglBase.releaseSurface();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.rootEglBase.release();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.peerConnection = null;
        this.surfaceViewRenderer.release();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: WebRtcPlayerImplNew.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lsputnik/axmor/com/sputnik/core/players/implementations/webrtc/WebRtcPlayerImplNew$NotSupportedReasons;", "", "(Ljava/lang/String;I)V", "DEVICE", "CAMERA", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class NotSupportedReasons {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ NotSupportedReasons[] $VALUES;
        public static final NotSupportedReasons DEVICE = new NotSupportedReasons("DEVICE", 0);
        public static final NotSupportedReasons CAMERA = new NotSupportedReasons("CAMERA", 1);

        private static final /* synthetic */ NotSupportedReasons[] $values() {
            return new NotSupportedReasons[]{DEVICE, CAMERA};
        }

        public static NotSupportedReasons valueOf(String str) {
            return (NotSupportedReasons) Enum.valueOf(NotSupportedReasons.class, str);
        }

        public static NotSupportedReasons[] values() {
            return (NotSupportedReasons[]) $VALUES.clone();
        }

        private NotSupportedReasons(String str, int i) {
        }

        static {
            NotSupportedReasons[] notSupportedReasonsArr$values = $values();
            $VALUES = notSupportedReasonsArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(notSupportedReasonsArr$values);
        }
    }
}
