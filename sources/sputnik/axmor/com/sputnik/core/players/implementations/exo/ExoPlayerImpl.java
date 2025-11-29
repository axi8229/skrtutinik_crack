package sputnik.axmor.com.sputnik.core.players.implementations.exo;

import android.app.Activity;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.core.players.interfaces.PlayerCallback;
import sputnik.axmor.com.sputnik.core.players.models.PlayerStates;

/* compiled from: ExoPlayerImpl.kt */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004*\u0001&\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u0010R$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lsputnik/axmor/com/sputnik/core/players/implementations/exo/ExoPlayerImpl;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayerCallback;", "playerCallback", "Lcom/google/android/exoplayer2/ui/PlayerView;", "playerView", "Landroid/app/Activity;", "activity", "<init>", "(Landroidx/lifecycle/Lifecycle;Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayerCallback;Lcom/google/android/exoplayer2/ui/PlayerView;Landroid/app/Activity;)V", "", "url", "", "play", "(Ljava/lang/String;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onResume", "(Landroidx/lifecycle/LifecycleOwner;)V", "onPause", "onStop", "Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayerCallback;", "Lcom/google/android/exoplayer2/ui/PlayerView;", "Landroid/app/Activity;", "lastKnownUrl", "Ljava/lang/String;", "getLastKnownUrl", "()Ljava/lang/String;", "setLastKnownUrl", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "sputnik/axmor/com/sputnik/core/players/implementations/exo/ExoPlayerImpl$exoPlayerListener$1", "exoPlayerListener", "Lsputnik/axmor/com/sputnik/core/players/implementations/exo/ExoPlayerImpl$exoPlayerListener$1;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExoPlayerImpl implements DefaultLifecycleObserver {
    private final Activity activity;
    private final ExoPlayerImpl$exoPlayerListener$1 exoPlayerListener;
    private String lastKnownUrl;
    private SimpleExoPlayer player;
    private final PlayerCallback playerCallback;
    private final PlayerView playerView;

    /* JADX WARN: Type inference failed for: r2v1, types: [sputnik.axmor.com.sputnik.core.players.implementations.exo.ExoPlayerImpl$exoPlayerListener$1] */
    public ExoPlayerImpl(Lifecycle lifecycle, PlayerCallback playerCallback, PlayerView playerView, Activity activity) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(playerCallback, "playerCallback");
        Intrinsics.checkNotNullParameter(playerView, "playerView");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.playerCallback = playerCallback;
        this.playerView = playerView;
        this.activity = activity;
        lifecycle.addObserver(this);
        this.exoPlayerListener = new Player.EventListener() { // from class: sputnik.axmor.com.sputnik.core.players.implementations.exo.ExoPlayerImpl$exoPlayerListener$1
            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPlaybackStateChanged(int state) {
                super.onPlaybackStateChanged(state);
                if (state != 3) {
                    return;
                }
                this.this$0.playerCallback.onStateChanged(PlayerStates.LOADED);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPlayerError(ExoPlaybackException error) {
                Intrinsics.checkNotNullParameter(error, "error");
                super.onPlayerError(error);
                this.this$0.playerCallback.onStateChanged(PlayerStates.ERROR);
            }
        };
    }

    public final void play(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            new URL(url);
            this.lastKnownUrl = url;
            this.playerCallback.onStateChanged(PlayerStates.LOADING);
            try {
                SimpleExoPlayer simpleExoPlayer = this.player;
                if (simpleExoPlayer != null) {
                    simpleExoPlayer.release();
                }
                this.player = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
            SimpleExoPlayer simpleExoPlayerBuild = new SimpleExoPlayer.Builder(this.activity).build();
            Player.AudioComponent audioComponent = simpleExoPlayerBuild.getAudioComponent();
            if (audioComponent != null) {
                audioComponent.setVolume(1.0f);
            }
            simpleExoPlayerBuild.setPlayWhenReady(true);
            simpleExoPlayerBuild.addListener(this.exoPlayerListener);
            this.player = simpleExoPlayerBuild;
            final MediaItem mediaItemFromUri = MediaItem.fromUri(Uri.parse(url));
            Intrinsics.checkNotNullExpressionValue(mediaItemFromUri, "fromUri(...)");
            final SimpleExoPlayer simpleExoPlayer2 = this.player;
            if (simpleExoPlayer2 != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: sputnik.axmor.com.sputnik.core.players.implementations.exo.ExoPlayerImpl$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ExoPlayerImpl.play$lambda$4$lambda$3$lambda$2(simpleExoPlayer2, mediaItemFromUri);
                    }
                });
            }
            this.playerView.setPlayer(this.player);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void play$lambda$4$lambda$3$lambda$2(SimpleExoPlayer this_with, MediaItem mediaItem) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(mediaItem, "$mediaItem");
        if (this_with.isPlaying()) {
            return;
        }
        this_with.setPlayWhenReady(true);
        this_with.setMediaItem(mediaItem);
        this_with.prepare();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onResume(owner);
        String str = this.lastKnownUrl;
        if (str != null) {
            play(String.valueOf(str));
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onPause(owner);
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.removeListener(this.exoPlayerListener);
        }
        SimpleExoPlayer simpleExoPlayer2 = this.player;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.pause();
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onStop(owner);
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop();
        }
    }
}
