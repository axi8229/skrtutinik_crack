package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BasePlayer implements Player {
    protected final Timeline.Window window = new Timeline.Window();

    protected interface ListenerInvocation {
        void invokeListener(Player.EventListener listener);
    }

    public void setMediaItem(MediaItem mediaItem) {
        setMediaItems(Collections.singletonList(mediaItem));
    }

    public void setMediaItems(List<MediaItem> mediaItems, boolean resetPosition) {
        setMediaItems(mediaItems, -1, -9223372036854775807L);
    }

    public void setMediaItems(List<MediaItem> mediaItems) {
        setMediaItems(mediaItems, true);
    }

    public final void pause() {
        setPlayWhenReady(false);
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isPlaying() {
        return getPlaybackState() == 3 && getPlayWhenReady() && getPlaybackSuppressionReason() == 0;
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean hasPrevious() {
        return getPreviousWindowIndex() != -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean hasNext() {
        return getNextWindowIndex() != -1;
    }

    public final void stop() {
        stop(false);
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getNextWindowIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getNextWindowIndex(getCurrentWindowIndex(), getRepeatModeForNavigation(), getShuffleModeEnabled());
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getPreviousWindowIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getPreviousWindowIndex(getCurrentWindowIndex(), getRepeatModeForNavigation(), getShuffleModeEnabled());
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isCurrentWindowSeekable() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).isSeekable;
    }

    public final long getContentDuration() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -9223372036854775807L;
        }
        return currentTimeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
    }

    private int getRepeatModeForNavigation() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    protected static final class ListenerHolder {
        public final Player.EventListener listener;
        private boolean released;

        public ListenerHolder(Player.EventListener listener) {
            this.listener = listener;
        }

        public void release() {
            this.released = true;
        }

        public void invoke(ListenerInvocation listenerInvocation) {
            if (this.released) {
                return;
            }
            listenerInvocation.invokeListener(this.listener);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || ListenerHolder.class != other.getClass()) {
                return false;
            }
            return this.listener.equals(((ListenerHolder) other).listener);
        }

        public int hashCode() {
            return this.listener.hashCode();
        }
    }
}
