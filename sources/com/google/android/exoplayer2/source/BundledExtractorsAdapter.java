package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes2.dex */
final class BundledExtractorsAdapter implements ProgressiveMediaExtractor {
    private Extractor extractor;
    private ExtractorInput extractorInput;
    private final Extractor[] extractors;

    public BundledExtractorsAdapter(Extractor[] extractors) {
        this.extractors = extractors;
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void init(DataReader dataReader, Uri uri, long position, long length, ExtractorOutput output) throws IOException {
        this.extractorInput = new DefaultExtractorInput(dataReader, position, length);
        if (this.extractor != null) {
            return;
        }
        Extractor[] extractorArr = this.extractors;
        int i = 0;
        if (extractorArr.length == 1) {
            this.extractor = extractorArr[0];
        } else {
            int length2 = extractorArr.length;
            while (true) {
                if (i >= length2) {
                    break;
                }
                Extractor extractor = extractorArr[i];
                try {
                    if (extractor.sniff(this.extractorInput)) {
                        this.extractor = extractor;
                        this.extractorInput.resetPeekPosition();
                        break;
                    }
                } catch (EOFException unused) {
                } catch (Throwable th) {
                    this.extractorInput.resetPeekPosition();
                    throw th;
                }
                this.extractorInput.resetPeekPosition();
                i++;
            }
            if (this.extractor == null) {
                throw new UnrecognizedInputFormatException("None of the available extractors (" + Util.getCommaDelimitedSimpleClassNames(this.extractors) + ") could read the stream.", (Uri) Assertions.checkNotNull(uri));
            }
        }
        this.extractor.init(output);
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void release() {
        Extractor extractor = this.extractor;
        if (extractor != null) {
            extractor.release();
            this.extractor = null;
        }
        this.extractorInput = null;
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void disableSeekingOnMp3Streams() {
        Extractor extractor = this.extractor;
        if (extractor instanceof Mp3Extractor) {
            ((Mp3Extractor) extractor).disableSeeking();
        }
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public long getCurrentInputPosition() {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput != null) {
            return extractorInput.getPosition();
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void seek(long position, long seekTimeUs) {
        ((Extractor) Assertions.checkNotNull(this.extractor)).seek(position, seekTimeUs);
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public int read(PositionHolder positionHolder) throws IOException {
        return ((Extractor) Assertions.checkNotNull(this.extractor)).read((ExtractorInput) Assertions.checkNotNull(this.extractorInput), positionHolder);
    }
}
