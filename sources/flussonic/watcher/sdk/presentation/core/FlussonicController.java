package flussonic.watcher.sdk.presentation.core;

import androidx.lifecycle.LifecycleObserver;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ParserException;

/* loaded from: classes3.dex */
public interface FlussonicController extends FlussonicWatcher, LifecycleObserver {
    void doPauseOrResume();

    long getStartPosition();

    static boolean isStoppedBeforePreparingCompleted(ExoPlaybackException exoPlaybackException) {
        for (ExoPlaybackException cause = exoPlaybackException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof ParserException) && ((ParserException) cause).getLocalizedMessage().contains("Loading finished before preparation is complete")) {
                return true;
            }
        }
        return false;
    }
}
