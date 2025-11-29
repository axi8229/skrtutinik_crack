package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacMetadataReader;
import com.google.android.exoplayer2.extractor.FlacSeekTableSeekMap;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class FlacReader extends StreamReader {
    private FlacOggSeeker flacOggSeeker;
    private FlacStreamMetadata streamMetadata;

    FlacReader() {
    }

    public static boolean verifyBitstreamType(ParsableByteArray data) {
        return data.bytesLeft() >= 5 && data.readUnsignedByte() == 127 && data.readUnsignedInt() == 1179402563;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected void reset(boolean headerData) {
        super.reset(headerData);
        if (headerData) {
            this.streamMetadata = null;
            this.flacOggSeeker = null;
        }
    }

    private static boolean isAudioPacket(byte[] data) {
        return data[0] == -1;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected long preparePayload(ParsableByteArray packet) {
        if (isAudioPacket(packet.data)) {
            return getFlacFrameBlockSize(packet);
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected boolean readHeaders(ParsableByteArray packet, long position, StreamReader.SetupData setupData) {
        byte[] bArr = packet.data;
        FlacStreamMetadata flacStreamMetadata = this.streamMetadata;
        if (flacStreamMetadata == null) {
            FlacStreamMetadata flacStreamMetadata2 = new FlacStreamMetadata(bArr, 17);
            this.streamMetadata = flacStreamMetadata2;
            setupData.format = flacStreamMetadata2.getFormat(Arrays.copyOfRange(bArr, 9, packet.limit()), null);
            return true;
        }
        if ((bArr[0] & 127) == 3) {
            FlacStreamMetadata.SeekTable seekTableMetadataBlock = FlacMetadataReader.readSeekTableMetadataBlock(packet);
            FlacStreamMetadata flacStreamMetadataCopyWithSeekTable = flacStreamMetadata.copyWithSeekTable(seekTableMetadataBlock);
            this.streamMetadata = flacStreamMetadataCopyWithSeekTable;
            this.flacOggSeeker = new FlacOggSeeker(flacStreamMetadataCopyWithSeekTable, seekTableMetadataBlock);
            return true;
        }
        if (!isAudioPacket(bArr)) {
            return true;
        }
        FlacOggSeeker flacOggSeeker = this.flacOggSeeker;
        if (flacOggSeeker != null) {
            flacOggSeeker.setFirstFrameOffset(position);
            setupData.oggSeeker = this.flacOggSeeker;
        }
        return false;
    }

    private int getFlacFrameBlockSize(ParsableByteArray packet) {
        int i = (packet.data[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            packet.skipBytes(4);
            packet.readUtf8EncodedLong();
        }
        int frameBlockSizeSamplesFromKey = FlacFrameReader.readFrameBlockSizeSamplesFromKey(packet, i);
        packet.setPosition(0);
        return frameBlockSizeSamplesFromKey;
    }

    private static final class FlacOggSeeker implements OggSeeker {
        private long firstFrameOffset = -1;
        private long pendingSeekGranule = -1;
        private FlacStreamMetadata.SeekTable seekTable;
        private FlacStreamMetadata streamMetadata;

        public FlacOggSeeker(FlacStreamMetadata streamMetadata, FlacStreamMetadata.SeekTable seekTable) {
            this.streamMetadata = streamMetadata;
            this.seekTable = seekTable;
        }

        public void setFirstFrameOffset(long firstFrameOffset) {
            this.firstFrameOffset = firstFrameOffset;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long read(ExtractorInput input) {
            long j = this.pendingSeekGranule;
            if (j < 0) {
                return -1L;
            }
            long j2 = -(j + 2);
            this.pendingSeekGranule = -1L;
            return j2;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public void startSeek(long targetGranule) {
            long[] jArr = this.seekTable.pointSampleNumbers;
            this.pendingSeekGranule = jArr[Util.binarySearchFloor(jArr, targetGranule, true, true)];
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public SeekMap createSeekMap() {
            Assertions.checkState(this.firstFrameOffset != -1);
            return new FlacSeekTableSeekMap(this.streamMetadata, this.firstFrameOffset);
        }
    }
}
