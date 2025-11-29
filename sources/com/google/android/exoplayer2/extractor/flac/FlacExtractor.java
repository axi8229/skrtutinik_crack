package com.google.android.exoplayer2.extractor.flac;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacMetadataReader;
import com.google.android.exoplayer2.extractor.FlacSeekTableSeekMap;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import org.pjsip.pjsua2.pjmedia_tp_proto;

/* loaded from: classes2.dex */
public final class FlacExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.flac.FlacExtractor$$ExternalSyntheticLambda0
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return FlacExtractor.lambda$static$0();
        }
    };
    private FlacBinarySearchSeeker binarySearchSeeker;
    private final ParsableByteArray buffer;
    private int currentFrameBytesWritten;
    private long currentFrameFirstSampleNumber;
    private ExtractorOutput extractorOutput;
    private FlacStreamMetadata flacStreamMetadata;
    private int frameStartMarker;
    private Metadata id3Metadata;
    private final boolean id3MetadataDisabled;
    private int minFrameSize;
    private final FlacFrameReader.SampleNumberHolder sampleNumberHolder;
    private int state;
    private final byte[] streamMarkerAndInfoBlock;
    private TrackOutput trackOutput;

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new FlacExtractor()};
    }

    public FlacExtractor() {
        this(0);
    }

    public FlacExtractor(int flags) {
        this.streamMarkerAndInfoBlock = new byte[42];
        this.buffer = new ParsableByteArray(new byte[pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP], 0);
        this.id3MetadataDisabled = (flags & 1) != 0;
        this.sampleNumberHolder = new FlacFrameReader.SampleNumberHolder();
        this.state = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput input) throws IOException {
        FlacMetadataReader.peekId3Metadata(input, false);
        return FlacMetadataReader.checkAndPeekStreamMarker(input);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput output) {
        this.extractorOutput = output;
        this.trackOutput = output.track(0, 1);
        output.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput input, PositionHolder seekPosition) throws IOException {
        int i = this.state;
        if (i == 0) {
            readId3Metadata(input);
            return 0;
        }
        if (i == 1) {
            getStreamMarkerAndInfoBlockBytes(input);
            return 0;
        }
        if (i == 2) {
            readStreamMarker(input);
            return 0;
        }
        if (i == 3) {
            readMetadataBlocks(input);
            return 0;
        }
        if (i == 4) {
            getFrameStartMarker(input);
            return 0;
        }
        if (i == 5) {
            return readFrames(input, seekPosition);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long position, long timeUs) {
        if (position == 0) {
            this.state = 0;
        } else {
            FlacBinarySearchSeeker flacBinarySearchSeeker = this.binarySearchSeeker;
            if (flacBinarySearchSeeker != null) {
                flacBinarySearchSeeker.setSeekTargetUs(timeUs);
            }
        }
        this.currentFrameFirstSampleNumber = timeUs != 0 ? -1L : 0L;
        this.currentFrameBytesWritten = 0;
        this.buffer.reset();
    }

    private void readId3Metadata(ExtractorInput input) throws IOException {
        this.id3Metadata = FlacMetadataReader.readId3Metadata(input, !this.id3MetadataDisabled);
        this.state = 1;
    }

    private void getStreamMarkerAndInfoBlockBytes(ExtractorInput input) throws IOException {
        byte[] bArr = this.streamMarkerAndInfoBlock;
        input.peekFully(bArr, 0, bArr.length);
        input.resetPeekPosition();
        this.state = 2;
    }

    private void readStreamMarker(ExtractorInput input) throws IOException {
        FlacMetadataReader.readStreamMarker(input);
        this.state = 3;
    }

    private void readMetadataBlocks(ExtractorInput input) throws IOException {
        FlacMetadataReader.FlacStreamMetadataHolder flacStreamMetadataHolder = new FlacMetadataReader.FlacStreamMetadataHolder(this.flacStreamMetadata);
        boolean metadataBlock = false;
        while (!metadataBlock) {
            metadataBlock = FlacMetadataReader.readMetadataBlock(input, flacStreamMetadataHolder);
            this.flacStreamMetadata = (FlacStreamMetadata) Util.castNonNull(flacStreamMetadataHolder.flacStreamMetadata);
        }
        Assertions.checkNotNull(this.flacStreamMetadata);
        this.minFrameSize = Math.max(this.flacStreamMetadata.minFrameSize, 6);
        ((TrackOutput) Util.castNonNull(this.trackOutput)).format(this.flacStreamMetadata.getFormat(this.streamMarkerAndInfoBlock, this.id3Metadata));
        this.state = 4;
    }

    private void getFrameStartMarker(ExtractorInput input) throws IOException {
        this.frameStartMarker = FlacMetadataReader.getFrameStartMarker(input);
        ((ExtractorOutput) Util.castNonNull(this.extractorOutput)).seekMap(getSeekMap(input.getPosition(), input.getLength()));
        this.state = 5;
    }

    private int readFrames(ExtractorInput input, PositionHolder seekPosition) throws IOException {
        boolean z;
        Assertions.checkNotNull(this.trackOutput);
        Assertions.checkNotNull(this.flacStreamMetadata);
        FlacBinarySearchSeeker flacBinarySearchSeeker = this.binarySearchSeeker;
        if (flacBinarySearchSeeker != null && flacBinarySearchSeeker.isSeeking()) {
            return this.binarySearchSeeker.handlePendingSeek(input, seekPosition);
        }
        if (this.currentFrameFirstSampleNumber == -1) {
            this.currentFrameFirstSampleNumber = FlacFrameReader.getFirstSampleNumber(input, this.flacStreamMetadata);
            return 0;
        }
        int iLimit = this.buffer.limit();
        if (iLimit < 32768) {
            int i = input.read(this.buffer.data, iLimit, pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP - iLimit);
            z = i == -1;
            if (!z) {
                this.buffer.setLimit(iLimit + i);
            } else if (this.buffer.bytesLeft() == 0) {
                outputSampleMetadata();
                return -1;
            }
        } else {
            z = false;
        }
        int position = this.buffer.getPosition();
        int i2 = this.currentFrameBytesWritten;
        int i3 = this.minFrameSize;
        if (i2 < i3) {
            ParsableByteArray parsableByteArray = this.buffer;
            parsableByteArray.skipBytes(Math.min(i3 - i2, parsableByteArray.bytesLeft()));
        }
        long jFindFrame = findFrame(this.buffer, z);
        int position2 = this.buffer.getPosition() - position;
        this.buffer.setPosition(position);
        this.trackOutput.sampleData(this.buffer, position2);
        this.currentFrameBytesWritten += position2;
        if (jFindFrame != -1) {
            outputSampleMetadata();
            this.currentFrameBytesWritten = 0;
            this.currentFrameFirstSampleNumber = jFindFrame;
        }
        if (this.buffer.bytesLeft() < 16) {
            ParsableByteArray parsableByteArray2 = this.buffer;
            byte[] bArr = parsableByteArray2.data;
            int position3 = parsableByteArray2.getPosition();
            ParsableByteArray parsableByteArray3 = this.buffer;
            System.arraycopy(bArr, position3, parsableByteArray3.data, 0, parsableByteArray3.bytesLeft());
            ParsableByteArray parsableByteArray4 = this.buffer;
            parsableByteArray4.reset(parsableByteArray4.bytesLeft());
        }
        return 0;
    }

    private SeekMap getSeekMap(long firstFramePosition, long streamLength) {
        Assertions.checkNotNull(this.flacStreamMetadata);
        FlacStreamMetadata flacStreamMetadata = this.flacStreamMetadata;
        if (flacStreamMetadata.seekTable != null) {
            return new FlacSeekTableSeekMap(flacStreamMetadata, firstFramePosition);
        }
        if (streamLength != -1 && flacStreamMetadata.totalSamples > 0) {
            FlacBinarySearchSeeker flacBinarySearchSeeker = new FlacBinarySearchSeeker(flacStreamMetadata, this.frameStartMarker, firstFramePosition, streamLength);
            this.binarySearchSeeker = flacBinarySearchSeeker;
            return flacBinarySearchSeeker.getSeekMap();
        }
        return new SeekMap.Unseekable(flacStreamMetadata.getDurationUs());
    }

    private long findFrame(ParsableByteArray data, boolean foundEndOfInput) {
        boolean zCheckAndReadFrameHeader;
        Assertions.checkNotNull(this.flacStreamMetadata);
        int position = data.getPosition();
        while (position <= data.limit() - 16) {
            data.setPosition(position);
            if (FlacFrameReader.checkAndReadFrameHeader(data, this.flacStreamMetadata, this.frameStartMarker, this.sampleNumberHolder)) {
                data.setPosition(position);
                return this.sampleNumberHolder.sampleNumber;
            }
            position++;
        }
        if (foundEndOfInput) {
            while (position <= data.limit() - this.minFrameSize) {
                data.setPosition(position);
                try {
                    zCheckAndReadFrameHeader = FlacFrameReader.checkAndReadFrameHeader(data, this.flacStreamMetadata, this.frameStartMarker, this.sampleNumberHolder);
                } catch (IndexOutOfBoundsException unused) {
                    zCheckAndReadFrameHeader = false;
                }
                if (data.getPosition() <= data.limit() ? zCheckAndReadFrameHeader : false) {
                    data.setPosition(position);
                    return this.sampleNumberHolder.sampleNumber;
                }
                position++;
            }
            data.setPosition(data.limit());
            return -1L;
        }
        data.setPosition(position);
        return -1L;
    }

    private void outputSampleMetadata() {
        ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleMetadata((this.currentFrameFirstSampleNumber * 1000000) / ((FlacStreamMetadata) Util.castNonNull(this.flacStreamMetadata)).sampleRate, 1, this.currentFrameBytesWritten, 0, null);
    }
}
