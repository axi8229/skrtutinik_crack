package flussonic.watcher.sdk.presentation.player.exo;

import android.view.GestureDetector;
import android.view.MotionEvent;
import flussonic.watcher.sdk.presentation.core.FlussonicPlayer;

/* loaded from: classes3.dex */
public class OnTapConfirmedGestureListener extends GestureDetector.SimpleOnGestureListener {
    private FlussonicPlayer.PlayerListener playerListener;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent e) {
        FlussonicPlayer.PlayerListener playerListener = this.playerListener;
        if (playerListener != null) {
            playerListener.onTapConfirmed();
            return true;
        }
        return super.onSingleTapConfirmed(e);
    }

    public void setPlayerListener(FlussonicPlayer.PlayerListener playerListener) {
        this.playerListener = playerListener;
    }
}
