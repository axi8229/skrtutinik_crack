package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* loaded from: classes2.dex */
final class TrackFragment {
    public long atomPosition;
    public long auxiliaryDataPosition;
    public long dataPosition;
    public boolean definesEncryptionData;
    public DefaultSampleValues header;
    public long nextFragmentDecodeTime;
    public int sampleCount;
    public boolean sampleEncryptionDataNeedsFill;
    public TrackEncryptionBox trackEncryptionBox;
    public int trunCount;
    public long[] trunDataPosition = new long[0];
    public int[] trunLength = new int[0];
    public int[] sampleSizeTable = new int[0];
    public int[] sampleCompositionTimeOffsetTable = new int[0];
    public long[] sampleDecodingTimeTable = new long[0];
    public boolean[] sampleIsSyncFrameTable = new boolean[0];
    public boolean[] sampleHasSubsampleEncryptionTable = new boolean[0];
    public final ParsableByteArray sampleEncryptionData = new ParsableByteArray();

    public void reset() {
        this.trunCount = 0;
        this.nextFragmentDecodeTime = 0L;
        this.definesEncryptionData = false;
        this.sampleEncryptionDataNeedsFill = false;
        this.trackEncryptionBox = null;
    }

    public void initTables(int trunCount, int sampleCount) {
        this.trunCount = trunCount;
        this.sampleCount = sampleCount;
        if (this.trunLength.length < trunCount) {
            this.trunDataPosition = new long[trunCount];
            this.trunLength = new int[trunCount];
        }
        if (this.sampleSizeTable.length < sampleCount) {
            int i = (sampleCount * 125) / 100;
            this.sampleSizeTable = new int[i];
            this.sampleCompositionTimeOffsetTable = new int[i];
            this.sampleDecodingTimeTable = new long[i];
            this.sampleIsSyncFrameTable = new boolean[i];
            this.sampleHasSubsampleEncryptionTable = new boolean[i];
        }
    }

    public void initEncryptionData(int length) {
        this.sampleEncryptionData.reset(length);
        this.definesEncryptionData = true;
        this.sampleEncryptionDataNeedsFill = true;
    }

    public void fillEncryptionData(ExtractorInput input) throws IOException {
        ParsableByteArray parsableByteArray = this.sampleEncryptionData;
        input.readFully(parsableByteArray.data, 0, parsableByteArray.limit());
        this.sampleEncryptionData.setPosition(0);
        this.sampleEncryptionDataNeedsFill = false;
    }

    public void fillEncryptionData(ParsableByteArray source) {
        ParsableByteArray parsableByteArray = this.sampleEncryptionData;
        source.readBytes(parsableByteArray.data, 0, parsableByteArray.limit());
        this.sampleEncryptionData.setPosition(0);
        this.sampleEncryptionDataNeedsFill = false;
    }

    public long getSamplePresentationTime(int index) {
        return this.sampleDecodingTimeTable[index] + this.sampleCompositionTimeOffsetTable[index];
    }

    public boolean sampleHasSubsampleEncryptionTable(int index) {
        return this.definesEncryptionData && this.sampleHasSubsampleEncryptionTable[index];
    }
}
