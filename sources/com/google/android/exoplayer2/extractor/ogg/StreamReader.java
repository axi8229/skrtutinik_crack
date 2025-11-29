package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* loaded from: classes2.dex */
abstract class StreamReader {
    private long currentGranule;
    private ExtractorOutput extractorOutput;
    private boolean formatSet;
    private long lengthOfReadPacket;
    private final OggPacket oggPacket = new OggPacket();
    private OggSeeker oggSeeker;
    private long payloadStartPosition;
    private int sampleRate;
    private boolean seekMapSet;
    private SetupData setupData;
    private int state;
    private long targetGranule;
    private TrackOutput trackOutput;

    protected abstract long preparePayload(ParsableByteArray packet);

    protected abstract boolean readHeaders(ParsableByteArray packet, long position, SetupData setupData) throws IOException;

    static class SetupData {
        Format format;
        OggSeeker oggSeeker;

        SetupData() {
        }
    }

    void init(ExtractorOutput output, TrackOutput trackOutput) {
        this.extractorOutput = output;
        this.trackOutput = trackOutput;
        reset(true);
    }

    protected void reset(boolean headerData) {
        if (headerData) {
            this.setupData = new SetupData();
            this.payloadStartPosition = 0L;
            this.state = 0;
        } else {
            this.state = 1;
        }
        this.targetGranule = -1L;
        this.currentGranule = 0L;
    }

    final void seek(long position, long timeUs) {
        this.oggPacket.reset();
        if (position == 0) {
            reset(!this.seekMapSet);
        } else if (this.state != 0) {
            long jConvertTimeToGranule = convertTimeToGranule(timeUs);
            this.targetGranule = jConvertTimeToGranule;
            this.oggSeeker.startSeek(jConvertTimeToGranule);
            this.state = 2;
        }
    }

    final int read(ExtractorInput input, PositionHolder seekPosition) throws IOException {
        int i = this.state;
        if (i == 0) {
            return readHeaders(input);
        }
        if (i != 1) {
            if (i == 2) {
                return readPayload(input, seekPosition);
            }
            throw new IllegalStateException();
        }
        input.skipFully((int) this.payloadStartPosition);
        this.state = 2;
        return 0;
    }

    private int readHeaders(ExtractorInput input) throws IOException {
        boolean headers = true;
        while (headers) {
            if (!this.oggPacket.populate(input)) {
                this.state = 3;
                return -1;
            }
            this.lengthOfReadPacket = input.getPosition() - this.payloadStartPosition;
            headers = readHeaders(this.oggPacket.getPayload(), this.payloadStartPosition, this.setupData);
            if (headers) {
                this.payloadStartPosition = input.getPosition();
            }
        }
        Format format = this.setupData.format;
        this.sampleRate = format.sampleRate;
        if (!this.formatSet) {
            this.trackOutput.format(format);
            this.formatSet = true;
        }
        OggSeeker oggSeeker = this.setupData.oggSeeker;
        if (oggSeeker != null) {
            this.oggSeeker = oggSeeker;
        } else if (input.getLength() == -1) {
            this.oggSeeker = new UnseekableOggSeeker();
        } else {
            OggPageHeader pageHeader = this.oggPacket.getPageHeader();
            this.oggSeeker = new DefaultOggSeeker(this, this.payloadStartPosition, input.getLength(), pageHeader.headerSize + pageHeader.bodySize, pageHeader.granulePosition, (pageHeader.type & 4) != 0);
        }
        this.setupData = null;
        this.state = 2;
        this.oggPacket.trimPayload();
        return 0;
    }

    private int readPayload(ExtractorInput input, PositionHolder seekPosition) throws IOException {
        long j = this.oggSeeker.read(input);
        if (j >= 0) {
            seekPosition.position = j;
            return 1;
        }
        if (j < -1) {
            onSeekEnd(-(j + 2));
        }
        if (!this.seekMapSet) {
            this.extractorOutput.seekMap((SeekMap) Assertions.checkStateNotNull(this.oggSeeker.createSeekMap()));
            this.seekMapSet = true;
        }
        if (this.lengthOfReadPacket > 0 || this.oggPacket.populate(input)) {
            this.lengthOfReadPacket = 0L;
            ParsableByteArray payload = this.oggPacket.getPayload();
            long jPreparePayload = preparePayload(payload);
            if (jPreparePayload >= 0) {
                long j2 = this.currentGranule;
                if (j2 + jPreparePayload >= this.targetGranule) {
                    long jConvertGranuleToTime = convertGranuleToTime(j2);
                    this.trackOutput.sampleData(payload, payload.limit());
                    this.trackOutput.sampleMetadata(jConvertGranuleToTime, 1, payload.limit(), 0, null);
                    this.targetGranule = -1L;
                }
            }
            this.currentGranule += jPreparePayload;
            return 0;
        }
        this.state = 3;
        return -1;
    }

    protected long convertGranuleToTime(long granule) {
        return (granule * 1000000) / this.sampleRate;
    }

    protected long convertTimeToGranule(long timeUs) {
        return (this.sampleRate * timeUs) / 1000000;
    }

    protected void onSeekEnd(long currentGranule) {
        this.currentGranule = currentGranule;
    }

    private static final class UnseekableOggSeeker implements OggSeeker {
        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long read(ExtractorInput input) {
            return -1L;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public void startSeek(long targetGranule) {
        }

        private UnseekableOggSeeker() {
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public SeekMap createSeekMap() {
            return new SeekMap.Unseekable(-9223372036854775807L);
        }
    }
}
