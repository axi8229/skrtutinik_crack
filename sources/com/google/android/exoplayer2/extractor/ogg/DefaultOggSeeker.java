package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import ru.yoomoney.sdk.auth.location.utils.UtilsKt;

/* loaded from: classes2.dex */
final class DefaultOggSeeker implements OggSeeker {
    private long end;
    private long endGranule;
    private final OggPageHeader pageHeader;
    private final long payloadEndPosition;
    private final long payloadStartPosition;
    private long positionBeforeSeekToEnd;
    private long start;
    private long startGranule;
    private int state;
    private final StreamReader streamReader;
    private long targetGranule;
    private long totalGranules;

    public DefaultOggSeeker(StreamReader streamReader, long payloadStartPosition, long payloadEndPosition, long firstPayloadPageSize, long firstPayloadPageGranulePosition, boolean firstPayloadPageIsLastPage) {
        Assertions.checkArgument(payloadStartPosition >= 0 && payloadEndPosition > payloadStartPosition);
        this.streamReader = streamReader;
        this.payloadStartPosition = payloadStartPosition;
        this.payloadEndPosition = payloadEndPosition;
        if (firstPayloadPageSize == payloadEndPosition - payloadStartPosition || firstPayloadPageIsLastPage) {
            this.totalGranules = firstPayloadPageGranulePosition;
            this.state = 4;
        } else {
            this.state = 0;
        }
        this.pageHeader = new OggPageHeader();
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public long read(ExtractorInput input) throws IOException {
        int i = this.state;
        if (i == 0) {
            long position = input.getPosition();
            this.positionBeforeSeekToEnd = position;
            this.state = 1;
            long j = this.payloadEndPosition - 65307;
            if (j > position) {
                return j;
            }
        } else if (i != 1) {
            if (i == 2) {
                long nextSeekPosition = getNextSeekPosition(input);
                if (nextSeekPosition != -1) {
                    return nextSeekPosition;
                }
                this.state = 3;
            } else if (i != 3) {
                if (i == 4) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            skipToPageOfTargetGranule(input);
            this.state = 4;
            return -(this.startGranule + 2);
        }
        this.totalGranules = readGranuleOfLastPage(input);
        this.state = 4;
        return this.positionBeforeSeekToEnd;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public OggSeekMap createSeekMap() {
        if (this.totalGranules != 0) {
            return new OggSeekMap();
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public void startSeek(long targetGranule) {
        this.targetGranule = Util.constrainValue(targetGranule, 0L, this.totalGranules - 1);
        this.state = 2;
        this.start = this.payloadStartPosition;
        this.end = this.payloadEndPosition;
        this.startGranule = 0L;
        this.endGranule = this.totalGranules;
    }

    private long getNextSeekPosition(ExtractorInput input) throws IOException {
        if (this.start == this.end) {
            return -1L;
        }
        long position = input.getPosition();
        if (!skipToNextPage(input, this.end)) {
            long j = this.start;
            if (j != position) {
                return j;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.pageHeader.populate(input, false);
        input.resetPeekPosition();
        long j2 = this.targetGranule;
        OggPageHeader oggPageHeader = this.pageHeader;
        long j3 = oggPageHeader.granulePosition;
        long j4 = j2 - j3;
        int i = oggPageHeader.headerSize + oggPageHeader.bodySize;
        if (0 <= j4 && j4 < 72000) {
            return -1L;
        }
        if (j4 < 0) {
            this.end = position;
            this.endGranule = j3;
        } else {
            this.start = input.getPosition() + i;
            this.startGranule = this.pageHeader.granulePosition;
        }
        long j5 = this.end;
        long j6 = this.start;
        if (j5 - j6 < 100000) {
            this.end = j6;
            return j6;
        }
        long position2 = input.getPosition() - (i * (j4 <= 0 ? 2L : 1L));
        long j7 = this.end;
        long j8 = this.start;
        return Util.constrainValue(position2 + ((j4 * (j7 - j8)) / (this.endGranule - this.startGranule)), j8, j7 - 1);
    }

    private void skipToPageOfTargetGranule(ExtractorInput input) throws IOException {
        this.pageHeader.populate(input, false);
        while (true) {
            OggPageHeader oggPageHeader = this.pageHeader;
            if (oggPageHeader.granulePosition <= this.targetGranule) {
                input.skipFully(oggPageHeader.headerSize + oggPageHeader.bodySize);
                this.start = input.getPosition();
                OggPageHeader oggPageHeader2 = this.pageHeader;
                this.startGranule = oggPageHeader2.granulePosition;
                oggPageHeader2.populate(input, false);
            } else {
                input.resetPeekPosition();
                return;
            }
        }
    }

    void skipToNextPage(ExtractorInput input) throws IOException {
        if (!skipToNextPage(input, this.payloadEndPosition)) {
            throw new EOFException();
        }
    }

    private boolean skipToNextPage(ExtractorInput input, long limit) throws IOException {
        int i;
        long jMin = Math.min(limit + 3, this.payloadEndPosition);
        int position = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            int i2 = 0;
            if (input.getPosition() + position > jMin && (position = (int) (jMin - input.getPosition())) < 4) {
                return false;
            }
            input.peekFully(bArr, 0, position, false);
            while (true) {
                i = position - 3;
                if (i2 < i) {
                    if (bArr[i2] == 79 && bArr[i2 + 1] == 103 && bArr[i2 + 2] == 103 && bArr[i2 + 3] == 83) {
                        input.skipFully(i2);
                        return true;
                    }
                    i2++;
                }
            }
            input.skipFully(i);
        }
    }

    long readGranuleOfLastPage(ExtractorInput input) throws IOException {
        skipToNextPage(input);
        this.pageHeader.reset();
        while ((this.pageHeader.type & 4) != 4 && input.getPosition() < this.payloadEndPosition) {
            this.pageHeader.populate(input, false);
            OggPageHeader oggPageHeader = this.pageHeader;
            input.skipFully(oggPageHeader.headerSize + oggPageHeader.bodySize);
        }
        return this.pageHeader.granulePosition;
    }

    private final class OggSeekMap implements SeekMap {
        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }

        private OggSeekMap() {
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public SeekMap.SeekPoints getSeekPoints(long timeUs) {
            return new SeekMap.SeekPoints(new SeekPoint(timeUs, Util.constrainValue((DefaultOggSeeker.this.payloadStartPosition + ((DefaultOggSeeker.this.streamReader.convertTimeToGranule(timeUs) * (DefaultOggSeeker.this.payloadEndPosition - DefaultOggSeeker.this.payloadStartPosition)) / DefaultOggSeeker.this.totalGranules)) - UtilsKt.UPDATE_INTERVAL, DefaultOggSeeker.this.payloadStartPosition, DefaultOggSeeker.this.payloadEndPosition - 1)));
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return DefaultOggSeeker.this.streamReader.convertGranuleToTime(DefaultOggSeeker.this.totalGranules);
        }
    }
}
