package com.google.android.exoplayer2;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class BaseRenderer implements Renderer, RendererCapabilities {
    private RendererConfiguration configuration;
    private int index;
    private int state;
    private SampleStream stream;
    private Format[] streamFormats;
    private boolean streamIsFinal;
    private long streamOffsetUs;
    private boolean throwRendererExceptionIsExecuting;
    private final int trackType;
    private final FormatHolder formatHolder = new FormatHolder();
    private long readingPositionUs = Long.MIN_VALUE;

    @Override // com.google.android.exoplayer2.Renderer
    public final RendererCapabilities getCapabilities() {
        return this;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public MediaClock getMediaClock() {
        return null;
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int what, Object object) throws ExoPlaybackException {
    }

    protected abstract void onDisabled();

    protected void onEnabled(boolean joining, boolean mayRenderStartOfStream) throws ExoPlaybackException {
    }

    protected abstract void onPositionReset(long positionUs, boolean joining) throws ExoPlaybackException;

    protected void onReset() {
    }

    protected void onStarted() {
    }

    protected void onStopped() throws ExoPlaybackException {
    }

    protected void onStreamChanged(Format[] formats, long offsetUs) throws ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 0;
    }

    public BaseRenderer(int trackType) {
        this.trackType = trackType;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public final int getTrackType() {
        return this.trackType;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setIndex(int index) {
        this.index = index;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void enable(RendererConfiguration configuration, Format[] formats, SampleStream stream, long positionUs, boolean joining, boolean mayRenderStartOfStream, long offsetUs) throws ExoPlaybackException {
        Assertions.checkState(this.state == 0);
        this.configuration = configuration;
        this.state = 1;
        onEnabled(joining, mayRenderStartOfStream);
        replaceStream(formats, stream, offsetUs);
        onPositionReset(positionUs, joining);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void start() {
        Assertions.checkState(this.state == 1);
        this.state = 2;
        onStarted();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void replaceStream(Format[] formats, SampleStream stream, long offsetUs) throws ExoPlaybackException {
        Assertions.checkState(!this.streamIsFinal);
        this.stream = stream;
        this.readingPositionUs = offsetUs;
        this.streamFormats = formats;
        this.streamOffsetUs = offsetUs;
        onStreamChanged(formats, offsetUs);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final SampleStream getStream() {
        return this.stream;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean hasReadStreamToEnd() {
        return this.readingPositionUs == Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final long getReadingPositionUs() {
        return this.readingPositionUs;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setCurrentStreamFinal() {
        this.streamIsFinal = true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean isCurrentStreamFinal() {
        return this.streamIsFinal;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void maybeThrowStreamError() throws IOException {
        this.stream.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void resetPosition(long positionUs) throws ExoPlaybackException {
        this.streamIsFinal = false;
        this.readingPositionUs = positionUs;
        onPositionReset(positionUs, false);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void stop() throws ExoPlaybackException {
        Assertions.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void disable() {
        Assertions.checkState(this.state == 1);
        this.formatHolder.clear();
        this.state = 0;
        this.stream = null;
        this.streamFormats = null;
        this.streamIsFinal = false;
        onDisabled();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void reset() {
        Assertions.checkState(this.state == 0);
        this.formatHolder.clear();
        onReset();
    }

    protected final FormatHolder getFormatHolder() {
        this.formatHolder.clear();
        return this.formatHolder;
    }

    protected final Format[] getStreamFormats() {
        return this.streamFormats;
    }

    protected final RendererConfiguration getConfiguration() {
        return this.configuration;
    }

    protected final int getIndex() {
        return this.index;
    }

    protected final ExoPlaybackException createRendererException(Exception cause, Format format) {
        int formatSupport;
        if (format == null || this.throwRendererExceptionIsExecuting) {
            formatSupport = 4;
        } else {
            this.throwRendererExceptionIsExecuting = true;
            try {
                formatSupport = RendererCapabilities.getFormatSupport(supportsFormat(format));
            } catch (ExoPlaybackException unused) {
            } finally {
                this.throwRendererExceptionIsExecuting = false;
            }
        }
        return ExoPlaybackException.createForRenderer(cause, getName(), getIndex(), format, formatSupport);
    }

    protected final int readSource(FormatHolder formatHolder, DecoderInputBuffer buffer, boolean formatRequired) {
        int data = this.stream.readData(formatHolder, buffer, formatRequired);
        if (data == -4) {
            if (buffer.isEndOfStream()) {
                this.readingPositionUs = Long.MIN_VALUE;
                return this.streamIsFinal ? -4 : -3;
            }
            long j = buffer.timeUs + this.streamOffsetUs;
            buffer.timeUs = j;
            this.readingPositionUs = Math.max(this.readingPositionUs, j);
        } else if (data == -5) {
            Format format = formatHolder.format;
            if (format.subsampleOffsetUs != Long.MAX_VALUE) {
                formatHolder.format = format.buildUpon().setSubsampleOffsetUs(format.subsampleOffsetUs + this.streamOffsetUs).build();
            }
        }
        return data;
    }

    protected int skipSource(long positionUs) {
        return this.stream.skipData(positionUs - this.streamOffsetUs);
    }

    protected final boolean isSourceReady() {
        return hasReadStreamToEnd() ? this.streamIsFinal : this.stream.isReady();
    }
}
