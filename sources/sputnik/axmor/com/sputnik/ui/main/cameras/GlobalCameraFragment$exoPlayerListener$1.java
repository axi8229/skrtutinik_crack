package sputnik.axmor.com.sputnik.ui.main.cameras;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Player;
import com.shopgun.android.zoomlayout.ZoomLayout;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.data.entities.cameras.CameraPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.SputnikApp;

/* compiled from: GlobalCameraFragment.kt */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"sputnik/axmor/com/sputnik/ui/main/cameras/GlobalCameraFragment$exoPlayerListener$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onIsPlayingChanged", "", "isPlaying", "", "onPlaybackStateChanged", "state", "", "onPlayerError", "error", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalCameraFragment$exoPlayerListener$1 implements Player.EventListener {
    final /* synthetic */ GlobalCameraFragment this$0;

    GlobalCameraFragment$exoPlayerListener$1(GlobalCameraFragment globalCameraFragment) {
        this.this$0 = globalCameraFragment;
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onIsPlayingChanged(boolean isPlaying) {
        if (this.this$0.getView() != null) {
            final GlobalCameraFragment globalCameraFragment = this.this$0;
            ImageView preview = globalCameraFragment.getBinding().preview;
            Intrinsics.checkNotNullExpressionValue(preview, "preview");
            ViewBindingUtilsKt.visibilityBasedOn(preview, Boolean.valueOf(!isPlaying));
            if (isPlaying) {
                int i = globalCameraFragment.getResources().getConfiguration().orientation;
                View view = globalCameraFragment.getView();
                if (view != null) {
                    view.post(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment$exoPlayerListener$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            GlobalCameraFragment$exoPlayerListener$1.onIsPlayingChanged$lambda$3$lambda$2(globalCameraFragment);
                        }
                    });
                }
                globalCameraFragment.getCamera().setLoadVideoFailed(false);
                globalCameraFragment.getCameraViewModel().handleLoading(false);
                SputnikApp.INSTANCE.getAnalyticsService().send("myCameras", "play_video", "loaded");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onIsPlayingChanged$lambda$3$lambda$2(GlobalCameraFragment this$0) {
        CameraPreferences cameraPreferencesByCameraUuid;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getView() == null || (cameraPreferencesByCameraUuid = this$0.getSettingsViewModel().getCameraPreferencesByCameraUuid(this$0.getCamera().getUuid())) == null) {
            return;
        }
        ZoomLayout zoomLayout = this$0.getBinding().layoutZoom;
        if (zoomLayout != null) {
            zoomLayout.setScale(cameraPreferencesByCameraUuid.getScale(), false);
        }
        ZoomLayout zoomLayout2 = this$0.getBinding().layoutZoom2;
        if (zoomLayout2 != null) {
            zoomLayout2.setScale(cameraPreferencesByCameraUuid.getScale(), false);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlaybackStateChanged(int state) {
        super.onPlaybackStateChanged(state);
        if (state != 3) {
            return;
        }
        LinearLayout videoLoader = this.this$0.getBinding().videoLoader;
        Intrinsics.checkNotNullExpressionValue(videoLoader, "videoLoader");
        ViewKt.gone(videoLoader);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerError(ExoPlaybackException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Log.e("error", error.toString());
        this.this$0.getCamera().setLoadVideoFailed(true);
        LogUtilsKt.writeLog("DD: error " + error);
        if (this.this$0.getCamera().getIsLoadPhotoFailed()) {
            this.this$0.showErrorLoadCamera();
        } else if (this.this$0.getView() != null) {
            ImageView preview = this.this$0.getBinding().preview;
            Intrinsics.checkNotNullExpressionValue(preview, "preview");
            ViewKt.visible(preview);
        }
    }
}
