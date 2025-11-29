package sputnik.axmor.com.sputnik.core.players.manager;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.google.android.exoplayer2.ui.PlayerView;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.VideoEvents;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.utils.LogUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.webrtc.SurfaceViewRenderer;
import sputnik.axmor.com.sputnik.core.players.implementations.exo.ExoPlayerImpl;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.WebRtcPlayerImplNew;
import sputnik.axmor.com.sputnik.core.players.interfaces.PlayerCallback;
import sputnik.axmor.com.sputnik.core.players.interfaces.PlayersCallback;
import sputnik.axmor.com.sputnik.core.players.manager.PlayersManager;
import sputnik.axmor.com.sputnik.core.players.models.PlayerStates;

/* compiled from: PlayersManager.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J[\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lsputnik/axmor/com/sputnik/core/players/manager/PlayersManager;", "", "<init>", "()V", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "", "url", "Lcom/google/android/exoplayer2/ui/PlayerView;", "exoView", "Lorg/webrtc/SurfaceViewRenderer;", "webrtcView", "Landroid/view/View;", "loaderView", "Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayersCallback;", "playersCallback", "Landroid/app/Activity;", "activity", "", "playExo", "(Landroidx/lifecycle/Lifecycle;Ljava/lang/String;Lcom/google/android/exoplayer2/ui/PlayerView;Lorg/webrtc/SurfaceViewRenderer;Landroid/view/View;Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayersCallback;Landroid/app/Activity;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "", "isWebrtcEnabled", "play", "(Ljava/lang/String;Landroidx/lifecycle/Lifecycle;Landroid/app/Activity;Lcom/google/android/exoplayer2/ui/PlayerView;Lorg/webrtc/SurfaceViewRenderer;Landroid/view/View;Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayersCallback;Lcom/sputnik/common/analytics/Analytics;Z)V", "isDeviceSupportH264", "Z", "Lsputnik/axmor/com/sputnik/core/players/implementations/webrtc/WebRtcPlayerImplNew;", "webrtcPlayer", "Lsputnik/axmor/com/sputnik/core/players/implementations/webrtc/WebRtcPlayerImplNew;", "Lsputnik/axmor/com/sputnik/core/players/implementations/exo/ExoPlayerImpl;", "exoPlayer", "Lsputnik/axmor/com/sputnik/core/players/implementations/exo/ExoPlayerImpl;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PlayersManager {
    private ExoPlayerImpl exoPlayer;
    private boolean isDeviceSupportH264 = true;
    private WebRtcPlayerImplNew webrtcPlayer;

    public final void play(final String url, final Lifecycle lifecycle, final Activity activity, final PlayerView exoView, final SurfaceViewRenderer webrtcView, final View loaderView, final PlayersCallback playersCallback, Analytics analytics, boolean isWebrtcEnabled) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(webrtcView, "webrtcView");
        Intrinsics.checkNotNullParameter(loaderView, "loaderView");
        Intrinsics.checkNotNullParameter(playersCallback, "playersCallback");
        if (!isWebrtcEnabled) {
            activity.runOnUiThread(new Runnable() { // from class: sputnik.axmor.com.sputnik.core.players.manager.PlayersManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PlayersManager.play$lambda$0(this.f$0, lifecycle, url, exoView, webrtcView, loaderView, playersCallback, activity);
                }
            });
            return;
        }
        WebRtcPlayerImplNew webRtcPlayerImplNew = new WebRtcPlayerImplNew(lifecycle, new AnonymousClass2(activity, playersCallback, loaderView, analytics, this, lifecycle, url, exoView, webrtcView), webrtcView, activity);
        this.webrtcPlayer = webRtcPlayerImplNew;
        if (this.isDeviceSupportH264) {
            webRtcPlayerImplNew.initConnection(url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void play$lambda$0(PlayersManager this$0, Lifecycle lifecycle, String url, PlayerView playerView, SurfaceViewRenderer webrtcView, View loaderView, PlayersCallback playersCallback, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lifecycle, "$lifecycle");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(webrtcView, "$webrtcView");
        Intrinsics.checkNotNullParameter(loaderView, "$loaderView");
        Intrinsics.checkNotNullParameter(playersCallback, "$playersCallback");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        this$0.playExo(lifecycle, url, playerView, webrtcView, loaderView, playersCallback, activity);
    }

    /* compiled from: PlayersManager.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"sputnik/axmor/com/sputnik/core/players/manager/PlayersManager$play$2", "Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayerCallback;", "Lsputnik/axmor/com/sputnik/core/players/models/PlayerStates;", "state", "", "onStateChanged", "(Lsputnik/axmor/com/sputnik/core/players/models/PlayerStates;)V", "Lsputnik/axmor/com/sputnik/core/players/implementations/webrtc/WebRtcPlayerImplNew$NotSupportedReasons;", "where", "onCodecNotSupported", "(Lsputnik/axmor/com/sputnik/core/players/implementations/webrtc/WebRtcPlayerImplNew$NotSupportedReasons;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.core.players.manager.PlayersManager$play$2, reason: invalid class name */
    public static final class AnonymousClass2 implements PlayerCallback {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Analytics $analytics;
        final /* synthetic */ PlayerView $exoView;
        final /* synthetic */ Lifecycle $lifecycle;
        final /* synthetic */ View $loaderView;
        final /* synthetic */ PlayersCallback $playersCallback;
        final /* synthetic */ String $url;
        final /* synthetic */ SurfaceViewRenderer $webrtcView;
        final /* synthetic */ PlayersManager this$0;

        /* compiled from: PlayersManager.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* renamed from: sputnik.axmor.com.sputnik.core.players.manager.PlayersManager$play$2$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[PlayerStates.values().length];
                try {
                    iArr[PlayerStates.LOADING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PlayerStates.LOADED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[WebRtcPlayerImplNew.NotSupportedReasons.values().length];
                try {
                    iArr2[WebRtcPlayerImplNew.NotSupportedReasons.DEVICE.ordinal()] = 1;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr2[WebRtcPlayerImplNew.NotSupportedReasons.CAMERA.ordinal()] = 2;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        AnonymousClass2(Activity activity, PlayersCallback playersCallback, View view, Analytics analytics, PlayersManager playersManager, Lifecycle lifecycle, String str, PlayerView playerView, SurfaceViewRenderer surfaceViewRenderer) {
            this.$activity = activity;
            this.$playersCallback = playersCallback;
            this.$loaderView = view;
            this.$analytics = analytics;
            this.this$0 = playersManager;
            this.$lifecycle = lifecycle;
            this.$url = str;
            this.$exoView = playerView;
            this.$webrtcView = surfaceViewRenderer;
        }

        @Override // sputnik.axmor.com.sputnik.core.players.interfaces.PlayerCallback
        public void onStateChanged(final PlayerStates state) {
            Intrinsics.checkNotNullParameter(state, "state");
            LogUtilsKt.writeLog("WEBRTC STATE " + state);
            Activity activity = this.$activity;
            final View view = this.$loaderView;
            activity.runOnUiThread(new Runnable() { // from class: sputnik.axmor.com.sputnik.core.players.manager.PlayersManager$play$2$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    PlayersManager.AnonymousClass2.onStateChanged$lambda$0(state, view);
                }
            });
            this.$playersCallback.onStateChanged(state, PlayersCallback.Players.WEBRTC);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onStateChanged$lambda$0(PlayerStates state, View loaderView) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(loaderView, "$loaderView");
            int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i == 1) {
                ViewKt.visible(loaderView);
            } else {
                if (i != 2) {
                    return;
                }
                ViewKt.gone(loaderView);
            }
        }

        @Override // sputnik.axmor.com.sputnik.core.players.interfaces.PlayerCallback
        public void onCodecNotSupported(WebRtcPlayerImplNew.NotSupportedReasons where) {
            Analytics analytics;
            Intrinsics.checkNotNullParameter(where, "where");
            LogUtilsKt.writeLog("WEBRTC CODEC " + where);
            int i = WhenMappings.$EnumSwitchMapping$1[where.ordinal()];
            if (i == 1) {
                Analytics analytics2 = this.$analytics;
                if (analytics2 != null) {
                    analytics2.trackLogEvent(new VideoEvents.PhoneNoSupport264());
                }
            } else if (i == 2 && (analytics = this.$analytics) != null) {
                analytics.trackLogEvent(new VideoEvents.CameraNoSupport264());
            }
            this.this$0.isDeviceSupportH264 = false;
            final Activity activity = this.$activity;
            final PlayersManager playersManager = this.this$0;
            final Lifecycle lifecycle = this.$lifecycle;
            final String str = this.$url;
            final PlayerView playerView = this.$exoView;
            final SurfaceViewRenderer surfaceViewRenderer = this.$webrtcView;
            final View view = this.$loaderView;
            final PlayersCallback playersCallback = this.$playersCallback;
            activity.runOnUiThread(new Runnable() { // from class: sputnik.axmor.com.sputnik.core.players.manager.PlayersManager$play$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PlayersManager.AnonymousClass2.onCodecNotSupported$lambda$1(playersManager, lifecycle, str, playerView, surfaceViewRenderer, view, playersCallback, activity);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCodecNotSupported$lambda$1(PlayersManager this$0, Lifecycle lifecycle, String url, PlayerView playerView, SurfaceViewRenderer webrtcView, View loaderView, PlayersCallback playersCallback, Activity activity) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(lifecycle, "$lifecycle");
            Intrinsics.checkNotNullParameter(url, "$url");
            Intrinsics.checkNotNullParameter(webrtcView, "$webrtcView");
            Intrinsics.checkNotNullParameter(loaderView, "$loaderView");
            Intrinsics.checkNotNullParameter(playersCallback, "$playersCallback");
            Intrinsics.checkNotNullParameter(activity, "$activity");
            this$0.playExo(lifecycle, url, playerView, webrtcView, loaderView, playersCallback, activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playExo(Lifecycle lifecycle, String url, PlayerView exoView, SurfaceViewRenderer webrtcView, View loaderView, PlayersCallback playersCallback, Activity activity) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(activity, playersCallback, loaderView);
        Intrinsics.checkNotNull(exoView);
        ExoPlayerImpl exoPlayerImpl = new ExoPlayerImpl(lifecycle, anonymousClass1, exoView, activity);
        this.exoPlayer = exoPlayerImpl;
        exoPlayerImpl.play(url);
    }

    /* compiled from: PlayersManager.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"sputnik/axmor/com/sputnik/core/players/manager/PlayersManager$playExo$1", "Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayerCallback;", "onStateChanged", "", "state", "Lsputnik/axmor/com/sputnik/core/players/models/PlayerStates;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.core.players.manager.PlayersManager$playExo$1, reason: invalid class name */
    public static final class AnonymousClass1 implements PlayerCallback {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ View $loaderView;
        final /* synthetic */ PlayersCallback $playersCallback;

        /* compiled from: PlayersManager.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* renamed from: sputnik.axmor.com.sputnik.core.players.manager.PlayersManager$playExo$1$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PlayerStates.values().length];
                try {
                    iArr[PlayerStates.LOADING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PlayerStates.LOADED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        AnonymousClass1(Activity activity, PlayersCallback playersCallback, View view) {
            this.$activity = activity;
            this.$playersCallback = playersCallback;
            this.$loaderView = view;
        }

        @Override // sputnik.axmor.com.sputnik.core.players.interfaces.PlayerCallback
        public void onCodecNotSupported(WebRtcPlayerImplNew.NotSupportedReasons notSupportedReasons) {
            PlayerCallback.DefaultImpls.onCodecNotSupported(this, notSupportedReasons);
        }

        @Override // sputnik.axmor.com.sputnik.core.players.interfaces.PlayerCallback
        public void onStateChanged(final PlayerStates state) {
            Intrinsics.checkNotNullParameter(state, "state");
            Activity activity = this.$activity;
            final View view = this.$loaderView;
            activity.runOnUiThread(new Runnable() { // from class: sputnik.axmor.com.sputnik.core.players.manager.PlayersManager$playExo$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PlayersManager.AnonymousClass1.onStateChanged$lambda$0(state, view);
                }
            });
            this.$playersCallback.onStateChanged(state, PlayersCallback.Players.EXO);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onStateChanged$lambda$0(PlayerStates state, View loaderView) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(loaderView, "$loaderView");
            int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i == 1) {
                ViewKt.visible(loaderView);
            } else {
                if (i != 2) {
                    return;
                }
                ViewKt.gone(loaderView);
            }
        }
    }
}
