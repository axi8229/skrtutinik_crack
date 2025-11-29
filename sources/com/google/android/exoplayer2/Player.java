package com.google.android.exoplayer2;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import java.util.List;

/* loaded from: classes2.dex */
public interface Player {

    public interface AudioComponent {
        void setVolume(float audioVolume);
    }

    public interface TextComponent {
        void addTextOutput(TextOutput listener);

        void removeTextOutput(TextOutput listener);
    }

    public interface VideoComponent {
        void addVideoListener(VideoListener listener);

        void clearCameraMotionListener(CameraMotionListener listener);

        void clearVideoFrameMetadataListener(VideoFrameMetadataListener listener);

        void clearVideoSurface(Surface surface);

        void clearVideoSurfaceView(SurfaceView surfaceView);

        void clearVideoTextureView(TextureView textureView);

        void removeVideoListener(VideoListener listener);

        void setCameraMotionListener(CameraMotionListener listener);

        void setVideoDecoderOutputBufferRenderer(VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer);

        void setVideoFrameMetadataListener(VideoFrameMetadataListener listener);

        void setVideoSurface(Surface surface);

        void setVideoSurfaceView(SurfaceView surfaceView);

        void setVideoTextureView(TextureView textureView);
    }

    void addListener(EventListener listener);

    Looper getApplicationLooper();

    long getContentBufferedPosition();

    long getContentPosition();

    int getCurrentAdGroupIndex();

    int getCurrentAdIndexInAdGroup();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    Timeline getCurrentTimeline();

    TrackGroupArray getCurrentTrackGroups();

    TrackSelectionArray getCurrentTrackSelections();

    int getCurrentWindowIndex();

    long getDuration();

    int getNextWindowIndex();

    boolean getPlayWhenReady();

    float getPlaybackSpeed();

    int getPlaybackState();

    int getPlaybackSuppressionReason();

    ExoPlaybackException getPlayerError();

    int getPreviousWindowIndex();

    int getRendererType(int index);

    int getRepeatMode();

    boolean getShuffleModeEnabled();

    TextComponent getTextComponent();

    long getTotalBufferedDuration();

    VideoComponent getVideoComponent();

    boolean hasNext();

    boolean hasPrevious();

    boolean isCurrentWindowSeekable();

    boolean isPlaying();

    boolean isPlayingAd();

    void removeListener(EventListener listener);

    void seekTo(int windowIndex, long positionMs);

    void setMediaItems(List<MediaItem> mediaItems, int startWindowIndex, long startPositionMs);

    void setPlayWhenReady(boolean playWhenReady);

    void setRepeatMode(int repeatMode);

    void setShuffleModeEnabled(boolean shuffleModeEnabled);

    void stop(boolean reset);

    public interface EventListener {
        default void onIsPlayingChanged(boolean isPlaying) {
        }

        @Deprecated
        default void onLoadingChanged(boolean isLoading) {
        }

        default void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {
        }

        @Deprecated
        default void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        }

        default void onPlaybackSpeedChanged(float playbackSpeed) {
        }

        default void onPlaybackStateChanged(int state) {
        }

        default void onPlaybackSuppressionReasonChanged(int playbackSuppressionReason) {
        }

        default void onPlayerError(ExoPlaybackException error) {
        }

        @Deprecated
        default void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
        }

        default void onPositionDiscontinuity(int reason) {
        }

        default void onRepeatModeChanged(int repeatMode) {
        }

        default void onSeekProcessed() {
        }

        default void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
        }

        @Deprecated
        default void onTimelineChanged(Timeline timeline, Object manifest, int reason) {
        }

        default void onTrackSelected(TrackSelectorResult trackSelectorResult) {
        }

        default void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
        }

        default void onTimelineChanged(Timeline timeline, int reason) {
            onTimelineChanged(timeline, timeline.getWindowCount() == 1 ? timeline.getWindow(0, new Timeline.Window()).manifest : null, reason);
        }

        default void onIsLoadingChanged(boolean isLoading) {
            onLoadingChanged(isLoading);
        }
    }
}
