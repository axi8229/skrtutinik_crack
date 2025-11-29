package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import kotlin.KotlinVersion;

/* loaded from: classes2.dex */
final class OggPageHeader {
    public int bodySize;
    public long granulePosition;
    public int headerSize;
    public long pageChecksum;
    public int pageSegmentCount;
    public long pageSequenceNumber;
    public int revision;
    public long streamSerialNumber;
    public int type;
    public final int[] laces = new int[KotlinVersion.MAX_COMPONENT_VALUE];
    private final ParsableByteArray scratch = new ParsableByteArray(KotlinVersion.MAX_COMPONENT_VALUE);

    OggPageHeader() {
    }

    public void reset() {
        this.revision = 0;
        this.type = 0;
        this.granulePosition = 0L;
        this.streamSerialNumber = 0L;
        this.pageSequenceNumber = 0L;
        this.pageChecksum = 0L;
        this.pageSegmentCount = 0;
        this.headerSize = 0;
        this.bodySize = 0;
    }

    public boolean populate(ExtractorInput input, boolean quiet) throws IOException {
        this.scratch.reset();
        reset();
        if ((input.getLength() != -1 && input.getLength() - input.getPeekPosition() < 27) || !input.peekFully(this.scratch.data, 0, 27, true)) {
            if (quiet) {
                return false;
            }
            throw new EOFException();
        }
        if (this.scratch.readUnsignedInt() != 1332176723) {
            if (quiet) {
                return false;
            }
            throw new ParserException("expected OggS capture pattern at begin of page");
        }
        int unsignedByte = this.scratch.readUnsignedByte();
        this.revision = unsignedByte;
        if (unsignedByte != 0) {
            if (quiet) {
                return false;
            }
            throw new ParserException("unsupported bit stream revision");
        }
        this.type = this.scratch.readUnsignedByte();
        this.granulePosition = this.scratch.readLittleEndianLong();
        this.streamSerialNumber = this.scratch.readLittleEndianUnsignedInt();
        this.pageSequenceNumber = this.scratch.readLittleEndianUnsignedInt();
        this.pageChecksum = this.scratch.readLittleEndianUnsignedInt();
        int unsignedByte2 = this.scratch.readUnsignedByte();
        this.pageSegmentCount = unsignedByte2;
        this.headerSize = unsignedByte2 + 27;
        this.scratch.reset();
        input.peekFully(this.scratch.data, 0, this.pageSegmentCount);
        for (int i = 0; i < this.pageSegmentCount; i++) {
            this.laces[i] = this.scratch.readUnsignedByte();
            this.bodySize += this.laces[i];
        }
        return true;
    }
}
