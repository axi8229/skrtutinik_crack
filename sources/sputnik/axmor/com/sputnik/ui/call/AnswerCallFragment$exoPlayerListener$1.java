package sputnik.axmor.com.sputnik.ui.call;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Player;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.SputnikApp;

/* compiled from: AnswerCallFragment.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"sputnik/axmor/com/sputnik/ui/call/AnswerCallFragment$exoPlayerListener$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onIsPlayingChanged", "", "isPlaying", "", "onPlayerError", "error", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnswerCallFragment$exoPlayerListener$1 implements Player.EventListener {
    final /* synthetic */ AnswerCallFragment this$0;

    AnswerCallFragment$exoPlayerListener$1(AnswerCallFragment answerCallFragment) {
        this.this$0 = answerCallFragment;
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onIsPlayingChanged(boolean isPlaying) {
        if (this.this$0.getView() != null) {
            final AnswerCallFragment answerCallFragment = this.this$0;
            if (isPlaying) {
                SputnikApp.INSTANCE.getAnalyticsService().send("myCameras", "play_video", "loaded");
                int i = answerCallFragment.getResources().getConfiguration().orientation;
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.call.AnswerCallFragment$exoPlayerListener$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnswerCallFragment$exoPlayerListener$1.onIsPlayingChanged$lambda$2$lambda$1(answerCallFragment);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onIsPlayingChanged$lambda$2$lambda$1(AnswerCallFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getView();
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerError(ExoPlaybackException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Log.e("errorCall", error.toString());
    }
}
