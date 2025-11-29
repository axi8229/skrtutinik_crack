package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import kotlin.KotlinVersion;

/* loaded from: classes2.dex */
public final class DtsReader implements ElementaryStreamReader {
    private int bytesRead;
    private Format format;
    private String formatId;
    private final String language;
    private TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int syncBytes;
    private long timeUs;
    private final ParsableByteArray headerScratchBytes = new ParsableByteArray(new byte[18]);
    private int state = 0;

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    public DtsReader(String language) {
        this.language = language;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.state = 0;
        this.bytesRead = 0;
        this.syncBytes = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator idGenerator) {
        idGenerator.generateNewId();
        this.formatId = idGenerator.getFormatId();
        this.output = extractorOutput.track(idGenerator.getTrackId(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long pesTimeUs, int flags) {
        this.timeUs = pesTimeUs;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray data) {
        Assertions.checkStateNotNull(this.output);
        while (data.bytesLeft() > 0) {
            int i = this.state;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int iMin = Math.min(data.bytesLeft(), this.sampleSize - this.bytesRead);
                        this.output.sampleData(data, iMin);
                        int i2 = this.bytesRead + iMin;
                        this.bytesRead = i2;
                        int i3 = this.sampleSize;
                        if (i2 == i3) {
                            this.output.sampleMetadata(this.timeUs, 1, i3, 0, null);
                            this.timeUs += this.sampleDurationUs;
                            this.state = 0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (continueRead(data, this.headerScratchBytes.data, 18)) {
                    parseHeader();
                    this.headerScratchBytes.setPosition(0);
                    this.output.sampleData(this.headerScratchBytes, 18);
                    this.state = 2;
                }
            } else if (skipToNextSync(data)) {
                this.state = 1;
            }
        }
    }

    private boolean continueRead(ParsableByteArray source, byte[] target, int targetLength) {
        int iMin = Math.min(source.bytesLeft(), targetLength - this.bytesRead);
        source.readBytes(target, this.bytesRead, iMin);
        int i = this.bytesRead + iMin;
        this.bytesRead = i;
        return i == targetLength;
    }

    private boolean skipToNextSync(ParsableByteArray pesBuffer) {
        while (pesBuffer.bytesLeft() > 0) {
            int i = this.syncBytes << 8;
            this.syncBytes = i;
            int unsignedByte = i | pesBuffer.readUnsignedByte();
            this.syncBytes = unsignedByte;
            if (DtsUtil.isSyncWord(unsignedByte)) {
                byte[] bArr = this.headerScratchBytes.data;
                int i2 = this.syncBytes;
                bArr[0] = (byte) ((i2 >> 24) & KotlinVersion.MAX_COMPONENT_VALUE);
                bArr[1] = (byte) ((i2 >> 16) & KotlinVersion.MAX_COMPONENT_VALUE);
                bArr[2] = (byte) ((i2 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
                bArr[3] = (byte) (i2 & KotlinVersion.MAX_COMPONENT_VALUE);
                this.bytesRead = 4;
                this.syncBytes = 0;
                return true;
            }
        }
        return false;
    }

    private void parseHeader() {
        byte[] bArr = this.headerScratchBytes.data;
        if (this.format == null) {
            Format dtsFormat = DtsUtil.parseDtsFormat(bArr, this.formatId, this.language, null);
            this.format = dtsFormat;
            this.output.format(dtsFormat);
        }
        this.sampleSize = DtsUtil.getDtsFrameSize(bArr);
        this.sampleDurationUs = (int) ((DtsUtil.parseDtsAudioSampleCount(bArr) * 1000000) / this.format.sampleRate);
    }
}
