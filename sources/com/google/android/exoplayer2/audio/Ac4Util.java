package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import kotlin.KotlinVersion;
import org.pjsip.pjsua2.pjsip_status_code;

/* loaded from: classes2.dex */
public final class Ac4Util {
    private static final int[] SAMPLE_COUNT = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, pjsip_status_code.PJSIP_SC_TEMPORARILY_UNAVAILABLE, 400, 400, 2048};

    public static final class SyncFrameInfo {
        public final int bitstreamVersion;
        public final int channelCount;
        public final int frameSize;
        public final int sampleCount;
        public final int sampleRate;

        private SyncFrameInfo(int bitstreamVersion, int channelCount, int sampleRate, int frameSize, int sampleCount) {
            this.bitstreamVersion = bitstreamVersion;
            this.channelCount = channelCount;
            this.sampleRate = sampleRate;
            this.frameSize = frameSize;
            this.sampleCount = sampleCount;
        }
    }

    public static Format parseAc4AnnexEFormat(ParsableByteArray data, String trackId, String language, DrmInitData drmInitData) {
        data.skipBytes(1);
        return new Format.Builder().setId(trackId).setSampleMimeType("audio/ac4").setChannelCount(2).setSampleRate(((data.readUnsignedByte() & 32) >> 5) == 1 ? 48000 : 44100).setDrmInitData(drmInitData).setLanguage(language).build();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.exoplayer2.audio.Ac4Util.SyncFrameInfo parseAc4SyncframeInfo(com.google.android.exoplayer2.util.ParsableBitArray r11) {
        /*
            r0 = 16
            int r1 = r11.readBits(r0)
            int r0 = r11.readBits(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L18
            r0 = 24
            int r0 = r11.readBits(r0)
            r2 = 7
            goto L19
        L18:
            r2 = r3
        L19:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L21
            int r0 = r0 + 2
        L21:
            r8 = r0
            r0 = 2
            int r1 = r11.readBits(r0)
            r2 = 3
            if (r1 != r2) goto L2f
            int r4 = readVariableBits(r11, r0)
            int r1 = r1 + r4
        L2f:
            r5 = r1
            r1 = 10
            int r1 = r11.readBits(r1)
            boolean r4 = r11.readBit()
            if (r4 == 0) goto L45
            int r4 = r11.readBits(r2)
            if (r4 <= 0) goto L45
            r11.skipBits(r0)
        L45:
            boolean r4 = r11.readBit()
            r6 = 44100(0xac44, float:6.1797E-41)
            r7 = 48000(0xbb80, float:6.7262E-41)
            if (r4 == 0) goto L53
            r9 = r7
            goto L54
        L53:
            r9 = r6
        L54:
            int r11 = r11.readBits(r3)
            if (r9 != r6) goto L63
            r4 = 13
            if (r11 != r4) goto L63
            int[] r0 = com.google.android.exoplayer2.audio.Ac4Util.SAMPLE_COUNT
            r11 = r0[r11]
            goto L91
        L63:
            if (r9 != r7) goto L90
            int[] r4 = com.google.android.exoplayer2.audio.Ac4Util.SAMPLE_COUNT
            int r6 = r4.length
            if (r11 >= r6) goto L90
            r4 = r4[r11]
            int r1 = r1 % 5
            r6 = 8
            r7 = 1
            if (r1 == r7) goto L8b
            r7 = 11
            if (r1 == r0) goto L86
            if (r1 == r2) goto L8b
            if (r1 == r3) goto L7c
            goto L84
        L7c:
            if (r11 == r2) goto L82
            if (r11 == r6) goto L82
            if (r11 != r7) goto L84
        L82:
            int r4 = r4 + 1
        L84:
            r11 = r4
            goto L91
        L86:
            if (r11 == r6) goto L82
            if (r11 != r7) goto L84
            goto L82
        L8b:
            if (r11 == r2) goto L82
            if (r11 != r6) goto L84
            goto L82
        L90:
            r11 = 0
        L91:
            com.google.android.exoplayer2.audio.Ac4Util$SyncFrameInfo r0 = new com.google.android.exoplayer2.audio.Ac4Util$SyncFrameInfo
            r6 = 2
            r10 = 0
            r4 = r0
            r7 = r9
            r9 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.Ac4Util.parseAc4SyncframeInfo(com.google.android.exoplayer2.util.ParsableBitArray):com.google.android.exoplayer2.audio.Ac4Util$SyncFrameInfo");
    }

    public static int parseAc4SyncframeSize(byte[] data, int syncword) {
        int i = 7;
        if (data.length < 7) {
            return -1;
        }
        int i2 = ((data[2] & 255) << 8) | (data[3] & 255);
        if (i2 == 65535) {
            i2 = ((data[4] & 255) << 16) | ((data[5] & 255) << 8) | (data[6] & 255);
        } else {
            i = 4;
        }
        if (syncword == 44097) {
            i += 2;
        }
        return i2 + i;
    }

    public static int parseAc4SyncframeAudioSampleCount(ByteBuffer buffer) {
        byte[] bArr = new byte[16];
        int iPosition = buffer.position();
        buffer.get(bArr);
        buffer.position(iPosition);
        return parseAc4SyncframeInfo(new ParsableBitArray(bArr)).sampleCount;
    }

    public static void getAc4SampleHeader(int size, ParsableByteArray buffer) {
        buffer.reset(7);
        byte[] bArr = buffer.data;
        bArr[0] = -84;
        bArr[1] = 64;
        bArr[2] = -1;
        bArr[3] = -1;
        bArr[4] = (byte) ((size >> 16) & KotlinVersion.MAX_COMPONENT_VALUE);
        bArr[5] = (byte) ((size >> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
        bArr[6] = (byte) (size & KotlinVersion.MAX_COMPONENT_VALUE);
    }

    private static int readVariableBits(ParsableBitArray data, int bitsPerRead) {
        int i = 0;
        while (true) {
            int bits = i + data.readBits(bitsPerRead);
            if (!data.readBit()) {
                return bits;
            }
            i = (bits + 1) << bitsPerRead;
        }
    }
}
