package com.google.android.exoplayer2.extractor.amr;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class AmrExtractor implements Extractor {
    private static final int MAX_FRAME_SIZE_BYTES;
    private static final int[] frameSizeBytesByTypeWb;
    private int currentSampleBytesRemaining;
    private int currentSampleSize;
    private long currentSampleTimeUs;
    private ExtractorOutput extractorOutput;
    private long firstSamplePosition;
    private int firstSampleSize;
    private final int flags;
    private boolean hasOutputFormat;
    private boolean hasOutputSeekMap;
    private boolean isWideBand;
    private int numSamplesWithSameSize;
    private final byte[] scratch;
    private SeekMap seekMap;
    private long timeOffsetUs;
    private TrackOutput trackOutput;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.amr.AmrExtractor$$ExternalSyntheticLambda0
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return AmrExtractor.lambda$static$0();
        }
    };
    private static final int[] frameSizeBytesByTypeNb = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final byte[] amrSignatureNb = Util.getUtf8Bytes("#!AMR\n");
    private static final byte[] amrSignatureWb = Util.getUtf8Bytes("#!AMR-WB\n");

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        frameSizeBytesByTypeWb = iArr;
        MAX_FRAME_SIZE_BYTES = iArr[8];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new AmrExtractor()};
    }

    public AmrExtractor() {
        this(0);
    }

    public AmrExtractor(int flags) {
        this.flags = flags;
        this.scratch = new byte[1];
        this.firstSampleSize = -1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput input) throws IOException {
        return readAmrHeader(input);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        this.trackOutput = extractorOutput.track(0, 1);
        extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput input, PositionHolder seekPosition) throws IOException {
        assertInitialized();
        if (input.getPosition() == 0 && !readAmrHeader(input)) {
            throw new ParserException("Could not find AMR header.");
        }
        maybeOutputFormat();
        int sample = readSample(input);
        maybeOutputSeekMap(input.getLength(), sample);
        return sample;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long position, long timeUs) {
        this.currentSampleTimeUs = 0L;
        this.currentSampleSize = 0;
        this.currentSampleBytesRemaining = 0;
        if (position != 0) {
            SeekMap seekMap = this.seekMap;
            if (seekMap instanceof ConstantBitrateSeekMap) {
                this.timeOffsetUs = ((ConstantBitrateSeekMap) seekMap).getTimeUsAtPosition(position);
                return;
            }
        }
        this.timeOffsetUs = 0L;
    }

    private boolean readAmrHeader(ExtractorInput input) throws IOException {
        byte[] bArr = amrSignatureNb;
        if (peekAmrSignature(input, bArr)) {
            this.isWideBand = false;
            input.skipFully(bArr.length);
            return true;
        }
        byte[] bArr2 = amrSignatureWb;
        if (!peekAmrSignature(input, bArr2)) {
            return false;
        }
        this.isWideBand = true;
        input.skipFully(bArr2.length);
        return true;
    }

    private static boolean peekAmrSignature(ExtractorInput input, byte[] amrSignature) throws IOException {
        input.resetPeekPosition();
        byte[] bArr = new byte[amrSignature.length];
        input.peekFully(bArr, 0, amrSignature.length);
        return Arrays.equals(bArr, amrSignature);
    }

    private void maybeOutputFormat() {
        if (this.hasOutputFormat) {
            return;
        }
        this.hasOutputFormat = true;
        boolean z = this.isWideBand;
        this.trackOutput.format(new Format.Builder().setSampleMimeType(z ? "audio/amr-wb" : "audio/3gpp").setMaxInputSize(MAX_FRAME_SIZE_BYTES).setChannelCount(1).setSampleRate(z ? 16000 : JosStatusCodes.RTN_CODE_COMMON_ERROR).build());
    }

    private int readSample(ExtractorInput extractorInput) throws IOException {
        if (this.currentSampleBytesRemaining == 0) {
            try {
                int iPeekNextSampleSize = peekNextSampleSize(extractorInput);
                this.currentSampleSize = iPeekNextSampleSize;
                this.currentSampleBytesRemaining = iPeekNextSampleSize;
                if (this.firstSampleSize == -1) {
                    this.firstSamplePosition = extractorInput.getPosition();
                    this.firstSampleSize = this.currentSampleSize;
                }
                if (this.firstSampleSize == this.currentSampleSize) {
                    this.numSamplesWithSameSize++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iSampleData = this.trackOutput.sampleData(extractorInput, this.currentSampleBytesRemaining, true);
        if (iSampleData == -1) {
            return -1;
        }
        int i = this.currentSampleBytesRemaining - iSampleData;
        this.currentSampleBytesRemaining = i;
        if (i > 0) {
            return 0;
        }
        this.trackOutput.sampleMetadata(this.timeOffsetUs + this.currentSampleTimeUs, 1, this.currentSampleSize, 0, null);
        this.currentSampleTimeUs += DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT;
        return 0;
    }

    private int peekNextSampleSize(ExtractorInput extractorInput) throws IOException {
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.scratch, 0, 1);
        byte b = this.scratch[0];
        if ((b & 131) > 0) {
            throw new ParserException("Invalid padding bits for frame header " + ((int) b));
        }
        return getFrameSizeInBytes((b >> 3) & 15);
    }

    private int getFrameSizeInBytes(int frameType) throws ParserException {
        if (isValidFrameType(frameType)) {
            return this.isWideBand ? frameSizeBytesByTypeWb[frameType] : frameSizeBytesByTypeNb[frameType];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        sb.append(this.isWideBand ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(frameType);
        throw new ParserException(sb.toString());
    }

    private boolean isValidFrameType(int frameType) {
        return frameType >= 0 && frameType <= 15 && (isWideBandValidFrameType(frameType) || isNarrowBandValidFrameType(frameType));
    }

    private boolean isWideBandValidFrameType(int frameType) {
        return this.isWideBand && (frameType < 10 || frameType > 13);
    }

    private boolean isNarrowBandValidFrameType(int frameType) {
        return !this.isWideBand && (frameType < 12 || frameType > 14);
    }

    private void maybeOutputSeekMap(long inputLength, int sampleReadResult) {
        int i;
        if (this.hasOutputSeekMap) {
            return;
        }
        if ((this.flags & 1) == 0 || inputLength == -1 || ((i = this.firstSampleSize) != -1 && i != this.currentSampleSize)) {
            SeekMap.Unseekable unseekable = new SeekMap.Unseekable(-9223372036854775807L);
            this.seekMap = unseekable;
            this.extractorOutput.seekMap(unseekable);
            this.hasOutputSeekMap = true;
            return;
        }
        if (this.numSamplesWithSameSize >= 20 || sampleReadResult == -1) {
            SeekMap constantBitrateSeekMap = getConstantBitrateSeekMap(inputLength);
            this.seekMap = constantBitrateSeekMap;
            this.extractorOutput.seekMap(constantBitrateSeekMap);
            this.hasOutputSeekMap = true;
        }
    }

    private SeekMap getConstantBitrateSeekMap(long inputLength) {
        return new ConstantBitrateSeekMap(inputLength, this.firstSamplePosition, getBitrateFromFrameSize(this.firstSampleSize, DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT), this.firstSampleSize);
    }

    private void assertInitialized() {
        Assertions.checkStateNotNull(this.trackOutput);
        Util.castNonNull(this.extractorOutput);
    }

    private static int getBitrateFromFrameSize(int frameSize, long durationUsPerFrame) {
        return (int) (((frameSize * 8) * 1000000) / durationUsPerFrame);
    }
}
