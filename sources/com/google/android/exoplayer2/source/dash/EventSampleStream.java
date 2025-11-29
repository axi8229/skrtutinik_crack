package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

/* loaded from: classes2.dex */
final class EventSampleStream implements SampleStream {
    private int currentIndex;
    private EventStream eventStream;
    private boolean eventStreamAppendable;
    private long[] eventTimesUs;
    private boolean isFormatSentDownstream;
    private final Format upstreamFormat;
    private final EventMessageEncoder eventMessageEncoder = new EventMessageEncoder();
    private long pendingSeekPositionUs = -9223372036854775807L;

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() {
    }

    public EventSampleStream(EventStream eventStream, Format upstreamFormat, boolean eventStreamAppendable) {
        this.upstreamFormat = upstreamFormat;
        this.eventStream = eventStream;
        this.eventTimesUs = eventStream.presentationTimesUs;
        updateEventStream(eventStream, eventStreamAppendable);
    }

    public String eventStreamId() {
        return this.eventStream.id();
    }

    public void updateEventStream(EventStream eventStream, boolean eventStreamAppendable) {
        int i = this.currentIndex;
        long j = i == 0 ? -9223372036854775807L : this.eventTimesUs[i - 1];
        this.eventStreamAppendable = eventStreamAppendable;
        this.eventStream = eventStream;
        long[] jArr = eventStream.presentationTimesUs;
        this.eventTimesUs = jArr;
        long j2 = this.pendingSeekPositionUs;
        if (j2 != -9223372036854775807L) {
            seekToUs(j2);
        } else if (j != -9223372036854775807L) {
            this.currentIndex = Util.binarySearchCeil(jArr, j, false, false);
        }
    }

    public void seekToUs(long positionUs) {
        int iBinarySearchCeil = Util.binarySearchCeil(this.eventTimesUs, positionUs, true, false);
        this.currentIndex = iBinarySearchCeil;
        if (!this.eventStreamAppendable || iBinarySearchCeil != this.eventTimesUs.length) {
            positionUs = -9223372036854775807L;
        }
        this.pendingSeekPositionUs = positionUs;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(FormatHolder formatHolder, DecoderInputBuffer buffer, boolean formatRequired) throws IOException {
        if (formatRequired || !this.isFormatSentDownstream) {
            formatHolder.format = this.upstreamFormat;
            this.isFormatSentDownstream = true;
            return -5;
        }
        int i = this.currentIndex;
        if (i == this.eventTimesUs.length) {
            if (this.eventStreamAppendable) {
                return -3;
            }
            buffer.setFlags(4);
            return -4;
        }
        this.currentIndex = i + 1;
        byte[] bArrEncode = this.eventMessageEncoder.encode(this.eventStream.events[i]);
        if (bArrEncode == null) {
            return -3;
        }
        buffer.ensureSpaceForWrite(bArrEncode.length);
        buffer.data.put(bArrEncode);
        buffer.timeUs = this.eventTimesUs[i];
        buffer.setFlags(1);
        return -4;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long positionUs) {
        int iMax = Math.max(this.currentIndex, Util.binarySearchCeil(this.eventTimesUs, positionUs, true, false));
        int i = iMax - this.currentIndex;
        this.currentIndex = iMax;
        return i;
    }
}
