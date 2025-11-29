package com.google.android.exoplayer2;

import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.MediaClock;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface Renderer extends PlayerMessage.Target {
    void disable();

    void enable(RendererConfiguration configuration, Format[] formats, SampleStream stream, long positionUs, boolean joining, boolean mayRenderStartOfStream, long offsetUs) throws ExoPlaybackException;

    RendererCapabilities getCapabilities();

    MediaClock getMediaClock();

    String getName();

    long getReadingPositionUs();

    int getState();

    SampleStream getStream();

    int getTrackType();

    boolean hasReadStreamToEnd();

    boolean isCurrentStreamFinal();

    boolean isEnded();

    boolean isReady();

    void maybeThrowStreamError() throws IOException;

    void render(long positionUs, long elapsedRealtimeUs) throws ExoPlaybackException;

    void replaceStream(Format[] formats, SampleStream stream, long offsetUs) throws ExoPlaybackException;

    void reset();

    void resetPosition(long positionUs) throws ExoPlaybackException;

    void setCurrentStreamFinal();

    void setIndex(int index);

    default void setOperatingRate(float operatingRate) throws ExoPlaybackException {
    }

    void start() throws ExoPlaybackException;

    void stop() throws ExoPlaybackException;
}
