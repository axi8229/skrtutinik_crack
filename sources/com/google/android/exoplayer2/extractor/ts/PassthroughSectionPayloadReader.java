package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes2.dex */
public final class PassthroughSectionPayloadReader implements SectionPayloadReader {
    private Format format;
    private TrackOutput output;
    private TimestampAdjuster timestampAdjuster;

    public PassthroughSectionPayloadReader(String mimeType) {
        this.format = new Format.Builder().setSampleMimeType(mimeType).build();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
    public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator idGenerator) {
        this.timestampAdjuster = timestampAdjuster;
        idGenerator.generateNewId();
        TrackOutput trackOutputTrack = extractorOutput.track(idGenerator.getTrackId(), 4);
        this.output = trackOutputTrack;
        trackOutputTrack.format(this.format);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
    public void consume(ParsableByteArray sectionData) {
        assertInitialized();
        long timestampOffsetUs = this.timestampAdjuster.getTimestampOffsetUs();
        if (timestampOffsetUs == -9223372036854775807L) {
            return;
        }
        Format format = this.format;
        if (timestampOffsetUs != format.subsampleOffsetUs) {
            Format formatBuild = format.buildUpon().setSubsampleOffsetUs(timestampOffsetUs).build();
            this.format = formatBuild;
            this.output.format(formatBuild);
        }
        int iBytesLeft = sectionData.bytesLeft();
        this.output.sampleData(sectionData, iBytesLeft);
        this.output.sampleMetadata(this.timestampAdjuster.getLastAdjustedTimestampUs(), 1, iBytesLeft, 0, null);
    }

    private void assertInitialized() {
        Assertions.checkStateNotNull(this.timestampAdjuster);
        Util.castNonNull(this.output);
    }
}
