package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.VorbisUtil;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.KotlinVersion;

/* loaded from: classes2.dex */
final class VorbisReader extends StreamReader {
    private VorbisUtil.CommentHeader commentHeader;
    private int previousPacketBlockSize;
    private boolean seenFirstAudioPacket;
    private VorbisUtil.VorbisIdHeader vorbisIdHeader;
    private VorbisSetup vorbisSetup;

    static int readBits(byte src, int length, int leastSignificantBitIndex) {
        return (src >> leastSignificantBitIndex) & (KotlinVersion.MAX_COMPONENT_VALUE >>> (8 - length));
    }

    VorbisReader() {
    }

    public static boolean verifyBitstreamType(ParsableByteArray data) {
        try {
            return VorbisUtil.verifyVorbisHeaderCapturePattern(1, data, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected void reset(boolean headerData) {
        super.reset(headerData);
        if (headerData) {
            this.vorbisSetup = null;
            this.vorbisIdHeader = null;
            this.commentHeader = null;
        }
        this.previousPacketBlockSize = 0;
        this.seenFirstAudioPacket = false;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected void onSeekEnd(long currentGranule) {
        super.onSeekEnd(currentGranule);
        this.seenFirstAudioPacket = currentGranule != 0;
        VorbisUtil.VorbisIdHeader vorbisIdHeader = this.vorbisIdHeader;
        this.previousPacketBlockSize = vorbisIdHeader != null ? vorbisIdHeader.blockSize0 : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected long preparePayload(ParsableByteArray packet) {
        byte b = packet.data[0];
        if ((b & 1) == 1) {
            return -1L;
        }
        int iDecodeBlockSize = decodeBlockSize(b, this.vorbisSetup);
        long j = this.seenFirstAudioPacket ? (this.previousPacketBlockSize + iDecodeBlockSize) / 4 : 0;
        appendNumberOfSamples(packet, j);
        this.seenFirstAudioPacket = true;
        this.previousPacketBlockSize = iDecodeBlockSize;
        return j;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected boolean readHeaders(ParsableByteArray packet, long position, StreamReader.SetupData setupData) throws IOException {
        if (this.vorbisSetup != null) {
            return false;
        }
        VorbisSetup setupHeaders = readSetupHeaders(packet);
        this.vorbisSetup = setupHeaders;
        if (setupHeaders == null) {
            return true;
        }
        VorbisUtil.VorbisIdHeader vorbisIdHeader = setupHeaders.idHeader;
        ArrayList arrayList = new ArrayList();
        arrayList.add(vorbisIdHeader.data);
        arrayList.add(this.vorbisSetup.setupHeaderData);
        setupData.format = new Format.Builder().setSampleMimeType("audio/vorbis").setAverageBitrate(vorbisIdHeader.bitrateNominal).setPeakBitrate(vorbisIdHeader.bitrateMaximum).setChannelCount(vorbisIdHeader.channels).setSampleRate(vorbisIdHeader.sampleRate).setInitializationData(arrayList).build();
        return true;
    }

    VorbisSetup readSetupHeaders(ParsableByteArray scratch) throws IOException {
        if (this.vorbisIdHeader == null) {
            this.vorbisIdHeader = VorbisUtil.readVorbisIdentificationHeader(scratch);
            return null;
        }
        if (this.commentHeader == null) {
            this.commentHeader = VorbisUtil.readVorbisCommentHeader(scratch);
            return null;
        }
        byte[] bArr = new byte[scratch.limit()];
        System.arraycopy(scratch.data, 0, bArr, 0, scratch.limit());
        return new VorbisSetup(this.vorbisIdHeader, this.commentHeader, bArr, VorbisUtil.readVorbisModes(scratch, this.vorbisIdHeader.channels), VorbisUtil.iLog(r5.length - 1));
    }

    static void appendNumberOfSamples(ParsableByteArray buffer, long packetSampleCount) {
        buffer.setLimit(buffer.limit() + 4);
        buffer.data[buffer.limit() - 4] = (byte) (packetSampleCount & 255);
        buffer.data[buffer.limit() - 3] = (byte) ((packetSampleCount >>> 8) & 255);
        buffer.data[buffer.limit() - 2] = (byte) ((packetSampleCount >>> 16) & 255);
        buffer.data[buffer.limit() - 1] = (byte) ((packetSampleCount >>> 24) & 255);
    }

    private static int decodeBlockSize(byte firstByteOfAudioPacket, VorbisSetup vorbisSetup) {
        if (!vorbisSetup.modes[readBits(firstByteOfAudioPacket, vorbisSetup.iLogModes, 1)].blockFlag) {
            return vorbisSetup.idHeader.blockSize0;
        }
        return vorbisSetup.idHeader.blockSize1;
    }

    static final class VorbisSetup {
        public final VorbisUtil.CommentHeader commentHeader;
        public final int iLogModes;
        public final VorbisUtil.VorbisIdHeader idHeader;
        public final VorbisUtil.Mode[] modes;
        public final byte[] setupHeaderData;

        public VorbisSetup(VorbisUtil.VorbisIdHeader idHeader, VorbisUtil.CommentHeader commentHeader, byte[] setupHeaderData, VorbisUtil.Mode[] modes, int iLogModes) {
            this.idHeader = idHeader;
            this.commentHeader = commentHeader;
            this.setupHeaderData = setupHeaderData;
            this.modes = modes;
            this.iLogModes = iLogModes;
        }
    }
}
