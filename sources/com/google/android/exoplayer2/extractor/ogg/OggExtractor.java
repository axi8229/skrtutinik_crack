package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* loaded from: classes2.dex */
public class OggExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.ogg.OggExtractor$$ExternalSyntheticLambda0
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return OggExtractor.lambda$static$0();
        }
    };
    private ExtractorOutput output;
    private StreamReader streamReader;
    private boolean streamReaderInitialized;

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new OggExtractor()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput input) throws IOException {
        try {
            return sniffInternal(input);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput output) {
        this.output = output;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long position, long timeUs) {
        StreamReader streamReader = this.streamReader;
        if (streamReader != null) {
            streamReader.seek(position, timeUs);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput input, PositionHolder seekPosition) throws IOException {
        Assertions.checkStateNotNull(this.output);
        if (this.streamReader == null) {
            if (!sniffInternal(input)) {
                throw new ParserException("Failed to determine bitstream type");
            }
            input.resetPeekPosition();
        }
        if (!this.streamReaderInitialized) {
            TrackOutput trackOutputTrack = this.output.track(0, 1);
            this.output.endTracks();
            this.streamReader.init(this.output, trackOutputTrack);
            this.streamReaderInitialized = true;
        }
        return this.streamReader.read(input, seekPosition);
    }

    private boolean sniffInternal(ExtractorInput input) throws IOException {
        OggPageHeader oggPageHeader = new OggPageHeader();
        if (oggPageHeader.populate(input, true) && (oggPageHeader.type & 2) == 2) {
            int iMin = Math.min(oggPageHeader.bodySize, 8);
            ParsableByteArray parsableByteArray = new ParsableByteArray(iMin);
            input.peekFully(parsableByteArray.data, 0, iMin);
            if (FlacReader.verifyBitstreamType(resetPosition(parsableByteArray))) {
                this.streamReader = new FlacReader();
            } else if (VorbisReader.verifyBitstreamType(resetPosition(parsableByteArray))) {
                this.streamReader = new VorbisReader();
            } else if (OpusReader.verifyBitstreamType(resetPosition(parsableByteArray))) {
                this.streamReader = new OpusReader();
            }
            return true;
        }
        return false;
    }

    private static ParsableByteArray resetPosition(ParsableByteArray scratch) {
        scratch.setPosition(0);
        return scratch;
    }
}
